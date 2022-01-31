import android.content.ContentResolver;
import android.content.ContentValues;
import com.tencent.common.config.provider.QZoneConfigConst;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import mqq.app.MobileQQ;

public class ahjx
  implements Runnable
{
  public ahjx(QZoneManagerImp paramQZoneManagerImp, QZoneCountInfo paramQZoneCountInfo, int paramInt) {}
  
  public void run()
  {
    if (QZoneManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp) == null) {
      return;
    }
    ContentValues localContentValues = this.jdField_a_of_type_CooperationQzoneUndealCountQZoneCountInfo.a();
    localContentValues.put("own_uin", QZoneManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp).getAccount());
    localContentValues.put("type", Integer.valueOf(this.jdField_a_of_type_Int));
    try
    {
      QZoneManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp).getApplication().getContentResolver().insert(QZoneConfigConst.h, localContentValues);
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqServletQZoneManagerImp.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahjx
 * JD-Core Version:    0.7.0.1
 */