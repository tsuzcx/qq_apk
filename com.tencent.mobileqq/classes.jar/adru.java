import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.NearbyActivity;

public class adru
  implements Handler.Callback
{
  public adru(NearbyActivity paramNearbyActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (!this.a.c)
      {
        this.a.g();
        this.a.b.removeMessages(1000);
        this.a.b.sendEmptyMessageDelayed(1000, this.a.n);
        continue;
        NearbyActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adru
 * JD-Core Version:    0.7.0.1
 */