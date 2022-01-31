import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.open.agent.AuthorityLoginView;
import com.tencent.qphone.base.util.QLog;

class alar
  implements Runnable
{
  alar(alaq paramalaq, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_Alaq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Alaq.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeResource(this.jdField_a_of_type_Alaq.jdField_a_of_type_ComTencentOpenAgentAuthorityLoginView.getResources(), 2130839300));
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError) {}
    } while (!QLog.isColorLevel());
    QLog.d("AuthorityLoginView", 2, "-->updateAccountFace oom");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alar
 * JD-Core Version:    0.7.0.1
 */