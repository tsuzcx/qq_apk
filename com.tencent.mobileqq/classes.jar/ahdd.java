import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class ahdd
  implements View.OnClickListener
{
  ahdd(ahdc paramahdc) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    this.a.jdField_a_of_type_Ahcz.f.setVisibility(8);
    if (this.a.jdField_a_of_type_Ahcz.f.getChildCount() > 0) {
      this.a.jdField_a_of_type_Ahcz.f.removeAllViews();
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))) {}
    while (!(paramView.getTag() instanceof Integer))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    akfd.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = ((Integer)paramView.getTag()).intValue();
    Object localObject = akcv.a().a(i);
    localObject = "，" + (String)localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setText((CharSequence)localObject);
    localObject = ContactUtils.getMemberDisplaynameByIstroop(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
    String str1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin;
    XEditTextEx localXEditTextEx = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType == 1) {}
    for (;;)
    {
      localObject = bevq.a(localQQAppInterface, localContext, str1, str2, (String)localObject, false, localXEditTextEx, bool);
      if ((localObject != null) && (((SpannableString)localObject).length() != 0)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getEditableText().insert(0, (CharSequence)localObject);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.length());
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdd
 * JD-Core Version:    0.7.0.1
 */