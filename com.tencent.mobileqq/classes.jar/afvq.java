import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class afvq
  implements ImageAssetDelegate
{
  afvq(afvo paramafvo, String paramString) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject1;
    if (afvo.a(this.jdField_a_of_type_Afvo) == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inScaled = true;
      ((BitmapFactory.Options)localObject2).inDensity = afvo.a(this.jdField_a_of_type_Afvo).getContext().getResources().getDisplayMetrics().densityDpi;
      try
      {
        String str = this.jdField_a_of_type_JavaLangString + File.separator + paramLottieImageAsset.getFileName();
        if (afvo.a(this.jdField_a_of_type_Afvo) != null)
        {
          paramLottieImageAsset = (Bitmap)afvo.a(this.jdField_a_of_type_Afvo).get(str);
          localObject1 = paramLottieImageAsset;
          if (paramLottieImageAsset != null) {
            continue;
          }
          try
          {
            localObject2 = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject2);
            localObject1 = localObject2;
            paramLottieImageAsset = (LottieImageAsset)localObject2;
            if (afvo.a(this.jdField_a_of_type_Afvo) == null) {
              continue;
            }
            paramLottieImageAsset = (LottieImageAsset)localObject2;
            afvo.a(this.jdField_a_of_type_Afvo).put(str, localObject2);
            return localObject2;
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim setImageAssetDelegate Exception");
          }
          localException1.printStackTrace();
          return paramLottieImageAsset;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramLottieImageAsset = null;
          continue;
          paramLottieImageAsset = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvq
 * JD-Core Version:    0.7.0.1
 */