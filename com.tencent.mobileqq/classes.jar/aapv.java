import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aapv
  implements OnCompositionLoadedListener
{
  public aapv(MainDownAni paramMainDownAni, aapz paramaapz, aaqg paramaaqg, String paramString) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_Aapz.e.get();
    Object localObject = MainDownAni.a(this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni);
    StringBuilder localStringBuilder = new StringBuilder().append("onCompositionLoaded, downAniView[");
    if (localImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w((String)localObject, 1, bool + "]");
      if (localImageView != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqArConfigMainDownAni.a();
      return;
    }
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setImageAssetDelegate(new aapw(this));
    ((LottieDrawable)localObject).addAnimatorListener(new aapx(this));
    ((LottieDrawable)localObject).setImagesAssetsFolder(this.jdField_a_of_type_JavaLangString);
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).loop(false);
    ((LottieDrawable)localObject).playAnimation();
    localImageView.setImageDrawable((Drawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapv
 * JD-Core Version:    0.7.0.1
 */