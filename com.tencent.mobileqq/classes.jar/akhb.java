import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceDecodeTask.FaceDecodeThreadInfo;
import java.util.ArrayList;

public class akhb
  implements Runnable
{
  private boolean a = true;
  
  public void a()
  {
    this.a = false;
  }
  
  public void run()
  {
    Object localObject1 = Thread.currentThread();
    ((Thread)localObject1).setName("FaceDecodeThread" + ((Thread)localObject1).getId());
    localObject1 = BaseApplicationImpl.processName;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals("com.tencent.mobileqq"))) {
      Process.setThreadPriority(-8);
    }
    for (;;)
    {
      localObject1 = null;
      label57:
      if (this.a) {
        synchronized (FaceDecodeTask.a)
        {
          int i = FaceDecodeTask.a.size();
          if (i == 0) {}
          try
          {
            FaceDecodeTask.a.wait();
            localObject3 = localObject1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              Object localObject3;
              Object localObject4 = localObject2;
            }
          }
          localObject1 = localObject3;
          if (localObject3 == null) {
            break label57;
          }
          ((FaceDecodeTask)localObject3).a();
          localObject1 = localObject3;
          break label57;
          if (FaceDecodeTask.b().b != -2147483648)
          {
            Process.setThreadPriority(FaceDecodeTask.b().b);
            continue;
            localObject3 = (FaceDecodeTask)FaceDecodeTask.a.remove(0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhb
 * JD-Core Version:    0.7.0.1
 */