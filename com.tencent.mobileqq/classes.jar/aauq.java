import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.file.MoveFileActivity;

public class aauq
  implements DialogInterface.OnClickListener
{
  public aauq(MoveFileActivity paramMoveFileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (abhn)paramDialogInterface;
    this.a.jdField_a_of_type_JavaLangString = paramDialogInterface.getInputValue().trim();
    if (this.a.jdField_a_of_type_JavaLangString.length() > bgsk.a)
    {
      paramDialogInterface.a(this.a.getString(2131696699), -65536);
      bdll.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this.a.jdField_a_of_type_Long + "", "", "", "");
    }
    do
    {
      return;
      if (bgsk.a(this.a.jdField_a_of_type_JavaLangString))
      {
        paramDialogInterface.a(this.a.getString(2131696700), -65536);
        bdll.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "0", "", "");
        return;
      }
      paramDialogInterface.dismiss();
    } while (bgsk.a(this.a.app, this.a, this.a.jdField_a_of_type_Long) == 0);
    aauw.a(this.a.app, this.a.jdField_a_of_type_Long, "/", this.a.jdField_a_of_type_JavaLangString, MoveFileActivity.a(this.a));
    this.a.a(2131696628);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauq
 * JD-Core Version:    0.7.0.1
 */