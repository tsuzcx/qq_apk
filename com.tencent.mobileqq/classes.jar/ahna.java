import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahna
  implements View.OnClickListener
{
  ahna(ahmz paramahmz) {}
  
  public void onClick(View paramView)
  {
    pfs.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
    Object localObject1 = (ahnb)agej.a(paramView);
    if (txr.a(((ahnb)localObject1).jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidContentContext)) {}
    for (;;)
    {
      localObject1 = ((ahnb)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localObject1 instanceof MessageForPubAccount))
      {
        localObject1 = (MessageForPubAccount)localObject1;
        if ((((MessageForPubAccount)localObject1).mPAMessage != null) && (((MessageForPubAccount)localObject1).mPAMessage.mMsgId > 0L)) {
          bdll.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", ((MessageForPubAccount)localObject1).frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(((MessageForPubAccount)localObject1).mPAMessage.mMsgId), "", "", "");
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((((ahnb)localObject1).b == null) || (!((ahnb)localObject1).b.equals("open_local"))) {
        break;
      }
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("schemaurl", ((ahnb)localObject1).c);
      ((Bundle)localObject2).putString("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      OpenAppClient.b((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Bundle)localObject2);
    }
    Object localObject2 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    ((Intent)localObject2).putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("url", ((ahnb)localObject1).c);
    ((Intent)localObject2).putExtra("assignBackText", this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690559));
    ((Intent)localObject2).putExtra("puin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("source_name", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    MessageForPubAccount localMessageForPubAccount;
    if ((((ahnb)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)((ahnb)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {
        break label475;
      }
    }
    label475:
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if (l >= 0L) {
        ((Intent)localObject2).putExtra("msg_id", String.valueOf(l));
      }
      ((Intent)localObject2).putExtra("fromAio", true);
      ((Intent)localObject2).putExtra("big_brother_source_key", tzq.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      tzq.a((Intent)localObject2, ((ahnb)localObject1).c);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      bdll.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, ((ahnb)localObject1).c, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahna
 * JD-Core Version:    0.7.0.1
 */