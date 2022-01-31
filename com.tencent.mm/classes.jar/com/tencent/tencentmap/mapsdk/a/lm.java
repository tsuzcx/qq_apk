package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import javax.microedition.khronos.opengles.GL10;

public class lm
  extends ln
{
  private boolean A = false;
  private boolean B = false;
  private int C = 0;
  private int D = 0;
  private boolean E = false;
  private GeoPoint F = null;
  private kl G;
  private pq H = null;
  private lt Q = null;
  private ah.l R;
  private View S = null;
  private View T = null;
  private ViewGroup U = null;
  private LinearLayout V = null;
  private boolean W = false;
  private final int X = 1;
  private final int Y = 2;
  private Runnable Z = new lm.1(this);
  protected Bitmap a = null;
  private Runnable aa = new lm.2(this);
  private lt.b ab = new lm.3(this);
  boolean b = false;
  protected byte[] c = new byte[0];
  float d = 0.5F;
  float e = 0.5F;
  boolean f = false;
  protected float g = 0.0F;
  protected boolean h = false;
  protected float i = 0.0F;
  protected float j = 0.0F;
  protected float k = -1.0F;
  protected qg l = null;
  protected String m = null;
  String n = null;
  protected GeoPoint o = null;
  protected GeoPoint p = null;
  protected GeoPoint q = null;
  protected float r = 1.0F;
  protected float s = 1.0F;
  protected float t = 1.0F;
  public boolean u = false;
  public boolean v = false;
  public boolean w = true;
  protected ma x = null;
  public qf y = null;
  public ll z;
  
  public lm(ma paramma)
  {
    this.x = paramma;
  }
  
  private View a(View paramView)
  {
    if (this.x == null) {
      return null;
    }
    if (this.U == null)
    {
      this.U = a(this.x.getContext());
      this.V = new LinearLayout(this.x.getContext());
      this.V.setGravity(17);
      this.V.setOrientation(1);
      this.V.setPadding(10, 10, 10, 30);
      this.U.addView(this.V, new LinearLayout.LayoutParams(-2, -2));
    }
    if (this.V != null)
    {
      this.V.removeAllViews();
      this.V.addView(paramView);
    }
    return this.U;
  }
  
  private LinearLayout a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    Bitmap localBitmap = lq.b(paramContext, "marker_infowindow.9.png");
    byte[] arrayOfByte = localBitmap.getNinePatchChunk();
    localLinearLayout.setBackgroundDrawable(new NinePatchDrawable(paramContext.getResources(), localBitmap, arrayOfByte, new Rect(), null));
    return localLinearLayout;
  }
  
  private void a(ViewGroup paramViewGroup, Context paramContext)
  {
    if ((paramViewGroup == null) || (paramContext == null)) {
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
  }
  
  private void a(qf paramqf)
  {
    if (this.S == null) {
      this.S = c(paramqf);
    }
    for (;;)
    {
      this.T = this.S;
      return;
      b(paramqf);
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.c)
    {
      this.m = paramString;
      return;
    }
  }
  
  private void b(qf paramqf)
  {
    if ((this.S == null) || (paramqf == null)) {}
    label133:
    label144:
    for (;;)
    {
      return;
      TextView localTextView = (TextView)this.S.findViewById(1);
      Object localObject;
      if (localTextView != null)
      {
        localObject = paramqf.f();
        if (StringUtil.isEmpty((String)localObject)) {
          localTextView.setVisibility(8);
        }
      }
      else
      {
        localObject = (TextView)this.S.findViewById(2);
        if (localObject != null)
        {
          paramqf = paramqf.g();
          if (!StringUtil.isEmpty(paramqf)) {
            break label133;
          }
          ((TextView)localObject).setVisibility(8);
        }
      }
      for (;;)
      {
        if (((localTextView == null) || (localTextView.getVisibility() != 8) || (localObject == null) || (((TextView)localObject).getVisibility() != 8)) && ((localTextView != null) || (localObject != null))) {
          break label144;
        }
        this.S = null;
        return;
        localTextView.setVisibility(0);
        localTextView.setText((CharSequence)localObject);
        break;
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramqf);
      }
    }
  }
  
  private void b(qg paramqg)
  {
    if ((paramqg == null) || (this.G != null) || (this.x == null)) {
      return;
    }
    km localkm = new km();
    localkm.a(lq.a(paramqg.b())).a(paramqg.k()).a(paramqg.f(), paramqg.g());
    Object localObject = Math.random();
    try
    {
      String str = paramqg.e().a().a();
      localObject = str;
    }
    catch (NullPointerException localNullPointerException)
    {
      label89:
      break label89;
    }
    localkm.a((String)localObject, new Bitmap[] { paramqg.e().a(this.x.getContext()) }).a((int)paramqg.o()).b(paramqg.n()).b((int)paramqg.l()).d(this.B).c(paramqg.a()).e(paramqg.r()).a(paramqg.v());
    if (this.G == null)
    {
      this.G = new kl(localkm);
      return;
    }
    this.G.a(localkm);
  }
  
  private View c(qf paramqf)
  {
    if (this.x == null) {
      return null;
    }
    LinearLayout localLinearLayout = a(this.x.getContext());
    a(localLinearLayout, this.x.getContext());
    localLinearLayout.setVisibility(8);
    TextView localTextView = (TextView)localLinearLayout.findViewById(1);
    Object localObject;
    if (localTextView != null)
    {
      localObject = paramqf.f();
      if (StringUtil.isEmpty((String)localObject)) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      localObject = (TextView)localLinearLayout.findViewById(2);
      if (localObject != null)
      {
        paramqf = paramqf.g();
        if (!StringUtil.isEmpty(paramqf)) {
          break label159;
        }
        ((TextView)localObject).setVisibility(8);
      }
    }
    for (;;)
    {
      if (((localTextView == null) || (localTextView.getVisibility() != 8) || (localObject == null) || (((TextView)localObject).getVisibility() != 8)) && ((localTextView != null) || (localObject != null))) {
        return localLinearLayout;
      }
      return null;
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject);
      break;
      label159:
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramqf);
    }
    return localLinearLayout;
  }
  
  public void a(float paramFloat)
  {
    this.g = paramFloat;
    if (this.G != null) {
      this.G.a((int)this.g);
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    synchronized (this.c)
    {
      this.a = paramBitmap;
      if (this.m == null) {
        this.m = paramBitmap.toString();
      }
      if (this.G != null) {
        this.G.a(this.m, new Bitmap[] { this.a });
      }
      return;
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    if (this.o == null) {
      this.o = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    for (;;)
    {
      this.A = true;
      if (this.G == null) {
        break;
      }
      this.G.a(this.o);
      return;
      this.o.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.o.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
  }
  
  public void a(af paramaf, ah.b paramb)
  {
    View localView = paramb.a(this.y);
    if (localView == null)
    {
      paramb = paramb.b(this.y);
      if (paramb == null)
      {
        a(this.y);
        this.T = this.S;
      }
    }
    do
    {
      do
      {
        return;
        paramb = a(paramb);
        if (this.T == null) {
          break;
        }
      } while (this.T.equals(paramb));
      if (paramaf.indexOfChild(this.T) >= 0) {
        paramaf.removeView(this.T);
      }
      this.T = paramb;
      return;
      this.T = paramb;
      return;
      if (this.T == null) {
        break;
      }
    } while (this.T.equals(localView));
    if (paramaf.indexOfChild(this.T) >= 0) {
      paramaf.removeView(this.T);
    }
    this.T = localView;
    return;
    this.T = localView;
  }
  
  public void a(pr parampr)
  {
    if (parampr == null) {}
    do
    {
      return;
      parampr = parampr.a();
    } while ((parampr == null) || (this.x == null));
    Bitmap localBitmap = parampr.a(this.x.getContext());
    a(parampr.a());
    b(localBitmap);
  }
  
  public void a(qg paramqg)
  {
    if (paramqg == null) {
      return;
    }
    this.l = paramqg;
    a(lq.a(paramqg.b()));
    b(paramqg.f(), paramqg.g());
    a_(paramqg.i());
    a(paramqg.o());
    a(paramqg.e());
    b(paramqg.k());
    c(paramqg.l());
    this.J = paramqg.m();
    b(paramqg);
  }
  
  public void a(GL10 paramGL10)
  {
    if (!a())
    {
      b();
      return;
    }
    f();
    b(paramGL10);
    if ((this.x != null) && (this.x.getMap() != null))
    {
      paramGL10 = this.x.getMap().B();
      if ((paramGL10 != null) && (this.G != null)) {
        this.G.b(paramGL10, this.x.getMap().t());
      }
    }
    s();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.x == null) {}
    for (;;)
    {
      return;
      this.f = false;
      Bitmap localBitmap = li.a(this.T);
      if (localBitmap == null) {
        continue;
      }
      synchronized (this.x.e)
      {
        if (this.z == null)
        {
          this.z = new ll(this.x);
          if (paramBoolean2)
          {
            this.z.d(true);
            this.x.r = this.z;
          }
          this.z.c(true);
        }
        if (!paramBoolean1)
        {
          this.z.d(true);
          this.x.r = this.z;
        }
        this.z.b(localBitmap);
        this.z.b(c(false), c(true));
        this.z.a(m());
        if (this.x.i != null) {
          this.z.a(this.x.getMarkerOnTapedPosition());
        }
        if (this.x.getMap() == null) {
          continue;
        }
        this.x.getMap().a();
        return;
      }
    }
  }
  
  public boolean a()
  {
    if (v() != null) {
      return (this.O) && (this.I);
    }
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.x != null)
    {
      if (this.w) {
        break label25;
      }
      bool1 = bool2;
    }
    label25:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.G == null);
        bool2 = this.G.a(this.x.getMap().t(), paramFloat1, paramFloat2);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (this.R == null);
    this.R.a(this.y);
    return bool2;
  }
  
  public void a_(boolean paramBoolean)
  {
    this.O = paramBoolean;
    if (this.G != null) {
      this.G.a(paramBoolean);
    }
    if ((this.x != null) && (this.x.getMap() != null)) {
      this.x.getMap().a();
    }
  }
  
  public void b()
  {
    if (this.G != null) {
      this.G.g();
    }
  }
  
  public void b(float paramFloat)
  {
    this.r = paramFloat;
    if (this.G != null) {
      this.G.a(paramFloat);
    }
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    float f1;
    if (paramFloat1 > 1.0F)
    {
      f1 = 1.0F;
      if (paramFloat2 <= 1.0F) {
        break label112;
      }
      paramFloat1 = 1.0F;
      label16:
      if ((f1 == this.d) && (paramFloat1 == this.e)) {
        break label125;
      }
    }
    label112:
    label125:
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      this.d = f1;
      this.e = paramFloat1;
      if (this.G != null) {
        this.G.a(this.d, this.e);
      }
      if ((this.z != null) && (this.z.j())) {
        a(false, false);
      }
      return;
      f1 = paramFloat1;
      if (paramFloat1 >= 0.0F) {
        break;
      }
      f1 = 0.0F;
      break;
      paramFloat1 = paramFloat2;
      if (paramFloat2 >= 0.0F) {
        break label16;
      }
      paramFloat1 = 0.0F;
      break label16;
    }
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    a(paramBitmap);
    i();
  }
  
  public void b(boolean paramBoolean)
  {
    this.B = paramBoolean;
    if (this.G != null) {
      this.G.b(paramBoolean);
    }
  }
  
  protected boolean b(GL10 paramGL10)
  {
    if (this.Q != null)
    {
      this.Q.c();
      this.E = this.Q.b();
      if ((this.E == true) && (this.x != null) && (this.x.getMap() != null)) {
        this.x.getMap().a();
      }
      return true;
    }
    return false;
  }
  
  public int c(boolean paramBoolean)
  {
    if ((this.a != null) && (this.G != null))
    {
      int i1 = this.a.getHeight();
      if (!paramBoolean) {
        return (int)(i1 * this.G.c());
      }
      return (int)(i1 * (1.0F - this.G.c()));
    }
    return 0;
  }
  
  public void c() {}
  
  public void c(float paramFloat)
  {
    this.N = paramFloat;
    if (this.G != null) {
      this.G.b((int)paramFloat);
    }
  }
  
  public void d()
  {
    this.x = null;
    this.o = null;
    if (this.G != null) {
      this.G.g();
    }
    if (this.z != null) {
      this.z.i();
    }
  }
  
  public qg e()
  {
    return this.l;
  }
  
  protected void f()
  {
    if ((this.x == null) || (!this.v)) {
      return;
    }
    a(this.x.getNaviCenter());
  }
  
  public GeoPoint g()
  {
    return this.o;
  }
  
  public boolean h()
  {
    return this.f;
  }
  
  public void i()
  {
    synchronized (this.c)
    {
      if ((this.a != null) && (!this.a.isRecycled())) {
        this.b = true;
      }
      return;
    }
  }
  
  public float j()
  {
    return this.g;
  }
  
  public boolean k()
  {
    return this.B;
  }
  
  public Point l()
  {
    return new Point(this.C, this.D);
  }
  
  public int m()
  {
    if ((this.a != null) && (this.G != null))
    {
      int i1 = this.a.getWidth();
      return (int)(i1 * this.G.b() - i1 * 0.5F);
    }
    return 0;
  }
  
  public boolean n()
  {
    return true;
  }
  
  public boolean o()
  {
    return this.E;
  }
  
  public kl p()
  {
    return this.G;
  }
  
  public void q()
  {
    if (this.x == null) {
      return;
    }
    this.x.a("", true);
    this.x.getMap().a();
    synchronized (this.x.e)
    {
      if (this.z == null) {
        return;
      }
    }
    this.z.d(false);
  }
  
  public void r()
  {
    a(this.y);
  }
  
  public void s()
  {
    ll localll = this.z;
    if ((localll != null) && (localll.j())) {
      if (!k()) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      localll.b(bool);
      localll.b(g());
      localll.a(e());
      if ((k()) && (!o()))
      {
        Point localPoint = l();
        localll.a(localPoint.x, localPoint.y);
      }
      localll.a(null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lm
 * JD-Core Version:    0.7.0.1
 */