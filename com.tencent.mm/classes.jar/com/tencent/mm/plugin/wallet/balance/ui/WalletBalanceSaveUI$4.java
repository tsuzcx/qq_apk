package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashMap;
import java.util.List;

final class WalletBalanceSaveUI$4
  implements n.c
{
  WalletBalanceSaveUI$4(WalletBalanceSaveUI paramWalletBalanceSaveUI, List paramList, com.tencent.mm.ui.widget.c paramc) {}
  
  public final void a(final l paraml)
  {
    int j = this.llc.size();
    int i = 0;
    Bankcard localBankcard;
    Object localObject1;
    if (i < j)
    {
      localBankcard = (Bankcard)this.llc.get(i);
      localObject1 = b.h(this.qhx, localBankcard.field_bankcardType, localBankcard.bUP());
      if (localObject1 == null) {
        break label567;
      }
    }
    label146:
    label406:
    label567:
    for (final String str1 = ((e)localObject1).mEi;; str1 = "")
    {
      Bitmap localBitmap = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
      x.a(new x.a()
      {
        public final void l(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          ai.d(new WalletBalanceSaveUI.4.1.1(this, paramAnonymousString, paramAnonymousBitmap));
        }
      });
      Object localObject4 = null;
      Object localObject3 = null;
      localObject1 = "";
      if (!bk.bl(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      SpannableString localSpannableString;
      Object localObject2;
      String str2;
      if (bk.bl(localBankcard.field_forbid_title))
      {
        localSpannableString = new SpannableString((CharSequence)localObject1);
        localObject2 = localObject1;
        str2 = localBankcard.field_desc;
        if (!localBankcard.bUQ()) {
          break label406;
        }
        y.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
        localObject1 = this.qhx.getResources().getDrawable(a.e.wallet_balance_manager_logo_small);
        if (!bk.bl((String)localObject2)) {
          break label400;
        }
      }
      for (boolean bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject1, bool);
        localObject1 = localObject3;
        if (localObject1 == null) {
          WalletBalanceSaveUI.d(this.qhx).put(str1, Integer.valueOf(i));
        }
        i += 1;
        break;
        localObject2 = (String)localObject1 + " ";
        localSpannableString = new SpannableString((String)localObject2 + localBankcard.field_forbid_title);
        localObject1 = new WalletBalanceSaveUI.4.2(this, this.qhx);
        int k = ((String)localObject2).length();
        int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(this.qhx.getResources().getColor(a.c.wallet_offline_link_color)), k, m, 33);
        localSpannableString.setSpan(localObject1, k, m, 33);
        break label146;
      }
      localObject1 = localObject4;
      if (localBitmap != null) {
        localObject1 = com.tencent.mm.sdk.platformtools.c.a(localBitmap, this.qhx.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.qhx.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
      }
      y.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
      if (localObject1 == null)
      {
        localObject3 = null;
        label486:
        if (!bk.bl((String)localObject2)) {
          break label528;
        }
      }
      for (bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject3, bool);
        break;
        localObject3 = new BitmapDrawable((Bitmap)localObject1);
        break label486;
      }
      paraml.a(j, this.qhx.getString(a.i.wallet_balance_save_bind_new_card_to_save), "", this.qhx.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.4
 * JD-Core Version:    0.7.0.1
 */