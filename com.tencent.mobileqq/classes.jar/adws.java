import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.jsp.QQApiPlugin;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class adws
  implements TroopMemberApiClient.Callback
{
  adws(adwp paramadwp, Bitmap paramBitmap) {}
  
  public void a(Bundle paramBundle)
  {
    int j = 0;
    int i = 0;
    if (paramBundle.getInt("readinjoy_to_wx_config") == 0)
    {
      paramBundle = WxShareHelperFromReadInjoy.a();
      str1 = this.jdField_a_of_type_Adwp.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.c;
      str2 = this.jdField_a_of_type_Adwp.d;
      localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      str3 = this.jdField_a_of_type_Adwp.e;
      str4 = this.jdField_a_of_type_Adwp.b;
      if ("2".equals(this.jdField_a_of_type_Adwp.jdField_a_of_type_JavaLangString)) {}
      for (;;)
      {
        paramBundle.a(str1, str2, localBitmap, str3, str4, i);
        return;
        i = 1;
      }
    }
    paramBundle = WXShareHelper.a();
    String str1 = this.jdField_a_of_type_Adwp.jdField_a_of_type_ComTencentMobileqqJspQQApiPlugin.c;
    String str2 = this.jdField_a_of_type_Adwp.d;
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    String str3 = this.jdField_a_of_type_Adwp.e;
    String str4 = this.jdField_a_of_type_Adwp.b;
    if ("2".equals(this.jdField_a_of_type_Adwp.jdField_a_of_type_JavaLangString)) {}
    for (i = j;; i = 1)
    {
      paramBundle.b(str1, str2, localBitmap, str3, str4, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adws
 * JD-Core Version:    0.7.0.1
 */