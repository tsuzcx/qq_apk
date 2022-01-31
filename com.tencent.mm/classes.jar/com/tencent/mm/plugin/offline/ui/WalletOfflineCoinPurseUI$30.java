package com.tencent.mm.plugin.offline.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.List;

final class WalletOfflineCoinPurseUI$30
  implements n.c
{
  WalletOfflineCoinPurseUI$30(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, List paramList, d paramd) {}
  
  public final void a(l paraml)
  {
    int i = 0;
    Bankcard localBankcard;
    Object localObject1;
    Object localObject2;
    Bitmap localBitmap;
    if (i < this.llc.size())
    {
      localBankcard = (Bankcard)this.llc.get(i);
      localObject1 = com.tencent.mm.plugin.offline.c.a.Kv(localBankcard.field_bankcardType);
      localObject2 = localObject1;
      if (localBankcard.bUR())
      {
        localObject2 = localObject1;
        if (localBankcard.qtH != null) {
          localObject2 = localBankcard.qtH.mEi;
        }
      }
      localBitmap = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject2));
      x.a(new WalletOfflineCoinPurseUI.30.1(this, (String)localObject2, paraml));
      localObject1 = "";
      if (!bk.bl(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      if ((!bk.bl((String)localObject1)) || (localBankcard.field_support_micropay)) {
        break label609;
      }
      if (bk.bl(localBankcard.field_no_micro_word)) {
        localObject1 = "";
      }
    }
    label156:
    label182:
    label596:
    label603:
    label609:
    for (;;)
    {
      SpannableString localSpannableString;
      Object localObject3;
      String str;
      if (bk.bl(localBankcard.field_forbid_title))
      {
        localSpannableString = new SpannableString((CharSequence)localObject1);
        localObject3 = localObject1;
        if (((!localBankcard.bUQ()) && (!localBankcard.bUR())) || (localBankcard.qty < 0.0D)) {
          break label533;
        }
        str = localBankcard.field_desc + this.mNj.getString(a.i.wallet_balance_left, new Object[] { com.tencent.mm.wallet_core.ui.e.B(localBankcard.qty) });
        if (!localBankcard.bUU()) {
          break label543;
        }
        localObject1 = com.tencent.mm.svg.a.a.e(this.mNj.getResources(), a.h.honey_pay_bank_logo);
      }
      for (;;)
      {
        if (localObject1 == null) {
          WalletOfflineCoinPurseUI.L(this.mNj).put(localObject2, Integer.valueOf(i));
        }
        y.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localSpannableString });
        localObject2 = j.b(this.mNj.mController.uMN, str);
        if (localObject1 == null)
        {
          localObject1 = null;
          label354:
          if (!bk.bl((String)localObject3)) {
            break label596;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          paraml.a(i, (CharSequence)localObject2, localSpannableString, (Drawable)localObject1, bool);
          i += 1;
          break;
          localObject1 = localBankcard.field_no_micro_word;
          break label156;
          localObject3 = (String)localObject1 + " ";
          localSpannableString = new SpannableString((String)localObject3 + localBankcard.field_forbid_title);
          localObject1 = new WalletOfflineCoinPurseUI.30.2(this, this.mNj, localBankcard);
          int j = ((String)localObject3).length();
          int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
          localSpannableString.setSpan(new ForegroundColorSpan(this.mNj.getResources().getColor(a.c.wallet_offline_link_color)), j, k, 33);
          localSpannableString.setSpan(localObject1, j, k, 33);
          break label182;
          str = localBankcard.field_desc;
          break label256;
          if (localBitmap == null) {
            break label603;
          }
          localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.a(localBitmap, this.mNj.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.mNj.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false));
          break label279;
          break label354;
        }
        return;
        localObject1 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.30
 * JD-Core Version:    0.7.0.1
 */