import android.os.Bundle;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager.Callback;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acfj
  implements NowShortVideoProtoManager.Callback
{
  public acfj(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg_box", 2, "follow onReceive errorCode = [" + paramInt + "]");
    }
    this.a.b.post(new acfk(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfj
 * JD-Core Version:    0.7.0.1
 */