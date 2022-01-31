import java.nio.ByteBuffer;

public class ajdj
{
  public final int a;
  public final long a;
  public final long b;
  
  public ajdj(ByteBuffer paramByteBuffer)
  {
    this.jdField_a_of_type_Int = (paramByteBuffer.get() & 0xFFFF);
    this.jdField_a_of_type_Long = (paramByteBuffer.getInt() & 0xFFFFFFFF);
    this.b = (paramByteBuffer.getInt() & 0xFFFFFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdj
 * JD-Core Version:    0.7.0.1
 */