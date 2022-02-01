package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonDecodingException;", "Lkotlinx/serialization/json/JsonException;", "offset", "", "message", "", "(ILjava/lang/String;)V", "kotlinx-serialization-runtime"})
public final class e
  extends k
{
  public e(int paramInt, String paramString)
  {
    super("Unexpected JSON token at offset " + paramInt + ": " + paramString);
    AppMethodBeat.i(257036);
    AppMethodBeat.o(257036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.c.e
 * JD-Core Version:    0.7.0.1
 */