import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class aajm
  implements ImageAssetDelegate
{
  aajm(aajl paramaajl) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    View localView = (View)this.a.a.d.get();
    Bitmap localBitmap2 = (Bitmap)this.a.a.a.a.a.get(paramLottieImageAsset.getFileName());
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      paramLottieImageAsset = new StringBuilder().append("loadRollAnimation, 加载图片失败, image[").append(paramLottieImageAsset.getFileName()).append("], canvas[");
      if (localView == null) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("WorldCupMgr", 1, bool + "]");
      localBitmap1 = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
      return localBitmap1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajm
 * JD-Core Version:    0.7.0.1
 */