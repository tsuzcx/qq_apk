package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.k.j;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/internal/ByteArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([B)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class i
  extends av<byte[]>
{
  byte[] buffer;
  int position;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(199735);
    this.buffer = paramArrayOfByte;
    this.position = paramArrayOfByte.length;
    ensureCapacity(10);
    AppMethodBeat.o(199735);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(199733);
    if (this.buffer.length < paramInt)
    {
      byte[] arrayOfByte = Arrays.copyOf(this.buffer, j.lw(paramInt, this.buffer.length * 2));
      p.g(arrayOfByte, "java.util.Arrays.copyOf(this, newSize)");
      this.buffer = arrayOfByte;
    }
    AppMethodBeat.o(199733);
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