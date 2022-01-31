package com.tencent.mm.plugin.wallet_core.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.ac;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  public LinkedList<Bankcard> dCr;
  ReentrantLock mLock = new ReentrantLock();
  ArrayList<b> qJk = new ArrayList();
  private com.tencent.mm.sdk.b.c qJl = new a.1(this);
  public LinkedList<String> qJm;
  
  public a()
  {
    com.tencent.mm.sdk.b.a.udP.c(this.qJl);
  }
  
  private static boolean a(Context paramContext, Bankcard paramBankcard)
  {
    if (q.Gw()) {}
    for (paramContext = com.tencent.mm.plugin.wallet_core.d.b.h(paramContext, paramBankcard.field_bankName, false); (paramContext == null) || (paramContext.bgQ); paramContext = com.tencent.mm.plugin.wallet_core.d.b.h(paramContext, paramBankcard.field_bankcardType, paramBankcard.bUP())) {
      return false;
    }
    return true;
  }
  
  public final void a(Context paramContext, Bankcard paramBankcard, ImageView paramImageView)
  {
    a(paramContext, paramBankcard, paramImageView, null, null, null);
  }
  
  public final void a(Context paramContext, Bankcard paramBankcard, ImageView paramImageView1, View paramView, ImageView paramImageView2, TextView paramTextView)
  {
    b localb = new b();
    localb.qJz = false;
    localb.qhv = paramBankcard;
    if (paramImageView1 != null)
    {
      paramImageView1.setTag(a.f.wallet_core_bankcard_logo_helper_tag, paramBankcard.field_bankcardType);
      localb.qJv = new WeakReference(paramImageView1);
    }
    if (paramView != null) {
      localb.qJw = new WeakReference(paramView);
    }
    if (paramImageView2 != null) {
      localb.qJx = new WeakReference(paramImageView2);
    }
    if (paramTextView != null) {
      localb.qJy = new WeakReference(paramTextView);
    }
    this.qJk.add(localb);
    if (q.Gw())
    {
      paramImageView1 = paramBankcard.field_bankName;
      if ((this.qJm == null) || (!this.qJm.contains(paramImageView1))) {
        break label175;
      }
      y.i("MicroMsg.BankcardLogoHelper", "waiting resp:" + paramImageView1);
    }
    label175:
    do
    {
      return;
      paramImageView1 = paramBankcard.field_bankcardType;
      break;
      if (a(paramContext, paramBankcard)) {
        break label227;
      }
      if (this.dCr == null) {
        this.dCr = new LinkedList();
      }
      this.dCr.add(paramBankcard);
    } while (this.qJm != null);
    b(paramContext, this.dCr);
    return;
    label227:
    paramContext = new ac();
    com.tencent.mm.sdk.b.a.udP.m(paramContext);
  }
  
  public final void a(Bankcard paramBankcard, ImageView paramImageView)
  {
    b localb = new b();
    localb.qhv = paramBankcard;
    if (paramImageView != null)
    {
      paramImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, paramBankcard.field_bankcardType);
      localb.qJv = new WeakReference(paramImageView);
    }
    paramImageView = paramBankcard.qtH;
    if ((paramImageView != null) && (localb.qJv != null) && (localb.qJv.get() != null))
    {
      y.d("MicroMsg.BankcardLogoHelper", "bankLogoUrl = " + paramImageView.mEi);
      paramBankcard = (ImageView)localb.qJv.get();
      if (!bk.bl(paramImageView.mEi))
      {
        localb.qFV = paramImageView.mEi;
        localb.qJz = true;
        paramImageView = x.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(paramImageView.mEi));
        if (paramImageView != null) {
          paramBankcard.setImageBitmap(paramImageView);
        }
        x.a(localb);
        return;
      }
      if (paramImageView.qtV > 0)
      {
        paramBankcard.post(new a.6(this, paramBankcard, paramImageView));
        return;
      }
      y.e("MicroMsg.BankcardLogoHelper", "bankcard logoUrl == null");
      return;
    }
    y.e("MicroMsg.BankcardLogoHelper", "bankUrls == null");
  }
  
  public final void b(final Context paramContext, List<Bankcard> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      this.qJm = new LinkedList();
      int i = 0;
      if (i < j)
      {
        Bankcard localBankcard = (Bankcard)paramList.get(i);
        if (localBankcard.bUQ()) {
          y.i("MicroMsg.BankcardLogoHelper", "ignore balance");
        }
        for (;;)
        {
          i += 1;
          break;
          if (!a(paramContext, localBankcard))
          {
            y.i("MicroMsg.BankcardLogoHelper", localBankcard.field_bankcardType + "'s url is null or need update");
            this.qJm.add(localBankcard.field_bankcardType);
          }
        }
      }
      if (this.qJm.size() > 0)
      {
        y.i("MicroMsg.BankcardLogoHelper", "doScene to get bankcard logo");
        paramList = new com.tencent.mm.plugin.wallet_core.c.c(this.qJm);
        g.DQ();
        g.DO().dJT.a(1650, new f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, m paramAnonymousm)
          {
            g.DQ();
            g.DO().dJT.b(1650, this);
            a.this.qJm = null;
            if (a.this.dCr != null)
            {
              a.this.b(paramContext, a.this.dCr);
              a.this.dCr = null;
            }
          }
        });
        g.DQ();
        g.DO().dJT.a(paramList, 0);
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.BankcardLogoHelper", "use cache bankcard logo data");
    paramContext = new ac();
    com.tencent.mm.sdk.b.a.udP.m(paramContext);
  }
  
  public final void destory()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.qJl);
    if (this.qJk != null)
    {
      this.qJk.clear();
      this.qJk = null;
    }
  }
  
  static final class b
    implements x.a
  {
    String qFV;
    WeakReference<ImageView> qJv;
    WeakReference<View> qJw = null;
    WeakReference<ImageView> qJx = null;
    WeakReference<TextView> qJy = null;
    boolean qJz = false;
    Bankcard qhv;
    
    public final void l(String paramString, Bitmap paramBitmap)
    {
      boolean bool2 = true;
      Object localObject = new StringBuilder("onGetPictureFinish ").append(paramString).append(", bitmap = ");
      boolean bool1;
      if (paramBitmap == null)
      {
        bool1 = true;
        y.d("MicroMsg.BankcardLogoHelper", bool1);
        if (!TextUtils.isEmpty(this.qFV)) {
          break label66;
        }
        y.e("MicroMsg.BankcardLogoHelper", "mBankcardLogoUrl is empty");
      }
      label66:
      while (this.qJv == null)
      {
        return;
        bool1 = false;
        break;
      }
      ImageView localImageView = (ImageView)this.qJv.get();
      if (paramBitmap == null)
      {
        bool1 = true;
        label91:
        if (localImageView != null) {
          break label278;
        }
        label96:
        if (localImageView != null) {
          break label284;
        }
      }
      label278:
      label284:
      for (localObject = "";; localObject = localImageView.getTag())
      {
        y.d("MicroMsg.BankcardLogoHelper", "onGetPictureFinish done notifyKey %s  bitmap is null? %s iv is null? %s iv tag: %s mBankcardLogoUrl %s, checkTagType: %s", new Object[] { paramString, Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, this.qFV, Boolean.valueOf(this.qJz) });
        if ((localImageView == null) || (paramString == null) || (!paramString.equals(this.qFV))) {
          break;
        }
        if (!this.qJz) {
          break label294;
        }
        if ((localImageView.getTag(a.f.wallet_core_bankcard_logo_helper_tag) == null) || (this.qhv == null) || (this.qhv.field_bankcardType == null)) {
          break;
        }
        paramString = (String)localImageView.getTag(a.f.wallet_core_bankcard_logo_helper_tag);
        if ((bk.bl(paramString)) || (!paramString.equals(this.qhv.field_bankcardType))) {
          break;
        }
        localImageView.post(new a.b.1(this, localImageView, paramBitmap));
        localImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
        return;
        bool1 = false;
        break label91;
        bool2 = false;
        break label96;
      }
      label294:
      localImageView.post(new a.b.2(this, localImageView, paramBitmap));
      localImageView.setTag(a.f.wallet_core_bankcard_logo_helper_tag, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.e.a
 * JD-Core Version:    0.7.0.1
 */