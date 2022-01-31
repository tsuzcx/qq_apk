import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aajt
  implements ImageAssetDelegate
{
  aajt(aajs paramaajs) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    String str = paramLottieImageAsset.getFileName();
    Bitmap localBitmap = (Bitmap)this.a.a.b.get(str);
    paramLottieImageAsset = localBitmap;
    if (localBitmap == null)
    {
      QLog.w("WorldCupMgr", 1, "loadBtnAnimation, 加载图片失败, image[" + str + "]");
      paramLottieImageAsset = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    }
    return paramLottieImageAsset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajt
 * JD-Core Version:    0.7.0.1
 */