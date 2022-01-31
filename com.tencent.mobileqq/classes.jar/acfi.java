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
import java.util.ArrayList;
import java.util.Iterator;

public class acfi
  implements View.OnClickListener
{
  public acfi(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && (paramView.getId() == 2131362114))
    {
      AssociatedAccountActivity.a(this.a);
      break label20;
      break label20;
    }
    label20:
    Object localObject;
    label146:
    do
    {
      do
      {
        return;
      } while ((paramView == null) || (!(paramView.getTag() instanceof akhe)));
      paramView = (akhe)paramView.getTag();
      if ((paramView == null) || (paramView.a == null)) {
        break;
      }
      localObject = paramView.a;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onItemClick type = " + ((bacs)localObject).jdField_a_of_type_Int);
      }
      switch (((bacs)localObject).jdField_a_of_type_Int)
      {
      case 5: 
      default: 
        paramView = null;
      }
    } while ((TextUtils.isEmpty(paramView)) || (!awia.a().a(this.a.app, this.a)) || (!this.a.c()));
    if (!((bacs)localObject).jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onItemClick goto SubAccountUgActivity");
      }
      this.a.jdField_a_of_type_JavaLangString = paramView;
      this.a.d = true;
      localObject = new Intent("before_account_change");
      this.a.sendBroadcast((Intent)localObject);
      localObject = new Intent(this.a, SubAccountUgActivity.class);
      ((Intent)localObject).putExtra("subAccount", paramView);
      ((Intent)localObject).putExtra("from_associated_activity", true);
      this.a.startActivity((Intent)localObject);
      return;
      if ((((bacs)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((bacs)localObject).jdField_a_of_type_JavaLangObject instanceof SimpleAccount))) {
        break label978;
      }
    }
    label978:
    for (paramView = ((SimpleAccount)((bacs)localObject).jdField_a_of_type_JavaLangObject).getUin();; paramView = null)
    {
      azqs.b(this.a.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
      break label146;
      AssociatedAccountActivity.a(this.a);
      azqs.b(this.a.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
      return;
      if ((((bacs)localObject).jdField_a_of_type_JavaLangObject != null) && ((((bacs)localObject).jdField_a_of_type_JavaLangObject instanceof SubAccountMessage))) {}
      for (paramView = ((SubAccountMessage)((bacs)localObject).jdField_a_of_type_JavaLangObject).subUin;; paramView = null)
      {
        azqs.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
        azqs.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
        break label146;
        if ((((bacs)localObject).jdField_a_of_type_JavaLangObject != null) && ((((bacs)localObject).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo))) {}
        for (paramView = ((SubAccountInfo)((bacs)localObject).jdField_a_of_type_JavaLangObject).subuin;; paramView = null)
        {
          if (((bacs)localObject).jdField_a_of_type_Int == 2)
          {
            azqs.b(this.a.app, "dc00898", "", "", "0X800AC3C", "0X800AC3C", 0, 0, "", "", "", "");
            azqs.b(this.a.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
            break label146;
          }
          azqs.b(this.a.app, "dc00898", "", "", "0X800AC3D", "0X800AC3D", 0, 0, "", "", "", "");
          azqs.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
          break label146;
          if ((((bacs)localObject).jdField_a_of_type_Boolean) && (((bacs)localObject).jdField_a_of_type_Int == 2))
          {
            if ((((bacs)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((bacs)localObject).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) || (this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo == null)) {
              break;
            }
            paramView = (SubAccountInfo)((bacs)localObject).jdField_a_of_type_JavaLangObject;
            if ((TextUtils.isEmpty(paramView.subuin)) || (paramView.subuin.equals(this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo.subuin))) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqDataSubAccountInfo = paramView;
            AssociatedAccountActivity.b(this.a, true);
            return;
          }
          this.a.a(2131695077);
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick mNeed2ConfirmMsgNum = " + this.a.b + "  toUin=" + paramView);
          }
          if (this.a.b > 0)
          {
            this.a.jdField_a_of_type_JavaLangString = paramView;
            localObject = (MessageHandler)this.a.app.a(0);
            badd localbadd = (badd)this.a.app.getManager(61);
            Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
            int i = 0;
            for (;;)
            {
              j = i;
              if (!localIterator.hasNext()) {
                break;
              }
              SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
              if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localbadd.c(localSubAccountInfo.subuin) > 0))
              {
                i += 1;
                ((MessageHandler)localObject).a().a(localSubAccountInfo.subuin, "sub.account.switchAccount");
              }
            }
          }
          int j = 0;
          if (j > 0)
          {
            this.a.b = j;
            return;
          }
          AssociatedAccountActivity.b(this.a, false, paramView);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfi
 * JD-Core Version:    0.7.0.1
 */