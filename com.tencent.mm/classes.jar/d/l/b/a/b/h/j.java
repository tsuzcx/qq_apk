package d.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class j
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final ByteBuffer Nrp;
  
  static
  {
    AppMethodBeat.i(59480);
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    Nrp = ByteBuffer.wrap(arrayOfByte);
    AppMethodBeat.o(59480);
  }
  
  public static boolean dc(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59478);
    boolean bool = y.L(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(59478);
    return bool;
  }
  
  public static String dd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59479);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      AppMethodBeat.o(59479);
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte = new RuntimeException("UTF-8 not supported?", paramArrayOfByte);
      AppMethodBeat.o(59479);
      throw paramArrayOfByte;
    }
  }
  
  public static abstract interface a
  {
    public abstract int getNumber();
  }
  
  public static abstract interface b<T extends j.a>
  {
    public abstract T ajA(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.h.j
 * JD-Core Version:    0.7.0.1
 */