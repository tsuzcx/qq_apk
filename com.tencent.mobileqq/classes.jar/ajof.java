import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class ajof
  implements DialogInterface.OnClickListener
{
  public ajof(PublishHomeWorkFragment paramPublishHomeWorkFragment, FormSwitchItem paramFormSwitchItem, CompoundButton paramCompoundButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
    PublishHomeWorkFragment.c(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment, false);
    PublishHomeWorkFragment.d(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment, false);
    this.jdField_a_of_type_AndroidWidgetCompoundButton.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajof
 * JD-Core Version:    0.7.0.1
 */