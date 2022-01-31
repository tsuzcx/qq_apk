package com.tencent.mm.pluginsdk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ProfileEditPhoneNumberView$1
  implements DialogInterface.OnClickListener
{
  ProfileEditPhoneNumberView$1(ProfileEditPhoneNumberView paramProfileEditPhoneNumberView, MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(27509);
    this.vRy.vRr = "";
    this.vRy.vRw.dnl();
    ProfileEditPhoneNumberView.a(this.vRy, this.vRx);
    if (!ProfileEditPhoneNumberView.a(this.vRy)) {
      ProfileEditPhoneNumberView.b(this.vRy);
    }
    AppMethodBeat.o(27509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.1
 * JD-Core Version:    0.7.0.1
 */