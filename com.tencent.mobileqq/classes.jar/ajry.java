import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class ajry
  implements Runnable
{
  public ajry(AvatarWallViewPagerAdapter paramAvatarWallViewPagerAdapter, String paramString, AvatarWallAdapter.AvatarInfo paramAvatarInfo, URLImageView paramURLImageView) {}
  
  public void run()
  {
    BitmapFactory.Options localOptions = ImageUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_Int);
    if (localOptions.outHeight > localOptions.outWidth) {}
    Bitmap localBitmap;
    for (int i = localOptions.outWidth;; i = localOptions.outHeight) {
      try
      {
        localBitmap = ImageUtil.b(BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, localOptions), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.b);
        if (localBitmap != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("AvatarWallViewPagerAdapter", 2, "bmp == null");
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("AvatarWallViewPagerAdapter", 2, "BitmapFactory.decodeFile throw exception, msg = " + localException.getMessage());
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("AvatarWallViewPagerAdapter", 2, "BitmapFactory.decodeFile throw oom error, msg = " + localOutOfMemoryError.getMessage());
        return;
      }
    }
    int j = TroopUtils.a(this.jdField_a_of_type_JavaLangString);
    Object localObject = localBitmap;
    if (j != 0) {
      localObject = ImageUtil.b(localBitmap, j);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AvatarInfo.b = i;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AvatarInfo.a = ((Bitmap)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_AndroidOsHandler.post(new ajrz(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajry
 * JD-Core Version:    0.7.0.1
 */