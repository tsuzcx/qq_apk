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
import com.tencent.mm.model.ba;
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
  private static long JQW = 0L;
  private static int mScreenHeight;
  private static int mScreenWidth = 0;
  SparseArray<String> JQT;
  a JQU;
  protected f<String, Bitmap> JQV;
  private LinkedList<Integer> JQX;
  private LinkedList<Integer> JQY;
  private int afo;
  private ap gIf;
  private be hQF;
  private int mScrollState;
  SparseArray<WeakReference<View>> tOa;
  HashMap<String, Integer> tOb;
  SparseArray<String> tOc;
  SparseArray<Bitmap> tOd;
  protected f<String, Bitmap> tOe;
  protected SparseIntArray tOf;
  private LinkedList<String> tOg;
  private boolean tOi;
  Bitmap ywr;
  
  static
  {
    mScreenHeight = 0;
  }
  
  public e(a parama)
  {
    AppMethodBeat.i(36058);
    this.hQF = new be(1, "chatting-image-gallery-lazy-loader");
    this.tOa = new SparseArray();
    this.tOb = new HashMap();
    this.tOc = new SparseArray();
    this.tOd = new SparseArray();
    this.JQT = new SparseArray();
    this.mScrollState = 0;
    this.afo = -1;
    this.JQV = new com.tencent.mm.memory.a.b(400, new f.b() {}, getClass());
    this.tOe = new com.tencent.mm.memory.a.b(5, new f.b() {}, getClass());
    this.JQX = new LinkedList();
    this.tOf = new SparseIntArray();
    this.tOg = new LinkedList();
    this.JQY = new LinkedList();
    this.gIf = new ap();
    this.tOi = false;
    this.JQU = parama;
    AppMethodBeat.o(36058);
  }
  
  private void Ht(int paramInt)
  {
    AppMethodBeat.i(36063);
    if (this.tOc.get(paramInt) != null)
    {
      String str = (String)this.tOc.get(paramInt);
      this.tOa.remove(paramInt);
      this.tOc.remove(paramInt);
      this.tOb.remove(str);
      this.tOd.remove(paramInt);
    }
    AppMethodBeat.o(36063);
  }
  
  private void Hu(final int paramInt)
  {
    AppMethodBeat.i(36062);
    if (this.JQV.aM(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(36062);
      return;
    }
    ba.ajF().n(new Runnable()
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
        final Bitmap localBitmap = e.b(e.this).adJ(paramInt);
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
            e.this.JQV.put(e.5.this.vb, localBitmap);
            AppMethodBeat.o(36051);
          }
        });
        AppMethodBeat.o(36052);
      }
    }, 300L);
    AppMethodBeat.o(36062);
  }
  
  private void Ox()
  {
    AppMethodBeat.i(36069);
    if (this.tOi)
    {
      AppMethodBeat.o(36069);
      return;
    }
    if (this.tOg.size() == 0)
    {
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject = (String)this.tOg.removeLast();
    final int i = ((Integer)this.JQY.removeLast()).intValue();
    if (!this.tOb.containsKey(localObject))
    {
      AppMethodBeat.o(36069);
      return;
    }
    this.tOi = true;
    localObject = new be.a()
    {
      private boolean JRc = false;
      private Bitmap tOk = null;
      
      public final boolean aEm()
      {
        AppMethodBeat.i(36055);
        if ((e.b(e.this) == null) || (TextUtils.isEmpty(this.leT)))
        {
          AppMethodBeat.o(36055);
          return false;
        }
        try
        {
          if (e.e(e.this).containsKey(this.leT))
          {
            int i = ((Integer)e.e(e.this).get(this.leT)).intValue();
            Object localObject = (WeakReference)e.i(e.this).get(i);
            if (localObject != null)
            {
              localObject = (View)((WeakReference)localObject).get();
              if ((localObject != null) && ((localObject instanceof WxImageView)))
              {
                final String str = (String)e.j(e.this).get(i);
                this.JRc = true;
                e.c(e.this).post(new Runnable()
                {
                  public final void run()
                  {
                    boolean bool2 = true;
                    AppMethodBeat.i(36053);
                    e.6 local6 = e.6.this;
                    WxImageView localWxImageView = (WxImageView)this.val$view;
                    String str = e.6.this.leT;
                    Object localObject = str;
                    int i = e.6.this.JRd;
                    boolean bool1;
                    if ((e.b(local6.JQZ) != null) && (localWxImageView != null) && (!bt.isNullOrNil(str)))
                    {
                      int j = e.k(local6.JQZ);
                      if (e.l(local6.JQZ) != null) {
                        break label232;
                      }
                      bool1 = true;
                      if ((e.l(local6.JQZ) == null) || (!e.l(local6.JQZ).isRecycled())) {
                        break label237;
                      }
                      label117:
                      ad.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                      if ((i != e.k(local6.JQZ)) || (e.l(local6.JQZ) == null) || (e.l(local6.JQZ).isRecycled())) {
                        break label243;
                      }
                      localObject = a.l(e.l(local6.JQZ));
                    }
                    for (;;)
                    {
                      e.b(local6.JQZ).a(localWxImageView, str, (a)localObject);
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
                        localObject = a.aP((String)localObject);
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
          this.tOk = e.b(e.this).aWp(this.leT);
          AppMethodBeat.o(36055);
          return true;
        }
        catch (Exception localException)
        {
          ad.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.tOk = null;
          AppMethodBeat.o(36055);
        }
        return false;
      }
      
      public final boolean aEn()
      {
        AppMethodBeat.i(36054);
        e.d(e.this);
        if (!this.JRc) {
          if (e.e(e.this).containsKey(this.leT))
          {
            i = ((Integer)e.e(e.this).get(this.leT)).intValue();
            if (e.f(e.this)) {
              break label168;
            }
            e.g(e.this).put(i, this.tOk);
          }
        }
        Object localObject;
        int j;
        for (;;)
        {
          e.this.w(this.leT, this.tOk);
          e.this.e(i, this.tOk);
          localObject = this.tOk;
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            break;
          }
          j = 0;
          ad.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.tOk = null;
          e.h(e.this);
          AppMethodBeat.o(36054);
          return false;
          label168:
          e.a(e.this, i, this.tOk);
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
    this.hQF.c((be.a)localObject);
    AppMethodBeat.o(36069);
  }
  
  private void a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(36064);
    this.tOb.put(paramString, Integer.valueOf(paramInt));
    this.tOc.put(paramInt, paramString);
    this.tOa.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(36064);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36065);
    if (this.tOa.get(paramInt) == null)
    {
      AppMethodBeat.o(36065);
      return;
    }
    View localView = (View)((WeakReference)this.tOa.get(paramInt)).get();
    String str = (String)this.tOc.get(paramInt);
    this.JQU.a(localView, str, paramBitmap);
    Ht(paramInt);
    AppMethodBeat.o(36065);
  }
  
  private boolean cWh()
  {
    return this.mScrollState == 0;
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(36067);
    if (this.tOg.contains(paramString1))
    {
      AppMethodBeat.o(36067);
      return;
    }
    int i = paramView.hashCode();
    Ht(i);
    a(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.JQT.remove(i);
      this.JQT.put(i, paramString2);
    }
    this.tOg.add(paramString1);
    this.JQY.add(Integer.valueOf(paramInt));
    Ox();
    AppMethodBeat.o(36067);
  }
  
  public final void bU(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(36057);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.tOe.put(str, localBitmap);
        this.JQX.push(Integer.valueOf(localBitmap.hashCode()));
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
    Bitmap localBitmap = (Bitmap)this.JQV.aL(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.JQU.a(paramImageView, null, localBitmap);
      AppMethodBeat.o(36066);
      return true;
    }
    AppMethodBeat.o(36066);
    return false;
  }
  
  final void cWg()
  {
    AppMethodBeat.i(36059);
    this.JQV.a(new f.a() {});
    this.tOe.a(new f.a() {});
    AppMethodBeat.o(36059);
  }
  
  public final void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36070);
    if ((paramInt == this.afo) || (this.afo == -1))
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.ywr = paramBitmap;
    }
    AppMethodBeat.o(36070);
  }
  
  public final void f(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(36068);
    if (this.tOg.contains(paramString))
    {
      AppMethodBeat.o(36068);
      return;
    }
    int i = paramImageView.hashCode();
    Ht(i);
    a(i, paramImageView, paramString);
    this.tOg.add(paramString);
    this.JQY.add(Integer.valueOf(paramInt));
    Ox();
    AppMethodBeat.o(36068);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(36060);
    this.mScrollState = paramInt;
    if (cWh())
    {
      int[] arrayOfInt = new int[this.tOd.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.tOd.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.tOd.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(36060);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(36061);
    if (!((d)this.JQU).JPj.JPl.bdb)
    {
      AppMethodBeat.o(36061);
      return;
    }
    if (this.afo == -1)
    {
      int i = 0;
      if (i == 0) {
        Hu(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          Hu(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Hu(paramInt - i);
        }
      }
    }
    if (this.afo > paramInt) {
      Hu(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.afo = paramInt;
      localObject = (d)this.JQU;
      if (localObject == null) {
        break label223;
      }
      if (((d)localObject).JPj.Hq(this.afo) == null) {
        break;
      }
      this.ywr = null;
      AppMethodBeat.o(36061);
      return;
      if (this.afo < paramInt) {
        Hu(paramInt + 3);
      }
    }
    Object localObject = ((d)localObject).JPj.Hr(this.afo);
    if (localObject != null) {
      this.ywr = ((WxImageView)localObject).getFullImageBitmap();
    }
    label223:
    AppMethodBeat.o(36061);
  }
  
  protected final void w(String paramString, Bitmap paramBitmap)
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
        JQW = mScreenWidth * JQW;
      }
      if (l1 * l2 <= JQW * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(36056);
      return;
    }
    this.tOe.q(paramString, paramBitmap);
    if (g.a.JRj.tOe.aM(paramString))
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        g.a.JRj.tOe.q(paramString, paramBitmap);
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
    public abstract void a(View paramView, String paramString, Bitmap paramBitmap);
    
    public abstract void a(WxImageView paramWxImageView, String paramString, a parama);
    
    public abstract Bitmap aWp(String paramString);
    
    public abstract Bitmap adJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */