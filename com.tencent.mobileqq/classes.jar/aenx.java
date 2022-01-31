import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aenx
  implements DialogInterface.OnClickListener
{
  aenx(aenv paramaenv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((aenv.a(this.a) != null) && (aenv.a(this.a).isShowing())) {
        aenv.a(this.a).dismiss();
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "disband cancel");
      }
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenx
 * JD-Core Version:    0.7.0.1
 */