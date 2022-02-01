package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.n.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class j$1
  implements n.c
{
  j$1(List paramList, Context paramContext, HashMap paramHashMap, com.tencent.mm.ui.widget.a.e parame, boolean paramBoolean, String paramString) {}
  
  public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paraml)
  {
    AppMethodBeat.i(70720);
    int i = 0;
    Iterator localIterator = this.zGN.iterator();
    final Bankcard localBankcard;
    Object localObject1;
    if (localIterator.hasNext())
    {
      localBankcard = (Bankcard)localIterator.next();
      localObject1 = null;
      if (localBankcard.ebw())
      {
        localObject2 = s.ecc().Ain;
        if (localObject2 != null) {
          localObject1 = ((Bankcard)localObject2).Acf;
        }
        label71:
        if (localObject1 == null) {
          break label653;
        }
      }
    }
    label647:
    label653:
    for (Object localObject2 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).dct;; localObject2 = "")
    {
      ad.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[] { localObject2 });
      Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new c((String)localObject2));
      com.tencent.mm.platformtools.u.a(new u.a()
      {
        public final void l(final String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(70718);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70717);
              ad.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymousString, j.1.1.this.AjI });
              if (j.1.this.AjD.containsKey(paramAnonymousString))
              {
                int i = ((Integer)j.1.this.AjD.get(paramAnonymousString)).intValue();
                if (j.1.1.this.sXf.getItem(i) != null)
                {
                  j.1.1.this.sXf.getItem(i).setIcon(new BitmapDrawable(f.a(paramAnonymousBitmap, aj.getResources().getDimensionPixelOffset(2131167003), aj.getResources().getDimensionPixelOffset(2131167003), true, false)));
                  j.1.this.AjE.ffw();
                }
              }
              AppMethodBeat.o(70717);
            }
          });
          AppMethodBeat.o(70718);
        }
      });
      localObject1 = "";
      if (!bt.isNullOrNil(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      Object localObject4;
      Object localObject3;
      label180:
      String str;
      if (bt.isNullOrNil(localBankcard.field_forbid_title))
      {
        localObject4 = new SpannableString((CharSequence)localObject1);
        localObject3 = localObject1;
        localObject1 = localObject4;
        localObject4 = localObject1;
        if (this.AjF)
        {
          localObject4 = localObject1;
          if (bt.ai((CharSequence)localObject1))
          {
            localObject4 = localObject1;
            if (!bt.isNullOrNil(localBankcard.field_fetchArriveTimeWording)) {
              localObject4 = new SpannableString(localBankcard.field_fetchArriveTimeWording);
            }
          }
        }
        str = localBankcard.field_desc;
        if (localBitmap == null) {
          break label647;
        }
      }
      for (localObject1 = f.a(localBitmap, this.val$context.getResources().getDimensionPixelOffset(2131167003), this.val$context.getResources().getDimensionPixelOffset(2131167003), true, false);; localObject1 = null)
      {
        if (localObject1 == null) {
          this.AjD.put(localObject2, Integer.valueOf(i));
        }
        ad.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str, localObject4 });
        if (localBankcard.ebv())
        {
          localObject1 = this.val$context.getResources().getDrawable(2131234612);
          if (!bt.isNullOrNil((String)localObject3)) {}
          for (bool = true;; bool = false)
          {
            paraml.b(i, str, (CharSequence)localObject4, (Drawable)localObject1, bool);
            i += 1;
            break;
            localObject1 = b.j(this.val$context, localBankcard.field_bankcardType, localBankcard.ebu());
            break label71;
            localObject3 = (String)localObject1 + " ";
            localObject1 = new SpannableString((String)localObject3 + localBankcard.field_forbid_title);
            localObject4 = new l(this.val$context)
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(70719);
                paramAnonymousView = new Intent();
                String str = localBankcard.field_forbid_url;
                ad.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", new Object[] { str });
                paramAnonymousView.putExtra("rawUrl", str);
                paramAnonymousView.putExtra("geta8key_username", com.tencent.mm.model.u.aqG());
                paramAnonymousView.putExtra("pay_channel", 1);
                com.tencent.mm.wallet_core.ui.e.X(j.1.this.val$context, paramAnonymousView);
                AppMethodBeat.o(70719);
              }
            };
            int j = ((String)localObject3).length();
            int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
            ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(2131101130)), j, k, 33);
            ((SpannableString)localObject1).setSpan(localObject4, j, k, 33);
            break label180;
          }
        }
        if (localObject1 == null)
        {
          localObject1 = null;
          label550:
          if (bt.isNullOrNil((String)localObject3)) {
            break label596;
          }
        }
        label596:
        for (boolean bool = true;; bool = false)
        {
          paraml.b(i, str, (CharSequence)localObject4, (Drawable)localObject1, bool);
          i += 1;
          break;
          localObject1 = new BitmapDrawable((Bitmap)localObject1);
          break label550;
        }
        if ((this.AjG) && (!bt.isNullOrNil(this.AjH))) {
          paraml.a(i, this.AjH, "", aj.getResources().getDrawable(2131234603), false);
        }
        AppMethodBeat.o(70720);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j.1
 * JD-Core Version:    0.7.0.1
 */