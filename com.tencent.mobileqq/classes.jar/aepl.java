import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aepl
  implements DialogInterface.OnClickListener
{
  aepl(aepg paramaepg, boolean paramBoolean, bcir parambcir) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Aepg.ab = true;
    aepg.d(this.jdField_a_of_type_Aepg, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aepg.aa = true;
    if ((this.jdField_a_of_type_Bcir.a()) && (!this.jdField_a_of_type_Bcir.b())) {
      axqw.b(this.jdField_a_of_type_Aepg.a, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepl
 * JD-Core Version:    0.7.0.1
 */