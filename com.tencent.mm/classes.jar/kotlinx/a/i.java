package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "fieldName", "", "(Ljava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class i
  extends t
{
  public i(String paramString)
  {
    super("Field '" + paramString + "' is required, but it was missing", (byte)0);
    AppMethodBeat.i(200083);
    AppMethodBeat.o(200083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.i
 * JD-Core Version:    0.7.0.1
 */