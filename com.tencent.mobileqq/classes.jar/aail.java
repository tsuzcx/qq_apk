import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class aail
  implements Runnable
{
  aail(aaii paramaaii, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void run()
  {
    if (aaii.c(this.jdField_a_of_type_Aaii) != -1) {
      GLES20.glDeleteTextures(1, new int[] { aaii.c(this.jdField_a_of_type_Aaii) }, 0);
    }
    if (aaii.d(this.jdField_a_of_type_Aaii) != -1) {
      GLES20.glDeleteTextures(1, new int[] { aaii.d(this.jdField_a_of_type_Aaii) }, 0);
    }
    if (aaii.e(this.jdField_a_of_type_Aaii) != -1) {
      GLES20.glDeleteTextures(1, new int[] { aaii.e(this.jdField_a_of_type_Aaii) }, 0);
    }
    try
    {
      aaii.b(this.jdField_a_of_type_Aaii, aaii.a(this.jdField_a_of_type_Aaii, 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      aaii.c(this.jdField_a_of_type_Aaii, aaii.a(this.jdField_a_of_type_Aaii, 2, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      aaii.d(this.jdField_a_of_type_Aaii, aaii.a(this.jdField_a_of_type_Aaii, 3, this.c, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      aaii.a(this.jdField_a_of_type_Aaii, true);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("AREngine_OnlineVideoARRenderable", 2, "drawFrame_soft exception=" + localException.getMessage());
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aail
 * JD-Core Version:    0.7.0.1
 */