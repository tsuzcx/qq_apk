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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  ArrayList<b> BNm;
  private com.tencent.mm.sdk.b.c BNn;
  public LinkedList<String> BNo;
  public LinkedList<Bankcard> fYB;
  ReentrantLock mLock;
  
  public a()
  {
    AppMethodBeat.i(71627);
    this.BNm = new ArrayList();
    this.mLock = new ReentrantLock();
    this.BNn = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.GpY.c(this.BNn);
    AppMethodBeat.o(71627);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71633);
    if (com.tencent.mm.model.u.axL()) {}
    for (String str = paramBankcard.field_bankName; (this.BNo != null) && (this.BNo.contains(str)); str = paramBankcard.field_bankcardType)
    {
      ac.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(71633);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.fYB == null) {
        this.fYB = new LinkedList();
      }
      this.fYB.add(paramBankcard);
      if (this.BNo == null)
      {
        b(paramContext, this.fYB);
        AppMethodBeat.o(71633);
      }
    }
    else
    {
      paramContext = new ah();
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
    }
    AppMethodBeat.o(71633);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71634);
    if (com.tencent.mm.model.u.axL()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.i(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.fRW); paramContext = com.tencent.mm.plugin.wallet_core.d.b.i(paramContext, paramBankcard.field_bankcardType, paramBankcard.eqQ()))
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
    localb.BNB = false;
    localb.Bfr = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.BNx = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.BNy = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.BNz = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.BNA = new WeakReference(paramTextView);
    }
    this.BNm.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(71631);
  }
  
  public final void a(final Bankcard paramBankcard, final ImageView paramImageView)
  {
    AppMethodBeat.i(71630);
    b localb = new b();
    localb.Bfr = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.BNx = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.Buz;
    if ((paramImageView != null) && (localb.BNx != null) && (localb.BNx.get() != null))
    {
      ac.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.vkI);
      paramBankcard = (ImageView)localb.BNx.get();
      if (!bs.isNullOrNil(paramImageView.vkI))
      {
        localb.BIo = paramImageView.vkI;
        localb.BNB = true;
        paramImageView = com.tencent.mm.platformtools.u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.vkI));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        com.tencent.mm.platformtools.u.a(localb);
        AppMethodBeat.o(71630);
        return;
      }
      if (paramImageView.BuS > 0)
      {
        paramBankcard.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71618);
            paramBankcard.setImageResource(paramImageView.BuS);
            AppMethodBeat.o(71618);
          }
        });
        AppMethodBeat.o(71630);
        return;
      }
      ac.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
      AppMethodBeat.o(71630);
      return;
    }
    ac.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
    AppMethodBeat.o(71630);
  }
  
  public final void b(final Context paramContext, List<Bankcard> paramList)
  {
    AppMethodBeat.i(71635);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.BNo = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.eqR()) {
          ac.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            ac.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.BNo.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.BNo.size() > 0)
      {
        ac.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new f(this.BNo);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(1650, new com.tencent.mm.ak.g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(71619);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.b(1650, this);
            a.this.BNo = null;
            if (a.this.fYB != null)
            {
              a.this.b(paramContext, a.this.fYB);
              a.this.fYB = null;
            }
            AppMethodBeat.o(71619);
          }
        });
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(paramList, 0);
        AppMethodBeat.o(71635);
        return;
      }
      ac.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      paramContext = new ah();
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
    }
    AppMethodBeat.o(71635);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(71632);
    com.tencent.mm.sdk.b.a.GpY.d(this.BNn);
    if (this.BNm != null)
    {
      this.BNm.clear();
      this.BNm = null;
    }
    AppMethodBeat.o(71632);
  }
  
  public static abstract interface a
  {
    public abstract void aU(Map<String, e> paramMap);
  }
  
  static final class b
    implements u.a
  {
    String BIo;
    WeakReference<TextView> BNA = null;
    boolean BNB = false;
    WeakReference<ImageView> BNx;
    WeakReference<View> BNy = null;
    WeakReference<ImageView> BNz = null;
    Bankcard Bfr;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      boolean bool2 = true;
      AppMethodBeat.i(71626);
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ac.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.BIo)) {
          break;
        }
        ac.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        AppMethodBeat.o(71626);
        return;
      }
      if (this.BNx != null)
      {
        final ImageView localImageView = (ImageView)this.BNx.get();
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
          ac.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.BIo, Boolean.valueOf(this.BNB) });
          if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.BIo))) {
            break label331;
          }
          if (!this.BNB) {
            break label306;
          }
          if ((localImageView.getTag(2131306720) == null) || (this.Bfr == null) || (this.Bfr.field_bankcardType == null)) {
            break label331;
          }
          paramString = (String)localImageView.getTag(2131306720);
          if ((!bs.isNullOrNil(paramString)) && (paramString.equals(this.Bfr.field_bankcardType)))
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