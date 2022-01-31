package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b
{
  private static HashMap<String, WeakReference<Bitmap>> oeM = new HashMap();
  private static Map<String, Integer> oeQ = new ConcurrentHashMap();
  public boolean eFF = true;
  private boolean eyq = false;
  private ah jge;
  private Surface mSurface;
  private Animation oeA;
  private Animation oeB;
  private volatile b.h oeC;
  private volatile b.b oeD;
  public volatile b.i oeE;
  private volatile b.c oeF;
  private b.k oeG;
  private b.j oeH;
  private b.d oeI;
  public boolean oeJ = true;
  public boolean oeK = true;
  public boolean oeL = false;
  public boolean oeN = false;
  public double oeO = -1.0D;
  boolean oeP = false;
  public double oeR = -1.0D;
  private boolean oeS = false;
  public boolean oeT = false;
  private b.a oeU;
  public e oeV;
  public b.f oeW;
  public b.g oeX;
  private int oen = 0;
  private int oeo = 0;
  public String oep = "";
  private String oeq = "";
  private int oer = -1;
  protected int oes = 41;
  private Bitmap oet;
  public Bitmap oeu;
  private Bitmap oev;
  private WeakReference<View> oew;
  private WeakReference<TextView> oex;
  private long oey;
  public WeakReference<View> oez;
  public int position;
  
  public b(int paramInt, View paramView)
  {
    this.oeo = paramInt;
    this.jge = new ah(Looper.getMainLooper());
    this.oez = new WeakReference(paramView);
    y.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void ET()
  {
    com.tencent.mm.modelvideo.o.g(new b.1(), 0L);
  }
  
  public static boolean MI(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = (Integer)oeQ.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  public static Bitmap b(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str = String.format("%s-%s-%s-%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Object localObject = (WeakReference)oeM.get(str);
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return (Bitmap)((WeakReference)localObject).get();
    }
    if (paramContext == null)
    {
      y.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
      return null;
    }
    if (paramInt1 <= 0)
    {
      y.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
      return null;
    }
    if ((paramInt2 <= 0) || (paramInt4 <= 0) || (paramInt3 <= 0))
    {
      y.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
      return null;
    }
    long l = bk.UZ();
    paramInt3 = paramInt2 * paramInt4 / paramInt3;
    paramContext = (NinePatchDrawable)paramContext.getResources().getDrawable(paramInt1);
    paramContext.setBounds(0, 0, paramInt2, paramInt3);
    localObject = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    paramContext.draw(new Canvas((Bitmap)localObject));
    oeM.put(str, new WeakReference(localObject));
    y.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[] { Long.valueOf(bk.cp(l)) });
    return localObject;
  }
  
  private void xt(int paramInt)
  {
    com.tencent.mm.modelvideo.o.g(new b.2(this, paramInt), 0L);
  }
  
  public final void F(Bitmap paramBitmap)
  {
    boolean bool = true;
    if (paramBitmap == null) {}
    for (;;)
    {
      y.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(bool) });
      com.tencent.mm.modelvideo.o.q(this.oeG);
      if (this.oeG == null) {
        this.oeG = new b.k(this, (byte)0);
      }
      this.oeG.ofk = new WeakReference(paramBitmap);
      com.tencent.mm.modelvideo.o.g(this.oeG, 0L);
      return;
      bool = false;
    }
  }
  
  public abstract void G(Bitmap paramBitmap);
  
  public final void aW(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[] { Integer.valueOf(hashCode()), paramString, this.oep, Boolean.valueOf(paramBoolean), Integer.valueOf(this.oer), Boolean.valueOf(this.oeT), Boolean.valueOf(this.oeK) });
    if (this.oeT)
    {
      iN(false);
      return;
    }
    if (bBb())
    {
      y.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
      clear();
      return;
    }
    if (!this.oeK)
    {
      clear();
      return;
    }
    if (paramBoolean)
    {
      this.oeq = paramString;
      iN(false);
      return;
    }
    if (this.oep.equals(paramString))
    {
      this.oeq = "ERROR#PATH";
      iN(false);
      restart();
      return;
    }
    clear();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.oep = str;
    if (bk.bl(this.oep))
    {
      y.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
      F(null);
      return;
    }
    if (!MI(this.oep))
    {
      y.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.oeC = new b.h(this, (byte)0);
    com.tencent.mm.modelvideo.o.g(this.oeC, 0L);
  }
  
  public int bAZ()
  {
    return -1;
  }
  
  public final boolean bBa()
  {
    if (1 == this.oeo) {
      if ((this.oeD == null) || (this.oeD.stop)) {}
    }
    while ((this.oeF != null) && (!this.oeF.stop) && (this.oeD != null) && (!this.oeD.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final boolean bBb()
  {
    if (this.oeN) {}
    do
    {
      do
      {
        return false;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
      } while (this.oen < 3);
      y.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
      this.oen = 0;
      return false;
    } while (this.oen < 3);
    return true;
  }
  
  protected final void bBc()
  {
    int i = Math.max(1, (int)SightVideoJNI.getVideoRate(this.oer));
    this.oes = (1000 / i);
    y.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.oes) });
  }
  
  public final c bBd()
  {
    if (this.oeU == null) {
      this.oeU = new b.a(this);
    }
    return this.oeU;
  }
  
  public final double bBe()
  {
    if (this.oer == -1) {
      return 0.0D;
    }
    return SightVideoJNI.getVideoDuration(this.oer);
  }
  
  public final void clear()
  {
    y.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.oer), Boolean.valueOf(bBa()) });
    iN(true);
    this.oey = 0L;
    xt(this.oer);
    this.oer = -1;
    this.oep = "";
    this.oeq = "ERROR#PATH";
    this.oev = null;
    this.oeO = 0.0D;
    this.oeP = false;
    com.tencent.mm.memory.o.dPr.m(this.oet);
    this.oet = null;
  }
  
  public abstract void cw(int paramInt1, int paramInt2);
  
  public final void e(Surface paramSurface)
  {
    y.v("MicroMsg.SightPlayController", "set play surface %s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    com.tencent.mm.modelvideo.o.g(this.oeG, 0L);
  }
  
  public final void iN(boolean paramBoolean)
  {
    if (this.oeC != null)
    {
      com.tencent.mm.modelvideo.o.q(this.oeC);
      this.oeC.stop = true;
    }
    if (this.oeF != null)
    {
      this.jge.removeCallbacks(this.oeF);
      this.oeF.stop = true;
    }
    if (this.oeD != null)
    {
      com.tencent.mm.modelvideo.o.q(this.oeD);
      this.oeD.stop = true;
    }
    b.i locali;
    if (this.oeE != null)
    {
      locali = this.oeE;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.g(this.oeE, 0L);
      return;
    }
  }
  
  public final void restart()
  {
    y.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.oeK), this.oep, Integer.valueOf(this.oer) });
    if (!this.oeK) {
      clear();
    }
    do
    {
      return;
      if (bBa())
      {
        y.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.oep });
        return;
      }
      if (this.oer < 0) {}
      for (boolean bool = true;; bool = false)
      {
        iN(bool);
        this.oey = 0L;
        if (!bBb()) {
          break;
        }
        y.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[] { Integer.valueOf(hashCode()) });
        return;
      }
      if (this.oer >= 0) {
        break;
      }
      y.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[] { Integer.valueOf(hashCode()), this.oep });
    } while (bk.bl(this.oep));
    if (!MI(this.oep))
    {
      y.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
      clear();
      return;
    }
    this.oeC = new b.h(this, (byte)0);
    com.tencent.mm.modelvideo.o.g(this.oeC, 0L);
    return;
    if (1 == this.oeo)
    {
      this.oeD = new b.b(this, (byte)0);
      this.oeF = null;
      com.tencent.mm.modelvideo.o.g(this.oeD, 0L);
      return;
    }
    this.oeD = new b.b(this, (byte)0);
    this.oeF = new b.c(this);
    this.oeD.ofd = this.oeF;
    this.oeF.ofh = this.oeD;
    com.tencent.mm.modelvideo.o.g(this.oeD, 0L);
  }
  
  public final void setSightInfoView(TextView paramTextView)
  {
    this.oex = new WeakReference(paramTextView);
  }
  
  public final void setThumbBgView(View paramView)
  {
    this.oew = new WeakReference(paramView);
  }
  
  public static abstract interface e
  {
    public abstract void d(b paramb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b
 * JD-Core Version:    0.7.0.1
 */