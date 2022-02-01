import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class aibr
  implements DialogInterface.OnClickListener
{
  aibr(aiav paramaiav, bili parambili) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Aiav.j = true;
    this.jdField_a_of_type_Aiav.i = true;
    aiav.b(this.jdField_a_of_type_Aiav, false);
    if ((this.jdField_a_of_type_Bili.a()) && (!this.jdField_a_of_type_Bili.b())) {
      bdla.b(this.jdField_a_of_type_Aiav.app, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aibr
 * JD-Core Version:    0.7.0.1
 */