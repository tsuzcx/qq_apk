import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.widget.ActionSheet;

class abfk
  implements DialogInterface.OnDismissListener
{
  abfk(abfj paramabfj, ActionSheet paramActionSheet) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    ArkAppCenter.b("ArkApp.DebugOnlineActivity", String.format("ClearApp actionsheet is closed", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfk
 * JD-Core Version:    0.7.0.1
 */