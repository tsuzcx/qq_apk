import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.troopgift.TroopGiftActionButton;
import com.tencent.mobileqq.util.DisplayUtil;
import org.json.JSONObject;

public class akcd
  implements View.OnTouchListener
{
  public akcd(TroopGiftActionButton paramTroopGiftActionButton, TextView paramTextView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      paramMotionEvent = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
      paramMotionEvent.setDuration(100L);
      paramMotionEvent.setAnimationListener(new akce(this));
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(paramMotionEvent);
      paramMotionEvent = new ImageView(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.getContext());
      Object localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setShape(1);
      ((GradientDrawable)localObject).setCornerRadius(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.getContext(), 56.0F));
      ((GradientDrawable)localObject).setColor(Color.parseColor(TroopGiftActionButton.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton).optString("buttonEffectColor")));
      ((GradientDrawable)localObject).setAlpha(192);
      paramMotionEvent.setImageDrawable((Drawable)localObject);
      localObject = new RelativeLayout.LayoutParams(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.getContext(), 56.0F), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.getContext(), 56.0F));
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.addView(paramMotionEvent, (ViewGroup.LayoutParams)localObject);
      localObject = new ScaleAnimation(1.0F, 1.7F, 1.0F, 1.7F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(150L);
      ((ScaleAnimation)localObject).setAnimationListener(new akcf(this, paramMotionEvent));
      paramMotionEvent.startAnimation((Animation)localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftActionButton.a.onClick(paramView);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcd
 * JD-Core Version:    0.7.0.1
 */