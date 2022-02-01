package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([I)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class z
  extends av<int[]>
{
  int[] bYo;
  int position;
  
  public z(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(225560);
    this.bYo = paramArrayOfInt;
    this.position = paramArrayOfInt.length;
    ensureCapacity(10);
    AppMethodBeat.o(225560);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(225558);
    if (this.bYo.length < paramInt)
    {
      int[] arrayOfInt = Arrays.copyOf(this.bYo, j.mZ(paramInt, this.bYo.length * 2));
      p.g(arrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
      this.bYo = arrayOfInt;
    }
    AppMethodBeat.o(225558);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.z
 * JD-Core Version:    0.7.0.1
 */