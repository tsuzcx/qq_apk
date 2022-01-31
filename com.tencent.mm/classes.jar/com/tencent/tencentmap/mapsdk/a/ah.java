package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.location.Location;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ka;
import com.tencent.tencentmap.mapsdk.maps.a.lh;
import com.tencent.tencentmap.mapsdk.maps.a.nk;
import com.tencent.tencentmap.mapsdk.maps.a.nn;

public final class ah
{
  private static int J = 1;
  public static final int a = o.a + 0;
  public static final int b = o.a + 9;
  public static final int c = o.a + 10;
  @Deprecated
  public static final int d = o.a + 11;
  public static final int e = o.a + 13;
  public static final int f = o.a + 12;
  @Deprecated
  public static final int g = b;
  @Deprecated
  public static final int h = e;
  private as A;
  private cg B;
  private bf C;
  private bk D;
  private av E;
  private boolean F;
  private an G;
  private ak H;
  private aa I;
  private final bg.a K;
  private ap i;
  private lh j;
  private bq k;
  private bo l;
  private bb m;
  private az n;
  private au o;
  private at p;
  private ch q;
  private bl r;
  private aw s;
  private bi t;
  private ag u;
  private bp v;
  private bn w;
  private ba x;
  private ay y;
  private ar z;
  
  protected ah()
  {
    AppMethodBeat.i(147104);
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
    this.F = false;
    this.G = null;
    this.I = null;
    this.K = new ah.1(this);
    this.i = new ap(0, null, null);
    this.G = new an(this.i, b());
    AppMethodBeat.o(147104);
  }
  
  protected ah(aa paramaa, Context paramContext, ai paramai)
  {
    AppMethodBeat.i(147103);
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.q = null;
    this.t = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.x = null;
    this.y = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.C = null;
    this.F = false;
    this.G = null;
    this.I = null;
    this.K = new ah.1(this);
    ka.b(paramContext);
    ka.a(paramContext);
    this.I = paramaa;
    nk.a().a(paramContext);
    nn.a(paramContext);
    this.i = new ap(paramaa.getMapViewType(), paramaa, paramai);
    this.t = new bi(this.i);
    this.G = new an(this.i, b());
    this.v = new bp(this.i);
    this.o = new au(this.I, this.t.b());
    this.z = new ar(this.o);
    this.m = new bb(this.t.b());
    this.x = new ba(this.m);
    this.n = new az(this.t.b());
    this.y = new ay(this.n);
    this.l = new bo(this.t.b());
    this.w = new bn(this.l);
    this.C = new bf(this.i.a());
    this.i.a(this.K);
    this.i.a(this.z, paramai);
    this.j = new lh(this.i);
    this.j.a(this.z, paramai);
    this.j.a();
    AppMethodBeat.o(147103);
  }
  
  private void A()
  {
    AppMethodBeat.i(147124);
    if (this.q == null) {
      this.q = new ch(this.z, this.w, this.v);
    }
    if (this.B == null) {
      this.B = new cg(this.q);
    }
    AppMethodBeat.o(147124);
  }
  
  private void B()
  {
    AppMethodBeat.i(147139);
    if (this.q != null)
    {
      this.q.e();
      this.q = null;
    }
    if (this.o != null)
    {
      this.o.a();
      this.o = null;
    }
    if (this.n != null)
    {
      this.n.a();
      this.n = null;
    }
    if (this.m != null)
    {
      this.m.a();
      this.m = null;
    }
    if (this.l != null)
    {
      this.l.a();
      this.l = null;
    }
    if (this.i != null)
    {
      this.i.c();
      this.i = null;
    }
    if (this.r != null)
    {
      this.r.a();
      this.r = null;
    }
    if (this.p != null)
    {
      this.p.a();
      this.p = null;
    }
    if (this.s != null) {
      this.s.a();
    }
    AppMethodBeat.o(147139);
  }
  
  private void C()
  {
    AppMethodBeat.i(147140);
    if (this.C != null)
    {
      this.C.a();
      this.C = null;
    }
    if (this.B != null)
    {
      this.B.a();
      this.B = null;
    }
    if (this.z != null)
    {
      this.z.a();
      this.z = null;
    }
    if (this.y != null)
    {
      this.y.a();
      this.y = null;
    }
    if (this.x != null)
    {
      this.x.a();
      this.x = null;
    }
    if (this.w != null)
    {
      this.w.a();
      this.w = null;
    }
    if (this.D != null)
    {
      this.D.a();
      this.D = null;
    }
    if (this.A != null)
    {
      this.A.a();
      this.A = null;
    }
    if (this.E != null)
    {
      this.E.a();
      this.E = null;
    }
    if (this.v != null)
    {
      this.v.a();
      this.v = null;
    }
    if (this.u != null)
    {
      this.u.a();
      this.u = null;
    }
    if (this.t != null)
    {
      this.t.a();
      this.t = null;
    }
    AppMethodBeat.o(147140);
  }
  
