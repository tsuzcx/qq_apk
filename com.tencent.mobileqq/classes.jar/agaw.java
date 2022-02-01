import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.widget.QQToast;

public class agaw
  extends Handler
{
  public agaw(TroopChatPie paramTroopChatPie, Looper paramLooper)
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
        } while (!(paramMessage instanceof bgkl));
        this.a.a((bgkl)paramMessage);
        return;
        paramMessage = (PlusPanel)this.a.panelManager.a(8);
      } while (paramMessage == null);
      paramMessage.a();
      return;
    }
    String str = (String)paramMessage.obj;
    int i = paramMessage.arg1;
    QQToast.a(this.a.mActivity, str, i).b(this.a.mActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agaw
 * JD-Core Version:    0.7.0.1
 */