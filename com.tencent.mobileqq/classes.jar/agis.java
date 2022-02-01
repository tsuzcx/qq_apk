import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class agis
  implements DialogInterface.OnClickListener
{
  agis(agiq paramagiq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((agiq.a(this.a) != null) && (agiq.a(this.a).isShowing())) {
        agiq.a(this.a).dismiss();
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
 * Qualified Name:     agis
 * JD-Core Version:    0.7.0.1
 */