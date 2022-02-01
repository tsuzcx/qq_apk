import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.1;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.2;

public class acex
{
  public acei a;
  protected Context a;
  protected Handler a;
  
  protected acex(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(acei paramacei)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramacei.h.getLayoutParams();
    localLayoutParams.height = paramacei.n;
    localLayoutParams.width = paramacei.o;
    localLayoutParams.addRule(3, 0);
    localLayoutParams.addRule(12, 0);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    paramacei.h.setLayoutParams(localLayoutParams);
    paramacei.h.postInvalidate();
  }
  
  public static void a(View paramView)
  {
    if ((paramView == null) || (paramView.getVisibility() != 0)) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(8);
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(100L);
    paramView.startAnimation(localAlphaAnimation);
    paramView.setVisibility(0);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Acei == null) || (this.jdField_a_of_type_Acei.g == null)) {
      return;
    }
    a(this.jdField_a_of_type_Acei.g);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtMvViewAnimationAbs.1(this), 300L);
  }
  
  public void a(int paramInt) {}
  
  protected void a(acei paramacei, View paramView)
  {
    paramacei.h = paramView;
    paramacei.o = aciv.a(470, 750, aciv.f(this.jdField_a_of_type_AndroidContentContext));
    paramacei.n = aciv.a(470, 1334, aciv.e(this.jdField_a_of_type_AndroidContentContext));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, paramInt1, paramInt2, -1);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.topMargin;
    int j = localLayoutParams.leftMargin;
    int k = localLayoutParams.rightMargin;
    a(paramView);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtMvViewAnimationAbs.2(this, localLayoutParams, i, paramInt1, j, paramInt2, paramInt3, k, paramView), 200L);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acex
 * JD-Core Version:    0.7.0.1
 */