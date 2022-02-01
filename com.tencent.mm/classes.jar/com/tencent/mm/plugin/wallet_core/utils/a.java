package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.ak;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  ArrayList<b> PgM;
  private IListener PgN;
  public LinkedList<String> PgO;
  public LinkedList<Bankcard> jTl;
  ReentrantLock mLock;
  
  public a()
  {
    AppMethodBeat.i(71627);
    this.PgM = new ArrayList();
    this.mLock = new ReentrantLock();
    this.PgN = new IListener() {};
    EventCenter.instance.addListener(this.PgN);
    AppMethodBeat.o(71627);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71633);
    if (z.bdq()) {}
    for (String str = paramBankcard.field_bankName; (this.PgO != null) && (this.PgO.contains(str)); str = paramBankcard.field_bankcardType)
    {
      Log.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(71633);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.jTl == null) {
        this.jTl = new LinkedList();
      }
      this.jTl.add(paramBankcard);
      if (this.PgO == null)
      {
        b(paramContext, this.jTl);
        AppMethodBeat.o(71633);
      }
    }
    else
    {
      paramContext = new ak();
      EventCenter.instance.publish(paramContext);
    }
    AppMethodBeat.o(71633);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71634);
    if (z.bdq()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.needUpdate); paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankcardType, paramBankcard.gIG()))
    {
      AppMethodBeat.o(71634);
      return false;
    }
    AppMethodBeat.o(71634);
    return true;
  }
  
  public static void n(ImageView paramImageView)
  {
    AppMethodBeat.i(71629);
    if (paramImageView != null)
    {
      paramImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
      paramImageView.setImageResource(a.e.wallet_balance_manager_logo_small);
    }
    AppMethodBeat.o(71629);
  }
  
  public final void a(Context paramContext, Bankcard paramBankcard, ImageView paramImageView)
  {
    AppMethodBeat.i(71628);
    a(paramContext, paramBankcard, paramImageView, null, null, null);
    AppMethodBeat.o(71628);
  }
  
  public final void a(Context paramContext, Bankcard paramBankcard, ImageView paramImageView1, View paramView, ImageView paramImageView2, TextView paramTextView)
  {
    AppMethodBeat.i(71631);
    b localb = new b();
    localb.Phb = false;
    localb.Ooj = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(a.f.wallet_core_bankcard_logo_helper_tag, paramBankcard.field_bankcardType);
      localb.PgX = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.PgY = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.PgZ = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.Pha = new WeakReference(paramTextView);
    }
    this.PgM.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(71631);
  }
  
  public final void a(final Bankcard paramBankcard, final ImageView paramImageView)
  {
    AppMethodBeat.i(71630);
    b localb = new b();
    localb.Ooj = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, paramBankcard.field_bankcardType);
      localb.PgX = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.ONN;
    if ((paramImageView != null) && (localb.PgX != null) && (localb.PgX.get() != null))
    {
      Log.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.GtW);
      paramBankcard = (ImageView)localb.PgX.get();
      if (!Util.isNullOrNil(paramImageView.GtW))
      {
        localb.PbN = paramImageView.GtW;
        localb.Phb = true;
        paramImageView = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.GtW));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        com.tencent.mm.platformtools.u.a(localb);
        AppMethodBeat.o(71630);
        return;
      }
      if (paramImageView.OOf > 0)
      {
        paramBankcard.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71618);
            paramBankcard.setImageResource(paramImageView.OOf);
            AppMethodBeat.o(71618);
          }
        });
        AppMethodBeat.o(71630);
        return;
      }
      Log.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
      AppMethodBeat.o(71630);
      return;
    }
    Log.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
    AppMethodBeat.o(71630);
  }
  
  public final void b(final Context paramContext, List<Bankcard> paramList)
  {
    AppMethodBeat.i(71635);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.PgO = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.gIH()) {
          Log.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            Log.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.PgO.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.PgO.size() > 0)
      {
        Log.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new f(this.PgO);
        h.aHH();
        h.aHF().kcd.a(1650, new i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(71619);
            h.aHH();
            h.aHF().kcd.b(1650, this);
            a.this.PgO = null;
            if (a.this.jTl != null)
            {
              a.this.b(paramContext, a.this.jTl);
              a.this.jTl = null;
            }
            AppMethodBeat.o(71619);
          }
        });
        h.aHH();
        h.aHF().kcd.a(paramList, 0);
        AppMethodBeat.o(71635);
        return;
      }
      Log.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      paramContext = new ak();
      EventCenter.instance.publish(paramContext);
    }
    AppMethodBeat.o(71635);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(71632);
    EventCenter.instance.removeListener(this.PgN);
    if (this.PgM != null)
    {
      this.PgM.clear();
      this.PgM = null;
    }
    AppMethodBeat.o(71632);
  }
  
  public static abstract interface a
  {
    public abstract void aW(Map<String, e> paramMap);
  }
  
  static final class b
    implements u.a
  {
    Bankcard Ooj;
    String PbN;
    WeakReference<ImageView> PgX;
    WeakReference<View> PgY = null;
    WeakReference<ImageView> PgZ = null;
    WeakReference<TextView> Pha = null;
    boolean Phb = false;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      boolean bool2 = true;
      AppMethodBeat.i(71626);
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.PbN)) {
          break;
        }
        Log.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        AppMethodBeat.o(71626);
        return;
      }
      if (this.PgX != null)
      {
        final ImageView localImageView = (ImageView)this.PgX.get();
        if (paramBitmap == null)
        {
          bool1 = true;
          if (localImageView != null) {
            break label293;
          }
          label106:
          if (localImageView != null) {
            break label299;
          }
        }
        label293:
        label299:
        for (localObject = "";; localObject = localImageView.getTag())
        {
          Log.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.PbN, Boolean.valueOf(this.Phb) });
          if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.PbN))) {
            break label335;
          }
          if (!this.Phb) {
            break label309;
          }
          if ((localImageView.getTag(a.f.wallet_core_bankcard_logo_helper_tag) == null) || (this.Ooj == null) || (this.Ooj.field_bankcardType == null)) {
            break label335;
          }
          paramString = (String)localImageView.getTag(a.f.wallet_core_bankcard_logo_helper_tag);
          if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.Ooj.field_bankcardType)))
          {
            localImageView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(71624);
                localImageView.setImageBitmap(paramBitmap);
                AppMethodBeat.o(71624);
              }
            });
            localImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
          }
          AppMethodBeat.o(71626);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label106;
        }
        label309:
        localImageView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71625);
            localImageView.setImageBitmap(paramBitmap);
            AppMethodBeat.o(71625);
          }
        });
        localImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
      }
      label335:
      AppMethodBeat.o(71626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a
 * JD-Core Version:    0.7.0.1
 */