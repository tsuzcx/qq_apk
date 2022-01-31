import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class aisp
  implements DialogInterface.OnClickListener
{
  public aisp(PublishHomeWorkFragment paramPublishHomeWorkFragment, FormSwitchItem paramFormSwitchItem, CompoundButton paramCompoundButton) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
    PublishHomeWorkFragment.c(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment, false);
    PublishHomeWorkFragment.d(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiPublishHomeWorkFragment, false);
    this.jdField_a_of_type_AndroidWidgetCompoundButton.setChecked(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aisp
 * JD-Core Version:    0.7.0.1
 */