package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletSuccPageAwardWidget$8
  implements com.tencent.mm.at.a.c.i
{
  WalletSuccPageAwardWidget$8(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(47950);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "load background_img finish, url: %s, bitmap: %s", new Object[] { paramString, paramBitmap });
    if ((paramBitmap != null) && (WalletSuccPageAwardWidget.h(this.uxM) != null) && (!bo.isNullOrNil(WalletSuccPageAwardWidget.h(this.uxM).CLV)) && (WalletSuccPageAwardWidget.h(this.uxM).CLV.equals(paramString)))
    {
      paramString = new NinePatch(paramBitmap, WalletSuccPageAwardWidget.ac(paramBitmap), "widget_bg");
      al.d(new WalletSuccPageAwardWidget.8.1(this, new NinePatchDrawable(this.uxM.getResources(), paramString)));
    }
    AppMethodBeat.o(47950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.8
 * JD-Core Version:    0.7.0.1
 */