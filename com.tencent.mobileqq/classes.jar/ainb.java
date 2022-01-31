import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.teamwork.spread.BaseTimAIOTipsProcessor.ListResult;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ainb
  implements BaseTimAIOTipsProcessor.ListResult
{
  ainb(aina paramaina, String paramString) {}
  
  public void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      if (QLog.isDebugVersion())
      {
        if (paramList != null) {
          break label34;
        }
        paramList = "lst is null";
        QLog.i("AIOMessageSpreadManager", 1, paramList);
      }
    }
    label34:
    float f1;
    float f2;
    do
    {
      return;
      while (!paramList.hasNext())
      {
        paramList = "lst.size() = 0";
        break;
        f1 = AIOMessageSpreadManager.a(this.jdField_a_of_type_Aina.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).a();
        paramList = paramList.iterator();
      }
      str = (String)paramList.next();
      f2 = AIOMessageSpreadManager.a(this.jdField_a_of_type_Aina.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, this.jdField_a_of_type_JavaLangString, str);
      if (QLog.isColorLevel()) {
        QLog.i("AIOMessageSpreadManager", 1, "file[" + this.jdField_a_of_type_JavaLangString + "] and [" + str + "], precentage[" + f2 + "]");
      }
    } while (f2 - f1 <= 0.0F);
    String str = AIOMessageSpreadManager.a(this.jdField_a_of_type_Aina.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).b();
    paramList = AIOMessageSpreadManager.a(this.jdField_a_of_type_Aina.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager).c();
    str = str + "。" + paramList;
    AIOMessageSpreadManager.a(this.jdField_a_of_type_Aina.jdField_a_of_type_ComTencentMobileqqTeamworkSpreadAIOMessageSpreadManager, this.jdField_a_of_type_Aina.jdField_a_of_type_ComTencentMobileqqDataChatMessage, str, paramList, "precent", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainb
 * JD-Core Version:    0.7.0.1
 */