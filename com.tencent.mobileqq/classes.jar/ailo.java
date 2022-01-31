import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.qphone.base.util.QLog;

public class ailo
  implements Runnable
{
  public ailo(Texture paramTexture) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_Int != 0)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.a.jdField_a_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      GLES20.glFlush();
      if (QLog.isColorLevel()) {
        QLog.d("Texture", 2, "Texture->release real: textureId = " + this.a.jdField_a_of_type_Int + ", filePath = " + Texture.a(this.a));
      }
      this.a.jdField_a_of_type_Int = 0;
    }
    if ((this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.a.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailo
 * JD-Core Version:    0.7.0.1
 */