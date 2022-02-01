package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import java.util.Arrays;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/CharArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([C)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class l
  extends av<char[]>
{
  char[] aZW;
  int position;
  
  public l(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(191241);
    this.aZW = paramArrayOfChar;
    this.position = paramArrayOfChar.length;
    ensureCapacity(10);
    AppMethodBeat.o(191241);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191239);
    if (this.aZW.length < paramInt)
    {
      char[] arrayOfChar = Arrays.copyOf(this.aZW, h.lp(paramInt, this.aZW.length * 2));
      p.g(arrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
      this.aZW = arrayOfChar;
    }
    AppMethodBeat.o(191239);
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