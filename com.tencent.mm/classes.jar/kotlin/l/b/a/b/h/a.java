package kotlin.l.b.a.b.h;

import java.io.OutputStream;

public abstract class a
  implements r
{
  protected int bPa = 0;
  
  public final void d(OutputStream paramOutputStream)
  {
    int i = 4096;
    int k = Ad();
    int j = f.gR(k) + k;
    if (j > 4096) {}
    for (;;)
    {
      paramOutputStream = f.f(paramOutputStream, i);
      paramOutputStream.hT(k);
      a(paramOutputStream);
      paramOutputStream.flush();
      return;
      i = j;
    }
  }
  
  public static abstract class a<BuilderType extends a>
    implements r.a
  {
    public abstract BuilderType c(e parame, g paramg);
    
    public abstract BuilderType iIZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     kotlin.l.b.a.b.h.a
 * JD-Core Version:    0.7.0.1
 */