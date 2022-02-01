package kotlinx.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/internal/ByteArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "", "bufferWithData", "([B)V", "buffer", "<set-?>", "", "position", "getPosition", "()I", "append", "", "c", "", "append$kotlinx_serialization_runtime", "build", "ensureCapacity", "requiredCapacity", "kotlinx-serialization-runtime"})
public final class i
  extends av<byte[]>
{
  byte[] buffer;
  int position;
  
  public i(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(254517);
    this.buffer = paramArrayOfByte;
    this.position = paramArrayOfByte.length;
    ensureCapacity(10);
    AppMethodBeat.o(254517);
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(254515);
    if (this.buffer.length < paramInt)
    {
      byte[] arrayOfByte = Arrays.copyOf(this.buffer, kotlin.k.i.ov(paramInt, this.buffer.length * 2));
      p.j(arrayOfByte, "java.util.Arrays.copyOf(this, newSize)");
      this.buffer = arrayOfByte;
    }
    AppMethodBeat.o(254515);
  }
  
  public final int getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.b.i
 * JD-Core Version:    0.7.0.1
 */