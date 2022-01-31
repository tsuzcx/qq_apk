import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class acfq
  implements DialogInterface.OnClickListener
{
  public acfq(acgy paramacgy, acgz paramacgz) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Acgy != null) {
      this.jdField_a_of_type_Acgy.a();
    }
    mtq.e(true, false);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    mtq.b(this.jdField_a_of_type_Acgz.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfq
 * JD-Core Version:    0.7.0.1
 */