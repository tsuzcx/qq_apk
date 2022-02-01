package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import java.util.Arrays;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/CharArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([C)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class l
  extends av<char[]>
{
  char[] aZW;
  int position;
  
  public l(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(199829);
    this.aZW = paramArrayOfChar;
    this.position = paramArrayOfChar.length;
    ensureCapacity(10);
    AppMethodBeat.o(199829);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199827);
    if (this.aZW.length < paramInt)
    {
      char[] arrayOfChar = Arrays.copyOf(this.aZW, j.lw(paramInt, this.aZW.length * 2));
      p.g(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.aZW = arrayOfChar;
    }
    AppMethodBeat.o(199827);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.l
 * JD-Core Version:    0.7.0.1
 */