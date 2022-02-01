package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/DoubleArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([D)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class o
  extends av<double[]>
{
  double[] abBB;
  int position;
  
  public o(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(254762);
    this.abBB = paramArrayOfDouble;
    this.position = paramArrayOfDouble.length;
    ensureCapacity(10);
    AppMethodBeat.o(254762);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254758);
    if (this.abBB.length < paramInt)
    {
      double[] arrayOfDouble = Arrays.copyOf(this.abBB, i.ov(paramInt, this.abBB.length * 2));
      p.j(arrayOfDouble, "java.util.Arrays.copyOf(this, newSize)");
      this.abBB = arrayOfDouble;
    }
    AppMethodBeat.o(254758);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.o
 * JD-Core Version:    0.7.0.1
 */