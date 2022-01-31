import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.ProcessStats;
import com.tencent.mobileqq.app.ProcessStats.Stats;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.qphone.base.util.QLog;

public class aisi
  implements FPSCalculator.GetFPSListener
{
  public aisi(PreDownloadScheduler paramPreDownloadScheduler) {}
  
  public void a(long paramLong, double paramDouble)
  {
    if (!PreDownloadScheduler.a(this.a)) {
      return;
    }
    if (!PreDownloadScheduler.b(this.a))
    {
      PreDownloadScheduler.a(this.a, paramLong);
      PreDownloadScheduler.a(this.a, paramDouble);
      PreDownloadScheduler.b(this.a, ProcessStats.a.a);
      if (PreDownloadScheduler.a(this.a) > PreDownloadScheduler.b(this.a))
      {
        if (!PreDownloadScheduler.c(this.a))
        {
          PreDownloadScheduler.a(this.a);
          if (PreDownloadScheduler.b(this.a) >= PreDownloadScheduler.c(this.a))
          {
            PreDownloadScheduler.a(this.a, true);
            PreDownloadScheduler.b(this.a, 0L);
          }
        }
        if (PreDownloadScheduler.c(this.a) >= PreDownloadScheduler.d(this.a)) {
          break label502;
        }
        if (!PreDownloadScheduler.d(this.a))
        {
          PreDownloadScheduler.d(this.a);
          if (PreDownloadScheduler.e(this.a) >= PreDownloadScheduler.c(this.a))
          {
            PreDownloadScheduler.b(this.a, true);
            PreDownloadScheduler.c(this.a, 0L);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject;
      if (((!PreDownloadScheduler.d(this.a)) || (!PreDownloadScheduler.c(this.a))) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder("[system info]:");
        ((StringBuilder)localObject).append(",mCurFPSTime=").append(PreDownloadScheduler.f(this.a));
        ((StringBuilder)localObject).append(",mCurFPS=").append(PreDownloadScheduler.a(this.a));
        ((StringBuilder)localObject).append(",mCurCPU=").append(PreDownloadScheduler.c(this.a));
        ((StringBuilder)localObject).append(",mFPSReadyCount=").append(PreDownloadScheduler.b(this.a));
        ((StringBuilder)localObject).append(",mCPUReadyCount=").append(PreDownloadScheduler.e(this.a));
        ((StringBuilder)localObject).append(",mFPSReady=").append(PreDownloadScheduler.c(this.a));
        ((StringBuilder)localObject).append(",mCPUReady=").append(PreDownloadScheduler.d(this.a));
        QLog.d("PreDownloadScheduler", 2, ((StringBuilder)localObject).toString());
      }
      PreDownloadScheduler.a(this.a).sendEmptyMessage(1005);
      return;
      Bundle localBundle;
      if ((PreDownloadScheduler.d(this.a)) && (PreDownloadScheduler.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", PreDownloadScheduler.a(this.a));
        localBundle.putDouble("CPU", PreDownloadScheduler.c(this.a));
        ((Message)localObject).obj = localBundle;
        PreDownloadScheduler.a(this.a).sendMessage((Message)localObject);
      }
      PreDownloadScheduler.a(this.a, false);
      PreDownloadScheduler.b(this.a, 0L);
      break;
      label502:
      if ((PreDownloadScheduler.d(this.a)) && (PreDownloadScheduler.c(this.a)))
      {
        localObject = new Message();
        ((Message)localObject).what = 1007;
        localBundle = new Bundle();
        localBundle.putDouble("FPS", PreDownloadScheduler.a(this.a));
        localBundle.putDouble("CPU", PreDownloadScheduler.c(this.a));
        ((Message)localObject).obj = localBundle;
        PreDownloadScheduler.a(this.a).sendMessage((Message)localObject);
      }
      PreDownloadScheduler.b(this.a, false);
      PreDownloadScheduler.c(this.a, 0L);
      continue;
      PreDownloadScheduler.b(this.a, true);
      PreDownloadScheduler.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisi
 * JD-Core Version:    0.7.0.1
 */