import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopGiftProtocolObserver;
import com.tencent.qphone.base.util.QLog;

public final class acfn
  extends ProtoUtils.TroopGiftProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i("reportMsgBoxMomentRead", 1, " reportMsgBoxMomentRead code:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfn
 * JD-Core Version:    0.7.0.1
 */