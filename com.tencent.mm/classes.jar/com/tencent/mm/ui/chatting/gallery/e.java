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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static long IbE = 0L;
  private static int mScreenHeight;
  private static int mScreenWidth = 0;
  SparseArray<String> IbB;
  a IbC;
  protected f<String, Bitmap> IbD;
  private LinkedList<Integer> IbF;
  private LinkedList<Integer> IbG;
  private int adx;
  private ao gox;
  private bd hyl;
  private int mScrollState;
  protected f<String, Bitmap> sRA;
  protected SparseIntArray sRB;
  private LinkedList<String> sRC;
  private boolean sRE;
  SparseArray<WeakReference<View>> sRw;
  HashMap<String, Integer> sRx;
  SparseArray<String> sRy;
  SparseArray<Bitmap> sRz;
  Bitmap xio;
  
  static
  {
    mScreenHeight = 0;
  }
  
  public e(a parama)
  {
    AppMethodBeat.i(36058);
    this.hyl = new bd(1, "chatting-image-gallery-lazy-loader");
    this.sRw = new SparseArray();
    this.sRx = new HashMap();
    this.sRy = new SparseArray();
    this.sRz = new SparseArray();
    this.IbB = new SparseArray();
    this.mScrollState = 0;
    this.adx = -1;
    this.IbD = new com.tencent.mm.memory.a.b(400, new f.b() {}, getClass());
    this.sRA = new com.tencent.mm.memory.a.b(5, new f.b() {}, getClass());
    this.IbF = new LinkedList();
    this.sRB = new SparseIntArray();
    this.sRC = new LinkedList();
    this.IbG = new LinkedList();
    this.gox = new ao();
    this.sRE = false;
    this.IbC = parama;
    AppMethodBeat.o(36058);
  }
  
  private void Ge(int paramInt)
  {
    AppMethodBeat.i(36063);
    if (this.sRy.get(paramInt) != null)
    {
      String str = (String)this.sRy.get(paramInt);
      this.sRw.remove(paramInt);
      this.sRy.remove(paramInt);
      this.sRx.remove(str);
      this.sRz.remove(paramInt);
    }
    AppMethodBeat.o(36063);
  }
  
  private void Gf(final int paramInt)
  {
    AppMethodBeat.i(36062);
    if (this.IbD.aK(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(36062);
      return;
    }
    az.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36052);
        if (e.b(e.this) == null)
        {
          ac.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
          AppMethodBeat.o(36052);
          return;
        }
        final Bitmap localBitmap = e.b(e.this).abx(paramInt);
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
            e.this.IbD.put(e.5.this.ti, localBitmap);
            AppMethodBeat.o(36051);
          }
        });
        AppMethodBeat.o(36052);
      }
    }, 300L);
    AppMethodBeat.o(36062);
  }
  
  private void MO()
  {
    AppMethodBeat.i(36069);
    if (this.sRE)
    {
      AppMethodBeat.o(36069);
      return;
    }
    if (this.sRC.size() == 0)
    {
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject = (String)this.sRC.removeLast();
    final int i = ((Integer)this.IbG.removeLast()).intValue();
    if (!this.sRx.containsKey(localObject))
    {
      AppMethodBeat.o(36069);
      return;
    }
    this.sRE = true;
    localObject = new bd.a()
    {
      private boolean IbK = false;
      private Bitmap sRG = null;
      
      public final boolean aBj()
      {
        AppMethodBeat.i(36055);
        if ((e.b(e.this) == null) || (TextUtils.isEmpty(this.kIA)))
        {
          AppMethodBeat.o(36055);
          return false;
        }
        try
        {
          if (e.e(e.this).containsKey(this.kIA))
          {
            int i = ((Integer)e.e(e.this).get(this.kIA)).intValue();
            Object localObject = (WeakReference)e.i(e.this).get(i);
            if (localObject != null)
            {
              localObject = (View)((WeakReference)localObject).get();
              if ((localObject != null) && ((localObject instanceof WxImageView)))
              {
                final String str = (String)e.j(e.this).get(i);
                this.IbK = true;
                e.c(e.this).post(new Runnable()
                {
                  public final void run()
                  {
                    boolean bool2 = true;
                    AppMethodBeat.i(36053);
                    e.6 local6 = e.6.this;
                    WxImageView localWxImageView = (WxImageView)this.val$view;
                    String str = e.6.this.kIA;
                    Object localObject = str;
                    int i = e.6.this.IbL;
                    boolean bool1;
                    if ((e.b(local6.IbH) != null) && (localWxImageView != null) && (!bs.isNullOrNil(str)))
                    {
                      int j = e.k(local6.IbH);
                      if (e.l(local6.IbH) != null) {
                        break label232;
                      }
                      bool1 = true;
                      if ((e.l(local6.IbH) == null) || (!e.l(local6.IbH).isRecycled())) {
                        break label237;
                      }
                      label117:
                      ac.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo loadWxImageView position: %d, mLastPosition: %d, previewBitmap == null: %b, recycle: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
                      if ((i != e.k(local6.IbH)) || (e.l(local6.IbH) == null) || (e.l(local6.IbH).isRecycled())) {
                        break label243;
                      }
                      localObject = a.l(e.l(local6.IbH));
                    }
                    for (;;)
                    {
                      e.b(local6.IbH).a(localWxImageView, str, (a)localObject);
                      AppMethodBeat.o(36053);
                      return;
                      label232:
                      bool1 = false;
                      break;
                      label237:
                      bool2 = false;
                      break label117;
                      label243:
                      if (!bs.isNullOrNil((String)localObject)) {
                        localObject = a.W((String)localObject);
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
          this.sRG = e.b(e.this).aQw(this.kIA);
          AppMethodBeat.o(36055);
          return true;
        }
        catch (Exception localException)
        {
          ac.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.sRG = null;
          AppMethodBeat.o(36055);
        }
        return false;
      }
      
      public final boolean aBk()
      {
        AppMethodBeat.i(36054);
        e.d(e.this);
        if (!this.IbK) {
          if (e.e(e.this).containsKey(this.kIA))
          {
            i = ((Integer)e.e(e.this).get(this.kIA)).intValue();
            if (e.f(e.this)) {
              break label168;
            }
            e.g(e.this).put(i, this.sRG);
          }
        }
        Object localObject;
        int j;
        for (;;)
        {
          e.this.w(this.kIA, this.sRG);
          e.this.e(i, this.sRG);
          localObject = this.sRG;
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            break;
          }
          j = 0;
          ac.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.sRG = null;
          e.h(e.this);
          AppMethodBeat.o(36054);
          return false;
          label168:
          e.a(e.this, i, this.sRG);
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
    this.hyl.c((bd.a)localObject);
    AppMethodBeat.o(36069);
  }
  
  private void a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(36064);
    this.sRx.put(paramString, Integer.valueOf(paramInt));
    this.sRy.put(paramInt, paramString);
    this.sRw.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(36064);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36065);
    if (this.sRw.get(paramInt) == null)
    {
      AppMethodBeat.o(36065);
      return;
    }
    View localView = (View)((WeakReference)this.sRw.get(paramInt)).get();
    this.sRy.get(paramInt);
    this.IbC.b(localView, paramBitmap);
    Ge(paramInt);
    AppMethodBeat.o(36065);
  }
  
  private boolean cNP()
  {
    return this.mScrollState == 0;
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(36067);
    if (this.sRC.contains(paramString1))
    {
      AppMethodBeat.o(36067);
      return;
    }
    int i = paramView.hashCode();
    Ge(i);
    a(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.IbB.remove(i);
      this.IbB.put(i, paramString2);
    }
    this.sRC.add(paramString1);
    this.IbG.add(Integer.valueOf(paramInt));
    MO();
    AppMethodBeat.o(36067);
  }
  
  public final void bQ(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(36057);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.sRA.put(str, localBitmap);
        this.IbF.push(Integer.valueOf(localBitmap.hashCode()));
        ac.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        ac.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    AppMethodBeat.o(36057);
  }
  
  public final boolean c(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(36066);
    ac.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.IbD.aJ(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.IbC.b(paramImageView, localBitmap);
      AppMethodBeat.o(36066);
      return true;
    }
    AppMethodBeat.o(36066);
    return false;
  }
  
  final void cNO()
  {
    AppMethodBeat.i(36059);
    this.IbD.a(new f.a() {});
    this.sRA.a(new f.a() {});
    AppMethodBeat.o(36059);
  }
  
  public final void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36070);
    if ((paramInt == this.adx) || (this.adx == -1))
    {
      ac.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.xio = paramBitmap;
    }
    AppMethodBeat.o(36070);
  }
  
  public final void f(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(36068);
    if (this.sRC.contains(paramString))
    {
      AppMethodBeat.o(36068);
      return;
    }
    int i = paramImageView.hashCode();
    Ge(i);
    a(i, paramImageView, paramString);
    this.sRC.add(paramString);
    this.IbG.add(Integer.valueOf(paramInt));
    MO();
    AppMethodBeat.o(36068);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(36060);
    this.mScrollState = paramInt;
    if (cNP())
    {
      int[] arrayOfInt = new int[this.sRz.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.sRz.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.sRz.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(36060);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(36061);
    if (!((d)this.IbC).HZU.HZW.aSG)
    {
      AppMethodBeat.o(36061);
      return;
    }
    if (this.adx == -1)
    {
      int i = 0;
      if (i == 0) {
        Gf(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          Gf(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Gf(paramInt - i);
        }
      }
    }
    if (this.adx > paramInt) {
      Gf(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.adx = paramInt;
      localObject = (d)this.IbC;
      if (localObject == null) {
        break label223;
      }
      if (((d)localObject).HZU.Gb(this.adx) == null) {
        break;
      }
      this.xio = null;
      AppMethodBeat.o(36061);
      return;
      if (this.adx < paramInt) {
        Gf(paramInt + 3);
      }
    }
    Object localObject = ((d)localObject).HZU.Gc(this.adx);
    if (localObject != null) {
      this.xio = ((WxImageView)localObject).getFullImageBitmap();
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
        mScreenWidth = ai.getContext().getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = ai.getContext().getResources().getDisplayMetrics().heightPixels;
        IbE = mScreenWidth * IbE;
      }
      if (l1 * l2 <= IbE * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      ac.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(36056);
      return;
    }
    this.sRA.o(paramString, paramBitmap);
    if (g.a.IbR.sRA.aK(paramString))
    {
      ac.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        g.a.IbR.sRA.o(paramString, paramBitmap);
        AppMethodBeat.o(36056);
        return;
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", paramString, "update preload cache failed", new Object[0]);
      }
    }
    AppMethodBeat.o(36056);
  }
  
  public static abstract interface a
  {
    public abstract void a(WxImageView paramWxImageView, String paramString, a parama);
    
    public abstract Bitmap aQw(String paramString);
    
    public abstract Bitmap abx(int paramInt);
    
    public abstract void b(View paramView, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */