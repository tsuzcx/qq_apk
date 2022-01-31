import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import mqq.app.MobileQQ;

public class ahki
  extends MessageObserver
{
  public ahki(RedTouchManager paramRedTouchManager) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 113) && (paramBoolean) && ((this.a.a instanceof QQAppInterface)))
    {
      RedpointHandler.a((QQAppInterface)this.a.a);
      paramObject = new Intent();
      paramObject.setAction("com.tencent.redpoint.broadcast.push");
      this.a.a.getApplication().sendBroadcast(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahki
 * JD-Core Version:    0.7.0.1
 */