import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class akki
  implements DialogInterface.OnClickListener
{
  akki(akkd paramakkd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "cancel click");
    }
    azqs.b(this.a.a, "dc00898", "", "", "0X800A328", "0X800A328", 1, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akki
 * JD-Core Version:    0.7.0.1
 */