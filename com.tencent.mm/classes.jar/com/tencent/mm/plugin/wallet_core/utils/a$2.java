package com.tencent.mm.plugin.wallet_core.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$2
  implements Runnable
{
  a$2(a parama, a.b paramb, ImageView paramImageView, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(47985);
    Bankcard localBankcard = this.uxW.tOQ;
    String str = (String)this.lHj.getTag(2131820690);
    if ((!bo.isNullOrNil(str)) && (((!r.ZB()) && (str.equals(localBankcard.field_bankcardType))) || ((r.ZB()) && (str.equals(localBankcard.field_bankName)))))
    {
      this.lHj.setImageBitmap(this.uxX);
      AppMethodBeat.o(47985);
      return;
    }
    ab.d("MicroMsg.BankcardLogoHelper", "not match tag: %s, banktype: %s, iv: %s", new Object[] { str, localBankcard.field_bankcardType, this.lHj });
    AppMethodBeat.o(47985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a.2
 * JD-Core Version:    0.7.0.1
 */