import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;

public class acrk
  implements DialogInterface.OnClickListener
{
  public acrk(Conversation paramConversation, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation, null);
    ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(256)).a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(), this.jdField_a_of_type_ComTencentMobileqqAppUpgradeUpgradeTIMWrapper.c);
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a, "CliOper", "", "", "0X800815D", "0X800815D", 0, 0, "", "", "", "");
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a, "CliOper", "", "", "0X8008657", "0X8008657", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrk
 * JD-Core Version:    0.7.0.1
 */