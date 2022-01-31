import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.FriendListHandler;
import mqq.os.MqqHandler;

public class ajxf
  extends MqqHandler
{
  public ajxf(FriendListHandler paramFriendListHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    FriendListHandler.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajxf
 * JD-Core Version:    0.7.0.1
 */