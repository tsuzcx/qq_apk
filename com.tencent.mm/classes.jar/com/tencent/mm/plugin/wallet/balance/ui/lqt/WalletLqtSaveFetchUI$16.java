package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.balance.a.a.i;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.List;

final class WalletLqtSaveFetchUI$16
  implements n.c
{
  WalletLqtSaveFetchUI$16(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, d paramd) {}
  
  public final void a(l paraml)
  {
    int j = WalletLqtSaveFetchUI.f(this.qiZ).size();
    int i = 0;
    Bankcard localBankcard;
    Object localObject1;
    if (i < j)
    {
      localBankcard = (Bankcard)WalletLqtSaveFetchUI.f(this.qiZ).get(i);
      localObject1 = b.h(this.qiZ, localBankcard.field_bankcardType, localBankcard.bUP());
      if (localObject1 == null) {
        break label713;
      }
    }
    label152:
    label412:
    label578:
    label713:
    for (String str1 = ((e)localObject1).mEi;; str1 = "")
    {
      Bitmap localBitmap = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str1));
      x.a(new WalletLqtSaveFetchUI.16.1(this, str1, paraml));
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
          break label412;
        }
        y.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
        localObject1 = this.qiZ.getResources().getDrawable(a.e.wallet_balance_manager_logo_small);
        if (!bk.bl((String)localObject2)) {
          break label406;
        }
      }
      for (boolean bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject1, bool);
        localObject1 = localObject3;
        if (localObject1 == null) {
          WalletLqtSaveFetchUI.g(this.qiZ).put(str1, Integer.valueOf(i));
        }
        i += 1;
        break;
        localObject2 = (String)localObject1 + " ";
        localSpannableString = new SpannableString((String)localObject2 + localBankcard.field_forbid_title);
        localObject1 = new WalletLqtSaveFetchUI.16.2(this, this.qiZ);
        int k = ((String)localObject2).length();
        int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(this.qiZ.getResources().getColor(a.c.wallet_offline_link_color)), k, m, 33);
        localSpannableString.setSpan(localObject1, k, m, 33);
        break label152;
      }
      localObject1 = localObject4;
      if (localBitmap != null) {
        localObject1 = com.tencent.mm.sdk.platformtools.c.a(localBitmap, this.qiZ.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.qiZ.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
      }
      y.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
      if (localObject1 == null)
      {
        localObject3 = null;
        label492:
        if (!bk.bl((String)localObject2)) {
          break label534;
        }
      }
      for (bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject3, bool);
        break;
        localObject3 = new BitmapDrawable((Bitmap)localObject1);
        break label492;
      }
      localObject1 = i.qfx;
      if (WalletLqtSaveFetchUI.h(this.qiZ) == 1)
      {
        bool = true;
        ((i)localObject1).kn(bool);
        if (!bool) {
          break label609;
        }
        localObject1 = ((i)localObject1).qfr;
        if (localObject1 == null) {
          break label619;
        }
        bool = ((aup)localObject1).tqc;
        label590:
        if (!bool) {
          break label625;
        }
        y.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
      }
      label609:
      label619:
      label625:
      do
      {
        return;
        bool = false;
        break;
        localObject1 = ((i)localObject1).qfs;
        break label578;
        bool = false;
        break label590;
        if (WalletLqtSaveFetchUI.h(this.qiZ) == 1)
        {
          paraml.a(j, this.qiZ.getString(a.i.wallet_lqt_save_new_card), "", this.qiZ.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
          return;
        }
      } while (WalletLqtSaveFetchUI.h(this.qiZ) != 2);
      paraml.a(j, this.qiZ.getString(a.i.wallet_lqt_fetch_new_card), "", this.qiZ.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.16
 * JD-Core Version:    0.7.0.1
 */