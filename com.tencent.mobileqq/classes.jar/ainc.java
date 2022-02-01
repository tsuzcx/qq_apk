import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ainc
  extends TransProcessorHandler
{
  ainc(ainb paramainb) {}
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.fileType != 327696) || (localFileMsg.commandId != 68)) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler STATUS_SEND_CANCEL unFinishSegSize=" + ainb.a(this.a).get() + " pos=" + localFileMsg.pttSlicePos);
        return;
        if (localFileMsg.pttSliceText != null) {
          this.a.a(new aing(localFileMsg.pttSliceText, true), localFileMsg.pttSlicePos);
        }
        ainb.a(this.a).set(ainb.a(this.a).get() - 1);
      } while (ainb.a(this.a).get() != 0);
      ainb.a(this.a).clear();
      if (ainb.a(this.a) != null) {
        ainb.a(this.a).d();
      }
      ainb.a(this.a).removeHandle(ainb.a(this.a));
      aioe.a(1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler recieve error:" + localFileMsg.errorCode);
      }
      if (ainb.a(this.a) != null) {
        ainb.a(this.a).a(localFileMsg.errorCode);
      }
      aioe.a(0, localFileMsg.errorCode);
      this.a.a();
      return;
    } while ((StringUtil.isEmpty(localFileMsg.pttSliceText)) || (ainb.a(this.a).get() <= 0));
    this.a.a(new aing(localFileMsg.pttSliceText, false), localFileMsg.pttSlicePos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainc
 * JD-Core Version:    0.7.0.1
 */