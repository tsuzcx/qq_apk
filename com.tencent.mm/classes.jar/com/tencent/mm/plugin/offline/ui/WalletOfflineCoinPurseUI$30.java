package com.tencent.mm.plugin.offline.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.HashMap;
import java.util.List;

final class WalletOfflineCoinPurseUI$30
  implements n.c
{
  WalletOfflineCoinPurseUI$30(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, List paramList, com.tencent.mm.ui.widget.b.d paramd) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(43540);
    int i = 0;
    Bankcard localBankcard;
    Object localObject1;
    Object localObject3;
    Bitmap localBitmap;
    if (i < this.nIy.size())
    {
      localBankcard = (Bankcard)this.nIy.get(i);
      localObject1 = com.tencent.mm.plugin.offline.c.a.Wx(localBankcard.field_bankcardType);
      localObject3 = localObject1;
      if (localBankcard.cTg())
      {
        localObject3 = localObject1;
        if (localBankcard.ufW != null) {
          localObject3 = localBankcard.ufW.pek;
        }
      }
      localBitmap = x.a(new c((String)localObject3));
      x.a(new WalletOfflineCoinPurseUI.30.1(this, (String)localObject3, paraml));
      localObject1 = "";
      if (!bo.isNullOrNil(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      if ((!bo.isNullOrNil((String)localObject1)) || (localBankcard.field_support_micropay)) {
        break label708;
      }
      if (bo.isNullOrNil(localBankcard.field_no_micro_word)) {
        localObject1 = "";
      }
    }
    label161:
    label187:
    label576:
    label708:
    for (;;)
    {
      Object localObject2;
      Object localObject4;
      String str;
      if (bo.isNullOrNil(localBankcard.field_forbid_title))
      {
        localObject2 = new SpannableString((CharSequence)localObject1);
        localObject4 = localObject1;
        if (((!localBankcard.cTf()) && (!localBankcard.cTg())) || (localBankcard.ufM < 0.0D)) {
          break label566;
        }
        str = localBankcard.field_desc + this.pny.getString(2131304816, new Object[] { e.F(localBankcard.ufM) });
        localObject1 = null;
        if (!localBankcard.cTj()) {
          break label576;
        }
        localObject1 = com.tencent.mm.svg.a.a.g(this.pny.getResources(), 2131231407);
        if (localObject1 == null) {
          WalletOfflineCoinPurseUI.K(this.pny).put(localObject3, Integer.valueOf(i));
        }
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject2 });
        if (!localBankcard.cTk()) {
          break label643;
        }
        localObject3 = j.b(this.pny.getContext(), str);
        if (bo.isNullOrNil((String)localObject4))
        {
          if (!bo.isNullOrNil(localBankcard.ugk)) {
            break label624;
          }
          localObject2 = "";
        }
        label380:
        if (localObject1 != null) {
          break label634;
        }
        localObject1 = null;
        if (!bo.isNullOrNil((String)localObject4)) {
          break label637;
        }
      }
      label624:
      label634:
      label637:
      for (boolean bool = false;; bool = true)
      {
        paraml.a(i, (CharSequence)localObject3, (CharSequence)localObject2, (Drawable)localObject1, bool);
        i += 1;
        break;
        localObject1 = localBankcard.field_no_micro_word;
        break label161;
        localObject4 = (String)localObject1 + " ";
        localObject2 = new SpannableString((String)localObject4 + localBankcard.field_forbid_title);
        localObject1 = new WalletOfflineCoinPurseUI.30.2(this, this.pny, localBankcard);
        int j = ((String)localObject4).length();
        int k = ((String)localObject4).length() + localBankcard.field_forbid_title.length();
        ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(this.pny.getResources().getColor(2131690662)), j, k, 33);
        ((SpannableString)localObject2).setSpan(localObject1, j, k, 33);
        break label187;
        str = localBankcard.field_desc;
        break label260;
        if (localBitmap == null) {
          break label285;
        }
        localObject1 = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.a(localBitmap, this.pny.getResources().getDimensionPixelOffset(2131428824), this.pny.getResources().getDimensionPixelOffset(2131428824), true, false));
        break label285;
        localObject2 = localBankcard.ugk;
        break label380;
        break label388;
      }
      localObject3 = j.b(this.pny.getContext(), str);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (!bo.isNullOrNil((String)localObject4)) {
          break label696;
        }
      }
      for (bool = false;; bool = true)
      {
        paraml.a(i, (CharSequence)localObject3, (CharSequence)localObject2, (Drawable)localObject1, bool);
        break;
        break label665;
      }
      AppMethodBeat.o(43540);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.30
 * JD-Core Version:    0.7.0.1
 */