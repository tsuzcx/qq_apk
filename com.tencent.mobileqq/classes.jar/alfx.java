import android.graphics.Bitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;

class alfx
  implements ImageAssetDelegate
{
  alfx(alfw paramalfw) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    paramLottieImageAsset = this.a.a + paramLottieImageAsset.getFileName();
    QLog.i("WorldCupShareFragment", 1, "initLoadingAnimation. fetchBitmap. imageFileName = " + paramLottieImageAsset);
    try
    {
      paramLottieImageAsset = SafeBitmapFactory.decodeFile(paramLottieImageAsset);
      if (paramLottieImageAsset != null) {}
      return paramLottieImageAsset;
    }
    catch (Exception paramLottieImageAsset)
    {
      QLog.i("WorldCupShareFragment", 2, "initLoadingAnimation failed. err = " + paramLottieImageAsset.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfx
 * JD-Core Version:    0.7.0.1
 */