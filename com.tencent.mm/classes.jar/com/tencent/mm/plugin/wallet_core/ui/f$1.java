package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class f$1
  implements n.c
{
  f$1(List paramList, Context paramContext, HashMap paramHashMap, d paramd) {}
  
  public final void a(l paraml)
  {
    int i = 0;
    Iterator localIterator = this.qgU.iterator();
    Bankcard localBankcard;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localBankcard = (Bankcard)localIterator.next();
      localObject1 = null;
      if (localBankcard.bUR())
      {
        localObject2 = o.bVs().qzj;
        if (localObject2 != null) {
          localObject1 = ((Bankcard)localObject2).qtH;
        }
        label66:
        if (localObject1 == null) {
          break label608;
        }
      }
    }
    label175:
    label595:
    label602:
    label608:
    for (Object localObject2 = ((e)localObject1).mEi;; localObject2 = "")
    {
      y.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[] { localObject2 });
      Bitmap localBitmap = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c((String)localObject2));
      x.a(new f.1.1(this, (String)localObject2, paraml));
      localObject1 = "";
      if (!bk.bl(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      Object localObject4;
      Object localObject3;
      String str;
      if (bk.bl(localBankcard.field_forbid_title))
      {
        localObject4 = new SpannableString((CharSequence)localObject1);
        localObject3 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject1;
        if (this.qAs)
        {
          localObject4 = localObject1;
          if (bk.L((CharSequence)localObject1))
          {
            localObject4 = localObject1;
            if (!bk.bl(localBankcard.field_fetchArriveTimeWording)) {
              localObject4 = new SpannableString(localBankcard.field_fetchArriveTimeWording);
            }
          }
        }
        str = localBankcard.field_desc;
        if (localBitmap == null) {
          break label602;
        }
      }
      for (localObject1 = com.tencent.mm.sdk.platformtools.c.a(localBitmap, this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);; localObject1 = null)
      {
        if (localObject1 == null) {
          this.qAq.put(localObject2, Integer.valueOf(i));
        }
        y.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject4 });
        if (localBankcard.bUQ())
        {
          localObject1 = this.val$context.getResources().getDrawable(a.e.wallet_balance_manager_logo_small);
          if (!bk.bl((String)localObject3)) {}
          for (bool = true;; bool = false)
          {
            paraml.a(i, str, (CharSequence)localObject4, (Drawable)localObject1, bool);
            i += 1;
            break;
            localObject1 = b.h(this.val$context, localBankcard.field_bankcardType, localBankcard.bUP());
            break label66;
            localObject3 = (String)localObject1 + " ";
            localObject1 = new SpannableString((String)localObject3 + localBankcard.field_forbid_title);
            localObject4 = new f.1.2(this, this.val$context, localBankcard);
            int j = ((String)localObject3).length();
            int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
            ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(a.c.wallet_offline_link_color)), j, k, 33);
            ((SpannableString)localObject1).setSpan(localObject4, j, k, 33);
            break label175;
          }
        }
        if (localObject1 == null)
        {
          localObject1 = null;
          if (bk.bl((String)localObject3)) {
            break label595;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paraml.a(i, str, (CharSequence)localObject4, (Drawable)localObject1, bool);
          i += 1;
          break;
          localObject1 = new BitmapDrawable((Bitmap)localObject1);
          break label549;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.f.1
 * JD-Core Version:    0.7.0.1
 */