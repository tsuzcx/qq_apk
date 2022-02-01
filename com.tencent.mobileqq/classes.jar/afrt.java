import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.PanelStrategy.1;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.qphone.base.util.QLog;

public class afrt
  implements akxc
{
  public afrt(CustomizeStrategyFactory.PanelStrategy.1 param1) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    paramPathResult = paramPathResult.filePath;
    if (paramInt == 0) {}
    try
    {
      Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramPathResult, bheg.a(paramPathResult, (int)(CustomizeStrategyFactory.a * 50.0F + 0.5D)));
      if (localBitmap != null) {
        this.a.a.icon = localBitmap;
      }
      this.a.a.resPath = paramPathResult;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "PanelStrategy info.icon=" + this.a.a.icon + ",resPath=" + this.a.a.resPath);
      }
    }
    catch (Throwable paramPathResult)
    {
      for (;;)
      {
        paramPathResult.printStackTrace();
      }
    }
    CustomizeStrategyFactory.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrt
 * JD-Core Version:    0.7.0.1
 */