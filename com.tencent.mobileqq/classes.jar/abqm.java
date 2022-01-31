import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;

public class abqm
  implements Handler.Callback
{
  private String a;
  
  public abqm(String paramString)
  {
    this.a = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    NearbyProcessMonitor.a(this.a, 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqm
 * JD-Core Version:    0.7.0.1
 */