package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/ShortArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([S)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class bc
  extends av<short[]>
{
  short[] abCh;
  int position;
  
  public bc(short[] paramArrayOfShort)
  {
    AppMethodBeat.i(254297);
    this.abCh = paramArrayOfShort;
    this.position = paramArrayOfShort.length;
    ensureCapacity(10);
    AppMethodBeat.o(254297);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254295);
    if (this.abCh.length < paramInt)
    {
      short[] arrayOfShort = Arrays.copyOf(this.abCh, i.ov(paramInt, this.abCh.length * 2));
      p.j(arrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
      this.abCh = arrayOfShort;
    }
    AppMethodBeat.o(254295);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.bc
 * JD-Core Version:    0.7.0.1
 */