import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;

public class ajbn
  implements DialogInterface.OnClickListener
{
  public ajbn(Conversation paramConversation, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Conversation.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation, null);
    ((UpgradeTIMManager)this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a.getManager(256)).a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a(), this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper.c);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a, "CliOper", "", "", "0X800815D", "0X800815D", 0, 0, "", "", "", "");
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.a, "CliOper", "", "", "0X8008657", "0X8008657", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbn
 * JD-Core Version:    0.7.0.1
 */