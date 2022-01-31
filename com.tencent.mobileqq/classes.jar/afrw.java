import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import java.util.ArrayList;

class afrw
  implements View.OnClickListener
{
  afrw(afrv paramafrv) {}
  
  public void onClick(View paramView)
  {
    oxp.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
    Object localObject = (afrx)aekt.a(paramView);
    long l2 = -1L;
    ChatMessage localChatMessage = ((afrx)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    long l1 = l2;
    if ((localChatMessage instanceof MessageForPubAccount))
    {
      paramView = (MessageForPubAccount)localChatMessage;
      l1 = l2;
      if (paramView.mPAMessage != null)
      {
        l1 = l2;
        if (paramView.mPAMessage.mMsgId > 0L) {
          l1 = paramView.mPAMessage.mMsgId;
        }
      }
    }
    if (((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface)) && (localChatMessage.istroop == 1))
    {
      azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      if (((bcic)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localChatMessage.uniseq)) {
        azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    ntw localntw;
    nup localnup;
    bddb localbddb;
    int i;
    if (TextUtils.isEmpty(((afrx)localObject).f))
    {
      paramView = ((afrx)localObject).e;
      localntw = (ntw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      localnup = (nup)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (TextUtils.isEmpty(paramView)) {
        break label994;
      }
      localbddb = bdds.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramView);
      if (localbddb != null) {
        break label774;
      }
      if (((afrx)localObject).jdField_a_of_type_Long != 0L) {
        break label684;
      }
      i = 0;
      label318:
      if (i == 0) {
        break label718;
      }
      if (afrv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((afrx)localObject).jdField_a_of_type_JavaLangString, ((afrx)localObject).jdField_a_of_type_Long, paramView)) {
        break label689;
      }
      afrv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((afrx)localObject).jdField_a_of_type_JavaLangString, ((afrx)localObject).b, ((afrx)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      label406:
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
      if ((localChatMessage != null) && (localntw != null) && (localnup != null) && (localntw.a(localChatMessage.senderuin))) {
        localnup.a(false, localChatMessage, 1, paramView);
      }
      if ((localChatMessage instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)localChatMessage;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L))
        {
          azmj.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((aluw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramView.mPAMessage.items != null) && (paramView.mPAMessage.items.size() > 0))
          {
            localObject = ((PAMessage.Item)paramView.mPAMessage.items.get(0)).title;
            yvu.a(paramView.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localObject });
          }
        }
      }
    }
    label684:
    label689:
    label718:
    label994:
    do
    {
      return;
      paramView = ((afrx)localObject).f;
      break;
      i = 1;
      break label318;
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
      break label406;
      afrv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((afrx)localObject).jdField_a_of_type_JavaLangString, ((afrx)localObject).b, ((afrx)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      break label406;
      if (TextUtils.isEmpty(localbddb.a()))
      {
        if (!afrv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((afrx)localObject).jdField_a_of_type_JavaLangString, ((afrx)localObject).jdField_a_of_type_Long, paramView))
        {
          afrv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((afrx)localObject).jdField_a_of_type_JavaLangString, ((afrx)localObject).b, ((afrx)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
          break label406;
        }
        PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
        break label406;
      }
      if (!localbddb.c())
      {
        afrv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((afrx)localObject).jdField_a_of_type_JavaLangString, ((afrx)localObject).b, ((afrx)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
        break label406;
      }
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
      break label406;
      afrv.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((afrx)localObject).jdField_a_of_type_JavaLangString, ((afrx)localObject).b, ((afrx)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
    } while ((localChatMessage == null) || (localntw == null) || (localnup == null) || (!localntw.a(localChatMessage.senderuin)));
    label774:
    localnup.a(false, localChatMessage, 1, ((afrx)localObject).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrw
 * JD-Core Version:    0.7.0.1
 */