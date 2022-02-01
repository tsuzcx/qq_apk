package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.f;
import java.lang.annotation.Annotation;

public final class y
  extends n
  implements d.l.b.a.b.d.a.e.y
{
  private final w Jwt;
  private final Annotation[] Jwu;
  private final String Jwv;
  private final boolean Jww;
  
  public y(w paramw, Annotation[] paramArrayOfAnnotation, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57517);
    this.Jwt = paramw;
    this.Jwu = paramArrayOfAnnotation;
    this.Jwv = paramString;
    this.Jww = paramBoolean;
    AppMethodBeat.o(57517);
  }
  
  public final boolean fBc()
  {
    return this.Jww;
  }
  
  public final f fyB()
  {
    AppMethodBeat.i(57515);
    Object localObject = this.Jwv;
    if (localObject != null)
    {
      localObject = f.aQF((String)localObject);
      AppMethodBeat.o(57515);
      return localObject;
    }
    AppMethodBeat.o(57515);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57516);
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getName()).append(": ");
    if (this.Jww) {}
    for (String str = "vararg ";; str = "")
    {
      str = str + fyB() + ": " + this.Jwt;
      AppMethodBeat.o(57516);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.y
 * JD-Core Version:    0.7.0.1
 */