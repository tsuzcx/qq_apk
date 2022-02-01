package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/DoubleArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([D)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class o
  extends av<double[]>
{
  double[] NMk;
  int position;
  
  public o(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(191215);
    this.NMk = paramArrayOfDouble;
    this.position = paramArrayOfDouble.length;
    ensureCapacity(10);
    AppMethodBeat.o(191215);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191213);
    if (this.NMk.length < paramInt)
    {
      double[] arrayOfDouble = Arrays.copyOf(this.NMk, h.lp(paramInt, this.NMk.length * 2));
      p.g(arrayOfDouble, "java.util.Arrays.copyOf(this, newSize)");
      this.NMk = arrayOfDouble;
    }
    AppMethodBeat.o(191213);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.o
 * JD-Core Version:    0.7.0.1
 */