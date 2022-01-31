package com.tencent.tencentmap.mapsdk.maps.a;

public abstract class nx<T>
  implements nv<T>, ny
{
  private final of a;
  private final nx<?> b;
  private nw c;
  private long d = -9223372036854775808L;
  
  protected nx()
  {
    this(null, false);
  }
  
  protected nx(nx<?> paramnx)
  {
    this(paramnx, true);
  }
  
  protected nx(nx<?> paramnx, boolean paramBoolean)
  {
    this.b = paramnx;
    if ((paramBoolean) && (paramnx != null)) {}
    for (paramnx = paramnx.a;; paramnx = new of())
    {
      this.a = paramnx;
      return;
    }
  }
  
  public void a(nw paramnw)
  {
    int j = 0;
    long l;
    try
    {
      l = this.d;
      this.c = paramnw;
      int i = j;
      if (this.b != null)
      {
        i = j;
        if (l == -9223372036854775808L) {
          i = 1;
        }
      }
      if (i != 0)
      {
        this.b.a(this.c);
        return;
      }
    }
    finally {}
    if (l == -9223372036854775808L)
    {
      this.c.a(9223372036854775807L);
      return;
    }
    this.c.a(l);
  }
  
  public final void b()
  {
    this.a.b();
  }
  
  public final boolean c()
  {
    return this.a.a();
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nx
 * JD-Core Version:    0.7.0.1
 */