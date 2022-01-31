import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;

class adjn
  implements arok<EmoticonPackage>
{
  adjn(adje paramadje, int paramInt, ChatMessage paramChatMessage) {}
  
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
      if (this.jdField_a_of_type_Int == 2131299417)
      {
        aael.b(this.jdField_a_of_type_Adje.b, this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        awqx.b(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      }
      label352:
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131296581)
        {
          localbbms = adje.a(this.jdField_a_of_type_Adje);
          if (localbbms != null)
          {
            localbbms.a(this.jdField_a_of_type_Adje.b.getString(2131626462));
            localbbms.show();
          }
          adje.a(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adje.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect", 0);
          awqx.b(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", str, i + "", "");
          QQAppInterface localQQAppInterface;
          if ((adje.jdField_a_of_type_Anla != null) && (adje.jdField_a_of_type_Anla.c()))
          {
            localQQAppInterface = this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i = this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            if (adje.jdField_a_of_type_Anla.a == null) {
              break label352;
            }
          }
          for (str = adje.jdField_a_of_type_Anla.a.epId;; str = "")
          {
            arnz.a(localQQAppInterface, "0X800A939", i, str);
            if ((paramEmoticonPackage == null) || (paramEmoticonPackage.name == null) || ((paramEmoticonPackage.mobileFeetype == 0) && (paramEmoticonPackage.downloadCount == 0))) {
              break label392;
            }
            i = this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
            int j = (int)(System.currentTimeMillis() / 1000L);
            if ((j - i <= 86400) && (j >= i)) {
              break;
            }
            adje.a(this.jdField_a_of_type_Adje, 6);
            return;
          }
          adje.a(6, this.jdField_a_of_type_Adje.b, this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, adje.jdField_a_of_type_Anla, this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbbms);
          return;
          adje.a(this.jdField_a_of_type_Adje, 6);
          return;
        }
      } while ((this.jdField_a_of_type_Int != 2131301037) && (this.jdField_a_of_type_Int != 2131300766));
      label392:
      bbms localbbms = adje.a(this.jdField_a_of_type_Adje);
      if (this.jdField_a_of_type_Int == 2131301037)
      {
        awqx.b(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "aio_trans_bq", 0, 0, "4", str, i + "", "");
        if ((2 == adje.jdField_a_of_type_Anla.a.jobType) && (!this.jdField_a_of_type_Adje.jdField_a_of_type_Anfj.c()))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Adje.b, 2131624440, 0);
          return;
        }
        adje.c = 1;
        adje.a(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, adje.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_button_forward_aio", 0);
        str = this.jdField_a_of_type_Adje.b.getString(2131626465);
      }
      for (i = 7;; i = 107)
      {
        if (localbbms != null)
        {
          localbbms.a(str);
          localbbms.show();
        }
        if (paramEmoticonPackage != null) {
          break;
        }
        adje.a(this.jdField_a_of_type_Adje, i);
        return;
        awqx.b(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006449", "0X8006449", 0, 0, "4", "", "", "");
        if ((this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (((azjh)this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48)).a(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true).a))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Adje.b, 2131631942, 0);
          return;
        }
        str = this.jdField_a_of_type_Adje.b.getString(2131626464);
        awqx.b(this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "ep_mall", "Clk_button_follow_aio", 0, 0, "", adje.jdField_a_of_type_Anla.a.epId, "", "");
      }
      adje.a(i, this.jdField_a_of_type_Adje.b, this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEmoticonPackage, adje.jdField_a_of_type_Anla, this.jdField_a_of_type_Adje.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localbbms);
      return;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjn
 * JD-Core Version:    0.7.0.1
 */