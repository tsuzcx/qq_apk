import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;

public class afjj
  implements bkzq
{
  public afjj(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, afjr paramafjr, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Afjr.a instanceof Friends)) {}
    for (paramView = ((Friends)this.jdField_a_of_type_Afjr.a).uin;; paramView = ((PhoneContact)this.jdField_a_of_type_Afjr.a).mobileCode) {
      switch (paramInt)
      {
      default: 
        this.jdField_a_of_type_Bkzi.dismiss();
        do
        {
          return;
        } while (!(this.jdField_a_of_type_Afjr.a instanceof PhoneContact));
      }
    }
    Object localObject = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), SplashActivity.class), null);
    if ((this.jdField_a_of_type_Afjr.a instanceof Friends))
    {
      ((Intent)localObject).putExtra("uintype", 0);
      ((Intent)localObject).putExtra("uin", paramView);
      ((Intent)localObject).putExtra("uinname", ContactUtils.getFriendShowName(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, paramView));
      ((Intent)localObject).putExtra("entrance", 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.startActivity((Intent)localObject);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C51", "0X8004C51", 0, 0, "", "", "", "");
      break;
      if ((this.jdField_a_of_type_Afjr.a instanceof PhoneContact))
      {
        ((Intent)localObject).putExtra("uintype", 1006);
        ((Intent)localObject).putExtra("uin", paramView);
        ((Intent)localObject).putExtra("uinname", ((PhoneContact)this.jdField_a_of_type_Afjr.a).name);
        ((Intent)localObject).putExtra("entrance", 2);
      }
    }
    if ((this.jdField_a_of_type_Afjr.a instanceof Friends))
    {
      paramView = new ProfileActivity.AllInOne(paramView, 1);
      paramView.jdField_h_of_type_Int = 59;
      paramView.j = 2;
    }
    for (;;)
    {
      ProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity(), paramView);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C52", "0X8004C52", 0, 0, "", "", "", "");
      break;
      if ((this.jdField_a_of_type_Afjr.a instanceof PhoneContact))
      {
        localObject = (PhoneContact)this.jdField_a_of_type_Afjr.a;
        paramView = new ProfileActivity.AllInOne(((PhoneContact)localObject).mobileCode, 34);
        paramView.jdField_h_of_type_Int = 59;
        paramView.jdField_h_of_type_JavaLangString = ((PhoneContact)localObject).name;
        paramView.j = 2;
        continue;
        if (NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.getActivity())) {
          if ((this.jdField_a_of_type_Afjr.a instanceof Friends))
          {
            localObject = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramView);
            ((FriendListHandler)localObject).gatherContacts((short)1, localArrayList, false);
          }
        }
        for (;;)
        {
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C53", "0X8004C53", 0, 0, "", "", "", "");
          break;
          if ((this.jdField_a_of_type_Afjr.a instanceof PhoneContact))
          {
            ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getManager(QQManagerFactory.CONTACT_MANAGER)).a(((PhoneContact)this.jdField_a_of_type_Afjr.a).mobileCode, false);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(2131694306, 0);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(paramView);
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app, "CliOper", "", "", "0X8004C54", "0X8004C54", 0, 0, "", "", "", "");
        break;
      }
      paramView = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afjj
 * JD-Core Version:    0.7.0.1
 */