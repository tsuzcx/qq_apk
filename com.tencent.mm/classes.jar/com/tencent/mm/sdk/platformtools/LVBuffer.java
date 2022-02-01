package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class LVBuffer
{
  private static final byte BE = 123;
  private static final byte ED = 125;
  public static final int LENGTH_ALLOC_PER_NEW = 4096;
  public static final int MAX_STRING_LENGTH = 3072;
  private ByteBuffer byteBuffer;
  private boolean isBuildBuffer;
  
  private int check(byte[] paramArrayOfByte)
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
  
  private int checkBuffer(int paramInt)
  {
    AppMethodBeat.i(157583);
    if (this.byteBuffer.limit() - this.byteBuffer.position() > paramInt)
    {
      AppMethodBeat.o(157583);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(this.byteBuffer.limit() + 4096);
    localByteBuffer.put(this.byteBuffer.array(), 0, this.byteBuffer.position());
    this.byteBuffer = localByteBuffer;
    AppMethodBeat.o(157583);
    return 0;
  }
  
  public byte[] buildFinish()
  {
    AppMethodBeat.i(157588);
    if (!this.isBuildBuffer)
    {
      localObject = new Exception("Buffer For Parse");
      AppMethodBeat.o(157588);
      throw ((Throwable)localObject);
    }
    checkBuffer(1);
    this.byteBuffer.put((byte)125);
    Object localObject = new byte[this.byteBuffer.position()];
    System.arraycopy(this.byteBuffer.array(), 0, localObject, 0, localObject.length);
    AppMethodBeat.o(157588);
    return localObject;
  }
  
  public boolean checkGetFinish()
  {
    AppMethodBeat.i(157581);
    if (this.byteBuffer.limit() - this.byteBuffer.position() <= 1)
    {
      AppMethodBeat.o(157581);
      return true;
    }
    AppMethodBeat.o(157581);
    return false;
  }
  
  public byte[] getBuffer()
  {
    AppMethodBeat.i(157577);
    if (this.isBuildBuffer)
    {
      localObject = new Exception("Buffer For Build");
      AppMethodBeat.o(157577);
      throw ((Throwable)localObject);
    }
    int i = this.byteBuffer.getShort();
    if (i > 3072)
    {
      this.byteBuffer = null;
      localObject = new Exception("Buffer String Length Error");
      AppMethodBeat.o(157577);
      throw ((Throwable)localObject);
    }
    if (i == 0)
    {
      AppMethodBeat.o(157577);
      return new byte[0];
    }
    Object localObject = new byte[i];
    this.byteBuffer.get((byte[])localObject, 0, i);
    AppMethodBeat.o(157577);
    return localObject;
  }
  
  public int getInt()
  {
    AppMethodBeat.i(157575);
    if (this.isBuildBuffer)
    {
      Exception localException = new Exception("Buffer For Build");
      AppMethodBeat.o(157575);
      throw localException;
    }
    int i = this.byteBuffer.getInt();
    AppMethodBeat.o(157575);
    return i;
  }
  
  public long getLong()
  {
    AppMethodBeat.i(157576);
    if (this.isBuildBuffer)
    {
      Exception localException = new Exception("Buffer For Build");
      AppMethodBeat.o(157576);
      throw localException;
    }
    long l = this.byteBuffer.getLong();
    AppMethodBeat.o(157576);
    return l;
  }
  
  public String getString()
  {
    AppMethodBeat.i(157578);
    if (this.isBuildBuffer)
    {
      localObject = new Exception("Buffer For Build");
      AppMethodBeat.o(157578);
      throw ((Throwable)localObject);
    }
    int i = this.byteBuffer.getShort();
    if (i > 3072)
    {
      this.byteBuffer = null;
      localObject = new Exception("Buffer String Length Error");
      AppMethodBeat.o(157578);
      throw ((Throwable)localObject);
    }
    if (i == 0)
    {
      AppMethodBeat.o(157578);
      return "";
    }
    Object localObject = new byte[i];
    this.byteBuffer.get((byte[])localObject, 0, i);
    localObject = new String((byte[])localObject, "UTF-8");
    AppMethodBeat.o(157578);
    return localObject;
  }
  
  public int initBuild()
  {
    AppMethodBeat.i(157582);
    this.byteBuffer = ByteBuffer.allocate(4096);
    this.byteBuffer.put((byte)123);
    this.isBuildBuffer = true;
    AppMethodBeat.o(157582);
    return 0;
  }
  
  public int initParse(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157574);
    if (check(paramArrayOfByte) != 0)
    {
      this.byteBuffer = null;
      AppMethodBeat.o(157574);
      return -1;
    }
    this.byteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    this.byteBuffer.position(1);
    this.isBuildBuffer = false;
    AppMethodBeat.o(157574);
    return 0;
  }
  
  public int putBuffer(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(157586);
    if (!this.isBuildBuffer)
    {
      paramArrayOfByte = new Exception("Buffer For Parse");
      AppMethodBeat.o(157586);
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
      AppMethodBeat.o(157586);
      throw paramArrayOfByte;
    }
    checkBuffer(paramArrayOfByte.length + 2);
    this.byteBuffer.putShort((short)paramArrayOfByte.length);
    if (paramArrayOfByte.length > 0) {
      this.byteBuffer.put(paramArrayOfByte);
    }
    AppMethodBeat.o(157586);
    return 0;
  }
  
  public int putInt(int paramInt)
  {
    AppMethodBeat.i(157584);
    if (!this.isBuildBuffer)
    {
      Exception localException = new Exception("Buffer For Parse");
      AppMethodBeat.o(157584);
      throw localException;
    }
    checkBuffer(4);
    this.byteBuffer.putInt(paramInt);
    AppMethodBeat.o(157584);
    return 0;
  }
  
  public int putLong(long paramLong)
  {
    AppMethodBeat.i(157585);
    if (!this.isBuildBuffer)
    {
      Exception localException = new Exception("Buffer For Parse");
      AppMethodBeat.o(157585);
      throw localException;
    }
    checkBuffer(8);
    this.byteBuffer.putLong(paramLong);
    AppMethodBeat.o(157585);
    return 0;
  }
  
  public int putString(String paramString)
  {
    AppMethodBeat.i(157587);
    if (!this.isBuildBuffer)
    {
      paramString = new Exception("Buffer For Parse");
      AppMethodBeat.o(157587);
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
      AppMethodBeat.o(157587);
      throw paramString;
    }
    checkBuffer(paramString.length + 2);
    this.byteBuffer.putShort((short)paramString.length);
    if (paramString.length > 0) {
      this.byteBuffer.put(paramString);
    }
    AppMethodBeat.o(157587);
    return 0;
  }
  
  public void skipPosition(int paramInt)
  {
    AppMethodBeat.i(157579);
    ByteBuffer localByteBuffer = this.byteBuffer;
    localByteBuffer.position(localByteBuffer.position() + paramInt);
    AppMethodBeat.o(157579);
  }
  
  public void skipString()
  {
    AppMethodBeat.i(157580);
    Exception localException;
    if (this.isBuildBuffer)
    {
      localException = new Exception("Buffer For Build");
      AppMethodBeat.o(157580);
      throw localException;
    }
    int i = this.byteBuffer.getShort();
    if (i > 3072)
    {
      this.byteBuffer = null;
      localException = new Exception("Buffer String Length Error");
      AppMethodBeat.o(157580);
      throw localException;
    }
    if (i == 0)
    {
      AppMethodBeat.o(157580);
      return;
    }
    this.byteBuffer.position(i + this.byteBuffer.position());
    AppMethodBeat.o(157580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LVBuffer
 * JD-Core Version:    0.7.0.1
 */