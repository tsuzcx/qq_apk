import android.text.TextUtils;
import com.tencent.mobileqq.bubble.BubbleManager;
import java.io.File;
import org.json.JSONArray;

public class ablm
  implements Runnable
{
  public ablm(BubbleManager paramBubbleManager) {}
  
  public void run()
  {
    synchronized (this.a)
    {
      Object localObject1 = new File(this.a.a(), "bubble_local.cfg");
      boolean bool = ((File)localObject1).exists();
      if (bool) {}
      try
      {
        localObject1 = this.a.a(((File)localObject1).getAbsolutePath());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          this.a.a = new JSONArray((String)localObject1);
        }
        if (this.a.a == null) {
          this.a.a = new JSONArray();
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablm
 * JD-Core Version:    0.7.0.1
 */