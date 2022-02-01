package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FacingCreateChatRoomAllInOneUI$18
  implements DialogInterface.OnClickListener
{
  FacingCreateChatRoomAllInOneUI$18(FacingCreateChatRoomAllInOneUI paramFacingCreateChatRoomAllInOneUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27642);
    paramDialogInterface = this.xoM;
    Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.xoM.finish();
    AppMethodBeat.o(27642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.18
 * JD-Core Version:    0.7.0.1
 */