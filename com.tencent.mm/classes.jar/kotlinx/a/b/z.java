package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/IntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([I)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class z
  extends av<int[]>
{
  int[] Ojw;
  int position;
  
  public z(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199788);
    this.Ojw = paramArrayOfInt;
    this.position = paramArrayOfInt.length;
    ensureCapacity(10);
    AppMethodBeat.o(199788);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199786);
    if (this.Ojw.length < paramInt)
    {
      int[] arrayOfInt = Arrays.copyOf(this.Ojw, j.lw(paramInt, this.Ojw.length * 2));
      p.g(arrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
      this.Ojw = arrayOfInt;
    }
    AppMethodBeat.o(199786);
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