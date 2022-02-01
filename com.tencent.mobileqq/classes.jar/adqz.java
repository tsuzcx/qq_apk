import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

public final class adqz
  implements binu
{
  public adqz(adrh paramadrh, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Activity paramActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Adrh != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Adrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
        this.jdField_a_of_type_Adrh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      }
      this.jdField_a_of_type_Adrh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      this.jdField_a_of_type_Adrh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    }
    paramDialog = new StringBuilder();
    paramView = (anzc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    paramView.a(this.jdField_a_of_type_JavaLangString);
    int i = paramView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramDialog);
    if ((paramDialog != null) && (paramDialog.length() > 0)) {}
    for (paramDialog = paramDialog.toString();; paramDialog = null)
    {
      if (i <= 0)
      {
        QQToast.a(BaseApplication.getContext(), 2, 2131691452, 1).a();
        if (this.jdField_a_of_type_Adrh != null) {
          this.jdField_a_of_type_Adrh.a(this.jdField_a_of_type_AndroidAppActivity);
        }
        return;
      }
      List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getMsgList(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      long l1;
      if ((localList != null) && (!localList.isEmpty())) {
        if (((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
          {
            FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, false);
          }
          for (;;)
          {
            ancb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history_c2c_start_del_msg");
            if (!paramBoolean) {
              break label433;
            }
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
              break label395;
            }
            QQToast.a(BaseApplication.getContext(), 2131691449, 1).a();
            return;
            l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
            break;
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearHistory(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          }
          label395:
          ((anzc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).i();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          paramView.n();
          label433:
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().onCurrentMessageDeleted(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          if (paramDialog != null) {}
          try
          {
            l2 = Long.parseLong(paramDialog);
            l1 = Math.max(l2, l1);
            if (l1 > 0L) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
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
            if (this.jdField_a_of_type_Adrh == null) {
              break;
            }
            this.jdField_a_of_type_Adrh.a(this.jdField_a_of_type_AndroidAppActivity);
            return;
          }
          catch (Exception paramDialog)
          {
            for (;;)
            {
              paramDialog.printStackTrace();
              long l2 = 0L;
            }
          }
        }
        l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqz
 * JD-Core Version:    0.7.0.1
 */