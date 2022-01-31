package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class h$1
  implements n.c
{
  h$1(List paramList, Context paramContext, HashMap paramHashMap, com.tencent.mm.ui.widget.b.d paramd, boolean paramBoolean, String paramString) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(47157);
    int i = 0;
    Iterator localIterator = this.tOn.iterator();
    Bankcard localBankcard;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localBankcard = (Bankcard)localIterator.next();
      localObject1 = null;
      if (localBankcard.cTg())
      {
        localObject2 = t.cTN().ulT;
        if (localObject2 != null) {
          localObject1 = ((Bankcard)localObject2).ufW;
        }
        label71:
        if (localObject1 == null) {
          break label653;
        }
      }
    }
    label647:
    label653:
    for (Object localObject2 = ((g)localObject1).pek;; localObject2 = "")
    {
      ab.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[] { localObject2 });
      Bitmap localBitmap = x.a(new c((String)localObject2));
      x.a(new h.1.1(this, (String)localObject2, paraml));
      localObject1 = "";
      if (!bo.isNullOrNil(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      Object localObject4;
      Object localObject3;
      label180:
      String str;
      if (bo.isNullOrNil(localBankcard.field_forbid_title))
      {
        localObject4 = new SpannableString((CharSequence)localObject1);
        localObject3 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject1;
        if (this.una)
        {
          localObject4 = localObject1;
          if (bo.aa((CharSequence)localObject1))
          {
            localObject4 = localObject1;
            if (!bo.isNullOrNil(localBankcard.field_fetchArriveTimeWording)) {
              localObject4 = new SpannableString(localBankcard.field_fetchArriveTimeWording);
            }
          }
        }
        str = localBankcard.field_desc;
        if (localBitmap == null) {
          break label647;
        }
      }
      for (localObject1 = com.tencent.mm.sdk.platformtools.d.a(localBitmap, this.val$context.getResources().getDimensionPixelOffset(2131428824), this.val$context.getResources().getDimensionPixelOffset(2131428824), true, false);; localObject1 = null)
      {
        if (localObject1 == null) {
          this.umY.put(localObject2, Integer.valueOf(i));
        }
        ab.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject4 });
        if (localBankcard.cTf())
        {
          localObject1 = this.val$context.getResources().getDrawable(2130840794);
          if (!bo.isNullOrNil((String)localObject3)) {}
          for (bool = true;; bool = false)
          {
            paraml.a(i, str, (CharSequence)localObject4, (Drawable)localObject1, bool);
            i += 1;
            break;
            localObject1 = b.h(this.val$context, localBankcard.field_bankcardType, localBankcard.cTe());
            break label71;
            localObject3 = (String)localObject1 + " ";
            localObject1 = new SpannableString((String)localObject3 + localBankcard.field_forbid_title);
            localObject4 = new h.1.2(this, this.val$context, localBankcard);
            int j = ((String)localObject3).length();
            int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
            ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(2131690662)), j, k, 33);
            ((SpannableString)localObject1).setSpan(localObject4, j, k, 33);
            break label180;
          }
        }
        if (localObject1 == null)
        {
          localObject1 = null;
          label550:
          if (bo.isNullOrNil((String)localObject3)) {
            break label596;
          }
        }
        label596:
        for (boolean bool = true;; bool = false)
        {
          paraml.a(i, str, (CharSequence)localObject4, (Drawable)localObject1, bool);
          i += 1;
          break;
          localObject1 = new BitmapDrawable((Bitmap)localObject1);
          break label550;
        }
        if ((this.unb) && (!bo.isNullOrNil(this.unc))) {
          paraml.a(i, this.unc, "", ah.getResources().getDrawable(2130840786), false);
        }
        AppMethodBeat.o(47157);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.h.1
 * JD-Core Version:    0.7.0.1
 */