package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class ow
{
  private pb a = null;
  private ah.p b = null;
  private Handler c = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 0))
      {
        if (ow.a(ow.this) != null)
        {
          paramAnonymousMessage = (Bitmap)paramAnonymousMessage.obj;
          ow.a(ow.this).a(paramAnonymousMessage);
        }
        ow.a(ow.this, null);
      }
    }
  };
  
  public ow(pb parampb)
  {
    this.a = parampb;
  }
  
  private void a(Handler paramHandler, Bitmap.Config paramConfig)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramHandler, paramConfig);
  }
  
  private boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public final int a(ac paramac)
  {
    if (this.a == null) {
      return -2147483648;
    }
    return this.a.a(paramac);
  }
  
  public final int a(ac paramac, long paramLong, ah.a parama)
  {
    if (this.a == null) {
      return -2147483648;
    }
    return this.a.a(paramac, paramLong, parama);
  }
  
  public String a(qc paramqc)
  {
    if (this.a != null) {
      return this.a.b(paramqc);
    }
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
    if (this.a == null) {
      return;
    }
    this.a.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public final void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramInt);
  }
  
  public final void a(ah.c paramc)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramc);
  }
  
  public final void a(ah.f paramf)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramf);
  }
  
  public final void a(ah.g paramg)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramg);
  }
  
  public final void a(ah.h paramh)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramh);
  }
  
  public void a(ah.i parami)
  {
    if (this.a != null) {
      this.a.a(parami);
    }
  }
  
  public final void a(ah.j paramj)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramj);
  }
  
  public final void a(ah.k paramk)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramk);
  }
  
  public final void a(ah.l paraml)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paraml);
  }
  
  public void a(ah.p paramp, Bitmap.Config paramConfig)
  {
    if ((this.a == null) || (paramp == null)) {
      return;
    }
    this.b = paramp;
    a(this.c, paramConfig);
  }
  
  public final void a(qn paramqn)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramqn);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (a(paramString2))) {
      return;
    }
    this.a.a(paramString1, paramString2);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramBoolean);
  }
  
  public pu b()
  {
    if (this.a == null) {
      return null;
    }
    return this.a.g();
  }
  
  public void b(int paramInt)
  {
    if (this.a != null) {
      this.a.b(paramInt);
    }
  }
  
  public final void b(qn paramqn)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramqn);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramBoolean);
  }
  
  public final float c()
  {
    if (this.a == null) {
      return -1.0F;
    }
    return this.a.h();
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
  }
  
  public final float d()
  {
    if (this.a == null) {
      return -1.0F;
    }
    return this.a.i();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.e(paramBoolean);
  }
  
  public final void e()
  {
    if (this.a == null) {
      return;
    }
    this.a.j();
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.a == null) {
      return;
    }
    this.a.f(paramBoolean);
  }
  
  public final boolean f()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.k();
  }
  
  public void g()
  {
    if (this.a == null) {
      return;
    }
    this.a.n();
  }
  
  public void h()
  {
    if (this.a == null) {
      return;
    }
    this.a.o();
  }
  
  public void i()
  {
    if (this.a == null) {
      return;
    }
    this.a.t();
  }
  
  public void j()
  {
    if (this.a == null) {
      return;
    }
    this.a.u();
  }
  
  public void k()
  {
    if (this.a == null) {
      return;
    }
    this.a.p();
  }
  
  public void l()
  {
    if (this.a == null) {
      return;
    }
    this.a.q();
  }
  
  public String m()
  {
    if (this.a == null) {
      return "";
    }
    return this.a.r();
  }
  
  public int n()
  {
    if (this.a != null) {
      return this.a.w();
    }
    return -1;
  }
  
  public String[] o()
  {
    if (this.a != null) {
      return this.a.x();
    }
    return null;
  }
  
  public boolean p()
  {
    if (this.a == null) {
      return false;
    }
    return this.a.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ow
 * JD-Core Version:    0.7.0.1
 */