import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class agqz
  extends Handler
{
  public agqz(TroopChatPie paramTroopChatPie, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        do
        {
          return;
          this.a.a(null, false);
          return;
          paramMessage = paramMessage.obj;
        } while (!(paramMessage instanceof bcjr));
        this.a.a((bcjr)paramMessage);
        return;
      } while (TroopChatPie.j(this.a) == null);
      TroopChatPie.k(this.a).a();
      return;
    }
    String str = (String)paramMessage.obj;
    int i = paramMessage.arg1;
    QQToast.a(this.a.a, str, i).b(this.a.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqz
 * JD-Core Version:    0.7.0.1
 */