import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;

class ahoh
  extends AnimatorListenerAdapter
{
  ahoh(ahog paramahog, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    EffectsCameraCaptureFragment.a(this.jdField_a_of_type_Ahog.a).setAlpha(1.0F);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    EffectsCameraCaptureFragment.a(this.jdField_a_of_type_Ahog.a).setVisibility(0);
    if (EffectsCameraCaptureFragment.a(this.jdField_a_of_type_Ahog.a) != null)
    {
      paramAnimator = URLDrawable.URLDrawableOptions.obtain();
      int i = UIUtils.a(this.jdField_a_of_type_Ahog.a.getActivity(), 21.0F);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(Color.parseColor("#EE1E23"));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(i, i);
      paramAnimator.mRequestWidth = i;
      paramAnimator.mRequestHeight = i;
      paramAnimator.mFailedDrawable = localGradientDrawable;
      paramAnimator.mLoadingDrawable = localGradientDrawable;
      paramAnimator = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.advertiseIconUrl, paramAnimator);
      paramAnimator.setTag(URLDrawableDecodeHandler.a(i, i));
      paramAnimator.setDecodeHandler(URLDrawableDecodeHandler.a);
      EffectsCameraCaptureFragment.a(this.jdField_a_of_type_Ahog.a).setImageDrawable(paramAnimator);
    }
    if (EffectsCameraCaptureFragment.f(this.jdField_a_of_type_Ahog.a) != null) {
      EffectsCameraCaptureFragment.f(this.jdField_a_of_type_Ahog.a).setText(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.advertiseStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahoh
 * JD-Core Version:    0.7.0.1
 */