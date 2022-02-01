package kotlinx.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/JsonDecodingException;", "Lkotlinx/serialization/json/JsonException;", "offset", "", "message", "", "(ILjava/lang/String;)V", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class d
  extends i
{
  public d(int paramInt, String paramString)
  {
    super("Unexpected JSON token at offset " + paramInt + ": " + paramString);
    AppMethodBeat.i(188472);
    AppMethodBeat.o(188472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.e.d
 * JD-Core Version:    0.7.0.1
 */