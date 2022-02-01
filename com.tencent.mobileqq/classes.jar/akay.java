import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class akay
  implements DialogInterface.OnDismissListener
{
  public akay(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (akir)paramDialogInterface;
    paramDialogInterface.a();
    int i = paramDialogInterface.a();
    paramDialogInterface = (aocm)this.a.a.getManager(92);
    if (QLog.isColorLevel()) {
      QLog.i("Q.history.C2CAllFragment", 2, "onDismiss, recordCount : " + i + ",showRoamFlag" + paramDialogInterface.e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akay
 * JD-Core Version:    0.7.0.1
 */