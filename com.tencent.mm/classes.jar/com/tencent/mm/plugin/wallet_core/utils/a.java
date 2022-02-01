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
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  ArrayList<b> DFj;
  private com.tencent.mm.sdk.b.c DFk;
  public LinkedList<String> DFl;
  public LinkedList<Bankcard> guy;
  ReentrantLock mLock;
  
  public a()
  {
    AppMethodBeat.i(71627);
    this.DFj = new ArrayList();
    this.mLock = new ReentrantLock();
    this.DFk = new com.tencent.mm.sdk.b.c() {};
    com.tencent.mm.sdk.b.a.IvT.c(this.DFk);
    AppMethodBeat.o(71627);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71633);
    if (v.aAR()) {}
    for (String str = paramBankcard.field_bankName; (this.DFl != null) && (this.DFl.contains(str)); str = paramBankcard.field_bankcardType)
    {
      ae.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(71633);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.guy == null) {
        this.guy = new LinkedList();
      }
      this.guy.add(paramBankcard);
      if (this.DFl == null)
      {
        b(paramContext, this.guy);
        AppMethodBeat.o(71633);
      }
    }
    else
    {
      paramContext = new ah();
      com.tencent.mm.sdk.b.a.IvT.l(paramContext);
    }
    AppMethodBeat.o(71633);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71634);
    if (v.aAR()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.i(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.gnV); paramContext = com.tencent.mm.plugin.wallet_core.d.b.i(paramContext, paramBankcard.field_bankcardType, paramBankcard.eIx()))
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
    localb.DFy = false;
    localb.CRA = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.DFu = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.DFv = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.DFw = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.DFx = new WeakReference(paramTextView);
    }
    this.DFj.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(71631);
  }
  
  public final void a(final Bankcard paramBankcard, final ImageView paramImageView)
  {
    AppMethodBeat.i(71630);
    b localb = new b();
    localb.CRA = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(2131306720, paramBankcard.field_bankcardType);
      localb.DFu = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.Dmu;
    if ((paramImageView != null) && (localb.DFu != null) && (localb.DFu.get() != null))
    {
      ae.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.wFJ);
      paramBankcard = (ImageView)localb.DFu.get();
      if (!bu.isNullOrNil(paramImageView.wFJ))
      {
        localb.DAk = paramImageView.wFJ;
        localb.DFy = true;
        paramImageView = u.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.wFJ));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        u.a(localb);
        AppMethodBeat.o(71630);
        return;
      }
      if (paramImageView.DmN > 0)
      {
        paramBankcard.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71618);
            paramBankcard.setImageResource(paramImageView.DmN);
            AppMethodBeat.o(71618);
          }
        });
        AppMethodBeat.o(71630);
        return;
      }
      ae.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
      AppMethodBeat.o(71630);
      return;
    }
    ae.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
    AppMethodBeat.o(71630);
  }
  
  public final void b(final Context paramContext, List<Bankcard> paramList)
  {
    AppMethodBeat.i(71635);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.DFl = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.eIy()) {
          ae.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            ae.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.DFl.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.DFl.size() > 0)
      {
        ae.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new com.tencent.mm.plugin.wallet_core.c.f(this.DFl);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(1650, new com.tencent.mm.ak.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(71619);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.b(1650, this);
            a.this.DFl = null;
            if (a.this.guy != null)
            {
              a.this.b(paramContext, a.this.guy);
              a.this.guy = null;
            }
            AppMethodBeat.o(71619);
          }
        });
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramList, 0);
        AppMethodBeat.o(71635);
        return;
      }
      ae.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      paramContext = new ah();
      com.tencent.mm.sdk.b.a.IvT.l(paramContext);
    }
    AppMethodBeat.o(71635);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(71632);
    com.tencent.mm.sdk.b.a.IvT.d(this.DFk);
    if (this.DFj != null)
    {
      this.DFj.clear();
      this.DFj = null;
    }
    AppMethodBeat.o(71632);
  }
  
  public static abstract interface a
  {
    public abstract void bd(Map<String, e> paramMap);
  }
  
  static final class b
    implements u.a
  {
    Bankcard CRA;
    String DAk;
    WeakReference<ImageView> DFu;
    WeakReference<View> DFv = null;
    WeakReference<ImageView> DFw = null;
    WeakReference<TextView> DFx = null;
    boolean DFy = false;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      boolean bool2 = true;
      AppMethodBeat.i(71626);
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.DAk)) {
          break;
        }
        ae.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        AppMethodBeat.o(71626);
        return;
      }
      if (this.DFu != null)
      {
        final ImageView localImageView = (ImageView)this.DFu.get();
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
          ae.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.DAk, Boolean.valueOf(this.DFy) });
          if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.DAk))) {
            break label331;
          }
          if (!this.DFy) {
            break label306;
          }
          if ((localImageView.getTag(2131306720) == null) || (this.CRA == null) || (this.CRA.field_bankcardType == null)) {
            break label331;
          }
          paramString = (String)localImageView.getTag(2131306720);
          if ((!bu.isNullOrNil(paramString)) && (paramString.equals(this.CRA.field_bankcardType)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a
 * JD-Core Version:    0.7.0.1
 */