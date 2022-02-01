package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/channels/BufferOverflow;", "", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public enum g
{
  static
  {
    AppMethodBeat.i(189304);
    ajxx = new g("SUSPEND", 0);
    ajxy = new g("DROP_OLDEST", 1);
    ajxz = new g("DROP_LATEST", 2);
    ajxA = new g[] { ajxx, ajxy, ajxz };
    AppMethodBeat.o(189304);
  }
  
  private g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a.g
 * JD-Core Version:    0.7.0.1
 */