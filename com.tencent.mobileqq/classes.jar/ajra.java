import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ajra
  implements yrb
{
  public ajra(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString1, String paramString2) {}
  
  public void callback(Bundle paramBundle)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getIntent();
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")) && (paramBundle.getInt("head_id") >= 0) && (!TextUtils.isEmpty(paramBundle.getString("video_id"))))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c();
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("video_path", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("photo_path", this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, 1, alud.a(2131707854), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajra
 * JD-Core Version:    0.7.0.1
 */