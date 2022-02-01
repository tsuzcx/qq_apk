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
import com.tencent.mm.g.a.ah;
import com.tencent.mm.platformtools.u.a;
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
  ArrayList<b> DnE;
  private com.tencent.mm.sdk.b.c DnF;
  public LinkedList<String> DnG;
  public LinkedList<Bankcard> grX;
  ReentrantLock mLock;
  
  public a()
  {
    AppMethodBeat.i(71627);
    this.DnE = new ArrayList();
    this.mLock = new ReentrantLock();
    this.DnF = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.IbL.c(this.DnF);
    AppMethodBeat.o(71627);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71633);
    if (com.tencent.mm.model.u.aAB()) {}
    for (String str = paramBankcard.field_bankName; (this.DnG != null) && (this.DnG.contains(str)); str = paramBankcard.field_bankcardType)
    {
      ad.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(71633);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.grX == null) {
        this.grX = new LinkedList();
      }
      this.grX.add(paramBankcard);
      if (this.DnG == null)
      {
        b(paramContext, this.grX);
        AppMethodBeat.o(71633);
      }
    }
    else
    {
      paramContext = new ah();
      com.tencent.mm.sdk.b.a.IbL.l(paramContext);
    }
    AppMethodBeat.o(71633);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71634);
    if (com.tencent.mm.model.u.aAB()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.i(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.glA); paramContext = com.tencent.mm.plugin.wallet_core.d.b.i(paramContext, paramBankcard.field_bankcardType, paramBankcard.eEQ()))
    {
      AppMethodBeat.o(71634);
      return false;
    }
    AppMethodBeat.o(71634);
    return true;
  }
  
  public static void k(ImageView paramImageView)
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
    localb.DnT = false;
    localb.CzV = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.DnP = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.DnQ = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.DnR = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.DnS = new WeakReference(paramTextView);
    }
    this.DnE.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(71631);
  }
  
  public final void a(final Bankcard paramBankcard, final ImageView paramImageView)
  {
    AppMethodBeat.i(71630);
    b localb = new b();
    localb.CzV = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.DnP = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.CUO;
    if ((paramImageView != null) && (localb.DnP != null) && (localb.DnP.get() != null))
    {
      ad.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.wqa);
      paramBankcard = (ImageView)localb.DnP.get();
      if (!bt.isNullOrNil(paramImageView.wqa))
      {
        localb.DiG = paramImageView.wqa;
        localb.DnT = true;
        paramImageView = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.wqa));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        com.tencent.mm.platformtools.u.a(localb);
        AppMethodBeat.o(71630);
        return;
      }
      if (paramImageView.CVh > 0)
      {
        paramBankcard.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71618);
            paramBankcard.setImageResource(paramImageView.CVh);
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
      this.DnG = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.eER()) {
          ad.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            ad.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.DnG.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.DnG.size() > 0)
      {
        ad.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new com.tencent.mm.plugin.wallet_core.c.f(this.DnG);
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(1650, new com.tencent.mm.al.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(71619);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.b(1650, this);
            a.this.DnG = null;
            if (a.this.grX != null)
            {
              a.this.b(paramContext, a.this.grX);
              a.this.grX = null;
            }
            AppMethodBeat.o(71619);
          }
        });
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a(paramList, 0);
        AppMethodBeat.o(71635);
        return;
      }
      ad.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      paramContext = new ah();
      com.tencent.mm.sdk.b.a.IbL.l(paramContext);
    }
    AppMethodBeat.o(71635);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(71632);
    com.tencent.mm.sdk.b.a.IbL.d(this.DnF);
    if (this.DnE != null)
    {
      this.DnE.clear();
      this.DnE = null;
    }
    AppMethodBeat.o(71632);
  }
  
  public static abstract interface a
  {
    public abstract void aX(Map<String, e> paramMap);
  }
  
  static final class b
    implements u.a
  {
    Bankcard CzV;
    String DiG;
    WeakReference<ImageView> DnP;
    WeakReference<View> DnQ = null;
    WeakReference<ImageView> DnR = null;
    WeakReference<TextView> DnS = null;
    boolean DnT = false;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      boolean bool2 = true;
      AppMethodBeat.i(71626);
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ad.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.DiG)) {
          break;
        }
        ad.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        AppMethodBeat.o(71626);
        return;
      }
      if (this.DnP != null)
      {
        final ImageView localImageView = (ImageView)this.DnP.get();
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
          ad.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.DiG, Boolean.valueOf(this.DnT) });
          if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.DiG))) {
            break label331;
          }
          if (!this.DnT) {
            break label306;
          }
          if ((localImageView.getTag(2131306720) == null) || (this.CzV == null) || (this.CzV.field_bankcardType == null)) {
            break label331;
          }
          paramString = (String)localImageView.getTag(2131306720);
          if ((!bt.isNullOrNil(paramString)) && (paramString.equals(this.CzV.field_bankcardType)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a
 * JD-Core Version:    0.7.0.1
 */