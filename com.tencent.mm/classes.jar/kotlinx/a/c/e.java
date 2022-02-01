package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonDecodingException;", "Lkotlinx/serialization/json/JsonException;", "offset", "", "message", "", "(ILjava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class e
  extends k
{
  public e(int paramInt, String paramString)
  {
    super("Unexpected JSON token at offset " + paramInt + ": " + paramString);
    AppMethodBeat.i(191483);
    AppMethodBeat.o(191483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.e
 * JD-Core Version:    0.7.0.1
 */