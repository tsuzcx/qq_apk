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
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bf.a;
import com.tencent.mm.sdk.platformtools.bu;
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
  private static long Kmh = 0L;
  private static int mScreenHeight;
  private static int mScreenWidth = 0;
  SparseArray<String> Kme;
  a Kmf;
  protected f<String, Bitmap> Kmg;
  private LinkedList<Integer> Kmi;
  private LinkedList<Integer> Kmj;
  private int afo;
  private aq gKO;
  private bf hTx;
  private int mScrollState;
  SparseArray<WeakReference<View>> tYR;
  HashMap<String, Integer> tYS;
  SparseArray<String> tYT;
  SparseArray<Bitmap> tYU;
  protected f<String, Bitmap> tYV;
  protected SparseIntArray tYW;
  private LinkedList<String> tYX;
  private boolean tYZ;
  Bitmap yMr;
  
  static
  {
    mScreenHeight = 0;
  }
  
  public e(a parama)
  {
    AppMethodBeat.i(36058);
    this.hTx = new bf(1, "chatting-image-gallery-lazy-loader");
    this.tYR = new SparseArray();
    this.tYS = new HashMap();
    this.tYT = new SparseArray();
    this.tYU = new SparseArray();
    this.Kme = new SparseArray();
    this.mScrollState = 0;
    this.afo = -1;
    this.Kmg = new com.tencent.mm.memory.a.b(400, new f.b() {}, getClass());
    this.tYV = new com.tencent.mm.memory.a.b(5, new f.b() {}, getClass());
    this.Kmi = new LinkedList();
    this.tYW = new SparseIntArray();
    this.tYX = new LinkedList();
    this.Kmj = new LinkedList();
    this.gKO = new aq();
    this.tYZ = false;
    this.Kmf = parama;
    AppMethodBeat.o(36058);
  }
  
  private void HQ(int paramInt)
  {
    AppMethodBeat.i(36063);
    if (this.tYT.get(paramInt) != null)
    {
      String str = (String)this.tYT.get(paramInt);
      this.tYR.remove(paramInt);
      this.tYT.remove(paramInt);
      this.tYS.remove(str);
      this.tYU.remove(paramInt);
    }
    AppMethodBeat.o(36063);
  }
  
  private void HR(final int paramInt)
  {
    AppMethodBeat.i(36062);
    if (this.Kmg.aM(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(36062);
      return;
    }
    bc.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36052);
        if (e.b(e.this) == null)
        {
          ae.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
          AppMethodBeat.o(36052);
          return;
        }
        final Bitmap localBitmap = e.b(e.this).aeq(paramInt);
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
            e.this.Kmg.put(e.5.this.vb, localBitmap);
            AppMethodBeat.o(36051);
          }
        });
        AppMethodBeat.o(36052);
      }
    }, 300L);
    AppMethodBeat.o(36062);
  }
  
  private void Ov()
  {
    AppMethodBeat.i(36069);
    if (this.tYZ)
    {
      AppMethodBeat.o(36069);
      return;
    }
    if (this.tYX.size() == 0)
    {
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject = (String)this.tYX.removeLast();
    final int i = ((Integer)this.Kmj.removeLast()).intValue();
    if (!this.tYS.containsKey(localObject))
    {
      AppMethodBeat.o(36069);
      return;
    }
    this.tYZ = true;
    localObject = new bf.a()
    {
      private boolean Kmn = false;
      private Bitmap tZb = null;
      
      public final boolean aEC()
      {
        AppMethodBeat.i(36055);
        if ((e.b(e.this) == null) || (TextUtils.isEmpty(this.liF)))
        {
          AppMethodBeat.o(36055);
          return false;
        }
        try
        {
          if (e.e(e.this).containsKey(this.liF))
          {
            int i = ((Integer)e.e(e.this).get(this.liF)).intValue();
            Object localObject = (WeakReference)e.i(e.this).get(i);
            if (localObject != null)
            {
              localObject = (View)((WeakReference)localObject).get();
              if ((localObject != null) && ((localObject instanceof WxImageView)))
              {
                final String str = (String)e.j(e.this).get(i);
                this.Kmn = true;
                e.c(e.this).post(new Runnable()
                {
                  public final void run()
                  {
                    boolean bool2 = true;
                    AppMethodBeat.i(36053);
                    e.6 local6 = e.6.this;
                    WxImageView localWxImageView = (WxImageView)this.val$view;
                    String str = e.6.this.liF;
                    Object localObject = str;
                    int i = e.6.this.Kmo;
                    boolean bool1;
                    if ((e.b(local6.Kmk) != null) && (localWxImageView != null) && (!bu.isNullOrNil(str)))
                    {
                      int j = e.k(local6.Kmk);
                      if (e.l(local6.Kmk) != null) {
                        break label232;
                      }
                      bool1 = true;
                      if ((e.l(local6.Kmk) == null) || (!e.l(local6.Kmk).isRecycled())) {
                        break label237;
                      }
                      label117:
                      ae.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                      if ((i != e.k(local6.Kmk)) || (e.l(local6.Kmk) == null) || (e.l(local6.Kmk).isRecycled())) {
                        break label243;
                      }
                      localObject = a.m(e.l(local6.Kmk));
                    }
                    for (;;)
                    {
                      e.b(local6.Kmk).a(localWxImageView, str, (a)localObject);
                      AppMethodBeat.o(36053);
                      return;
                      label232:
                      bool1 = false;
                      break;
                      label237:
                      bool2 = false;
                      break label117;
                      label243:
                      if (!bu.isNullOrNil((String)localObject)) {
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
          this.tZb = e.b(e.this).aXQ(this.liF);
          AppMethodBeat.o(36055);
          return true;
        }
        catch (Exception localException)
        {
          ae.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.tZb = null;
          AppMethodBeat.o(36055);
        }
        return false;
      }
      
      public final boolean aED()
      {
        AppMethodBeat.i(36054);
        e.d(e.this);
        if (!this.Kmn) {
          if (e.e(e.this).containsKey(this.liF))
          {
            i = ((Integer)e.e(e.this).get(this.liF)).intValue();
            if (e.f(e.this)) {
              break label168;
            }
            e.g(e.this).put(i, this.tZb);
          }
        }
        Object localObject;
        int j;
        for (;;)
        {
          e.this.w(this.liF, this.tZb);
          e.this.e(i, this.tZb);
          localObject = this.tZb;
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            break;
          }
          j = 0;
          ae.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.tZb = null;
          e.h(e.this);
          AppMethodBeat.o(36054);
          return false;
          label168:
          e.a(e.this, i, this.tZb);
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
    this.hTx.c((bf.a)localObject);
    AppMethodBeat.o(36069);
  }
  
  private void a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(36064);
    this.tYS.put(paramString, Integer.valueOf(paramInt));
    this.tYT.put(paramInt, paramString);
    this.tYR.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(36064);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36065);
    if (this.tYR.get(paramInt) == null)
    {
      AppMethodBeat.o(36065);
      return;
    }
    View localView = (View)((WeakReference)this.tYR.get(paramInt)).get();
    String str = (String)this.tYT.get(paramInt);
    this.Kmf.a(0L, localView, str, paramBitmap);
    HQ(paramInt);
    AppMethodBeat.o(36065);
  }
  
  private boolean cYM()
  {
    return this.mScrollState == 0;
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(36067);
    if (this.tYX.contains(paramString1))
    {
      AppMethodBeat.o(36067);
      return;
    }
    int i = paramView.hashCode();
    HQ(i);
    a(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.Kme.remove(i);
      this.Kme.put(i, paramString2);
    }
    this.tYX.add(paramString1);
    this.Kmj.add(Integer.valueOf(paramInt));
    Ov();
    AppMethodBeat.o(36067);
  }
  
  public final boolean c(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(36066);
    ae.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.Kmg.aL(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.Kmf.a(0L, paramImageView, null, localBitmap);
      AppMethodBeat.o(36066);
      return true;
    }
    AppMethodBeat.o(36066);
    return false;
  }
  
  final void cYL()
  {
    AppMethodBeat.i(36059);
    this.Kmg.a(new f.a() {});
    this.tYV.a(new f.a() {});
    AppMethodBeat.o(36059);
  }
  
  public final void ca(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(36057);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.tYV.put(str, localBitmap);
        this.Kmi.push(Integer.valueOf(localBitmap.hashCode()));
        ae.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        ae.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    AppMethodBeat.o(36057);
  }
  
  public final void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36070);
    if ((paramInt == this.afo) || (this.afo == -1))
    {
      ae.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.yMr = paramBitmap;
    }
    AppMethodBeat.o(36070);
  }
  
  public final void f(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(36068);
    if (this.tYX.contains(paramString))
    {
      AppMethodBeat.o(36068);
      return;
    }
    int i = paramImageView.hashCode();
    HQ(i);
    a(i, paramImageView, paramString);
    this.tYX.add(paramString);
    this.Kmj.add(Integer.valueOf(paramInt));
    Ov();
    AppMethodBeat.o(36068);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(36060);
    this.mScrollState = paramInt;
    if (cYM())
    {
      int[] arrayOfInt = new int[this.tYU.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.tYU.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.tYU.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(36060);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(36061);
    if (!((d)this.Kmf).Kkv.Kkx.bdb)
    {
      AppMethodBeat.o(36061);
      return;
    }
    if (this.afo == -1)
    {
      int i = 0;
      if (i == 0) {
        HR(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          HR(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          HR(paramInt - i);
        }
      }
    }
    if (this.afo > paramInt) {
      HR(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.afo = paramInt;
      localObject = (d)this.Kmf;
      if (localObject == null) {
        break label223;
      }
      if (((d)localObject).Kkv.HN(this.afo) == null) {
        break;
      }
      this.yMr = null;
      AppMethodBeat.o(36061);
      return;
      if (this.afo < paramInt) {
        HR(paramInt + 3);
      }
    }
    Object localObject = ((d)localObject).Kkv.HO(this.afo);
    if (localObject != null) {
      this.yMr = ((WxImageView)localObject).getFullImageBitmap();
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
        mScreenWidth = ak.getContext().getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = ak.getContext().getResources().getDisplayMetrics().heightPixels;
        Kmh = mScreenWidth * Kmh;
      }
      if (l1 * l2 <= Kmh * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      ae.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(36056);
      return;
    }
    this.tYV.q(paramString, paramBitmap);
    if (g.a.Kmu.tYV.aM(paramString))
    {
      ae.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        g.a.Kmu.tYV.q(paramString, paramBitmap);
        AppMethodBeat.o(36056);
        return;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", paramString, "update preload cache failed", new Object[0]);
      }
    }
    AppMethodBeat.o(36056);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, View paramView, String paramString, Bitmap paramBitmap);
    
    public abstract void a(WxImageView paramWxImageView, String paramString, a parama);
    
    public abstract Bitmap aXQ(String paramString);
    
    public abstract Bitmap aeq(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */