package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.a;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.d;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.gl.JNICallback.l;
import com.tencent.map.lib.listener.MapLanguageChangeListener;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import javax.microedition.khronos.opengles.GL10;

public class ik
  implements hl, hs
{
  private String A;
  private boolean B;
  private boolean C;
  private int D;
  private int E;
  private Rect F;
  private float G;
  private float H;
  private boolean I;
  private int J;
  private int K;
  private boolean L;
  private JNICallback.h M;
  private if a;
  private com.tencent.map.lib.gl.b b;
  private ii c;
  private iy d;
  private ij e;
  private ih f;
  private WeakReference<ic> g;
  private hn h;
  private Rect i;
  private boolean j;
  private boolean k;
  private Context l;
  private it m;
  private ik.d n;
  private iq o;
  private LinkedBlockingQueue<ik.a> p;
  private iv q;
  private a r;
  private volatile boolean s;
  private com.tencent.map.lib.util.c<Integer, Integer> t;
  private boolean u;
  private com.tencent.map.lib.b v;
  private boolean w;
  private ik.b x;
  private ik.c y;
  private ia z;
  
  public ik(Context paramContext, ic paramic)
  {
    AppMethodBeat.i(148468);
    this.s = false;
    this.u = true;
    this.w = true;
    this.B = true;
    this.C = false;
    this.D = 0;
    this.E = 0;
    this.G = 0.5F;
    this.H = 0.5F;
    this.I = true;
    this.J = 18;
    this.K = 14;
    this.L = false;
    this.l = paramContext;
    this.g = new WeakReference(paramic);
    this.a = new if(paramContext, this);
    this.o = new iq(this);
    this.i = new Rect();
    this.e = new ij(this);
    this.h = new hn(this.o, this);
    this.c = new ii(this);
    this.a.a(this.c);
    this.n = new ik.d(this, null);
    this.p = new LinkedBlockingQueue();
    AppMethodBeat.o(148468);
  }
  
  private void J()
  {
    AppMethodBeat.i(148505);
    if (this.a != null) {
      this.a.k();
    }
    AppMethodBeat.o(148505);
  }
  
  private void K()
  {
    AppMethodBeat.i(148506);
    if (this.a != null) {
      this.a.l();
    }
    AppMethodBeat.o(148506);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(148479);
    this.a.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.D = paramInt3;
    this.E = paramInt4;
    if (paramBoolean) {
      a(this.G, this.H, this.I);
    }
    AppMethodBeat.o(148479);
  }
  
  private void c(GL10 paramGL10)
  {
    AppMethodBeat.i(148482);
    if (this.p.size() == 0)
    {
      AppMethodBeat.o(148482);
      return;
    }
    int i1 = 1;
    while (i1 != 0)
    {
      ik.a locala = (ik.a)this.p.poll();
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
    AppMethodBeat.o(148482);
  }
  
  private void l(boolean paramBoolean)
  {
    AppMethodBeat.i(148510);
    if (this.a != null) {
      this.a.b(paramBoolean);
    }
    AppMethodBeat.o(148510);
  }
  
  public boolean A()
  {
    AppMethodBeat.i(148534);
    if (this.z == null)
    {
      AppMethodBeat.o(148534);
      return false;
    }
    boolean bool = this.z.a();
    AppMethodBeat.o(148534);
    return bool;
  }
  
  public void B()
  {
    AppMethodBeat.i(148535);
    if ((this.z == null) || (!this.z.a()))
    {
      AppMethodBeat.o(148535);
      return;
    }
    this.z.b();
    AppMethodBeat.o(148535);
  }
  
  public iv C()
  {
    return this.q;
  }
  
  public String D()
  {
    AppMethodBeat.i(148539);
    String str = null;
    if (this.a != null) {
      str = this.a.B();
    }
    AppMethodBeat.o(148539);
    return str;
  }
  
  @Deprecated
  protected boolean E()
  {
    AppMethodBeat.i(148540);
    if (this.a != null)
    {
      boolean bool = this.a.g();
      AppMethodBeat.o(148540);
      return bool;
    }
    AppMethodBeat.o(148540);
    return false;
  }
  
  public ArrayList<MapPoi> F()
  {
    AppMethodBeat.i(148542);
    if (this.a == null)
    {
      AppMethodBeat.o(148542);
      return null;
    }
    ArrayList localArrayList = this.a.D();
    AppMethodBeat.o(148542);
    return localArrayList;
  }
  
  public String G()
  {
    AppMethodBeat.i(148543);
    if (this.a == null)
    {
      AppMethodBeat.o(148543);
      return null;
    }
    String str = this.a.C();
    AppMethodBeat.o(148543);
    return str;
  }
  
  public String H()
  {
    AppMethodBeat.i(148544);
    if (this.a == null)
    {
      AppMethodBeat.o(148544);
      return null;
    }
    String str = this.a.E();
    AppMethodBeat.o(148544);
    return str;
  }
  
  public void I()
  {
    AppMethodBeat.i(148546);
    if (this.M != null) {
      this.M.q();
    }
    AppMethodBeat.o(148546);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat)
  {
    int i2 = 255;
    AppMethodBeat.i(148493);
    if (this.a == null)
    {
      AppMethodBeat.o(148493);
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
                    AppMethodBeat.o(148493);
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
    AppMethodBeat.i(148515);
    if (this.a != null)
    {
      paramInt = this.a.d(paramInt, paramBoolean);
      AppMethodBeat.o(148515);
      return paramInt;
    }
    AppMethodBeat.o(148515);
    return -1;
  }
  
  public int a(CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(148490);
    if ((this.a == null) || (paramCircleInfo == null))
    {
      AppMethodBeat.o(148490);
      return -1;
    }
    int i1 = this.a.a(paramCircleInfo);
    AppMethodBeat.o(148490);
    return i1;
  }
  
  public int a(Polygon2D paramPolygon2D)
  {
    AppMethodBeat.i(148488);
    if ((this.a == null) || (paramPolygon2D == null))
    {
      AppMethodBeat.o(148488);
      return -1;
    }
    int i1 = this.a.a(paramPolygon2D);
    if (this.t == null) {
      this.t = new com.tencent.map.lib.util.c();
    }
    this.t.a(Integer.valueOf(i1), Integer.valueOf(paramPolygon2D.borldLineId));
    AppMethodBeat.o(148488);
    return i1;
  }
  
  public TappedElement a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148531);
    if (this.a != null)
    {
      TappedElement localTappedElement = this.a.a(paramFloat1, paramFloat2);
      AppMethodBeat.o(148531);
      return localTappedElement;
    }
    AppMethodBeat.o(148531);
    return null;
  }
  
  public ii a()
  {
    return this.c;
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148502);
    if ((this.r != null) && (this.v != null))
    {
      String str = this.v.a(paramGeoPoint);
      if (str != null)
      {
        AppMethodBeat.o(148502);
        return str;
      }
    }
    if (this.a == null)
    {
      AppMethodBeat.o(148502);
      return "";
    }
    paramGeoPoint = this.a.a(paramGeoPoint);
    AppMethodBeat.o(148502);
    return paramGeoPoint;
  }
  
  public List<Integer> a(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(148499);
    paramRect = this.a.a(paramRect, paramInt);
    AppMethodBeat.o(148499);
    return paramRect;
  }
  
  public void a(double paramDouble)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148509);
    int i1;
    if (this.c.p() > 1.0E-010D)
    {
      i1 = 1;
      if (!this.L) {
        break label94;
      }
      if ((!this.w) || (i1 == 0)) {
        break label88;
      }
      label47:
      l(bool1);
    }
    for (;;)
    {
      if ((!iz.a()) && (this.c.t())) {
        this.a.n();
      }
      AppMethodBeat.o(148509);
      return;
      i1 = 0;
      break;
      label88:
      bool1 = false;
      break label47;
      label94:
      if (!this.w)
      {
        bool1 = bool2;
        if (i1 == 0) {}
      }
      else
      {
        bool1 = true;
      }
      l(bool1);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(148480);
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
    AppMethodBeat.o(148480);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(148492);
    if ((this.a == null) || (paramInt == -1))
    {
      AppMethodBeat.o(148492);
      return;
    }
    this.a.a(paramInt);
    AppMethodBeat.o(148492);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148477);
    if (this.a == null)
    {
      AppMethodBeat.o(148477);
      return;
    }
    this.s = true;
    this.i.set(0, 0, paramInt1, paramInt2);
    a(0, 0, paramInt1, paramInt2, false);
    this.c.v();
    AppMethodBeat.o(148477);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148516);
    if (this.a == null)
    {
      AppMethodBeat.o(148516);
      return;
    }
    this.a.a(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(148516);
  }
  
  public void a(int paramInt, CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(148491);
    if ((this.a == null) || (paramCircleInfo == null))
    {
      AppMethodBeat.o(148491);
      return;
    }
    this.a.a(paramInt, paramCircleInfo);
    AppMethodBeat.o(148491);
  }
  
  public void a(Rect paramRect)
  {
    AppMethodBeat.i(148478);
    if ((this.i == null) || (paramRect == null))
    {
      AppMethodBeat.o(148478);
      return;
    }
    this.F = paramRect;
    int i1 = this.i.width();
    int i2 = this.i.height();
    a(paramRect.left, paramRect.bottom, i1 - paramRect.right - paramRect.left, i2 - paramRect.bottom - paramRect.top, true);
    AppMethodBeat.o(148478);
  }
  
  public void a(JNICallback.b paramb)
  {
    AppMethodBeat.i(148521);
    if (this.a != null) {
      this.a.a(paramb);
    }
    AppMethodBeat.o(148521);
  }
  
  public void a(JNICallback.c paramc)
  {
    AppMethodBeat.i(148522);
    if (this.a != null) {
      this.a.a(paramc);
    }
    AppMethodBeat.o(148522);
  }
  
  public void a(JNICallback.d paramd)
  {
    AppMethodBeat.i(148519);
    if (this.a != null) {
      this.a.a(paramd);
    }
    AppMethodBeat.o(148519);
  }
  
  public void a(JNICallback.e parame)
  {
    AppMethodBeat.i(148514);
    if (this.a != null) {
      this.a.a(parame);
    }
    AppMethodBeat.o(148514);
  }
  
  public void a(JNICallback.h paramh)
  {
    this.M = paramh;
  }
  
  public void a(JNICallback.k paramk)
  {
    AppMethodBeat.i(148520);
    if (this.a != null) {
      this.a.a(paramk);
    }
    AppMethodBeat.o(148520);
  }
  
  public void a(JNICallback.l paraml)
  {
    AppMethodBeat.i(148523);
    if (this.a != null) {
      this.a.a(paraml);
    }
    AppMethodBeat.o(148523);
  }
  
  public void a(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    AppMethodBeat.i(148529);
    if (this.x == null) {
      this.x = new ik.b(this);
    }
    this.x.a(paramMapLanguageChangeListener);
    AppMethodBeat.o(148529);
  }
  
  public void a(ik.a parama)
  {
    AppMethodBeat.i(148474);
    try
    {
      this.p.put(parama);
      AppMethodBeat.o(148474);
      return;
    }
    catch (InterruptedException parama)
    {
      AppMethodBeat.o(148474);
    }
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(148503);
    if (this.a != null) {
      this.a.f(paramString);
    }
    AppMethodBeat.o(148503);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148541);
    if (this.a == null)
    {
      AppMethodBeat.o(148541);
      return;
    }
    this.a.a(paramString1, paramString2);
    AppMethodBeat.o(148541);
  }
  
  public void a(List<BlockRouteCityData> paramList)
  {
    AppMethodBeat.i(148500);
    this.a.a(paramList);
    AppMethodBeat.o(148500);
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(148497);
    if (this.y == null) {
      this.y = new ik.c(this);
    }
    this.y.a(paramList, paramList1);
    AppMethodBeat.o(148497);
  }
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148476);
    if (this.a == null)
    {
      AppMethodBeat.o(148476);
      return;
    }
    if (this.b != null) {
      this.b.a();
    }
    AppMethodBeat.o(148476);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(148487);
    if (this.d != null)
    {
      this.k = paramBoolean;
      if (paramBoolean)
      {
        J();
        this.d.b();
        AppMethodBeat.o(148487);
        return;
      }
      K();
      this.d.e();
    }
    AppMethodBeat.o(148487);
  }
  
  public void a(String[] paramArrayOfString)
  {
    AppMethodBeat.i(148513);
    if (this.a != null) {
      this.a.a(paramArrayOfString);
    }
    AppMethodBeat.o(148513);
  }
  
  public boolean a(Context paramContext, a parama, jd paramjd)
  {
    AppMethodBeat.i(148469);
    this.r = parama;
    if (this.r.d() != null) {
      d.a = this.r.d().a();
    }
    d.c("initEngine");
    Object localObject = parama.a();
    this.q = ((iv)localObject);
    this.a.a(parama.b());
    this.b = new com.tencent.map.lib.gl.b(100);
    this.v = parama.c();
    this.m = new it(paramContext, this, (iv)localObject, this.v);
    parama = ((iv)localObject).c();
    String str = ((iv)localObject).a();
    localObject = ((iv)localObject).b();
    try
    {
      this.m.a();
      boolean bool = this.a.a(paramContext, this.m, parama, str, (String)localObject, 2.0F);
      this.m.b();
      this.f = new ih(this, this.b, this.a);
      if (this.d == null) {
        this.d = new iy(this, paramjd);
      }
      if (this.z == null) {
        this.z = new hy(this, this.r.b());
      }
      this.a.n();
      this.a.e(true);
      this.a.d(20);
      this.a.e(3);
      l(false);
      this.c.a(this);
      AppMethodBeat.o(148469);
      return bool;
    }
    finally
    {
      this.m.b();
      AppMethodBeat.o(148469);
    }
  }
  
  public WeakReference<ic> b()
  {
    return this.g;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(148495);
    if (this.a == null)
    {
      AppMethodBeat.o(148495);
      return;
    }
    this.a.b(paramInt);
    AppMethodBeat.o(148495);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148481);
    if (this.i != null) {
      this.i.set(0, 0, paramInt1, paramInt2);
    }
    AppMethodBeat.o(148481);
  }
  
  public void b(MapLanguageChangeListener paramMapLanguageChangeListener)
  {
    AppMethodBeat.i(148530);
    if (this.x == null) {
      this.x = new ik.b(this);
    }
    this.x.b(paramMapLanguageChangeListener);
    AppMethodBeat.o(148530);
  }
  
  public void b(Polygon2D paramPolygon2D)
  {
    AppMethodBeat.i(148489);
    if ((this.a == null) || (paramPolygon2D == null))
    {
      AppMethodBeat.o(148489);
      return;
    }
    this.a.b(paramPolygon2D);
    AppMethodBeat.o(148489);
  }
  
  public void b(String paramString)
  {
    AppMethodBeat.i(148527);
    if (this.a != null) {
      this.a.e(paramString);
    }
    AppMethodBeat.o(148527);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(148501);
    this.a.f(paramBoolean);
    AppMethodBeat.o(148501);
  }
  
  public boolean b(GL10 paramGL10)
  {
    AppMethodBeat.i(148483);
    if (this.a == null)
    {
      AppMethodBeat.o(148483);
      return false;
    }
    boolean bool;
    ik.e locale;
    synchronized (this.a)
    {
      this.c.C();
      c(paramGL10);
      this.a.t();
      if ((this.a.u()) || (this.s))
      {
        bool = true;
        if (bool)
        {
          locale = this.n.a(paramGL10);
          if (locale != null) {
            break label244;
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
            break label300;
          }
          if ((this.a.g()) || (ik.e.a(locale) >= 100))
          {
            ik.e.a(locale, 0);
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
          AppMethodBeat.o(148483);
          return bool;
          paramGL10 = finally;
          AppMethodBeat.o(148483);
          throw paramGL10;
          bool = false;
          break;
          label244:
          if ((this.n == null) || (!this.a.g())) {
            continue;
          }
          this.n.a(paramGL10, this.f, this.h);
        }
      }
      ik.e.b(locale);
      continue;
      label300:
      ik.e.a(locale, 0);
    }
  }
  
  public ij c()
  {
    return this.e;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(148496);
    if ((this.a != null) && (this.t != null)) {
      if ((Integer)this.t.a(Integer.valueOf(paramInt)) == null) {
        break label71;
      }
    }
    label71:
    for (int i1 = ((Integer)this.t.a(Integer.valueOf(paramInt))).intValue();; i1 = 0)
    {
      this.a.a(paramInt, i1);
      AppMethodBeat.o(148496);
      return;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    int i1 = 255;
    AppMethodBeat.i(148494);
    if (this.a == null)
    {
      AppMethodBeat.o(148494);
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
        AppMethodBeat.o(148494);
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
    AppMethodBeat.i(148504);
    if (this.C == paramBoolean)
    {
      AppMethodBeat.o(148504);
      return;
    }
    this.C = paramBoolean;
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
    AppMethodBeat.o(148504);
  }
  
  public hu d()
  {
    return this.h;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(148512);
    if (this.a != null) {
      this.a.c(paramInt);
    }
    AppMethodBeat.o(148512);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148524);
    if (this.a != null) {
      this.a.d(paramInt1, paramInt2);
    }
    AppMethodBeat.o(148524);
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    AppMethodBeat.i(148508);
    this.w = paramBoolean;
    if (this.L)
    {
      if ((paramBoolean) && (this.c.t())) {}
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        l(paramBoolean);
        AppMethodBeat.o(148508);
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
    l(paramBoolean);
    AppMethodBeat.o(148508);
  }
  
  public iq e()
  {
    return this.o;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(148517);
    if (this.a != null)
    {
      this.a.f(paramInt);
      this.s = true;
    }
    AppMethodBeat.o(148517);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148526);
    if (this.a != null) {
      this.a.c(paramInt1, paramInt2);
    }
    AppMethodBeat.o(148526);
  }
  
  public void e(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public if f()
  {
    return this.a;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(148518);
    if (this.a != null) {
      this.a.g(paramInt);
    }
    AppMethodBeat.o(148518);
  }
  
  public void f(boolean paramBoolean)
  {
    AppMethodBeat.i(148511);
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
    AppMethodBeat.o(148511);
  }
  
  public Rect g()
  {
    return this.i;
  }
  
  public void g(boolean paramBoolean)
  {
    AppMethodBeat.i(148525);
    this.c.a(paramBoolean);
    AppMethodBeat.o(148525);
  }
  
  public boolean g(int paramInt)
  {
    AppMethodBeat.i(148545);
    if (this.a == null)
    {
      AppMethodBeat.o(148545);
      return false;
    }
    boolean bool = this.a.i(paramInt);
    AppMethodBeat.o(148545);
    return bool;
  }
  
  public float h()
  {
    AppMethodBeat.i(148475);
    if (this.l == null)
    {
      AppMethodBeat.o(148475);
      return 1.0F;
    }
    float f1 = SystemUtil.getDensity(this.l);
    AppMethodBeat.o(148475);
    return f1;
  }
  
  public void h(boolean paramBoolean)
  {
    AppMethodBeat.i(148533);
    if (this.r == null)
    {
      AppMethodBeat.o(148533);
      return;
    }
    if (this.z == null) {
      this.z = new hy(this, this.r.b());
    }
    this.z.a(paramBoolean);
    AppMethodBeat.o(148533);
  }
  
  public if i()
  {
    return this.a;
  }
  
  public void i(boolean paramBoolean)
  {
    AppMethodBeat.i(148536);
    if (this.a != null) {
      this.a.g(paramBoolean);
    }
    AppMethodBeat.o(148536);
  }
  
  public void j(boolean paramBoolean)
  {
    AppMethodBeat.i(148537);
    if (this.a != null) {
      this.a.h(paramBoolean);
    }
    AppMethodBeat.o(148537);
  }
  
  public boolean j()
  {
    AppMethodBeat.i(148470);
    if (this.a == null)
    {
      AppMethodBeat.o(148470);
      return false;
    }
    boolean bool = this.a.b();
    AppMethodBeat.o(148470);
    return bool;
  }
  
  public Context k()
  {
    return this.l;
  }
  
  public void k(boolean paramBoolean)
  {
    AppMethodBeat.i(148538);
    if (this.c != null) {
      this.c.c(paramBoolean);
    }
    AppMethodBeat.o(148538);
  }
  
  public void l()
  {
    AppMethodBeat.i(148471);
    if (this.a == null)
    {
      AppMethodBeat.o(148471);
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
        ((ic)this.g.get()).a_();
      }
      if (this.j) {
        this.a.i();
      }
      if ((this.k) && (this.d != null)) {
        this.d.d();
      }
      if (this.z != null) {
        this.z.c();
      }
      AppMethodBeat.o(148471);
      return;
      this.c.d();
    }
  }
  
  public void m()
  {
    AppMethodBeat.i(148472);
    if (this.a == null)
    {
      AppMethodBeat.o(148472);
      return;
    }
    this.s = false;
    this.B = false;
    if (this.z != null) {
      this.z.d();
    }
    this.c.e();
    this.a.j();
    if ((this.k) && (this.d != null)) {
      this.d.c();
    }
    AppMethodBeat.o(148472);
  }
  
  public void n()
  {
    AppMethodBeat.i(148473);
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
    AppMethodBeat.o(148473);
  }
  
  public it o()
  {
    return this.m;
  }
  
  public Rect p()
  {
    return this.F;
  }
  
  public void q()
  {
    this.s = true;
  }
  
  public int r()
  {
    AppMethodBeat.i(148484);
    if (this.a != null)
    {
      int i1 = this.a.d();
      AppMethodBeat.o(148484);
      return i1;
    }
    AppMethodBeat.o(148484);
    return -1;
  }
  
  public void s()
  {
    AppMethodBeat.i(148485);
    if (this.a != null) {
      this.a.e();
    }
    AppMethodBeat.o(148485);
  }
  
  public void t()
  {
    AppMethodBeat.i(148486);
    if (this.a != null) {
      this.a.f();
    }
    AppMethodBeat.o(148486);
  }
  
  public String toString()
  {
    AppMethodBeat.i(148532);
    if (this.o != null)
    {
      String str = this.o.toString();
      AppMethodBeat.o(148532);
      return str;
    }
    AppMethodBeat.o(148532);
    return "";
  }
  
  public boolean u()
  {
    return this.k;
  }
  
  public void v()
  {
    AppMethodBeat.i(148498);
    if (this.y == null) {
      this.y = new ik.c(this);
    }
    this.y.b();
    AppMethodBeat.o(148498);
  }
  
  public void w()
  {
    AppMethodBeat.i(148507);
    this.c.z();
    this.s = true;
    AppMethodBeat.o(148507);
  }
  
  public MapLanguage x()
  {
    AppMethodBeat.i(148528);
    if (this.x == null) {
      this.x = new ik.b(this);
    }
    MapLanguage localMapLanguage = this.x.a();
    AppMethodBeat.o(148528);
    return localMapLanguage;
  }
  
  public ih y()
  {
    return this.f;
  }
  
  public String z()
  {
    return this.A;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ik
 * JD-Core Version:    0.7.0.1
 */