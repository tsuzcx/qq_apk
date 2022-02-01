package com.tencent.mm.plugin.textstatus.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusDoWhatActivity.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusTransparentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/api/TextStatusSetter;", "", "()V", "setTextStatus", "", "context", "Landroid/content/Context;", "setStatusParamIn", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "callback", "Landroid/os/ResultReceiver;", "setTextStatusForResult", "activity", "Landroid/app/Activity;", "requestCode", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa ThY;
  
  static
  {
    AppMethodBeat.i(289886);
    ThY = new aa();
    AppMethodBeat.o(289886);
  }
  
  public static boolean a(Activity paramActivity, w paramw, int paramInt)
  {
    AppMethodBeat.i(289844);
    if (paramActivity == null)
    {
      AppMethodBeat.o(289844);
      return false;
    }
    Object localObject = paramw;
    if (paramw == null) {
      localObject = new w.a().ThS;
    }
    s.s(localObject, "setStatusParam");
    ab.a((w)localObject);
    if (ac.hFS())
    {
      paramw = com.tencent.mm.plugin.expansions.b.yFu;
      if (com.tencent.mm.plugin.expansions.b.isInstalled("xlab")) {}
    }
    else
    {
      paramw = TextStatusTransparentActivity.TAv;
      s.u(paramActivity, "activity");
      s.u(localObject, "setStatusParam");
      paramw = new Intent((Context)paramActivity, TextStatusTransparentActivity.class);
      paramw.putExtra("SET_TEXT_PARAMS", ((w)localObject).toByteArray());
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramw).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusTransparentActivity$Companion", "startForResult", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(289844);
      return false;
    }
    com.tencent.mm.plugin.textstatus.util.a.a(com.tencent.mm.plugin.textstatus.util.b.hKh());
    if (ab.b((w)localObject))
    {
      paramw = new Bundle();
      paramw.putByteArray("SET_TEXT_PARAMS", ((w)localObject).toByteArray());
      localObject = TextStatusDoWhatActivity.Txk;
      TextStatusDoWhatActivity.a.a((Context)paramActivity, paramw, Integer.valueOf(paramInt));
      AppMethodBeat.o(289844);
      return true;
    }
    paramw = TextStatusEditActivity.Txz;
    s.u(paramActivity, "context");
    Intent localIntent = new Intent((Context)paramActivity, TextStatusEditActivity.class);
    if (localObject == null) {}
    for (paramw = null;; paramw = ((w)localObject).toByteArray())
    {
      localIntent.putExtra("SET_TEXT_PARAMS", paramw);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "startForResult", "(Landroid/app/Activity;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      if (paramActivity != null) {
        paramActivity.overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
      }
      AppMethodBeat.o(289844);
      return true;
    }
  }
  
  public static boolean b(Context paramContext, w paramw, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(289863);
    if (paramContext == null)
    {
      Log.e("MicroMsg.TextStatus.StatusThirdShare", "setTextStatus context == null");
      AppMethodBeat.o(289863);
      return false;
    }
    w localw = paramw;
    if (paramw == null) {
      localw = new w.a().ThS;
    }
    s.s(localw, "setStatusParam");
    ab.a(localw);
    if (ac.hFS())
    {
      paramw = com.tencent.mm.plugin.expansions.b.yFu;
      if (com.tencent.mm.plugin.expansions.b.isInstalled("xlab")) {}
    }
    else
    {
      paramw = TextStatusTransparentActivity.TAv;
      s.u(paramContext, "context");
      s.u(localw, "setStatusParam");
      paramw = new Intent(paramContext, TextStatusTransparentActivity.class);
      if (!(paramContext instanceof Activity)) {
        paramw.addFlags(268435456);
      }
      paramw.putExtra("SET_TEXT_PARAMS", localw.toByteArray());
      paramw.putExtra("CALLBACK", (Parcelable)paramResultReceiver);
      paramw = new com.tencent.mm.hellhoundlib.b.a().cG(paramw);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramw.aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusTransparentActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;Landroid/os/ResultReceiver;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramw.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusTransparentActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;Landroid/os/ResultReceiver;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if ((paramContext instanceof Activity)) {}
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        if (paramContext != null) {
          paramContext.overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(289863);
        return false;
      }
    }
    com.tencent.mm.plugin.textstatus.util.a.a(com.tencent.mm.plugin.textstatus.util.b.hKh());
    if (ab.b(localw))
    {
      paramw = new Bundle();
      paramw.putByteArray("SET_TEXT_PARAMS", localw.toByteArray());
      paramw.putParcelable("CALLBACK", (Parcelable)paramResultReceiver);
      paramResultReceiver = TextStatusDoWhatActivity.Txk;
      TextStatusDoWhatActivity.a.a(paramContext, paramw, null);
      AppMethodBeat.o(289863);
      return true;
    }
    paramw = TextStatusEditActivity.Txz;
    TextStatusEditActivity.a.a(paramContext, localw, false, paramResultReceiver);
    AppMethodBeat.o(289863);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.aa
 * JD-Core Version:    0.7.0.1
 */