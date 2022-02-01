import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.troop.file.MoveFileActivity;

public class aago
  implements DialogInterface.OnClickListener
{
  public aago(MoveFileActivity paramMoveFileActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (aatk)paramDialogInterface;
    this.a.jdField_a_of_type_JavaLangString = paramDialogInterface.getInputValue().trim();
    if (this.a.jdField_a_of_type_JavaLangString.length() > bgke.a)
    {
      paramDialogInterface.a(this.a.getString(2131697108), -65536);
      bdla.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "over_num", 0, 0, this.a.jdField_a_of_type_Long + "", "", "", "");
    }
    do
    {
      return;
      if (bgke.a(this.a.jdField_a_of_type_JavaLangString))
      {
        paramDialogInterface.a(this.a.getString(2131697109), -65536);
        bdla.b(this.a.app, "P_CliOper", "Grp_files", "", "file", "sensitive", 0, 0, this.a.jdField_a_of_type_Long + "", "0", "", "");
        return;
      }
      paramDialogInterface.dismiss();
    } while (bgke.a(this.a.app, this.a, this.a.jdField_a_of_type_Long) == 0);
    aagu.a(this.a.app, this.a.jdField_a_of_type_Long, "/", this.a.jdField_a_of_type_JavaLangString, MoveFileActivity.a(this.a));
    this.a.a(2131697036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aago
 * JD-Core Version:    0.7.0.1
 */