import android.os.Bundle;
import com.tencent.mobileqq.statistics.DailyReport;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;

public class aifs
  extends DownloadListener
{
  public aifs(DailyReport paramDailyReport, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    long l = paramDownloadTask.a().getLong("id");
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(l), 0, 0, 0, 0, AvatarPendantUtil.a(new File(AvatarPendantUtil.b(l, 4))), "");
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifs
 * JD-Core Version:    0.7.0.1
 */