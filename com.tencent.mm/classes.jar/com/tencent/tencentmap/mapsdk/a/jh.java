package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.a;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.SystemUtil;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.opengles.GL10;

public class jh
  implements ik, ir
{
  private String A;
  private boolean B = true;
  private boolean C = false;
  private int D = 0;
  private int E = 0;
  private Rect F;
  private float G = 0.5F;
  private float H = 0.5F;
  private boolean I = true;
  private int J = 18;
  private int K = 14;
  private boolean L = false;
  private jc a;
  private com.tencent.map.lib.gl.b b;
  private jf c;
  private jz d;
  private jg e;
  private je f;
  private WeakReference<jb> g;
  private im h;
  private Rect i;
  private boolean j;
  private boolean k;
  private Context l;
  private jr m;
  private jh.d n;
  private jo o;
  private LinkedBlockingQueue<jh.a> p;
  private jt q;
  private a r;
  private boolean s = false;
  private com.tencent.map.lib.util.c<Integer, Integer> t;
  private boolean u = true;
  private com.tencent.map.lib.b v;
  private boolean w = true;
  private jh.b x;
  private jh.c y;
  private ja z;
  
  public jh(Context paramContext, jb paramjb)
  {
    this.l = paramContext.getApplicationContext();
    this.g = new WeakReference(paramjb);
    this.a = new jc(paramContext, this);
    this.o = new jo(this);
    this.i = new Rect();
    this.e = new jg(this);
    this.h = new im(this.o, this);
    this.c = new jf(this);
    this.a.a(this.c);
    this.n = new jh.d(this, null);
    this.p = new LinkedBlockingQueue();
  }
  
  private void J()
  {
    if (this.a != null) {
      this.a.k();
    }
  }
  
  private void K()
  {
    if (this.a != null) {
      this.a.l();
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.D = paramInt3;
    this.E = paramInt4;
    if (paramBoolean) {
      a(this.G, this.H, this.I);
    }
  }
  
  private void c(GL10 paramGL10)
  {
    if (this.p.size() == 0) {}
    for (;;)
    {
      return;
      int i1 = 1;
      while (i1 != 0)
      {
        jh.a locala = (jh.a)this.p.poll();
        if (locala != null) {
          try
          {
            locala.a(paramGL10);
          }
          catch (Exception localException) {}
        } else {
          i1 = 0;
        }
      }
    }
  }
  
  private void m(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
  }
  
  public MapLanguage A()
  {
    if (this.x == null) {
      this.x = new jh.b(this);
    }
    return this.x.a();
  }
  
  public je B()
  {
    return this.f;
  }
  
  public String C()
  {
    return this.A;
  }
  
  public boolean D()
  {
    if (this.z == null) {
      return false;
    }
    return this.z.a();
  }
  
  public void E()
  {
    if ((this.z == null) || (!this.z.a())) {
      return;
    }
    this.z.b();
  }
  
  a F()
  {
    return this.r;
  }
  
  public jt G()
  {
    return this.q;
  }
  
  public String H()
  {
    String str = null;
    if (this.a != null) {
      str = this.a.E();
    }
    return str;
  }
  
  protected boolean I()
  {
    if (this.a != null) {
      return this.a.g();
    }
    return false;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    int i2 = 255;
    if (this.a == null) {
      return -1;
    }
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 > 255) {}
      for (int i1 = 255;; i1 = paramInt1)
      {
        if (paramInt2 < 0) {}
        for (paramInt1 = 0;; paramInt1 = paramInt2)
        {
          if (paramInt1 > 255) {}
          for (paramInt2 = 255;; paramInt2 = paramInt1)
          {
            if (paramInt3 < 0) {}
            for (paramInt1 = 0;; paramInt1 = paramInt3)
            {
              if (paramInt1 > 255) {}
              for (paramInt3 = 255;; paramInt3 = paramInt1)
              {
                if (paramInt4 < 0) {}
                for (paramInt1 = 0;; paramInt1 = paramInt4)
                {
                  if (paramInt1 > 255) {
                    paramInt1 = i2;
                  }
                  for (;;)
                  {
                    MaskLayer localMaskLayer = new MaskLayer();
                    localMaskLayer.color = new int[] { i1, paramInt2, paramInt3, 255 - paramInt1 };
                    if (this.i != null)
                    {
                      localMaskLayer.width = this.i.width();
                      localMaskLayer.height = this.i.height();
                    }
                    localMaskLayer.zIndex = paramFloat;
                    localMaskLayer.layer = paramInt5;
                    paramInt1 = this.a.a(localMaskLayer);
                    this.e.a(paramInt1, paramInt5);
                    return paramInt1;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (this.a != null) {
      return this.a.c(paramInt, paramBoolean);
    }
    return -1;
  }
  
  public int a(Polygon2D paramPolygon2D)
  {
    if ((this.a == null) || (paramPolygon2D == null)) {
      return -1;
    }
    paramPolygon2D.borderWidth *= SystemUtil.getDensity(this.l);
    int i1 = this.a.a(paramPolygon2D);
    if (this.t == null) {
      this.t = new com.tencent.map.lib.util.c();
    }
    this.t.a(Integer.valueOf(i1), Integer.valueOf(paramPolygon2D.borldLineId));
    return i1;
  }
  
  public TappedElement a(float paramFloat1, float paramFloat2)
  {
    if (this.a != null) {
      return this.a.a(paramFloat1, paramFloat2);
    }
    return null;
  }
  
  public jf a()
  {
    return this.c;
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    if ((this.r != null) && (this.v != null))
    {
      String str = this.v.a(paramGeoPoint);
      if (str != null) {
        return str;
      }
    }
    if (this.a == null) {
      return "";
    }
    return this.a.a(paramGeoPoint);
  }
  
  public List<Integer> a(Rect paramRect, int paramInt)
  {
    return this.a.a(paramRect, paramInt);
  }
  
  public void a(double paramDouble)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    int i1;
    if (this.c.p() > 1.0E-010D)
    {
      i1 = 1;
      if (!this.L) {
        break label82;
      }
      if ((!this.w) || (i1 == 0)) {
        break label76;
      }
      label41:
      m(bool1);
    }
    for (;;)
    {
      if ((!kp.a()) && (this.c.t())) {
        this.a.n();
      }
      return;
      i1 = 0;
      break;
      label76:
      bool1 = false;
      break label41;
      label82:
      if (!this.w)
      {
        bool1 = bool2;
        if (i1 == 0) {}
      }
      else
      {
        bool1 = true;
      }
      m(bool1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.G = paramFloat1;
    this.H = paramFloat2;
    double d5 = paramFloat1;
    double d2 = paramFloat2;
    double d3 = d2;
    double d4 = d5;
    if (this.i != null)
    {
      double d1 = d2;
      if (this.E > 0) {
        d1 = 0.5D - (0.5D - d2) * this.i.height() / this.E;
      }
      d3 = d1;
      d4 = d5;
      if (this.D > 0)
      {
        d4 = 0.5D - (0.5D - d5) * this.i.width() / this.D;
        d3 = d1;
      }
    }
    this.a.b((float)d4, (float)d3, paramBoolean);
  }
  
  public void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    this.s = true;
    this.i.set(0, 0, paramInt1, paramInt2);
    a(0, 0, paramInt1, paramInt2, false);
    this.c.v();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Rect paramRect)
  {
    if ((this.i == null) || (paramRect == null)) {
      return;
    }
    this.F = paramRect;
    int i1 = this.i.width();
    int i2 = this.i.height();
    a(paramRect.left, paramRect.bottom, i1 - paramRect.right - paramRect.left, i2 - paramRect.bottom - paramRect.top, true);
  }
  
  public void a(JNICallback.b paramb)
  {
    if (this.a != null) {
      this.a.a(paramb);
    }
  }
  
  public void a(JNICallback.c paramc)
  {
    if (this.a != null) {
      this.a.a(paramc);
    }
  }
  
  public void a(JNICallback.d paramd)
  {
    if (this.a != null) {
      this.a.a(paramd);
    }
  }
  
  public void a(JNICallback.e parame)
  {
    if (this.a != null) {
      this.a.a(parame);
    }
  }
  
  public void a(JNICallback.f paramf)
  {
    if (this.a != null) {
      this.a.a(paramf);
    }
  }
  
  public void a(JNICallback.j paramj)
  {
    if (this.a != null) {
      this.a.a(paramj);
    }
  }
  
  public void a(JNICallback.k paramk)
  {
    if (this.a != null) {
      this.a.a(paramk);
    }
  }
  
  public void a(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    if (this.x == null) {
      this.x = new jh.b(this);
    }
    this.x.a(paramMapLanguageChangeListener);
  }
  
  public void a(jh.a parama)
  {
    try
    {
      this.p.put(parama);
      return;
    }
    catch (InterruptedException parama) {}
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.e(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramString1, paramString2);
  }
  
  public void a(List<BlockRouteCityData> paramList)
  {
    this.a.a(paramList);
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    if (this.y == null) {
      this.y = new jh.c(this);
    }
    this.y.a(paramList, paramList1);
  }
  
  public void a(GL10 paramGL10)
  {
    if (this.a == null) {
      return;
    }
    this.b.a();
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.a)
    {
      this.a.f(paramBoolean);
      return;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if (this.a != null) {
      this.a.a(paramArrayOfString);
    }
  }
  
  public boolean a(Context paramContext, a parama)
  {
    return a(paramContext, parama, parama.b());
  }
  
  public boolean a(Context paramContext, a parama, kt paramkt)
  {
    this.r = parama;
    if (this.r.d() != null) {
      d.a = this.r.d().a();
    }
    d.c("initEngine");
    Object localObject = parama.a();
    this.q = ((jt)localObject);
    this.a.a(parama.b());
    this.b = new com.tencent.map.lib.gl.b(100);
    this.v = parama.c();
    this.m = new jr(paramContext, this, (jt)localObject, this.v);
    parama = ((jt)localObject).c();
    String str = ((jt)localObject).a();
    localObject = ((jt)localObject).b();
    this.m.a();
    boolean bool = this.a.a(paramContext, this.m, parama, str, (String)localObject, 2.0F);
    this.m.b();
    this.f = new je(this, this.b, this.a);
    if (this.d == null) {
      this.d = new jz(this, paramkt);
    }
    if (this.z == null) {
      this.z = new iy(this, this.r.b());
    }
    this.a.n();
    this.a.e(true);
    this.a.c(19);
    this.a.d(3);
    m(false);
    this.c.a(this);
    return bool;
  }
  
  public String b(GeoPoint paramGeoPoint)
  {
    if (this.a != null) {
      return this.a.b(paramGeoPoint);
    }
    return null;
  }
  
  public WeakReference<jb> b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    if ((this.a != null) && (this.t != null)) {
      if ((Integer)this.t.a(Integer.valueOf(paramInt)) == null) {
        break label59;
      }
    }
    label59:
    for (int i1 = ((Integer)this.t.a(Integer.valueOf(paramInt))).intValue();; i1 = 0)
    {
      this.a.a(paramInt, i1);
      return;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.i != null) {
      this.i.set(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void b(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    if (this.x == null) {
      this.x = new jh.b(this);
    }
    this.x.b(paramMapLanguageChangeListener);
  }
  
  public void b(Polygon2D paramPolygon2D)
  {
    if ((this.a == null) || (paramPolygon2D == null)) {
      return;
    }
    paramPolygon2D.borderWidth *= SystemUtil.getDensity(this.l);
    this.a.b(paramPolygon2D);
  }
  
  public void b(String paramString)
  {
    if (this.a != null) {
      this.a.d(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.d != null)
    {
      this.k = paramBoolean;
      if (paramBoolean)
      {
        J();
        this.d.b();
      }
    }
    else
    {
      return;
    }
    K();
    this.d.e();
  }
  
  public boolean b(GL10 paramGL10)
  {
    if (this.a == null) {
      return false;
    }
    boolean bool;
    e locale;
    synchronized (this.a)
    {
      this.c.C();
      c(paramGL10);
      this.a.w();
      if ((this.a.x()) || (this.s))
      {
        bool = true;
        if (bool)
        {
          locale = this.n.a(paramGL10);
          if (locale != null) {
            break label220;
          }
          this.e.a(this.f, this.h);
        }
      }
    }
    for (;;)
    {
      synchronized (this.a)
      {
        this.a.c();
        this.s = false;
        if ((!this.n.a()) && (locale != null))
        {
          if (locale.c()) {
            break label270;
          }
          if ((this.a.g()) || (e.a(locale) >= 100))
          {
            e.a(locale, 0);
            this.n.b(paramGL10, this.f, this.h);
          }
        }
        else
        {
          if (this.f != null) {
            this.f.c();
          }
          if (this.f != null) {
            this.f.a();
          }
          return bool;
          paramGL10 = finally;
          throw paramGL10;
          bool = false;
          break;
          label220:
          if ((this.n == null) || (!this.a.g())) {
            continue;
          }
          this.n.a(paramGL10, this.f, this.h);
        }
      }
      e.b(locale);
      continue;
      label270:
      e.a(locale, 0);
    }
  }
  
  public jg c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramInt);
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int i1 = 255;
    if (this.a == null) {
      return;
    }
    if (paramInt2 < 0) {
      paramInt2 = 0;
    }
    for (;;)
    {
      if (paramInt2 > 255) {
        paramInt2 = i1;
      }
      for (;;)
      {
        i1 = 255 - paramInt2;
        paramInt2 = i1;
        if (i1 == 0) {
          paramInt2 = 1;
        }
        this.a.b(paramInt1, paramInt2);
        return;
      }
    }
  }
  
  public void c(String paramString)
  {
    this.A = paramString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.g(paramBoolean);
  }
  
  public iu d()
  {
    return this.h;
  }
  
  public void d(int paramInt)
  {
    if (this.a != null)
    {
      this.a.e(paramInt);
      this.s = true;
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.d(paramInt1, paramInt2);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.C == paramBoolean) {}
    do
    {
      return;
      this.C = paramBoolean;
    } while (this.a == null);
    this.a.a(paramBoolean);
  }
  
  public jo e()
  {
    return this.o;
  }
  
  public void e(int paramInt)
  {
    if (this.a != null) {
      this.a.f(paramInt);
    }
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.c(paramInt1, paramInt2);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    this.w = paramBoolean;
    if (this.L)
    {
      if ((paramBoolean) && (this.c.t())) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        m(paramBoolean);
        return;
      }
    }
    if (!paramBoolean)
    {
      paramBoolean = bool2;
      if (!this.c.t()) {}
    }
    else
    {
      paramBoolean = true;
    }
    m(paramBoolean);
  }
  
  public jc f()
  {
    return this.a;
  }
  
  public void f(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public Rect g()
  {
    return this.i;
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
  }
  
  public float h()
  {
    if (this.l == null) {
      return 1.0F;
    }
    return SystemUtil.getDensity(this.l);
  }
  
  public void h(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
  }
  
  public jc i()
  {
    return this.a;
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.r == null) {
      return;
    }
    if (this.z == null) {
      this.z = new iy(this, this.r.b());
    }
    this.z.a(paramBoolean);
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.h(paramBoolean);
    }
  }
  
  public boolean j()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.b();
  }
  
  public com.tencent.map.lib.gl.b k()
  {
    return this.b;
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.i(paramBoolean);
    }
  }
  
  public Context l()
  {
    return this.l;
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.c != null) {
      this.c.c(paramBoolean);
    }
  }
  
  public void m()
  {
    if (this.a == null) {
      return;
    }
    this.s = true;
    this.B = true;
    if (this.u)
    {
      this.c.c();
      this.u = false;
    }
    for (;;)
    {
      if ((this.g != null) && (this.g.get() != null)) {
        ((jb)this.g.get()).f();
      }
      if (this.j) {
        this.a.i();
      }
      if ((this.k) && (this.d != null)) {
        this.d.d();
      }
      if (this.z == null) {
        break;
      }
      this.z.c();
      return;
      this.c.d();
    }
  }
  
  public void n()
  {
    if (this.a == null) {}
    do
    {
      return;
      this.s = false;
      this.B = false;
      if (this.z != null) {
        this.z.d();
      }
      this.c.e();
      this.a.j();
    } while ((!this.k) || (this.d == null));
    this.d.c();
  }
  
  public void o()
  {
    this.c.b(this);
    if (this.y != null) {
      this.y.a();
    }
    this.c.f();
    this.u = true;
    if (this.z != null) {
      this.z.e();
    }
    if (this.d != null) {
      this.d.f();
    }
    if (this.a != null) {
      this.a.a();
    }
    this.l = null;
  }
  
  public jr p()
  {
    return this.m;
  }
  
  public Rect q()
  {
    return this.F;
  }
  
  public void r()
  {
    this.s = true;
  }
  
  public int s()
  {
    if (this.a != null) {
      return this.a.d();
    }
    return -1;
  }
  
  public void t()
  {
    if (this.a != null) {
      this.a.e();
    }
  }
  
  public String toString()
  {
    if (this.o != null) {
      return this.o.toString();
    }
    return "";
  }
  
  public void u()
  {
    if (this.a != null) {
      this.a.f();
    }
  }
  
  public boolean v()
  {
    return this.k;
  }
  
  public void w()
  {
    if (this.y == null) {
      this.y = new jh.c(this);
    }
    this.y.b();
  }
  
  public void x()
  {
    this.c.z();
    this.s = true;
  }
  
  public String[] y()
  {
    if (this.a != null) {
      return this.a.p();
    }
    return null;
  }
  
  public String z()
  {
    if (this.a != null) {
      return this.a.r();
    }
    return null;
  }
  
  private class e
  {
    private int a;
    private js b;
    private kj c;
    private int d;
    private int e;
    private Rect f;
    private int g;
    
    /* Error */
    public boolean a()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 38	com/tencent/tencentmap/mapsdk/a/jh$e:g	I
      //   6: istore_1
      //   7: iload_1
      //   8: iconst_2
      //   9: if_icmpne +9 -> 18
      //   12: iconst_1
      //   13: istore_2
      //   14: aload_0
      //   15: monitorexit
      //   16: iload_2
      //   17: ireturn
      //   18: iconst_0
      //   19: istore_2
      //   20: goto -6 -> 14
      //   23: astore_3
      //   24: aload_0
      //   25: monitorexit
      //   26: aload_3
      //   27: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	28	0	this	e
      //   6	4	1	i	int
      //   13	7	2	bool	boolean
      //   23	4	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	7	23	finally
    }
    
    public void b()
    {
      try
      {
        this.g = 2;
        this.a = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public boolean c()
    {
      return this.g == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.jh
 * JD-Core Version:    0.7.0.1
 */