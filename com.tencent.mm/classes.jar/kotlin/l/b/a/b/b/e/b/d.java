package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import kotlin.g.b.s;
import kotlin.l.b.a.b.f.f;

public abstract class d
  implements kotlin.l.b.a.b.d.a.e.b
{
  public static final a aiMU = new a((byte)0);
  private final f aiJy;
  
  private d(f paramf)
  {
    this.aiJy = paramf;
  }
  
  public final f kok()
  {
    return this.aiJy;
  }
  
  public static final class a
  {
    public static d a(Object paramObject, f paramf)
    {
      AppMethodBeat.i(57415);
      s.u(paramObject, "value");
      if (b.cJ(paramObject.getClass()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.d
 * JD-Core Version:    0.7.0.1
 */