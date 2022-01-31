import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupDBManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class abzb
  implements Handler.Callback
{
  public abzb(EmoticonFromGroupDBManager paramEmoticonFromGroupDBManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.a.b = true;
      QLog.i("EmoticonFromGroup_DBManager", 1, "set db tag, mCanWriteDataToDB = true.");
    } while (this.a.b() < 300);
    EmoticonFromGroupDBManager.a(this.a).clear();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abzb
 * JD-Core Version:    0.7.0.1
 */