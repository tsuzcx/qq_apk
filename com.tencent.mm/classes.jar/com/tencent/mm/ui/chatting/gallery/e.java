package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.davemorrissey.labs.subscaleview.view.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.be.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

final class e
  implements ViewPager.OnPageChangeListener
{
  private static long GBJ = 0L;
  private static int mScreenHeight;
  private static int mScreenWidth = 0;
  SparseArray<String> GBG;
  a GBH;
  protected f<String, Bitmap> GBI;
  private LinkedList<Integer> GBK;
  private LinkedList<Integer> GBL;
  Bitmap GBM;
  private int acD;
  private ap gAC;
  private be gXM;
  private int mScrollState;
  SparseArray<WeakReference<View>> rJH;
  HashMap<String, Integer> rJI;
  SparseArray<String> rJJ;
  SparseArray<Bitmap> rJK;
  protected f<String, Bitmap> rJL;
  protected SparseIntArray rJM;
  private LinkedList<String> rJN;
  private boolean rJP;
  
  static
  {
    mScreenHeight = 0;
  }
  
  public e(a parama)
  {
    AppMethodBeat.i(36058);
    this.gXM = new be(1, "chatting-image-gallery-lazy-loader");
    this.rJH = new SparseArray();
    this.rJI = new HashMap();
    this.rJJ = new SparseArray();
    this.rJK = new SparseArray();
    this.GBG = new SparseArray();
    this.mScrollState = 0;
    this.acD = -1;
    this.GBI = new com.tencent.mm.memory.a.b(400, new f.b() {}, getClass());
    this.rJL = new com.tencent.mm.memory.a.b(5, new f.b() {}, getClass());
    this.GBK = new LinkedList();
    this.rJM = new SparseIntArray();
    this.rJN = new LinkedList();
    this.GBL = new LinkedList();
    this.gAC = new ap();
    this.rJP = false;
    this.GBH = parama;
    AppMethodBeat.o(36058);
  }
  
  private void Ei(int paramInt)
  {
    AppMethodBeat.i(36063);
    if (this.rJJ.get(paramInt) != null)
    {
      String str = (String)this.rJJ.get(paramInt);
      this.rJH.remove(paramInt);
      this.rJJ.remove(paramInt);
      this.rJI.remove(str);
      this.rJK.remove(paramInt);
    }
    AppMethodBeat.o(36063);
  }
  
  private void Ej(final int paramInt)
  {
    AppMethodBeat.i(36062);
    if (this.GBI.aN(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(36062);
      return;
    }
    az.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36052);
        if (e.b(e.this) == null)
        {
          ad.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
          AppMethodBeat.o(36052);
          return;
        }
        final Bitmap localBitmap = e.b(e.this).Zl(paramInt);
        if (localBitmap == null)
        {
          AppMethodBeat.o(36052);
          return;
        }
        e.c(e.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36051);
            e.this.GBI.put(e.5.this.si, localBitmap);
            AppMethodBeat.o(36051);
          }
        });
        AppMethodBeat.o(36052);
      }
    }, 300L);
    AppMethodBeat.o(36062);
  }
  
  private void MQ()
  {
    AppMethodBeat.i(36069);
    if (this.rJP)
    {
      AppMethodBeat.o(36069);
      return;
    }
    if (this.rJN.size() == 0)
    {
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject = (String)this.rJN.removeLast();
    final int i = ((Integer)this.GBL.removeLast()).intValue();
    if (!this.rJI.containsKey(localObject))
    {
      AppMethodBeat.o(36069);
      return;
    }
    this.rJP = true;
    localObject = new be.a()
    {
      private boolean GBQ = false;
      private Bitmap rJR = null;
      
      public final boolean aus()
      {
        AppMethodBeat.i(36055);
        if ((e.b(e.this) == null) || (TextUtils.isEmpty(this.khI)))
        {
          AppMethodBeat.o(36055);
          return false;
        }
        try
        {
          if (e.e(e.this).containsKey(this.khI))
          {
            int i = ((Integer)e.e(e.this).get(this.khI)).intValue();
            Object localObject = (WeakReference)e.i(e.this).get(i);
            if (localObject != null)
            {
              localObject = (View)((WeakReference)localObject).get();
              if ((localObject != null) && ((localObject instanceof WxImageView)))
              {
                final String str = (String)e.j(e.this).get(i);
                this.GBQ = true;
                e.c(e.this).post(new Runnable()
                {
                  public final void run()
                  {
                    boolean bool2 = true;
                    AppMethodBeat.i(36053);
                    e.6 local6 = e.6.this;
                    WxImageView localWxImageView = (WxImageView)this.val$view;
                    String str = e.6.this.khI;
                    Object localObject = str;
                    int i = e.6.this.GBR;
                    boolean bool1;
                    if ((e.b(local6.GBN) != null) && (localWxImageView != null) && (!bt.isNullOrNil(str)))
                    {
                      int j = e.k(local6.GBN);
                      if (e.l(local6.GBN) != null) {
                        break label232;
                      }
                      bool1 = true;
                      if ((e.l(local6.GBN) == null) || (!e.l(local6.GBN).isRecycled())) {
                        break label237;
                      }
                      label117:
                      ad.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                      if ((i != e.k(local6.GBN)) || (e.l(local6.GBN) == null) || (e.l(local6.GBN).isRecycled())) {
                        break label243;
                      }
                      localObject = a.l(e.l(local6.GBN));
                    }
                    for (;;)
                    {
                      e.b(local6.GBN).a(localWxImageView, str, (a)localObject);
                      AppMethodBeat.o(36053);
                      return;
                      label232:
                      bool1 = false;
                      break;
                      label237:
                      bool2 = false;
                      break label117;
                      label243:
                      if (!bt.isNullOrNil((String)localObject)) {
                        localObject = a.U((String)localObject);
                      } else {
                        localObject = null;
                      }
                    }
                  }
                });
                AppMethodBeat.o(36055);
                return true;
              }
            }
          }
          this.rJR = e.b(e.this).loadImage(this.khI);
          AppMethodBeat.o(36055);
          return true;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.rJR = null;
          AppMethodBeat.o(36055);
        }
        return false;
      }
      
      public final boolean aut()
      {
        AppMethodBeat.i(36054);
        e.d(e.this);
        if (!this.GBQ) {
          if (e.e(e.this).containsKey(this.khI))
          {
            i = ((Integer)e.e(e.this).get(this.khI)).intValue();
            if (e.f(e.this)) {
              break label168;
            }
            e.g(e.this).put(i, this.rJR);
          }
        }
        Object localObject;
        int j;
        for (;;)
        {
          e.this.x(this.khI, this.rJR);
          e.this.e(i, this.rJR);
          localObject = this.rJR;
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            break;
          }
          j = 0;
          ad.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.rJR = null;
          e.h(e.this);
          AppMethodBeat.o(36054);
          return false;
          label168:
          e.a(e.this, i, this.rJR);
        }
        if (Build.VERSION.SDK_INT >= 12) {}
        for (int i = ((Bitmap)localObject).getByteCount();; i = ((Bitmap)localObject).getRowBytes() * ((Bitmap)localObject).getHeight())
        {
          j = i;
          if (i >= 0) {
            break;
          }
          localObject = new IllegalStateException("Negative size: ".concat(String.valueOf(localObject)));
          AppMethodBeat.o(36054);
          throw ((Throwable)localObject);
        }
      }
    };
    this.gXM.c((be.a)localObject);
    AppMethodBeat.o(36069);
  }
  
  private void a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(36064);
    this.rJI.put(paramString, Integer.valueOf(paramInt));
    this.rJJ.put(paramInt, paramString);
    this.rJH.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(36064);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36065);
    if (this.rJH.get(paramInt) == null)
    {
      AppMethodBeat.o(36065);
      return;
    }
    View localView = (View)((WeakReference)this.rJH.get(paramInt)).get();
    this.rJJ.get(paramInt);
    this.GBH.b(localView, paramBitmap);
    Ei(paramInt);
    AppMethodBeat.o(36065);
  }
  
  private boolean cAF()
  {
    return this.mScrollState == 0;
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(36067);
    if (this.rJN.contains(paramString1))
    {
      AppMethodBeat.o(36067);
      return;
    }
    int i = paramView.hashCode();
    Ei(i);
    a(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.GBG.remove(i);
      this.GBG.put(i, paramString2);
    }
    this.rJN.add(paramString1);
    this.GBL.add(Integer.valueOf(paramInt));
    MQ();
    AppMethodBeat.o(36067);
  }
  
  public final void bL(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(36057);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.rJL.put(str, localBitmap);
        this.GBK.push(Integer.valueOf(localBitmap.hashCode()));
        ad.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        ad.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    AppMethodBeat.o(36057);
  }
  
  public final boolean c(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(36066);
    ad.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.GBI.aM(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.GBH.b(paramImageView, localBitmap);
      AppMethodBeat.o(36066);
      return true;
    }
    AppMethodBeat.o(36066);
    return false;
  }
  
  final void cAE()
  {
    AppMethodBeat.i(36059);
    this.GBI.a(new f.a() {});
    this.rJL.a(new f.a() {});
    AppMethodBeat.o(36059);
  }
  
  public final void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36070);
    if ((paramInt == this.acD) || (this.acD == -1))
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.GBM = paramBitmap;
    }
    AppMethodBeat.o(36070);
  }
  
  public final void f(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(36068);
    if (this.rJN.contains(paramString))
    {
      AppMethodBeat.o(36068);
      return;
    }
    int i = paramImageView.hashCode();
    Ei(i);
    a(i, paramImageView, paramString);
    this.rJN.add(paramString);
    this.GBL.add(Integer.valueOf(paramInt));
    MQ();
    AppMethodBeat.o(36068);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(36060);
    this.mScrollState = paramInt;
    if (cAF())
    {
      int[] arrayOfInt = new int[this.rJK.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.rJK.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.rJK.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(36060);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(36061);
    if (!((d)this.GBH).GzZ.GAb.aRL)
    {
      AppMethodBeat.o(36061);
      return;
    }
    if (this.acD == -1)
    {
      int i = 0;
      if (i == 0) {
        Ej(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          Ej(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Ej(paramInt - i);
        }
      }
    }
    if (this.acD > paramInt) {
      Ej(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.acD = paramInt;
      localObject = (d)this.GBH;
      if (localObject == null) {
        break label223;
      }
      if (((d)localObject).GzZ.Ef(this.acD) == null) {
        break;
      }
      this.GBM = null;
      AppMethodBeat.o(36061);
      return;
      if (this.acD < paramInt) {
        Ej(paramInt + 3);
      }
    }
    Object localObject = ((d)localObject).GzZ.Eg(this.acD);
    if (localObject != null) {
      this.GBM = ((WxImageView)localObject).getFullImageBitmap();
    }
    label223:
    AppMethodBeat.o(36061);
  }
  
  protected final void x(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36056);
    if (paramBitmap != null)
    {
      long l1 = paramBitmap.getWidth();
      long l2 = paramBitmap.getHeight();
      if ((mScreenHeight == 0) || (mScreenWidth == 0))
      {
        mScreenWidth = aj.getContext().getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = aj.getContext().getResources().getDisplayMetrics().heightPixels;
        GBJ = mScreenWidth * GBJ;
      }
      if (l1 * l2 <= GBJ * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(36056);
      return;
    }
    this.rJL.o(paramString, paramBitmap);
    if (g.a.GBX.rJL.aN(paramString))
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        g.a.GBX.rJL.o(paramString, paramBitmap);
        AppMethodBeat.o(36056);
        return;
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", paramString, "update preload cache failed", new Object[0]);
      }
    }
    AppMethodBeat.o(36056);
  }
  
  public static abstract interface a
  {
    public abstract Bitmap Zl(int paramInt);
    
    public abstract void a(WxImageView paramWxImageView, String paramString, a parama);
    
    public abstract void b(View paramView, Bitmap paramBitmap);
    
    public abstract Bitmap loadImage(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */