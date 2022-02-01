package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/MissingFieldException;", "Lkotlinx/serialization/SerializationException;", "fieldName", "", "(Ljava/lang/String;)V", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class c
  extends f
{
  public c(String paramString)
  {
    super("Field '" + paramString + "' is required, but it was missing");
    AppMethodBeat.i(188407);
    AppMethodBeat.o(188407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlinx.a.c
 * JD-Core Version:    0.7.0.1
 */