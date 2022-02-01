import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

public final class adwc
  implements bhwc
{
  public adwc(adwk paramadwk, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Activity paramActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Adwk != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Adwk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
        this.jdField_a_of_type_Adwk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      }
      this.jdField_a_of_type_Adwk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      this.jdField_a_of_type_Adwk.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    }
    paramDialog = new StringBuilder();
    paramView = (anqg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    paramView.a(this.jdField_a_of_type_JavaLangString);
    int i = paramView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramDialog);
    if ((paramDialog != null) && (paramDialog.length() > 0)) {}
    for (paramDialog = paramDialog.toString();; paramDialog = null)
    {
      if (i <= 0)
      {
        QQToast.a(BaseApplication.getContext(), 2, 2131691324, 1).a();
        if (this.jdField_a_of_type_Adwk != null) {
          this.jdField_a_of_type_Adwk.a(this.jdField_a_of_type_AndroidAppActivity);
        }
      }
      label356:
      do
      {
        return;
        long l2 = 0L;
        List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        long l1 = l2;
        if (localList != null)
        {
          l1 = l2;
          if (!localList.isEmpty())
          {
            if (!((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {
              break label356;
            }
            l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;
          }
        }
        if (FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
        {
          FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, false);
        }
        for (;;)
        {
          amuf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history_c2c_start_del_msg");
          if (!paramBoolean) {
            break label442;
          }
          if (bgnt.d(BaseApplication.getContext())) {
            break label405;
          }
          QQToast.a(BaseApplication.getContext(), 2131691321, 1).a();
          return;
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        }
        ((anqg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92)).i();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        paramView.n();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        if (paramDialog != null) {
          l2 = 0L;
        }
        try
        {
          long l3 = Long.parseLong(paramDialog);
          l2 = l3;
        }
        catch (Exception paramDialog)
        {
          for (;;)
          {
            paramDialog.printStackTrace();
          }
        }
        l1 = Math.max(l2, l1);
        if (l1 > 0L) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
        }
        paramView.a().c();
        paramView.b();
        if (paramBoolean) {
          paramView.n();
        }
        paramDialog = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        if (paramDialog != null)
        {
          paramView = paramDialog.obtainMessage(1017);
          paramView.obj = this.jdField_a_of_type_JavaLangString;
          paramView.arg1 = this.jdField_a_of_type_Int;
          paramDialog.sendMessage(paramView);
        }
      } while (this.jdField_a_of_type_Adwk == null);
      label405:
      label442:
      this.jdField_a_of_type_Adwk.a(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwc
 * JD-Core Version:    0.7.0.1
 */