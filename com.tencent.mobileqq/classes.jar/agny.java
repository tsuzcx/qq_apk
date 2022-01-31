import android.graphics.Bitmap;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class agny
  implements ImageAssetDelegate
{
  agny(agnx paramagnx) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    Bitmap localBitmap = (Bitmap)this.a.a.a.get(paramLottieImageAsset);
    QLog.i("ScanTorchActivity", 1, "loadWorldCupGuideAnimation. fetchBitmap. name = " + paramLottieImageAsset);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agny
 * JD-Core Version:    0.7.0.1
 */