import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.widget.AvatarWallAdapter;
import com.tencent.mobileqq.troop.widget.BorderURLImageView;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;

class ajdp
  implements Runnable
{
  ajdp(ajdo paramajdo, Setting paramSetting) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) || (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType == 0))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) && (!this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.g))
      {
        this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.g = true;
        if (!this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
          this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.b, 4, true);
        }
      }
      if (this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
      try
      {
        this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130840537);
        this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.b(this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.f, this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c, this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c);
        if (this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView.setImageBitmap(this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_AndroidGraphicsBitmap);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(AvatarWallAdapter.jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
        }
        this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView.setImageResource(2130840537);
        return;
      }
    }
    try
    {
      URLDrawable localURLDrawable = URLDrawable.getDrawable(NearbyImgDownloader.a(this.jdField_a_of_type_Ajdo.jdField_a_of_type_JavaLangString));
      localURLDrawable.setTag(URLDrawableDecodeHandler.a(this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c, this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c, this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.f));
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.b);
      this.jdField_a_of_type_Ajdo.jdField_a_of_type_ComTencentMobileqqTroopWidgetBorderURLImageView.setImageDrawable(localURLDrawable);
      return;
    }
    catch (MalformedURLException localMalformedURLException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajdp
 * JD-Core Version:    0.7.0.1
 */