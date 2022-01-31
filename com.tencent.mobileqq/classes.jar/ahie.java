import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ahie
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("springHb_report_SpringHbReportServlet", 2, "[onReceive] cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess() + ", retCode=" + paramFromServiceMsg.getResultCode());
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      bbmx.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("extra_result_code", paramFromServiceMsg.getResultCode());
      localBundle.putString("cmd", paramIntent.getStringExtra("cmd"));
      localBundle.putByteArray("data", arrayOfByte);
      notifyObserver(paramIntent, 0, paramFromServiceMsg.isSuccess(), localBundle, null);
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("springHb_report_SpringHbReportServlet", 2, "[onSend] cmd=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahie
 * JD-Core Version:    0.7.0.1
 */