import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class ahcy
  implements ImageAssetDelegate
{
  ahcy(ahcx paramahcx) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    return (Bitmap)BaseApplicationImpl.sImageCache.get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcy
 * JD-Core Version:    0.7.0.1
 */