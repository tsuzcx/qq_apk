package com.tencent.mm.plugin.wallet_core.e;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class a$2
  implements Runnable
{
  a$2(a parama, a.b paramb, ImageView paramImageView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    Bankcard localBankcard = this.qJo.qhv;
    String str = (String)this.jxK.getTag(a.f.wallet_core_bankcard_logo_helper_tag);
    if ((!bk.bl(str)) && (((!q.Gw()) && (str.equals(localBankcard.field_bankcardType))) || ((q.Gw()) && (str.equals(localBankcard.field_bankName)))))
    {
      this.jxK.setImageBitmap(this.qJp);
      return;
    }
    y.d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", new Object[] { str, localBankcard.field_bankcardType, this.jxK });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.a.2
 * JD-Core Version:    0.7.0.1
 */