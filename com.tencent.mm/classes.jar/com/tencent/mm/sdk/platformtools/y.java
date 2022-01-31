package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class y
{
  private ByteBuffer byteBuffer;
  private boolean yng;
  
  private int Nc(int paramInt)
  {
    AppMethodBeat.i(52027);
    if (this.byteBuffer.limit() - this.byteBuffer.position() > paramInt)
    {
      AppMethodBeat.o(52027);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(this.byteBuffer.limit() + 4096);
    localByteBuffer.put(this.byteBuffer.array(), 0, this.byteBuffer.position());
    this.byteBuffer = localByteBuffer;
    AppMethodBeat.o(52027);
    return 0;
  }
  
  private static int bZ(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      i = -1;
    }
    do
    {
      return i;
      if (paramArrayOfByte[0] != 123) {
        return -2;
      }
    } while (paramArrayOfByte[(paramArrayOfByte.length - 1)] == 125);
    return -3;
  }
  
  public final void Nb(int paramInt)
  {
    AppMethodBeat.i(52023);
    ByteBuffer localByteBuffer = this.byteBuffer;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
    AppMethodBeat.o(52023);
  }
  
  public final int Nd(int paramInt)
  {
    AppMethodBeat.i(52028);
    if (!this.yng)
    {
      Exception localException = new Exception("Buffer For Parse");
      AppMethodBeat.o(52028);
      throw localException;
    }
    Nc(4);
    this.byteBuffer.putInt(paramInt);
    AppMethodBeat.o(52028);
    return 0;
  }
  
  public final int ape(String paramString)
  {
    AppMethodBeat.i(52031);
    if (!this.yng)
    {
      paramString = new Exception("Buffer For Parse");
      AppMethodBeat.o(52031);
      throw paramString;
    }
    byte[] arrayOfByte = null;
    if (paramString != null) {
      arrayOfByte = paramString.getBytes();
    }
    paramString = arrayOfByte;
    if (arrayOfByte == null) {
      paramString = new byte[0];
    }
    if (paramString.length > 3072)
    {
      paramString = new Exception("Buffer String Length Error");
      AppMethodBeat.o(52031);
      throw paramString;
    }
    Nc(paramString.length + 2);
    this.byteBuffer.putShort((short)paramString.length);
    if (paramString.length > 0) {
      this.byteBuffer.put(paramString);
    }
    AppMethodBeat.o(52031);
    return 0;
  }
  
  public final int ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52018);
    if (bZ(paramArrayOfByte) != 0)
    {
      this.byteBuffer = null;
      AppMethodBeat.o(52018);
      return -1;
    }
    this.byteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    this.byteBuffer.position(1);
    this.yng = false;
    AppMethodBeat.o(52018);
    return 0;
  }
  
  public final int cb(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52030);
    if (!this.yng)
    {
      paramArrayOfByte = new Exception("Buffer For Parse");
      AppMethodBeat.o(52030);
      throw paramArrayOfByte;
    }
    byte[] arrayOfByte = null;
    if (paramArrayOfByte != null) {
      arrayOfByte = paramArrayOfByte;
    }
    paramArrayOfByte = arrayOfByte;
    if (arrayOfByte == null) {
      paramArrayOfByte = new byte[0];
    }
    if (paramArrayOfByte.length > 3072)
    {
      paramArrayOfByte = new Exception("Buffer String Length Error");
      AppMethodBeat.o(52030);
      throw paramArrayOfByte;
    }
    Nc(paramArrayOfByte.length + 2);
    this.byteBuffer.putShort((short)paramArrayOfByte.length);
    if (paramArrayOfByte.length > 0) {
      this.byteBuffer.put(paramArrayOfByte);
    }
    AppMethodBeat.o(52030);
    return 0;
  }
  
  public final void dst()
  {
    AppMethodBeat.i(52024);
    Exception localException;
    if (this.yng)
    {
      localException = new Exception("Buffer For Build");
      AppMethodBeat.o(52024);
      throw localException;
    }
    int i = this.byteBuffer.getShort();
    if (i > 3072)
    {
      this.byteBuffer = null;
      localException = new Exception("Buffer String Length Error");
      AppMethodBeat.o(52024);
      throw localException;
    }
    if (i == 0)
    {
      AppMethodBeat.o(52024);
      return;
    }
    this.byteBuffer.position(i + this.byteBuffer.position());
    AppMethodBeat.o(52024);
  }
  
  public final boolean dsu()
  {
    AppMethodBeat.i(52025);
    if (this.byteBuffer.limit() - this.byteBuffer.position() <= 1)
    {
      AppMethodBeat.o(52025);
      return true;
    }
    AppMethodBeat.o(52025);
    return false;
  }
  
  public final int dsv()
  {
    AppMethodBeat.i(52026);
    this.byteBuffer = ByteBuffer.allocate(4096);
    this.byteBuffer.put((byte)123);
    this.yng = true;
    AppMethodBeat.o(52026);
    return 0;
  }
  
  public final byte[] dsw()
  {
    AppMethodBeat.i(52032);
    if (!this.yng)
    {
      localObject = new Exception("Buffer For Parse");
      AppMethodBeat.o(52032);
      throw ((Throwable)localObject);
    }
    Nc(1);
    this.byteBuffer.put((byte)125);
    Object localObject = new byte[this.byteBuffer.position()];
    System.arraycopy(this.byteBuffer.array(), 0, localObject, 0, localObject.length);
    AppMethodBeat.o(52032);
    return localObject;
  }
  
  public final byte[] getBuffer()
  {
    AppMethodBeat.i(52021);
    if (this.yng)
    {
      localObject = new Exception("Buffer For Build");
      AppMethodBeat.o(52021);
      throw ((Throwable)localObject);
    }
    int i = this.byteBuffer.getShort();
    if (i > 3072)
    {
      this.byteBuffer = null;
      localObject = new Exception("Buffer String Length Error");
      AppMethodBeat.o(52021);
      throw ((Throwable)localObject);
    }
    if (i == 0)
    {
      AppMethodBeat.o(52021);
      return new byte[0];
    }
    Object localObject = new byte[i];
    this.byteBuffer.get((byte[])localObject, 0, i);
    AppMethodBeat.o(52021);
    return localObject;
  }
  
  public final int getInt()
  {
    AppMethodBeat.i(52019);
    if (this.yng)
    {
      Exception localException = new Exception("Buffer For Build");
      AppMethodBeat.o(52019);
      throw localException;
    }
    int i = this.byteBuffer.getInt();
    AppMethodBeat.o(52019);
    return i;
  }
  
  public final long getLong()
  {
    AppMethodBeat.i(52020);
    if (this.yng)
    {
      Exception localException = new Exception("Buffer For Build");
      AppMethodBeat.o(52020);
      throw localException;
    }
    long l = this.byteBuffer.getLong();
    AppMethodBeat.o(52020);
    return l;
  }
  
  public final String getString()
  {
    AppMethodBeat.i(52022);
    if (this.yng)
    {
      localObject = new Exception("Buffer For Build");
      AppMethodBeat.o(52022);
      throw ((Throwable)localObject);
    }
    int i = this.byteBuffer.getShort();
    if (i > 3072)
    {
      this.byteBuffer = null;
      localObject = new Exception("Buffer String Length Error");
      AppMethodBeat.o(52022);
      throw ((Throwable)localObject);
    }
    if (i == 0)
    {
      AppMethodBeat.o(52022);
      return "";
    }
    Object localObject = new byte[i];
    this.byteBuffer.get((byte[])localObject, 0, i);
    localObject = new String((byte[])localObject, "UTF-8");
    AppMethodBeat.o(52022);
    return localObject;
  }
  
  public final int nN(long paramLong)
  {
    AppMethodBeat.i(52029);
    if (!this.yng)
    {
      Exception localException = new Exception("Buffer For Parse");
      AppMethodBeat.o(52029);
      throw localException;
    }
    Nc(8);
    this.byteBuffer.putLong(paramLong);
    AppMethodBeat.o(52029);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.y
 * JD-Core Version:    0.7.0.1
 */