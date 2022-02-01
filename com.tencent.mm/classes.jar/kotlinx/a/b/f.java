package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/BooleanArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([Z)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class f
  extends av<boolean[]>
{
  boolean[] NMd;
  int position;
  
  public f(boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(191170);
    this.NMd = paramArrayOfBoolean;
    this.position = paramArrayOfBoolean.length;
    ensureCapacity(10);
    AppMethodBeat.o(191170);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191168);
    if (this.NMd.length < paramInt)
    {
      boolean[] arrayOfBoolean = Arrays.copyOf(this.NMd, h.lp(paramInt, this.NMd.length * 2));
      p.g(arrayOfBoolean, "java.util.Arrays.copyOf(this, newSize)");
      this.NMd = arrayOfBoolean;
    }
    AppMethodBeat.o(191168);
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