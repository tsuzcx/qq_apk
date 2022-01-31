import android.app.Activity;
import android.app.Dialog;
import com.tencent.mobileqq.database.corrupt.DBFixDialogUI;

public class abvx
  implements Runnable
{
  public abvx(DBFixDialogUI paramDBFixDialogUI, Dialog paramDialog) {}
  
  public void run()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixDialogUI.a instanceof Activity)) && (((Activity)this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixDialogUI.a).isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvx
 * JD-Core Version:    0.7.0.1
 */