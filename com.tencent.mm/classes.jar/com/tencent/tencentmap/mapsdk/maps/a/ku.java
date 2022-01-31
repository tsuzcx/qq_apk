package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ai;

public class ku
  extends View
  implements ie
{
  private Context a;
  private kx b;
  private Object c;
  private int d;
  private int e;
  private ai f;
  private kw g;
  private boolean h;
  private boolean i;
  
  public ku(Context paramContext, ai paramai)
  {
    super(paramContext);
    AppMethodBeat.i(148988);
    this.h = true;
    this.i = false;
    if ((paramai != null) && (paramContext != null))
    {
      Object localObject = paramai.d();
      if (localObject == null)
      {
        AppMethodBeat.o(148988);
        return;
      }
      this.a = paramContext.getApplicationContext();
      this.c = localObject;
      this.d = paramai.e();
      this.e = paramai.f();
      if ((this.e <= 0) || (this.d <= 0))
      {
        this.d = 0;
        this.e = 0;
      }
      this.f = paramai;
      this.b = new kx(this, this.a, this.f);
    }
    AppMethodBeat.o(148988);
  }
  
  private void b()
  {
    AppMethodBeat.i(148996);
    if ((this.b != null) && (this.h == true))
    {
      this.b.a(null, null);
      this.b.a(null, this.d, this.e);
      this.b.a(this.d, this.e);
      this.h = false;
    }
    AppMethodBeat.o(148996);
  }
  
  private void c()
  {
    AppMethodBeat.i(148997);
    if (this.g == null) {
      this.g = new kw(this.c, this.b);
    }
    if (!this.i)
    {
      this.g.start();
      this.i = true;
    }
    AppMethodBeat.o(148997);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148995);
    if ((this.b == null) || (this.g == null) || (!this.g.isAlive()))
    {
      AppMethodBeat.o(148995);
      return;
    }
    if (this.g != null)
    {
      this.c = paramObject;
      this.g.a(paramObject);
    }
    if (this.b != null)
    {
      this.b.a(null, null);
      this.b.a(null, paramInt1, paramInt2);
    }
    AppMethodBeat.o(148995);
  }
  
  public void a_()
  {
    AppMethodBeat.i(148989);
    if (this.g != null) {
      synchronized (this.g)
      {
        this.g.notify();
        AppMethodBeat.o(148989);
        return;
      }
    }
    AppMethodBeat.o(148989);
  }
  
  public void e()
  {
    AppMethodBeat.i(148990);
    if (this.b != null) {
      this.b.e();
    }
    if (this.g != null) {
      this.g.b();
    }
    b();
    c();
    AppMethodBeat.o(148990);
  }
  
  public void f()
  {
    AppMethodBeat.i(148991);
    if (this.b != null) {
      this.b.f();
    }
    if (this.g != null) {
      this.g.a();
    }
    AppMethodBeat.o(148991);
  }
  
  public void g()
  {
    AppMethodBeat.i(148992);
    if (this.b != null) {
      this.b.g();
    }
    if (this.g != null) {
      this.g.c();
    }
    AppMethodBeat.o(148992);
  }
  
  public ic getVectorMapDelegate()
  {
    return this.b;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148994);
    if (this.b != null)
    {
      this.d = paramInt1;
      this.e = paramInt2;
      this.b.a(null, paramInt1, paramInt2);
      this.b.a(paramInt1, paramInt2);
      this.b.h();
      this.h = true;
    }
    AppMethodBeat.o(148994);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148993);
    if (this.b != null)
    {
      boolean bool = this.b.a(paramMotionEvent);
      AppMethodBeat.o(148993);
      return bool;
    }
    AppMethodBeat.o(148993);
    return false;
  }
  
  public void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ku
 * JD-Core Version:    0.7.0.1
 */