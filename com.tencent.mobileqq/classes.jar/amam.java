import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import cooperation.qqpim.QQPimDefineList;
import cooperation.qqpim.QQPimGetTipsInfoIPC;

public class amam
  implements Runnable
{
  private amam(QQPimGetTipsInfoIPC paramQQPimGetTipsInfoIPC) {}
  
  public void run()
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(QQPimDefineList.r, 3);
      QIPCServerHelper.getInstance().callClient(QQPimDefineList.b, QQPimDefineList.c, QQPimDefineList.e, localBundle, new aman(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amam
 * JD-Core Version:    0.7.0.1
 */