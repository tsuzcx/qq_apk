package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.tencent.map.lib.a;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ai;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class ib
  implements JNICallback.h, ic
{
  protected ie a;
  private Context b;
  private f c;
  private ik d;
  private in e;
  private iw f;
  private float g;
  private Handler h;
  private int i;
  private nr j;
  private ai k;
  private volatile boolean l;
  
  public ib(ie paramie, Context paramContext, ai paramai)
  {
    AppMethodBeat.i(148152);
    this.g = 0.5F;
    this.h = new Handler();
    this.i = 0;
    this.a = null;
    this.a = paramie;
    this.b = paramContext;
    this.k = paramai;
    k();
    AppMethodBeat.o(148152);
  }
  
  private float a(float paramFloat)
  {
    AppMethodBeat.i(148171);
    int m = (int)paramFloat;
    paramFloat = (float)Math.pow(2.0D, paramFloat - m);
    float f1 = 1 << m - 3;
    AppMethodBeat.o(148171);
    return f1 * 3.051758E-005F * paramFloat;
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(148170);
    this.d.a().a(paramFloat1, paramFloat2, 0, paramBoolean);
    AppMethodBeat.o(148170);
  }
  
  private void r()
  {
    AppMethodBeat.i(148176);
    long l1 = System.currentTimeMillis();
    nr localnr = o();
    if (localnr != null)
    {
      localnr.a(true);
      localnr.a(l1);
    }
    this.l = false;
    AppMethodBeat.o(148176);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(148157);
    float f2;
    float f1;
    if ((this.d != null) && (this.h != null))
    {
      f2 = this.d.a().l();
      f1 = a(paramFloat3);
      if (Math.abs(f2 - f1) <= 0.0001D) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      this.i = 0;
      f2 = (paramFloat2 - this.g) / 10.0F;
      this.h.post(new ib.1(this, f2, paramFloat1, paramFloat2, paramFloat3, bool, f1));
      AppMethodBeat.o(148157);
      return;
    }
  }
  
  public void a(a parama, jd paramjd)
  {
    AppMethodBeat.i(148156);
    if (this.d.a(this.b.getApplicationContext(), parama, paramjd)) {
      this.d.a().k();
    }
    AppMethodBeat.o(148156);
  }
  
  public void a(id paramid)
  {
    AppMethodBeat.i(148154);
    this.e.a(paramid);
    AppMethodBeat.o(148154);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2) {}
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148168);
    this.d.a(paramInt1, paramInt2);
    AppMethodBeat.o(148168);
  }
  
  public void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(148167);
    this.d.a(paramGL10);
    AppMethodBeat.o(148167);
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148159);
    if (this.f != null)
    {
      this.f.b();
      this.f.a(paramArrayOfByte);
    }
    AppMethodBeat.o(148159);
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(148174);
    if (this.d == null)
    {
      AppMethodBeat.o(148174);
      return false;
    }
    boolean bool = this.d.g(paramInt);
    AppMethodBeat.o(148174);
    return bool;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(148165);
    if (this.e != null)
    {
      boolean bool = this.e.onTouch(null, paramMotionEvent);
      AppMethodBeat.o(148165);
      return bool;
    }
    AppMethodBeat.o(148165);
    return false;
  }
  
  public boolean a(GL10 paramGL10)
  {
    AppMethodBeat.i(148169);
    boolean bool = this.d.b(paramGL10);
    AppMethodBeat.o(148169);
    return bool;
  }
  
  public void a_()
  {
    AppMethodBeat.i(148153);
    if (this.a != null) {
      this.a.a_();
    }
    AppMethodBeat.o(148153);
  }
  
  public f b()
  {
    return this.c;
  }
  
  public void b(id paramid)
  {
    AppMethodBeat.i(148155);
    this.e.b(paramid);
    AppMethodBeat.o(148155);
  }
  
  public ik c()
  {
    return this.d;
  }
  
  public void d()
  {
    AppMethodBeat.i(99791);
    if (this.d != null)
    {
      getEGLContextHash();
      this.d.n();
    }
    AppMethodBeat.o(99791);
  }
  
  public void e()
  {
    AppMethodBeat.i(148160);
    if (this.f != null) {
      this.f.b();
    }
    this.d.l();
    AppMethodBeat.o(148160);
  }
  
  public void f()
  {
    AppMethodBeat.i(148161);
    if (this.f != null) {
      this.f.a();
    }
    this.d.m();
    AppMethodBeat.o(148161);
  }
  
  public void g()
  {
    AppMethodBeat.i(99793);
    b.a();
    this.j.b = (System.currentTimeMillis() - this.j.a);
    ns.a(this).a(this.j);
    AppMethodBeat.o(99793);
  }
  
  public int getEGLContextHash()
  {
    AppMethodBeat.i(148158);
    Object localObject = (EGL10)EGLContext.getEGL();
    if (localObject != null)
    {
      localObject = ((EGL10)localObject).eglGetCurrentContext();
      if (localObject != null)
      {
        int m = localObject.hashCode();
        AppMethodBeat.o(148158);
        return m;
      }
    }
    AppMethodBeat.o(148158);
    return 0;
  }
  
  public int getHeight()
  {
    AppMethodBeat.i(148164);
    if (this.a != null)
    {
      int m = this.a.getHeight();
      AppMethodBeat.o(148164);
      return m;
    }
    AppMethodBeat.o(148164);
    return 2147483647;
  }
  
  public ic getVectorMapDelegate()
  {
    return this;
  }
  
  public int getWidth()
  {
    AppMethodBeat.i(148163);
    if (this.a != null)
    {
      int m = this.a.getWidth();
      AppMethodBeat.o(148163);
      return m;
    }
    AppMethodBeat.o(148163);
    return 2147483647;
  }
  
  public void h()
  {
    AppMethodBeat.i(148166);
    if (this.a != null) {
      this.a.a_();
    }
    AppMethodBeat.o(148166);
  }
  
  public Context i()
  {
    return this.b;
  }
  
  public void j() {}
  
  public void k()
  {
    AppMethodBeat.i(99775);
    if (this.b == null)
    {
      AppMethodBeat.o(99775);
      return;
    }
    ns.a(this).b(this);
    this.j = new nr();
    this.j.a = System.currentTimeMillis();
    this.e = new in(this);
    if (this.d == null) {
      this.d = new ik(this.b, this);
    }
    this.c = new f(this.d);
    this.e.a(this.d);
    WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
    int m = localWindowManager.getDefaultDisplay().getWidth();
    int n = localWindowManager.getDefaultDisplay().getHeight();
    this.d.b(m, n);
    this.f = new iw(c());
    this.f.start();
    b().a(this);
    this.l = true;
    AppMethodBeat.o(99775);
  }
  
  public void l()
  {
    AppMethodBeat.i(99777);
    if (this.d != null) {
      this.d.q();
    }
    AppMethodBeat.o(99777);
  }
  
  protected boolean m()
  {
    AppMethodBeat.i(148172);
    Object localObject = i();
    if (localObject == null)
    {
      AppMethodBeat.o(148172);
      return false;
    }
    localObject = (AccessibilityManager)((Context)localObject).getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    if (Build.VERSION.SDK_INT < 14)
    {
      AppMethodBeat.o(148172);
      return bool1;
    }
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    if ((bool1) && (bool2))
    {
      AppMethodBeat.o(148172);
      return true;
    }
    AppMethodBeat.o(148172);
    return false;
  }
  
  public boolean n()
  {
    AppMethodBeat.i(148173);
    if ((this.d != null) && (this.d.E()))
    {
      AppMethodBeat.o(148173);
      return true;
    }
    AppMethodBeat.o(148173);
    return false;
  }
  
  public nr o()
  {
    return this.j;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public ai p()
  {
    return this.k;
  }
  
  public void q()
  {
    AppMethodBeat.i(148175);
    if (this.l) {
      r();
    }
    AppMethodBeat.o(148175);
  }
  
  public void setZOrderMediaOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(148162);
    if (this.a != null) {
      this.a.setZOrderMediaOverlay(paramBoolean);
    }
    AppMethodBeat.o(148162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ib
 * JD-Core Version:    0.7.0.1
 */