package com.tencent.mm.plugin.wallet_core.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.lang.ref.WeakReference;

final class a$4
  implements Runnable
{
  a$4(a parama, View paramView, g paramg, a.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(47987);
    this.uxZ.invalidate();
    Object localObject = this.uxY.ugn;
    int i;
    if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(localObject)) {
      i = 2130840799;
    }
    while (i != -1)
    {
      this.uxZ.setBackgroundResource(i);
      localObject = BitmapFactory.decodeResource(this.uxZ.getResources(), i);
      i = ((Bitmap)localObject).getPixel(((Bitmap)localObject).getWidth() / 2, ((Bitmap)localObject).getHeight() / 2);
      ab.d("MicroMsg.BankcardLogoHelper", "local bg color: %s", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.uxW.uyg.get();
      if (localObject != null) {
        ((TextView)localObject).setTextColor(i);
      }
      AppMethodBeat.o(47987);
      return;
      if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(localObject)) {
        i = 2130840803;
      } else if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(localObject)) {
        i = 2130840805;
      } else if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(localObject)) {
        i = 2130840810;
      } else if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(localObject)) {
        i = 2130840811;
      } else if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(localObject)) {
        i = 2130840816;
      } else {
        i = -1;
      }
    }
    c localc;
    if (!bo.isNullOrNil(this.uxY.ugn))
    {
      localc = new c(this.uxY.ugn);
      localObject = x.a(localc);
      x.a(this.uxW);
      if (localObject == null) {}
    }
    try
    {
      byte[] arrayOfByte = ((Bitmap)localObject).getNinePatchChunk();
      if ((arrayOfByte == null) || (!NinePatch.isNinePatchChunk(arrayOfByte))) {
        e.deleteFile(localc.aon());
      }
    }
    catch (Exception localException)
    {
      label273:
      break label273;
    }
    if (localObject != null)
    {
      this.uxZ.setBackgroundDrawable(b.b(this.uxZ.getContext(), (Bitmap)localObject));
      i = ((Bitmap)localObject).getPixel(((Bitmap)localObject).getWidth() / 2, ((Bitmap)localObject).getHeight() / 2);
      localObject = (TextView)this.uxW.uyg.get();
      if (localObject != null)
      {
        ab.d("MicroMsg.BankcardLogoHelper", "server bg color: %s", new Object[] { Integer.valueOf(i) });
        ((TextView)localObject).setTextColor(i);
      }
    }
    AppMethodBeat.o(47987);
    return;
    if (this.uxY.ugr > 0) {
      this.uxZ.setBackgroundResource(this.uxY.ugr);
    }
    AppMethodBeat.o(47987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.4
 * JD-Core Version:    0.7.0.1
 */