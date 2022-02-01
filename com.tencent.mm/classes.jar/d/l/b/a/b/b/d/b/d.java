package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.f;
import java.lang.annotation.Annotation;

public abstract class d
  implements d.l.b.a.b.d.a.e.b
{
  public static final a Ljt = new a((byte)0);
  private final f Lgj;
  
  public d(f paramf)
  {
    this.Lgj = paramf;
  }
  
  public final f fRf()
  {
    return this.Lgj;
  }
  
  public static final class a
  {
    public static d a(Object paramObject, f paramf)
    {
      AppMethodBeat.i(57415);
      d.g.b.k.h(paramObject, "value");
      if (b.bw(paramObject.getClass()))
      {
        paramObject = (d)new o(paramf, (Enum)paramObject);
        AppMethodBeat.o(57415);
        return paramObject;
      }
      if ((paramObject instanceof Annotation))
      {
        paramObject = (d)new e(paramf, (Annotation)paramObject);
        AppMethodBeat.o(57415);
        return paramObject;
      }
      if ((paramObject instanceof Object[]))
      {
        paramObject = (d)new h(paramf, (Object[])paramObject);
        AppMethodBeat.o(57415);
        return paramObject;
      }
      if ((paramObject instanceof Class))
      {
        paramObject = (d)new k(paramf, (Class)paramObject);
        AppMethodBeat.o(57415);
        return paramObject;
      }
      paramObject = (d)new q(paramf, paramObject);
      AppMethodBeat.o(57415);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.d
 * JD-Core Version:    0.7.0.1
 */