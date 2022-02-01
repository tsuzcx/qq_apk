package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import kotlin.l.b.a.b.d.a.e.aa;
import kotlin.l.b.a.b.f.f;

public final class y
  extends n
  implements aa
{
  private final w aiNp;
  private final Annotation[] aiNq;
  private final String aiNr;
  private final boolean aiNs;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57517);
    this.aiNp = paramw;
    this.aiNq = paramArrayOfAnnotation;
    this.aiNr = paramString;
    this.aiNs = paramBoolean;
    AppMethodBeat.o(57517);
  }
  
  public final boolean klP()
  {
    return this.aiNs;
  }
  
  public final f kok()
  {
    AppMethodBeat.i(57515);
    Object localObject = this.aiNr;
    if (localObject == null)
    {
      AppMethodBeat.o(57515);
      return null;
    }
    localObject = f.bJh((String)localObject);
    AppMethodBeat.o(57515);
    return localObject;
  }
  
  public final boolean kqA()
  {
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57516);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.aiNs) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + kok() + ": " + this.aiNp;
      AppMethodBeat.o(57516);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.y
 * JD-Core Version:    0.7.0.1
 */