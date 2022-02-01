package com.tencent.mm.plugin.textstatus.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.textstatus.a.aa;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.a.q;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.a.y;
import com.tencent.mm.plugin.textstatus.a.z;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.third.i;
import com.tencent.mm.plugin.textstatus.third.k;
import com.tencent.mm.plugin.textstatus.ui.TextStatusPreviewFinderActivity;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/StatusThirdShare;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShare;", "()V", "getThirdService", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "jumpType", "", "goTextStatusPreviewFinderUIForResult", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "jsApiSetTextStatus", "", "context", "Landroid/content/Context;", "statusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "callback", "Landroid/os/ResultReceiver;", "printEnterParam", "registerThirdService", "service", "setTextStatus", "setTextStatusForResult", "setTextStatusInner", "setTextStatusWithSignature", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusActionTask;", "param", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionParam;", "_callback", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusActionCallback;", "unregisterThirdService", "preprocess", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements com.tencent.mm.plugin.textstatus.a.n
{
  public static final n.a TmZ;
  
  static
  {
    AppMethodBeat.i(290564);
    TmZ = new n.a((byte)0);
    AppMethodBeat.o(290564);
  }
  
  private static void c(w paramw)
  {
    Object localObject2 = null;
    AppMethodBeat.i(290522);
    StringBuilder localStringBuilder = new StringBuilder("[enterParam] sid:");
    Object localObject1;
    if (paramw == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(" vinfo:");
      if (paramw != null) {
        break label146;
      }
      localObject1 = null;
      label40:
      localStringBuilder = localStringBuilder.append(localObject1).append(" iconId:");
      if (paramw != null) {
        break label182;
      }
      localObject1 = null;
      label57:
      localStringBuilder = localStringBuilder.append(localObject1).append(" mType:");
      if (paramw != null) {
        break label218;
      }
      localObject1 = null;
      label74:
      localObject1 = localStringBuilder.append(localObject1).append(" mPath:");
      if (paramw != null) {
        break label243;
      }
    }
    label146:
    label182:
    label218:
    label243:
    for (paramw = localObject2;; paramw = paramw.mediaPath)
    {
      Log.i("MicroMsg.TextStatus.StatusThirdShare", paramw);
      AppMethodBeat.o(290522);
      return;
      localObject1 = paramw.Tog;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((TextStatusTopicInfo)localObject1).sourceId;
      break;
      localObject1 = paramw.Tog;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label40;
      }
      localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label40;
      }
      localObject1 = ((TextStatusTopicInfo)localObject1).verifyInfo;
      break label40;
      localObject1 = paramw.Tog;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label57;
      }
      localObject1 = ((TextStatusExtInfo)localObject1).topicInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label57;
      }
      localObject1 = ((TextStatusTopicInfo)localObject1).iconId;
      break label57;
      localObject1 = paramw.Tog;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label74;
      }
      localObject1 = Integer.valueOf(((TextStatusExtInfo)localObject1).mediaType);
      break label74;
    }
  }
  
  private static boolean c(Context paramContext, w paramw, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(290537);
    if (paramContext == null)
    {
      Log.e("MicroMsg.TextStatus.StatusThirdShare", "setTextStatus context == null");
      AppMethodBeat.o(290537);
      return false;
    }
    c(paramw);
    if (paramw != null) {
      d(paramw);
    }
    aa localaa = aa.ThY;
    boolean bool = aa.b(paramContext, paramw, paramResultReceiver);
    AppMethodBeat.o(290537);
    return bool;
  }
  
  private static void d(w paramw)
  {
    AppMethodBeat.i(290552);
    if (paramw.Toi == 0L) {
      paramw.Toi = 5L;
    }
    paramw = paramw.Tog;
    Object localObject;
    if (paramw == null)
    {
      paramw = null;
      if (paramw != null)
      {
        localObject = (CharSequence)paramw.sourceId;
        if ((localObject != null) && (!kotlin.n.n.bp((CharSequence)localObject))) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (paramw.jumpInfos == null) {
          paramw.jumpInfos = new LinkedList();
        }
        if (paramw.jumpInfos.size() == 0)
        {
          Log.i("MicroMsg.TextStatus.StatusThirdShare", "preprocess jumpinfos size err null,protect");
          paramw.jumpInfos = new LinkedList();
          paramw = paramw.jumpInfos;
          localObject = new TextStatusJumpInfo();
          ((TextStatusJumpInfo)localObject).jumpType = "0";
          ah localah = ah.aiuX;
          paramw.add(localObject);
        }
      }
      AppMethodBeat.o(290552);
      return;
      paramw = paramw.topicInfo;
      break;
    }
  }
  
  public final q a(Context paramContext, z paramz, y paramy)
  {
    AppMethodBeat.i(290590);
    k localk = k.TuZ;
    paramContext = k.b(paramContext, paramz, paramy);
    AppMethodBeat.o(290590);
    return paramContext;
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(290626);
    i locali = i.TuX;
    i.b(paramString, paramo);
    AppMethodBeat.o(290626);
  }
  
  public final boolean a(Activity paramActivity, int paramInt, w paramw)
  {
    AppMethodBeat.i(290575);
    if (paramActivity == null)
    {
      AppMethodBeat.o(290575);
      return false;
    }
    c(paramw);
    if (paramw != null) {
      d(paramw);
    }
    aa localaa = aa.ThY;
    aa.a(paramActivity, paramw, paramInt);
    AppMethodBeat.o(290575);
    return true;
  }
  
  public final boolean a(Context paramContext, w paramw)
  {
    AppMethodBeat.i(290600);
    boolean bool = c(paramContext, paramw, null);
    AppMethodBeat.o(290600);
    return bool;
  }
  
  public final boolean a(Context paramContext, w paramw, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(290615);
    boolean bool = c(paramContext, paramw, paramResultReceiver);
    AppMethodBeat.o(290615);
    return bool;
  }
  
  public final void bdp(String paramString)
  {
    AppMethodBeat.i(290632);
    Object localObject = i.TuX;
    localObject = i.bec(paramString);
    if (localObject != null) {
      ((o)localObject).release();
    }
    i.TuY.remove(paramString);
    AppMethodBeat.o(290632);
  }
  
  public final void g(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(290638);
    s.u(paramActivity, "activity");
    s.u(paramIntent, "intent");
    paramIntent.setClass((Context)paramActivity, TextStatusPreviewFinderActivity.class);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/plugin/textstatus/model/StatusThirdShare", "goTextStatusPreviewFinderUIForResult", "(Landroid/app/Activity;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(290638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.n
 * JD-Core Version:    0.7.0.1
 */