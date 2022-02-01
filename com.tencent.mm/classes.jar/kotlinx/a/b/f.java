package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/BooleanArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([Z)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class f
  extends av<boolean[]>
{
  boolean[] abBu;
  int position;
  
  public f(boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(254580);
    this.abBu = paramArrayOfBoolean;
    this.position = paramArrayOfBoolean.length;
    ensureCapacity(10);
    AppMethodBeat.o(254580);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254577);
    if (this.abBu.length < paramInt)
    {
      boolean[] arrayOfBoolean = Arrays.copyOf(this.abBu, i.ov(paramInt, this.abBu.length * 2));
      p.j(arrayOfBoolean, "java.util.Arrays.copyOf(this, newSize)");
      this.abBu = arrayOfBoolean;
    }
    AppMethodBeat.o(254577);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.f
 * JD-Core Version:    0.7.0.1
 */