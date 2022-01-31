package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.base.preference.Preference;

final class NormalUserFooterPreference$i$2
  implements DialogInterface.OnCancelListener
{
  NormalUserFooterPreference$i$2(NormalUserFooterPreference.i parami) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.mYV.onStop();
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("Intro_Switch", true).addFlags(67108864);
    a.eUR.q(paramDialogInterface, this.mYV.mYC.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i.2
 * JD-Core Version:    0.7.0.1
 */