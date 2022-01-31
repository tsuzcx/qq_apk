import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class adsj
  implements ValueAnimator.AnimatorUpdateListener
{
  public adsj(MedalGuideView paramMedalGuideView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue("alpha")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(f);
    f = ((Float)paramValueAnimator.getAnimatedValue("translate")).floatValue();
    this.a.jdField_a_of_type_ComTencentImageURLImageView.setTranslationY(f);
    f = paramValueAnimator.getAnimatedFraction();
    if ((!this.a.c) && (f >= 0.8857143F))
    {
      this.a.c = true;
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "send MSG_START_3D_ROTATE");
      }
    }
    if (f >= 1.0F) {
      paramValueAnimator.removeAllUpdateListeners();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adsj
 * JD-Core Version:    0.7.0.1
 */