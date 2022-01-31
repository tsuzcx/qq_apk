package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ai;

@TargetApi(14)
public class kv
  extends TextureView
  implements TextureView.SurfaceTextureListener, ie
{
  private kx a;
  private Object b;
  private kw c;
  
  public kv(Context paramContext, ai paramai)
  {
    super(paramContext);
    AppMethodBeat.i(148998);
    this.a = new kx(this, getContext().getApplicationContext(), paramai);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(148998);
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149006);
    if (this.b == null) {
      this.b = paramObject;
    }
    for (;;)
    {
      if (this.a != null)
      {
        this.a.a(null, null);
        this.a.a(null, paramInt1, paramInt2);
      }
      if (this.c == null)
      {
        this.c = new kw(paramObject, this.a);
        this.c.start();
      }
      AppMethodBeat.o(149006);
      return;
      if (this.c != null)
      {
        this.b = paramObject;
        this.c.a(paramObject);
      }
    }
  }
  
  public void a_()
  {
    AppMethodBeat.i(149001);
    if (this.c != null) {
      synchronized (this.c)
      {
        this.c.notify();
        AppMethodBeat.o(149001);
        return;
      }
    }
    AppMethodBeat.o(149001);
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(149008);
    if ((this.a != null) && (this.a.b(paramMotionEvent)))
    {
      AppMethodBeat.o(149008);
      return true;
    }
    boolean bool = super.dispatchHoverEvent(paramMotionEvent);
    AppMethodBeat.o(149008);
    return bool;
  }
  
  public void e()
  {
    AppMethodBeat.i(149002);
    if (this.a != null) {
      this.a.e();
    }
    if (this.c != null) {
      this.c.b();
    }
    AppMethodBeat.o(149002);
  }
  
  public void f()
  {
    AppMethodBeat.i(149003);
    if (this.a != null) {
      this.a.f();
    }
    if (this.c != null) {
      this.c.a();
    }
    AppMethodBeat.o(149003);
  }
  
  public void g()
  {
    AppMethodBeat.i(149004);
    if (this.a != null) {
      this.a.g();
    }
    if (this.c != null) {
      this.c.c();
    }
    AppMethodBeat.o(149004);
  }
  
  public ic getVectorMapDelegate()
  {
    return this.a;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(149005);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2);
    }
    AppMethodBeat.o(149005);
  }
  
  @TargetApi(16)
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148999);
    a(paramSurfaceTexture, paramInt1, paramInt2);
    AppMethodBeat.o(148999);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149000);
    if (this.a != null)
    {
      this.a.a(null, paramInt1, paramInt2);
      if (this.c != null) {
        this.c.d();
      }
    }
    AppMethodBeat.o(149000);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(149007);
    if (this.a != null)
    {
      boolean bool = this.a.a(paramMotionEvent);
      AppMethodBeat.o(149007);
      return bool;
    }
    AppMethodBeat.o(149007);
    return false;
  }
  
  public void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kv
 * JD-Core Version:    0.7.0.1
 */