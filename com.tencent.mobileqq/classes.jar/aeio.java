import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity;

public class aeio
  implements DialogInterface.OnClickListener
{
  public aeio(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, bgpa parambgpa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bgpa.dismiss();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.getIntent();
    paramDialogInterface.putExtra("delHead_fileid", FriendProfilePicBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity));
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeio
 * JD-Core Version:    0.7.0.1
 */