package kotlinx.coroutines.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"arraycopy", "", "E", "source", "", "srcPos", "", "destination", "destinationStart", "length", "([Ljava/lang/Object;I[Ljava/lang/Object;II)V", "kotlinx-coroutines-core"})
public final class a
{
  public static final <E> void a(E[] paramArrayOfE1, int paramInt1, E[] paramArrayOfE2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(118384);
    j.q(paramArrayOfE1, "source");
    j.q(paramArrayOfE2, "destination");
    System.arraycopy(paramArrayOfE1, paramInt1, paramArrayOfE2, paramInt2, paramInt3);
    AppMethodBeat.o(118384);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a.a
 * JD-Core Version:    0.7.0.1
 */