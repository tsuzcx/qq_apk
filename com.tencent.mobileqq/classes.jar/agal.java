import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager.Callback;

public class agal
  implements Handler.Callback
{
  public agal(NowHongbaoPushManager paramNowHongbaoPushManager) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (NowHongbaoPushManager.a(this.a) == 0)
      {
        NowHongbaoPushManager.a(this.a);
      }
      else
      {
        NowHongbaoPushManager.b(this.a);
        continue;
        paramMessage = (NowHongbaoPushManager.Callback)paramMessage.obj;
        NowHongbaoPushManager.a(this.a, paramMessage);
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agal
 * JD-Core Version:    0.7.0.1
 */