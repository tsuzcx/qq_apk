import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

public class admt
  implements View.OnClickListener
{
  public admt(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131362175)) {
      AssociatedAccountActivity.a(this.a);
    }
    Object localObject2;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView == null) || ((paramView.getTag() instanceof ambd)))
      {
        localObject1 = (ambd)paramView.getTag();
        if ((localObject1 == null) || (((ambd)localObject1).a != null))
        {
          localObject2 = ((ambd)localObject1).a;
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick type = " + ((bddw)localObject2).jdField_a_of_type_Int);
          }
          switch (((bddw)localObject2).jdField_a_of_type_Int)
          {
          case 5: 
          default: 
            localObject1 = null;
            label163:
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (aywm.a().a(this.a.app, this.a)) && (this.a.c()))
            {
              if (((bddw)localObject2).jdField_a_of_type_Boolean) {
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
    if ((((bddw)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((bddw)localObject2).jdField_a_of_type_JavaLangObject instanceof SimpleAccount))) {}
    for (Object localObject1 = ((SimpleAccount)((bddw)localObject2).jdField_a_of_type_JavaLangObject).getUin();; localObject1 = null)
    {
      bcst.b(this.a.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
      break label163;
      AssociatedAccountActivity.a(this.a);
      bcst.b(this.a.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
      break;
      if ((((bddw)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((bddw)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountMessage))) {}
      for (localObject1 = ((SubAccountMessage)((bddw)localObject2).jdField_a_of_type_JavaLangObject).subUin;; localObject1 = null)
      {
        bcst.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
        bcst.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
        break label163;
        if ((((bddw)localObject2).jdField_a_of_type_JavaLangObject != null) && ((((bddw)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo))) {}
        for (localObject1 = ((SubAccountInfo)((bddw)localObject2).jdField_a_of_type_JavaLangObject).subuin;; localObject1 = null)
        {
          if (((bddw)localObject2).jdField_a_of_type_Int == 2)
          {
            bcst.b(this.a.app, "dc00898", "", "", "0X800AC3C", "0X800AC3C", 0, 0, "", "", "", "");
            bcst.b(this.a.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
            break label163;
          }
          bcst.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
          bcst.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
          break label163;
          label673:
          if ((((bddw)localObject2).jdField_a_of_type_Boolean) && (((bddw)localObject2).jdField_a_of_type_Int == 2))
          {
            if ((((bddw)localObject2).jdField_a_of_type_JavaLangObject == null) || (!(((bddw)localObject2).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null)) {
              break;
            }
            localObject1 = (SubAccountInfo)((bddw)localObject2).jdField_a_of_type_JavaLangObject;
            if ((TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)) || (((SubAccountInfo)localObject1).subuin.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = ((SubAccountInfo)localObject1);
            AssociatedAccountActivity.b(this.a, true);
            break;
          }
          this.a.a(2131694150);
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick mNeed2ConfirmMsgNum = " + this.a.b + "  toUin=" + (String)localObject1);
          }
          if (this.a.b > 0)
          {
            this.a.jdField_a_of_type_JavaLangString = ((String)localObject1);
            localObject2 = (MessageHandler)this.a.app.a(0);
            bdeh localbdeh = (bdeh)this.a.app.getManager(61);
            Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
            int i = 0;
            for (;;)
            {
              j = i;
              if (!localIterator.hasNext()) {
                break;
              }
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localbdeh.c(localSubAccountInfo.subuin) > 0))
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
 * Qualified Name:     admt
 * JD-Core Version:    0.7.0.1
 */