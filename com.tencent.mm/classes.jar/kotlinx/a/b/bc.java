package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/internal/ShortArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([S)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class bc
  extends av<short[]>
{
  short[] TYS;
  int position;
  
  public bc(short[] paramArrayOfShort)
  {
    AppMethodBeat.i(225421);
    this.TYS = paramArrayOfShort;
    this.position = paramArrayOfShort.length;
    ensureCapacity(10);
    AppMethodBeat.o(225421);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(225419);
    if (this.TYS.length < paramInt)
    {
      short[] arrayOfShort = Arrays.copyOf(this.TYS, j.mZ(paramInt, this.TYS.length * 2));
      p.g(arrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
      this.TYS = arrayOfShort;
    }
    AppMethodBeat.o(225419);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.b.bc
 * JD-Core Version:    0.7.0.1
 */