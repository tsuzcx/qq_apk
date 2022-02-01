package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import kotlin.l.b.a.b.f.f;

public final class y
  extends n
  implements kotlin.l.b.a.b.d.a.e.y
{
  private final w Tnw;
  private final Annotation[] Tnx;
  private final String Tny;
  private final boolean Tnz;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57517);
    this.Tnw = paramw;
    this.Tnx = paramArrayOfAnnotation;
    this.Tny = paramString;
    this.Tnz = paramBoolean;
    AppMethodBeat.o(57517);
  }
  
  public final f hAH()
  {
    AppMethodBeat.i(57515);
    Object localObject = this.Tny;
    if (localObject != null)
    {
      localObject = f.bub((String)localObject);
      AppMethodBeat.o(57515);
      return localObject;
    }
    AppMethodBeat.o(57515);
    return null;
  }
  
  public final boolean hDj()
  {
    return this.Tnz;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57516);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.Tnz) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + hAH() + ": " + this.Tnw;
      AppMethodBeat.o(57516);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.y
 * JD-Core Version:    0.7.0.1
 */