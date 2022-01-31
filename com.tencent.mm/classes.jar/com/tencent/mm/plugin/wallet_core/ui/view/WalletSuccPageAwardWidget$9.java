package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import b.a.a.c;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletSuccPageAwardWidget$9
  implements i
{
  WalletSuccPageAwardWidget$9(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img_whole finish, url: %s, bitmap: %s", new Object[] { paramString, paramBitmap });
    if ((paramBitmap != null) && (WalletSuccPageAwardWidget.j(this.qJe) != null) && (!bk.bl(WalletSuccPageAwardWidget.j(this.qJe).xpr)) && (WalletSuccPageAwardWidget.j(this.qJe).xpr.equals(paramString))) {
      ai.d(new WalletSuccPageAwardWidget.9.1(this, paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.9
 * JD-Core Version:    0.7.0.1
 */