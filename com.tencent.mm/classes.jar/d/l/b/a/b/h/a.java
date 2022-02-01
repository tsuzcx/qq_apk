package d.l.b.a.b.h;

import java.io.OutputStream;

public abstract class a
  implements q
{
  protected int NNJ = 0;
  
  public final void d(OutputStream paramOutputStream)
  {
    int i = 4096;
    int k = zp();
    int j = f.fP(k) + k;
    if (j > 4096) {}
    for (;;)
    {
      paramOutputStream = f.f(paramOutputStream, i);
      paramOutputStream.fO(k);
      a(paramOutputStream);
      paramOutputStream.flush();
      return;
      i = j;
    }
  }
  
  public static abstract class a<BuilderType extends a>
    implements q.a
  {
    public abstract BuilderType c(e parame, g paramg);
    
    public abstract BuilderType grd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     d.l.b.a.b.h.a
 * JD-Core Version:    0.7.0.1
 */