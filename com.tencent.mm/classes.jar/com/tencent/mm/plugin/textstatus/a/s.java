package com.tencent.mm.plugin.textstatus.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.k.a;
import com.tencent.mm.plugin.textstatus.k.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/api/TextStatusSetter;", "", "()V", "isJumpPick", "", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setTextStatus", "context", "Landroid/content/Context;", "setTextStatusForResult", "activity", "Landroid/app/Activity;", "requestCode", "", "plugin-textstatus_release"})
public final class s
{
  public static final s MzQ;
  
  static
  {
    AppMethodBeat.i(238915);
    MzQ = new s();
    AppMethodBeat.o(238915);
  }
  
  public static boolean a(Context paramContext, q paramq)
  {
    AppMethodBeat.i(238910);
    if (paramContext == null)
    {
      Log.e("MicroMsg.TextStatus.StatusThirdShare", "setTextStatus context == null");
      AppMethodBeat.o(238910);
      return false;
    }
    c.gnz().gnx();
    if ((paramq == null) || (a(paramq)))
    {
      localObject = new Bundle();
      if (paramq != null) {
        ((Bundle)localObject).putByteArray("SET_TEXT_PARAMS", paramq.toByteArray());
      }
      paramq = TextStatusDoWhatActivity.MKZ;
      TextStatusDoWhatActivity.a.a(paramContext, (Bundle)localObject, null);
      AppMethodBeat.o(238910);
      return true;
    }
    Object localObject = TextStatusEditActivity.MMp;
    TextStatusEditActivity.a.a(paramContext, paramq, false);
    AppMethodBeat.o(238910);
    return true;
  }
  
  public static boolean a(q paramq)
  {
    AppMethodBeat.i(238912);
    if (paramq.MEI == 1)
    {
      AppMethodBeat.o(238912);
      return false;
    }
    paramq = paramq.MEA;
    if (paramq != null)
    {
      paramq = paramq.topicInfo;
      if (paramq == null) {}
    }
    for (paramq = paramq.iconId; (TextUtils.isEmpty((CharSequence)paramq)) || (!c.gnz().beI(paramq)); paramq = null)
    {
      AppMethodBeat.o(238912);
      return true;
    }
    AppMethodBeat.o(238912);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.s
 * JD-Core Version:    0.7.0.1
 */