package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/DoubleArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([D)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class o
  extends av<double[]>
{
  double[] TYm;
  int position;
  
  public o(double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(225575);
    this.TYm = paramArrayOfDouble;
    this.position = paramArrayOfDouble.length;
    ensureCapacity(10);
    AppMethodBeat.o(225575);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(225573);
    if (this.TYm.length < paramInt)
    {
      double[] arrayOfDouble = Arrays.copyOf(this.TYm, j.mZ(paramInt, this.TYm.length * 2));
      p.g(arrayOfDouble, "java.util.Arrays.copyOf(this, newSize)");
      this.TYm = arrayOfDouble;
    }
    AppMethodBeat.o(225573);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.o
 * JD-Core Version:    0.7.0.1
 */