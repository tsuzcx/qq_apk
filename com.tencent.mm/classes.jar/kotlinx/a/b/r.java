package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/FloatArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([F)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class r
  extends av<float[]>
{
  float[] Ojt;
  int position;
  
  public r(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(199739);
    this.Ojt = paramArrayOfFloat;
    this.position = paramArrayOfFloat.length;
    ensureCapacity(10);
    AppMethodBeat.o(199739);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199737);
    if (this.Ojt.length < paramInt)
    {
      float[] arrayOfFloat = Arrays.copyOf(this.Ojt, j.lw(paramInt, this.Ojt.length * 2));
      p.g(arrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
      this.Ojt = arrayOfFloat;
    }
    AppMethodBeat.o(199737);
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