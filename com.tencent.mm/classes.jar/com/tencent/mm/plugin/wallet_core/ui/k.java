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
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.wallet_core.ui.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class k
{
  public static void a(final Context paramContext, List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, final boolean paramBoolean, final String paramString3, q.g paramg)
  {
    AppMethodBeat.i(70721);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 2, true);
    locale.ODT = new q.f()
    {
      public final void onCreateMMMenu(final o paramAnonymouso)
      {
        AppMethodBeat.i(70720);
        int i = 0;
        Iterator localIterator = this.OnC.iterator();
        final Bankcard localBankcard;
        Object localObject1;
        Object localObject2;
        if (localIterator.hasNext())
        {
          localBankcard = (Bankcard)localIterator.next();
          localObject1 = null;
          if (localBankcard.gII())
          {
            localObject2 = com.tencent.mm.plugin.wallet_core.model.u.gJo().OUc;
            if (localObject2 != null) {
              localObject1 = ((Bankcard)localObject2).ONN;
            }
            label71:
            if (localObject1 == null) {
              break label783;
            }
          }
        }
        label777:
        label783:
        for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).GtW;; str1 = "")
        {
          Log.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[] { str1 });
          Bitmap localBitmap = com.tencent.mm.platformtools.u.a(new c(str1));
          com.tencent.mm.platformtools.u.a(new u.a()
          {
            public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(70718);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(70717);
                  Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, k.1.1.this.OVD });
                  if (k.1.this.OVy.containsKey(paramAnonymous2String))
                  {
                    int i = ((Integer)k.1.this.OVy.get(paramAnonymous2String)).intValue();
                    if (k.1.1.this.ErT.getItem(i) != null)
                    {
                      k.1.1.this.ErT.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, MMApplicationContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), MMApplicationContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
                      k.1.this.OVz.gIa();
                    }
                  }
                  AppMethodBeat.o(70717);
                }
              });
              AppMethodBeat.o(70718);
            }
          });
          localObject1 = "";
          if (!Util.isNullOrNil(localBankcard.field_forbidWord)) {
            localObject1 = localBankcard.field_forbidWord;
          }
          Object localObject3;
          label180:
          String str2;
          if (Util.isNullOrNil(localBankcard.field_forbid_title))
          {
            localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (this.OVA)
            {
              localObject2 = localObject1;
              if (Util.isNullOrNil((CharSequence)localObject1))
              {
                localObject2 = localObject1;
                if (!Util.isNullOrNil(localBankcard.field_fetchArriveTimeWording)) {
                  localObject2 = new SpannableStringBuilder(localBankcard.field_fetchArriveTimeWording);
                }
              }
            }
            localObject1 = localObject2;
            if (!Util.isNullOrNil((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              if (!Util.isNullOrNil(localBankcard.field_prompt_info_prompt_text))
              {
                localObject2 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
                localObject1 = localObject2;
                if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text))
                {
                  localObject1 = localObject2;
                  if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url))
                  {
                    ((SpannableStringBuilder)localObject2).append(localBankcard.field_prompt_info_jump_text);
                    ((SpannableStringBuilder)localObject2).setSpan(new r(new r.a()
                    {
                      public final void ed(View paramAnonymous2View)
                      {
                        AppMethodBeat.i(228115);
                        g.bA(k.1.this.val$context, localBankcard.field_prompt_info_jump_url);
                        h.IzE.a(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
                        AppMethodBeat.o(228115);
                      }
                    }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject2).length(), 33);
                    localObject1 = localObject2;
                  }
                }
              }
            }
            str2 = localBankcard.field_desc;
            if (localBitmap == null) {
              break label777;
            }
          }
          for (localObject2 = BitmapUtil.extractThumbNail(localBitmap, paramContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), paramContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);; localObject2 = null)
          {
            if (localObject2 == null) {
              this.OVy.put(str1, Integer.valueOf(i));
            }
            Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject1 });
            if (localBankcard.gIH())
            {
              localObject2 = paramContext.getResources().getDrawable(a.e.wallet_balance_manager_logo_small);
              if (!Util.isNullOrNil((String)localObject3)) {}
              for (bool = true;; bool = false)
              {
                paramAnonymouso.a(i, str2, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
                i += 1;
                break;
                localObject1 = b.j(paramContext, localBankcard.field_bankcardType, localBankcard.gIG());
                break label71;
                localObject3 = (String)localObject1 + " ";
                localObject1 = new SpannableStringBuilder((String)localObject3 + localBankcard.field_forbid_title);
                localObject2 = new m(paramContext)
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(70719);
                    paramAnonymous2View = new Intent();
                    String str = localBankcard.field_forbid_url;
                    Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", new Object[] { str });
                    paramAnonymous2View.putExtra("rawUrl", str);
                    paramAnonymous2View.putExtra("geta8key_username", z.bcZ());
                    paramAnonymous2View.putExtra("pay_channel", 1);
                    g.aJ(k.1.this.val$context, paramAnonymous2View);
                    AppMethodBeat.o(70719);
                  }
                };
                int j = ((String)localObject3).length();
                int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
                ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(a.c.wallet_offline_link_color)), j, k, 33);
                ((SpannableStringBuilder)localObject1).setSpan(localObject2, j, k, 33);
                break label180;
              }
            }
            if (localObject2 == null)
            {
              localObject2 = null;
              label679:
              if (Util.isNullOrNil((String)localObject3)) {
                break label726;
              }
            }
            label726:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymouso.a(i, str2, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              i += 1;
              break;
              localObject2 = new BitmapDrawable((Bitmap)localObject2);
              break label679;
            }
            if ((paramBoolean) && (!Util.isNullOrNil(paramString3))) {
              paramAnonymouso.a(i, paramString3, "", MMApplicationContext.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
            }
            AppMethodBeat.o(70720);
            return;
          }
        }
      }
    };
    locale.ODU = paramg;
    locale.OEc = true;
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.wallet_balance_fetch_bankcard_bottomsheet_header, null);
    if (!Util.isNullOrNil(paramString1)) {
      ((TextView)paramContext.findViewById(a.f.bfbh_header_title_tv)).setText(paramString1);
    }
    if (!Util.isNullOrNil(paramString2)) {
      ((TextView)paramContext.findViewById(a.f.bfbh_header_desc_tv)).setText(paramString2);
    }
    for (;;)
    {
      locale.Z(paramContext, false);
      if (paramBankcard == null) {
        break;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((Bankcard)paramList.get(i)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
          locale.mBE = i;
        }
        i += 1;
      }
      paramContext.findViewById(a.f.bfbh_header_desc_tv).setVisibility(8);
    }
    locale.eik();
    AppMethodBeat.o(70721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */