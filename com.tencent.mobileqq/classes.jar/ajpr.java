import android.content.DialogInterface.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class ajpr
  implements CompoundButton.OnCheckedChangeListener
{
  public ajpr(QQCustomDialog paramQQCustomDialog, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QQCustomDialog localQQCustomDialog;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
    {
      paramCompoundButton = this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener;
      localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      paramCompoundButton.onClick(localQQCustomDialog, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajpr
 * JD-Core Version:    0.7.0.1
 */