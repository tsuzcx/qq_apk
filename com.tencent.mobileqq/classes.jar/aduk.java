import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;

class aduk
  implements askq<EmoticonPackage>
{
  aduk(adue paramadue, int paramInt, ChatMessage paramChatMessage) {}
  
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
      if (this.jdField_a_of_type_Int == 2131364984)
      {
        aanz.b(this.jdField_a_of_type_Adue.b, this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        axqy.b(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      }
      label352:
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131362121)
        {
          localbcqf = adue.a(this.jdField_a_of_type_Adue);
          if (localbcqf != null)
          {
            localbcqf.a(this.jdField_a_of_type_Adue.b.getString(2131692048));
            localbcqf.show();
          }
          adue.a(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adue.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
          axqy.b(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", str, i + "", "");
          QQAppInterface localQQAppInterface;
          if ((adue.jdField_a_of_type_Aobp != null) && (adue.jdField_a_of_type_Aobp.c()))
          {
            localQQAppInterface = this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i = this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            if (adue.jdField_a_of_type_Aobp.a == null) {
              break label352;
            }
          }
          for (str = adue.jdField_a_of_type_Aobp.a.epId;; str = "")
          {
            askf.a(localQQAppInterface, "0X800A939", i, str);
            if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
              break label392;
            }
            i = this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            int j = (int)(System.currentTimeMillis() / 1000L);
            if ((j - i <= 86400) && (j >= i)) {
              break;
            }
            adue.a(this.jdField_a_of_type_Adue, 6);
            return;
          }
          adue.a(6, this.jdField_a_of_type_Adue.b, this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, adue.jdField_a_of_type_Aobp, this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbcqf);
          return;
          adue.a(this.jdField_a_of_type_Adue, 6);
          return;
        }
      } while ((this.jdField_a_of_type_Int != 2131366648) && (this.jdField_a_of_type_Int != 2131366377));
      label392:
      bcqf localbcqf = adue.a(this.jdField_a_of_type_Adue);
      if (this.jdField_a_of_type_Int == 2131366648)
      {
        axqy.b(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", str, i + "", "");
        if ((2 == adue.jdField_a_of_type_Aobp.a.jobType) && (!this.jdField_a_of_type_Adue.jdField_a_of_type_Anvx.c()))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Adue.b, 2131689992, 0);
          return;
        }
        adue.c = 1;
        adue.a(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adue.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
        str = this.jdField_a_of_type_Adue.b.getString(2131692051);
      }
      for (i = 7;; i = 107)
      {
        if (localbcqf != null)
        {
          localbcqf.a(str);
          localbcqf.show();
        }
        if (paramEmoticonPackage != null) {
          break;
        }
        adue.a(this.jdField_a_of_type_Adue, i);
        return;
        axqy.b(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
        if ((this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((baky)this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Adue.b, 2131697657, 0);
          return;
        }
        str = this.jdField_a_of_type_Adue.b.getString(2131692050);
        axqy.b(this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", adue.jdField_a_of_type_Aobp.a.epId, "", "");
      }
      adue.a(i, this.jdField_a_of_type_Adue.b, this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, adue.jdField_a_of_type_Aobp, this.jdField_a_of_type_Adue.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbcqf);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aduk
 * JD-Core Version:    0.7.0.1
 */