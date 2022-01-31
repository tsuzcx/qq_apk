import android.graphics.BitmapFactory;
import com.tencent.mobileqq.portal.FlakeView;

public class afyc
  implements Runnable
{
  public afyc(FlakeView paramFlakeView, String paramString) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.e = true;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     afyc
 * JD-Core Version:    0.7.0.1
 */