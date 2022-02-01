import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ahsd
  extends TransProcessorHandler
{
  ahsd(ahsc paramahsc) {}
  
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
        QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler STATUS_SEND_CANCEL unFinishSegSize=" + ahsc.a(this.a).get() + " pos=" + localFileMsg.pttSlicePos);
        return;
        if (localFileMsg.pttSliceText != null) {
          this.a.a(new ahsh(localFileMsg.pttSliceText, true), localFileMsg.pttSlicePos);
        }
        ahsc.a(this.a).set(ahsc.a(this.a).get() - 1);
      } while (ahsc.a(this.a).get() != 0);
      ahsc.a(this.a).clear();
      if (ahsc.a(this.a) != null) {
        ahsc.a(this.a).d();
      }
      ahsc.a(this.a).removeHandle(ahsc.a(this.a));
      ahtf.a(1, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VoiceTextEdtiController", 2, "pttTransProcessorHandler recieve error:" + localFileMsg.errorCode);
      }
      if (ahsc.a(this.a) != null) {
        ahsc.a(this.a).a(localFileMsg.errorCode);
      }
      ahtf.a(0, localFileMsg.errorCode);
      this.a.a();
      return;
    } while ((StringUtil.isEmpty(localFileMsg.pttSliceText)) || (ahsc.a(this.a).get() <= 0));
    this.a.a(new ahsh(localFileMsg.pttSliceText, false), localFileMsg.pttSlicePos);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsd
 * JD-Core Version:    0.7.0.1
 */