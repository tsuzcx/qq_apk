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

public class aaah
  implements View.OnClickListener
{
  public aaah(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof ahyn))) {}
    Object localObject;
    do
    {
      do
      {
        return;
        paramView = (ahyn)paramView.getTag();
      } while ((paramView == null) || (paramView.a == null));
      localObject = paramView.a;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onItemClick type = " + ((axak)localObject).jdField_a_of_type_Int);
      }
      switch (((axak)localObject).jdField_a_of_type_Int)
      {
      case 5: 
      default: 
        paramView = null;
      }
    } while ((TextUtils.isEmpty(paramView)) || (!atok.a().a(this.a.app, this.a)) || (!this.a.b()));
    this.a.a(2131629240);
    int j;
    if (((axak)localObject).jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onItemClick mNeed2ConfirmMsgNum = " + this.a.b + "  toUin=" + paramView);
      }
      if (this.a.b > 0)
      {
        this.a.jdField_a_of_type_JavaLangString = paramView;
        localObject = (MessageHandler)this.a.app.a(0);
        axat localaxat = (axat)this.a.app.getManager(61);
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
        int i = 0;
        for (;;)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if ((localSubAccountInfo != null) && (!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localaxat.c(localSubAccountInfo.subuin) > 0))
          {
            i += 1;
            ((MessageHandler)localObject).a().a(localSubAccountInfo.subuin, "sub.account.switchAccount");
          }
        }
        if ((((axak)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((axak)localObject).jdField_a_of_type_JavaLangObject instanceof SimpleAccount))) {
          break label780;
        }
      }
    }
    label780:
    for (paramView = ((SimpleAccount)((axak)localObject).jdField_a_of_type_JavaLangObject).getUin();; paramView = null)
    {
      awqx.b(this.a.app, "CliOper", "", "", "0X8007141", "0X8007141", 0, 0, "", "", "", "");
      break;
      AssociatedAccountActivity.c(this.a);
      awqx.b(this.a.app, "CliOper", "", "", "0X800714A", "0X800714A", 0, 0, "", "", "", "");
      return;
      if ((((axak)localObject).jdField_a_of_type_JavaLangObject != null) && ((((axak)localObject).jdField_a_of_type_JavaLangObject instanceof SubAccountMessage))) {}
      for (paramView = ((SubAccountMessage)((axak)localObject).jdField_a_of_type_JavaLangObject).subUin;; paramView = null)
      {
        awqx.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
        break;
        if ((((axak)localObject).jdField_a_of_type_JavaLangObject != null) && ((((axak)localObject).jdField_a_of_type_JavaLangObject instanceof SubAccountInfo))) {}
        for (paramView = ((SubAccountInfo)((axak)localObject).jdField_a_of_type_JavaLangObject).subuin;; paramView = null)
        {
          if (((axak)localObject).jdField_a_of_type_Int == 2)
          {
            awqx.b(this.a.app, "CliOper", "", "", "0X800713F", "0X800713F", 0, 0, "", "", "", "");
            break;
          }
          awqx.b(this.a.app, "CliOper", "", "", "0X8007140", "0X8007140", 0, 0, "", "", "", "");
          break;
          j = 0;
          if (j > 0)
          {
            this.a.b = j;
            return;
          }
          AssociatedAccountActivity.c(this.a, false);
          AssociatedAccountActivity.a(this.a, paramView);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("AssociatedAccountActivity", 2, "onItemClick goto SubAccountUgActivity");
          }
          this.a.c();
          this.a.jdField_a_of_type_JavaLangString = paramView;
          this.a.d = true;
          localObject = new Intent("before_account_change");
          this.a.sendBroadcast((Intent)localObject);
          localObject = new Intent(this.a, SubAccountUgActivity.class);
          ((Intent)localObject).putExtra("subAccount", paramView);
          ((Intent)localObject).putExtra("from_associated_activity", true);
          this.a.startActivity((Intent)localObject);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaah
 * JD-Core Version:    0.7.0.1
 */