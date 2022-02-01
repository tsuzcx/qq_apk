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
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.wallet_core.ui.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class j
{
  public static void a(final Context paramContext, List<Bankcard> paramList, Bankcard paramBankcard, String paramString1, String paramString2, final boolean paramBoolean, final String paramString3, o.g paramg)
  {
    AppMethodBeat.i(70721);
    final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramContext, 2, true);
    locale.HLX = new o.f()
    {
      public final void onCreateMMMenu(final m paramAnonymousm)
      {
        AppMethodBeat.i(70720);
        int i = 0;
        Iterator localIterator = this.HvP.iterator();
        final Bankcard localBankcard;
        Object localObject1;
        Object localObject2;
        if (localIterator.hasNext())
        {
          localBankcard = (Bankcard)localIterator.next();
          localObject1 = null;
          if (localBankcard.fQc())
          {
            localObject2 = t.fQI().IbQ;
            if (localObject2 != null) {
              localObject1 = ((Bankcard)localObject2).HVM;
            }
            label71:
            if (localObject1 == null) {
              break label780;
            }
          }
        }
        label774:
        label780:
        for (final String str1 = ((com.tencent.mm.plugin.wallet_core.model.e)localObject1).AAU;; str1 = "")
        {
          Log.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[] { str1 });
          Bitmap localBitmap = u.a(new c(str1));
          u.a(new u.a()
          {
            public final void k(final String paramAnonymous2String, final Bitmap paramAnonymous2Bitmap)
            {
              AppMethodBeat.i(70718);
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(70717);
                  Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[] { paramAnonymous2String, j.1.1.this.Idm });
                  if (j.1.this.Idh.containsKey(paramAnonymous2String))
                  {
                    int i = ((Integer)j.1.this.Idh.get(paramAnonymous2String)).intValue();
                    if (j.1.1.this.yNV.getItem(i) != null)
                    {
                      j.1.1.this.yNV.getItem(i).setIcon(new BitmapDrawable(BitmapUtil.extractThumbNail(paramAnonymous2Bitmap, MMApplicationContext.getResources().getDimensionPixelOffset(2131167138), MMApplicationContext.getResources().getDimensionPixelOffset(2131167138), true, false)));
                      j.1.this.Idi.fPw();
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
            if (this.Idj)
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
                    ((SpannableStringBuilder)localObject2).setSpan(new q(new q.a()
                    {
                      public final void dF(View paramAnonymous2View)
                      {
                        AppMethodBeat.i(214238);
                        f.bn(j.1.this.val$context, localBankcard.field_prompt_info_jump_url);
                        h.CyF.a(20216, new Object[] { Integer.valueOf(4), localBankcard.field_prompt_info_jump_url });
                        AppMethodBeat.o(214238);
                      }
                    }), localBankcard.field_prompt_info_prompt_text.length(), ((SpannableStringBuilder)localObject2).length(), 33);
                    localObject1 = localObject2;
                  }
                }
              }
            }
            str2 = localBankcard.field_desc;
            if (localBitmap == null) {
              break label774;
            }
          }
          for (localObject2 = BitmapUtil.extractThumbNail(localBitmap, paramContext.getResources().getDimensionPixelOffset(2131167138), paramContext.getResources().getDimensionPixelOffset(2131167138), true, false);; localObject2 = null)
          {
            if (localObject2 == null) {
              this.Idh.put(str1, Integer.valueOf(i));
            }
            Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[] { Integer.valueOf(i), str2, localObject1 });
            if (localBankcard.fQb())
            {
              localObject2 = paramContext.getResources().getDrawable(2131235574);
              if (!Util.isNullOrNil((String)localObject3)) {}
              for (bool = true;; bool = false)
              {
                paramAnonymousm.a(i, str2, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
                i += 1;
                break;
                localObject1 = b.j(paramContext, localBankcard.field_bankcardType, localBankcard.fQa());
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
                    Log.i("MicroMsg.WalletBankcardBottomSheetHelper", "go to url %s", new Object[] { str });
                    paramAnonymous2View.putExtra("rawUrl", str);
                    paramAnonymous2View.putExtra("geta8key_username", z.aTY());
                    paramAnonymous2View.putExtra("pay_channel", 1);
                    f.aA(j.1.this.val$context, paramAnonymous2View);
                    AppMethodBeat.o(70719);
                  }
                };
                int j = ((String)localObject3).length();
                int k = ((String)localObject3).length() + localBankcard.field_forbid_title.length();
                ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(paramContext.getResources().getColor(2131101373)), j, k, 33);
                ((SpannableStringBuilder)localObject1).setSpan(localObject2, j, k, 33);
                break label180;
              }
            }
            if (localObject2 == null)
            {
              localObject2 = null;
              label676:
              if (Util.isNullOrNil((String)localObject3)) {
                break label723;
              }
            }
            label723:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousm.a(i, str2, (CharSequence)localObject1, (Drawable)localObject2, 0, bool);
              i += 1;
              break;
              localObject2 = new BitmapDrawable((Bitmap)localObject2);
              break label676;
            }
            if ((paramBoolean) && (!Util.isNullOrNil(paramString3))) {
              paramAnonymousm.a(i, paramString3, "", MMApplicationContext.getResources().getDrawable(2131235565), false);
            }
            AppMethodBeat.o(70720);
            return;
          }
        }
      }
    };
    locale.HLY = paramg;
    locale.HMg = true;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496878, null);
    if (!Util.isNullOrNil(paramString1)) {
      ((TextView)paramContext.findViewById(2131297351)).setText(paramString1);
    }
    if (!Util.isNullOrNil(paramString2)) {
      ((TextView)paramContext.findViewById(2131297350)).setText(paramString2);
    }
    for (;;)
    {
      locale.V(paramContext, false);
      if (paramBankcard == null) {
        break;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if (((Bankcard)paramList.get(i)).field_bindSerial.equals(paramBankcard.field_bindSerial)) {
          locale.jKz = i;
        }
        i += 1;
      }
      paramContext.findViewById(2131297350).setVisibility(8);
    }
    locale.dGm();
    AppMethodBeat.o(70721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j
 * JD-Core Version:    0.7.0.1
 */