import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class agzs
  implements DialogInterface.OnClickListener
{
  agzs(agzo paramagzo, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_Int != 0) {
        break label47;
      }
      this.jdField_a_of_type_Agzo.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) });
    }
    for (;;)
    {
      agzo.b(this.jdField_a_of_type_Agzo, null);
      return;
      label47:
      if (this.jdField_a_of_type_Int == 1) {
        this.jdField_a_of_type_Agzo.a(new Integer[] { Integer.valueOf(0), Integer.valueOf(2) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzs
 * JD-Core Version:    0.7.0.1
 */