  public static int a()
  {
    return J;
  }
  
  public final co a(cp paramcp)
  {
    AppMethodBeat.i(147115);
    if ((this.F) || (this.w == null) || (paramcp == null))
    {
      AppMethodBeat.o(147115);
      return null;
    }
    paramcp = this.w.a(paramcp);
    AppMethodBeat.o(147115);
    return paramcp;
  }
  
  public final dc a(dd paramdd)
  {
    AppMethodBeat.i(147116);
    if ((this.F) || (this.z == null) || (paramdd == null))
    {
      AppMethodBeat.o(147116);
      return null;
    }
    paramdd = this.z.a(paramdd, this.z);
    AppMethodBeat.o(147116);
    return paramdd;
  }
  
  public final dh a(di paramdi)
  {
    AppMethodBeat.i(147114);
    if ((this.F) || (this.y == null) || (paramdi == null))
    {
      AppMethodBeat.o(147114);
      return null;
    }
    paramdi = this.y.a(paramdi);
    AppMethodBeat.o(147114);
    return paramdi;
  }
  
  public final dj a(dk paramdk)
  {
    AppMethodBeat.i(147113);
    if ((this.F) || (this.x == null) || (paramdk == null))
    {
      AppMethodBeat.o(147113);
      return null;
    }
    paramdk = this.x.a(paramdk);
    AppMethodBeat.o(147113);
    return paramdk;
  }
  
