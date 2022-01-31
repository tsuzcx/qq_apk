import android.os.MessageQueue.IdleHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.IdleTask;
import java.util.ArrayList;

public class akqo
  implements MessageQueue.IdleHandler
{
  public akqo(SwiftBrowserIdleTaskHelper paramSwiftBrowserIdleTaskHelper) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!SwiftBrowserIdleTaskHelper.a().isEmpty())
    {
      localObject = (SwiftBrowserIdleTaskHelper.IdleTask)SwiftBrowserIdleTaskHelper.a().remove(0);
      i = ((SwiftBrowserIdleTaskHelper.IdleTask)localObject).a();
      if (2 == i) {
        SwiftBrowserIdleTaskHelper.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (SwiftBrowserIdleTaskHelper.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((SwiftBrowserIdleTaskHelper)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akqo
 * JD-Core Version:    0.7.0.1
 */