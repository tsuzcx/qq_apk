package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/LongArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([J)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class aj
  extends av<long[]>
{
  long[] TYz;
  int position;
  
  public aj(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(225538);
    this.TYz = paramArrayOfLong;
    this.position = paramArrayOfLong.length;
    ensureCapacity(10);
    AppMethodBeat.o(225538);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(225536);
    if (this.TYz.length < paramInt)
    {
      long[] arrayOfLong = Arrays.copyOf(this.TYz, j.mZ(paramInt, this.TYz.length * 2));
      p.g(arrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
      this.TYz = arrayOfLong;
    }
    AppMethodBeat.o(225536);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.aj
 * JD-Core Version:    0.7.0.1
 */