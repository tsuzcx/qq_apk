package com.tencent.mm.plugin.wallet.balance.ui.lqt;

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
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.ui.a;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wallet_core.ui.r;
import com.tencent.mm.plugin.wallet_core.ui.r.a;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.HashMap;
import java.util.List;

final class WalletLqtSaveFetchUI$5
  implements q.f
{
  WalletLqtSaveFetchUI$5(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, a parama) {}
  
  public final void onCreateMMMenu(final o paramo)
  {
    AppMethodBeat.i(265402);
    int j = WalletLqtSaveFetchUI.m(this.Oty).size();
    int i = 0;
    final Bankcard localBankcard;
    Object localObject1;
    if (i < j)
    {
      localBankcard = (Bankcard)WalletLqtSaveFetchUI.m(this.Oty).get(i);
      localObject1 = b.j(this.Oty, localBankcard.field_bankcardType, localBankcard.gIG());
      if (localObject1 == null) {
        break label741;
      }
    }
    label161:
    label600:
    label606:
    label741:
    for (final String str1 = ((e)localObject1).GtW;; str1 = "")
    {
      Bitmap localBitmap = u.a(new c(str1));
      u.a(new u.a()
      {
        public final void k(final String paramAnonymousString, final Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(195083);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186936);
              Log.i("MicroMsg.WalletLqtSaveFetchUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymousString, WalletLqtSaveFetchUI.5.1.this.GFU });
              if ((WalletLqtSaveFetchUI.5.this.OtC.tZx.isShowing()) && (WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.5.this.Oty).containsKey(paramAnonymousString)))
              {
                int i = ((Integer)WalletLqtSaveFetchUI.n(WalletLqtSaveFetchUI.5.this.Oty).get(paramAnonymousString)).intValue();
                if ((i < WalletLqtSaveFetchUI.5.1.this.ErT.size()) && (WalletLqtSaveFetchUI.5.1.this.ErT.getItem(i) != null))
                {
                  WalletLqtSaveFetchUI.5.1.this.ErT.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymousBitmap, WalletLqtSaveFetchUI.5.this.Oty.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), WalletLqtSaveFetchUI.5.this.Oty.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false)));
                  WalletLqtSaveFetchUI.5.this.OtC.gIa();
                }
              }
              AppMethodBeat.o(186936);
            }
          });
          AppMethodBeat.o(195083);
        }
      });
      Drawable localDrawable = null;
      Object localObject4 = null;
      localObject1 = "";
      if (!Util.isNullOrNil(localBankcard.field_forbidWord)) {
        localObject1 = localBankcard.field_forbidWord;
      }
      Object localObject3;
      Object localObject2;
      String str2;
      if (Util.isNullOrNil(localBankcard.field_forbid_title))
      {
        localObject3 = new SpannableStringBuilder((CharSequence)localObject1);
        localObject2 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject1;
        if (Util.isNullOrNil((CharSequence)localObject1))
        {
          localObject3 = localObject1;
          if (!Util.isNullOrNil(localBankcard.field_prompt_info_prompt_text))
          {
            localObject1 = new SpannableStringBuilder(localBankcard.field_prompt_info_prompt_text);
            localObject3 = localObject1;
            if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_text))
            {
              localObject3 = localObject1;
              if (!Util.isNullOrNil(localBankcard.field_prompt_info_jump_url))
              {
                ((SpannableStringBuilder)localObject1).append(localBankcard.field_prompt_info_jump_text);
                ((SpannableStringBuilder)localObject1).setSpan(new r(new r.a()
                {
                  public final void ed(View paramAnonymousView)
                  {
                    AppMethodBeat.i(269009);
                    com.tencent.mm.wallet_core.ui.g.bA(WalletLqtSaveFetchUI.5.this.Oty.getContext(), localBankcard.field_prompt_info_jump_url);
                    h.IzE.a(20216, new Object[] { Integer.valueOf(2), localBankcard.field_prompt_info_jump_url });
                    AppMethodBeat.o(269009);
                  }
                }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject1).length(), 33);
                localObject3 = localObject1;
              }
            }
          }
        }
        str2 = localBankcard.field_desc;
        if (!localBankcard.gIH()) {
          break label606;
        }
        localObject1 = str2;
        if (localBankcard.OND >= 0.0D) {
          localObject1 = str2 + this.Oty.getString(a.i.wallet_balance_left, new Object[] { com.tencent.mm.wallet_core.ui.g.F(localBankcard.OND) });
        }
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), localObject1, localObject3 });
        localDrawable = this.Oty.getResources().getDrawable(a.e.wallet_balance_manager_logo_small);
        if (Util.isNullOrNil((String)localObject2)) {
          break label600;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramo.a(i, (CharSequence)localObject1, (CharSequence)localObject3, localDrawable, 0, bool);
        localObject1 = localObject4;
        if (localObject1 == null) {
          WalletLqtSaveFetchUI.n(this.Oty).put(str1, Integer.valueOf(i));
        }
        i += 1;
        break;
        localObject2 = (String)localObject1 + " ";
        localObject1 = new SpannableStringBuilder((String)localObject2 + localBankcard.field_forbid_title);
        localObject3 = new m(this.Oty)
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(223812);
            paramAnonymousView = localBankcard.field_forbid_url;
            Intent localIntent = new Intent();
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "go to url %s", new Object[] { paramAnonymousView });
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("geta8key_username", z.bcZ());
            localIntent.putExtra("pay_channel", 1);
            com.tencent.mm.wallet_core.ui.g.aJ(WalletLqtSaveFetchUI.5.this.Oty.getContext(), localIntent);
            AppMethodBeat.o(223812);
          }
        };
        int k = ((String)localObject2).length();
        int m = ((String)localObject2).length() + localBankcard.field_forbid_title.length();
        ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(this.Oty.getResources().getColor(a.c.link_color)), k, m, 33);
        ((SpannableStringBuilder)localObject1).setSpan(localObject3, k, m, 33);
        break label161;
      }
      localObject1 = localDrawable;
      if (localBitmap != null) {
        localObject1 = BitmapUtil.extractThumbNail(localBitmap, this.Oty.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.Oty.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
      }
      Log.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject3 });
      if (localObject1 == null)
      {
        localObject4 = null;
        if (Util.isNullOrNil((String)localObject2)) {
          break label729;
        }
      }
      for (bool = true;; bool = false)
      {
        paramo.a(i, str2, (CharSequence)localObject3, (Drawable)localObject4, 0, bool);
        break;
        localObject4 = new BitmapDrawable((Bitmap)localObject1);
        break label686;
      }
      AppMethodBeat.o(265402);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.5
 * JD-Core Version:    0.7.0.1
 */