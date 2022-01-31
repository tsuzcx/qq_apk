import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.vashealth.HealthPathTracePlugin;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class akrm
  extends Handler
{
  public akrm(PathTraceManager paramPathTraceManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      try
      {
        paramMessage = (JSONObject)paramMessage.obj;
        String str = paramMessage.getString("callback");
        if (this.a.a != null)
        {
          HealthPathTracePlugin localHealthPathTracePlugin = (HealthPathTracePlugin)this.a.a.get();
          if (localHealthPathTracePlugin != null)
          {
            localHealthPathTracePlugin.callJs(str, new String[] { paramMessage.toString() });
            return;
          }
        }
      }
      catch (Exception paramMessage) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akrm
 * JD-Core Version:    0.7.0.1
 */