import com.tencent.mobileqq.magicface.view.GLRender;

public class adqz
{
  public float a;
  public int a;
  public boolean a;
  public byte[] a;
  public int b;
  public byte[] b;
  public int c;
  public int d;
  
  public adqz(GLRender paramGLRender) {}
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label28;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte1.length];
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label49;
      }
    }
    for (;;)
    {
      return false;
      label28:
      if (this.jdField_a_of_type_ArrayOfByte.length == paramArrayOfByte1.length) {
        break;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte1.length];
      break;
      label49:
      System.arraycopy(paramArrayOfByte1, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte1.length);
      if (this.jdField_b_of_type_ArrayOfByte == null) {
        this.jdField_b_of_type_ArrayOfByte = new byte[paramArrayOfByte2.length];
      }
      while (this.jdField_b_of_type_ArrayOfByte != null)
      {
        System.arraycopy(paramArrayOfByte2, 0, this.jdField_b_of_type_ArrayOfByte, 0, paramArrayOfByte2.length);
        this.jdField_a_of_type_Int = paramInt3;
        this.jdField_b_of_type_Int = paramInt4;
        this.c = paramInt1;
        this.d = paramInt2;
        this.jdField_a_of_type_Float = paramFloat;
        this.jdField_a_of_type_Boolean = paramBoolean;
        return true;
        if (this.jdField_b_of_type_ArrayOfByte.length != paramArrayOfByte2.length) {
          this.jdField_b_of_type_ArrayOfByte = new byte[paramArrayOfByte2.length];
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adqz
 * JD-Core Version:    0.7.0.1
 */