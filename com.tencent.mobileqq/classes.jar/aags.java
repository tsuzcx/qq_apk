import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;

class aags
  implements DialogInterface.OnCancelListener
{
  aags(aagr paramaagr) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aags
 * JD-Core Version:    0.7.0.1
 */