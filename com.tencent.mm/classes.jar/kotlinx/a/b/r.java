package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/FloatArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([F)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class r
  extends av<float[]>
{
  float[] NMn;
  int position;
  
  public r(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(191151);
    this.NMn = paramArrayOfFloat;
    this.position = paramArrayOfFloat.length;
    ensureCapacity(10);
    AppMethodBeat.o(191151);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191149);
    if (this.NMn.length < paramInt)
    {
      float[] arrayOfFloat = Arrays.copyOf(this.NMn, h.lp(paramInt, this.NMn.length * 2));
      p.g(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
      this.NMn = arrayOfFloat;
    }
    AppMethodBeat.o(191149);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.r
 * JD-Core Version:    0.7.0.1
 */