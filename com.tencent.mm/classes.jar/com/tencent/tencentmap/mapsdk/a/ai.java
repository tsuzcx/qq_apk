package com.tencent.tencentmap.mapsdk.a;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ai
{
  private String a;
  private String b;
  private boolean c = false;
  private Object d;
  private int e;
  private int f;
  private String g;
  private String h;
  private boolean i = false;
  
  public final ai a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public final void a(Object paramObject)
  {
    AppMethodBeat.i(147169);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder)))
    {
      paramObject = new IllegalArgumentException("Parameter Surface should be Surface,SurfaceTexture or SurfaceHolder");
      AppMethodBeat.o(147169);
      throw paramObject;
    }
    this.d = paramObject;
    AppMethodBeat.o(147169);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147170);
    if (paramString1 != null) {}
    for (this.h = paramString1.trim(); paramString2 != null; this.h = "")
    {
      this.g = paramString2.trim();
      AppMethodBeat.o(147170);
      return;
    }
    this.g = "";
    AppMethodBeat.o(147170);
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final Object d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public final int f()
  {
    return this.f;
  }
  
  public final String g()
  {
    return this.g;
  }
  
  public final String h()
  {
    return this.h;
  }
  
  public final boolean i()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ai
 * JD-Core Version:    0.7.0.1
 */