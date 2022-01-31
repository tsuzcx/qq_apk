package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class bp
{
  private bu a;
  private ah.p b;
  private Handler c;
  
  public bp(bu parambu)
  {
    AppMethodBeat.i(149918);
    this.a = null;
    this.b = null;
    this.c = new bp.1(this, Looper.getMainLooper());
    this.a = parambu;
    c(false);
    AppMethodBeat.o(149918);
  }
  
  private void a(Handler paramHandler, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(149938);
    if (this.a == null)
    {
      AppMethodBeat.o(149938);
      return;
    }
    this.a.a(paramHandler, paramConfig);
    AppMethodBeat.o(149938);
  }
  
  private boolean a(String paramString)
  {
    AppMethodBeat.i(149957);
    if ((paramString == null) || (paramString.trim().length() == 0))
    {
      AppMethodBeat.o(149957);
      return true;
    }
    AppMethodBeat.o(149957);
    return false;
  }
  
  public final int a(ab paramab)
  {
    AppMethodBeat.i(149922);
    if (this.a == null)
    {
      AppMethodBeat.o(149922);
      return -2147483648;
    }
    int i = this.a.a(paramab);
    AppMethodBeat.o(149922);
    return i;
  }
  
  public final int a(ab paramab, long paramLong, ah.a parama)
  {
    AppMethodBeat.i(149923);
    if (this.a == null)
    {
      AppMethodBeat.o(149923);
      return -2147483648;
    }
    int i = this.a.a(paramab, paramLong, parama);
    AppMethodBeat.o(149923);
    return i;
  }
  
  public String a(cz paramcz)
  {
    AppMethodBeat.i(149952);
    if (this.a != null)
    {
      paramcz = this.a.b(paramcz);
      AppMethodBeat.o(149952);
      return paramcz;
    }
    AppMethodBeat.o(149952);
    return null;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(149942);
    if (this.a == null)
    {
      AppMethodBeat.o(149942);
      return;
    }
    this.a.a(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(149942);
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(149925);
    if (this.a == null)
    {
      AppMethodBeat.o(149925);
      return;
    }
    this.a.a(paramInt);
    AppMethodBeat.o(149925);
  }
  
  public final void a(ah.c paramc)
  {
    AppMethodBeat.i(149931);
    if (this.a == null)
    {
      AppMethodBeat.o(149931);
      return;
    }
    this.a.a(paramc);
    AppMethodBeat.o(149931);
  }
  
  public final void a(ah.f paramf)
  {
    AppMethodBeat.i(149947);
    if (this.a == null)
    {
      AppMethodBeat.o(149947);
      return;
    }
    this.a.a(paramf);
    AppMethodBeat.o(149947);
  }
  
  public final void a(ah.g paramg)
  {
    AppMethodBeat.i(149946);
    if (this.a == null)
    {
      AppMethodBeat.o(149946);
      return;
    }
    this.a.a(paramg);
    AppMethodBeat.o(149946);
  }
  
  public final void a(ah.h paramh)
  {
    AppMethodBeat.i(149929);
    if (this.a == null)
    {
      AppMethodBeat.o(149929);
      return;
    }
    this.a.a(paramh);
    AppMethodBeat.o(149929);
  }
  
  public void a(ah.i parami)
  {
    AppMethodBeat.i(149944);
    if (this.a != null) {
      this.a.a(parami);
    }
    AppMethodBeat.o(149944);
  }
  
  public final void a(ah.j paramj)
  {
    AppMethodBeat.i(149930);
    if (this.a == null)
    {
      AppMethodBeat.o(149930);
      return;
    }
    this.a.a(paramj);
    AppMethodBeat.o(149930);
  }
  
  public final void a(ah.k paramk)
  {
    AppMethodBeat.i(149953);
    if (this.a == null)
    {
      AppMethodBeat.o(149953);
      return;
    }
    this.a.a(paramk);
    AppMethodBeat.o(149953);
  }
  
  public final void a(ah.l paraml)
  {
    AppMethodBeat.i(149945);
    if (this.a == null)
    {
      AppMethodBeat.o(149945);
      return;
    }
    this.a.a(paraml);
    AppMethodBeat.o(149945);
  }
  
  public void a(ah.p paramp, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(149939);
    if ((this.a == null) || (paramp == null))
    {
      AppMethodBeat.o(149939);
      return;
    }
    this.b = paramp;
    a(this.c, paramConfig);
    AppMethodBeat.o(149939);
  }
  
  public void a(cy paramcy)
  {
    AppMethodBeat.i(149960);
    if (this.a != null) {
      this.a.a(paramcy);
    }
    AppMethodBeat.o(149960);
  }
  
  public final void a(dl paramdl)
  {
    AppMethodBeat.i(149940);
    if (this.a == null)
    {
      AppMethodBeat.o(149940);
      return;
    }
    this.a.a(paramdl);
    AppMethodBeat.o(149940);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149956);
    if ((a(paramString1)) || (a(paramString2)))
    {
      AppMethodBeat.o(149956);
      return;
    }
    this.a.a(paramString1, paramString2);
    AppMethodBeat.o(149956);
  }
  
  public final void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149926);
    if (this.a == null)
    {
      AppMethodBeat.o(149926);
      return;
    }
    this.a.a(paramBoolean);
    AppMethodBeat.o(149926);
  }
  
  public cn b()
  {
    AppMethodBeat.i(149919);
    if (this.a == null)
    {
      AppMethodBeat.o(149919);
      return null;
    }
    cn localcn = this.a.f();
    AppMethodBeat.o(149919);
    return localcn;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(149949);
    if (this.a != null) {
      this.a.b(paramInt);
    }
    AppMethodBeat.o(149949);
  }
  
  public final void b(dl paramdl)
  {
    AppMethodBeat.i(149941);
    if (this.a == null)
    {
      AppMethodBeat.o(149941);
      return;
    }
    this.a.b(paramdl);
    AppMethodBeat.o(149941);
  }
  
  public final void b(boolean paramBoolean)
  {
    AppMethodBeat.i(149927);
    if (this.a == null)
    {
      AppMethodBeat.o(149927);
      return;
    }
    this.a.b(paramBoolean);
    AppMethodBeat.o(149927);
  }
  
  public final float c()
  {
    AppMethodBeat.i(149920);
    if (this.a == null)
    {
      AppMethodBeat.o(149920);
      return -1.0F;
    }
    float f = this.a.g();
    AppMethodBeat.o(149920);
    return f;
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(149948);
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
    AppMethodBeat.o(149948);
  }
  
  public final float d()
  {
    AppMethodBeat.i(149921);
    if (this.a == null)
    {
      AppMethodBeat.o(149921);
      return -1.0F;
    }
    float f = this.a.h();
    AppMethodBeat.o(149921);
    return f;
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(149954);
    if (this.a == null)
    {
      AppMethodBeat.o(149954);
      return;
    }
    this.a.e(paramBoolean);
    AppMethodBeat.o(149954);
  }
  
  public final void e()
  {
    AppMethodBeat.i(149924);
    if (this.a == null)
    {
      AppMethodBeat.o(149924);
      return;
    }
    this.a.i();
    AppMethodBeat.o(149924);
  }
  
  public void e(boolean paramBoolean)
  {
    AppMethodBeat.i(149958);
    if (this.a == null)
    {
      AppMethodBeat.o(149958);
      return;
    }
    this.a.f(paramBoolean);
    AppMethodBeat.o(149958);
  }
  
  public final boolean f()
  {
    AppMethodBeat.i(149928);
    if (this.a == null)
    {
      AppMethodBeat.o(149928);
      return false;
    }
    boolean bool = this.a.j();
    AppMethodBeat.o(149928);
    return bool;
  }
  
  public void g()
  {
    AppMethodBeat.i(149932);
    if (this.a == null)
    {
      AppMethodBeat.o(149932);
      return;
    }
    this.a.m();
    AppMethodBeat.o(149932);
  }
  
  public void h()
  {
    AppMethodBeat.i(149933);
    if (this.a == null)
    {
      AppMethodBeat.o(149933);
      return;
    }
    this.a.n();
    AppMethodBeat.o(149933);
  }
  
  public void i()
  {
    AppMethodBeat.i(149934);
    if (this.a == null)
    {
      AppMethodBeat.o(149934);
      return;
    }
    this.a.s();
    AppMethodBeat.o(149934);
  }
  
  public void j()
  {
    AppMethodBeat.i(149935);
    if (this.a == null)
    {
      AppMethodBeat.o(149935);
      return;
    }
    this.a.t();
    AppMethodBeat.o(149935);
  }
  
  public void k()
  {
    AppMethodBeat.i(149936);
    if (this.a == null)
    {
      AppMethodBeat.o(149936);
      return;
    }
    this.a.o();
    AppMethodBeat.o(149936);
  }
  
  public void l()
  {
    AppMethodBeat.i(149937);
    if (this.a == null)
    {
      AppMethodBeat.o(149937);
      return;
    }
    this.a.p();
    AppMethodBeat.o(149937);
  }
  
  public String m()
  {
    AppMethodBeat.i(149943);
    if (this.a == null)
    {
      AppMethodBeat.o(149943);
      return "";
    }
    String str = this.a.q();
    AppMethodBeat.o(149943);
    return str;
  }
  
  public int n()
  {
    AppMethodBeat.i(149950);
    if (this.a != null)
    {
      int i = this.a.u();
      AppMethodBeat.o(149950);
      return i;
    }
    AppMethodBeat.o(149950);
    return -1;
  }
  
  public String[] o()
  {
    AppMethodBeat.i(149951);
    if (this.a != null)
    {
      String[] arrayOfString = this.a.v();
      AppMethodBeat.o(149951);
      return arrayOfString;
    }
    AppMethodBeat.o(149951);
    return null;
  }
  
  public boolean p()
  {
    AppMethodBeat.i(149955);
    if (this.a == null)
    {
      AppMethodBeat.o(149955);
      return false;
    }
    boolean bool = this.a.w();
    AppMethodBeat.o(149955);
    return bool;
  }
  
  public boolean q()
  {
    AppMethodBeat.i(149959);
    if (this.a != null)
    {
      boolean bool = this.a.x();
      AppMethodBeat.o(149959);
      return bool;
    }
    AppMethodBeat.o(149959);
    return false;
  }
  
  public String r()
  {
    AppMethodBeat.i(149961);
    if (this.a == null)
    {
      AppMethodBeat.o(149961);
      return null;
    }
    String str = this.a.y();
    AppMethodBeat.o(149961);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bp
 * JD-Core Version:    0.7.0.1
 */