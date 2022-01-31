import android.graphics.Bitmap;
import com.tencent.mobileqq.armap.SdCardImageAnimView;
import com.tencent.qphone.base.util.QLog;

class abkf
  implements Runnable
{
  abkf(abke paramabke, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SdCardImageAnimView", 2, "defaultImgRunnable set image bitmap");
    }
    this.jdField_a_of_type_Abke.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abkf
 * JD-Core Version:    0.7.0.1
 */