package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.balance.a.a.p;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashMap;
import java.util.List;

final class WalletLqtSaveFetchUI$2
  implements n.c
{
  WalletLqtSaveFetchUI$2(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, com.tencent.mm.ui.widget.b.d paramd) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(142312);
    int j = WalletLqtSaveFetchUI.k(this.tRZ).size();
    int i = 0;
    Bankcard localBankcard;
    Object localObject1;
    if (i < j)
    {
      localBankcard = (Bankcard)WalletLqtSaveFetchUI.k(this.tRZ).get(i);
      localObject1 = b.h(this.tRZ, localBankcard.field_bankcardType, localBankcard.cTe());
      if (localObject1 == null) {
        break label725;
      }
    }
    label157:
    label415:
    label579:
    label725:
    for (String str1 = ((g)localObject1).pek;; str1 = "")
    {
      Bitmap localBitmap = x.a(new c(str1));
      x.a(new WalletLqtSaveFetchUI.2.1(this, str1, paraml));
      Object localObject4 = null;
      Object localObject3 = null;
      localObject1 = "";
      if (!bo.isNullOrNil(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      SpannableString localSpannableString;
      Object localObject2;
      String str2;
      if (bo.isNullOrNil(localBankcard.field_forbid_title))
      {
        localSpannableString = new SpannableString((CharSequence)localObject1);
        localObject2 = localObject1;
        str2 = localBankcard.field_desc;
        if (!localBankcard.cTf()) {
          break label415;
        }
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
        localObject1 = this.tRZ.getResources().getDrawable(2130840794);
        if (!bo.isNullOrNil((String)localObject2)) {
          break label409;
        }
      }
      for (boolean bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject1, bool);
        localObject1 = localObject3;
        if (localObject1 == null) {
          WalletLqtSaveFetchUI.l(this.tRZ).put(str1, Integer.valueOf(i));
        }
        i += 1;
        break;
        localObject2 = (String)localObject1 + " ";
        localSpannableString = new SpannableString((String)localObject2 + localBankcard.field_forbid_title);
        localObject1 = new WalletLqtSaveFetchUI.2.2(this, this.tRZ);
        int k = ((String)localObject2).length();
        int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(this.tRZ.getResources().getColor(2131690662)), k, m, 33);
        localSpannableString.setSpan(localObject1, k, m, 33);
        break label157;
      }
      localObject1 = localObject4;
      if (localBitmap != null) {
        localObject1 = com.tencent.mm.sdk.platformtools.d.a(localBitmap, this.tRZ.getResources().getDimensionPixelOffset(2131428824), this.tRZ.getResources().getDimensionPixelOffset(2131428824), true, false);
      }
      ab.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
      if (localObject1 == null)
      {
        localObject3 = null;
        label493:
        if (!bo.isNullOrNil((String)localObject2)) {
          break label535;
        }
      }
      for (bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject3, bool);
        break;
        localObject3 = new BitmapDrawable((Bitmap)localObject1);
        break label493;
      }
      localObject1 = p.tMy;
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 1)
      {
        bool = true;
        ((p)localObject1).nn(bool);
        if (!bool) {
          break label615;
        }
        localObject1 = ((p)localObject1).tMj;
        if (localObject1 == null) {
          break label625;
        }
      }
      label615:
      label625:
      for (bool = ((bax)localObject1).xqa;; bool = false)
      {
        if (!bool) {
          break label631;
        }
        ab.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
        AppMethodBeat.o(142312);
        return;
        bool = false;
        break;
        localObject1 = ((p)localObject1).tMk;
        break label579;
      }
      label631:
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 1)
      {
        paraml.a(j, this.tRZ.getString(2131305284), "", this.tRZ.getResources().getDrawable(2130840786), false);
        AppMethodBeat.o(142312);
        return;
      }
      if (WalletLqtSaveFetchUI.e(this.tRZ) == 2) {
        paraml.a(j, this.tRZ.getString(2131305204), "", this.tRZ.getResources().getDrawable(2130840786), false);
      }
      AppMethodBeat.o(142312);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.2
 * JD-Core Version:    0.7.0.1
 */