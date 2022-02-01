import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

class akjc
  implements DialogInterface.OnClickListener
{
  akjc(akja paramakja) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.jdField_a_of_type_Int == 2) {
      this.a.a.a("0X8005B8A", 1);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      if (NetworkUtil.isNetSupport(this.a.a)) {
        break;
      }
      this.a.a.a(2131694305);
      return;
      if (this.a.a.jdField_a_of_type_Int == 6) {
        this.a.a.a("0X8005B8A", 2);
      } else if (this.a.a.jdField_a_of_type_Int == 7) {
        this.a.a.a("0X8005B8A", 3);
      }
    }
    paramDialogInterface = this.a.a.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    if ((paramDialogInterface == null) || (paramDialogInterface.nationCode == null) || (paramDialogInterface.mobileNo == null))
    {
      this.a.a.setResult(0);
      this.a.a.finish();
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new akjd(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(paramDialogInterface.nationCode, paramDialogInterface.mobileNo);
    this.a.a.a(2131718527, 300L, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akjc
 * JD-Core Version:    0.7.0.1
 */