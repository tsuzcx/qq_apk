import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public final class adah
  implements DialogInterface.OnClickListener
{
  public adah(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, awqt paramawqt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Awqt);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adah
 * JD-Core Version:    0.7.0.1
 */