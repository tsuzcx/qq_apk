package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([I)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class z
  extends av<int[]>
{
  int[] bZS;
  int position;
  
  public z(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(254681);
    this.bZS = paramArrayOfInt;
    this.position = paramArrayOfInt.length;
    ensureCapacity(10);
    AppMethodBeat.o(254681);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254677);
    if (this.bZS.length < paramInt)
    {
      int[] arrayOfInt = Arrays.copyOf(this.bZS, i.ov(paramInt, this.bZS.length * 2));
      p.j(arrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
      this.bZS = arrayOfInt;
    }
    AppMethodBeat.o(254677);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.z
 * JD-Core Version:    0.7.0.1
 */