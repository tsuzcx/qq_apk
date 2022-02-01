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
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.an;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class b
{
  private IListener VXA;
  public LinkedList<String> VXB;
  ArrayList<b> VXz;
  ReentrantLock mLock;
  public LinkedList<Bankcard> mtD;
  
  public b()
  {
    AppMethodBeat.i(71627);
    this.VXz = new ArrayList();
    this.mLock = new ReentrantLock();
    this.VXA = new BankcardLogoHelper.1(this, com.tencent.mm.app.f.hfK);
    this.VXA.alive();
    AppMethodBeat.o(71627);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71633);
    if (z.bBi()) {}
    for (String str = paramBankcard.field_bankName; (this.VXB != null) && (this.VXB.contains(str)); str = paramBankcard.field_bankcardType)
    {
      Log.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(71633);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.mtD == null) {
        this.mtD = new LinkedList();
      }
      this.mtD.add(paramBankcard);
      if (this.VXB == null)
      {
        d(paramContext, this.mtD);
        AppMethodBeat.o(71633);
      }
    }
    else
    {
      new an().publish();
    }
    AppMethodBeat.o(71633);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71634);
    if (z.bBi()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.needUpdate); paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankcardType, paramBankcard.ihU()))
    {
      AppMethodBeat.o(71634);
      return false;
    }
    AppMethodBeat.o(71634);
    return true;
  }
  
  public static void w(ImageView paramImageView)
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
    localb.VXO = false;
    localb.VcZ = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(a.f.wallet_core_bankcard_logo_helper_tag, paramBankcard.field_bankcardType);
      localb.VXK = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.VXL = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.VXM = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.VXN = new WeakReference(paramTextView);
    }
    this.VXz.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(71631);
  }
  
  public final void a(final Bankcard paramBankcard, final ImageView paramImageView)
  {
    AppMethodBeat.i(71630);
    b localb = new b();
    localb.VcZ = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, paramBankcard.field_bankcardType);
      localb.VXK = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.VDy;
    if ((paramImageView != null) && (localb.VXK != null) && (localb.VXK.get() != null))
    {
      Log.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.MpW);
      paramBankcard = (ImageView)localb.VXK.get();
      if (!Util.isNullOrNil(paramImageView.MpW))
      {
        localb.VSt = paramImageView.MpW;
        localb.VXO = true;
        paramImageView = r.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.MpW));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        r.a(localb);
        AppMethodBeat.o(71630);
        return;
      }
      if (paramImageView.VDZ > 0)
      {
        paramBankcard.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71618);
            paramBankcard.setImageResource(paramImageView.VDZ);
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
  
  public final void d(final Context paramContext, List<Bankcard> paramList)
  {
    AppMethodBeat.i(71635);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.VXB = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.ihV()) {
          Log.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            Log.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.VXB.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.VXB.size() > 0)
      {
        Log.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new com.tencent.mm.plugin.wallet_core.c.f(this.VXB);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(1650, new com.tencent.mm.am.h()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(71619);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.b(1650, this);
            b.this.VXB = null;
            if (b.this.mtD != null)
            {
              b.this.d(paramContext, b.this.mtD);
              b.this.mtD = null;
            }
            AppMethodBeat.o(71619);
          }
        });
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(paramList, 0);
        AppMethodBeat.o(71635);
        return;
      }
      Log.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      new an().publish();
    }
    AppMethodBeat.o(71635);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(71632);
    this.VXA.dead();
    if (this.VXz != null)
    {
      this.VXz.clear();
      this.VXz = null;
    }
    AppMethodBeat.o(71632);
  }
  
  public static abstract interface a
  {
    public abstract void bn(Map<String, e> paramMap);
  }
  
  static final class b
    implements r.a
  {
    String VSt;
    WeakReference<ImageView> VXK;
    WeakReference<View> VXL = null;
    WeakReference<ImageView> VXM = null;
    WeakReference<TextView> VXN = null;
    boolean VXO = false;
    Bankcard VcZ;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      boolean bool2 = true;
      AppMethodBeat.i(71626);
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.VSt)) {
          break;
        }
        Log.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        AppMethodBeat.o(71626);
        return;
      }
      if (this.VXK != null)
      {
        final ImageView localImageView = (ImageView)this.VXK.get();
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
          Log.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.VSt, Boolean.valueOf(this.VXO) });
          if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.VSt))) {
            break label335;
          }
          if (!this.VXO) {
            break label309;
          }
          if ((localImageView.getTag(a.f.wallet_core_bankcard_logo_helper_tag) == null) || (this.VcZ == null) || (this.VcZ.field_bankcardType == null)) {
            break label335;
          }
          paramString = (String)localImageView.getTag(a.f.wallet_core_bankcard_logo_helper_tag);
          if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.VcZ.field_bankcardType)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.b
 * JD-Core Version:    0.7.0.1
 */