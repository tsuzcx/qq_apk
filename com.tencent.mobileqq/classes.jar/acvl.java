import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

public class acvl
  implements ahbr
{
  public acvl(CustomizeStrategyFactory.SkinRedPacketStrategy.1 param1) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {}
    try
    {
      this.a.a.resPath = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "TYPE_POP_ANIM path=" + paramPathResult);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acvl
 * JD-Core Version:    0.7.0.1
 */