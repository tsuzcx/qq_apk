import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.mobileqq.nearby.now.send.uploader.WordsCheck.OnResultListener;
import com.tencent.qphone.base.util.QLog;

public final class aewr
  implements CsTask.OnCsError
{
  public aewr(WordsCheck.OnResultListener paramOnResultListener) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.e("WordsCheck", 1, "onError, code=" + paramInt);
    if (this.a != null) {
      this.a.a(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aewr
 * JD-Core Version:    0.7.0.1
 */