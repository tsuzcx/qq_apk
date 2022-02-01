package kotlin.l.b.a.b.h;

import java.io.OutputStream;

public abstract class a
  implements q
{
  protected int bNb = 0;
  
  public final void d(OutputStream paramOutputStream)
  {
    int i = 4096;
    int k = yC();
    int j = f.fY(k) + k;
    if (j > 4096) {}
    for (;;)
    {
      paramOutputStream = f.f(paramOutputStream, i);
      paramOutputStream.hc(k);
      a(paramOutputStream);
      paramOutputStream.flush();
      return;
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.h.a
 * JD-Core Version:    0.7.0.1
 */