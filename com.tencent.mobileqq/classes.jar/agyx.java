import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.phone.PhoneNumberInfo;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.qcall.LightalkShieldData;
import com.tencent.mobileqq.qcall.LightalkShieldHandler;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

public class agyx
  implements ActionSheet.OnButtonClickListener
{
  public agyx(QCallDetailActivity paramQCallDetailActivity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).a(2131433117, 1);
        return;
      }
      if (QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity) == 26)
      {
        paramView = PhoneNumberUtil.a(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity));
        paramView = paramView.a + "-" + paramView.c;
        if (this.jdField_a_of_type_Boolean) {
          QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).b(20, paramView);
        }
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label802;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8004E6F", "0X8004E6F", 0, 0, "", "", "", "");
        break;
        QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).a(20, paramView);
        continue;
        paramInt = 0;
        long l;
        Object localObject;
        try
        {
          Long.parseLong(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity));
          if (!this.b) {
            break label393;
          }
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            try
            {
              l = Long.parseLong(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity));
              if (!this.jdField_a_of_type_Boolean) {
                break label359;
              }
              if (this.c) {
                break label325;
              }
              paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 0);
              paramView.setTitle(2131437828);
              paramView.setMessage(2131437829);
              paramView.setCanceledOnTouchOutside(false);
              localObject = new agyy(this, paramView, l);
              paramView.setNegativeButton(2131437831, (DialogInterface.OnClickListener)localObject);
              paramView.setPositiveButton(2131437830, (DialogInterface.OnClickListener)localObject);
              paramView.show();
            }
            catch (Exception paramView)
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 1, "无效的号码", 0).b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getTitleBarHeight());
            }
            paramView = paramView;
            paramInt = 1;
          }
        }
        break;
        label325:
        paramView = QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
        if (!this.jdField_a_of_type_Boolean) {}
        for (boolean bool = true;; bool = false)
        {
          paramView.a(l, bool);
          break;
        }
        label359:
        paramView = QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
        if (!this.jdField_a_of_type_Boolean) {}
        for (bool = true;; bool = false)
        {
          paramView.a(l, bool);
          break;
        }
        label393:
        label783:
        if (paramInt != 0)
        {
          paramView = new LightalkShieldData();
          paramView.qcallId = UinUtils.a(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity));
          paramView.phone = QCallDetailActivity.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity);
          if (this.jdField_a_of_type_Boolean)
          {
            if (!this.c)
            {
              paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 0);
              paramView.setTitle(2131437828);
              paramView.setMessage(2131437829);
              paramView.setCanceledOnTouchOutside(false);
              localObject = new agyz(this, paramView);
              paramView.setNegativeButton(2131437831, (DialogInterface.OnClickListener)localObject);
              paramView.setPositiveButton(2131437830, (DialogInterface.OnClickListener)localObject);
              paramView.show();
            }
            else
            {
              QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).b(10, UinUtils.a(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity)));
              ReportController.b(null, "CliOper", "", "", "0X8006256", "0X8006256", 0, 0, "", "", "", "");
            }
          }
          else
          {
            QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity).a(10, UinUtils.a(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity)));
            ReportController.b(null, "CliOper", "", "", "0X8006256", "0X8006256", 1, 0, "", "", "", "");
          }
        }
        else
        {
          ArrayList localArrayList;
          try
          {
            l = Long.parseLong(QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity));
            localObject = (ShieldMsgManger)this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app.getManager(15);
            localArrayList = new ArrayList();
            if (localObject != null) {
              localArrayList.add(Long.valueOf(l));
            }
            if (!this.jdField_a_of_type_Boolean) {
              break label783;
            }
            if (this.c) {
              break label764;
            }
            paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 0);
            paramView.setTitle(2131437828);
            paramView.setMessage(2131437829);
            paramView.setCanceledOnTouchOutside(false);
            localObject = new agza(this, paramView, (ShieldMsgManger)localObject, localArrayList);
            paramView.setNegativeButton(2131437831, (DialogInterface.OnClickListener)localObject);
            paramView.setPositiveButton(2131437830, (DialogInterface.OnClickListener)localObject);
            paramView.show();
          }
          catch (Exception paramView)
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 1, "无效的号码", 0).b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.getTitleBarHeight());
          }
          break;
          label764:
          if (localObject != null)
          {
            ((ShieldMsgManger)localObject).b(this.jdField_a_of_type_Int, localArrayList);
            continue;
            if (localObject != null) {
              ((ShieldMsgManger)localObject).a(this.jdField_a_of_type_Int, localArrayList);
            }
          }
        }
      }
      label802:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8004E6E", "0X8004E6E", 0, 0, "", "", "", "");
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app, "CliOper", "", "", "0X8004FA9", "0X8004FA9", 0, 0, "", "", "", "");
      ReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity, 410, "", QCallDetailActivity.a(this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity), this.jdField_a_of_type_ComTencentMobileqqQcallQCallDetailActivity.app.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agyx
 * JD-Core Version:    0.7.0.1
 */