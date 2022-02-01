package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/CharArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([C)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class l
  extends av<char[]>
{
  char[] aZS;
  int position;
  
  public l(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(225601);
    this.aZS = paramArrayOfChar;
    this.position = paramArrayOfChar.length;
    ensureCapacity(10);
    AppMethodBeat.o(225601);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(225599);
    if (this.aZS.length < paramInt)
    {
      char[] arrayOfChar = Arrays.copyOf(this.aZS, j.mZ(paramInt, this.aZS.length * 2));
      p.g(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.aZS = arrayOfChar;
    }
    AppMethodBeat.o(225599);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.l
 * JD-Core Version:    0.7.0.1
 */