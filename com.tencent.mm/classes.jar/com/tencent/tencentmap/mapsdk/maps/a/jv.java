package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.l;
import com.tencent.map.lib.element.m;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aa;
import com.tencent.tencentmap.mapsdk.a.ah.b;
import com.tencent.tencentmap.mapsdk.a.ah.l;
import com.tencent.tencentmap.mapsdk.a.bj;
import com.tencent.tencentmap.mapsdk.a.cj;
import com.tencent.tencentmap.mapsdk.a.ck;
import com.tencent.tencentmap.mapsdk.a.dc;
import com.tencent.tencentmap.mapsdk.a.dd;
import javax.microedition.khronos.opengles.GL10;

public class jv
  extends jx
{
  private boolean A;
  private boolean B;
  private int C;
  private int D;
  private boolean E;
  private GeoPoint F;
  private kx G;
  private l H;
  private cj R;
  private kd S;
  private ah.l T;
  private View U;
  private View V;
  private ViewGroup W;
  private LinearLayout X;
  private boolean Y;
  private final int Z;
  protected Object a;
  private final int aa;
  private Runnable ab;
  private Runnable ac;
  private kd.b ad;
  protected Bitmap b;
  boolean c;
  protected byte[] d;
  float e;
  float f;
  boolean g;
  protected float h;
  protected boolean i;
  protected float j;
  protected float k;
  protected float l;
  protected dd m;
  protected String n;
  String o;
  protected GeoPoint p;
  protected GeoPoint q;
  protected GeoPoint r;
  protected float s;
  protected float t;
  protected float u;
  public boolean v;
  public boolean w;
  public boolean x;
  public dc y;
  public ju z;
  
  public jv(kx paramkx)
  {
    AppMethodBeat.i(148794);
    this.a = null;
    this.b = null;
    this.c = false;
    this.d = new byte[0];
    this.e = 0.5F;
    this.f = 0.5F;
    this.g = false;
    this.h = 0.0F;
    this.i = false;
    this.j = 0.0F;
    this.k = 0.0F;
    this.l = -1.0F;
    this.m = null;
    this.n = null;
    this.o = null;
    this.A = false;
    this.p = null;
    this.q = null;
    this.r = null;
    this.s = 1.0F;
    this.t = 1.0F;
    this.u = 1.0F;
    this.v = false;
    this.w = false;
    this.x = true;
    this.B = false;
    this.C = 0;
    this.D = 0;
    this.E = false;
    this.F = null;
    this.G = null;
    this.y = null;
    this.R = null;
    this.S = null;
    this.U = null;
    this.V = null;
    this.W = null;
    this.X = null;
    this.Y = false;
    this.Z = 1;
    this.aa = 2;
    this.ab = new jv.1(this);
    this.ac = new jv.2(this);
    this.ad = new jv.3(this);
    this.G = paramkx;
    AppMethodBeat.o(148794);
  }
  
  private View a(View paramView)
  {
    AppMethodBeat.i(148826);
    if (this.G == null)
    {
      AppMethodBeat.o(148826);
      return null;
    }
    if (this.W == null)
    {
      this.W = a(this.G.i());
      this.X = new LinearLayout(this.G.i());
      this.X.setGravity(17);
      this.X.setOrientation(1);
      this.X.setPadding(10, 10, 10, 30);
      this.W.addView(this.X, new LinearLayout.LayoutParams(-2, -2));
    }
    if (this.X != null)
    {
      this.X.removeAllViews();
      this.X.addView(paramView);
    }
    paramView = this.W;
    AppMethodBeat.o(148826);
    return paramView;
  }
  
  private LinearLayout a(Context paramContext)
  {
    AppMethodBeat.i(148828);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Bitmap localBitmap = ka.b(paramContext, "marker_infowindow.9.png");
    if (localBitmap != null)
    {
      byte[] arrayOfByte = localBitmap.getNinePatchChunk();
      localLinearLayout.setBackgroundDrawable(new NinePatchDrawable(paramContext.getResources(), localBitmap, arrayOfByte, new Rect(), null));
    }
    AppMethodBeat.o(148828);
    return localLinearLayout;
  }
  
  private void a(ViewGroup paramViewGroup, Context paramContext)
  {
    AppMethodBeat.i(148829);
    if ((paramViewGroup == null) || (paramContext == null))
    {
      AppMethodBeat.o(148829);
      return;
    }
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setGravity(17);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(10, 10, 10, 30);
    TextView localTextView = new TextView(paramContext);
    localTextView.setGravity(3);
    localTextView.setId(1);
    localTextView.setTextColor(-16777216);
    localTextView.setText("Title");
    localLinearLayout.addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
    paramContext = new TextView(paramContext);
    paramContext.setGravity(3);
    paramContext.setId(2);
    paramContext.setTextColor(-16777216);
    paramContext.setText("Snippet");
    localLinearLayout.addView(paramContext, new LinearLayout.LayoutParams(-2, -2));
    paramViewGroup.addView(localLinearLayout);
    AppMethodBeat.o(148829);
  }
  
  private void a(dc paramdc)
  {
    AppMethodBeat.i(148824);
    if (this.U == null) {
      this.U = c(paramdc);
    }
    for (;;)
    {
      this.V = this.U;
      AppMethodBeat.o(148824);
      return;
      b(paramdc);
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.d)
    {
      this.n = paramString;
      return;
    }
  }
  
  private void b(dc paramdc)
  {
    AppMethodBeat.i(148825);
    if ((this.U == null) || (paramdc == null))
    {
      AppMethodBeat.o(148825);
      return;
    }
    TextView localTextView = (TextView)this.U.findViewById(1);
    Object localObject;
    if (localTextView != null)
    {
      localObject = paramdc.f();
      if (StringUtil.isEmpty((String)localObject)) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      localObject = (TextView)this.U.findViewById(2);
      if (localObject != null)
      {
        paramdc = paramdc.g();
        if (!StringUtil.isEmpty(paramdc)) {
          break label151;
        }
        ((TextView)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      if (((localTextView != null) && (localTextView.getVisibility() == 8) && (localObject != null) && (((TextView)localObject).getVisibility() == 8)) || ((localTextView == null) && (localObject == null))) {
        this.U = null;
      }
      AppMethodBeat.o(148825);
      return;
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject);
      break;
      label151:
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramdc);
    }
  }
  
  private void b(dd paramdd)
  {
    AppMethodBeat.i(148823);
    if ((this.G == null) || (paramdd == null) || (this.H != null))
    {
      AppMethodBeat.o(148823);
      return;
    }
    m localm = new m();
    localm.a(ka.a(paramdd.b())).a(paramdd.k()).a(paramdd.f(), paramdd.g());
    Object localObject = Math.random();
    try
    {
      String str = paramdd.e().a().a();
      localObject = str;
    }
    catch (NullPointerException localNullPointerException)
    {
      label101:
      break label101;
    }
    localm.a((String)localObject, new Bitmap[] { paramdd.e().a(this.G.i()) }).a((int)paramdd.o()).b(paramdd.n()).b((int)paramdd.l()).d(this.B).c(paramdd.a()).e(paramdd.r()).a(paramdd.v()).c(paramdd.x());
    this.H = new l(localm);
    AppMethodBeat.o(148823);
  }
  
  private View c(dc paramdc)
  {
    AppMethodBeat.i(148827);
    if (this.G == null)
    {
      AppMethodBeat.o(148827);
      return null;
    }
    LinearLayout localLinearLayout = a(this.G.i());
    a(localLinearLayout, this.G.i());
    localLinearLayout.setVisibility(8);
    TextView localTextView = (TextView)localLinearLayout.findViewById(1);
    Object localObject;
    if (localTextView != null)
    {
      localObject = paramdc.f();
      if (StringUtil.isEmpty((String)localObject)) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      localObject = (TextView)localLinearLayout.findViewById(2);
      if (localObject != null)
      {
        paramdc = paramdc.g();
        if (!StringUtil.isEmpty(paramdc)) {
          break label177;
        }
        ((TextView)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      if (((localTextView == null) || (localTextView.getVisibility() != 8) || (localObject == null) || (((TextView)localObject).getVisibility() != 8)) && ((localTextView != null) || (localObject != null))) {
        break label192;
      }
      AppMethodBeat.o(148827);
      return null;
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject);
      break;
      label177:
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramdc);
    }
    label192:
    AppMethodBeat.o(148827);
    return localLinearLayout;
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(148800);
    this.h = paramFloat;
    if (this.H != null) {
      this.H.b((int)this.h);
    }
    AppMethodBeat.o(148800);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148819);
    this.C = paramInt1;
    this.D = paramInt2;
    if (this.H != null)
    {
      c(true);
      GeoPoint localGeoPoint = new GeoPoint(this.D, this.C);
      this.H.a(localGeoPoint);
    }
    AppMethodBeat.o(148819);
  }
  
  protected void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148802);
    synchronized (this.d)
    {
      this.b = paramBitmap;
      if (this.n == null) {
        this.n = paramBitmap.toString();
      }
      if (this.H != null) {
        this.H.a(this.n, new Bitmap[] { this.b });
      }
      AppMethodBeat.o(148802);
      return;
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148797);
    if (paramGeoPoint == null)
    {
      AppMethodBeat.o(148797);
      return;
    }
    if (this.p == null) {
      this.p = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      this.A = true;
      if (this.H != null) {
        this.H.a(this.p);
      }
      AppMethodBeat.o(148797);
      return;
      this.p.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.p.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public void a(aa paramaa, ah.b paramb)
  {
    AppMethodBeat.i(148832);
    View localView = paramb.a(this.y);
    if (localView == null)
    {
      paramb = paramb.b(this.y);
      if (paramb == null)
      {
        a(this.y);
        this.V = this.U;
        AppMethodBeat.o(148832);
        return;
      }
      paramb = a(paramb);
      if (this.V != null)
      {
        if (!this.V.equals(paramb))
        {
          if (paramaa.indexOfChild(this.V) >= 0) {
            paramaa.removeView(this.V);
          }
          this.V = paramb;
          AppMethodBeat.o(148832);
        }
      }
      else {
        this.V = paramb;
      }
      AppMethodBeat.o(148832);
      return;
    }
    if (this.V != null) {
      if (!this.V.equals(localView)) {
        if (paramaa.indexOfChild(this.V) >= 0) {
          paramaa.removeView(this.V);
        }
      }
    }
    for (this.V = localView;; this.V = localView)
    {
      if ((this.V != null) && (this.V.getLayoutParams() == null))
      {
        paramaa = new FrameLayout.LayoutParams(-2, -2);
        this.V.setLayoutParams(paramaa);
      }
      AppMethodBeat.o(148832);
      return;
    }
  }
  
  public void a(ck paramck)
  {
    AppMethodBeat.i(148796);
    if ((this.G == null) || (paramck == null))
    {
      AppMethodBeat.o(148796);
      return;
    }
    paramck = paramck.a();
    if ((paramck != null) && (this.G != null))
    {
      Bitmap localBitmap = paramck.a(this.G.i());
      a(paramck.a());
      b(localBitmap);
    }
    AppMethodBeat.o(148796);
  }
  
  public void a(dd paramdd)
  {
    AppMethodBeat.i(148795);
    if (paramdd == null)
    {
      AppMethodBeat.o(148795);
      return;
    }
    this.m = paramdd;
    a(ka.a(paramdd.b()));
    b(paramdd.f(), paramdd.g());
    a(paramdd.i());
    a(paramdd.o());
    a(paramdd.e());
    b(paramdd.k());
    c(paramdd.l());
    a_(paramdd.x());
    this.J = paramdd.m();
    this.a = paramdd.u();
    b(paramdd);
    AppMethodBeat.o(148795);
  }
  
  public void a(kd paramkd)
  {
    AppMethodBeat.i(148810);
    this.S = paramkd;
    if (this.S != null) {
      this.S.a(this.ad);
    }
    AppMethodBeat.o(148810);
  }
  
  public void a(GL10 paramGL10)
  {
    AppMethodBeat.i(148805);
    if (this.G == null)
    {
      AppMethodBeat.o(148805);
      return;
    }
    if (!a())
    {
      b();
      AppMethodBeat.o(148805);
      return;
    }
    f();
    b(paramGL10);
    if (this.G.b() != null)
    {
      paramGL10 = this.G.b().x();
      if ((paramGL10 != null) && (this.H != null)) {
        this.H.b(paramGL10, this.G.b().t());
      }
    }
    w();
    AppMethodBeat.o(148805);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(148808);
    this.O = paramBoolean;
    if (this.H != null) {
      this.H.a(paramBoolean);
    }
    if ((this.G != null) && (this.G.b() != null)) {
      this.G.b().a();
    }
    AppMethodBeat.o(148808);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(148831);
    if (this.G == null)
    {
      AppMethodBeat.o(148831);
      return;
    }
    this.g = false;
    Bitmap localBitmap = jr.a(this.V);
    if (localBitmap == null)
    {
      AppMethodBeat.o(148831);
      return;
    }
    synchronized (this.G.b)
    {
      if (this.z == null)
      {
        this.z = new ju(this.G);
        if (paramBoolean2)
        {
          this.z.d(true);
          this.G.W = this.z;
        }
        this.z.c(true);
      }
      if (!paramBoolean1)
      {
        this.z.d(true);
        this.G.W = this.z;
      }
      this.z.b(localBitmap);
      this.z.b(d(false), d(true));
      this.z.a(q());
      if (this.G.f != null) {
        this.z.a(this.G.t());
      }
      if (this.G.b() != null) {
        this.G.b().a();
      }
      AppMethodBeat.o(148831);
      return;
    }
  }
  
  public boolean a()
  {
    AppMethodBeat.i(148807);
    if (B() != null)
    {
      if ((this.O) && (this.I))
      {
        AppMethodBeat.o(148807);
        return true;
      }
      AppMethodBeat.o(148807);
      return false;
    }
    boolean bool = this.O;
    AppMethodBeat.o(148807);
    return bool;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148806);
    if ((this.G == null) || (!this.x))
    {
      AppMethodBeat.o(148806);
      return false;
    }
    if (this.H != null)
    {
      boolean bool = this.H.a(this.G.b().t(), paramFloat1, paramFloat2);
      if ((bool) && (this.T != null)) {
        this.T.a(this.y);
      }
      AppMethodBeat.o(148806);
      return bool;
    }
    AppMethodBeat.o(148806);
    return false;
  }
  
  public void a_(int paramInt)
  {
    AppMethodBeat.i(148798);
    super.a_(paramInt);
    if (this.H != null) {
      this.H.a(paramInt);
    }
    if (this.z != null) {
      this.H.a(paramInt);
    }
    AppMethodBeat.o(148798);
  }
  
  public void b()
  {
    AppMethodBeat.i(100134);
    if (this.H != null) {
      this.H.g();
    }
    AppMethodBeat.o(100134);
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(148816);
    this.s = paramFloat;
    if (this.H != null) {
      this.H.a(paramFloat);
    }
    AppMethodBeat.o(148816);
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148801);
    float f1;
    if (paramFloat1 > 1.0F)
    {
      f1 = 1.0F;
      if (paramFloat2 <= 1.0F) {
        break label124;
      }
      paramFloat1 = 1.0F;
      label22:
      if ((f1 == this.e) && (paramFloat1 == this.f)) {
        break label137;
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      this.e = f1;
      this.f = paramFloat1;
      if (this.H != null) {
        this.H.a(this.e, this.f);
      }
      if ((this.z != null) && (this.z.j())) {
        a(false, false);
      }
      AppMethodBeat.o(148801);
      return;
      f1 = paramFloat1;
      if (paramFloat1 >= 0.0F) {
        break;
      }
      f1 = 0.0F;
      break;
      label124:
      paramFloat1 = paramFloat2;
      if (paramFloat2 >= 0.0F) {
        break label22;
      }
      paramFloat1 = 0.0F;
      break label22;
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(148803);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(148803);
      return;
    }
    a(paramBitmap);
    i();
    AppMethodBeat.o(148803);
  }
  
  public void b(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  protected boolean b(GL10 paramGL10)
  {
    AppMethodBeat.i(148815);
    if (this.G == null)
    {
      AppMethodBeat.o(148815);
      return false;
    }
    if (this.S != null)
    {
      this.S.d();
      this.E = this.S.c();
      if ((this.E == true) && (this.G.b() != null)) {
        this.G.b().a();
      }
      AppMethodBeat.o(148815);
      return true;
    }
    AppMethodBeat.o(148815);
    return false;
  }
  
  public void c()
  {
    AppMethodBeat.i(100135);
    AppMethodBeat.o(100135);
  }
  
  public void c(float paramFloat)
  {
    AppMethodBeat.i(148817);
    this.N = paramFloat;
    if (this.H != null) {
      this.H.c((int)paramFloat);
    }
    AppMethodBeat.o(148817);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(148818);
    this.B = paramBoolean;
    if (this.H != null) {
      this.H.b(paramBoolean);
    }
    AppMethodBeat.o(148818);
  }
  
  public int d(boolean paramBoolean)
  {
    AppMethodBeat.i(148821);
    if ((this.b != null) && (this.H != null))
    {
      int i1 = this.b.getHeight();
      if (!paramBoolean)
      {
        i1 = (int)(i1 * this.H.c());
        AppMethodBeat.o(148821);
        return i1;
      }
      i1 = (int)(i1 * (1.0F - this.H.c()));
      AppMethodBeat.o(148821);
      return i1;
    }
    AppMethodBeat.o(148821);
    return 0;
  }
  
  public void d()
  {
    AppMethodBeat.i(148809);
    this.p = null;
    if (this.H != null) {
      this.H.g();
    }
    if (this.z != null) {
      this.z.i();
    }
    AppMethodBeat.o(148809);
  }
  
  public dd e()
  {
    return this.m;
  }
  
  protected void f()
  {
    AppMethodBeat.i(148799);
    if ((this.G == null) || (!this.w))
    {
      AppMethodBeat.o(148799);
      return;
    }
    a(this.G.I());
    AppMethodBeat.o(148799);
  }
  
  public GeoPoint g()
  {
    return this.p;
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public void i()
  {
    AppMethodBeat.i(148804);
    synchronized (this.d)
    {
      if ((this.b != null) && (!this.b.isRecycled())) {
        this.c = true;
      }
      AppMethodBeat.o(148804);
      return;
    }
  }
  
  public boolean j()
  {
    AppMethodBeat.i(148811);
    if ((this.G == null) || (this.S == null))
    {
      AppMethodBeat.o(148811);
      return false;
    }
    GeoPoint localGeoPoint2 = this.p;
    GeoPoint localGeoPoint1 = localGeoPoint2;
    if (this.B)
    {
      localGeoPoint1 = localGeoPoint2;
      if (this.G.b() != null)
      {
        localGeoPoint1 = this.G.b().t().a(new DoublePoint(this.C, this.D));
        this.F = new GeoPoint(localGeoPoint1);
      }
    }
    boolean bool = this.S.a(localGeoPoint1, this.r);
    AppMethodBeat.o(148811);
    return bool;
  }
  
  public Rect k()
  {
    AppMethodBeat.i(148812);
    if ((this.H != null) && (this.G != null) && (this.G.b() != null))
    {
      localRect = this.H.a(this.G.b().t());
      AppMethodBeat.o(148812);
      return localRect;
    }
    Rect localRect = new Rect();
    AppMethodBeat.o(148812);
    return localRect;
  }
  
  public Rect l()
  {
    AppMethodBeat.i(148813);
    if ((this.H != null) && (this.G != null) && (this.G.b() != null))
    {
      localRect = this.H.b(this.G.b().t());
      AppMethodBeat.o(148813);
      return localRect;
    }
    Rect localRect = new Rect();
    AppMethodBeat.o(148813);
    return localRect;
  }
  
  public String m()
  {
    AppMethodBeat.i(148814);
    Object localObject = e();
    if (localObject == null)
    {
      AppMethodBeat.o(148814);
      return null;
    }
    localObject = ((dd)localObject).w();
    AppMethodBeat.o(148814);
    return localObject;
  }
  
  public float n()
  {
    return this.h;
  }
  
  public boolean o()
  {
    return this.B;
  }
  
  public Point p()
  {
    AppMethodBeat.i(148820);
    Point localPoint = new Point(this.C, this.D);
    AppMethodBeat.o(148820);
    return localPoint;
  }
  
  public int q()
  {
    AppMethodBeat.i(148822);
    if ((this.b != null) && (this.H != null))
    {
      int i1 = this.b.getWidth();
      i1 = (int)(i1 * this.H.b() - i1 * 0.5F);
      AppMethodBeat.o(148822);
      return i1;
    }
    AppMethodBeat.o(148822);
    return 0;
  }
  
  public boolean r()
  {
    return true;
  }
  
  public boolean s()
  {
    return this.E;
  }
  
  public l t()
  {
    return this.H;
  }
  
  public void u()
  {
    AppMethodBeat.i(148830);
    if (this.G == null)
    {
      AppMethodBeat.o(148830);
      return;
    }
    this.G.a("", true);
    this.G.b().a();
    synchronized (this.G.b)
    {
      if (this.z == null)
      {
        AppMethodBeat.o(148830);
        return;
      }
      this.z.d(false);
      AppMethodBeat.o(148830);
      return;
    }
  }
  
  public void v()
  {
    AppMethodBeat.i(148833);
    a(this.y);
    AppMethodBeat.o(148833);
  }
  
  public void w()
  {
    AppMethodBeat.i(148834);
    ju localju = this.z;
    if ((localju != null) && (localju.j())) {
      if (!o()) {
        break label95;
      }
    }
    label95:
    for (boolean bool = true;; bool = false)
    {
      localju.b(bool);
      localju.b(g());
      localju.a(e());
      if ((o()) && (!s()))
      {
        Point localPoint = p();
        localju.a(localPoint.x, localPoint.y);
      }
      localju.a(null);
      AppMethodBeat.o(148834);
      return;
    }
  }
  
  public boolean x()
  {
    AppMethodBeat.i(148835);
    Rect localRect = l();
    int i1 = this.G.getWidth();
    int i2 = this.G.getHeight();
    if ((localRect.left >= 0) && (localRect.top >= 0) && (localRect.right <= i1) && (localRect.bottom <= i2))
    {
      AppMethodBeat.o(148835);
      return true;
    }
    AppMethodBeat.o(148835);
    return false;
  }
  
  public boolean y()
  {
    AppMethodBeat.i(148836);
    if ((this.a != null) && ("AUTH_MARKER".equals(this.a.toString())))
    {
      AppMethodBeat.o(148836);
      return true;
    }
    AppMethodBeat.o(148836);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jv
 * JD-Core Version:    0.7.0.1
 */