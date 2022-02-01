import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class afsx
  implements DialogInterface.OnClickListener
{
  afsx(afsv paramafsv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((afsv.a(this.a) != null) && (afsv.a(this.a).isShowing())) {
        afsv.a(this.a).dismiss();
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
 * Qualified Name:     afsx
 * JD-Core Version:    0.7.0.1
 */