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
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.e.f;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.a.d;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
final class a$e
  implements DialogInterface.OnClickListener
{
  a$e(a parama, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(75687);
    if (a.b(this.xCB) != null)
    {
      paramDialogInterface = a.b(this.xCB);
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type android.app.Dialog");
        AppMethodBeat.o(75687);
        throw paramDialogInterface;
      }
      if (((Dialog)paramDialogInterface).isShowing())
      {
        paramDialogInterface = a.b(this.xCB);
        if (paramDialogInterface != null) {
          paramDialogInterface.dismiss();
        }
        ad.i("MicroMsg.EditCropVideoPlugin", "click ok dismiss dialog");
      }
    }
    ad.i("MicroMsg.EditCropVideoPlugin", "dialog ok isInstallWeSee:" + this.xCC);
    paramDialogInterface = a.c(this.xCB);
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.htN;
      if (paramDialogInterface == null) {
        break label272;
      }
      paramDialogInterface = a.c(this.xCB);
      if (paramDialogInterface == null) {
        break label267;
      }
      paramDialogInterface = paramDialogInterface.htN;
    }
    for (;;)
    {
      if (this.xCC)
      {
        localObject = f.xRE;
        localObject = this.xCB.gqv.getContext();
        p.g(localObject, "parent.context");
        if (paramDialogInterface == null) {
          p.gfZ();
        }
        p.h(localObject, "context");
        p.h(paramDialogInterface, "videoPath");
        String str = f.yS(cf.aCL());
        q.a((Context)localObject, new Intent(), str, paramDialogInterface);
        paramDialogInterface = c.xHa;
        c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(1));
        paramDialogInterface = new Intent();
        localObject = this.xCB.gqv.getContext();
        if (localObject == null)
        {
          paramDialogInterface = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75687);
          throw paramDialogInterface;
          paramDialogInterface = null;
          break;
          label267:
          paramDialogInterface = null;
          continue;
          label272:
          paramDialogInterface = a.c(this.xCB);
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.htR;
            continue;
          }
          paramDialogInterface = null;
          continue;
        }
        ((Activity)localObject).setResult(-2, paramDialogInterface);
        paramDialogInterface = this.xCB.gqv.getContext();
        if (paramDialogInterface == null)
        {
          paramDialogInterface = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(75687);
          throw paramDialogInterface;
        }
        ((Activity)paramDialogInterface).finish();
        ad.d("MicroMsg.EditCropVideoPlugin", "set RESULT_VIDEO_FINISH");
        AppMethodBeat.o(75687);
        return;
      }
    }
    Object localObject = WeSeeProvider.xwB;
    paramDialogInterface = q.aND(paramDialogInterface);
    p.g(paramDialogInterface, "TakePhotoUtil.parseWeSeeUri(videoPath)");
    WeSeeProvider.a.bd(paramDialogInterface, System.currentTimeMillis());
    paramDialogInterface = f.xRE;
    paramDialogInterface = this.xCB.gqv.getContext();
    p.g(paramDialogInterface, "parent.context");
    f.gb(paramDialogInterface);
    paramDialogInterface = c.xHa;
    c.u("KEY_WESEE_DIALOG_OPERATION", Integer.valueOf(3));
    AppMethodBeat.o(75687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.e
 * JD-Core Version:    0.7.0.1
 */