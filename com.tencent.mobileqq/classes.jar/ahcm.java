import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class ahcm
  implements awnc<EmoticonPackage>
{
  ahcm(ahch paramahch, int paramInt, ChatMessage paramChatMessage) {}
  
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
      if (this.jdField_a_of_type_Int != 2131365308) {
        break label98;
      }
      adrm.b(this.jdField_a_of_type_Ahch.b, this.jdField_a_of_type_Ahch.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      bcst.b(this.jdField_a_of_type_Ahch.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
    }
    label98:
    do
    {
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131362186)
        {
          this.jdField_a_of_type_Ahch.a(paramEmoticonPackage, str, i);
          return;
        }
        if ((this.jdField_a_of_type_Int == 2131367044) || (this.jdField_a_of_type_Int == 2131366752))
        {
          this.jdField_a_of_type_Ahch.a(paramEmoticonPackage, str, i, this.jdField_a_of_type_Int);
          return;
        }
      } while (this.jdField_a_of_type_Int != 2131371379);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 4, "marketface related click");
      }
    } while ((ahch.jdField_a_of_type_Asbq == null) || (ahch.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (ahch.jdField_a_of_type_Asbq.a == null));
    bcst.b(this.jdField_a_of_type_Ahch.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Ahch.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B115", "0X800B115", arze.a(this.jdField_a_of_type_Ahch.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "1", "", ahch.jdField_a_of_type_Asbq.a.epId, ahch.jdField_a_of_type_Asbq.a.eId);
    this.jdField_a_of_type_Ahch.h(ahch.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcm
 * JD-Core Version:    0.7.0.1
 */