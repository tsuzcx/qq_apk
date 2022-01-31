import android.os.Bundle;
import com.tencent.mobileqq.nearby.now.protocol.CsTask.Callback;
import com.tencent.mobileqq.nearby.now.send.uploader.WordsCheck.OnResultListener;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.now.WordsSecurity.SecurityRsp;
import com.tencent.qphone.base.util.QLog;

public final class aews
  implements CsTask.Callback
{
  public aews(WordsCheck.OnResultListener paramOnResultListener) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramBundle = new WordsSecurity.SecurityRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (!paramBundle.ret_code.has()) {
        break label104;
      }
      i = paramBundle.ret_code.get();
      if (paramBundle.sys_beat_level.get() == 4) {
        break label177;
      }
      paramInt = i;
      if (paramBundle.dirty_word_beat.get() != 1) {}
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        int i;
        QLog.e("WordsCheck", 1, paramArrayOfByte, new Object[0]);
        if (this.a == null) {
          break;
        }
        this.a.a(0);
        return;
        paramInt = i;
        if (i == 0) {
          paramInt = -1;
        }
      }
    }
    QLog.i("WordsCheck", 1, "ret_code = " + paramInt);
    if (this.a != null)
    {
      this.a.a(paramInt);
      return;
      label104:
      QLog.i("WordsCheck", 1, "ret_code not has, ret_code = " + paramInt);
      if (this.a != null)
      {
        this.a.b(3);
        return;
      }
    }
    label177:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aews
 * JD-Core Version:    0.7.0.1
 */