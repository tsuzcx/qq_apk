import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.qphone.base.util.QLog;

public class aein
  extends Handler
{
  public aein(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "mWaitingDialogControlHandler operationFinished = " + MoveToGroupActivity.b(this.a));
    }
    MoveToGroupActivity.c(this.a, true);
    if (MoveToGroupActivity.b(this.a))
    {
      this.a.a(true);
      return;
    }
    paramMessage = MoveToGroupActivity.a(this.a).obtainMessage(0);
    MoveToGroupActivity.a(this.a).sendMessageDelayed(paramMessage, 60000L);
    MoveToGroupActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aein
 * JD-Core Version:    0.7.0.1
 */