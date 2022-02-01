import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import tencent.im.oidb.cmd0x59f.oidb_0x59f.Guidelines_8410;

class alke
{
  alkj jdField_a_of_type_Alkj = alkj.jdField_a_of_type_Alkj;
  private oidb_0x59f.Guidelines_8410 jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410;
  
  int a()
  {
    if ((this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 != null) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_jump_type.has())) {
      return this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_jump_type.get();
    }
    return 0;
  }
  
  String a()
  {
    Object localObject2;
    if (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 == null) {
      localObject2 = "";
    }
    do
    {
      Object localObject1;
      do
      {
        return localObject2;
        localObject2 = "";
        localObject1 = localObject2;
        if (a())
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.str_res_url_night.has()) {
            localObject1 = this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.str_res_url_night.get();
          }
        }
        localObject2 = localObject1;
      } while (!TextUtils.isEmpty((CharSequence)localObject1));
      localObject2 = localObject1;
    } while (!this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.str_res_url.has());
    return this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.str_res_url.get();
  }
  
  void a(oidb_0x59f.Guidelines_8410 paramGuidelines_8410)
  {
    this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 = paramGuidelines_8410;
  }
  
  boolean a()
  {
    return ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
  }
  
  boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = this.jdField_a_of_type_Alkj.a(paramQQAppInterface.getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      try
      {
        Object localObject = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse(paramQQAppInterface);
        paramQQAppInterface = Calendar.getInstance();
        paramQQAppInterface.setTime((Date)localObject);
        localObject = Calendar.getInstance();
        ((Calendar)localObject).setTime(new Date());
        if ((paramQQAppInterface.get(0) == ((Calendar)localObject).get(0)) && (paramQQAppInterface.get(1) == ((Calendar)localObject).get(1)))
        {
          int i = paramQQAppInterface.get(6);
          int j = ((Calendar)localObject).get(6);
          if (i == j) {
            return true;
          }
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("NewerGuideBannerModel", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return false;
  }
  
  int b()
  {
    if ((this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 != null) && (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_id.has())) {
      return this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.uint32_banner_id.get();
    }
    return 0;
  }
  
  String b()
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410 == null) {}
    while (!this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.str_jump_url.has()) {
      return "";
    }
    return this.jdField_a_of_type_TencentImOidbCmd0x59fOidb_0x59f$Guidelines_8410.str_jump_url.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alke
 * JD-Core Version:    0.7.0.1
 */