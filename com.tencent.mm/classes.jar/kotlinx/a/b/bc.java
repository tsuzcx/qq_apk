package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/ShortArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([S)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class bc
  extends av<short[]>
{
  short[] NMR;
  int position;
  
  public bc(short[] paramArrayOfShort)
  {
    AppMethodBeat.i(191061);
    this.NMR = paramArrayOfShort;
    this.position = paramArrayOfShort.length;
    ensureCapacity(10);
    AppMethodBeat.o(191061);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191059);
    if (this.NMR.length < paramInt)
    {
      short[] arrayOfShort = Arrays.copyOf(this.NMR, h.lp(paramInt, this.NMR.length * 2));
      p.g(arrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
      this.NMR = arrayOfShort;
    }
    AppMethodBeat.o(191059);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.bc
 * JD-Core Version:    0.7.0.1
 */