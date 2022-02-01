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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  ArrayList<b> AuS;
  private com.tencent.mm.sdk.b.c AuT;
  public LinkedList<String> AuU;
  public LinkedList<Bankcard> fUG;
  ReentrantLock mLock;
  
  public a()
  {
    AppMethodBeat.i(71627);
    this.AuS = new ArrayList();
    this.mLock = new ReentrantLock();
    this.AuT = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.ESL.c(this.AuT);
    AppMethodBeat.o(71627);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71633);
    if (com.tencent.mm.model.u.aqV()) {}
    for (String str = paramBankcard.field_bankName; (this.AuU != null) && (this.AuU.contains(str)); str = paramBankcard.field_bankcardType)
    {
      ad.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(71633);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.fUG == null) {
        this.fUG = new LinkedList();
      }
      this.fUG.add(paramBankcard);
      if (this.AuU == null)
      {
        b(paramContext, this.fUG);
        AppMethodBeat.o(71633);
      }
    }
    else
    {
      paramContext = new ag();
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
    }
    AppMethodBeat.o(71633);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71634);
    if (com.tencent.mm.model.u.aqV()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.fOl); paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankcardType, paramBankcard.ebu()))
    {
      AppMethodBeat.o(71634);
      return false;
    }
    AppMethodBeat.o(71634);
    return true;
  }
  
  public static void j(ImageView paramImageView)
  {
    AppMethodBeat.i(71629);
    if (paramImageView != null)
    {
      paramImageView.setTag(2131306720, null);
      paramImageView.setImageResource(2131234612);
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
    localb.Avh = false;
    localb.zMX = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.Avd = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.Ave = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.Avf = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.Avg = new WeakReference(paramTextView);
    }
    this.AuS.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(71631);
  }
  
  public final void a(final Bankcard paramBankcard, final ImageView paramImageView)
  {
    AppMethodBeat.i(71630);
    b localb = new b();
    localb.zMX = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.Avd = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.Acf;
    if ((paramImageView != null) && (localb.Avd != null) && (localb.Avd.get() != null))
    {
      ad.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.dct);
      paramBankcard = (ImageView)localb.Avd.get();
      if (!bt.isNullOrNil(paramImageView.dct))
      {
        localb.ApU = paramImageView.dct;
        localb.Avh = true;
        paramImageView = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.dct));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        com.tencent.mm.platformtools.u.a(localb);
        AppMethodBeat.o(71630);
        return;
      }
      if (paramImageView.Acy > 0)
      {
        paramBankcard.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71618);
            paramBankcard.setImageResource(paramImageView.Acy);
            AppMethodBeat.o(71618);
          }
        });
        AppMethodBeat.o(71630);
        return;
      }
      ad.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
      AppMethodBeat.o(71630);
      return;
    }
    ad.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
    AppMethodBeat.o(71630);
  }
  
  public final void b(final Context paramContext, List<Bankcard> paramList)
  {
    AppMethodBeat.i(71635);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.AuU = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.ebv()) {
          ad.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            ad.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.AuU.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.AuU.size() > 0)
      {
        ad.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new f(this.AuU);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(1650, new com.tencent.mm.al.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(71619);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.b(1650, this);
            a.this.AuU = null;
            if (a.this.fUG != null)
            {
              a.this.b(paramContext, a.this.fUG);
              a.this.fUG = null;
            }
            AppMethodBeat.o(71619);
          }
        });
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramList, 0);
        AppMethodBeat.o(71635);
        return;
      }
      ad.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      paramContext = new ag();
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
    }
    AppMethodBeat.o(71635);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(71632);
    com.tencent.mm.sdk.b.a.ESL.d(this.AuT);
    if (this.AuS != null)
    {
      this.AuS.clear();
      this.AuS = null;
    }
    AppMethodBeat.o(71632);
  }
  
  public static abstract interface a
  {
    public abstract void aQ(Map<String, e> paramMap);
  }
  
  static final class b
    implements u.a
  {
    String ApU;
    WeakReference<ImageView> Avd;
    WeakReference<View> Ave = null;
    WeakReference<ImageView> Avf = null;
    WeakReference<TextView> Avg = null;
    boolean Avh = false;
    Bankcard zMX;
    
    public final void l(String paramString, final Bitmap paramBitmap)
    {
      boolean bool2 = true;
      AppMethodBeat.i(71626);
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.ApU)) {
          break;
        }
        ad.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        AppMethodBeat.o(71626);
        return;
      }
      if (this.Avd != null)
      {
        final ImageView localImageView = (ImageView)this.Avd.get();
        if (paramBitmap == null)
        {
          bool1 = true;
          if (localImageView != null) {
            break label290;
          }
          label106:
          if (localImageView != null) {
            break label296;
          }
        }
        label290:
        label296:
        for (localObject = "";; localObject = localImageView.getTag())
        {
          ad.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.ApU, Boolean.valueOf(this.Avh) });
          if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.ApU))) {
            break label331;
          }
          if (!this.Avh) {
            break label306;
          }
          if ((localImageView.getTag(2131306720) == null) || (this.zMX == null) || (this.zMX.field_bankcardType == null)) {
            break label331;
          }
          paramString = (String)localImageView.getTag(2131306720);
          if ((!bt.isNullOrNil(paramString)) && (paramString.equals(this.zMX.field_bankcardType)))
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
            localImageView.setTag(2131306720, null);
          }
          AppMethodBeat.o(71626);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label106;
        }
        label306:
        localImageView.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71625);
            localImageView.setImageBitmap(paramBitmap);
            AppMethodBeat.o(71625);
          }
        });
        localImageView.setTag(2131306720, null);
      }
      label331:
      AppMethodBeat.o(71626);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a
 * JD-Core Version:    0.7.0.1
 */