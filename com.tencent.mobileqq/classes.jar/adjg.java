import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class adjg
  implements View.OnClickListener
{
  public adjg(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131362184)) {
      AssociatedAccountActivity.a(this.a);
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == null) || ((paramView.getTag() instanceof amfr)))
      {
        localObject1 = (amfr)paramView.getTag();
        if ((localObject1 == null) || (((amfr)localObject1).a != null))
        {
          localObject2 = ((amfr)localObject1).a;
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick type = " + ((bdxh)localObject2).jdField_a_of_type_Int);
          }
          switch (((bdxh)localObject2).jdField_a_of_type_Int)
          {
          case 5: 
          default: 
            localObject1 = null;
            label163:
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (azit.a().a(this.a.app, this.a)) && (this.a.c()))
            {
              if (((bdxh)localObject2).jdField_a_of_type_Boolean) {
                break label673;
              }
              if (QLog.isColorLevel()) {
                QLog.d("AssociatedAccountActivity", 2, "onItemClick goto SubAccountUgActivity");
              }
              this.a.jdField_a_of_type_JavaLangString = ((String)localObject1);
              this.a.d = true;
              localObject2 = new Intent("before_account_change");
              this.a.sendBroadcast((Intent)localObject2);
              localObject2 = new Intent(this.a, SubAccountUgActivity.class);
              ((Intent)localObject2).putExtra("subAccount", (String)localObject1);
              ((Intent)localObject2).putExtra("from_associated_activity", true);
              this.a.startActivity((Intent)localObject2);
            }
            break;
          }
        }
      }
    }
    if ((((bdxh)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((bdxh)localObject2).jdField_a_of_type_JavaLangObject instanceof SimpleAccount))) {}
    for (Object localObject1 = ((SimpleAccount)((bdxh)localObject2).jdField_a_of_type_JavaLangObject).getUin();; localObject1 = null)
    {
      bdla.b(this.a.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
      break label163;
      AssociatedAccountActivity.a(this.a);
      bdla.b(this.a.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
      break;
      if ((((bdxh)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((bdxh)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountMessage))) {}
      for (localObject1 = ((SubAccountMessage)((bdxh)localObject2).jdField_a_of_type_JavaLangObject).subUin;; localObject1 = null)
      {
        bdla.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
        bdla.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
        break label163;
        if ((((bdxh)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((bdxh)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo))) {}
        for (localObject1 = ((SubAccountInfo)((bdxh)localObject2).jdField_a_of_type_JavaLangObject).subuin;; localObject1 = null)
        {
          if (((bdxh)localObject2).jdField_a_of_type_Int == 2)
          {
            bdla.b(this.a.app, "dc00898", "", "", "0X800AC3C", "0X800AC3C", 0, 0, "", "", "", "");
            bdla.b(this.a.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
            break label163;
          }
          bdla.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
          bdla.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
          break label163;
          label673:
          if ((((bdxh)localObject2).jdField_a_of_type_Boolean) && (((bdxh)localObject2).jdField_a_of_type_Int == 2))
          {
            if ((((bdxh)localObject2).jdField_a_of_type_JavaLangObject == null) || (!(((bdxh)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null)) {
              break;
            }
            localObject1 = (SubAccountInfo)((bdxh)localObject2).jdField_a_of_type_JavaLangObject;
            if ((TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)) || (((SubAccountInfo)localObject1).subuin.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountInfo)localObject1);
            AssociatedAccountActivity.b(this.a, true);
            break;
          }
          this.a.a(2131694469);
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick mNeed2ConfirmMsgNum = " + this.a.b + "  toUin=" + (String)localObject1);
          }
          if (this.a.b > 0)
          {
            this.a.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localObject2 = (MessageHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
            bdxs localbdxs = (bdxs)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
            Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
            int i = 0;
            for (;;)
            {
              j = i;
              if (!localIterator.hasNext()) {
                break;
              }
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localbdxs.c(localSubAccountInfo.subuin) > 0))
              {
                i += 1;
                ((MessageHandler)localObject2).a().a(localSubAccountInfo.subuin, "sub.account.switchAccount");
              }
            }
          }
          int j = 0;
          if (j > 0)
          {
            this.a.b = j;
            break;
          }
          AssociatedAccountActivity.b(this.a, false, (String)localObject1);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adjg
 * JD-Core Version:    0.7.0.1
 */