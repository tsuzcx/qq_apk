import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class ajbc
  implements DialogInterface.OnClickListener
{
  public ajbc(boolean paramBoolean, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbc
 * JD-Core Version:    0.7.0.1
 */