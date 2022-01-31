import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;

class adum
  implements asko<EmoticonPackage>
{
  adum(adug paramadug, int paramInt, ChatMessage paramChatMessage) {}
  
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
      if (this.jdField_a_of_type_Int == 2131364985)
      {
        aaod.b(this.jdField_a_of_type_Adug.b, this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        axqw.b(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      }
      label352:
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131362122)
        {
          localbcpq = adug.a(this.jdField_a_of_type_Adug);
          if (localbcpq != null)
          {
            localbcpq.a(this.jdField_a_of_type_Adug.b.getString(2131692048));
            localbcpq.show();
          }
          adug.a(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adug.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
          axqw.b(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", str, i + "", "");
          QQAppInterface localQQAppInterface;
          if ((adug.jdField_a_of_type_Aobk != null) && (adug.jdField_a_of_type_Aobk.c()))
          {
            localQQAppInterface = this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i = this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            if (adug.jdField_a_of_type_Aobk.a == null) {
              break label352;
            }
          }
          for (str = adug.jdField_a_of_type_Aobk.a.epId;; str = "")
          {
            askd.a(localQQAppInterface, "0X800A939", i, str);
            if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
              break label392;
            }
            i = this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            int j = (int)(System.currentTimeMillis() / 1000L);
            if ((j - i <= 86400) && (j >= i)) {
              break;
            }
            adug.a(this.jdField_a_of_type_Adug, 6);
            return;
          }
          adug.a(6, this.jdField_a_of_type_Adug.b, this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, adug.jdField_a_of_type_Aobk, this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbcpq);
          return;
          adug.a(this.jdField_a_of_type_Adug, 6);
          return;
        }
      } while ((this.jdField_a_of_type_Int != 2131366648) && (this.jdField_a_of_type_Int != 2131366377));
      label392:
      bcpq localbcpq = adug.a(this.jdField_a_of_type_Adug);
      if (this.jdField_a_of_type_Int == 2131366648)
      {
        axqw.b(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", str, i + "", "");
        if ((2 == adug.jdField_a_of_type_Aobk.a.jobType) && (!this.jdField_a_of_type_Adug.jdField_a_of_type_Anvs.c()))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Adug.b, 2131689992, 0);
          return;
        }
        adug.c = 1;
        adug.a(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adug.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
        str = this.jdField_a_of_type_Adug.b.getString(2131692051);
      }
      for (i = 7;; i = 107)
      {
        if (localbcpq != null)
        {
          localbcpq.a(str);
          localbcpq.show();
        }
        if (paramEmoticonPackage != null) {
          break;
        }
        adug.a(this.jdField_a_of_type_Adug, i);
        return;
        axqw.b(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
        if ((this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((bakk)this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Adug.b, 2131697656, 0);
          return;
        }
        str = this.jdField_a_of_type_Adug.b.getString(2131692050);
        axqw.b(this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", adug.jdField_a_of_type_Aobk.a.epId, "", "");
      }
      adug.a(i, this.jdField_a_of_type_Adug.b, this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, adug.jdField_a_of_type_Aobk, this.jdField_a_of_type_Adug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbcpq);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adum
 * JD-Core Version:    0.7.0.1
 */