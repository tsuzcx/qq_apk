import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.selectmember.DiscussionMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;

public class ajuk
  implements DialogInterface.OnClickListener
{
  public ajuk(DiscussionMemberListInnerFrame paramDiscussionMemberListInnerFrame) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    boolean bool;
    do
    {
      return;
      paramDialogInterface = this.a.jdField_a_of_type_AndroidWidgetCheckBox;
      if (this.a.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        break;
      }
      bool = true;
      paramDialogInterface.setChecked(bool);
      this.a.onCheckedChanged(this.a.jdField_a_of_type_AndroidWidgetCheckBox, this.a.jdField_a_of_type_AndroidWidgetCheckBox.isChecked());
    } while (this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d != 32);
    if (this.a.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {}
    for (paramDialogInterface = "friendsfinder.all.confirm";; paramDialogInterface = "friendsfinder.all.cancel")
    {
      ajaf.a(0, paramDialogInterface);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajuk
 * JD-Core Version:    0.7.0.1
 */