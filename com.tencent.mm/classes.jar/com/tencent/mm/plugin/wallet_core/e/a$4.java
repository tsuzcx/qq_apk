package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class a$4
  implements Runnable
{
  a$4(a parama, View paramView, com.tencent.mm.plugin.wallet_core.model.e parame, a.b paramb) {}
  
  public final void run()
  {
    this.qJr.invalidate();
    Object localObject = this.qJq.qtS;
    int i;
    if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png".equals(localObject))
    {
      i = a.e.wallet_bankcard_bule_bg;
      if (i == -1) {
        break label197;
      }
      this.qJr.setBackgroundResource(i);
      localObject = BitmapFactory.decodeResource(this.qJr.getResources(), i);
      i = ((Bitmap)localObject).getPixel(((Bitmap)localObject).getWidth() / 2, ((Bitmap)localObject).getHeight() / 2);
      y.d("MicroMsg.BankcardLogoHelper", "local bg color: %s", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.qJo.qJy.get();
      if (localObject != null) {
        ((TextView)localObject).setTextColor(i);
      }
    }
    label197:
    label350:
    do
    {
      do
      {
        do
        {
          return;
          if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png".equals(localObject))
          {
            i = a.e.wallet_bankcard_green_bg;
            break;
          }
          if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png".equals(localObject))
          {
            i = a.e.wallet_bankcard_hbule_bg;
            break;
          }
          if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png".equals(localObject))
          {
            i = a.e.wallet_bankcard_purple_bg;
            break;
          }
          if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png".equals(localObject))
          {
            i = a.e.wallet_bankcard_red_bg;
            break;
          }
          if ("http://res.wx.qq.com/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png".equals(localObject))
          {
            i = a.e.wallet_bankcard_yellow_bg;
            break;
          }
          i = -1;
          break;
          if (bk.bl(this.qJq.qtS)) {
            break label350;
          }
          c localc = new c(this.qJq.qtS);
          localObject = x.a(localc);
          x.a(this.qJo);
          if (localObject != null) {}
          try
          {
            byte[] arrayOfByte = ((Bitmap)localObject).getNinePatchChunk();
            if ((arrayOfByte == null) || (!NinePatch.isNinePatchChunk(arrayOfByte))) {
              com.tencent.mm.vfs.e.deleteFile(localc.UO());
            }
          }
          catch (Exception localException)
          {
            break label269;
          }
        } while (localObject == null);
        this.qJr.setBackgroundDrawable(b.b(this.qJr.getContext(), (Bitmap)localObject));
        i = ((Bitmap)localObject).getPixel(((Bitmap)localObject).getWidth() / 2, ((Bitmap)localObject).getHeight() / 2);
        localObject = (TextView)this.qJo.qJy.get();
      } while (localObject == null);
      y.d("MicroMsg.BankcardLogoHelper", "server bg color: %s", new Object[] { Integer.valueOf(i) });
      ((TextView)localObject).setTextColor(i);
      return;
    } while (this.qJq.qtW <= 0);
    label269:
    this.qJr.setBackgroundResource(this.qJq.qtW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.a.4
 * JD-Core Version:    0.7.0.1
 */