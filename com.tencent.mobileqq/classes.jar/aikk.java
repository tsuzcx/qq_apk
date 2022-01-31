import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.subaccount.logic.SubAccountThirdQQBackProtocData;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog;
import com.tencent.mobileqq.widget.LeftPopupMenuDialog.MenuItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import java.util.Iterator;
import java.util.List;

public class aikk
  extends MessageObserver
{
  public aikk(AssociatedAccountOptPopBar paramAssociatedAccountOptPopBar) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountThirdQQBackProtocData paramSubAccountThirdQQBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onSubAccountThirdQQUnreadMsgNum success = " + paramBoolean + "  mainAccount = " + paramString + "  data = " + paramSubAccountThirdQQBackProtocData + " mIsFirstRequest=" + this.a.jdField_a_of_type_Boolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) || (this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.isShowing()) || (paramSubAccountThirdQQBackProtocData == null) || (!TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()))) {}
    do
    {
      do
      {
        return;
        if (!this.a.jdField_a_of_type_Boolean) {
          break;
        }
        if (paramBoolean) {
          this.a.b = true;
        }
        if (this.a.jdField_a_of_type_Int > 0)
        {
          paramString = this.a;
          paramString.jdField_a_of_type_Int -= 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountOptPopBar", 2, "onSubAccountThirdQQUnreadMsgNum() mRequestNum = " + this.a.jdField_a_of_type_Int);
        }
      } while (this.a.jdField_a_of_type_Int != 0);
      if (this.a.b)
      {
        AssociatedAccountOptPopBar.a(this.a);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a(this.a.jdField_a_of_type_JavaUtilList);
        this.a.b = false;
      }
      this.a.jdField_a_of_type_Boolean = false;
      return;
    } while (!paramBoolean);
    paramString = this.a.jdField_a_of_type_JavaUtilList.iterator();
    label320:
    Object localObject;
    DragTextView localDragTextView;
    while (paramString.hasNext())
    {
      paramSubAccountThirdQQBackProtocData = (LeftPopupMenuDialog.MenuItem)paramString.next();
      if ((paramSubAccountThirdQQBackProtocData != null) && (paramSubAccountThirdQQBackProtocData.a != null) && ((paramSubAccountThirdQQBackProtocData.a instanceof SimpleAccount)))
      {
        localObject = (SimpleAccount)paramSubAccountThirdQQBackProtocData.a;
        int i = SubAccountControll.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, ((SimpleAccount)localObject).getUin());
        if (i != paramSubAccountThirdQQBackProtocData.b)
        {
          paramSubAccountThirdQQBackProtocData.b = i;
          localObject = AssociatedAccountOptPopBar.a(this.a, ((SimpleAccount)localObject).getUin());
          if (localObject != null)
          {
            localDragTextView = (DragTextView)((View)localObject).findViewById(2131363207);
            if ((localDragTextView != null) && (paramSubAccountThirdQQBackProtocData != null))
            {
              if (paramSubAccountThirdQQBackProtocData.b <= 0) {
                break label479;
              }
              CustomWidgetUtil.a(localDragTextView, 3, paramSubAccountThirdQQBackProtocData.b, 2130846056, 99, null);
            }
          }
        }
      }
    }
    for (;;)
    {
      AssociatedAccountOptPopBar.a(this.a, (View)localObject, paramSubAccountThirdQQBackProtocData);
      break label320;
      break;
      label479:
      localDragTextView.setVisibility(8);
    }
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "onGetSubAccountMsg() return, subAccount=" + paramString + "  mIsFirstRequest=" + this.a.jdField_a_of_type_Boolean);
    }
    if ((paramString == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app == null) || (this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.isShowing()) || (paramSubAccountBackProtocData == null) || (!TextUtils.equals(paramSubAccountBackProtocData.b, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.c()))) {}
    LeftPopupMenuDialog.MenuItem localMenuItem;
    DragTextView localDragTextView;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!this.a.jdField_a_of_type_Boolean) {
              break;
            }
            if (paramBoolean) {
              this.a.b = true;
            }
            if (this.a.jdField_a_of_type_Int > 0)
            {
              paramString = this.a;
              paramString.jdField_a_of_type_Int -= 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountOptPopBar", 2, "onGetSubAccountMsg() mRequestNum=" + this.a.jdField_a_of_type_Int);
            }
          } while (this.a.jdField_a_of_type_Int != 0);
          if (this.a.b)
          {
            AssociatedAccountOptPopBar.a(this.a);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetLeftPopupMenuDialog.a(this.a.jdField_a_of_type_JavaUtilList);
            this.a.b = false;
          }
          this.a.jdField_a_of_type_Boolean = false;
          return;
        } while (!paramBoolean);
        paramSubAccountBackProtocData = AssociatedAccountOptPopBar.a(this.a, paramString);
      } while (paramSubAccountBackProtocData == null);
      localMenuItem = (LeftPopupMenuDialog.MenuItem)paramSubAccountBackProtocData.getTag();
      localDragTextView = (DragTextView)paramSubAccountBackProtocData.findViewById(2131363207);
    } while ((localDragTextView == null) || (localMenuItem == null));
    localMenuItem.b = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.a().a().a(paramString, 7000);
    if (localMenuItem.b > 0) {
      CustomWidgetUtil.a(localDragTextView, 3, localMenuItem.b, 2130846055, 99, null);
    }
    for (;;)
    {
      AssociatedAccountOptPopBar.a(this.a, paramSubAccountBackProtocData, localMenuItem);
      return;
      localDragTextView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikk
 * JD-Core Version:    0.7.0.1
 */