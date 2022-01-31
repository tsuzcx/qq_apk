package com.tencent.mm.plugin.setting.ui.qrcode;

import android.os.Bundle;
import com.tencent.mm.plugin.account.model.h;

final class ShareToQQUI$5
  extends h
{
  ShareToQQUI$5(ShareToQQUI paramShareToQQUI) {}
  
  public final void l(Bundle paramBundle)
  {
    super.l(paramBundle);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    super.onError(paramInt, paramString);
    if (paramInt == 3) {
      ShareToQQUI.d(this.nRC);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.5
 * JD-Core Version:    0.7.0.1
 */