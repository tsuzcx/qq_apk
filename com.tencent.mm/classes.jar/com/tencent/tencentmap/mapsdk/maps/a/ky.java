package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.e;
import com.tencent.map.lib.gl.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ai;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ky
  extends e
  implements JNICallback.f, e.m, ie
{
  private kx a;
  private boolean b;
  private Object c;
  
  public ky(Context paramContext, ai paramai)
  {
    super(paramContext);
    AppMethodBeat.i(149095);
    if ((paramai != null) && (paramai.d() != null)) {
      this.c = paramai.d();
    }
    d();
    this.a = new kx(this, getContext().getApplicationContext(), paramai);
    setContentDescription("地图");
    AppMethodBeat.o(149095);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149109);
    if (this.a != null) {
      this.a.a(paramArrayOfByte);
    }
    AppMethodBeat.o(149109);
  }
  
  private void h()
  {
    AppMethodBeat.i(149107);
    setEGLContextClientVersion(2);
    setPreserveEGLContextOnPause(true);
    a(8, 8, 8, 8, 16, 0);
    setEGLContextFactory(new ky.1(this));
    if (this.c != null) {
      setEGLWindowSurfaceFactory(new ky.2(this));
    }
    AppMethodBeat.o(149107);
  }
  
  private void i()
  {
    AppMethodBeat.i(149108);
    if (this.a != null) {
      this.a.d();
    }
    AppMethodBeat.o(149108);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2) {}
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149097);
    if (this.a != null) {
      this.a.a(paramGL10, paramInt1, paramInt2);
    }
    AppMethodBeat.o(149097);
  }
  
  public void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(149096);
    if (this.a != null) {
      this.a.a(paramGL10, paramEGLConfig);
    }
    AppMethodBeat.o(149096);
  }
  
  public boolean a(GL10 paramGL10)
  {
    AppMethodBeat.i(149105);
    if (this.a == null)
    {
      AppMethodBeat.o(149105);
      return false;
    }
    boolean bool = this.a.a(paramGL10);
    AppMethodBeat.o(149105);
    return bool;
  }
  
  public void a_()
  {
    AppMethodBeat.i(149104);
    if (getVisibility() == 0) {
      b();
    }
    AppMethodBeat.o(149104);
  }
  
  public void d()
  {
    AppMethodBeat.i(149110);
    h();
    setRenderer(this);
    setRenderMode(0);
    this.b = gu.a(this, true);
    AppMethodBeat.o(149110);
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(149111);
    if ((this.a != null) && (this.a.b(paramMotionEvent)))
    {
      AppMethodBeat.o(149111);
      return true;
    }
    boolean bool = super.dispatchHoverEvent(paramMotionEvent);
    AppMethodBeat.o(149111);
    return bool;
  }
  
  public void e()
  {
    AppMethodBeat.i(149103);
    if (this.b) {
      super.e();
    }
    if (this.a != null) {
      this.a.e();
    }
    AppMethodBeat.o(149103);
  }
  
  public void f()
  {
    AppMethodBeat.i(149102);
    if (this.b) {
      super.f();
    }
    if (this.a != null) {
      this.a.f();
    }
    AppMethodBeat.o(149102);
  }
  
  public void g()
  {
    AppMethodBeat.i(149101);
    if (this.a != null) {
      this.a.g();
    }
    AppMethodBeat.o(149101);
  }
  
  public int getEGLContextHash()
  {
    AppMethodBeat.i(149106);
    if (this.a != null)
    {
      int i = this.a.getEGLContextHash();
      AppMethodBeat.o(149106);
      return i;
    }
    AppMethodBeat.o(149106);
    return 0;
  }
  
  public kx getVectorMapDelegate()
  {
    return this.a;
  }
  
  public void j()
  {
    AppMethodBeat.i(149098);
    if (this.a != null) {
      this.a.j();
    }
    AppMethodBeat.o(149098);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(149099);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(149099);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(149100);
    if (this.a != null)
    {
      boolean bool = this.a.a(paramMotionEvent);
      AppMethodBeat.o(149100);
      return bool;
    }
    AppMethodBeat.o(149100);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ky
 * JD-Core Version:    0.7.0.1
 */