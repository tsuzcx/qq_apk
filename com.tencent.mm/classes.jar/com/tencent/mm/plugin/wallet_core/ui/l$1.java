package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.wallet_core.ui.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

final class l$1
  implements u.g
{
  l$1(List paramList, Context paramContext, HashMap paramHashMap, f paramf, boolean paramBoolean, String paramString) {}
  
  public final void onCreateMMMenu(final com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(70720);
    int i = 0;
    Iterator localIterator = this.Vcs.iterator();
    final Bankcard localBankcard;
    Object localObject1;
    Object localObject2;
    if (localIterator.hasNext())
    {
      localBankcard = (Bankcard)localIterator.next();
      localObject1 = null;
      if (localBankcard.ihW())
      {
        localObject2 = u.iiC().VKi;
        if (localObject2 != null) {
          localObject1 = ((Bankcard)localObject2).VDy;
        }
        label71:
        if (localObject1 == null) {
          break label783;
        }
      }
    }
    label777:
    label783:
    for (final String str1 = ((e)localObject1).MpW;; str1 = "")
    {
      Log.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[] { str1 });
      Bitmap localBitmap = r.a(new c(str1));
      r.a(new r.a()
      {
        public final void k(final String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(70718);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(70717);
              Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymousString, l.1.1.this.VLS });
              if (l.1.this.VLN.containsKey(paramAnonymousString))
              {
                int i = ((Integer)l.1.this.VLN.get(paramAnonymousString)).intValue();
                if (l.1.1.this.Kkz.getItem(i) != null)
                {
                  l.1.1.this.Kkz.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymousBitmap, MMApplicationContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), MMApplicationContext.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
                  l.1.this.VLO.ihf();
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
        if (this.VLP)
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
                ((SpannableStringBuilder)localObject2).setSpan(new s(new s.a()
                {
                  public final void eS(View paramAnonymousView)
                  {
                    AppMethodBeat.i(301212);
                    i.bC(l.1.this.val$context, localBankcard.field_prompt_info_jump_url);
                    h.OAn.b(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(301212);
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
      for (localObject2 = BitmapUtil.extractThumbNail(localBitmap, this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);; localObject2 = null)
      {
        if (localObject2 == null) {
          this.VLN.put(str1, Integer.valueOf(i));
        }
        Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject1 });
        if (localBankcard.ihV())
        {
          localObject2 = this.val$context.getResources().getDrawable(a.e.wallet_balance_manager_logo_small);
          if (!Util.isNullOrNil((String)localObject3)) {}
          for (bool = true;; bool = false)
          {
            params.a(i, str2, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
            i += 1;
            break;
            localObject1 = b.j(this.val$context, localBankcard.field_bankcardType, localBankcard.ihU());
            break label71;
            localObject3 = (String)localObject1 + " ";
            localObject1 = new SpannableStringBuilder((String)localObject3 + localBankcard.field_forbid_title);
            localObject2 = new n(this.val$context)
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(70719);
                paramAnonymousView = new Intent();
                String str = localBankcard.field_forbid_url;
                Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", new Object[] { str });
                paramAnonymousView.putExtra("rawUrl", str);
                paramAnonymousView.putExtra("geta8key_username", z.bAM());
                paramAnonymousView.putExtra("pay_channel", 1);
                i.aS(l.1.this.val$context, paramAnonymousView);
                AppMethodBeat.o(70719);
              }
            };
            int j = ((String)localObject3).length();
            int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
            ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(a.c.wallet_offline_link_color)), j, k, 33);
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
          params.a(i, str2, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
          i += 1;
          break;
          localObject2 = new BitmapDrawable((Bitmap)localObject2);
          break label679;
        }
        if ((this.VLQ) && (!Util.isNullOrNil(this.VLR))) {
          params.a(i, this.VLR, "", MMApplicationContext.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
        }
        AppMethodBeat.o(70720);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l.1
 * JD-Core Version:    0.7.0.1
 */