import java.nio.ByteBuffer;

public class ajdi
{
  public final int a;
  public final long a;
  public final byte[] a;
  public final int b;
  public final long b;
  public final byte[] b;
  public final long c;
  public final long d;
  public final long e;
  
  public ajdi(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.jdField_a_of_type_Int = 304;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_Int = 20;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.c = paramLong3;
    this.d = paramLong4;
    this.e = paramLong5;
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.putShort((short)(this.jdField_a_of_type_Int & 0xFFFF));
    byte[] arrayOfByte;
    if (this.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_Int) {
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    }
    for (;;)
    {
      paramByteBuffer.put(arrayOfByte, 0, this.jdField_a_of_type_Int);
      paramByteBuffer.putShort((short)(this.jdField_b_of_type_Int & 0xFFFF));
      if (this.jdField_b_of_type_ArrayOfByte.length == this.jdField_b_of_type_Int) {
        arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
      }
      for (;;)
      {
        paramByteBuffer.put(arrayOfByte, 0, this.jdField_b_of_type_Int);
        paramByteBuffer.putInt((int)(this.jdField_a_of_type_Long & 0xFFFFFFFF));
        paramByteBuffer.putInt((int)(this.jdField_b_of_type_Long & 0xFFFFFFFF));
        paramByteBuffer.putInt((int)(this.c & 0xFFFFFFFF));
        paramByteBuffer.putInt((int)(this.d & 0xFFFFFFFF));
        paramByteBuffer.putInt((int)(this.e & 0xFFFFFFFF));
        return;
        arrayOfByte = new byte[this.jdField_a_of_type_Int];
        if (this.jdField_a_of_type_ArrayOfByte.length > this.jdField_a_of_type_Int) {}
        for (int i = this.jdField_a_of_type_Int;; i = this.jdField_a_of_type_ArrayOfByte.length)
        {
          System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, i);
          while (i < this.jdField_a_of_type_Int)
          {
            arrayOfByte[i] = 0;
            i += 1;
          }
        }
        arrayOfByte = new byte[this.jdField_b_of_type_Int];
        if (this.jdField_b_of_type_ArrayOfByte.length > this.jdField_b_of_type_Int) {}
        for (i = this.jdField_b_of_type_Int;; i = this.jdField_b_of_type_ArrayOfByte.length)
        {
          System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, arrayOfByte, 0, i);
          while (i < this.jdField_b_of_type_Int)
          {
            arrayOfByte[i] = 0;
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdi
 * JD-Core Version:    0.7.0.1
 */