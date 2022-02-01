import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class ahmf
  extends askr
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private asre jdField_a_of_type_Asre;
  private bjbs jdField_a_of_type_Bjbs;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, asre paramasre, SessionInfo paramSessionInfo, bjbs parambjbs)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Asre = paramasre;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Bjbs = parambjbs;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "onJsonComplete:" + paramEmoticonPackage.epId);
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_Asre.a.epId)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      ahlt.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_Asre, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bjbs);
      return;
    }
    ahlt.a(this.jdField_a_of_type_Int + 1000, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_Asre, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bjbs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmf
 * JD-Core Version:    0.7.0.1
 */