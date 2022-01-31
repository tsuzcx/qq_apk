import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;

class aerw
  implements ImageAssetDelegate
{
  aerw(aert paramaert) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = 320;
    try
    {
      paramLottieImageAsset = bdda.a(aert.a(this.a) + "images/" + paramLottieImageAsset.getFileName(), localOptions);
      return paramLottieImageAsset;
    }
    catch (Exception paramLottieImageAsset)
    {
      QLog.e("LottieAnimDirector", 1, "Delegate decode bitmap error");
      return null;
    }
    catch (OutOfMemoryError paramLottieImageAsset)
    {
      QLog.e("LottieAnimDirector", 1, "Delegate decode bitmap OOM");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aerw
 * JD-Core Version:    0.7.0.1
 */