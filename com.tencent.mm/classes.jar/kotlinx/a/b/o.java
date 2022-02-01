package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/DoubleArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([D)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class o
  extends av<double[]>
{
  double[] Ojq;
  int position;
  
  public o(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(199803);
    this.Ojq = paramArrayOfDouble;
    this.position = paramArrayOfDouble.length;
    ensureCapacity(10);
    AppMethodBeat.o(199803);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199801);
    if (this.Ojq.length < paramInt)
    {
      double[] arrayOfDouble = Arrays.copyOf(this.Ojq, j.lw(paramInt, this.Ojq.length * 2));
      p.g(arrayOfDouble, "java.util.Arrays.copyOf(this, newSize)");
      this.Ojq = arrayOfDouble;
    }
    AppMethodBeat.o(199801);
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