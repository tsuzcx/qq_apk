import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.portal.Flake;
import com.tencent.mobileqq.portal.FlakeView;
import java.util.ArrayList;
import java.util.Random;

public class agqs
  implements Runnable
{
  public agqs(FlakeView paramFlakeView, String[] paramArrayOfString, int paramInt) {}
  
  public void run()
  {
    Random localRandom = new Random();
    Bitmap[] arrayOfBitmap = new Bitmap[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        try
        {
          arrayOfBitmap[i] = BitmapFactory.decodeFile(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          i += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            localOutOfMemoryError.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      Object localObject = arrayOfBitmap[localRandom.nextInt(this.jdField_a_of_type_ArrayOfJavaLangString.length)];
      if (localObject != null)
      {
        localObject = Flake.a(this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.getWidth(), (Bitmap)localObject, 3, this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.getResources());
        ((Flake)localObject).a = (this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.getWidth() / 2);
        ((Flake)localObject).b = AIOUtils.a(205.0F, this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.getResources());
        this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a.add(localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView;
        ((FlakeView)localObject).e += 1;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqs
 * JD-Core Version:    0.7.0.1
 */