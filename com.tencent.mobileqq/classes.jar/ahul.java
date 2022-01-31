import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemButton;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class ahul
  implements Runnable
{
  ahul(ahuj paramahuj, StructMsgItemButton paramStructMsgItemButton, StructMsgForGeneralShare paramStructMsgForGeneralShare, QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTime();
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemButton.s)) {}
    try
    {
      i = Integer.parseInt(this.jdField_a_of_type_Ahuj.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemButton.s);
      if (PublicAccountChatPie.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        j = 1;
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, "0X80055C8", "0X80055C8", i, 0, Long.toString(l), Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId), this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemButton.c, Integer.toString(j), false);
        j = 0;
        if (this.jdField_a_of_type_Boolean) {
          j = 1;
        }
        Object localObject1 = new StringBuilder().append("MSGID=").append(Long.toString(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(AbsStructMsgElement.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemButton.b));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin, "0X8005D4A", "0X8005D4A", i, j, ((StringBuilder)localObject1).toString(), "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message == null) {}
        String str;
        do
        {
          do
          {
            return;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_msgClick");
          } while (TextUtils.isEmpty((CharSequence)localObject1));
          Object localObject2 = new JSONObject();
          try
          {
            ((JSONObject)localObject2).put("puin", this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.uin);
            ((JSONObject)localObject2).put("index", Long.toString(i));
            ((JSONObject)localObject2).put("gdt_cli_data", localObject1);
            new ArrayList().add(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.msgId));
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_singleAd");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_mulAd");
            str = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.getExtInfoFromExtStr("gdt_followAd");
            if (((String)localObject1).equals("1")) {
              return;
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
            if (((String)localObject2).equals("1")) {
              return;
            }
          }
        } while (!str.equals("1"));
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahul
 * JD-Core Version:    0.7.0.1
 */