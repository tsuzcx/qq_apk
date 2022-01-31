import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.ColorScreenLoader;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

public class abfl
  implements ImageAssetDelegate
{
  public abfl(FriendProfileCardActivity.ColorScreenLoader paramColorScreenLoader) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    return (Bitmap)BaseApplicationImpl.sImageCache.get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abfl
 * JD-Core Version:    0.7.0.1
 */