  public final String a(cz paramcz)
  {
    AppMethodBeat.i(147159);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147159);
      return null;
    }
    paramcz = this.v.a(paramcz);
    AppMethodBeat.o(147159);
    return paramcz;
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(147146);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147146);
      return;
    }
    this.v.a(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(147146);
  }
  
  @Deprecated
  public final void a(int paramInt)
  {
    AppMethodBeat.i(147118);
    b(paramInt);
    AppMethodBeat.o(147118);
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(147108);
    if ((this.F) || (this.v == null) || (this.v.q()))
    {
      AppMethodBeat.o(147108);
      return;
    }
    this.v.a(paramab);
    AppMethodBeat.o(147108);
  }
  
  public final void a(ab paramab, long paramLong, a parama)
  {
    AppMethodBeat.i(147111);
    if ((this.F) || (this.v == null) || (this.v.q()))
    {
      AppMethodBeat.o(147111);
      return;
    }
    this.v.a(paramab, paramLong, parama);
    AppMethodBeat.o(147111);
  }
  
  public final void a(ab paramab, a parama)
  {
    AppMethodBeat.i(147110);
    if ((this.F) || (this.v == null) || (this.v.q()))
    {
      AppMethodBeat.o(147110);
      return;
    }
    this.v.a(paramab, 500L, parama);
    AppMethodBeat.o(147110);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(147153);
    if ((this.F) || (this.z == null))
    {
      AppMethodBeat.o(147153);
      return;
    }
    this.z.a(paramb);
    AppMethodBeat.o(147153);
  }
  
  public final void a(ah.c paramc)
  {
    AppMethodBeat.i(147129);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147129);
      return;
    }
    this.v.a(paramc);
    AppMethodBeat.o(147129);
  }
  
  public final void a(ah.f paramf)
  {
    AppMethodBeat.i(147154);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147154);
      return;
    }
    this.v.a(paramf);
    AppMethodBeat.o(147154);
  }
  
  public final void a(ah.g paramg)
  {
    AppMethodBeat.i(147152);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147152);
      return;
    }
    this.v.a(paramg);
    AppMethodBeat.o(147152);
  }
  
  public final void a(ah.h paramh)
  {
    AppMethodBeat.i(147130);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147130);
      return;
    }
    this.v.a(paramh);
    AppMethodBeat.o(147130);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(147132);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147132);
      return;
    }
    this.v.a(parami);
    AppMethodBeat.o(147132);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(147131);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147131);
      return;
    }
    this.v.a(paramj);
    AppMethodBeat.o(147131);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(147160);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147160);
      return;
    }
    this.v.a(paramk);
    AppMethodBeat.o(147160);
  }
  
  public final void a(ah.l paraml)
  {
    AppMethodBeat.i(147150);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147150);
      return;
    }
    this.v.a(paraml);
    AppMethodBeat.o(147150);
  }
  
  public final void a(ah.m paramm)
  {
    AppMethodBeat.i(147151);
    if ((this.F) || (this.z == null))
    {
      AppMethodBeat.o(147151);
      return;
    }
    this.z.a(paramm);
    AppMethodBeat.o(147151);
  }
  
  public final void a(ah.p paramp)
  {
    AppMethodBeat.i(147142);
    a(paramp, Bitmap.Config.ARGB_8888);
    AppMethodBeat.o(147142);
  }
  
  public final void a(ah.p paramp, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(147141);
    if (this.v != null) {
      this.v.a(paramp, paramConfig);
    }
    AppMethodBeat.o(147141);
  }
  
  public final void a(cy paramcy)
  {
    AppMethodBeat.i(147167);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147167);
      return;
    }
    this.v.a(paramcy);
    AppMethodBeat.o(147167);
  }
  
  @Deprecated
  public final void a(dl paramdl)
  {
    AppMethodBeat.i(147143);
    b(paramdl);
    AppMethodBeat.o(147143);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147163);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147163);
      return;
    }
    this.v.a(paramString1, paramString2);
    AppMethodBeat.o(147163);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(147121);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147121);
      return;
    }
    this.v.a(paramBoolean);
    AppMethodBeat.o(147121);
  }
  
  final bi b()
  {
    return this.t;
  }
  
  public final void b(int paramInt)
  {
    AppMethodBeat.i(147119);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147119);
      return;
    }
    this.v.a(paramInt);
    AppMethodBeat.o(147119);
  }
  
  public final void b(ab paramab)
  {
    AppMethodBeat.i(147109);
    if ((this.F) || (this.v == null) || (this.v.q()))
    {
      AppMethodBeat.o(147109);
      return;
    }
    this.v.a(paramab, 500L, null);
    AppMethodBeat.o(147109);
  }
  
  public final void b(dl paramdl)
  {
    AppMethodBeat.i(147144);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147144);
      return;
    }
    this.v.a(paramdl);
    AppMethodBeat.o(147144);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(147122);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147122);
      return;
    }
    this.v.b(paramBoolean);
    AppMethodBeat.o(147122);
  }
  
  public final ap c()
  {
    return this.i;
  }
  
  public final void c(int paramInt)
  {
    AppMethodBeat.i(147156);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147156);
      return;
    }
    this.v.b(paramInt);
    AppMethodBeat.o(147156);
  }
  
  public final void c(dl paramdl)
  {
    AppMethodBeat.i(147145);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147145);
      return;
    }
    this.v.b(paramdl);
    AppMethodBeat.o(147145);
  }
  
  public final void c(boolean paramBoolean)
  {
    AppMethodBeat.i(147125);
    if (this.F)
    {
      AppMethodBeat.o(147125);
      return;
    }
    A();
    if (!paramBoolean)
    {
      this.B.d();
      AppMethodBeat.o(147125);
      return;
    }
    if (j() == true)
    {
      AppMethodBeat.o(147125);
      return;
    }
    this.B.c();
    AppMethodBeat.o(147125);
  }
  
  public final cn d()
  {
    AppMethodBeat.i(147105);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147105);
      return null;
    }
    cn localcn = this.v.b();
    AppMethodBeat.o(147105);
    return localcn;
  }
  
  protected final void d(boolean paramBoolean)
  {
    AppMethodBeat.i(147148);
    if ((this.F) || (this.i == null))
    {
      AppMethodBeat.o(147148);
      return;
    }
    this.i.c(paramBoolean);
    AppMethodBeat.o(147148);
  }
  
  public final float e()
  {
    AppMethodBeat.i(147106);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147106);
      return 0.0F;
    }
    float f1 = this.v.c();
    AppMethodBeat.o(147106);
    return f1;
  }
  
  public final void e(boolean paramBoolean)
  {
    AppMethodBeat.i(147149);
    if ((this.F) || (this.i == null))
    {
      AppMethodBeat.o(147149);
      return;
    }
    this.i.a(paramBoolean, false);
    AppMethodBeat.o(147149);
  }
  
  public final float f()
  {
    AppMethodBeat.i(147107);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147107);
      return 0.0F;
    }
    float f1 = this.v.d();
    AppMethodBeat.o(147107);
    return f1;
  }
  
  public final void f(boolean paramBoolean)
  {
    AppMethodBeat.i(147155);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147155);
      return;
    }
    this.v.c(paramBoolean);
    AppMethodBeat.o(147155);
  }
  
  public final void g()
  {
    AppMethodBeat.i(147112);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147112);
      return;
    }
    this.v.e();
    AppMethodBeat.o(147112);
  }
  
  public final void g(boolean paramBoolean)
  {
    AppMethodBeat.i(147161);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147161);
      return;
    }
    this.v.d(paramBoolean);
    AppMethodBeat.o(147161);
  }
  
  public final void h()
  {
    AppMethodBeat.i(147117);
    if (this.x != null) {
      this.x.b();
    }
    if (this.y != null) {
      this.y.b();
    }
    if (this.w != null) {
      this.w.b();
    }
    if (this.z != null) {
      this.z.b();
    }
    if (this.D != null) {
      this.D.b();
    }
    AppMethodBeat.o(147117);
  }
  
  public final void h(boolean paramBoolean)
  {
    AppMethodBeat.i(147164);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147164);
      return;
    }
    this.v.e(paramBoolean);
    AppMethodBeat.o(147164);
  }
  
  public final boolean i()
  {
    AppMethodBeat.i(147120);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147120);
      return false;
    }
    boolean bool = this.v.f();
    AppMethodBeat.o(147120);
    return bool;
  }
  
  public final boolean j()
  {
    AppMethodBeat.i(147123);
    if (this.F)
    {
      AppMethodBeat.o(147123);
      return false;
    }
    A();
    boolean bool = this.B.e();
    AppMethodBeat.o(147123);
    return bool;
  }
  
  public final Location k()
  {
    AppMethodBeat.i(147126);
    if (this.F)
    {
      AppMethodBeat.o(147126);
      return null;
    }
    A();
    Location localLocation = this.B.b();
    AppMethodBeat.o(147126);
    return localLocation;
  }
  
  public final ak l()
  {
    AppMethodBeat.i(147127);
    if (this.F)
    {
      AppMethodBeat.o(147127);
      return null;
    }
    if (this.H == null) {
      this.H = new ak(this.C);
    }
    ak localak = this.H;
    AppMethodBeat.o(147127);
    return localak;
  }
  
  public final ag m()
  {
    AppMethodBeat.i(147128);
    if ((this.F) || (this.i == null))
    {
      AppMethodBeat.o(147128);
      return null;
    }
    if (this.u == null) {
      this.u = new ag(this.i);
    }
    ag localag = this.u;
    AppMethodBeat.o(147128);
    return localag;
  }
  
  final void n()
  {
    AppMethodBeat.i(147133);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147133);
      return;
    }
    this.v.g();
    AppMethodBeat.o(147133);
  }
  
  final void o()
  {
    AppMethodBeat.i(147134);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147134);
      return;
    }
    this.v.h();
    AppMethodBeat.o(147134);
  }
  
  final void p()
  {
    AppMethodBeat.i(147135);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147135);
      return;
    }
    this.v.i();
    AppMethodBeat.o(147135);
  }
  
  final void q()
  {
    AppMethodBeat.i(147136);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147136);
      return;
    }
    this.v.j();
    AppMethodBeat.o(147136);
  }
  
  final void r()
  {
    AppMethodBeat.i(147137);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147137);
      return;
    }
    this.v.k();
    AppMethodBeat.o(147137);
  }
  
  final void s()
  {
    AppMethodBeat.i(147138);
    if (this.F)
    {
      AppMethodBeat.o(147138);
      return;
    }
    if (this.v != null) {
      this.v.l();
    }
    if (this.j != null) {
      this.j.b();
    }
    C();
    B();
    this.F = true;
    AppMethodBeat.o(147138);
  }
  
  public final String t()
  {
    AppMethodBeat.i(147147);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147147);
      return "";
    }
    String str = this.v.m();
    AppMethodBeat.o(147147);
    return str;
  }
  
  public final int u()
  {
    AppMethodBeat.i(147157);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147157);
      return -1;
    }
    int i1 = this.v.n();
    AppMethodBeat.o(147157);
    return i1;
  }
  
  public final String[] v()
  {
    AppMethodBeat.i(147158);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147158);
      return null;
    }
    String[] arrayOfString = this.v.o();
    AppMethodBeat.o(147158);
    return arrayOfString;
  }
  
  public final boolean w()
  {
    AppMethodBeat.i(147162);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147162);
      return false;
    }
    boolean bool = this.v.p();
    AppMethodBeat.o(147162);
    return bool;
  }
  
  public final int x()
  {
    AppMethodBeat.i(147165);
    if (this.I == null)
    {
      AppMethodBeat.o(147165);
      return 0;
    }
    int i1 = this.I.getWidth();
    AppMethodBeat.o(147165);
    return i1;
  }
  
  public final int y()
  {
    AppMethodBeat.i(147166);
    if (this.I == null)
    {
      AppMethodBeat.o(147166);
      return 0;
    }
    int i1 = this.I.getHeight();
    AppMethodBeat.o(147166);
    return i1;
  }
  
  public final String z()
  {
    AppMethodBeat.i(147168);
    if ((this.F) || (this.v == null))
    {
      AppMethodBeat.o(147168);
      return null;
    }
    String str = this.v.r();
    AppMethodBeat.o(147168);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  public static abstract interface b
  {
    public abstract View a(dc paramdc);
    
    public abstract View b(dc paramdc);
  }
  
  public static abstract interface i
  {
    public abstract void a();
  }
  
  public static abstract interface j
  {
    public abstract void a(cz paramcz);
  }
  
  public static abstract interface k
  {
    public abstract void a(db paramdb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ah
 * JD-Core Version:    0.7.0.1
 */