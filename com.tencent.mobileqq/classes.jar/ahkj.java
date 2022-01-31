import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.redtouch.RedTouchTextView;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.File;

public class ahkj
  implements Runnable
{
  public ahkj(RedTouchTextView paramRedTouchTextView, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject = new File(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.getContext().getFilesDir(), this.jdField_a_of_type_JavaLangString);
    Bitmap localBitmap;
    if (((File)localObject).exists())
    {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a((File)localObject);
      localObject = localBitmap;
      if (this.jdField_a_of_type_Int == 1) {
        localObject = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.b = new BitmapDrawable((Bitmap)localObject);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a();
    }
    while (RedTouchTextView.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView)) {
      return;
    }
    RedTouchTextView.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView, true);
    if (HttpDownloadUtil.a(null, this.jdField_a_of_type_JavaLangString, (File)localObject))
    {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a((File)localObject);
      localObject = localBitmap;
      if (this.jdField_a_of_type_Int == 1) {
        localObject = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.b = new BitmapDrawable((Bitmap)localObject);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView.a();
    }
    RedTouchTextView.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchTextView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahkj
 * JD-Core Version:    0.7.0.1
 */