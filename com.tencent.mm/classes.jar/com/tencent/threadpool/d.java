package com.tencent.threadpool;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public static e ahAo;
  public static f ahAp;
  public static a ahAq;
  
  static
  {
    AppMethodBeat.i(183137);
    ahAo = new c((byte)0);
    ahAp = new d((byte)0);
    ahAq = new d.b((byte)0);
    AppMethodBeat.o(183137);
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
    
    public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
  }
  
  static final class c
    implements d.e
  {
    public final void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2) {}
    
    public final void a(String paramString1, int paramInt, f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean) {}
    
    public final void a(String paramString, int paramInt, Throwable paramThrowable) {}
    
    public final void h(String paramString1, int paramInt, String paramString2) {}
    
    public final void shutdown() {}
  }
  
  static final class d
    implements d.f
  {
    public final void a(Thread paramThread, String paramString, long paramLong) {}
    
    public final void b(Thread paramThread, String paramString, long paramLong) {}
    
    public final void c(Thread paramThread, String paramString, long paramLong) {}
  }
  
  public static abstract interface e
  {
    public abstract void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2);
    
    public abstract void a(String paramString1, int paramInt, f paramf, long paramLong1, long paramLong2, String paramString2, boolean paramBoolean);
    
    public abstract void a(String paramString, int paramInt, Throwable paramThrowable);
    
    public abstract void h(String paramString1, int paramInt, String paramString2);
    
    public abstract void shutdown();
  }
  
  public static abstract interface f
  {
    public abstract void a(Thread paramThread, String paramString, long paramLong);
    
    public abstract void b(Thread paramThread, String paramString, long paramLong);
    
    public abstract void c(Thread paramThread, String paramString, long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.d
 * JD-Core Version:    0.7.0.1
 */