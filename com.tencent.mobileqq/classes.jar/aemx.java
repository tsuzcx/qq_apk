import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.ThemeAnimStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.widget.AnimationView.AnimationInfo;
import com.tencent.qphone.base.util.QLog;

public class aemx
  implements aivw
{
  public aemx(CustomizeStrategyFactory.ThemeAnimStrategy.1 param1) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.folderPath;
    if (paramInt == 0) {}
    try
    {
      this.a.a.animInfo = AnimationView.AnimationInfo.loadFromFolder(paramPathResult);
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_AIO_REDPACKET background=" + this.a.a.background + ",animInfo=" + this.a.a.animInfo);
      }
      CustomizeStrategyFactory.a().a(this.a.a);
      return;
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aemx
 * JD-Core Version:    0.7.0.1
 */