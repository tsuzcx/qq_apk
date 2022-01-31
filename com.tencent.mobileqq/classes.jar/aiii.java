import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.widget.TroopAvatarBigPhotoAdapter;
import com.tencent.widget.Gallery;

class aiii
  implements Runnable
{
  aiii(aiih paramaiih, Setting paramSetting) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b);
    this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.e != null) {
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.b(this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.e);
    }
    this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.a(this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataSetting);
    TroopAvatarBigPhotoAdapter localTroopAvatarBigPhotoAdapter = this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter;
    if (!this.jdField_a_of_type_Aiih.jdField_a_of_type_AndroidOsBundle.getBoolean("from_photo_wall", false)) {}
    for (boolean bool = true;; bool = false)
    {
      localTroopAvatarBigPhotoAdapter.a(bool);
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter.b(this.jdField_a_of_type_Aiih.jdField_a_of_type_AndroidOsBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int = this.jdField_a_of_type_Aiih.jdField_a_of_type_AndroidOsBundle.getInt("index", -1);
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarBigPhotoAdapter);
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getResources().getDimensionPixelSize(2131558524));
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new aiij(this));
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new aiik(this));
      this.jdField_a_of_type_Aiih.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new aiil(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiii
 * JD-Core Version:    0.7.0.1
 */