package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class k
{
  public static final byte[] EMPTY_BYTE_ARRAY;
  public static final ByteBuffer dSR;
  
  static
  {
    AppMethodBeat.i(59480);
    byte[] arrayOfByte = new byte[0];
    EMPTY_BYTE_ARRAY = arrayOfByte;
    dSR = ByteBuffer.wrap(arrayOfByte);
    AppMethodBeat.o(59480);
  }
  
  public static boolean F(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(59478);
    boolean bool = z.t(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(59478);
    return bool;
  }
  
  public static String G(byte[] paramArrayOfByte)
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
  
  public static abstract interface b<T extends k.a>
  {
    public abstract T aKJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.h.k
 * JD-Core Version:    0.7.0.1
 */