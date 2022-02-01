package d.l.b.a.b.h;

import java.io.OutputStream;

public abstract class a
  implements q
{
  protected int LzG = 0;
  
  public final void d(OutputStream paramOutputStream)
  {
    int i = 4096;
    int k = xS();
    int j = f.fM(k) + k;
    if (j > 4096) {}
    for (;;)
    {
      paramOutputStream = f.f(paramOutputStream, i);
      paramOutputStream.fL(k);
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
    
    public abstract BuilderType fVc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.a
 * JD-Core Version:    0.7.0.1
 */