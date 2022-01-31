import android.graphics.BitmapFactory;
import com.tencent.mobileqq.portal.HongbaoCaidanRainView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class agra
  implements Runnable
{
  public agra(HongbaoCaidanRainView paramHongbaoCaidanRainView, String[] paramArrayOfString) {}
  
  public void run()
  {
    HongbaoCaidanRainView.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView).clear();
    String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label156;
      }
      Object localObject = arrayOfString[i];
      try
      {
        localObject = BitmapFactory.decodeFile((String)localObject);
        if (localObject != null) {
          HongbaoCaidanRainView.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView).add(localObject);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          QLog.d("HongbaoCaidanRainView", 1, "start, OutOfMemoryError oom=" + localOutOfMemoryError.getMessage());
          if (QLog.isColorLevel()) {
            localOutOfMemoryError.printStackTrace();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.d("HongbaoCaidanRainView", 1, "start, throwable t=" + localThrowable.getMessage());
          if (QLog.isColorLevel()) {
            localThrowable.printStackTrace();
          }
        }
      }
      i += 1;
    }
    label156:
    if (HongbaoCaidanRainView.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView).size() > 0)
    {
      HongbaoCaidanRainView.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView, System.currentTimeMillis());
      HongbaoCaidanRainView.b(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView, HongbaoCaidanRainView.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView));
      HongbaoCaidanRainView.a(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView, true);
      HongbaoCaidanRainView.b(this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView, false);
      this.jdField_a_of_type_ComTencentMobileqqPortalHongbaoCaidanRainView.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agra
 * JD-Core Version:    0.7.0.1
 */