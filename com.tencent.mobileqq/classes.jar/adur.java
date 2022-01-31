import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class adur
  extends anwl
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aobp jdField_a_of_type_Aobp;
  private bcqf jdField_a_of_type_Bcqf;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, aobp paramaobp, SessionInfo paramSessionInfo, bcqf parambcqf)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aobp = paramaobp;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Bcqf = parambcqf;
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MarketFaceItemBuilder", 2, "onJsonComplete:" + paramEmoticonPackage.epId);
    }
    if (paramInt == 0)
    {
      if (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.jdField_a_of_type_Aobp.a.epId)) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      adue.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_Aobp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bcqf);
      return;
    }
    adue.a(this.jdField_a_of_type_Int + 1000, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, this.jdField_a_of_type_Aobp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bcqf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adur
 * JD-Core Version:    0.7.0.1
 */