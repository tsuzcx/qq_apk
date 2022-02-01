import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aecf
  implements DialogInterface.OnClickListener
{
  public aecf(GeneralSettingActivity paramGeneralSettingActivity, Runnable paramRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof QQCustomDialog)) {
      ((QQCustomDialog)paramDialogInterface).setOnDismissListener(null);
    }
    this.jdField_a_of_type_JavaLangRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aecf
 * JD-Core Version:    0.7.0.1
 */