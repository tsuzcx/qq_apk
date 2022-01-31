import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public final class afbm
  implements DialogInterface.OnClickListener
{
  public afbm(boolean paramBoolean, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afbm
 * JD-Core Version:    0.7.0.1
 */