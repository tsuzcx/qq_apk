import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil.GetFileInfoCallBack;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class adhx
  implements UniformDownloadUtil.GetFileInfoCallBack
{
  public adhx(UniformDownloadMgr paramUniformDownloadMgr) {}
  
  public void a(String paramString, long paramLong)
  {
    if (UniformDownloadUtil.a(paramString))
    {
      StatisticAssist.a(this.a.a.getApplication().getApplicationContext(), this.a.a.getCurrentAccountUin(), "Stop_download_2-2_3-0");
      return;
    }
    StatisticAssist.a(this.a.a.getApplication().getApplicationContext(), this.a.a.getCurrentAccountUin(), "Stop_download_2-2_3-1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adhx
 * JD-Core Version:    0.7.0.1
 */