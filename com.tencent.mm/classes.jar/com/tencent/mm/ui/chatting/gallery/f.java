package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager.e;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

final class f
  implements ViewPager.e
{
  private static int mScreenHeight = 0;
  private static int mScreenWidth = 0;
  private static long vvq = 0L;
  private int UL = -1;
  private ah dPi = new ah();
  private av egH = new av(1, "chatting-image-gallery-lazy-loader");
  SparseArray<WeakReference<View>> kJp = new SparseArray();
  HashMap<String, Integer> kJq = new HashMap();
  SparseArray<String> kJr = new SparseArray();
  SparseArray<Bitmap> kJs = new SparseArray();
  protected com.tencent.mm.a.f<String, Bitmap> kJt = new com.tencent.mm.a.f(5, new f.2(this));
  protected SparseIntArray kJu = new SparseIntArray();
  LinkedList<String> kJv = new LinkedList();
  private boolean kJx = false;
  private int lf = 0;
  SparseArray<String> vvn = new SparseArray();
  f.a vvo;
  protected com.tencent.mm.a.f<Integer, Bitmap> vvp = new com.tencent.mm.a.f(40, new f.1(this));
  private LinkedList<Integer> vvr = new LinkedList();
  LinkedList<Integer> vvs = new LinkedList();
  Bitmap vvt;
  
  public f(f.a parama)
  {
    this.vvo = parama;
  }
  
  private void a(int paramInt, Bitmap paramBitmap)
  {
    if (this.kJp.get(paramInt) == null) {
      return;
    }
    View localView = (View)((WeakReference)this.kJp.get(paramInt)).get();
    this.kJr.get(paramInt);
    this.vvo.b(localView, paramBitmap);
    sa(paramInt);
  }
  
  private boolean aXR()
  {
    return this.lf == 0;
  }
  
  private void sb(int paramInt)
  {
    if (this.vvp.aC(Integer.valueOf(paramInt))) {
      return;
    }
    au.DS().k(new f.5(this, paramInt), 300L);
  }
  
  public final void Q(int paramInt)
  {
    int j = 0;
    this.lf = paramInt;
    if (aXR())
    {
      int[] arrayOfInt = new int[this.kJs.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.kJs.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        a(i, (Bitmap)this.kJs.get(i));
        paramInt += 1;
      }
    }
  }
  
  public final void R(int paramInt)
  {
    if (!((e)this.vvo).vtH.vtK.prepared) {
      return;
    }
    if (this.UL == -1)
    {
      int i = 0;
      if (i == 0) {
        sb(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label126;
        }
        if (paramInt + i <= paramInt + 3) {
          sb(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          sb(paramInt - i);
        }
      }
    }
    if (this.UL > paramInt) {
      sb(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label126:
      this.UL = paramInt;
      Object localObject = (e)this.vvo;
      if ((localObject == null) || (((e)localObject).vtH.rX(this.UL) != null)) {
        break;
      }
      localObject = ((e)localObject).vtH.rY(this.UL);
      if (localObject == null) {
        break;
      }
      this.vvt = ((WxImageView)localObject).getFullImageBitmap();
      return;
      if (this.UL < paramInt) {
        sb(paramInt + 3);
      }
    }
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  final void a(int paramInt, View paramView, String paramString)
  {
    this.kJq.put(paramString, Integer.valueOf(paramInt));
    this.kJr.put(paramInt, paramString);
    this.kJp.put(paramInt, new WeakReference(paramView));
  }
  
  final void aXQ()
  {
    this.vvp.a(new f.3(this));
    this.kJt.a(new f.4(this));
  }
  
  final void ahX()
  {
    if (this.kJx) {}
    int i;
    do
    {
      do
      {
        return;
      } while (this.kJv.size() == 0);
      localObject = (String)this.kJv.removeLast();
      i = ((Integer)this.vvs.removeLast()).intValue();
    } while (!this.kJq.containsKey(localObject));
    this.kJx = true;
    Object localObject = new f.6(this, (String)localObject, i);
    this.egH.c((av.a)localObject);
  }
  
  public final void ay(Map<String, Bitmap> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.kJt.put(str, localBitmap);
        this.vvr.push(Integer.valueOf(localBitmap.hashCode()));
        y.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        y.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
  }
  
  public final void b(int paramInt, Bitmap paramBitmap)
  {
    if ((paramInt == this.UL) || (this.UL == -1))
    {
      y.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.vvt = paramBitmap;
    }
  }
  
  public final boolean b(ImageView paramImageView, int paramInt)
  {
    y.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.vvp.get(Integer.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.vvo.b(paramImageView, localBitmap);
      return true;
    }
    return false;
  }
  
  public final void h(ImageView paramImageView, String paramString, int paramInt)
  {
    if (this.kJv.contains(paramString)) {
      return;
    }
    int i = paramImageView.hashCode();
    sa(i);
    a(i, paramImageView, paramString);
    this.kJv.add(paramString);
    this.vvs.add(Integer.valueOf(paramInt));
    ahX();
  }
  
  protected final void s(String paramString, Bitmap paramBitmap)
  {
    int i;
    if (paramBitmap != null)
    {
      long l1 = paramBitmap.getWidth();
      long l2 = paramBitmap.getHeight();
      if ((mScreenHeight == 0) || (mScreenWidth == 0))
      {
        mScreenWidth = ae.getContext().getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = ae.getContext().getResources().getDisplayMetrics().heightPixels;
        vvq = mScreenWidth * vvq;
      }
      if (l1 * l2 > vvq * 2L)
      {
        i = 1;
        if (i == 0) {
          break label108;
        }
        y.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      }
    }
    label108:
    do
    {
      return;
      i = 0;
      break;
      this.kJt.f(paramString, paramBitmap);
    } while (!g.a.vvC.kJt.aC(paramString));
    y.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
    try
    {
      g.a.vvC.kJt.f(paramString, paramBitmap);
      return;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", paramString, "update preload cache failed", new Object[0]);
    }
  }
  
  final void sa(int paramInt)
  {
    if (this.kJr.get(paramInt) != null)
    {
      String str = (String)this.kJr.get(paramInt);
      this.kJp.remove(paramInt);
      this.kJr.remove(paramInt);
      this.kJq.remove(str);
      this.kJs.remove(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */