import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.OnUseResListener;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class agtp
  implements Runnable
{
  agtp(agto paramagto, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Agto.jdField_a_of_type_Agtj.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      return;
    }
    this.jdField_a_of_type_Agto.jdField_a_of_type_Agtj.a.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelShareHelper$OnUseResListener.a(false);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131430006);
      return;
    }
    if (this.jdField_a_of_type_Agto.jdField_a_of_type_Long == 2L)
    {
      WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Agto.jdField_a_of_type_Agtj.a.jdField_a_of_type_AndroidGraphicsBitmap, 0);
      return;
    }
    WXShareHelper.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Agto.jdField_a_of_type_Agtj.a.jdField_a_of_type_AndroidGraphicsBitmap, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agtp
 * JD-Core Version:    0.7.0.1
 */