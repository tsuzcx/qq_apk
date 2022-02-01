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
import com.tencent.mm.model.bg;
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

final class e
  implements ViewPager.OnPageChangeListener
{
  private static long Pye = 0L;
  private static int mScreenHeight;
  private static int mScreenWidth = 0;
  Bitmap CQj;
  SparseArray<String> Pyb;
  a Pyc;
  protected f<String, Bitmap> Pyd;
  private LinkedList<Integer> Pyf;
  private LinkedList<Integer> Pyg;
  private int afB;
  private MMHandler hAk;
  private QueueWorkerThread iOL;
  private int mScrollState;
  SparseArray<WeakReference<View>> xqf;
  HashMap<String, Integer> xqg;
  SparseArray<String> xqh;
  SparseArray<Bitmap> xqi;
  protected f<String, Bitmap> xqj;
  protected SparseIntArray xqk;
  private LinkedList<String> xql;
  private boolean xqn;
  
  static
  {
    mScreenHeight = 0;
  }
  
  public e(a parama)
  {
    AppMethodBeat.i(36058);
    this.iOL = new QueueWorkerThread(1, "chatting-image-gallery-lazy-loader");
    this.xqf = new SparseArray();
    this.xqg = new HashMap();
    this.xqh = new SparseArray();
    this.xqi = new SparseArray();
    this.Pyb = new SparseArray();
    this.mScrollState = 0;
    this.afB = -1;
    this.Pyd = new com.tencent.mm.memory.a.b(400, new f.b() {}, getClass());
    this.xqj = new com.tencent.mm.memory.a.b(5, new f.b() {}, getClass());
    this.Pyf = new LinkedList();
    this.xqk = new SparseIntArray();
    this.xql = new LinkedList();
    this.Pyg = new LinkedList();
    this.hAk = new MMHandler();
    this.xqn = false;
    this.Pyc = parama;
    AppMethodBeat.o(36058);
  }
  
  private void NT(int paramInt)
  {
    AppMethodBeat.i(36063);
    if (this.xqh.get(paramInt) != null)
    {
      String str = (String)this.xqh.get(paramInt);
      this.xqf.remove(paramInt);
      this.xqh.remove(paramInt);
      this.xqg.remove(str);
      this.xqi.remove(paramInt);
    }
    AppMethodBeat.o(36063);
  }
  
  private void NU(final int paramInt)
  {
    AppMethodBeat.i(36062);
    if (this.Pyd.check(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(36062);
      return;
    }
    bg.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36052);
        if (e.b(e.this) == null)
        {
          Log.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
          AppMethodBeat.o(36052);
          return;
        }
        final Bitmap localBitmap = e.b(e.this).ana(paramInt);
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
            e.this.Pyd.put(e.5.this.vi, localBitmap);
            AppMethodBeat.o(36051);
          }
        });
        AppMethodBeat.o(36052);
      }
    }, 300L);
    AppMethodBeat.o(36062);
  }
  
  private void YC()
  {
    AppMethodBeat.i(36069);
    if (this.xqn)
    {
      AppMethodBeat.o(36069);
      return;
    }
    if (this.xql.size() == 0)
    {
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject = (String)this.xql.removeLast();
    final int i = ((Integer)this.Pyg.removeLast()).intValue();
    if (!this.xqg.containsKey(localObject))
    {
      AppMethodBeat.o(36069);
      return;
    }
    this.xqn = true;
    localObject = new QueueWorkerThread.ThreadObject()
    {
      private boolean Pyk = false;
      private Bitmap xqp = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(36055);
        if ((e.b(e.this) == null) || (TextUtils.isEmpty(this.mol)))
        {
          AppMethodBeat.o(36055);
          return false;
        }
        try
        {
          if (e.e(e.this).containsKey(this.mol))
          {
            int i = ((Integer)e.e(e.this).get(this.mol)).intValue();
            Object localObject = (WeakReference)e.i(e.this).get(i);
            if (localObject != null)
            {
              localObject = (View)((WeakReference)localObject).get();
              if ((localObject != null) && ((localObject instanceof WxImageView)))
              {
                final String str = (String)e.j(e.this).get(i);
                this.Pyk = true;
                e.c(e.this).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36053);
                    e.6.a(e.6.this, (WxImageView)this.val$view, e.6.this.mol, str, e.6.this.Pyl);
                    AppMethodBeat.o(36053);
                  }
                });
                AppMethodBeat.o(36055);
                return true;
              }
            }
          }
          this.xqp = e.b(e.this).bmV(this.mol);
          AppMethodBeat.o(36055);
          return true;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.xqp = null;
          AppMethodBeat.o(36055);
        }
        return false;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(36054);
        e.d(e.this);
        if (!this.Pyk) {
          if (e.e(e.this).containsKey(this.mol))
          {
            i = ((Integer)e.e(e.this).get(this.mol)).intValue();
            if (e.f(e.this)) {
              break label168;
            }
            e.g(e.this).put(i, this.xqp);
          }
        }
        Object localObject;
        int j;
        for (;;)
        {
          e.this.w(this.mol, this.xqp);
          e.this.e(i, this.xqp);
          localObject = this.xqp;
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            break;
          }
          j = 0;
          Log.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.xqp = null;
          e.h(e.this);
          AppMethodBeat.o(36054);
          return false;
          label168:
          e.a(e.this, i, this.xqp);
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
    this.iOL.add((QueueWorkerThread.ThreadObject)localObject);
    AppMethodBeat.o(36069);
  }
  
  private void a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(36064);
    this.xqg.put(paramString, Integer.valueOf(paramInt));
    this.xqh.put(paramInt, paramString);
    this.xqf.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(36064);
  }
  
  private void b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36065);
    if (this.xqf.get(paramInt) == null)
    {
      AppMethodBeat.o(36065);
      return;
    }
    View localView = (View)((WeakReference)this.xqf.get(paramInt)).get();
    String str = (String)this.xqh.get(paramInt);
    this.Pyc.a(0L, localView, str, paramBitmap);
    NT(paramInt);
    AppMethodBeat.o(36065);
  }
  
  private boolean dSk()
  {
    return this.mScrollState == 0;
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(36067);
    if (this.xql.contains(paramString1))
    {
      AppMethodBeat.o(36067);
      return;
    }
    int i = paramView.hashCode();
    NT(i);
    a(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.Pyb.remove(i);
      this.Pyb.put(i, paramString2);
    }
    this.xql.add(paramString1);
    this.Pyg.add(Integer.valueOf(paramInt));
    YC();
    AppMethodBeat.o(36067);
  }
  
  public final boolean c(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(36066);
    Log.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.Pyd.aT(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.Pyc.a(0L, paramImageView, null, localBitmap);
      AppMethodBeat.o(36066);
      return true;
    }
    AppMethodBeat.o(36066);
    return false;
  }
  
  public final void cg(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(36057);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.xqj.put(str, localBitmap);
        this.Pyf.push(Integer.valueOf(localBitmap.hashCode()));
        Log.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        Log.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    AppMethodBeat.o(36057);
  }
  
  final void dSj()
  {
    AppMethodBeat.i(36059);
    this.Pyd.a(new f.a() {});
    this.xqj.a(new f.a() {});
    AppMethodBeat.o(36059);
  }
  
  public final void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36070);
    if ((paramInt == this.afB) || (this.afB == -1))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.CQj = paramBitmap;
    }
    AppMethodBeat.o(36070);
  }
  
  public final void f(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(36068);
    if (this.xql.contains(paramString))
    {
      AppMethodBeat.o(36068);
      return;
    }
    int i = paramImageView.hashCode();
    NT(i);
    a(i, paramImageView, paramString);
    this.xql.add(paramString);
    this.Pyg.add(Integer.valueOf(paramInt));
    YC();
    AppMethodBeat.o(36068);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(36060);
    this.mScrollState = paramInt;
    if (dSk())
    {
      int[] arrayOfInt = new int[this.xqi.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.xqi.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        b(i, (Bitmap)this.xqi.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(36060);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(36061);
    if (!((d)this.Pyc).Pwu.Pww.bcY)
    {
      AppMethodBeat.o(36061);
      return;
    }
    if (this.afB == -1)
    {
      int i = 0;
      if (i == 0) {
        NU(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          NU(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          NU(paramInt - i);
        }
      }
    }
    if (this.afB > paramInt) {
      NU(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.afB = paramInt;
      localObject = (d)this.Pyc;
      if (localObject == null) {
        break label223;
      }
      if (((d)localObject).Pwu.NQ(this.afB) == null) {
        break;
      }
      this.CQj = null;
      AppMethodBeat.o(36061);
      return;
      if (this.afB < paramInt) {
        NU(paramInt + 3);
      }
    }
    Object localObject = ((d)localObject).Pwu.NR(this.afB);
    if (localObject != null) {
      this.CQj = ((WxImageView)localObject).getFullImageBitmap();
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
        Pye = mScreenWidth * Pye;
      }
      if (l1 * l2 <= Pye * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(36056);
      return;
    }
    this.xqj.x(paramString, paramBitmap);
    if (g.a.Pyr.xqj.check(paramString))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        g.a.Pyr.xqj.x(paramString, paramBitmap);
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
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, View paramView, String paramString, Bitmap paramBitmap);
    
    public abstract void a(WxImageView paramWxImageView, String paramString, a parama);
    
    public abstract Bitmap ana(int paramInt);
    
    public abstract Bitmap bmV(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */