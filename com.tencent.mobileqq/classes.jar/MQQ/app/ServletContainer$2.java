package mqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class ServletContainer$2
  implements Runnable
{
  ServletContainer$2(ServletContainer paramServletContainer, String paramString, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      Servlet localServlet = this.this$0.getServlet(this.val$className);
      if (localServlet != null)
      {
        localServlet.service(this.val$form);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("mqq", 1, "", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.ServletContainer.2
 * JD-Core Version:    0.7.0.1
 */