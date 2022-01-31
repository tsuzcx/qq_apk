package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;

final class SnsTransparentUI$2
  implements DialogInterface.OnDismissListener
{
  SnsTransparentUI$2(SnsTransparentUI paramSnsTransparentUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    ad.ee(this.pif);
    this.pif.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.2
 * JD-Core Version:    0.7.0.1
 */