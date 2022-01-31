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

class afrz
  implements View.OnClickListener
{
  afrz(afry paramafry) {}
  
  public void onClick(View paramView)
  {
    oxp.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
    paramView = (afsa)aekt.a(paramView);
    if (swh.a(paramView.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidContentContext)) {}
    for (;;)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((paramView instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L)) {
          azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
        }
      }
      return;
      if ((paramView.b == null) || (!paramView.b.equals("open_local"))) {
        break;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("schemaurl", paramView.c);
      ((Bundle)localObject).putString("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      OpenAppClient.b((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Bundle)localObject);
    }
    Object localObject = new Intent(this.a.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject).putExtra("url", paramView.c);
    ((Intent)localObject).putExtra("assignBackText", this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690623));
    ((Intent)localObject).putExtra("puin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("source_name", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    MessageForPubAccount localMessageForPubAccount;
    if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {
        break label449;
      }
    }
    label449:
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if (l >= 0L) {
        ((Intent)localObject).putExtra("msg_id", String.valueOf(l));
      }
      ((Intent)localObject).putExtra("fromAio", true);
      ((Intent)localObject).putExtra("big_brother_source_key", syb.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      syb.a((Intent)localObject, paramView.c);
      this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramView.c, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrz
 * JD-Core Version:    0.7.0.1
 */