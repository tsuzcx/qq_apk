import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.ar.config.SplashPopupWin;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aaqk
  implements OnCompositionLoadedListener
{
  public aaqk(SplashPopupWin paramSplashPopupWin, WeakReference paramWeakReference, aaqw paramaaqw, String paramString) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject = new StringBuilder().append("onCompositionLoaded, MovingView[");
    if (localImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("WorldCupMgr", 1, bool + "]");
      if (localImageView != null) {
        break;
      }
      return;
    }
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setImageAssetDelegate(new aaql(this));
    ((LottieDrawable)localObject).addAnimatorListener(new aaqm(this));
    ((LottieDrawable)localObject).setImagesAssetsFolder(this.jdField_a_of_type_JavaLangString);
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).loop(true);
    localImageView.setImageDrawable((Drawable)localObject);
    SplashPopupWin.a(this.jdField_a_of_type_ComTencentMobileqqArConfigSplashPopupWin, (LottieDrawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqk
 * JD-Core Version:    0.7.0.1
 */