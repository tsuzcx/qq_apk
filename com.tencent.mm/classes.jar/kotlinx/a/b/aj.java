package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/LongArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([J)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class aj
  extends av<long[]>
{
  long[] NMy;
  int position;
  
  public aj(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(191178);
    this.NMy = paramArrayOfLong;
    this.position = paramArrayOfLong.length;
    ensureCapacity(10);
    AppMethodBeat.o(191178);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191176);
    if (this.NMy.length < paramInt)
    {
      long[] arrayOfLong = Arrays.copyOf(this.NMy, h.lp(paramInt, this.NMy.length * 2));
      p.g(arrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
      this.NMy = arrayOfLong;
    }
    AppMethodBeat.o(191176);
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