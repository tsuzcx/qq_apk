package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.ui.base.WxImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

final class f
  implements ViewPager.OnPageChangeListener
{
  private static int mScreenHeight = 0;
  private static int mScreenWidth = 0;
  private static long zLr = 0L;
  private int Vy;
  private ak faV;
  private az fwL;
  private int mScrollState;
  SparseArray<WeakReference<View>> nfN;
  HashMap<String, Integer> nfO;
  SparseArray<String> nfP;
  SparseArray<Bitmap> nfQ;
  protected com.tencent.mm.a.f<String, Bitmap> nfR;
  protected SparseIntArray nfS;
  private LinkedList<String> nfT;
  private boolean nfV;
  SparseArray<String> zLo;
  f.a zLp;
  protected com.tencent.mm.a.f<String, Bitmap> zLq;
  private LinkedList<Integer> zLs;
  private LinkedList<Integer> zLt;
  Bitmap zLu;
  
  public f(f.a parama)
  {
    AppMethodBeat.i(32145);
    this.fwL = new az(1, "chatting-image-gallery-lazy-loader");
    this.nfN = new SparseArray();
    this.nfO = new HashMap();
    this.nfP = new SparseArray();
    this.nfQ = new SparseArray();
    this.zLo = new SparseArray();
    this.mScrollState = 0;
    this.Vy = -1;
    this.zLq = new b(400, new f.1(this), getClass());
    this.nfR = new b(5, new f.2(this), getClass());
    this.zLs = new LinkedList();
    this.nfS = new SparseIntArray();
    this.nfT = new LinkedList();
    this.zLt = new LinkedList();
    this.faV = new ak();
    this.nfV = false;
    this.zLp = parama;
    AppMethodBeat.o(32145);
  }
  
  private void Dh()
  {
    AppMethodBeat.i(32156);
    if (this.nfV)
    {
      AppMethodBeat.o(32156);
      return;
    }
    if (this.nfT.size() == 0)
    {
      AppMethodBeat.o(32156);
      return;
    }
    Object localObject = (String)this.nfT.removeLast();
    int i = ((Integer)this.zLt.removeLast()).intValue();
    if (!this.nfO.containsKey(localObject))
    {
      AppMethodBeat.o(32156);
      return;
    }
    this.nfV = true;
    localObject = new f.6(this, (String)localObject, i);
    this.fwL.e((az.a)localObject);
    AppMethodBeat.o(32156);
  }
  
  private void a(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(32152);
    if (this.nfN.get(paramInt) == null)
    {
      AppMethodBeat.o(32152);
      return;
    }
    View localView = (View)((WeakReference)this.nfN.get(paramInt)).get();
    this.nfP.get(paramInt);
    this.zLp.b(localView, paramBitmap);
    wW(paramInt);
    AppMethodBeat.o(32152);
  }
  
  private void a(int paramInt, View paramView, String paramString)
  {
    AppMethodBeat.i(32151);
    this.nfO.put(paramString, Integer.valueOf(paramInt));
    this.nfP.put(paramInt, paramString);
    this.nfN.put(paramInt, new WeakReference(paramView));
    AppMethodBeat.o(32151);
  }
  
  private boolean bEz()
  {
    return this.mScrollState == 0;
  }
  
  private void wW(int paramInt)
  {
    AppMethodBeat.i(32150);
    if (this.nfP.get(paramInt) != null)
    {
      String str = (String)this.nfP.get(paramInt);
      this.nfN.remove(paramInt);
      this.nfP.remove(paramInt);
      this.nfO.remove(str);
      this.nfQ.remove(paramInt);
    }
    AppMethodBeat.o(32150);
  }
  
  private void wX(int paramInt)
  {
    AppMethodBeat.i(32149);
    if (this.zLq.Z(String.valueOf(paramInt)))
    {
      AppMethodBeat.o(32149);
      return;
    }
    aw.RO().o(new f.5(this, paramInt), 300L);
    AppMethodBeat.o(32149);
  }
  
  public final void aX(Map<String, Bitmap> paramMap)
  {
    AppMethodBeat.i(32144);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Bitmap localBitmap = (Bitmap)paramMap.get(str);
      if (localBitmap != null)
      {
        this.nfR.put(str, localBitmap);
        this.zLs.push(Integer.valueOf(localBitmap.hashCode()));
        ab.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", new Object[] { str, Integer.valueOf(localBitmap.hashCode()) });
      }
      else
      {
        ab.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
      }
    }
    AppMethodBeat.o(32144);
  }
  
  public final void b(View paramView, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(32154);
    if (this.nfT.contains(paramString1))
    {
      AppMethodBeat.o(32154);
      return;
    }
    int i = paramView.hashCode();
    wW(i);
    a(i, paramView, paramString1);
    if ((paramView instanceof WxImageView))
    {
      this.zLo.remove(i);
      this.zLo.put(i, paramString2);
    }
    this.nfT.add(paramString1);
    this.zLt.add(Integer.valueOf(paramInt));
    Dh();
    AppMethodBeat.o(32154);
  }
  
  final void bEy()
  {
    AppMethodBeat.i(32146);
    this.zLq.a(new f.3(this));
    this.nfR.a(new f.4(this));
    AppMethodBeat.o(32146);
  }
  
  public final void c(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(32157);
    if ((paramInt == this.Vy) || (this.Vy == -1))
    {
      ab.i("MicroMsg.ImageGalleryLazyLoader", "alvinluo notifyBitmapLoaded cache bitmap, position: %d", new Object[] { Integer.valueOf(paramInt) });
      this.zLu = paramBitmap;
    }
    AppMethodBeat.o(32157);
  }
  
  public final boolean c(ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(32153);
    ab.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", new Object[] { Integer.valueOf(paramInt) });
    Bitmap localBitmap = (Bitmap)this.zLq.Y(String.valueOf(paramInt));
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      this.zLp.b(paramImageView, localBitmap);
      AppMethodBeat.o(32153);
      return true;
    }
    AppMethodBeat.o(32153);
    return false;
  }
  
  public final void g(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(32155);
    if (this.nfT.contains(paramString))
    {
      AppMethodBeat.o(32155);
      return;
    }
    int i = paramImageView.hashCode();
    wW(i);
    a(i, paramImageView, paramString);
    this.nfT.add(paramString);
    this.zLt.add(Integer.valueOf(paramInt));
    Dh();
    AppMethodBeat.o(32155);
  }
  
  public final void onPageScrollStateChanged(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(32147);
    this.mScrollState = paramInt;
    if (bEz())
    {
      int[] arrayOfInt = new int[this.nfQ.size()];
      int i = 0;
      for (;;)
      {
        paramInt = j;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = this.nfQ.keyAt(i);
        i += 1;
      }
      while (paramInt < arrayOfInt.length)
      {
        i = arrayOfInt[paramInt];
        a(i, (Bitmap)this.nfQ.get(i));
        paramInt += 1;
      }
    }
    AppMethodBeat.o(32147);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(32148);
    if (!((e)this.zLp).zJI.zJL.prepared)
    {
      AppMethodBeat.o(32148);
      return;
    }
    if (this.Vy == -1)
    {
      int i = 0;
      if (i == 0) {
        wX(paramInt);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramInt + i > paramInt + 3) && (paramInt - i < Math.max(paramInt - 3, 0))) {
          break label138;
        }
        if (paramInt + i <= paramInt + 3) {
          wX(paramInt + i);
        }
        if (paramInt - i >= Math.max(paramInt - 3, 0)) {
          wX(paramInt - i);
        }
      }
    }
    if (this.Vy > paramInt) {
      wX(Math.max(paramInt - 3, 0));
    }
    for (;;)
    {
      label138:
      this.Vy = paramInt;
      localObject = (e)this.zLp;
      if (localObject == null) {
        break label223;
      }
      if (((e)localObject).zJI.wT(this.Vy) == null) {
        break;
      }
      this.zLu = null;
      AppMethodBeat.o(32148);
      return;
      if (this.Vy < paramInt) {
        wX(paramInt + 3);
      }
    }
    Object localObject = ((e)localObject).zJI.wU(this.Vy);
    if (localObject != null) {
      this.zLu = ((WxImageView)localObject).getFullImageBitmap();
    }
    label223:
    AppMethodBeat.o(32148);
  }
  
  protected final void u(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(32143);
    if (paramBitmap != null)
    {
      long l1 = paramBitmap.getWidth();
      long l2 = paramBitmap.getHeight();
      if ((mScreenHeight == 0) || (mScreenWidth == 0))
      {
        mScreenWidth = ah.getContext().getResources().getDisplayMetrics().widthPixels;
        mScreenHeight = ah.getContext().getResources().getDisplayMetrics().heightPixels;
        zLr = mScreenWidth * zLr;
      }
      if (l1 * l2 <= zLr * 2L) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      ab.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
      AppMethodBeat.o(32143);
      return;
    }
    this.nfR.f(paramString, paramBitmap);
    if (g.a.zLE.nfR.Z(paramString))
    {
      ab.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
      try
      {
        g.a.zLE.nfR.f(paramString, paramBitmap);
        AppMethodBeat.o(32143);
        return;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", paramString, "update preload cache failed", new Object[0]);
      }
    }
    AppMethodBeat.o(32143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */