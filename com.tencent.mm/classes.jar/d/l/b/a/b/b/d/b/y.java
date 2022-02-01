package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.f;
import java.lang.annotation.Annotation;

public final class y
  extends n
  implements d.l.b.a.b.d.a.e.y
{
  private final w NaI;
  private final Annotation[] NaJ;
  private final String NaK;
  private final boolean NaL;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57517);
    this.NaI = paramw;
    this.NaJ = paramArrayOfAnnotation;
    this.NaK = paramString;
    this.NaL = paramBoolean;
    AppMethodBeat.o(57517);
  }
  
  public final f giD()
  {
    AppMethodBeat.i(57515);
    Object localObject = this.NaK;
    if (localObject != null)
    {
      localObject = f.bcH((String)localObject);
      AppMethodBeat.o(57515);
      return localObject;
    }
    AppMethodBeat.o(57515);
    return null;
  }
  
  public final boolean glf()
  {
    return this.NaL;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57516);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.NaL) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + giD() + ": " + this.NaI;
      AppMethodBeat.o(57516);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.y
 * JD-Core Version:    0.7.0.1
 */