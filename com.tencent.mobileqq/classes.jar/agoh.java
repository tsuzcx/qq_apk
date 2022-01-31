import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import java.lang.ref.WeakReference;

class agoh
  implements ImageAssetDelegate
{
  agoh(agog paramagog) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = (ImageView)this.a.a.a.get();
    BitmapFactory.Options localOptions;
    if (localObject != null)
    {
      paramLottieImageAsset = paramLottieImageAsset.getFileName();
      localOptions = new BitmapFactory.Options();
      localOptions.inDensity = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      localOptions.inTargetDensity = ((ImageView)localObject).getResources().getDisplayMetrics().densityDpi;
      localOptions.inScaled = true;
    }
    for (;;)
    {
      try
      {
        if (TextUtils.equals(paramLottieImageAsset, "img_0.png"))
        {
          paramLottieImageAsset = BitmapFactory.decodeResource(((ImageView)localObject).getResources(), 2130842260, localOptions);
          localObject = paramLottieImageAsset;
          if (paramLottieImageAsset == null) {
            localObject = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
          }
          return localObject;
        }
        if (TextUtils.equals(paramLottieImageAsset, "img_1.png"))
        {
          paramLottieImageAsset = BitmapFactory.decodeResource(((ImageView)localObject).getResources(), 2130842261, localOptions);
          continue;
        }
        if (TextUtils.equals(paramLottieImageAsset, "img_2.png"))
        {
          paramLottieImageAsset = BitmapFactory.decodeResource(((ImageView)localObject).getResources(), 2130842262, localOptions);
          continue;
        }
      }
      catch (Exception paramLottieImageAsset)
      {
        paramLottieImageAsset = null;
        continue;
      }
      paramLottieImageAsset = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agoh
 * JD-Core Version:    0.7.0.1
 */