import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;

class afvm
  implements aufy<EmoticonPackage>
{
  afvm(afvg paramafvg, int paramInt, ChatMessage paramChatMessage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    String str = "0";
    int i;
    if (paramEmoticonPackage != null)
    {
      str = paramEmoticonPackage.epId;
      if ((3 == paramEmoticonPackage.jobType) || (5 == paramEmoticonPackage.jobType)) {
        i = 2;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 2131365071)
      {
        acjm.b(this.jdField_a_of_type_Afvg.b, this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        azqs.b(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      }
      label352:
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131362126)
        {
          localbety = afvg.a(this.jdField_a_of_type_Afvg);
          if (localbety != null)
          {
            localbety.a(this.jdField_a_of_type_Afvg.b.getString(2131692104));
            localbety.show();
          }
          afvg.a(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, afvg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
          azqs.b(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", str, i + "", "");
          QQAppInterface localQQAppInterface;
          if ((afvg.jdField_a_of_type_Apxv != null) && (afvg.jdField_a_of_type_Apxv.c()))
          {
            localQQAppInterface = this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i = this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            if (afvg.jdField_a_of_type_Apxv.a == null) {
              break label352;
            }
          }
          for (str = afvg.jdField_a_of_type_Apxv.a.epId;; str = "")
          {
            aufn.a(localQQAppInterface, "0X800A939", i, str);
            if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
              break label392;
            }
            i = this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            int j = (int)(System.currentTimeMillis() / 1000L);
            if ((j - i <= 86400) && (j >= i)) {
              break;
            }
            afvg.a(this.jdField_a_of_type_Afvg, 6);
            return;
          }
          afvg.a(6, this.jdField_a_of_type_Afvg.b, this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, afvg.jdField_a_of_type_Apxv, this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbety);
          return;
          afvg.a(this.jdField_a_of_type_Afvg, 6);
          return;
        }
      } while ((this.jdField_a_of_type_Int != 2131366776) && (this.jdField_a_of_type_Int != 2131366487));
      label392:
      bety localbety = afvg.a(this.jdField_a_of_type_Afvg);
      if (this.jdField_a_of_type_Int == 2131366776)
      {
        azqs.b(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", str, i + "", "");
        if ((2 == afvg.jdField_a_of_type_Apxv.a.jobType) && (!this.jdField_a_of_type_Afvg.jdField_a_of_type_Apro.c()))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Afvg.b, 2131690039, 0);
          return;
        }
        afvg.c = 1;
        afvg.a(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, afvg.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
        str = this.jdField_a_of_type_Afvg.b.getString(2131692107);
      }
      for (i = 7;; i = 107)
      {
        if (localbety != null)
        {
          localbety.a(str);
          localbety.show();
        }
        if (paramEmoticonPackage != null) {
          break;
        }
        afvg.a(this.jdField_a_of_type_Afvg, i);
        return;
        azqs.b(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
        if ((this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bcnu)this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Afvg.b, 2131697834, 0);
          return;
        }
        str = this.jdField_a_of_type_Afvg.b.getString(2131692106);
        azqs.b(this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", afvg.jdField_a_of_type_Apxv.a.epId, "", "");
      }
      afvg.a(i, this.jdField_a_of_type_Afvg.b, this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, afvg.jdField_a_of_type_Apxv, this.jdField_a_of_type_Afvg.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbety);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvm
 * JD-Core Version:    0.7.0.1
 */