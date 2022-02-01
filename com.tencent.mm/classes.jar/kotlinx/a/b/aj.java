package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/LongArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([J)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class aj
  extends av<long[]>
{
  long[] OjE;
  int position;
  
  public aj(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(199766);
    this.OjE = paramArrayOfLong;
    this.position = paramArrayOfLong.length;
    ensureCapacity(10);
    AppMethodBeat.o(199766);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199764);
    if (this.OjE.length < paramInt)
    {
      long[] arrayOfLong = Arrays.copyOf(this.OjE, j.lw(paramInt, this.OjE.length * 2));
      p.g(arrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
      this.OjE = arrayOfLong;
    }
    AppMethodBeat.o(199764);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.aj
 * JD-Core Version:    0.7.0.1
 */