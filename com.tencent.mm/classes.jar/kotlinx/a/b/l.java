package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.i;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/CharArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([C)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class l
  extends av<char[]>
{
  char[] aJp;
  int position;
  
  public l(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(254874);
    this.aJp = paramArrayOfChar;
    this.position = paramArrayOfChar.length;
    ensureCapacity(10);
    AppMethodBeat.o(254874);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254872);
    if (this.aJp.length < paramInt)
    {
      char[] arrayOfChar = Arrays.copyOf(this.aJp, i.ov(paramInt, this.aJp.length * 2));
      p.j(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.aJp = arrayOfChar;
    }
    AppMethodBeat.o(254872);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.l
 * JD-Core Version:    0.7.0.1
 */