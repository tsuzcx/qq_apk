import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class alwh
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = bakc.b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      ajtg localajtg = (ajtg)((QQAppInterface)getAppRuntime()).a(20);
      if (localajtg != null) {
        localajtg.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(bakc.a(arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alwh
 * JD-Core Version:    0.7.0.1
 */