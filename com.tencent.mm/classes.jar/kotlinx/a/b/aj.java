package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/LongArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([J)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class aj
  extends av<long[]>
{
  long[] abBO;
  int position;
  
  public aj(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(254614);
    this.abBO = paramArrayOfLong;
    this.position = paramArrayOfLong.length;
    ensureCapacity(10);
    AppMethodBeat.o(254614);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254609);
    if (this.abBO.length < paramInt)
    {
      long[] arrayOfLong = Arrays.copyOf(this.abBO, i.ov(paramInt, this.abBO.length * 2));
      p.j(arrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
      this.abBO = arrayOfLong;
    }
    AppMethodBeat.o(254609);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.aj
 * JD-Core Version:    0.7.0.1
 */