import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;

class aabw
  implements Runnable
{
  aabw(aabt paramaabt, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3) {}
  
  public void run()
  {
    if (aabt.c(this.jdField_a_of_type_Aabt) != -1) {
      GLES20.glDeleteTextures(1, new int[] { aabt.c(this.jdField_a_of_type_Aabt) }, 0);
    }
    if (aabt.d(this.jdField_a_of_type_Aabt) != -1) {
      GLES20.glDeleteTextures(1, new int[] { aabt.d(this.jdField_a_of_type_Aabt) }, 0);
    }
    if (aabt.e(this.jdField_a_of_type_Aabt) != -1) {
      GLES20.glDeleteTextures(1, new int[] { aabt.e(this.jdField_a_of_type_Aabt) }, 0);
    }
    try
    {
      aabt.b(this.jdField_a_of_type_Aabt, aabt.a(this.jdField_a_of_type_Aabt, 1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      aabt.c(this.jdField_a_of_type_Aabt, aabt.a(this.jdField_a_of_type_Aabt, 2, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      aabt.d(this.jdField_a_of_type_Aabt, aabt.a(this.jdField_a_of_type_Aabt, 3, this.c, this.jdField_a_of_type_Int / 2, (this.jdField_b_of_type_Int + 1) / 2));
      aabt.a(this.jdField_a_of_type_Aabt, true);
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
 * Qualified Name:     aabw
 * JD-Core Version:    0.7.0.1
 */