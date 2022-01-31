package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.e;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ah.a;
import com.tencent.tencentmap.mapsdk.a.ah.c;
import com.tencent.tencentmap.mapsdk.a.ah.d;
import com.tencent.tencentmap.mapsdk.a.ah.e;
import com.tencent.tencentmap.mapsdk.a.ah.f;
import com.tencent.tencentmap.mapsdk.a.ah.g;
import com.tencent.tencentmap.mapsdk.a.ah.h;
import com.tencent.tencentmap.mapsdk.a.ah.i;
import com.tencent.tencentmap.mapsdk.a.ah.j;
import com.tencent.tencentmap.mapsdk.a.ah.k;
import com.tencent.tencentmap.mapsdk.a.ah.l;
import com.tencent.tencentmap.mapsdk.a.ai;
import com.tencent.tencentmap.mapsdk.a.ap.b;
import com.tencent.tencentmap.mapsdk.a.aq;
import com.tencent.tencentmap.mapsdk.a.au.a;
import com.tencent.tencentmap.mapsdk.a.bh;
import com.tencent.tencentmap.mapsdk.a.bm;
import com.tencent.tencentmap.mapsdk.a.bz;
import com.tencent.tencentmap.mapsdk.a.cf;
import com.tencent.tencentmap.mapsdk.a.cj;
import com.tencent.tencentmap.mapsdk.a.cn;
import com.tencent.tencentmap.mapsdk.a.cn.a;
import com.tencent.tencentmap.mapsdk.a.cu;
import com.tencent.tencentmap.mapsdk.a.cx;
import com.tencent.tencentmap.mapsdk.a.cz;
import com.tencent.tencentmap.mapsdk.a.db;
import com.tencent.tencentmap.mapsdk.a.dc;
import com.tencent.tencentmap.mapsdk.a.dl;
import com.tencent.tencentmap.mapsdk.a.dn;
import com.tencent.tencentmap.mapsdk.a.dp;
import com.tencent.tencentmap.mapsdk.a.p;
import com.tencent.tencentmap.mapsdk.a.r;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class kx
  extends ib
  implements ah.c, kn
{
  public float A;
  public float B;
  protected boolean C;
  protected boolean D;
  protected boolean E;
  protected boolean F;
  protected boolean G;
  protected boolean H;
  public Handler I;
  public volatile boolean J;
  public volatile boolean K;
  protected int L;
  public cz M;
  public cz N;
  public int O;
  public int P;
  public int Q;
  public int R;
  public int S;
  public int T;
  public int U;
  public boolean V;
  public ju W;
  private String X;
  private boolean Y;
  private List<jx> Z;
  private int aA;
  private int aB;
  private GeoPoint aC;
  private nn aD;
  private boolean aE;
  private float aF;
  private float aG;
  private boolean aH;
  private volatile boolean aI;
  private boolean aJ;
  private int aK;
  private int aL;
  private int aM;
  private boolean aN;
  private int aO;
  private int aP;
  private float aQ;
  private AtomicBoolean aR;
  private boolean aS;
  private boolean aT;
  private final id aU;
  private com.tencent.map.lib.basemap.data.a aV;
  private boolean aW;
  private boolean aX;
  private la aY;
  private List<jv> aZ;
  private List<jx> aa;
  private List<jx> ab;
  private List<jx> ac;
  private bm ad;
  private np ae;
  private lo af;
  private List<jx> ag;
  private ne ah;
  private cf ai;
  private nf.a aj;
  private Map<Class<? extends jx>, bz> ak;
  private List<aq> al;
  private ah.e am;
  private final ir an;
  private e ao;
  private final hr ap;
  private ap.b aq;
  private ht ar;
  private Handler as;
  private bh at;
  private com.tencent.map.lib.a au;
  private Comparator<jx> av;
  private Bitmap.Config aw;
  private boolean ax;
  private int ay;
  private int az;
  public byte[] b;
  private List<MapPoi> ba;
  public ju c;
  public kd d;
  public kd e;
  public kd f;
  public kd g;
  protected volatile cu h;
  public int i;
  public nc j;
  protected dn k;
  public cj l;
  public ah.h m;
  public au.a n;
  public List<ah.c> o;
  public ah.j p;
  public volatile ah.i q;
  protected ah.f r;
  public ah.l s;
  public ah.g t;
  public ah.k u;
  protected final Handler v;
  public ah.a w;
  public ah.d x;
  public float y;
  public float z;
  
  public kx(ie paramie, Context paramContext, ai paramai)
  {
    super(paramie, paramContext, paramai);
    AppMethodBeat.i(149023);
    this.b = new byte[0];
    this.X = "";
    this.c = null;
    this.Y = false;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.i = 22;
    this.Z = new ArrayList();
    this.aa = new ArrayList();
    this.ab = new ArrayList();
    this.ac = new ArrayList();
    this.ae = null;
    this.ag = new ArrayList();
    this.ai = null;
    this.k = null;
    this.l = null;
    this.aj = null;
    this.ak = new HashMap();
    this.al = null;
    this.m = null;
    this.n = null;
    this.o = new CopyOnWriteArrayList();
    this.p = null;
    this.q = null;
    this.am = null;
    this.s = null;
    this.t = null;
    this.u = null;
    this.ao = new ko(this);
    this.w = null;
    this.x = null;
    this.aq = null;
    this.ar = new kr(this);
    this.av = new kx.1(this);
    this.aw = Bitmap.Config.RGB_565;
    this.ax = true;
    this.ay = -2147483648;
    this.az = -2147483648;
    this.aA = -2147483648;
    this.aB = -2147483648;
    this.y = 0.5F;
    this.z = 0.5F;
    this.A = 0.5F;
    this.B = 0.5F;
    this.aC = null;
    this.aD = null;
    this.aE = false;
    this.aF = 100.0F;
    this.aG = 100.0F;
    this.aH = true;
    this.aI = false;
    this.aJ = false;
    this.aK = 10;
    this.aL = 0;
    this.aM = 0;
    this.aN = false;
    this.C = true;
    this.D = true;
    this.E = true;
    this.F = true;
    this.G = true;
    this.H = true;
    this.aO = 19;
    this.aP = 3;
    this.aQ = 0.0F;
    this.aR = new AtomicBoolean(false);
    this.I = null;
    this.aS = true;
    this.aT = true;
    this.J = false;
    this.K = false;
    this.L = 0;
    this.M = null;
    this.N = null;
    this.O = 0;
    this.P = 0;
    this.Q = 0;
    this.R = 0;
    this.S = 0;
    this.T = 0;
    this.U = 0;
    this.V = false;
    this.W = null;
    this.aW = false;
    this.aX = true;
    this.aZ = new ArrayList();
    this.ba = new ArrayList();
    this.v = new kl(this);
    this.ap = new kq(this);
    this.ao = new ko(this);
    this.aU = new kt(this);
    this.ar = new kr(this);
    this.an = new kp(this);
    this.aD = new nn();
    nn.a(paramContext);
    lm.a(paramContext);
    this.aO = b().c();
    this.aP = b().b();
    ni.a(paramContext);
    this.at = new nq();
    a(this.aU);
    b().a(this.an);
    b().a(this.ar);
    b().a(this.ao);
    b().a(this.ap);
    b().a(this);
    if (this.I == null) {
      this.I = new Handler();
    }
    paramie = (WindowManager)i().getSystemService("window");
    this.T = paramie.getDefaultDisplay().getWidth();
    this.U = paramie.getDefaultDisplay().getHeight();
    if ((paramai != null) && (!StringUtil.isEmpty(paramai.h()))) {}
    for (paramie = paramai.h();; paramie = null)
    {
      this.ai = new cf(this, paramie);
      this.ae = new np(this);
      if (paramai != null)
      {
        this.aE = paramai.c();
        this.V = paramai.i();
      }
      AppMethodBeat.o(149023);
      return;
    }
  }
  
  private boolean W()
  {
    AppMethodBeat.i(149049);
    boolean bool = nn.d();
    AppMethodBeat.o(149049);
    return bool;
  }
  
  private void X()
  {
    AppMethodBeat.i(149077);
    synchronized (this.b)
    {
      if (this.Z == null)
      {
        AppMethodBeat.o(149077);
        return;
      }
      Iterator localIterator = this.Z.iterator();
      if (localIterator.hasNext())
      {
        jx localjx = (jx)localIterator.next();
        if (localjx != null) {
          localjx.d();
        }
        localIterator.remove();
      }
    }
    this.aa.clear();
    this.ab.clear();
    this.ac.clear();
    AppMethodBeat.o(149077);
  }
  
  private b[] Y()
  {
    AppMethodBeat.i(149087);
    b localb1 = hn.a(b().t().a(new DoublePoint(0.0D, 0.0D)));
    b localb2 = hn.a(b().t().a(new DoublePoint(getWidth(), getHeight())));
    AppMethodBeat.o(149087);
    return new b[] { localb1, localb2 };
  }
  
  private void Z()
  {
    AppMethodBeat.i(149088);
    if (m())
    {
      if ((this.a instanceof View))
      {
        if (this.aY == null)
        {
          this.aY = new la((View)this.a, this);
          this.aY.b();
        }
        android.support.v4.view.t.a((View)this.a, this.aY);
        AppMethodBeat.o(149088);
      }
    }
    else if (this.aY != null)
    {
      android.support.v4.view.t.a((View)this.a, null);
      this.aY.c();
      this.aY = null;
    }
    AppMethodBeat.o(149088);
  }
  
  private Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(149076);
    if ((paramBitmap1 == null) || (paramBitmap1.isRecycled()) || (paramBitmap2 == null) || (paramBitmap2.isRecycled()))
    {
      AppMethodBeat.o(149076);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap1.getWidth(), paramBitmap1.getHeight(), paramBitmap1.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
    localCanvas.drawBitmap(paramBitmap2, this.ah.c().left, this.ah.c().top, null);
    AppMethodBeat.o(149076);
    return localBitmap;
  }
  
  private void a(ai paramai)
  {
    AppMethodBeat.i(149074);
    Context localContext = i().getApplicationContext();
    dp.a().a(localContext);
    p localp = p.a(localContext);
    com.tencent.tencentmap.mapsdk.a.t.a(localp.b());
    com.tencent.tencentmap.mapsdk.a.t.a(localp.c());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramai != null)
    {
      localObject1 = localObject2;
      if (!StringUtil.isEmpty(paramai.h())) {
        localObject1 = paramai.h();
      }
    }
    com.tencent.tencentmap.mapsdk.a.t.a(localp.b((String)localObject1));
    com.tencent.tencentmap.mapsdk.a.t.a(localp.c((String)localObject1));
    com.tencent.tencentmap.mapsdk.a.t.a(localp.d());
    if (paramai != null)
    {
      if (paramai.a() == null) {
        break label177;
      }
      r.a(paramai.a());
    }
    for (;;)
    {
      lk.a(localContext, (String)localObject1);
      this.au = new le(this, (String)localObject1);
      a(this.au, kj.a());
      b().b(jq.a());
      b().c(jq.c());
      AppMethodBeat.o(149074);
      return;
      label177:
      if (paramai.b() != null) {
        r.b(paramai.b());
      }
    }
  }
  
  private boolean a(cz paramcz, b[] paramArrayOfb)
  {
    AppMethodBeat.i(149086);
    if (paramcz == null)
    {
      AppMethodBeat.o(149086);
      return false;
    }
    paramcz = hn.a(ka.a(paramcz));
    if ((paramcz.b() >= paramArrayOfb[0].b()) && (paramcz.b() <= paramArrayOfb[1].b()) && (paramcz.a() <= paramArrayOfb[0].a()) && (paramcz.a() >= paramArrayOfb[1].a()))
    {
      AppMethodBeat.o(149086);
      return true;
    }
    AppMethodBeat.o(149086);
    return false;
  }
  
  private boolean a(jx paramjx, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149026);
    if ((paramjx == null) || (!paramjx.a()) || (!paramjx.r()))
    {
      AppMethodBeat.o(149026);
      return false;
    }
    if (!paramjx.a(paramFloat1, paramFloat2))
    {
      AppMethodBeat.o(149026);
      return false;
    }
    bz localbz = (bz)this.ak.get(paramjx.getClass());
    if (localbz != null)
    {
      boolean bool = localbz.a(paramjx, true, b().t().a(new DoublePoint(paramFloat1, paramFloat2)));
      AppMethodBeat.o(149026);
      return bool;
    }
    AppMethodBeat.o(149026);
    return false;
  }
  
  private void b(GL10 paramGL10)
  {
    AppMethodBeat.i(149025);
    int i2;
    int i1;
    Object localObject1;
    int i3;
    Object localObject2;
    for (;;)
    {
      synchronized (this.b)
      {
        i2 = this.Z.size();
        i1 = 0;
        localObject1 = null;
        if (i1 < i2)
        {
          i3 = i2;
          if (this.Z.size() > i2) {
            i3 = this.Z.size();
          }
          if (i1 < this.Z.size())
          {
            localjx = (jx)this.Z.get(i1);
            if (localjx == null) {
              break label245;
            }
            if (TextUtils.equals(localjx.A(), this.X))
            {
              localObject2 = localjx;
              if (localjx.a()) {
                break;
              }
              localObject2 = localjx;
              if (this.aN) {
                break;
              }
              localjx.b();
              localObject2 = localObject1;
              break;
            }
            if ((localjx instanceof jy))
            {
              ((jy)localjx).a(b().x(), b().t(), paramGL10);
              localObject2 = localObject1;
              break;
            }
            localjx.a(paramGL10);
            break label245;
          }
        }
        else
        {
          if (localObject1 != null) {
            localObject1.a(paramGL10);
          }
          AppMethodBeat.o(149025);
          return;
        }
      }
      jx localjx = null;
    }
    for (;;)
    {
      i1 += 1;
      localObject1 = localObject2;
      i2 = i3;
      break;
      label245:
      localObject2 = localObject1;
    }
  }
  
  private void c(GL10 paramGL10)
  {
    AppMethodBeat.i(149075);
    if (paramGL10 == null)
    {
      AppMethodBeat.o(149075);
      return;
    }
    int i3 = this.T;
    int i4 = this.U;
    Object localObject = new int[i3 * i4];
    int[] arrayOfInt = new int[i3 * i4];
    IntBuffer localIntBuffer = IntBuffer.wrap((int[])localObject);
    localIntBuffer.position(0);
    paramGL10.glReadPixels(0, 0, i3, i4, 6408, 5121, localIntBuffer);
    int i1 = 0;
    while (i1 < i4)
    {
      int i2 = 0;
      while (i2 < i3)
      {
        int i5 = localObject[(i1 * i3 + i2)];
        arrayOfInt[((i4 - i1 - 1) * i3 + i2)] = (i5 & 0xFF00FF00 | i5 << 16 & 0xFF0000 | i5 >> 16 & 0xFF);
        i2 += 1;
      }
      i1 += 1;
    }
    try
    {
      paramGL10 = Bitmap.createBitmap(arrayOfInt, i3, i4, this.aw);
      localObject = paramGL10;
      if (this.a != null)
      {
        localObject = paramGL10;
        if (!(this.a instanceof ku))
        {
          localObject = paramGL10;
          if (this.ah.j()) {
            localObject = a(paramGL10, this.ah.i());
          }
        }
      }
      this.as.sendMessage(this.as.obtainMessage(0, localObject));
      this.as = null;
      AppMethodBeat.o(149075);
      return;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        paramGL10 = null;
      }
    }
  }
  
  public boolean A()
  {
    return this.E;
  }
  
  public boolean B()
  {
    return this.F;
  }
  
  public boolean C()
  {
    return this.G;
  }
  
  public void D()
  {
    AppMethodBeat.i(149053);
    if (this.I != null) {
      this.I.removeCallbacksAndMessages(null);
    }
    if (this.v != null) {
      this.v.removeCallbacksAndMessages(null);
    }
    if (this.as != null) {
      this.as.removeCallbacksAndMessages(null);
    }
    if (this.al != null)
    {
      this.al.clear();
      this.al = null;
    }
    X();
    if (this.ak != null) {
      this.ak.clear();
    }
    AppMethodBeat.o(149053);
  }
  
  public void E()
  {
    AppMethodBeat.i(149060);
    int i1 = b().h();
    this.aS = true;
    this.aT = true;
    if (i1 <= this.aP) {
      this.aT = false;
    }
    for (;;)
    {
      if (this.aj != null)
      {
        nf localnf = new nf();
        localnf.a = 0;
        localnf.b = this.aS;
        localnf.c = this.aT;
        this.aj.a(localnf);
      }
      AppMethodBeat.o(149060);
      return;
      if (i1 >= this.aO) {
        this.aS = false;
      }
    }
  }
  
  public void F()
  {
    AppMethodBeat.i(149061);
    if (this.aj != null)
    {
      nf localnf = new nf();
      localnf.a = 0;
      localnf.b = this.aS;
      localnf.c = this.aT;
      this.aj.a(localnf);
    }
    AppMethodBeat.o(149061);
  }
  
  public nc G()
  {
    return this.j;
  }
  
  public cf H()
  {
    return this.ai;
  }
  
  public GeoPoint I()
  {
    AppMethodBeat.i(149064);
    if (this.aC == null)
    {
      if (this.ay == -2147483648) {
        this.ay = (this.T / 2);
      }
      if (this.az == -2147483648) {
        this.az = (this.U / 2);
      }
      localObject = new DoublePoint(this.ay, this.az);
      this.aC = b().t().a((DoublePoint)localObject);
    }
    Object localObject = this.aC;
    AppMethodBeat.o(149064);
    return localObject;
  }
  
  public int J()
  {
    return this.aA;
  }
  
  public int K()
  {
    return this.aB;
  }
  
  public int L()
  {
    return this.ay;
  }
  
  public int M()
  {
    return this.az;
  }
  
  public ne N()
  {
    return this.ah;
  }
  
  public void O()
  {
    AppMethodBeat.i(149067);
    if (this.af == null)
    {
      this.af = new lo(new ln(this));
      a(this.af);
      if (b() != null) {
        b().g(19);
      }
      new lq(i().getApplicationContext(), this.af).a();
    }
    AppMethodBeat.o(149067);
  }
  
  public void P()
  {
    AppMethodBeat.i(149068);
    if (this.af != null)
    {
      this.af.e();
      this.af = null;
    }
    AppMethodBeat.o(149068);
  }
  
  public boolean Q()
  {
    return this.af != null;
  }
  
  public boolean R()
  {
    return this.aW;
  }
  
  public com.tencent.map.lib.basemap.data.a S()
  {
    AppMethodBeat.i(149078);
    Object localObject = T();
    b localb = hn.a(b().f());
    float f1 = b().h();
    if (this.aV == null) {
      this.aV = new com.tencent.map.lib.basemap.data.a(localb, (b[])localObject, f1);
    }
    for (;;)
    {
      localObject = this.aV;
      AppMethodBeat.o(149078);
      return localObject;
      this.aV.a(localb, (b[])localObject, f1);
    }
  }
  
  public b[] T()
  {
    AppMethodBeat.i(149079);
    b[] arrayOfb = new b[8];
    float f1 = this.T;
    float f2 = this.U;
    if ((f1 <= 2.0F) || (f2 <= 2.0F))
    {
      AppMethodBeat.o(149079);
      return null;
    }
    DoublePoint localDoublePoint1 = new DoublePoint(0.0D, 0.0D);
    DoublePoint localDoublePoint2 = new DoublePoint(f1 / 2.0F, 0.0D);
    DoublePoint localDoublePoint3 = new DoublePoint(f1, 0.0D);
    DoublePoint localDoublePoint4 = new DoublePoint(f1, f2 / 2.0F);
    DoublePoint localDoublePoint5 = new DoublePoint(f1, f2);
    DoublePoint localDoublePoint6 = new DoublePoint(f1 / 2.0F, f2);
    DoublePoint localDoublePoint7 = new DoublePoint(0.0D, f2);
    DoublePoint localDoublePoint8 = new DoublePoint(0.0D, f2 / 2.0F);
    int i1 = 0;
    while (i1 < 8)
    {
      arrayOfb[i1] = hn.a(b().t().a(new DoublePoint[] { localDoublePoint1, localDoublePoint2, localDoublePoint3, localDoublePoint4, localDoublePoint5, localDoublePoint6, localDoublePoint7, localDoublePoint8 }[i1]));
      i1 += 1;
    }
    AppMethodBeat.o(149079);
    return arrayOfb;
  }
  
  public List<jv> U()
  {
    AppMethodBeat.i(149084);
    this.aZ.clear();
    Object localObject1 = Y();
    Iterator localIterator = this.aa.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (jx)localIterator.next();
      if ((localObject2 instanceof jv))
      {
        localObject2 = (jv)localObject2;
        if (a(((jv)localObject2).y.e(), (b[])localObject1)) {
          this.aZ.add(localObject2);
        }
      }
    }
    localObject1 = this.aZ;
    AppMethodBeat.o(149084);
    return localObject1;
  }
  
  public List<MapPoi> V()
  {
    AppMethodBeat.i(149085);
    this.ba.clear();
    this.ba = b().G();
    List localList = this.ba;
    AppMethodBeat.o(149085);
    return localList;
  }
  
  public bz a(Class<? extends jx> paramClass)
  {
    AppMethodBeat.i(149039);
    paramClass = (bz)this.ak.get(paramClass);
    AppMethodBeat.o(149039);
    return paramClass;
  }
  
  public dc a(String paramString)
  {
    AppMethodBeat.i(149033);
    if (StringUtil.isEmpty(paramString))
    {
      AppMethodBeat.o(149033);
      return null;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.Z.iterator();
      while (localIterator.hasNext())
      {
        jx localjx = (jx)localIterator.next();
        if ((localjx.A().equals(paramString)) && ((localjx instanceof jv)))
        {
          paramString = ((jv)localjx).y;
          AppMethodBeat.o(149033);
          return paramString;
        }
      }
      AppMethodBeat.o(149033);
      return null;
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(149027);
    b().l();
    if (this.x != null) {
      this.x.a();
    }
    AppMethodBeat.o(149027);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(149062);
    if (this.aQ == paramFloat)
    {
      AppMethodBeat.o(149062);
      return;
    }
    this.aQ = paramFloat;
    if (this.aj != null)
    {
      nf localnf = new nf();
      localnf.a = 1;
      localnf.d = b().h();
      localnf.e = b().t().a(new Point(0, this.U / 2), new Point(this.T, this.U / 2));
      this.aj.a(localnf);
    }
    AppMethodBeat.o(149062);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149024);
    if (this.al != null)
    {
      int i2 = this.al.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ??? = (aq)this.al.get(i1);
        if (??? != null) {
          ((aq)???).a(paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    if (this.b != null)
    {
      synchronized (this.b)
      {
        if (this.Z != null)
        {
          Iterator localIterator = this.Z.iterator();
          if (localIterator.hasNext()) {
            ((jx)localIterator.next()).z();
          }
        }
      }
      AppMethodBeat.o(149024);
      return;
    }
    AppMethodBeat.o(149024);
  }
  
  public void a(Context paramContext, ai paramai)
  {
    AppMethodBeat.i(149029);
    a(paramai);
    if (!b().g()) {
      b().a(0);
    }
    for (;;)
    {
      if (this.aE) {
        O();
      }
      AppMethodBeat.o(149029);
      return;
      b().a(5);
    }
  }
  
  public void a(Handler paramHandler, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(149030);
    this.as = paramHandler;
    this.aw = paramConfig;
    b().a();
    AppMethodBeat.o(149030);
  }
  
  public void a(ah.c paramc)
  {
    AppMethodBeat.i(149069);
    if ((this.o != null) && (paramc != null)) {
      this.o.add(paramc);
    }
    if (paramc == null) {}
    for (boolean bool = true;; bool = false)
    {
      j(bool);
      AppMethodBeat.o(149069);
      return;
    }
  }
  
  public void a(ah.f paramf)
  {
    this.r = paramf;
  }
  
  public void a(ah.k paramk)
  {
    this.u = paramk;
  }
  
  public void a(ap.b paramb)
  {
    this.aq = paramb;
  }
  
  public void a(aq paramaq)
  {
    AppMethodBeat.i(149042);
    if (paramaq == null)
    {
      AppMethodBeat.o(149042);
      return;
    }
    if (this.al == null) {
      this.al = new ArrayList();
    }
    if (this.al.contains(paramaq) == true)
    {
      AppMethodBeat.o(149042);
      return;
    }
    this.al.add(paramaq);
    AppMethodBeat.o(149042);
  }
  
  public void a(bm parambm)
  {
    if (parambm == null) {
      return;
    }
    synchronized (this.b)
    {
      this.ad = parambm;
      return;
    }
  }
  
  public void a(dl paramdl)
  {
    AppMethodBeat.i(149055);
    if (this.k == null) {
      this.k = new dn();
    }
    this.k.a(paramdl);
    AppMethodBeat.o(149055);
  }
  
  public void a(jv paramjv)
  {
    AppMethodBeat.i(149089);
    if ((paramjv != null) && ((paramjv instanceof jv)) && (this.aY != null)) {
      this.aY.a(paramjv);
    }
    AppMethodBeat.o(149089);
  }
  
  public void a(nc paramnc)
  {
    this.j = paramnc;
  }
  
  public void a(ne paramne)
  {
    AppMethodBeat.i(149066);
    this.ah = paramne;
    a(new kx.2(this, paramne));
    AppMethodBeat.o(149066);
  }
  
  public void a(nf.a parama)
  {
    this.aj = parama;
  }
  
  public void a(Class<? extends jx> paramClass, bz parambz)
  {
    AppMethodBeat.i(149038);
    this.ak.put(paramClass, parambz);
    AppMethodBeat.o(149038);
  }
  
  public void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149044);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(149044);
      return;
    }
    for (;;)
    {
      int i2;
      int i3;
      int i4;
      synchronized (this.b)
      {
        int i5 = this.Z.size();
        i2 = 0;
        i3 = -1;
        i1 = i5;
        if (i2 >= i5) {
          break label220;
        }
        jx localjx = (jx)this.Z.get(i2);
        i4 = i1;
        if (localjx != null)
        {
          if (localjx.D() > paramFloat) {
            i1 = i2;
          }
          i4 = i1;
          if (TextUtils.equals(localjx.A(), paramString))
          {
            i3 = i2;
            break label211;
            AppMethodBeat.o(149044);
            return;
            i2 = i1;
            if (i1 >= i3) {
              i2 = i1 - 1;
            }
            paramString = (jx)this.Z.remove(i3);
            if (paramString == null)
            {
              AppMethodBeat.o(149044);
              return;
            }
            this.Z.add(i2, paramString);
            AppMethodBeat.o(149044);
            return;
          }
        }
      }
      int i1 = i4;
      label211:
      i2 += 1;
      continue;
      label220:
      if (i3 != -1) {
        if (i3 != i1) {}
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149031);
    a(paramString, paramBoolean, false);
    AppMethodBeat.o(149031);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    byte[] arrayOfByte = this.b;
    if (!paramBoolean2) {}
    try
    {
      this.X = paramString;
      return;
    }
    finally {}
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149071);
    super.a(paramGL10, paramInt1, paramInt2);
    this.T = paramInt1;
    this.U = paramInt2;
    d((int)(this.T * this.y), (int)(this.U * this.z));
    e((int)(this.T * this.A), (int)(this.U * this.B));
    if (this.aq != null) {
      this.aq.a();
    }
    AppMethodBeat.o(149071);
  }
  
  public void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(149070);
    super.a(paramGL10, paramEGLConfig);
    AppMethodBeat.o(149070);
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149041);
    Object localObject;
    if (this.n != null)
    {
      localObject = c(paramFloat1, paramFloat2);
      if ((localObject != null) && (((String)localObject).trim().length() != 0))
      {
        this.n.a((String)localObject);
        AppMethodBeat.o(149041);
        return true;
      }
    }
    if ((this.p != null) && (this.H))
    {
      localObject = new DoublePoint(paramFloat1, paramFloat2);
      localObject = ka.a(b().t().a((DoublePoint)localObject));
      this.p.a((cz)localObject);
    }
    AppMethodBeat.o(149041);
    return false;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(149050);
    if (this.n != null) {
      this.n.a(paramMotionEvent);
    }
    boolean bool = super.a(paramMotionEvent);
    AppMethodBeat.o(149050);
    return bool;
  }
  
  public boolean a(jx paramjx)
  {
    AppMethodBeat.i(149034);
    if (paramjx == null)
    {
      AppMethodBeat.o(149034);
      return false;
    }
    for (;;)
    {
      int i1;
      synchronized (this.b)
      {
        int i4 = this.Z.size();
        i1 = 0;
        int i2 = 0;
        int i3 = i4;
        if (i1 < i4)
        {
          jx localjx = (jx)this.Z.get(i1);
          if ((localjx == null) || (i2 != 0) || (localjx.D() < paramjx.D())) {
            break label255;
          }
          i2 = 1;
          i3 = i1;
          break label255;
        }
        this.Z.add(i3, paramjx);
        if ((paramjx != null) && (paramjx.B() != null))
        {
          if (this.h != null) {
            paramjx.a(this.h);
          }
          this.ag.add(paramjx);
        }
        if ((paramjx instanceof jv))
        {
          this.aa.add(paramjx);
          Collections.sort(this.aa, this.av);
          AppMethodBeat.o(149034);
          return true;
        }
        if ((paramjx instanceof jz))
        {
          this.ab.add(paramjx);
          Collections.sort(this.ab, this.av);
        }
      }
      this.ac.add(paramjx);
      Collections.sort(this.ac, this.av);
      continue;
      label255:
      i1 += 1;
    }
  }
  
  public boolean a(GL10 paramGL10)
  {
    AppMethodBeat.i(149073);
    b(paramGL10);
    boolean bool = super.a(paramGL10);
    if ((this.as != null) && (b() != null) && (b().F()) && (r() != null) && (r().c()) && (n()))
    {
      if (!this.aX) {
        break label96;
      }
      this.aX = false;
      this.ah.k();
      l();
    }
    for (;;)
    {
      AppMethodBeat.o(149073);
      return bool;
      label96:
      c(paramGL10);
      this.ah.l();
      this.aX = true;
    }
  }
  
  public bz b(Class<? extends jx> paramClass)
  {
    AppMethodBeat.i(149040);
    paramClass = (bz)this.ak.remove(paramClass);
    AppMethodBeat.o(149040);
    return paramClass;
  }
  
  public jx b(String paramString)
  {
    AppMethodBeat.i(149045);
    for (;;)
    {
      int i1;
      synchronized (this.b)
      {
        int i2 = this.Z.size();
        i1 = 0;
        Object localObject = null;
        if (i1 < i2)
        {
          jx localjx = (jx)this.Z.get(i1);
          localObject = localjx;
          if (localjx == null) {
            break label105;
          }
          localObject = localjx;
          if (!TextUtils.equals(localjx.A(), paramString))
          {
            localObject = null;
            break label105;
          }
        }
        AppMethodBeat.o(149045);
        return localObject;
      }
      label105:
      i1 += 1;
    }
  }
  
  public jx b(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149035);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(149035);
      return null;
    }
    for (;;)
    {
      synchronized (this.b)
      {
        Iterator localIterator = this.Z.iterator();
        if (localIterator.hasNext())
        {
          jx localjx = (jx)localIterator.next();
          if ((localjx == null) || (!TextUtils.equals(localjx.A(), paramString))) {
            continue;
          }
          localIterator.remove();
          paramString = localjx;
          if (paramBoolean)
          {
            localjx.d();
            paramString = localjx;
          }
          if (paramString != null)
          {
            this.aa.remove(paramString);
            this.ab.remove(paramString);
            this.ac.remove(paramString);
          }
          AppMethodBeat.o(149035);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(149057);
    this.aM = paramInt;
    b().e(this.aL + 52, paramInt + 52);
    h();
    AppMethodBeat.o(149057);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149058);
    this.aL = paramInt1;
    this.aM = paramInt2;
    b().e(paramInt1 + 52, paramInt2 + 52);
    h();
    AppMethodBeat.o(149058);
  }
  
  public void b(dl paramdl)
  {
    AppMethodBeat.i(149056);
    if (this.k == null)
    {
      AppMethodBeat.o(149056);
      return;
    }
    this.k.b(paramdl);
    AppMethodBeat.o(149056);
  }
  
  public void b(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149043);
    for (;;)
    {
      Object localObject4;
      boolean bool2;
      int i1;
      synchronized (this.b)
      {
        Object localObject1 = (jv)b(this.X);
        if (localObject1 != null)
        {
          localObject4 = ((jv)localObject1).z;
          if ((this.X.equals("")) || (localObject1 == null) || (localObject4 == null) || (!((ju)localObject4).j())) {
            break label765;
          }
          bool1 = ((ju)localObject4).a(paramFloat1, paramFloat2);
          if (!bool1) {
            break label756;
          }
          localObject1 = ((jv)localObject1).y;
          bool2 = bool1;
          if (bool1) {
            break label742;
          }
          i1 = this.aa.size() - 1;
          bool2 = bool1;
          if (i1 < 0) {
            break label742;
          }
          jv localjv = (jv)this.aa.get(i1);
          localObject8 = localjv.z;
          if ((localjv.A().equals(this.X)) || (localObject8 == null) || (!((ju)localObject8).j())) {
            break label753;
          }
          bool1 = ((ju)localObject8).a(paramFloat1, paramFloat2);
          if (bool1)
          {
            localObject4 = localjv.y;
            localObject1 = localObject8;
            localObject8 = localObject4;
            localObject4 = localObject1;
            if (!bool1) {
              continue;
            }
            if ((this.t != null) && (localObject8 != null) && (localObject4 != null) && (((dc)localObject8).l()))
            {
              this.t.a((dc)localObject8);
              this.t.a(((ju)localObject4).l, ((ju)localObject4).m, ((ju)localObject4).G, ((ju)localObject4).H);
            }
            AppMethodBeat.o(149043);
            return true;
          }
        }
        else
        {
          localObject4 = null;
          continue;
        }
        i1 -= 1;
        continue;
        i1 = this.aa.size() - 1;
        bool1 = false;
        if (i1 >= 0)
        {
          bool2 = a((jx)this.aa.get(i1), paramFloat1, paramFloat2);
          bool1 = bool2;
          if (!bool2)
          {
            i1 -= 1;
            bool1 = bool2;
            continue;
          }
        }
        if (bool1)
        {
          AppMethodBeat.o(149043);
          return bool1;
        }
        i1 = this.ab.size() - 1;
        if (i1 >= 0)
        {
          bool2 = a((jx)this.ab.get(i1), paramFloat1, paramFloat2);
          bool1 = bool2;
          if (!bool2)
          {
            i1 -= 1;
            bool1 = bool2;
            continue;
          }
        }
        if (bool1)
        {
          AppMethodBeat.o(149043);
          return bool1;
        }
        i1 = this.ac.size() - 1;
        bool2 = bool1;
        if (i1 >= 0)
        {
          bool1 = a((jx)this.ac.get(i1), paramFloat1, paramFloat2);
          bool2 = bool1;
          if (!bool1)
          {
            i1 -= 1;
            continue;
          }
        }
        if (bool2)
        {
          AppMethodBeat.o(149043);
          return bool2;
        }
        if (this.Y)
        {
          localObject1 = this.b;
          i1 = 0;
        }
      }
      try
      {
        while (i1 < this.aa.size())
        {
          localObject4 = (jv)this.aa.get(i1);
          if (((jv)localObject4).z != null) {
            ((jv)localObject4).z.d(false);
          }
          i1 += 1;
          continue;
          localObject2 = finally;
          throw localObject2;
        }
        if (e(paramFloat1, paramFloat2))
        {
          AppMethodBeat.o(149043);
          return true;
        }
      }
      finally
      {
        AppMethodBeat.o(149043);
      }
      if ((this.m != null) && (this.H))
      {
        ??? = new DoublePoint(paramFloat1, paramFloat2);
        ??? = ka.a(b().t().a((DoublePoint)???));
        this.m.a((cz)???);
      }
      synchronized (this.b)
      {
        w();
        h();
        AppMethodBeat.o(149043);
        return false;
      }
      label742:
      boolean bool1 = bool2;
      Object localObject8 = ???;
      continue;
      label753:
      continue;
      label756:
      Object localObject7 = null;
      ??? = null;
      continue;
      label765:
      localObject7 = null;
      ??? = null;
      bool1 = false;
    }
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(149090);
    if (this.aY != null)
    {
      boolean bool = this.aY.dispatchHoverEvent(paramMotionEvent);
      AppMethodBeat.o(149090);
      return bool;
    }
    AppMethodBeat.o(149090);
    return false;
  }
  
  public String c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149047);
    for (;;)
    {
      synchronized (this.b)
      {
        int i1 = this.Z.size() - 1;
        if (i1 >= 0)
        {
          Object localObject1 = (jx)this.Z.get(i1);
          if ((localObject1 != null) && (((jx)localObject1).a()) && ((localObject1 instanceof jv)) && (((jx)localObject1).a(paramFloat1, paramFloat2)))
          {
            localObject1 = ((jx)localObject1).A();
            AppMethodBeat.o(149047);
            return localObject1;
          }
          i1 -= 1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149063);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(149063);
      return;
    }
    if (this.aC == null)
    {
      GeoPoint localGeoPoint = b().f();
      this.aC = new GeoPoint(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    }
    this.aC.setLatitudeE6(paramInt1);
    this.aC.setLongitudeE6(paramInt2);
    AppMethodBeat.o(149063);
  }
  
  public void c(Class<? extends jx> paramClass)
  {
    AppMethodBeat.i(149054);
    if (paramClass == null)
    {
      AppMethodBeat.o(149054);
      return;
    }
    synchronized (this.b)
    {
      Iterator localIterator = this.Z.iterator();
      while (localIterator.hasNext())
      {
        jx localjx = (jx)localIterator.next();
        if ((localjx != null) && (paramClass.isInstance(localjx)) && (!localjx.y()))
        {
          localjx.d();
          localIterator.remove();
          this.aa.remove(localjx);
          this.ab.remove(localjx);
          this.ac.remove(localjx);
        }
      }
    }
    b().a();
    AppMethodBeat.o(149054);
  }
  
  public void c(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.ay = paramInt1;
    this.az = paramInt2;
  }
  
  public void d(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149059);
    if (!this.H)
    {
      AppMethodBeat.o(149059);
      return false;
    }
    boolean bool = b().a(paramFloat1, paramFloat2);
    AppMethodBeat.o(149059);
    return bool;
  }
  
  public void e()
  {
    AppMethodBeat.i(149051);
    super.e();
    this.L = 0;
    this.K = false;
    Z();
    if (this.ai != null) {
      this.ai.d();
    }
    AppMethodBeat.o(149051);
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    this.aA = paramInt1;
    this.aB = paramInt2;
  }
  
  public void e(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }
  
  public boolean e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149065);
    Object localObject2 = b().b(paramFloat1, paramFloat2);
    if (localObject2 != null)
    {
      Object localObject1;
      switch (((TappedElement)localObject2).type)
      {
      default: 
        AppMethodBeat.o(149065);
        return false;
      case 0: 
        AppMethodBeat.o(149065);
        return false;
      case 1: 
        if (this.u != null)
        {
          if (((TappedElement)localObject2).itemType != 1) {
            break label205;
          }
          localObject1 = new cx();
          ((cx)localObject1).b = ((TappedElement)localObject2).buildingName;
          ((cx)localObject1).a = ((TappedElement)localObject2).buildingId;
          ((cx)localObject1).c = ((TappedElement)localObject2).floorName;
        }
        break;
      }
      for (;;)
      {
        ((db)localObject1).d = ((TappedElement)localObject2).name;
        localObject2 = d.a(((TappedElement)localObject2).pixelX, ((TappedElement)localObject2).pixelY);
        if (localObject2 != null) {
          ((db)localObject1).e = new cz(((GeoPoint)localObject2).getLatitudeE6() / 1000000.0D, ((GeoPoint)localObject2).getLongitudeE6() / 1000000.0D);
        }
        this.u.a((db)localObject1);
        AppMethodBeat.o(149065);
        return true;
        label205:
        localObject1 = new db();
      }
    }
    AppMethodBeat.o(149065);
    return false;
  }
  
  public void f(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  public void g()
  {
    AppMethodBeat.i(149052);
    super.g();
    b().a(null);
    if (this.o != null) {
      this.o.clear();
    }
    if (this.aY != null) {
      this.aY.d();
    }
    if (this.ae != null) {
      this.ae.b();
    }
    this.aJ = true;
    AppMethodBeat.o(149052);
  }
  
  public void g(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public void h(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void i(boolean paramBoolean)
  {
    AppMethodBeat.i(149046);
    this.aH = paramBoolean;
    b().f(paramBoolean);
    b().a();
    AppMethodBeat.o(149046);
  }
  
  public void j()
  {
    AppMethodBeat.i(149072);
    super.j();
    AppMethodBeat.o(149072);
  }
  
  public void j(boolean paramBoolean)
  {
    AppMethodBeat.i(149048);
    if ((!paramBoolean) || (W()))
    {
      b().a(this.an);
      AppMethodBeat.o(149048);
      return;
    }
    b().a(null);
    AppMethodBeat.o(149048);
  }
  
  public void k(boolean paramBoolean)
  {
    this.aW = paramBoolean;
  }
  
  public void onCameraChange(cn paramcn)
  {
    AppMethodBeat.i(149082);
    if (this.o != null)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        ah.c localc = (ah.c)localIterator.next();
        if (localc != null) {
          localc.onCameraChange(paramcn);
        }
      }
    }
    AppMethodBeat.o(149082);
  }
  
  public void onCameraChangeFinished(cn paramcn)
  {
    AppMethodBeat.i(149083);
    if (this.o != null)
    {
      Iterator localIterator = this.o.iterator();
      while (localIterator.hasNext())
      {
        ah.c localc = (ah.c)localIterator.next();
        if (localc != null) {
          localc.onCameraChangeFinished(paramcn);
        }
      }
    }
    AppMethodBeat.o(149083);
  }
  
  public boolean onIndoorBuildingDeactivated()
  {
    AppMethodBeat.i(149081);
    this.h = null;
    Iterator localIterator = this.ag.iterator();
    while (localIterator.hasNext()) {
      ((jx)localIterator.next()).C();
    }
    AppMethodBeat.o(149081);
    return false;
  }
  
  public boolean onIndoorBuildingFocused()
  {
    return false;
  }
  
  public boolean onIndoorLevelActivated(cu paramcu)
  {
    AppMethodBeat.i(149080);
    this.h = paramcu;
    Iterator localIterator = this.ag.iterator();
    while (localIterator.hasNext()) {
      ((jx)localIterator.next()).a(paramcu);
    }
    AppMethodBeat.o(149080);
    return false;
  }
  
  public np r()
  {
    return this.ae;
  }
  
  public cn s()
  {
    AppMethodBeat.i(149028);
    Object localObject1 = b();
    Object localObject2 = ((f)localObject1).f();
    if ((localObject2 == null) || (((this.o == null) || (this.o.size() <= 0)) && (this.aU == null)))
    {
      AppMethodBeat.o(149028);
      return null;
    }
    localObject2 = ka.a((GeoPoint)localObject2);
    float f2 = ((f)localObject1).q();
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 % 360.0F + 360.0F;
    }
    f2 = ((f)localObject1).r();
    float f3 = ((f)localObject1).h();
    double d1 = ((f)localObject1).k();
    f3 = (float)(f3 + Math.log(d1) / Math.log(2.0D));
    localObject1 = cn.a().a(f3).a((cz)localObject2).c(f1).b(f2).a();
    AppMethodBeat.o(149028);
    return localObject1;
  }
  
  public GeoPoint t()
  {
    AppMethodBeat.i(149032);
    synchronized (this.b)
    {
      if ((this.X == null) || (this.X.trim().length() == 0))
      {
        AppMethodBeat.o(149032);
        return null;
      }
      Object localObject1 = b(this.X);
      if (localObject1 == null)
      {
        AppMethodBeat.o(149032);
        return null;
      }
      localObject1 = ((jv)localObject1).g();
      AppMethodBeat.o(149032);
      return localObject1;
    }
  }
  
  public String u()
  {
    synchronized (this.b)
    {
      String str = this.X;
      return str;
    }
  }
  
  public void v()
  {
    AppMethodBeat.i(149036);
    synchronized (this.b)
    {
      if (this.ad != null)
      {
        this.ad.e();
        this.ad = null;
      }
      AppMethodBeat.o(149036);
      return;
    }
  }
  
  public void w()
  {
    AppMethodBeat.i(149037);
    synchronized (this.b)
    {
      if (this.ad != null) {
        this.ad.f();
      }
      AppMethodBeat.o(149037);
      return;
    }
  }
  
  public boolean x()
  {
    for (;;)
    {
      synchronized (this.b)
      {
        if (this.ad != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean y()
  {
    return this.aH;
  }
  
  public boolean z()
  {
    return this.D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kx
 * JD-Core Version:    0.7.0.1
 */