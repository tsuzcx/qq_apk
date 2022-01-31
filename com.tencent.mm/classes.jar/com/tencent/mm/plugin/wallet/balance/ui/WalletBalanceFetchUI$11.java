package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class WalletBalanceFetchUI$11
  implements n.c
{
  WalletBalanceFetchUI$11(WalletBalanceFetchUI paramWalletBalanceFetchUI, List paramList, Context paramContext) {}
  
  public final void a(l paraml)
  {
    int i = 0;
    Iterator localIterator = this.qgU.iterator();
    Object localObject4;
    Object localObject2;
    Bitmap localBitmap;
    Object localObject3;
    if (localIterator.hasNext())
    {
      localObject4 = (Bankcard)localIterator.next();
      localObject2 = b.h(this.val$context, ((Bankcard)localObject4).field_bankcardType, ((Bankcard)localObject4).bUP());
      localObject1 = "";
      if (localObject2 != null) {
        localObject1 = ((e)localObject2).mEi;
      }
      y.d("MicroMsg.WalletBalanceFetchUI", "logo url: %s", new Object[] { localObject1 });
      localBitmap = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject1));
      localObject1 = "";
      if (!bk.bl(((Bankcard)localObject4).field_forbidWord)) {
        localObject1 = ((Bankcard)localObject4).field_forbidWord;
      }
      if (bk.bl(((Bankcard)localObject4).field_forbid_title))
      {
        localObject3 = new SpannableString((CharSequence)localObject1);
        localObject2 = localObject1;
        localObject1 = localObject3;
        label152:
        localObject3 = localObject1;
        if (bk.L((CharSequence)localObject1)) {
          localObject3 = new SpannableString(((Bankcard)localObject4).field_fetchArriveTimeWording);
        }
        localObject4 = ((Bankcard)localObject4).field_desc;
        if (localBitmap == null) {
          break label467;
        }
      }
    }
    label261:
    label444:
    label467:
    for (Object localObject1 = com.tencent.mm.sdk.platformtools.c.a(localBitmap, this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);; localObject1 = null)
    {
      y.i("MicroMsg.WalletBalanceFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), localObject4, localObject3 });
      if (localObject1 == null)
      {
        localObject1 = null;
        if (bk.bl((String)localObject2)) {
          break label444;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paraml.a(i, (CharSequence)localObject4, (CharSequence)localObject3, (Drawable)localObject1, bool);
        i += 1;
        break;
        localObject2 = (String)localObject1 + " ";
        localObject1 = new SpannableString((String)localObject2 + ((Bankcard)localObject4).field_forbid_title);
        localObject3 = new WalletBalanceFetchUI.11.1(this, this.val$context, (Bankcard)localObject4);
        int j = ((String)localObject2).length();
        int k = ((String)localObject2).length() + ((Bankcard)localObject4).field_forbid_title.length();
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(a.c.wallet_offline_link_color)), j, k, 33);
        ((SpannableString)localObject1).setSpan(localObject3, j, k, 33);
        break label152;
        localObject1 = new BitmapDrawable((Bitmap)localObject1);
        break label261;
      }
      paraml.e(i, this.val$context.getString(a.i.wallet_balance_fetch_use_new_card));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.11
 * JD-Core Version:    0.7.0.1
 */