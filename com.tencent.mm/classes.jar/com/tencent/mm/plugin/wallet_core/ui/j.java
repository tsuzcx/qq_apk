package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static void a(final Context paramContext, List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, final boolean paramBoolean, final String paramString3, n.e parame)
  {
    AppMethodBeat.i(70721);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 2, true);
    locale.KJy = new n.d()
    {
      public final void onCreateMMMenu(final com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(70720);
        int i = 0;
        Iterator localIterator = this.Czn.iterator();
        final Bankcard localBankcard;
        Object localObject1;
        Object localObject2;
        if (localIterator.hasNext())
        {
          localBankcard = (Bankcard)localIterator.next();
          localObject1 = null;
          if (localBankcard.eES())
          {
            localObject2 = t.eFy().Dba;
            if (localObject2 != null) {
              localObject1 = ((Bankcard)localObject2).CUO;
            }
            label71:
            if (localObject1 == null) {
              break label778;
            }
          }
        }
        label772:
        label778:
        for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).wqa;; str1 = "")
        {
          ad.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[] { str1 });
          Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new c(str1));
          com.tencent.mm.platformtools.u.a(new u.a()
          {
            public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(70718);
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(70717);
                  ad.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, j.1.1.this.Dcw });
                  if (j.1.this.Dcr.containsKey(paramAnonymous2String))
                  {
                    int i = ((Integer)j.1.this.Dcr.get(paramAnonymous2String)).intValue();
                    if (j.1.1.this.vic.getItem(i) != null)
                    {
                      j.1.1.this.vic.getItem(i).setIcon(new BitmapDrawable(com.tencent.mm.sdk.platformtools.g.a(paramAnonymous2Bitmap, aj.getResources().getDimensionPixelOffset(2131167003), aj.getResources().getDimensionPixelOffset(2131167003), true, false)));
                      j.1.this.Dcs.fMg();
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
          Object localObject3;
          label180:
          String str2;
          if (bt.isNullOrNil(localBankcard.field_forbid_title))
          {
            localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (this.Dct)
            {
              localObject2 = localObject1;
              if (bt.ai((CharSequence)localObject1))
              {
                localObject2 = localObject1;
                if (!bt.isNullOrNil(localBankcard.field_fetchArriveTimeWording)) {
                  localObject2 = new SpannableStringBuilder(localBankcard.field_fetchArriveTimeWording);
                }
              }
            }
            localObject1 = localObject2;
            if (!bt.ai((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              if (!bt.isNullOrNil(localBankcard.field_prompt_info_prompt_text))
              {
                localObject2 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
                localObject1 = localObject2;
                if (!bt.isNullOrNil(localBankcard.field_prompt_info_jump_text))
                {
                  localObject1 = localObject2;
                  if (!bt.isNullOrNil(localBankcard.field_prompt_info_jump_url))
                  {
                    ((SpannableStringBuilder)localObject2).append(localBankcard.field_prompt_info_jump_text);
                    ((SpannableStringBuilder)localObject2).setSpan(new q(new q.a()
                    {
                      public final void dN(View paramAnonymous2View)
                      {
                        AppMethodBeat.i(199345);
                        com.tencent.mm.wallet_core.ui.e.aW(j.1.this.val$context, localBankcard.field_prompt_info_jump_url);
                        com.tencent.mm.plugin.report.service.g.yhR.f(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
                        AppMethodBeat.o(199345);
                      }
                    }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject2).length(), 33);
                    localObject1 = localObject2;
                  }
                }
              }
            }
            str2 = localBankcard.field_desc;
            if (localBitmap == null) {
              break label772;
            }
          }
          for (localObject2 = com.tencent.mm.sdk.platformtools.g.a(localBitmap, paramContext.getResources().getDimensionPixelOffset(2131167003), paramContext.getResources().getDimensionPixelOffset(2131167003), true, false);; localObject2 = null)
          {
            if (localObject2 == null) {
              this.Dcr.put(str1, Integer.valueOf(i));
            }
            ad.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject1 });
            if (localBankcard.eER())
            {
              localObject2 = paramContext.getResources().getDrawable(2131234612);
              if (!bt.isNullOrNil((String)localObject3)) {}
              for (bool = true;; bool = false)
              {
                paramAnonymousl.b(i, str2, (CharSequence)localObject1, (Drawable)localObject2, bool);
                i += 1;
                break;
                localObject1 = b.i(paramContext, localBankcard.field_bankcardType, localBankcard.eEQ());
                break label71;
                localObject3 = (String)localObject1 + " ";
                localObject1 = new SpannableStringBuilder((String)localObject3 + localBankcard.field_forbid_title);
                localObject2 = new l(paramContext)
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(70719);
                    paramAnonymous2View = new Intent();
                    String str = localBankcard.field_forbid_url;
                    ad.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", new Object[] { str });
                    paramAnonymous2View.putExtra("rawUrl", str);
                    paramAnonymous2View.putExtra("geta8key_username", com.tencent.mm.model.u.aAm());
                    paramAnonymous2View.putExtra("pay_channel", 1);
                    com.tencent.mm.wallet_core.ui.e.an(j.1.this.val$context, paramAnonymous2View);
                    AppMethodBeat.o(70719);
                  }
                };
                int j = ((String)localObject3).length();
                int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
                ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101130)), j, k, 33);
                ((SpannableStringBuilder)localObject1).setSpan(localObject2, j, k, 33);
                break label180;
              }
            }
            if (localObject2 == null)
            {
              localObject2 = null;
              label675:
              if (bt.isNullOrNil((String)localObject3)) {
                break label721;
              }
            }
            label721:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousl.b(i, str2, (CharSequence)localObject1, (Drawable)localObject2, bool);
              i += 1;
              break;
              localObject2 = new BitmapDrawable((Bitmap)localObject2);
              break label675;
            }
            if ((paramBoolean) && (!bt.isNullOrNil(paramString3))) {
              paramAnonymousl.a(i, paramString3, "", aj.getResources().getDrawable(2131234603), false);
            }
            AppMethodBeat.o(70720);
            return;
          }
        }
      }
    };
    locale.KJz = parame;
    locale.KWX = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495898, null);
    if (!bt.isNullOrNil(paramString1)) {
      ((TextView)paramContext.findViewById(2131297202)).setText(paramString1);
    }
    if (!bt.isNullOrNil(paramString2)) {
      ((TextView)paramContext.findViewById(2131297201)).setText(paramString2);
    }
    for (;;)
    {
      locale.K(paramContext, false);
      if (paramBankcard == null) {
        break;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((Bankcard)paramList.get(i)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
          locale.iKS = i;
        }
        i += 1;
      }
      paramContext.findViewById(2131297201).setVisibility(8);
    }
    locale.cMW();
    AppMethodBeat.o(70721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j
 * JD-Core Version:    0.7.0.1
 */