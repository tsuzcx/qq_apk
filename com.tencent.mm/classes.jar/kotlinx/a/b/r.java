package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/FloatArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([F)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class r
  extends av<float[]>
{
  float[] TYp;
  int position;
  
  public r(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(225511);
    this.TYp = paramArrayOfFloat;
    this.position = paramArrayOfFloat.length;
    ensureCapacity(10);
    AppMethodBeat.o(225511);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(225509);
    if (this.TYp.length < paramInt)
    {
      float[] arrayOfFloat = Arrays.copyOf(this.TYp, j.mZ(paramInt, this.TYp.length * 2));
      p.g(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
      this.TYp = arrayOfFloat;
    }
    AppMethodBeat.o(225509);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.r
 * JD-Core Version:    0.7.0.1
 */