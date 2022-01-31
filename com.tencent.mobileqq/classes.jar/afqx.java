import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;

class afqx
  implements aubp<EmoticonPackage>
{
  afqx(afqr paramafqr, int paramInt, ChatMessage paramChatMessage) {}
  
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
      if (this.jdField_a_of_type_Int == 2131365069)
      {
        acex.b(this.jdField_a_of_type_Afqr.b, this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        azmj.b(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      }
      label352:
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131362126)
        {
          localbepp = afqr.a(this.jdField_a_of_type_Afqr);
          if (localbepp != null)
          {
            localbepp.a(this.jdField_a_of_type_Afqr.b.getString(2131692103));
            localbepp.show();
          }
          afqr.a(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, afqr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
          azmj.b(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", str, i + "", "");
          QQAppInterface localQQAppInterface;
          if ((afqr.jdField_a_of_type_Aptm != null) && (afqr.jdField_a_of_type_Aptm.c()))
          {
            localQQAppInterface = this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i = this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            if (afqr.jdField_a_of_type_Aptm.a == null) {
              break label352;
            }
          }
          for (str = afqr.jdField_a_of_type_Aptm.a.epId;; str = "")
          {
            aube.a(localQQAppInterface, "0X800A939", i, str);
            if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
              break label392;
            }
            i = this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            int j = (int)(System.currentTimeMillis() / 1000L);
            if ((j - i <= 86400) && (j >= i)) {
              break;
            }
            afqr.a(this.jdField_a_of_type_Afqr, 6);
            return;
          }
          afqr.a(6, this.jdField_a_of_type_Afqr.b, this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, afqr.jdField_a_of_type_Aptm, this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbepp);
          return;
          afqr.a(this.jdField_a_of_type_Afqr, 6);
          return;
        }
      } while ((this.jdField_a_of_type_Int != 2131366766) && (this.jdField_a_of_type_Int != 2131366481));
      label392:
      bepp localbepp = afqr.a(this.jdField_a_of_type_Afqr);
      if (this.jdField_a_of_type_Int == 2131366766)
      {
        azmj.b(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", str, i + "", "");
        if ((2 == afqr.jdField_a_of_type_Aptm.a.jobType) && (!this.jdField_a_of_type_Afqr.jdField_a_of_type_Apnf.c()))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Afqr.b, 2131690039, 0);
          return;
        }
        afqr.c = 1;
        afqr.a(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, afqr.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
        str = this.jdField_a_of_type_Afqr.b.getString(2131692106);
      }
      for (i = 7;; i = 107)
      {
        if (localbepp != null)
        {
          localbepp.a(str);
          localbepp.show();
        }
        if (paramEmoticonPackage != null) {
          break;
        }
        afqr.a(this.jdField_a_of_type_Afqr, i);
        return;
        azmj.b(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
        if ((this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bcjl)this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Afqr.b, 2131697832, 0);
          return;
        }
        str = this.jdField_a_of_type_Afqr.b.getString(2131692105);
        azmj.b(this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", afqr.jdField_a_of_type_Aptm.a.epId, "", "");
      }
      afqr.a(i, this.jdField_a_of_type_Afqr.b, this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, afqr.jdField_a_of_type_Aptm, this.jdField_a_of_type_Afqr.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbepp);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afqx
 * JD-Core Version:    0.7.0.1
 */