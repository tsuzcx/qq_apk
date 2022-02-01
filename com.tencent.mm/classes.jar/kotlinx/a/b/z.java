package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([I)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class z
  extends av<int[]>
{
  int[] NMq;
  int position;
  
  public z(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191200);
    this.NMq = paramArrayOfInt;
    this.position = paramArrayOfInt.length;
    ensureCapacity(10);
    AppMethodBeat.o(191200);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191198);
    if (this.NMq.length < paramInt)
    {
      int[] arrayOfInt = Arrays.copyOf(this.NMq, h.lp(paramInt, this.NMq.length * 2));
      p.g(arrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
      this.NMq = arrayOfInt;
    }
    AppMethodBeat.o(191198);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.z
 * JD-Core Version:    0.7.0.1
 */