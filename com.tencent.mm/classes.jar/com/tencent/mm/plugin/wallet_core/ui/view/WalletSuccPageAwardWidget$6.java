package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import b.a.a.g;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletSuccPageAwardWidget$6
  implements i
{
  WalletSuccPageAwardWidget$6(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramString, paramBitmap });
    if ((paramBitmap != null) && (WalletSuccPageAwardWidget.h(this.qJe) != null) && (!bk.bl(WalletSuccPageAwardWidget.h(this.qJe).xpE)) && (WalletSuccPageAwardWidget.h(this.qJe).xpE.equals(paramString)))
    {
      paramString = new NinePatch(paramBitmap, WalletSuccPageAwardWidget.O(paramBitmap), "widget_bg");
      ai.d(new WalletSuccPageAwardWidget.6.1(this, new NinePatchDrawable(this.qJe.getResources(), paramString)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.6
 * JD-Core Version:    0.7.0.1
 */