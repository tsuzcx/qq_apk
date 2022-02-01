import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class ahly
  implements axfu<EmoticonPackage>
{
  ahly(ahlt paramahlt, int paramInt, ChatMessage paramChatMessage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    String str = "0";
    int i = -1;
    if (paramEmoticonPackage != null)
    {
      str = paramEmoticonPackage.epId;
      if ((3 == paramEmoticonPackage.jobType) || (5 == paramEmoticonPackage.jobType)) {
        i = 2;
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int != 2131365352) {
        break label98;
      }
      aean.b(this.jdField_a_of_type_Ahlt.b, this.jdField_a_of_type_Ahlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      bdll.b(this.jdField_a_of_type_Ahlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
    }
    label98:
    do
    {
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131362195)
        {
          this.jdField_a_of_type_Ahlt.a(paramEmoticonPackage, str, i);
          return;
        }
        if ((this.jdField_a_of_type_Int == 2131367095) || (this.jdField_a_of_type_Int == 2131366803))
        {
          this.jdField_a_of_type_Ahlt.a(paramEmoticonPackage, str, i, this.jdField_a_of_type_Int);
          return;
        }
      } while (this.jdField_a_of_type_Int != 2131371486);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 4, "marketface related click");
      }
    } while ((ahlt.jdField_a_of_type_Asre == null) || (ahlt.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (ahlt.jdField_a_of_type_Asre.a == null));
    bdll.b(this.jdField_a_of_type_Ahlt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Ahlt.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B115", "0X800B115", asos.a(this.jdField_a_of_type_Ahlt.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "1", "", ahlt.jdField_a_of_type_Asre.a.epId, ahlt.jdField_a_of_type_Asre.a.eId);
    this.jdField_a_of_type_Ahlt.h(ahlt.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahly
 * JD-Core Version:    0.7.0.1
 */