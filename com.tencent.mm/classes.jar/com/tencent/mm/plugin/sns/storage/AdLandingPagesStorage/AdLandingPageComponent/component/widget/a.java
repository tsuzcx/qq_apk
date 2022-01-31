package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a
{
  private static HashMap<String, WeakReference<Bitmap>> oeM = new HashMap();
  private static Map<String, Integer> oeQ = new ConcurrentHashMap();
  boolean eFF = true;
  private boolean eyq = false;
  private ah jge = new ah(Looper.getMainLooper());
  private Surface mSurface;
  volatile a.h oIp;
  private volatile a.b oIq;
  volatile a.i oIr;
  private volatile a.c oIs;
  private a.k oIt;
  private a.j oIu;
  private d oIv;
  private a.a oIw;
  a.e oIx;
  a.f oIy;
  a.g oIz;
  private Animation oeA;
  private Animation oeB;
  boolean oeK = true;
  public boolean oeL = false;
  public boolean oeN = false;
  double oeO = -1.0D;
  boolean oeP = false;
  double oeR = -1.0D;
  private boolean oeS = false;
  boolean oeT = false;
  private int oen = 0;
  private int oeo = 0;
  String oep = "";
  String oeq = "";
  int oer = -1;
  protected int oes = 41;
  private Bitmap oet;
  private Bitmap oeu;
  private Bitmap oev;
  WeakReference<View> oew;
  WeakReference<TextView> oex;
  private long oey;
  private WeakReference<View> oez;
  int position;
  
  public a(View paramView)
  {
    this.oez = new WeakReference(paramView);
    y.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[] { Integer.valueOf(0) });
  }
  
  public static boolean MI(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    paramString = (Integer)oeQ.get(paramString);
    return (paramString == null) || (2 != paramString.intValue());
  }
  
  private void xt(int paramInt)
  {
    com.tencent.mm.modelvideo.o.g(new a.1(this, paramInt), 0L);
  }
  
  public abstract void G(Bitmap paramBitmap);
  
  protected int bAZ()
  {
    return -1;
  }
  
  public final boolean bBa()
  {
    if (1 == this.oeo) {
      if ((this.oIq == null) || (this.oIq.stop)) {}
    }
    while ((this.oIs != null) && (!this.oIs.stop) && (this.oIq != null) && (!this.oIq.stop))
    {
      return true;
      return false;
    }
    return false;
  }
  
  final boolean bBb()
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
    if (this.oIw == null) {
      this.oIw = new a.a(this);
    }
    return this.oIw;
  }
  
  public final void bFG()
  {
    y.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[] { Boolean.valueOf(true) });
    com.tencent.mm.modelvideo.o.q(this.oIt);
    if (this.oIt == null) {
      this.oIt = new a.k(this, (byte)0);
    }
    this.oIt.ofk = new WeakReference(null);
    com.tencent.mm.modelvideo.o.g(this.oIt, 0L);
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
  
  public final void iN(boolean paramBoolean)
  {
    if (this.oIp != null)
    {
      com.tencent.mm.modelvideo.o.q(this.oIp);
      this.oIp.stop = true;
    }
    if (this.oIs != null)
    {
      this.jge.removeCallbacks(this.oIs);
      this.oIs.stop = true;
    }
    if (this.oIq != null)
    {
      com.tencent.mm.modelvideo.o.q(this.oIq);
      this.oIq.stop = true;
    }
    a.i locali;
    if (this.oIr != null)
    {
      locali = this.oIr;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = 0;; i = 2)
    {
      locali.type = i;
      com.tencent.mm.modelvideo.o.g(this.oIr, 0L);
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
    this.oIp = new a.h(this, (byte)0);
    com.tencent.mm.modelvideo.o.g(this.oIp, 0L);
    return;
    if (1 == this.oeo)
    {
      this.oIq = new a.b(this, (byte)0);
      this.oIs = null;
      com.tencent.mm.modelvideo.o.g(this.oIq, 0L);
      return;
    }
    this.oIq = new a.b(this, (byte)0);
    this.oIs = new a.c(this);
    this.oIq.oIB = this.oIs;
    this.oIs.oID = this.oIq;
    com.tencent.mm.modelvideo.o.g(this.oIq, 0L);
  }
  
  private final class d
    implements Runnable
  {
    private d() {}
    
    public final void run()
    {
      if (a.k(a.this).get() == null) {
        return;
      }
      ((View)a.k(a.this).get()).startAnimation(a.l(a.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
 * JD-Core Version:    0.7.0.1
 */