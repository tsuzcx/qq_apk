import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class ahes
  implements ImageAssetDelegate
{
  private Context a;
  
  public ahes(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    try
    {
      paramLottieImageAsset = this.a.getAssets().open("login_btn_lottie_images/" + paramLottieImageAsset.getFileName());
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeStream(paramLottieImageAsset, (Rect)null, (BitmapFactory.Options)localObject);
      paramLottieImageAsset.close();
      return localObject;
    }
    catch (Throwable paramLottieImageAsset)
    {
      QLog.i("LoginBtnImageAssetDelegate", 2, "fetchBitmap error " + paramLottieImageAsset.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahes
 * JD-Core Version:    0.7.0.1
 */