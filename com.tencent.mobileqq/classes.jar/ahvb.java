import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class ahvb
  implements wxt
{
  public ahvb(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString1, String paramString2) {}
  
  public void a(Bundle paramBundle)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getIntent();
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")) && (paramBundle.getInt("head_id") >= 0) && (!TextUtils.isEmpty(paramBundle.getString("video_id"))))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e();
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("video_path", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("photo_path", this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e();
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, 1, ajya.a(2131707470), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.e());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahvb
 * JD-Core Version:    0.7.0.1
 */