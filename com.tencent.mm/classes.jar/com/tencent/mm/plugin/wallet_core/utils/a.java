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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  ArrayList<b> Iou;
  private IListener Iov;
  public LinkedList<String> Iow;
  public LinkedList<Bankcard> hhn;
  ReentrantLock mLock;
  
  public a()
  {
    AppMethodBeat.i(71627);
    this.Iou = new ArrayList();
    this.mLock = new ReentrantLock();
    this.Iov = new IListener() {};
    EventCenter.instance.addListener(this.Iov);
    AppMethodBeat.o(71627);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71633);
    if (z.aUo()) {}
    for (String str = paramBankcard.field_bankName; (this.Iow != null) && (this.Iow.contains(str)); str = paramBankcard.field_bankcardType)
    {
      Log.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(71633);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.hhn == null) {
        this.hhn = new LinkedList();
      }
      this.hhn.add(paramBankcard);
      if (this.Iow == null)
      {
        b(paramContext, this.hhn);
        AppMethodBeat.o(71633);
      }
    }
    else
    {
      paramContext = new aj();
      EventCenter.instance.publish(paramContext);
    }
    AppMethodBeat.o(71633);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(71634);
    if (z.aUo()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.needUpdate); paramContext = com.tencent.mm.plugin.wallet_core.d.b.j(paramContext, paramBankcard.field_bankcardType, paramBankcard.fQa()))
    {
      AppMethodBeat.o(71634);
      return false;
    }
    AppMethodBeat.o(71634);
    return true;
  }
  
  public static void m(ImageView paramImageView)
  {
    AppMethodBeat.i(71629);
    if (paramImageView != null)
    {
      paramImageView.setTag(2131310182, null);
      paramImageView.setImageResource(2131235574);
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
    localb.IoJ = false;
    localb.Hww = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(2131310182, paramBankcard.field_bankcardType);
      localb.IoF = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.IoG = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.IoH = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.IoI = new WeakReference(paramTextView);
    }
    this.Iou.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(71631);
  }
  
  public final void a(final Bankcard paramBankcard, final ImageView paramImageView)
  {
    AppMethodBeat.i(71630);
    b localb = new b();
    localb.Hww = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(2131310182, paramBankcard.field_bankcardType);
      localb.IoF = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.HVM;
    if ((paramImageView != null) && (localb.IoF != null) && (localb.IoF.get() != null))
    {
      Log.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.AAU);
      paramBankcard = (ImageView)localb.IoF.get();
      if (!Util.isNullOrNil(paramImageView.AAU))
      {
        localb.Ijw = paramImageView.AAU;
        localb.IoJ = true;
        paramImageView = u.a(new c(paramImageView.AAU));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        u.a(localb);
        AppMethodBeat.o(71630);
        return;
      }
      if (paramImageView.HWf > 0)
      {
        paramBankcard.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71618);
            paramBankcard.setImageResource(paramImageView.HWf);
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
      this.Iow = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.fQb()) {
          Log.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            Log.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.Iow.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.Iow.size() > 0)
      {
        Log.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new f(this.Iow);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(1650, new i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(71619);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.b(1650, this);
            a.this.Iow = null;
            if (a.this.hhn != null)
            {
              a.this.b(paramContext, a.this.hhn);
              a.this.hhn = null;
            }
            AppMethodBeat.o(71619);
          }
        });
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(paramList, 0);
        AppMethodBeat.o(71635);
        return;
      }
      Log.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      paramContext = new aj();
      EventCenter.instance.publish(paramContext);
    }
    AppMethodBeat.o(71635);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(71632);
    EventCenter.instance.removeListener(this.Iov);
    if (this.Iou != null)
    {
      this.Iou.clear();
      this.Iou = null;
    }
    AppMethodBeat.o(71632);
  }
  
  public static abstract interface a
  {
    public abstract void bc(Map<String, e> paramMap);
  }
  
  static final class b
    implements u.a
  {
    Bankcard Hww;
    String Ijw;
    WeakReference<ImageView> IoF;
    WeakReference<View> IoG = null;
    WeakReference<ImageView> IoH = null;
    WeakReference<TextView> IoI = null;
    boolean IoJ = false;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      boolean bool2 = true;
      AppMethodBeat.i(71626);
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.Ijw)) {
          break;
        }
        Log.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
        AppMethodBeat.o(71626);
        return;
      }
      if (this.IoF != null)
      {
        final ImageView localImageView = (ImageView)this.IoF.get();
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
          Log.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.Ijw, Boolean.valueOf(this.IoJ) });
          if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.Ijw))) {
            break label331;
          }
          if (!this.IoJ) {
            break label306;
          }
          if ((localImageView.getTag(2131310182) == null) || (this.Hww == null) || (this.Hww.field_bankcardType == null)) {
            break label331;
          }
          paramString = (String)localImageView.getTag(2131310182);
          if ((!Util.isNullOrNil(paramString)) && (paramString.equals(this.Hww.field_bankcardType)))
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
            localImageView.setTag(2131310182, null);
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
        localImageView.setTag(2131310182, null);
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