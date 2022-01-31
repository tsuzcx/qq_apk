import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.widget.XEditTextEx;

class aelp
  implements View.OnClickListener
{
  aelp(aelo paramaelo) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    this.a.jdField_a_of_type_Aell.f.setVisibility(8);
    if (this.a.jdField_a_of_type_Aell.f.getChildCount() > 0) {
      this.a.jdField_a_of_type_Aell.f.removeAllViews();
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    while (!(paramView.getTag() instanceof Integer)) {
      return;
    }
    ahfj.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = ahdd.a().a(i);
    paramView = "，" + paramView;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramView);
    paramView = bbcl.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.istroop, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
    String str1 = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin;
    XEditTextEx localXEditTextEx = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
    for (;;)
    {
      paramView = bafh.a(localQQAppInterface, localContext, str1, str2, paramView, false, localXEditTextEx, bool);
      if ((paramView != null) && (paramView.length() != 0)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, paramView);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.length());
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelp
 * JD-Core Version:    0.7.0.1
 */