import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.tencent.mobileqq.ar.config.MainEntryAni;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class aaqc
  implements OnCompositionLoadedListener
{
  public aaqc(MainEntryAni paramMainEntryAni, aaqf paramaaqf, aaqg paramaaqg, String paramString) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_Aaqf.d.get();
    Object localObject = new StringBuilder().append("onCompositionLoaded, rollView[");
    if (localImageView != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("WorldCupMgr", 1, bool + "]");
      if (localImageView != null) {
        break;
      }
      MainEntryAni.a(this.jdField_a_of_type_ComTencentMobileqqArConfigMainEntryAni, this.jdField_a_of_type_Aaqf);
      return;
    }
    localObject = new LottieDrawable();
    ((LottieDrawable)localObject).setImageAssetDelegate(new aaqd(this));
    ((LottieDrawable)localObject).addAnimatorListener(new aaqe(this));
    ((LottieDrawable)localObject).setImagesAssetsFolder(this.jdField_a_of_type_JavaLangString);
    ((LottieDrawable)localObject).setComposition(paramLottieComposition);
    ((LottieDrawable)localObject).loop(false);
    ((LottieDrawable)localObject).playAnimation();
    localImageView.setImageDrawable((Drawable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqc
 * JD-Core Version:    0.7.0.1
 */