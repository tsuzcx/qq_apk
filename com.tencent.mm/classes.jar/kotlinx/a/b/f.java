package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/BooleanArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([Z)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class f
  extends av<boolean[]>
{
  boolean[] Ojj;
  int position;
  
  public f(boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(199758);
    this.Ojj = paramArrayOfBoolean;
    this.position = paramArrayOfBoolean.length;
    ensureCapacity(10);
    AppMethodBeat.o(199758);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199756);
    if (this.Ojj.length < paramInt)
    {
      boolean[] arrayOfBoolean = Arrays.copyOf(this.Ojj, j.lw(paramInt, this.Ojj.length * 2));
      p.g(arrayOfBoolean, "java.util.Arrays.copyOf(this, newSize)");
      this.Ojj = arrayOfBoolean;
    }
    AppMethodBeat.o(199756);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.f
 * JD-Core Version:    0.7.0.1
 */