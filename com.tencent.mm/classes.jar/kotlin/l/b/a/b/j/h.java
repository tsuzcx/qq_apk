package kotlin.l.b.a.b.j;

import kotlin.g.b.s;
import kotlin.l.b.a.b.b.b;

public abstract class h
  extends i
{
  protected abstract void a(b paramb1, b paramb2);
  
  public final void b(b paramb1, b paramb2)
  {
    s.u(paramb1, "fromSuper");
    s.u(paramb2, "fromCurrent");
    a(paramb1, paramb2);
  }
  
  public final void c(b paramb1, b paramb2)
  {
    s.u(paramb1, "first");
    s.u(paramb2, "second");
    a(paramb1, paramb2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.h
 * JD-Core Version:    0.7.0.1
 */