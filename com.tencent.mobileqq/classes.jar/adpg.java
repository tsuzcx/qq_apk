import android.util.Log;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class adpg
  extends ScheduledThreadPoolExecutor
{
  public adpg(TimerTaskManager paramTimerTaskManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    Throwable localThrowable1 = paramThrowable;
    if (paramThrowable == null)
    {
      localThrowable1 = paramThrowable;
      if (!(paramRunnable instanceof Future)) {}
    }
    try
    {
      paramRunnable = (Future)paramRunnable;
      localThrowable1 = paramThrowable;
      if (paramRunnable.isDone())
      {
        paramRunnable.get();
        localThrowable1 = paramThrowable;
      }
    }
    catch (CancellationException localCancellationException)
    {
      break label46;
    }
    catch (ExecutionException paramRunnable)
    {
      for (;;)
      {
        localThrowable2 = paramRunnable.getCause();
      }
    }
    catch (InterruptedException paramRunnable)
    {
      for (;;)
      {
        label46:
        Throwable localThrowable2 = paramThrowable;
      }
    }
    if (localThrowable1 != null) {
      Log.e("LyricTimerTaskManager", "Exception happen when execute task! : " + localThrowable1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adpg
 * JD-Core Version:    0.7.0.1
 */