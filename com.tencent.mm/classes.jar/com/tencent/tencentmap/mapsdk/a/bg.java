package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ie;
import com.tencent.tencentmap.mapsdk.maps.a.kx;
import com.tencent.tencentmap.mapsdk.maps.a.lh.a;
import com.tencent.tencentmap.mapsdk.maps.a.na;
import com.tencent.tencentmap.mapsdk.maps.a.nb;
import com.tencent.tencentmap.mapsdk.maps.a.nb.a;
import com.tencent.tencentmap.mapsdk.maps.a.nb.b;
import com.tencent.tencentmap.mapsdk.maps.a.nc;
import com.tencent.tencentmap.mapsdk.maps.a.ne;
import com.tencent.tencentmap.mapsdk.maps.a.ne.a;
import com.tencent.tencentmap.mapsdk.maps.a.nf;
import com.tencent.tencentmap.mapsdk.maps.a.nf.a;
import com.tencent.tencentmap.mapsdk.maps.a.ng;
import com.tencent.tencentmap.mapsdk.maps.a.nn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bg
  extends cd
  implements aq, nf.a
{
  public Handler a;
  private aa b;
  private ai c;
  private kx d;
  private ng e;
  private ne f;
  private nc g;
  private na h;
  private lh.a i;
  private int j;
  private List<nb> k;
  private boolean l;
  
  public bg(aa paramaa, ie paramie)
  {
    AppMethodBeat.i(149843);
    this.b = null;
    this.k = new ArrayList();
    this.l = false;
    this.a = new bg.1(this, Looper.getMainLooper());
    this.b = paramaa;
    if (paramie == null)
    {
      AppMethodBeat.o(149843);
      return;
    }
    this.d = ((kx)paramie.getVectorMapDelegate());
    this.c = this.d.p();
    if ((paramie instanceof View))
    {
      paramaa = (View)paramie;
      if (this.b.indexOfChild(paramaa) < 0)
      {
        paramie = new FrameLayout.LayoutParams(-1, -1);
        this.b.addView(paramaa, 0, paramie);
        this.b.requestLayout();
      }
    }
    int n = 4;
    int m = 20;
    if (this.d.b() != null)
    {
      n = this.d.b().b();
      m = this.d.b().c();
    }
    this.f = new ne(this.b.getContext().getApplicationContext(), n, m);
    this.d.a(this.f);
    this.g = new nc(this.b.getContext(), this.b);
    this.d.a(this.g);
    this.e = new ng(this.b.getContext(), this.d);
    this.k.add(this.f);
    this.k.add(this.e);
    this.d.a(this);
    this.d.a(this);
    b(0, 0);
    AppMethodBeat.o(149843);
  }
  
  public void a()
  {
    AppMethodBeat.i(149844);
    if ((this.b == null) || (this.d == null))
    {
      AppMethodBeat.o(149844);
      return;
    }
    if (this.a != null) {
      this.a.removeCallbacksAndMessages(null);
    }
    this.b.removeAllViews();
    this.d.a(null);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((nb)localIterator.next()).a();
    }
    this.e = null;
    this.e = null;
    this.k.clear();
    this.k = null;
    this.d = null;
    this.b = null;
    AppMethodBeat.o(149844);
  }
  
  void a(float paramFloat)
  {
    AppMethodBeat.i(149869);
    if (this.f != null) {
      this.f.a(paramFloat);
    }
    AppMethodBeat.o(149869);
  }
  
  void a(int paramInt)
  {
    AppMethodBeat.i(149861);
    if (this.f != null)
    {
      this.f.a(nb.b.a(paramInt));
      f();
    }
    AppMethodBeat.o(149861);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149857);
    this.j = paramInt2;
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext())
    {
      nb localnb = (nb)localIterator.next();
      localnb.a(paramInt1, paramInt2);
      localnb.a(this.b);
    }
    AppMethodBeat.o(149857);
  }
  
  void a(int paramInt, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(149862);
    if (this.f != null)
    {
      nb.b localb = nb.b.a(paramInt);
      this.f.a(localb);
      switch (2.a[localb.ordinal()])
      {
      }
    }
    for (;;)
    {
      this.f.d();
      f();
      AppMethodBeat.o(149862);
      return;
      this.f.a(nb.a.d, paramArrayOfInt[0]);
      this.f.a(nb.a.a, paramArrayOfInt[1]);
      continue;
      this.f.a(nb.a.c, paramArrayOfInt[0]);
      this.f.a(nb.a.a, paramArrayOfInt[1]);
      continue;
      this.f.a(nb.a.c, paramArrayOfInt[0]);
      this.f.a(nb.a.b, paramArrayOfInt[1]);
      continue;
      this.f.a(nb.a.d, paramArrayOfInt[0]);
      this.f.a(nb.a.b, paramArrayOfInt[1]);
    }
  }
  
  public void a(bg.a parama)
  {
    AppMethodBeat.i(149845);
    if (this.e != null) {
      this.e.a(parama);
    }
    AppMethodBeat.o(149845);
  }
  
  public void a(lh.a parama, ai paramai)
  {
    AppMethodBeat.i(149871);
    if ((paramai != null) && (paramai.d() != null))
    {
      this.i = parama;
      int m = paramai.e();
      int n = paramai.f();
      this.b.measure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), View.MeasureSpec.makeMeasureSpec(n, 1073741824));
      a(m, n);
    }
    AppMethodBeat.o(149871);
  }
  
  public void a(ne.a parama, ai paramai)
  {
    AppMethodBeat.i(149870);
    if ((paramai != null) && (paramai.d() != null) && (this.f != null) && (paramai != null))
    {
      this.f.a(parama);
      int m = paramai.e();
      int n = paramai.f();
      this.b.measure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), View.MeasureSpec.makeMeasureSpec(n, 1073741824));
      a(m, n);
    }
    AppMethodBeat.o(149870);
  }
  
  public void a(nf paramnf)
  {
    AppMethodBeat.i(149865);
    if ((paramnf != null) && (paramnf.a != -1))
    {
      paramnf = this.a.obtainMessage(paramnf.a, paramnf);
      this.a.sendMessage(paramnf);
    }
    AppMethodBeat.o(149865);
  }
  
  void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149846);
    this.e.a(paramBoolean);
    AppMethodBeat.o(149846);
  }
  
  void b(int paramInt)
  {
    AppMethodBeat.i(149863);
    if (this.f != null)
    {
      this.f.b(nb.b.a(paramInt));
      f();
    }
    AppMethodBeat.o(149863);
  }
  
  void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149866);
    if (this.d != null) {
      this.d.b(paramInt1, paramInt2);
    }
    AppMethodBeat.o(149866);
  }
  
  void b(boolean paramBoolean)
  {
    AppMethodBeat.i(149847);
    this.d.i(paramBoolean);
    AppMethodBeat.o(149847);
  }
  
  boolean b()
  {
    AppMethodBeat.i(149853);
    boolean bool = this.d.y();
    AppMethodBeat.o(149853);
    return bool;
  }
  
  void c(boolean paramBoolean)
  {
    AppMethodBeat.i(149848);
    this.d.c(paramBoolean);
    AppMethodBeat.o(149848);
  }
  
  boolean c()
  {
    AppMethodBeat.i(149854);
    boolean bool = this.d.B();
    AppMethodBeat.o(149854);
    return bool;
  }
  
  void d(boolean paramBoolean)
  {
    AppMethodBeat.i(149849);
    this.d.e(paramBoolean);
    AppMethodBeat.o(149849);
  }
  
  boolean d()
  {
    AppMethodBeat.i(149855);
    boolean bool = this.d.C();
    AppMethodBeat.o(149855);
    return bool;
  }
  
  void e(boolean paramBoolean)
  {
    AppMethodBeat.i(149850);
    this.d.f(paramBoolean);
    AppMethodBeat.o(149850);
  }
  
  public boolean e()
  {
    AppMethodBeat.i(149856);
    if (this.g != null)
    {
      boolean bool = this.g.b();
      AppMethodBeat.o(149856);
      return bool;
    }
    AppMethodBeat.o(149856);
    return false;
  }
  
  protected void f()
  {
    AppMethodBeat.i(149858);
    Iterator localIterator = this.k.iterator();
    while (localIterator.hasNext()) {
      ((nb)localIterator.next()).a(this.b);
    }
    AppMethodBeat.o(149858);
  }
  
  void f(boolean paramBoolean)
  {
    AppMethodBeat.i(149851);
    this.d.g(paramBoolean);
    AppMethodBeat.o(149851);
  }
  
  void g(boolean paramBoolean)
  {
    AppMethodBeat.i(149852);
    this.d.h(paramBoolean);
    c(paramBoolean);
    d(paramBoolean);
    e(paramBoolean);
    f(paramBoolean);
    AppMethodBeat.o(149852);
  }
  
  boolean g()
  {
    AppMethodBeat.i(149860);
    if (this.f != null)
    {
      boolean bool = this.f.f();
      AppMethodBeat.o(149860);
      return bool;
    }
    AppMethodBeat.o(149860);
    return false;
  }
  
  void h(boolean paramBoolean)
  {
    AppMethodBeat.i(149859);
    if (this.f != null) {
      this.f.b(paramBoolean);
    }
    AppMethodBeat.o(149859);
  }
  
  public void i(boolean paramBoolean)
  {
    AppMethodBeat.i(149864);
    if ((this.f == null) || (this.d == null) || (this.d.b() == null))
    {
      AppMethodBeat.o(149864);
      return;
    }
    if (paramBoolean) {
      this.f.b();
    }
    this.f.a(nn.g());
    this.f.a(this.d.S(), this.d.b().e());
    AppMethodBeat.o(149864);
  }
  
  void j(boolean paramBoolean)
  {
    AppMethodBeat.i(149867);
    if ((this.d != null) && (this.d.b() != null)) {
      this.d.b().j(paramBoolean);
    }
    AppMethodBeat.o(149867);
  }
  
  public void k(boolean paramBoolean)
  {
    AppMethodBeat.i(149868);
    this.g.a(paramBoolean);
    AppMethodBeat.o(149868);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bg
 * JD-Core Version:    0.7.0.1
 */