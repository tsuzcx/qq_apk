package mqq.app;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

class ServletContainer$1
  implements ThreadFactory
{
  ServletContainer$1(ServletContainer paramServletContainer) {}
  
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "ServletForward");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.ServletContainer.1
 * JD-Core Version:    0.7.0.1
 */