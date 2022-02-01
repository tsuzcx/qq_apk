package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f.a;
import com.tencent.mm.b.f.b;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread;
import com.tencent.mm.sdk.platformtools.QueueWorkerThread.ThreadObject;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

final class k
  implements ViewPager.OnPageChangeListener
{
  private static long aeCg = 0L;
  private static int mScreenHeight;
  private static int mScreenWidth = 0;
  SparseArray<WeakReference<View>> HOD;
  HashMap<String, Integer> HOE;
  SparseArray<String> HOF;
  SparseArray<Bitmap> HOG;
  protected com.tencent.mm.b.f<String, Bitmap> HOH;
  protected SparseIntArray HOI;
  private LinkedList<String> HOJ;
  private boolean HOL;
  SparseArray<String> aeCd;
  f aeCe;
  protected com.tencent.mm.b.f<String, Bitmap> aeCf;
  private LinkedList<Integer> aeCh;
  private LinkedList<Integer> aeCi;
  private int mI;
  private MMHandler mRi;
  private int mScrollState;
  Bitmap mVG;
  private QueueWorkerThread owH;
  
  static
  {
    mScreenHeight = 0;
  }
  
  public k(f paramf)
  {
    AppMethodBeat.i(254445);
    this.owH = new QueueWorkerThread(1, "chatting-image-gallery-lazy-loader");
    this.HOD = new SparseArray();
    this.HOE = new HashMap();
    this.HOF = new SparseArray();
    this.HOG = new SparseArray();
    this.aeCd = new SparseArray();
    this.mScrollState = 0;
    this.mI = -1;
    this.aeCf = new b(400, new f.b() {}, getClass());
    this.HOH = new b(5, new f.b() {}, getClass());
    this.aeCh = new LinkedList();
    this.HOI = new SparseIntArray();
    this.HOJ = new LinkedList();
    this.aeCi = new LinkedList();
    this.mRi = new MMHandler();
    this.HOL = false;
    this.aeCe = paramf;
    AppMethodBeat.o(254445);
  }
  
  private void WQ(int paramInt)
  {
    AppMethodBeat.i(36063);
    if (this.HOF.get(paramInt) != null)
    {
      String str = (String)this.HOF.get(paramInt);
      this.HOD.remove(paramInt);
      this.HOF.remove(paramInt);
      this.HOE.remove(str);
      this.HOG.remove(paramInt);
    }
    AppMethodBeat.o(36063);
  }
  
  private void WR(final int paramInt)
  {
    AppMethodBeat.i(36062);
    if (this.aeCf.check(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(36062);
      return;
    }
    bh.baH().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36052);
        if (k.b(k.this) == null)
        {
          Log.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
          AppMethodBeat.o(36052);
          return;
        }
        final Bitmap localBitmap = k.b(k.this).aCv(paramInt);
        if (localBitmap == null)
        {
          AppMethodBeat.o(36052);
          return;
        }
        k.c(k.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36051);
            k.this.aeCf.put(k.5.this.dyI, localBitmap);
            AppMethodBeat.o(36051);
          }
        });
        AppMethodBeat.o(36052);
      }
    }, 300L);
    AppMethodBeat.o(36062);
  }
  
  private void aFi()
  {
    AppMethodBeat.i(36069);
    if (this.HOL)
    {
      AppMethodBeat.o(36069);
      return;
    }
    if (this.HOJ.size() == 0)
    {
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject = (String)this.HOJ.removeLast();
    final int i = ((Integer)this.aeCi.removeLast()).intValue();
    if (!this.HOE.containsKey(localObject))
    {
      AppMethodBeat.o(36069);
      return;
    }
    this.HOL = true;
    localObject = new QueueWorkerThread.ThreadObject()
    {
      private boolean aeCm = false;
      private Bitmap wNk = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(36055);
        if ((k.b(k.this) == null) || (TextUtils.isEmpty(this.srj)))
        {
          AppMethodBeat.o(36055);
          return false;
        }
        try
        {
          if (k.e(k.this).containsKey(this.srj))
          {
            int i = ((Integer)k.e(k.this).get(this.srj)).intValue();
            Object localObject = (WeakReference)k.i(k.this).get(i);
            if (localObject != null)
            {
              localObject = (View)((WeakReference)localObject).get();
              if ((localObject != null) && ((localObject instanceof WxImageView)))
              {
                final String str = (String)k.j(k.this).get(i);
                this.aeCm = true;
                k.c(k.this).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36053);
                    k.6.a(k.6.this, (WxImageView)this.val$view, k.6.this.srj, str, k.6.this.aeCn);
                    AppMethodBeat.o(36053);
                  }
                });
                AppMethodBeat.o(36055);
                return true;
              }
            }
          }
          this.wNk = k.b(k.this).aEY(this.srj);
          AppMethodBeat.o(36055);
          return true;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.wNk = null;
          AppMethodBeat.o(36055);
        }
        return false;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(36054);
        k.d(k.this);
        if (!this.aeCm) {
          if (k.e(k.this).containsKey(this.srj))
          {
            i = ((Integer)k.e(k.this).get(this.srj)).intValue();
            if (k.f(k.this)) {
              break label168;
            }
            k.g(k.this).put(i, this.wNk);
          }
        }
        Object localObject;
        int j;
        for (;;)
        {
          k.this.w(this.srj, this.wNk);
          k.this.g(i, this.wNk);
          localObject = this.wNk;
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            break;
          }
          j = 0;
          Log.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.wNk = null;
          k.h(k.this);
          AppMethodBeat.o(36054);
          return false;
          label168:
          k.a(k.this, i, this.wNk);
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
    this.owH.add((QueueWorkerThread.ThreadObject)localObject);
    AppMethodBeat.o(36069);
  }
  
  private void b(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(36064);
    this.HOE.put(paramString, Integer.valueOf(paramInt));
    this.HOF.put(paramInt, paramString);
    this.HOD.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(36064);
  }
  
  private void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36065);
    if (this.HOD.get(paramInt) == null)
    {
      AppMethodBeat.o(36065);
      return;
    }
    View localView = (View)((WeakReference)this.HOD.get(paramInt)).get();
    String str = (String)this.HOF.get(paramInt);
    this.aeCe.a(0L, localView, str, paramBitmap);
    WQ(paramInt);
    AppMethodBeat.o(36065);
  }
  
  private boolean fBG()
  {
    return this.mScrollState == 0;
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(36067);
    if (this.HOJ.contains(paramString1))
    {
      AppMethodBeat.o(36067);
      return;
    }
    int i = paramView.hashCode();
    WQ(i);
    b(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.aeCd.remove(i);
      this.aeCd.put(i, paramString2);
    }
    this.HOJ.add(paramString1);
    this.aeCi.add(Integer.valueOf(paramInt));
    aFi();
    AppMethodBeat.o(36067);
  }
  
  public final void cL(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(36057);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.HOH.put(str, localBitmap);
        this.aeCh.push(Integer.valueOf(localBitmap.hashCode()));
        Log.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        Log.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    AppMethodBeat.o(36057);
  }
  
  public final boolean e(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(36066);
    Log.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.aeCf.ct(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.aeCe.a(0L, paramImageView, null, localBitmap);
      AppMethodBeat.o(36066);
      return true;
    }
    AppMethodBeat.o(36066);
    return false;
  }
  
  final void fBF()
  {
    AppMethodBeat.i(36059);
    this.aeCf.a(new f.a() {});
    this.HOH.a(new f.a() {});
    AppMethodBeat.o(36059);
  }
  
  public final void g(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36070);
    if ((paramInt == this.mI) || (this.mI == -1))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.mVG = paramBitmap;
    }
    AppMethodBeat.o(36070);
  }
  
  public final void k(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(36068);
    if (this.HOJ.contains(paramString))
    {
      AppMethodBeat.o(36068);
      return;
    }
    int i = paramImageView.hashCode();
    WQ(i);
    b(i, paramImageView, paramString);
    this.HOJ.add(paramString);
    this.aeCi.add(Integer.valueOf(paramInt));
    aFi();
    AppMethodBeat.o(36068);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(36060);
    this.mScrollState = paramInt;
    if (fBG())
    {
      int[] arrayOfInt = new int[this.HOG.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.HOG.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        e(i, (Bitmap)this.HOG.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(36060);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(36061);
    if (!((j)this.aeCe).aeAg.aeAC.cGv)
    {
      AppMethodBeat.o(36061);
      return;
    }
    if (this.mI == -1)
    {
      int i = 0;
      if (i == 0) {
        WR(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          WR(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          WR(paramInt - i);
        }
      }
    }
    if (this.mI > paramInt) {
      WR(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.mI = paramInt;
      localObject = (j)this.aeCe;
      if (localObject == null) {
        break label223;
      }
      if (((j)localObject).aeAg.WN(this.mI) == null) {
        break;
      }
      this.mVG = null;
      AppMethodBeat.o(36061);
      return;
      if (this.mI < paramInt) {
        WR(paramInt + 3);
      }
    }
    Object localObject = ((j)localObject).aeAg.WO(this.mI);
    if (localObject != null) {
      this.mVG = ((WxImageView)localObject).getFullImageBitmap();
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
        mScreenWidth = MMApplicationContext.getContext().getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = MMApplicationContext.getContext().getResources().getDisplayMetrics().heightPixels;
        aeCg = mScreenWidth * aeCg;
      }
      if (l1 * l2 <= aeCg * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(36056);
      return;
    }
    this.HOH.B(paramString, paramBitmap);
    if (m.a.aeCt.HOH.check(paramString))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        m.a.aeCt.HOH.B(paramString, paramBitmap);
        AppMethodBeat.o(36056);
        return;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", paramString, "update preload cache failed", new Object[0]);
      }
    }
    AppMethodBeat.o(36056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k
 * JD-Core Version:    0.7.0.1
 */