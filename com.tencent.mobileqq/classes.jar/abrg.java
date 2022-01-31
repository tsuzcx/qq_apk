import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import java.io.File;

public class abrg
  implements Runnable
{
  public abrg(SelectCoverActivity paramSelectCoverActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
        } while (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_Boolean);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_JavaLangString))
        {
          SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 2, "处理失败，请重试", 0);
          return;
        }
        SelectCoverActivity.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity, 0, "正在上传", 0);
        if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_d_of_type_Int != 1) {
          break;
        }
      } while ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a)) || (!new File(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a).exists()) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_b_of_type_JavaLangString)) || (!new File(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.jdField_b_of_type_JavaLangString).exists()));
      SelectCoverActivity.b(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_d_of_type_Int != 2);
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.getIntent();
    localIntent.putExtra("key_photo_file_path", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_video_duration", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.f);
    localIntent.putExtra("key_video_has_voice", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.c);
    localIntent.putExtra("key_camera_id", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("key_photo_selected_by_user", this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrg
 * JD-Core Version:    0.7.0.1
 */