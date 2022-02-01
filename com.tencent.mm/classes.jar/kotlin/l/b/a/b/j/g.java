package kotlin.l.b.a.b.j;

import kotlin.g.b.p;
import kotlin.l.b.a.b.b.b;

public abstract class g
  extends h
{
  protected abstract void a(b paramb1, b paramb2);
  
  public final void b(b paramb1, b paramb2)
  {
    p.k(paramb1, "fromSuper");
    p.k(paramb2, "fromCurrent");
    a(paramb1, paramb2);
  }
  
  public final void c(b paramb1, b paramb2)
  {
    p.k(paramb1, "first");
    p.k(paramb2, "second");
    a(paramb1, paramb2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g
 * JD-Core Version:    0.7.0.1
 */