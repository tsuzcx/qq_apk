package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.concurrent.Callable;

public abstract class b<T>
  extends a<T>
{
  final File b;
  final long c;
  j d;
  
  public b(File paramFile)
  {
    this.b = paramFile;
    this.c = 10000L;
  }
  
  private void d()
  {
    if (this.d != null) {
      this.d.a();
    }
  }
  
  protected final void a()
  {
    m.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(173894);
        try
        {
          b localb = b.this;
          File localFile = b.this.b;
          Callable local1 = new Callable() {};
          long l = b.this.c;
          localb.d = ((j)j.a(new j.1(local1, localFile), localFile, l));
          b.this.c();
          AppMethodBeat.o(173894);
          return;
        }
        catch (Exception localException)
        {
          b.this.a(localException);
          AppMethodBeat.o(173894);
        }
      }
    });
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    d();
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public abstract void a(Exception paramException);
  
  public void a(T paramT)
  {
    d();
    super.a(paramT);
  }
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.b
 * JD-Core Version:    0.7.0.1
 */