import com.tencent.mobileqq.database.corrupt.DBFixDialogUI;
import com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog;

public class abpc
  implements Runnable
{
  public abpc(DBFixDialogUI paramDBFixDialogUI, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == DBFixLoadingDialog.d) {
      DBFixDialogUI.c(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixDialogUI);
    }
    while (this.jdField_a_of_type_Int != DBFixLoadingDialog.e) {
      return;
    }
    DBFixDialogUI.d(this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixDialogUI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abpc
 * JD-Core Version:    0.7.0.1
 */