import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity;
import com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter;
import com.tencent.widget.Gallery;

class aihj
  implements Runnable
{
  aihj(aihi paramaihi, Setting paramSetting) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.b);
    this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.a(this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataSetting);
    TroopAvatarWallGalleryAdapter localTroopAvatarWallGalleryAdapter = this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter;
    if (!this.jdField_a_of_type_Aihi.jdField_a_of_type_AndroidOsBundle.getBoolean("from_photo_wall", false)) {}
    for (boolean bool = true;; bool = false)
    {
      localTroopAvatarWallGalleryAdapter.a(bool);
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter.b(this.jdField_a_of_type_Aihi.jdField_a_of_type_AndroidOsBundle.getBoolean("is_use_path", false));
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAvatarWallGalleryAdapter);
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.getResources().getDimensionPixelSize(2131558524));
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.b(false);
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.a(false);
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new aihk(this));
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new aihl(this));
      this.jdField_a_of_type_Aihi.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallEditActivity.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new aihm(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aihj
 * JD-Core Version:    0.7.0.1
 */