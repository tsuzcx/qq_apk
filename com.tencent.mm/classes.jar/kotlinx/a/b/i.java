package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.h;
import d.l;
import java.util.Arrays;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/internal/ByteArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([B)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class i
  extends av<byte[]>
{
  byte[] buffer;
  int position;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(191147);
    this.buffer = paramArrayOfByte;
    this.position = paramArrayOfByte.length;
    ensureCapacity(10);
    AppMethodBeat.o(191147);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(191145);
    if (this.buffer.length < paramInt)
    {
      byte[] arrayOfByte = Arrays.copyOf(this.buffer, h.lp(paramInt, this.buffer.length * 2));
      p.g(arrayOfByte, "java.util.Arrays.copyOf(this, newSize)");
      this.buffer = arrayOfByte;
    }
    AppMethodBeat.o(191145);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.b.i
 * JD-Core Version:    0.7.0.1
 */