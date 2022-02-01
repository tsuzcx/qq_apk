package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import kotlin.l.b.a.b.f.f;

public final class y
  extends n
  implements kotlin.l.b.a.b.d.a.e.y
{
  private final w aaQq;
  private final Annotation[] aaQr;
  private final String aaQs;
  private final boolean aaQt;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57517);
    this.aaQq = paramw;
    this.aaQr = paramArrayOfAnnotation;
    this.aaQs = paramString;
    this.aaQt = paramBoolean;
    AppMethodBeat.o(57517);
  }
  
  public final f iEU()
  {
    AppMethodBeat.i(57515);
    Object localObject = this.aaQs;
    if (localObject != null)
    {
      localObject = f.bHe((String)localObject);
      AppMethodBeat.o(57515);
      return localObject;
    }
    AppMethodBeat.o(57515);
    return null;
  }
  
  public final boolean iHD()
  {
    return this.aaQt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57516);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.aaQt) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + iEU() + ": " + this.aaQq;
      AppMethodBeat.o(57516);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.y
 * JD-Core Version:    0.7.0.1
 */