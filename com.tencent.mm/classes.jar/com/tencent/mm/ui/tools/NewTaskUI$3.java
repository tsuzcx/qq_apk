package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class NewTaskUI$3
  implements DialogInterface.OnClickListener
{
  NewTaskUI$3(NewTaskUI paramNewTaskUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(this.wea).feA + " img len" + NewTaskUI.a(this.wea).fez.length + " " + com.tencent.mm.compatible.util.g.zI());
    if (NewTaskUI.b(this.wea) == null)
    {
      y.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
      return;
    }
    paramDialogInterface = new q(NewTaskUI.a(this.wea).fns, NewTaskUI.b(this.wea).getSecImgCode(), NewTaskUI.b(this.wea).getSecImgSid(), NewTaskUI.b(this.wea).getSecImgEncryptKey());
    au.Dk().a(paramDialogInterface, 0);
    NewTaskUI localNewTaskUI1 = this.wea;
    NewTaskUI localNewTaskUI2 = this.wea;
    this.wea.getString(R.l.app_tip);
    NewTaskUI.a(localNewTaskUI1, h.b(localNewTaskUI2, this.wea.getString(R.l.login_logining), true, new NewTaskUI.3.1(this, paramDialogInterface)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI.3
 * JD-Core Version:    0.7.0.1
 */