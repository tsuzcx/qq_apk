package com.tencent.mm.plugin.textstatus.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.q;
import com.tencent.mm.plugin.textstatus.a.s;
import com.tencent.mm.plugin.textstatus.b.a;
import com.tencent.mm.plugin.textstatus.j.d;
import com.tencent.mm.plugin.textstatus.k.a;
import com.tencent.mm.plugin.textstatus.k.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusPreviewFinderActivity;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/StatusThirdShare;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShare;", "()V", "getThirdService", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "jumpType", "", "goTextStatusPreviewFinderUIForResult", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "printEnterParam", "statusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "registerThirdService", "service", "setTextStatus", "", "context", "Landroid/content/Context;", "setTextStatusForResult", "unregisterThirdService", "preprocess", "Companion", "plugin-textstatus_release"})
public final class m
  implements com.tencent.mm.plugin.textstatus.a.l
{
  public static final m.a MDx;
  
  static
  {
    AppMethodBeat.i(237101);
    MDx = new m.a((byte)0);
    AppMethodBeat.o(237101);
  }
  
  private static void b(q paramq)
  {
    Object localObject2 = null;
    AppMethodBeat.i(237090);
    StringBuilder localStringBuilder = new StringBuilder("[enterParam] sid:");
    if (paramq != null)
    {
      localObject1 = paramq.MEA;
      if (localObject1 != null)
      {
        localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
        if (localObject1 != null)
        {
          localObject1 = ((TextStatusTopicInfo)localObject1).sourceId;
          localStringBuilder = localStringBuilder.append((String)localObject1).append(" vinfo:");
          if (paramq == null) {
            break label166;
          }
          localObject1 = paramq.MEA;
          if (localObject1 == null) {
            break label166;
          }
          localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
          if (localObject1 == null) {
            break label166;
          }
          localObject1 = ((TextStatusTopicInfo)localObject1).verifyInfo;
          label82:
          localStringBuilder = localStringBuilder.append((String)localObject1).append(" iconId:");
          if (paramq == null) {
            break label171;
          }
          localObject1 = paramq.MEA;
          if (localObject1 == null) {
            break label171;
          }
          localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
          if (localObject1 == null) {
            break label171;
          }
        }
      }
    }
    label166:
    label171:
    for (Object localObject1 = ((TextStatusTopicInfo)localObject1).iconId;; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append((String)localObject1).append(" mPath:");
      localObject1 = localObject2;
      if (paramq != null) {
        localObject1 = paramq.mediaPath;
      }
      Log.i("MicroMsg.TextStatus.StatusThirdShare", (String)localObject1);
      AppMethodBeat.o(237090);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label82;
    }
  }
  
  private static void c(q paramq)
  {
    AppMethodBeat.i(237099);
    if (paramq.MEC == 0L) {
      paramq.MEC = 5L;
    }
    paramq = paramq.MEA;
    Object localObject;
    if (paramq != null)
    {
      paramq = paramq.topicInfo;
      if (paramq != null)
      {
        localObject = (CharSequence)paramq.sourceId;
        if ((localObject != null) && (!n.ba((CharSequence)localObject))) {
          break label146;
        }
      }
    }
    label146:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramq.jumpInfos == null) {
          paramq.jumpInfos = new LinkedList();
        }
        if (paramq.jumpInfos.size() == 0)
        {
          Log.i("MicroMsg.TextStatus.StatusThirdShare", "preprocess jumpinfos size err null,protect");
          paramq.jumpInfos = new LinkedList();
          paramq = paramq.jumpInfos;
          localObject = new TextStatusJumpInfo();
          ((TextStatusJumpInfo)localObject).jumpType = "0";
          paramq.add(localObject);
        }
      }
      AppMethodBeat.o(237099);
      return;
      paramq = null;
      break;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.textstatus.a.m paramm)
  {
    AppMethodBeat.i(237093);
    d locald = d.MIW;
    d.b(paramString, paramm);
    AppMethodBeat.o(237093);
  }
  
  public final boolean a(Activity paramActivity, int paramInt, q paramq)
  {
    AppMethodBeat.i(237088);
    if (paramActivity == null)
    {
      AppMethodBeat.o(237088);
      return false;
    }
    b(paramq);
    if (paramq != null) {
      c(paramq);
    }
    Object localObject = s.MzQ;
    if (paramActivity != null)
    {
      c.gnz().gnx();
      if ((paramq == null) || (s.a(paramq)))
      {
        localObject = new Bundle();
        if (paramq != null) {
          ((Bundle)localObject).putByteArray("SET_TEXT_PARAMS", paramq.toByteArray());
        }
        paramq = TextStatusDoWhatActivity.MKZ;
        TextStatusDoWhatActivity.a.a((Context)paramActivity, (Bundle)localObject, Integer.valueOf(paramInt));
      }
    }
    else
    {
      AppMethodBeat.o(237088);
      return true;
    }
    localObject = TextStatusEditActivity.MMp;
    p.k(paramActivity, "context");
    localObject = new Intent((Context)paramActivity, TextStatusEditActivity.class);
    if (paramq != null) {}
    for (paramq = paramq.toByteArray();; paramq = null)
    {
      ((Intent)localObject).putExtra("SET_TEXT_PARAMS", paramq);
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      if (paramActivity == null) {
        break;
      }
      paramActivity.overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
      break;
    }
  }
  
  public final boolean a(Context paramContext, q paramq)
  {
    AppMethodBeat.i(237092);
    if (paramContext == null)
    {
      Log.e("MicroMsg.TextStatus.StatusThirdShare", "setTextStatus context == null");
      AppMethodBeat.o(237092);
      return false;
    }
    b(paramq);
    if (paramq != null) {
      c(paramq);
    }
    s locals = s.MzQ;
    s.a(paramContext, paramq);
    AppMethodBeat.o(237092);
    return true;
  }
  
  public final void beb(String paramString)
  {
    AppMethodBeat.i(237095);
    Object localObject = d.MIW;
    localObject = d.beD(paramString);
    if (localObject != null) {
      ((com.tencent.mm.plugin.textstatus.a.m)localObject).release();
    }
    d.MIV.remove(paramString);
    AppMethodBeat.o(237095);
  }
  
  public final void m(Activity paramActivity, Intent paramIntent)
  {
    AppMethodBeat.i(237097);
    p.k(paramActivity, "activity");
    p.k(paramIntent, "intent");
    paramIntent.setClass((Context)paramActivity, TextStatusPreviewFinderActivity.class);
    paramActivity.startActivityForResult(paramIntent, 10001);
    AppMethodBeat.o(237097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.m
 * JD-Core Version:    0.7.0.1
 */