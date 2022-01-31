import com.tencent.mobileqq.richmedia.conn.LiteTcpConnection;
import com.tencent.mobileqq.richmedia.conn.SubTitleProtocoDataCodec;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class agze
  implements Runnable
{
  public agze(LiteTcpConnection paramLiteTcpConnection) {}
  
  public void run()
  {
    while (LiteTcpConnection.a(this.a).get()) {
      try
      {
        MsfSocketInputBuffer localMsfSocketInputBuffer = LiteTcpConnection.a(this.a);
        if (localMsfSocketInputBuffer == null) {
          return;
        }
        while (!localMsfSocketInputBuffer.isDataAvailable(10000)) {
          if (!LiteTcpConnection.a(this.a).get()) {
            return;
          }
        }
        if (!LiteTcpConnection.a(this.a).get()) {
          break;
        }
        LiteTcpConnection.a(this.a).a(localMsfSocketInputBuffer);
        localMsfSocketInputBuffer.reset();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PeakAudioTransHandler LiteTcpConnection", 2, "read exception " + localException.getMessage() + ";");
        }
        LiteTcpConnection.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agze
 * JD-Core Version:    0.7.0.1
 */