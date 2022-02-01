import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.qphone.base.util.QLog;

class agil
  implements avtb<EmoticonPackage>
{
  agil(agif paramagif, int paramInt, ChatMessage paramChatMessage) {}
  
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
      if (this.jdField_a_of_type_Int != 2131365382) {
        break label98;
      }
      acvv.b(this.jdField_a_of_type_Agif.b, this.jdField_a_of_type_Agif.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      bcef.b(this.jdField_a_of_type_Agif.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
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
          this.jdField_a_of_type_Agif.a(paramEmoticonPackage, str, i);
          return;
        }
        if ((this.jdField_a_of_type_Int == 2131367111) || (this.jdField_a_of_type_Int == 2131366827))
        {
          this.jdField_a_of_type_Agif.a(paramEmoticonPackage, str, i, this.jdField_a_of_type_Int);
          return;
        }
      } while (this.jdField_a_of_type_Int != 2131371454);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 4, "marketface related click");
      }
    } while ((agif.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (agif.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (agif.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null));
    bcef.b(this.jdField_a_of_type_Agif.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_Agif.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, "0X800B115", "0X800B115", EmoticonUtils.getRelatedEmotionReportFromType(this.jdField_a_of_type_Agif.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, "1", "", agif.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, agif.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
    this.jdField_a_of_type_Agif.h(agif.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agil
 * JD-Core Version:    0.7.0.1
 */