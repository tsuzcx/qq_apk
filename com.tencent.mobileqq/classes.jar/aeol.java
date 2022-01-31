import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import java.io.File;

class aeol
  implements ImageAssetDelegate
{
  aeol(aeok paramaeok) {}
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    paramLottieImageAsset = this.a.a + File.separator + paramLottieImageAsset;
    boolean bool = new File(paramLottieImageAsset).exists();
    if (QLog.isColorLevel()) {
      QLog.d("IntimateTitleSwitchView", 0, "fetchBitmap exists:" + bool + " imagePath:" + paramLottieImageAsset);
    }
    if (!bool) {
      return null;
    }
    Object localObject = BaseApplicationImpl.sImageCache.get(paramLottieImageAsset);
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeFile(paramLottieImageAsset, (BitmapFactory.Options)localObject);
      BaseApplicationImpl.sImageCache.put(paramLottieImageAsset, localObject);
      return localObject;
    }
    catch (Throwable paramLottieImageAsset)
    {
      QLog.i("IntimateTitleSwitchView", 0, "fetchBitmap error " + paramLottieImageAsset.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeol
 * JD-Core Version:    0.7.0.1
 */