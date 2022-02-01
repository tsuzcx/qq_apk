import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.qphone.base.util.QLog;

class adfl
  implements DialogInterface.OnClickListener
{
  adfl(adfj paramadfj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "onSetColorNick failed. save colorNick");
    }
    this.a.a.a.sendEmptyMessage(259);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfl
 * JD-Core Version:    0.7.0.1
 */