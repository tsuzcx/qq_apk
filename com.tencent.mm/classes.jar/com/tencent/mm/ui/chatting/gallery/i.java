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

final class i
  implements ViewPager.OnPageChangeListener
{
  private static long WSD = 0L;
  private static int mScreenHeight;
  private static int mScreenWidth = 0;
  SparseArray<WeakReference<View>> CcA;
  HashMap<String, Integer> CcB;
  SparseArray<String> CcC;
  SparseArray<Bitmap> CcD;
  protected com.tencent.mm.b.f<String, Bitmap> CcE;
  protected SparseIntArray CcF;
  private LinkedList<String> CcG;
  private boolean CcI;
  SparseArray<String> WSA;
  d WSB;
  protected com.tencent.mm.b.f<String, Bitmap> WSC;
  private LinkedList<Integer> WSE;
  private LinkedList<Integer> WSF;
  private MMHandler knk;
  Bitmap krJ;
  private QueueWorkerThread lFb;
  private int lL;
  private int mScrollState;
  
  static
  {
    mScreenHeight = 0;
  }
  
  public i(d paramd)
  {
    AppMethodBeat.i(281613);
    this.lFb = new QueueWorkerThread(1, "chatting-image-gallery-lazy-loader");
    this.CcA = new SparseArray();
    this.CcB = new HashMap();
    this.CcC = new SparseArray();
    this.CcD = new SparseArray();
    this.WSA = new SparseArray();
    this.mScrollState = 0;
    this.lL = -1;
    this.WSC = new b(400, new f.b() {}, getClass());
    this.CcE = new b(5, new f.b() {}, getClass());
    this.WSE = new LinkedList();
    this.CcF = new SparseIntArray();
    this.CcG = new LinkedList();
    this.WSF = new LinkedList();
    this.knk = new MMHandler();
    this.CcI = false;
    this.WSB = paramd;
    AppMethodBeat.o(281613);
  }
  
  private void Ti(int paramInt)
  {
    AppMethodBeat.i(36063);
    if (this.CcC.get(paramInt) != null)
    {
      String str = (String)this.CcC.get(paramInt);
      this.CcA.remove(paramInt);
      this.CcC.remove(paramInt);
      this.CcB.remove(str);
      this.CcD.remove(paramInt);
    }
    AppMethodBeat.o(36063);
  }
  
  private void Tj(final int paramInt)
  {
    AppMethodBeat.i(36062);
    if (this.WSC.check(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(36062);
      return;
    }
    bh.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(36052);
        if (i.b(i.this) == null)
        {
          Log.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
          AppMethodBeat.o(36052);
          return;
        }
        final Bitmap localBitmap = i.b(i.this).avP(paramInt);
        if (localBitmap == null)
        {
          AppMethodBeat.o(36052);
          return;
        }
        i.c(i.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36051);
            i.this.WSC.put(i.5.this.bFI, localBitmap);
            AppMethodBeat.o(36051);
          }
        });
        AppMethodBeat.o(36052);
      }
    }, 300L);
    AppMethodBeat.o(36062);
  }
  
  private void a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(36064);
    this.CcB.put(paramString, Integer.valueOf(paramInt));
    this.CcC.put(paramInt, paramString);
    this.CcA.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(36064);
  }
  
  private void adj()
  {
    AppMethodBeat.i(36069);
    if (this.CcI)
    {
      AppMethodBeat.o(36069);
      return;
    }
    if (this.CcG.size() == 0)
    {
      AppMethodBeat.o(36069);
      return;
    }
    Object localObject = (String)this.CcG.removeLast();
    final int i = ((Integer)this.WSF.removeLast()).intValue();
    if (!this.CcB.containsKey(localObject))
    {
      AppMethodBeat.o(36069);
      return;
    }
    this.CcI = true;
    localObject = new QueueWorkerThread.ThreadObject()
    {
      private boolean WSJ = false;
      private Bitmap tJN = null;
      
      public final boolean doInBackground()
      {
        AppMethodBeat.i(36055);
        if ((i.b(i.this) == null) || (TextUtils.isEmpty(this.pmq)))
        {
          AppMethodBeat.o(36055);
          return false;
        }
        try
        {
          if (i.e(i.this).containsKey(this.pmq))
          {
            int i = ((Integer)i.e(i.this).get(this.pmq)).intValue();
            Object localObject = (WeakReference)i.i(i.this).get(i);
            if (localObject != null)
            {
              localObject = (View)((WeakReference)localObject).get();
              if ((localObject != null) && ((localObject instanceof WxImageView)))
              {
                final String str = (String)i.j(i.this).get(i);
                this.WSJ = true;
                i.c(i.this).post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(36053);
                    i.6.a(i.6.this, (WxImageView)this.val$view, i.6.this.pmq, str, i.6.this.WSK);
                    AppMethodBeat.o(36053);
                  }
                });
                AppMethodBeat.o(36055);
                return true;
              }
            }
          }
          this.tJN = i.b(i.this).aIz(this.pmq);
          AppMethodBeat.o(36055);
          return true;
        }
        catch (Exception localException)
        {
          Log.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[] { localException.getMessage() });
          this.tJN = null;
          AppMethodBeat.o(36055);
        }
        return false;
      }
      
      public final boolean onPostExecute()
      {
        AppMethodBeat.i(36054);
        i.d(i.this);
        if (!this.WSJ) {
          if (i.e(i.this).containsKey(this.pmq))
          {
            i = ((Integer)i.e(i.this).get(this.pmq)).intValue();
            if (i.f(i.this)) {
              break label168;
            }
            i.g(i.this).put(i, this.tJN);
          }
        }
        Object localObject;
        int j;
        for (;;)
        {
          i.this.w(this.pmq, this.tJN);
          i.this.e(i, this.tJN);
          localObject = this.tJN;
          if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
            break;
          }
          j = 0;
          Log.i("MicroMsg.ImageGalleryLazyLoader", "bmp size : %s", new Object[] { Integer.valueOf(j) });
          this.tJN = null;
          i.h(i.this);
          AppMethodBeat.o(36054);
          return false;
          label168:
          i.a(i.this, i, this.tJN);
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
    this.lFb.add((QueueWorkerThread.ThreadObject)localObject);
    AppMethodBeat.o(36069);
  }
  
  private void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36065);
    if (this.CcA.get(paramInt) == null)
    {
      AppMethodBeat.o(36065);
      return;
    }
    View localView = (View)((WeakReference)this.CcA.get(paramInt)).get();
    String str = (String)this.CcC.get(paramInt);
    this.WSB.a(0L, localView, str, paramBitmap);
    Ti(paramInt);
    AppMethodBeat.o(36065);
  }
  
  private boolean euL()
  {
    return this.mScrollState == 0;
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(36067);
    if (this.CcG.contains(paramString1))
    {
      AppMethodBeat.o(36067);
      return;
    }
    int i = paramView.hashCode();
    Ti(i);
    a(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.WSA.remove(i);
      this.WSA.put(i, paramString2);
    }
    this.CcG.add(paramString1);
    this.WSF.add(Integer.valueOf(paramInt));
    adj();
    AppMethodBeat.o(36067);
  }
  
  public final boolean c(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(36066);
    Log.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.WSC.aX(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.WSB.a(0L, paramImageView, null, localBitmap);
      AppMethodBeat.o(36066);
      return true;
    }
    AppMethodBeat.o(36066);
    return false;
  }
  
  public final void cn(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(36057);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.CcE.put(str, localBitmap);
        this.WSE.push(Integer.valueOf(localBitmap.hashCode()));
        Log.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        Log.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    AppMethodBeat.o(36057);
  }
  
  public final void e(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36070);
    if ((paramInt == this.lL) || (this.lL == -1))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.krJ = paramBitmap;
    }
    AppMethodBeat.o(36070);
  }
  
  final void euK()
  {
    AppMethodBeat.i(36059);
    this.WSC.a(new com.tencent.mm.b.f.a() {});
    this.CcE.a(new com.tencent.mm.b.f.a() {});
    AppMethodBeat.o(36059);
  }
  
  public final void k(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(36068);
    if (this.CcG.contains(paramString))
    {
      AppMethodBeat.o(36068);
      return;
    }
    int i = paramImageView.hashCode();
    Ti(i);
    a(i, paramImageView, paramString);
    this.CcG.add(paramString);
    this.WSF.add(Integer.valueOf(paramInt));
    adj();
    AppMethodBeat.o(36068);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(36060);
    this.mScrollState = paramInt;
    if (euL())
    {
      int[] arrayOfInt = new int[this.CcD.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.CcD.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        c(i, (Bitmap)this.CcD.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(36060);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(36061);
    if (!((h)this.WSB).WQM.WQW.aMy)
    {
      AppMethodBeat.o(36061);
      return;
    }
    if (this.lL == -1)
    {
      int i = 0;
      if (i == 0) {
        Tj(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          Tj(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          Tj(paramInt - i);
        }
      }
    }
    if (this.lL > paramInt) {
      Tj(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.lL = paramInt;
      localObject = (h)this.WSB;
      if (localObject == null) {
        break label223;
      }
      if (((h)localObject).WQM.Tf(this.lL) == null) {
        break;
      }
      this.krJ = null;
      AppMethodBeat.o(36061);
      return;
      if (this.lL < paramInt) {
        Tj(paramInt + 3);
      }
    }
    Object localObject = ((h)localObject).WQM.Tg(this.lL);
    if (localObject != null) {
      this.krJ = ((WxImageView)localObject).getFullImageBitmap();
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
        WSD = mScreenWidth * WSD;
      }
      if (l1 * l2 <= WSD * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(36056);
      return;
    }
    this.CcE.q(paramString, paramBitmap);
    if (k.a.WSQ.CcE.check(paramString))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        k.a.WSQ.CcE.q(paramString, paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.i
 * JD-Core Version:    0.7.0.1
 */