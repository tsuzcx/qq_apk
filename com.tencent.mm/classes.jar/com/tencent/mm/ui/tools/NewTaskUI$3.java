package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

final class NewTaskUI$3
  implements DialogInterface.OnClickListener
{
  NewTaskUI$3(NewTaskUI paramNewTaskUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(34919);
    ab.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.a(this.AwK).gwj + " img len" + NewTaskUI.a(this.AwK).gwi.length + " " + g.Ml());
    if (NewTaskUI.b(this.AwK) == null)
    {
      ab.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
      AppMethodBeat.o(34919);
      return;
    }
    paramDialogInterface = new s(NewTaskUI.a(this.AwK).gEL, NewTaskUI.b(this.AwK).getSecImgCode(), NewTaskUI.b(this.AwK).getSecImgSid(), NewTaskUI.b(this.AwK).getSecImgEncryptKey());
    aw.Rc().a(paramDialogInterface, 0);
    NewTaskUI localNewTaskUI1 = this.AwK;
    NewTaskUI localNewTaskUI2 = this.AwK;
    this.AwK.getString(2131297087);
    NewTaskUI.a(localNewTaskUI1, h.b(localNewTaskUI2, this.AwK.getString(2131301149), true, new NewTaskUI.3.1(this, paramDialogInterface)));
    AppMethodBeat.o(34919);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.NewTaskUI.3
 * JD-Core Version:    0.7.0.1
 */