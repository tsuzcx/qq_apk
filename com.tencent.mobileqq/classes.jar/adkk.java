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

class adkk
  implements View.OnClickListener
{
  adkk(adkj paramadkj) {}
  
  public void onClick(View paramView)
  {
    ohp.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
    Object localObject = (adkl)aciy.a(paramView);
    long l2 = -1L;
    ChatMessage localChatMessage = ((adkl)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
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
      awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      if (((azhx)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localChatMessage.uniseq)) {
        awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
      }
    }
    nfp localnfp;
    ngh localngh;
    bacn localbacn;
    int i;
    if (TextUtils.isEmpty(((adkl)localObject).f))
    {
      paramView = ((adkl)localObject).e;
      localnfp = (nfp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(88);
      localngh = (ngh)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(88);
      if (TextUtils.isEmpty(paramView)) {
        break label994;
      }
      localbacn = bade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, paramView);
      if (localbacn != null) {
        break label774;
      }
      if (((adkl)localObject).jdField_a_of_type_Long != 0L) {
        break label684;
      }
      i = 0;
      label318:
      if (i == 0) {
        break label718;
      }
      if (adkj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((adkl)localObject).jdField_a_of_type_JavaLangString, ((adkl)localObject).jdField_a_of_type_Long, paramView)) {
        break label689;
      }
      adkj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((adkl)localObject).jdField_a_of_type_JavaLangString, ((adkl)localObject).b, ((adkl)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      label406:
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_32", "singlepic_allclick");
      if ((localChatMessage != null) && (localnfp != null) && (localngh != null) && (localnfp.a(localChatMessage.senderuin))) {
        localngh.a(false, localChatMessage, 1, paramView);
      }
      if ((localChatMessage instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)localChatMessage;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L))
        {
          awqx.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
          if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56) != null) && (((ajoy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (paramView.mPAMessage.items != null) && (paramView.mPAMessage.items.size() > 0))
          {
            localObject = ((PAMessage.Item)paramView.mPAMessage.items.get(0)).title;
            wye.a(paramView.frienduin, "auth_aio", "clk_content", 0, 0, new String[] { "", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, localObject });
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
      paramView = ((adkl)localObject).f;
      break;
      i = 1;
      break label318;
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
      break label406;
      adkj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((adkl)localObject).jdField_a_of_type_JavaLangString, ((adkl)localObject).b, ((adkl)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
      break label406;
      if (TextUtils.isEmpty(localbacn.a()))
      {
        if (!adkj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((adkl)localObject).jdField_a_of_type_JavaLangString, ((adkl)localObject).jdField_a_of_type_Long, paramView))
        {
          adkj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((adkl)localObject).jdField_a_of_type_JavaLangString, ((adkl)localObject).b, ((adkl)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
          break label406;
        }
        PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_34", "singlepic_appclick");
        break label406;
      }
      if (!localbacn.c())
      {
        adkj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((adkl)localObject).jdField_a_of_type_JavaLangString, ((adkl)localObject).b, ((adkl)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
        break label406;
      }
      PublicAccountHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Pb_account_lifeservice", "mp_msg_sys_33", "singlepic_mqqclick");
      break label406;
      adkj.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ((adkl)localObject).jdField_a_of_type_JavaLangString, ((adkl)localObject).b, ((adkl)localObject).c, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, l1);
    } while ((localChatMessage == null) || (localnfp == null) || (localngh == null) || (!localnfp.a(localChatMessage.senderuin)));
    label774:
    localngh.a(false, localChatMessage, 1, ((adkl)localObject).c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkk
 * JD-Core Version:    0.7.0.1
 */