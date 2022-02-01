package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.f;
import java.lang.annotation.Annotation;

public final class y
  extends n
  implements d.l.b.a.b.d.a.e.y
{
  private final w NxO;
  private final Annotation[] NxP;
  private final String NxQ;
  private final boolean NxR;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57517);
    this.NxO = paramw;
    this.NxP = paramArrayOfAnnotation;
    this.NxQ = paramString;
    this.NxR = paramBoolean;
    AppMethodBeat.o(57517);
  }
  
  public final f gnf()
  {
    AppMethodBeat.i(57515);
    Object localObject = this.NxQ;
    if (localObject != null)
    {
      localObject = f.bel((String)localObject);
      AppMethodBeat.o(57515);
      return localObject;
    }
    AppMethodBeat.o(57515);
    return null;
  }
  
  public final boolean gpH()
  {
    return this.NxR;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57516);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.NxR) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + gnf() + ": " + this.NxO;
      AppMethodBeat.o(57516);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.y
 * JD-Core Version:    0.7.0.1
 */