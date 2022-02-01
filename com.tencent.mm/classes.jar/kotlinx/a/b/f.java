package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/BooleanArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([Z)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class f
  extends av<boolean[]>
{
  boolean[] TYf;
  int position;
  
  public f(boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(225530);
    this.TYf = paramArrayOfBoolean;
    this.position = paramArrayOfBoolean.length;
    ensureCapacity(10);
    AppMethodBeat.o(225530);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(225528);
    if (this.TYf.length < paramInt)
    {
      boolean[] arrayOfBoolean = Arrays.copyOf(this.TYf, j.mZ(paramInt, this.TYf.length * 2));
      p.g(arrayOfBoolean, "java.util.Arrays.copyOf(this, newSize)");
      this.TYf = arrayOfBoolean;
    }
    AppMethodBeat.o(225528);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.f
 * JD-Core Version:    0.7.0.1
 */