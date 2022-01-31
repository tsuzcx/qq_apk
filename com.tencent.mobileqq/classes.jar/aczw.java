import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;

class aczw
  implements DialogInterface.OnClickListener
{
  aczw(aczv paramaczv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.o();
    azqs.b(this.a.a.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k), "", "");
    if (this.a.a.a.b) {
      new azqx(this.a.a.app).a("dc00899").b("Grp_mem_card").c("page").d("msg_clk").a(new String[] { this.a.a.a.jdField_a_of_type_JavaLangString }).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczw
 * JD-Core Version:    0.7.0.1
 */