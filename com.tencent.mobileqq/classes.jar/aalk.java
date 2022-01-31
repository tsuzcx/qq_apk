import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.1;
import com.tencent.gdtad.api.motivevideo.GdtMvViewAnimationAbs.2;

public class aalk
{
  public aalc a;
  protected Context a;
  protected Handler a;
  
  protected aalk(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(aalc paramaalc)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramaalc.h.getLayoutParams();
    localLayoutParams.height = paramaalc.n;
    localLayoutParams.width = paramaalc.o;
    localLayoutParams.addRule(3, 0);
    localLayoutParams.addRule(12, 0);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    paramaalc.h.setLayoutParams(localLayoutParams);
    paramaalc.h.postInvalidate();
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
    if ((this.jdField_a_of_type_Aalc == null) || (this.jdField_a_of_type_Aalc.g == null)) {
      return;
    }
    a(this.jdField_a_of_type_Aalc.g);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new GdtMvViewAnimationAbs.1(this), 300L);
  }
  
  public void a(int paramInt) {}
  
  protected void a(aalc paramaalc, View paramView)
  {
    paramaalc.h = paramView;
    paramaalc.o = aapa.a(470, 750, aapa.f(this.jdField_a_of_type_AndroidContentContext));
    paramaalc.n = aapa.a(470, 1334, aapa.e(this.jdField_a_of_type_AndroidContentContext));
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
 * Qualified Name:     aalk
 * JD-Core Version:    0.7.0.1
 */