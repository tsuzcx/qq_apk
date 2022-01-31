package com.tencent.mm.plugin.wallet_core.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet_core.c.f;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  public LinkedList<Bankcard> ezI;
  ReentrantLock mLock;
  ArrayList<a.b> uxS;
  private com.tencent.mm.sdk.b.c uxT;
  public LinkedList<String> uxU;
  
  public a()
  {
    AppMethodBeat.i(47998);
    this.uxS = new ArrayList();
    this.mLock = new ReentrantLock();
    this.uxT = new a.1(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.uxT);
    AppMethodBeat.o(47998);
  }
  
  private void a(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(48004);
    if (r.ZB()) {}
    for (String str = paramBankcard.field_bankName; (this.uxU != null) && (this.uxU.contains(str)); str = paramBankcard.field_bankcardType)
    {
      ab.i("MicroMsg.BankcardLogoHelper", "waiting resp:".concat(String.valueOf(str)));
      AppMethodBeat.o(48004);
      return;
    }
    if (!b(paramContext, paramBankcard))
    {
      if (this.ezI == null) {
        this.ezI = new LinkedList();
      }
      this.ezI.add(paramBankcard);
      if (this.uxU == null)
      {
        b(paramContext, this.ezI);
        AppMethodBeat.o(48004);
      }
    }
    else
    {
      paramContext = new ad();
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
    }
    AppMethodBeat.o(48004);
  }
  
  private static boolean b(Context paramContext, Bankcard paramBankcard)
  {
    AppMethodBeat.i(48005);
    if (r.ZB()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.h(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.bxr); paramContext = com.tencent.mm.plugin.wallet_core.d.b.h(paramContext, paramBankcard.field_bankcardType, paramBankcard.cTe()))
    {
      AppMethodBeat.o(48005);
      return false;
    }
    AppMethodBeat.o(48005);
    return true;
  }
  
  public static void k(ImageView paramImageView)
  {
    AppMethodBeat.i(48000);
    if (paramImageView != null)
    {
      paramImageView.setTag(2131820690, null);
      paramImageView.setImageResource(2130840794);
    }
    AppMethodBeat.o(48000);
  }
  
  public final void a(Context paramContext, Bankcard paramBankcard, ImageView paramImageView)
  {
    AppMethodBeat.i(47999);
    a(paramContext, paramBankcard, paramImageView, null, null, null);
    AppMethodBeat.o(47999);
  }
  
  public final void a(Context paramContext, Bankcard paramBankcard, ImageView paramImageView1, View paramView, ImageView paramImageView2, TextView paramTextView)
  {
    AppMethodBeat.i(48002);
    a.b localb = new a.b();
    localb.uyh = false;
    localb.tOQ = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(2131820690, paramBankcard.field_bankcardType);
      localb.uyd = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.uye = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.uyf = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.uyg = new WeakReference(paramTextView);
    }
    this.uxS.add(localb);
    a(paramContext, paramBankcard);
    AppMethodBeat.o(48002);
  }
  
  public final void a(Bankcard paramBankcard, ImageView paramImageView)
  {
    AppMethodBeat.i(48001);
    a.b localb = new a.b();
    localb.tOQ = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(2131820690, paramBankcard.field_bankcardType);
      localb.uyd = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.ufW;
    if ((paramImageView != null) && (localb.uyd != null) && (localb.uyd.get() != null))
    {
      ab.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.pek);
      paramBankcard = (ImageView)localb.uyd.get();
      if (!bo.isNullOrNil(paramImageView.pek))
      {
        localb.uta = paramImageView.pek;
        localb.uyh = true;
        paramImageView = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.pek));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        x.a(localb);
        AppMethodBeat.o(48001);
        return;
      }
      if (paramImageView.ugq > 0)
      {
        paramBankcard.post(new a.6(this, paramBankcard, paramImageView));
        AppMethodBeat.o(48001);
        return;
      }
      ab.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
      AppMethodBeat.o(48001);
      return;
    }
    ab.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
    AppMethodBeat.o(48001);
  }
  
  public final void b(Context paramContext, List<Bankcard> paramList)
  {
    AppMethodBeat.i(48006);
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.uxU = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.cTf()) {
          ab.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!b(paramContext, localBankcard))
          {
            ab.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.uxU.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.uxU.size() > 0)
      {
        ab.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new f(this.uxU);
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(1650, new a.7(this, paramContext));
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(paramList, 0);
        AppMethodBeat.o(48006);
        return;
      }
      ab.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
      paramContext = new ad();
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
    }
    AppMethodBeat.o(48006);
  }
  
  public final void destory()
  {
    AppMethodBeat.i(48003);
    com.tencent.mm.sdk.b.a.ymk.d(this.uxT);
    if (this.uxS != null)
    {
      this.uxS.clear();
      this.uxS = null;
    }
    AppMethodBeat.o(48003);
  }
  
  public static abstract interface a
  {
    public abstract void am(Map<String, com.tencent.mm.plugin.wallet_core.model.g> paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.a
 * JD-Core Version:    0.7.0.1
 */