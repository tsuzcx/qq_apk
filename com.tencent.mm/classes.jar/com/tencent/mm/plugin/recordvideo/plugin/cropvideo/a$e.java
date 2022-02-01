package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.e.g;
import com.tencent.mm.plugin.recordvideo.e.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
final class a$e
  implements DialogInterface.OnClickListener
{
  a$e(a parama, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(237355);
    if (a.j(this.BSH) != null)
    {
      paramDialogInterface = a.j(this.BSH);
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new t("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(237355);
        throw paramDialogInterface;
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.j(this.BSH);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        Log.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
      }
    }
    Log.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstall:" + this.BSI);
    paramDialogInterface = a.i(this.BSH);
    label151:
    int k;
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.iqd;
      if (paramDialogInterface == null) {
        break label376;
      }
      localObject2 = a.i(this.BSH);
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject2 != null) {
        paramDialogInterface = ((b)localObject2).iqd;
      }
      if (!this.BSI) {
        break label475;
      }
      localObject1 = h.Cix;
      if (paramDialogInterface == null) {
        p.hyc();
      }
      localObject1 = g.Ciw;
      k = g.eMQ();
      localObject1 = a.k(this.BSH);
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((RecordConfigProvider)localObject1).BOm;
      if (localObject1 == null) {
        break label402;
      }
      paramInt = ((VideoTransPara)localObject1).videoBitrate;
      label215:
      localObject1 = a.k(this.BSH);
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((RecordConfigProvider)localObject1).BOm;
      if (localObject1 == null) {
        break label407;
      }
    }
    label402:
    label407:
    for (int i = ((VideoTransPara)localObject1).width;; i = 0)
    {
      localObject1 = a.k(this.BSH);
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((RecordConfigProvider)localObject1).BOm;
      if (localObject1 != null) {
        j = ((VideoTransPara)localObject1).height;
      }
      paramDialogInterface = h.b("moments", paramDialogInterface, k, paramInt, i, j);
      localObject1 = h.Cix;
      localObject1 = this.BSH.parent.getContext();
      p.g(localObject1, "parent.context");
      h.ao((Context)localObject1, paramDialogInterface);
      paramDialogInterface = new Intent();
      localObject1 = this.BSH.parent.getContext();
      if (localObject1 != null) {
        break label412;
      }
      paramDialogInterface = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(237355);
      throw paramDialogInterface;
      paramDialogInterface = null;
      break;
      label376:
      localObject2 = a.i(this.BSH);
      paramDialogInterface = (DialogInterface)localObject1;
      if (localObject2 == null) {
        break label151;
      }
      paramDialogInterface = ((b)localObject2).iqh;
      break label151;
      paramInt = 0;
      break label215;
    }
    label412:
    ((Activity)localObject1).setResult(-2, paramDialogInterface);
    paramDialogInterface = this.BSH.parent.getContext();
    if (paramDialogInterface == null)
    {
      paramDialogInterface = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(237355);
      throw paramDialogInterface;
    }
    ((Activity)paramDialogInterface).finish();
    Log.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
    AppMethodBeat.o(237355);
    return;
    label475:
    paramDialogInterface = com.tencent.mm.plugin.recordvideo.e.a.ChV;
    paramDialogInterface = this.BSH.parent.getContext();
    p.g(paramDialogInterface, "parent.context");
    localObject1 = new StringBuilder();
    Object localObject2 = g.Ciw;
    com.tencent.mm.plugin.recordvideo.e.a.bt(paramDialogInterface, g.eMR() + "moments1");
    AppMethodBeat.o(237355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.e
 * JD-Core Version:    0.7.0.1
 */