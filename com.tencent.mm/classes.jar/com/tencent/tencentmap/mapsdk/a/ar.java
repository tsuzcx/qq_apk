package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.tencent.map.lib.element.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.jr;
import com.tencent.tencentmap.mapsdk.maps.a.lh.a;
import com.tencent.tencentmap.mapsdk.maps.a.ne;
import com.tencent.tencentmap.mapsdk.maps.a.ne.a;
import java.util.List;

public class ar
  implements lh.a, ne.a
{
  private bw a = null;
  private dc b;
  private dc c;
  private dc d;
  
  public ar(bw parambw)
  {
    this.a = parambw;
  }
  
  public final dc a(dd paramdd, ar paramar)
  {
    AppMethodBeat.i(149713);
    if (this.a != null)
    {
      paramdd = this.a.a(paramdd, paramar);
      AppMethodBeat.o(149713);
      return paramdd;
    }
    AppMethodBeat.o(149713);
    return null;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149742);
    if (this.d == null)
    {
      dd localdd = new dd();
      localdd.a(0.5F, 0.5F);
      localdd.a("AUTH_MARKER");
      localdd.a(cl.a(paramBitmap));
      this.d = a(localdd, this);
      this.d.a(paramInt1 / 2, paramInt2 / 2);
      this.d.c(false);
      AppMethodBeat.o(149742);
      return;
    }
    this.d.a(cl.a(paramBitmap));
    this.d.a(paramInt1 / 2, paramInt2 / 2);
    AppMethodBeat.o(149742);
  }
  
  public void a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(149738);
    if ((paramView == null) || (paramRect == null))
    {
      AppMethodBeat.o(149738);
      return;
    }
    paramView = jr.a(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(149738);
      return;
    }
    if (this.b == null)
    {
      dd localdd = new dd().a(0.0F, 0.0F).b(false);
      localdd.a("AUTH_MARKER");
      localdd.e(true);
      this.b = a(localdd, this);
      this.b.c(false);
    }
    this.b.a(paramRect.left, paramRect.top);
    this.b.a(cl.a(paramView));
    this.b.b(paramBoolean);
    AppMethodBeat.o(149738);
  }
  
  public final void a(ah.b paramb)
  {
    AppMethodBeat.i(149737);
    if (this.a != null) {
      this.a.a(paramb);
    }
    AppMethodBeat.o(149737);
  }
  
  public final void a(ah.m paramm)
  {
    AppMethodBeat.i(149736);
    if (this.a != null) {
      this.a.a(paramm);
    }
    AppMethodBeat.o(149736);
  }
  
  public void a(ne paramne)
  {
    AppMethodBeat.i(149740);
    if (this.c != null) {
      this.c.b(false);
    }
    if ((paramne != null) && (this.b != null) && (!paramne.j())) {
      this.b.b(false);
    }
    AppMethodBeat.o(149740);
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(149714);
    if (this.a != null) {
      this.a.a(paramString);
    }
    AppMethodBeat.o(149714);
  }
  
  public final void a(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149727);
    if (this.a != null) {
      this.a.a(paramString, paramFloat);
    }
    AppMethodBeat.o(149727);
  }
  
  public final void a(String paramString, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149715);
    if (this.a != null) {
      this.a.a(paramString, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(149715);
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(149722);
    if (this.a == null)
    {
      AppMethodBeat.o(149722);
      return;
    }
    this.a.a(paramString, paramInt);
    AppMethodBeat.o(149722);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149733);
    if (this.a != null) {
      this.a.a(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(149733);
  }
  
  public final void a(String paramString, ck paramck)
  {
    AppMethodBeat.i(149717);
    if (this.a != null) {
      this.a.a(paramString, paramck);
    }
    AppMethodBeat.o(149717);
  }
  
  public final void a(String paramString, cz paramcz)
  {
    AppMethodBeat.i(149718);
    if (this.a != null) {
      this.a.a(paramString, paramcz);
    }
    AppMethodBeat.o(149718);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(100657);
    if (this.a != null) {
      this.a.a(paramString1, paramString2);
    }
    AppMethodBeat.o(100657);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149716);
    if (this.a != null) {
      this.a.a(paramString, paramBoolean);
    }
    AppMethodBeat.o(149716);
  }
  
  public final cz b(String paramString)
  {
    AppMethodBeat.i(149719);
    if (this.a != null)
    {
      paramString = this.a.f(paramString);
      AppMethodBeat.o(149719);
      return paramString;
    }
    AppMethodBeat.o(149719);
    return null;
  }
  
  public final void b()
  {
    AppMethodBeat.i(149726);
    if (this.a != null) {
      this.a.b();
    }
    AppMethodBeat.o(149726);
  }
  
  public void b(View paramView, Rect paramRect, boolean paramBoolean)
  {
    AppMethodBeat.i(149739);
    if ((paramView == null) || (paramRect == null))
    {
      AppMethodBeat.o(149739);
      return;
    }
    paramView = jr.a(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(149739);
      return;
    }
    if (this.c == null)
    {
      dd localdd = new dd().a(0.0F, 0.0F).b(false);
      localdd.a("AUTH_MARKER");
      localdd.e(true);
      this.c = a(localdd, this);
      this.c.c(false);
    }
    this.c.a(paramRect.left, paramRect.top);
    this.c.a(cl.a(paramView));
    this.c.b(paramBoolean);
    AppMethodBeat.o(149739);
  }
  
  public void b(ne paramne)
  {
    AppMethodBeat.i(149741);
    if (this.c != null) {
      this.c.b(true);
    }
    if (this.b != null) {
      this.b.b(true);
    }
    AppMethodBeat.o(149741);
  }
  
  public void b(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149729);
    if (this.a != null) {
      this.a.b(paramString, paramFloat);
    }
    AppMethodBeat.o(149729);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149720);
    if (this.a != null) {
      this.a.b(paramString1, paramString2);
    }
    AppMethodBeat.o(149720);
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149721);
    if (this.a != null) {
      this.a.b(paramString, paramBoolean);
    }
    AppMethodBeat.o(149721);
  }
  
  public final void c(String paramString)
  {
    AppMethodBeat.i(149723);
    if (this.a != null) {
      this.a.b(paramString);
    }
    AppMethodBeat.o(149723);
  }
  
  public void c(String paramString, float paramFloat)
  {
    AppMethodBeat.i(149734);
    if (this.a != null) {
      this.a.c(paramString, paramFloat);
    }
    AppMethodBeat.o(149734);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149730);
    if (this.a != null) {
      this.a.c(paramString, paramBoolean);
    }
    AppMethodBeat.o(149730);
  }
  
  public final void d(String paramString)
  {
    AppMethodBeat.i(149724);
    if (this.a != null) {
      this.a.c(paramString);
    }
    AppMethodBeat.o(149724);
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(149731);
    if (this.a != null) {
      this.a.d(paramString, paramBoolean);
    }
    AppMethodBeat.o(149731);
  }
  
  public final boolean e(String paramString)
  {
    AppMethodBeat.i(149725);
    if (this.a != null)
    {
      boolean bool = this.a.d(paramString);
      AppMethodBeat.o(149725);
      return bool;
    }
    AppMethodBeat.o(149725);
    return false;
  }
  
  public final float f(String paramString)
  {
    AppMethodBeat.i(149728);
    if (this.a != null)
    {
      float f = this.a.e(paramString);
      AppMethodBeat.o(149728);
      return f;
    }
    AppMethodBeat.o(149728);
    return 0.0F;
  }
  
  public boolean g(String paramString)
  {
    AppMethodBeat.i(149732);
    if (this.a != null)
    {
      boolean bool = this.a.g(paramString);
      AppMethodBeat.o(149732);
      return bool;
    }
    AppMethodBeat.o(149732);
    return false;
  }
  
  public List<j> h(String paramString)
  {
    AppMethodBeat.i(149735);
    if (this.a != null)
    {
      paramString = this.a.h(paramString);
      AppMethodBeat.o(149735);
      return paramString;
    }
    AppMethodBeat.o(149735);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ar
 * JD-Core Version:    0.7.0.1
 */