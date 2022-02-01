package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/JsonDecodingException;", "Lkotlinx/serialization/json/JsonException;", "offset", "", "message", "", "(ILjava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class e
  extends k
{
  public e(int paramInt, String paramString)
  {
    super("Unexpected JSON token at offset " + paramInt + ": " + paramString);
    AppMethodBeat.i(225845);
    AppMethodBeat.o(225845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.e
 * JD-Core Version:    0.7.0.1
 */