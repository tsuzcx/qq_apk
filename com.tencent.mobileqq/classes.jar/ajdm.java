import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter.AvatarInfo;
import com.tencent.mobileqq.troop.widget.BorderURLImageView;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class ajdm
  implements Runnable
{
  public ajdm(AvatarWallAdapter paramAvatarWallAdapter, String paramString, int paramInt, AvatarWallAdapter.AvatarInfo paramAvatarInfo, BorderURLImageView paramBorderURLImageView) {}
  
  public void run()
  {
    Object localObject1 = ImageUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    int i;
    if (((BitmapFactory.Options)localObject1).outHeight > ((BitmapFactory.Options)localObject1).outWidth) {
      i = ((BitmapFactory.Options)localObject1).outWidth;
    }
    try
    {
      for (;;)
      {
        localObject1 = ImageUtil.a(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
        Object localObject3 = localObject1;
        if (localObject1 != null)
        {
          int j = TroopUtils.a(this.jdField_a_of_type_JavaLangString);
          localObject3 = localObject1;
          if (j != 0) {
            localObject3 = ImageUtil.b((Bitmap)localObject1, j);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AvatarInfo.b = i;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter$AvatarInfo.a = ((Bitmap)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidOsHandler.post(new ajdn(this));
        return;
        i = ((BitmapFactory.Options)localObject1).outHeight;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w(AvatarWallAdapter.jdField_a_of_type_JavaLangString, 2, "viewFactory: AVATAR_LOCAL:" + localOutOfMemoryError);
        }
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajdm
 * JD-Core Version:    0.7.0.1
 */