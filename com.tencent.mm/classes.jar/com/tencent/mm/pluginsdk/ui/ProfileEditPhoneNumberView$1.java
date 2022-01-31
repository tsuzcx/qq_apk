package com.tencent.mm.pluginsdk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ProfileEditPhoneNumberView$1
  implements DialogInterface.OnClickListener
{
  ProfileEditPhoneNumberView$1(ProfileEditPhoneNumberView paramProfileEditPhoneNumberView, MMPhoneNumberEditText paramMMPhoneNumberEditText) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.saH.saA = "";
    this.saH.saF.cmv();
    ProfileEditPhoneNumberView.a(this.saH, this.saG);
    if (!ProfileEditPhoneNumberView.a(this.saH)) {
      ProfileEditPhoneNumberView.b(this.saH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.1
 * JD-Core Version:    0.7.0.1
 */