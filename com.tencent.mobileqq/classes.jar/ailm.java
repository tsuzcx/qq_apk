import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ailm
  implements DialogInterface.OnClickListener
{
  ailm(aikq paramaikq, biuo parambiuo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Aikq.aa = true;
    this.jdField_a_of_type_Aikq.Z = true;
    aikq.b(this.jdField_a_of_type_Aikq, false);
    if ((this.jdField_a_of_type_Biuo.a()) && (!this.jdField_a_of_type_Biuo.b())) {
      bdll.b(this.jdField_a_of_type_Aikq.a, "dc00899", "Grp_wolf", "", "ready_time", "ready_kick", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailm
 * JD-Core Version:    0.7.0.1
 */