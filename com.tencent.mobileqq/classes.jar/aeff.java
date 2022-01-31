import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.ArrayList;

public class aeff
  implements bhqd
{
  public aeff(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, aefn paramaefn, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Aefn.a instanceof Friends)) {}
    for (paramView = ((Friends)this.jdField_a_of_type_Aefn.a).uin;; paramView = ((PhoneContact)this.jdField_a_of_type_Aefn.a).mobileCode) {
      switch (paramInt)
      {
      default: 
        this.jdField_a_of_type_Bhpy.dismiss();
        do
        {
          return;
        } while (!(this.jdField_a_of_type_Aefn.a instanceof PhoneContact));
      }
    }
    Object localObject = aekt.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), SplashActivity.class), null);
    if ((this.jdField_a_of_type_Aefn.a instanceof Friends))
    {
      ((Intent)localObject).putExtra("uintype", 0);
      ((Intent)localObject).putExtra("uin", paramView);
      ((Intent)localObject).putExtra("uinname", bdbt.m(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, paramView));
      ((Intent)localObject).putExtra("entrance", 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.startActivity((Intent)localObject);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C51", "0X8004C51", 0, 0, "", "", "", "");
      break;
      if ((this.jdField_a_of_type_Aefn.a instanceof PhoneContact))
      {
        ((Intent)localObject).putExtra("uintype", 1006);
        ((Intent)localObject).putExtra("uin", paramView);
        ((Intent)localObject).putExtra("uinname", ((PhoneContact)this.jdField_a_of_type_Aefn.a).name);
        ((Intent)localObject).putExtra("entrance", 2);
      }
    }
    if ((this.jdField_a_of_type_Aefn.a instanceof Friends))
    {
      paramView = new ProfileActivity.AllInOne(paramView, 1);
      paramView.jdField_h_of_type_Int = 59;
      paramView.j = 2;
    }
    for (;;)
    {
      ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), paramView);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C52", "0X8004C52", 0, 0, "", "", "", "");
      break;
      if ((this.jdField_a_of_type_Aefn.a instanceof PhoneContact))
      {
        localObject = (PhoneContact)this.jdField_a_of_type_Aefn.a;
        paramView = new ProfileActivity.AllInOne(((PhoneContact)localObject).mobileCode, 34);
        paramView.jdField_h_of_type_Int = 59;
        paramView.jdField_h_of_type_JavaLangString = ((PhoneContact)localObject).name;
        paramView.j = 2;
        continue;
        if (bdee.d(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity())) {
          if ((this.jdField_a_of_type_Aefn.a instanceof Friends))
          {
            localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.a(1);
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramView);
            ((FriendListHandler)localObject).a((short)1, localArrayList, false);
          }
        }
        for (;;)
        {
          azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C53", "0X8004C53", 0, 0, "", "", "", "");
          break;
          if ((this.jdField_a_of_type_Aefn.a instanceof PhoneContact))
          {
            ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getManager(11)).a(((PhoneContact)this.jdField_a_of_type_Aefn.a).mobileCode, false);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(2131694830, 0);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(paramView);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C54", "0X8004C54", 0, 0, "", "", "", "");
        break;
      }
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeff
 * JD-Core Version:    0.7.0.1
 */