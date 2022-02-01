import android.os.Message;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ajgl
  extends MqqHandler
{
  public ajgl(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      TroopNotifyAndRecommendView.d(this.a);
      return;
      this.a.j();
      return;
      paramMessage = paramMessage.obj;
      try
      {
        this.a.a((List)paramMessage);
        TroopNotifyAndRecommendView.e(this.a);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          QLog.e("TroopNotifyAndRecommendView", 1, "handleRecommendData wrong");
        }
      }
    } while (this.a.a == null);
    this.a.a.c(2131718527);
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgl
 * JD-Core Version:    0.7.0.1
 */