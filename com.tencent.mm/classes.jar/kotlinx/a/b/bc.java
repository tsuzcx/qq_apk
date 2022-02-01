package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/ShortArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([S)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class bc
  extends av<short[]>
{
  short[] OjX;
  int position;
  
  public bc(short[] paramArrayOfShort)
  {
    AppMethodBeat.i(199649);
    this.OjX = paramArrayOfShort;
    this.position = paramArrayOfShort.length;
    ensureCapacity(10);
    AppMethodBeat.o(199649);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199647);
    if (this.OjX.length < paramInt)
    {
      short[] arrayOfShort = Arrays.copyOf(this.OjX, j.lw(paramInt, this.OjX.length * 2));
      p.g(arrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
      this.OjX = arrayOfShort;
    }
    AppMethodBeat.o(199647);
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