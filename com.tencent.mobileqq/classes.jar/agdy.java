import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.WeakHashMap;

class agdy
  implements ImageAssetDelegate
{
  agdy(agdw paramagdw, String paramString) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inScaled = true;
    ((BitmapFactory.Options)localObject).inDensity = agdw.a(this.jdField_a_of_type_Agdw).a.getResources().getDisplayMetrics().densityDpi;
    try
    {
      String str = this.jdField_a_of_type_JavaLangString + File.separator + paramLottieImageAsset.getFileName();
      if (agdw.a(this.jdField_a_of_type_Agdw) != null)
      {
        paramLottieImageAsset = (Bitmap)agdw.a(this.jdField_a_of_type_Agdw).get(str);
        if (paramLottieImageAsset != null) {
          localObject = paramLottieImageAsset;
        }
        for (;;)
        {
          return localObject;
          try
          {
            Bitmap localBitmap = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
            localObject = localBitmap;
            paramLottieImageAsset = localBitmap;
            if (agdw.a(this.jdField_a_of_type_Agdw) != null)
            {
              paramLottieImageAsset = localBitmap;
              agdw.a(this.jdField_a_of_type_Agdw).put(str, localBitmap);
              return localBitmap;
            }
          }
          catch (Exception localException1) {}
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopEggLottieAnimView", 2, "playNextAnim setImageAssetDelegate Exception");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdy
 * JD-Core Version:    0.7.0.1
 */