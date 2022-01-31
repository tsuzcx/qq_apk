import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.OnUseResListener;

class agau
  implements Runnable
{
  agau(agat paramagat, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Agat.a.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_Agat.a.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131429987);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_thumb", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_urldrawable_big_url", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("forward_extra", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt(ForwardBaseOption.e, 1);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ForwardBaseOption.a(this.jdField_a_of_type_Agat.a.a.jdField_a_of_type_AndroidAppActivity, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agau
 * JD-Core Version:    0.7.0.1
 */