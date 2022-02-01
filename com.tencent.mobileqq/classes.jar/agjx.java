import android.app.Activity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

final class agjx
  implements bmrs
{
  agjx(int paramInt1, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, int paramInt2, String paramString, Activity paramActivity) {}
  
  public void a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs.length <= 0) || (paramVarArgs[0] == null))
    {
      QLog.i("PlusPanelUtils", 2, "error get pskey...");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("pskey_type", "27");
    localHashMap.put("pskey", paramVarArgs[0]);
    localHashMap.put("recv_group_type", this.jdField_a_of_type_Int + "");
    localHashMap.put("recv_group_id", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localHashMap.put("send_nickname", bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    localHashMap.put("send_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    localHashMap.put("group_count", this.b + "");
    paramVarArgs = bmrq.a(this.jdField_a_of_type_JavaLangString, localHashMap, true);
    alik.a(this.jdField_a_of_type_AndroidAppActivity, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjx
 * JD-Core Version:    0.7.0.1
 */