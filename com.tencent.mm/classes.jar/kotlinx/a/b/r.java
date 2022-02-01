package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/FloatArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([F)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class r
  extends av<float[]>
{
  float[] abBE;
  int position;
  
  public r(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(254529);
    this.abBE = paramArrayOfFloat;
    this.position = paramArrayOfFloat.length;
    ensureCapacity(10);
    AppMethodBeat.o(254529);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254525);
    if (this.abBE.length < paramInt)
    {
      float[] arrayOfFloat = Arrays.copyOf(this.abBE, i.ov(paramInt, this.abBE.length * 2));
      p.j(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
      this.abBE = arrayOfFloat;
    }
    AppMethodBeat.o(254525);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.r
 * JD-Core Version:    0.7.0.1
 */