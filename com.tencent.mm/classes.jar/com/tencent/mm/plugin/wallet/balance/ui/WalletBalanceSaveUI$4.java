package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashMap;
import java.util.List;

final class WalletBalanceSaveUI$4
  implements n.c
{
  WalletBalanceSaveUI$4(WalletBalanceSaveUI paramWalletBalanceSaveUI, List paramList, com.tencent.mm.ui.widget.d paramd) {}
  
  public final void onCreateMMMenu(final l paraml)
  {
    AppMethodBeat.i(45474);
    int j = this.nIy.size();
    int i = 0;
    Bankcard localBankcard;
    Object localObject1;
    if (i < j)
    {
      localBankcard = (Bankcard)this.nIy.get(i);
      localObject1 = b.h(this.tOS, localBankcard.field_bankcardType, localBankcard.cTe());
      if (localObject1 == null) {
        break label571;
      }
    }
    label151:
    label409:
    label571:
    for (final String str1 = ((g)localObject1).pek;; str1 = "")
    {
      Bitmap localBitmap = x.a(new c(str1));
      x.a(new x.a()
      {
        public final void m(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(45473);
          al.d(new WalletBalanceSaveUI.4.1.1(this, paramAnonymousString, paramAnonymousBitmap));
          AppMethodBeat.o(45473);
        }
      });
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
          break label409;
        }
        ab.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
        localObject1 = this.tOS.getResources().getDrawable(2130840794);
        if (!bo.isNullOrNil((String)localObject2)) {
          break label403;
        }
      }
      for (boolean bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject1, bool);
        localObject1 = localObject3;
        if (localObject1 == null) {
          WalletBalanceSaveUI.d(this.tOS).put(str1, Integer.valueOf(i));
        }
        i += 1;
        break;
        localObject2 = (String)localObject1 + " ";
        localSpannableString = new SpannableString((String)localObject2 + localBankcard.field_forbid_title);
        localObject1 = new WalletBalanceSaveUI.4.2(this, this.tOS);
        int k = ((String)localObject2).length();
        int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
        localSpannableString.setSpan(new ForegroundColorSpan(this.tOS.getResources().getColor(2131690662)), k, m, 33);
        localSpannableString.setSpan(localObject1, k, m, 33);
        break label151;
      }
      localObject1 = localObject4;
      if (localBitmap != null) {
        localObject1 = com.tencent.mm.sdk.platformtools.d.a(localBitmap, this.tOS.getResources().getDimensionPixelOffset(2131428824), this.tOS.getResources().getDimensionPixelOffset(2131428824), true, false);
      }
      ab.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localSpannableString });
      if (localObject1 == null)
      {
        localObject3 = null;
        label487:
        if (!bo.isNullOrNil((String)localObject2)) {
          break label529;
        }
      }
      for (bool = false;; bool = true)
      {
        paraml.a(i, str2, localSpannableString, (Drawable)localObject3, bool);
        break;
        localObject3 = new BitmapDrawable((Bitmap)localObject1);
        break label487;
      }
      paraml.a(j, this.tOS.getString(2131304842), "", this.tOS.getResources().getDrawable(2130840786), false);
      AppMethodBeat.o(45474);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.4
 * JD-Core Version:    0.7.0.1
 */