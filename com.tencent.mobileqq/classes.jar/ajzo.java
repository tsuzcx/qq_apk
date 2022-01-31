import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ajzo
  implements Runnable
{
  ajzo(ajzn paramajzn, Setting paramSetting) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) || (this.jdField_a_of_type_ComTencentMobileqqDataSetting.bHeadType == 0))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataSetting == null) && (!this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_Boolean = true;
        if (!this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
          this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_JavaLangString, 4, true);
        }
      }
      if (this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    }
    do
    {
      try
      {
        this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getContext().getResources(), 2130840558);
        this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.b(this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_Int, this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.b);
        if (this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.jdField_a_of_type_AndroidGraphicsBitmap);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AvatarWallViewPagerAdapter", 2, QLog.getStackTraceString(localOutOfMemoryError));
          }
        }
        this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840558);
        return;
      }
      URLDrawable localURLDrawable = this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(this.jdField_a_of_type_Ajzn.jdField_a_of_type_JavaLangString);
      if (localURLDrawable != null)
      {
        this.jdField_a_of_type_Ajzn.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AvatarWallViewPagerAdapter", 2, "avatar wall pic load error，createUrlDrawableByPath return null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajzo
 * JD-Core Version:    0.7.0.1
 */