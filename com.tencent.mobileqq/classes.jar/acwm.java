import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class acwm
  implements DialogInterface.OnClickListener
{
  acwm(acwl paramacwl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((acwl.a(this.a) != null) && (acwl.a(this.a).isShowing())) {
        acwl.a(this.a).dismiss();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwm
 * JD-Core Version:    0.7.0.1
 */