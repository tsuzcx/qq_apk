package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.f;
import java.lang.annotation.Annotation;

public final class y
  extends n
  implements d.l.b.a.b.d.a.e.y
{
  private final w LjM;
  private final Annotation[] LjN;
  private final String LjO;
  private final boolean LjP;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57517);
    this.LjM = paramw;
    this.LjN = paramArrayOfAnnotation;
    this.LjO = paramString;
    this.LjP = paramBoolean;
    AppMethodBeat.o(57517);
  }
  
  public final f fRf()
  {
    AppMethodBeat.i(57515);
    Object localObject = this.LjO;
    if (localObject != null)
    {
      localObject = f.aWE((String)localObject);
      AppMethodBeat.o(57515);
      return localObject;
    }
    AppMethodBeat.o(57515);
    return null;
  }
  
  public final boolean fTG()
  {
    return this.LjP;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57516);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.LjP) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + fRf() + ": " + this.LjM;
      AppMethodBeat.o(57516);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.y
 * JD-Core Version:    0.7.0.1
 */