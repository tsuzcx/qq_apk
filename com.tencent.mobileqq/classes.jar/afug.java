import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.widget.immersive.ImmersiveUtils;

public class afug
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, View.OnTouchListener, IMiniMsgUnreadCallback
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private afuj jdField_a_of_type_Afuj;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public afug(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.d = paramInt1;
    this.e = paramInt2;
    this.k = paramInt3;
    this.c = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
    paramActivity = BaseApplicationImpl.getApplication().getBaseContext();
    paramInt1 = paramActivity.getResources().getDisplayMetrics().widthPixels;
    paramInt3 = paramActivity.getResources().getDisplayMetrics().heightPixels;
    int m = paramActivity.getResources().getDimensionPixelSize(2131166108);
    int n = paramActivity.getResources().getDimensionPixelSize(2131166109);
    int i2 = paramActivity.getResources().getDimensionPixelSize(2131166107);
    int i1 = bajq.b(56.0F);
    this.f = paramInt1;
    this.i = m;
    this.j = (paramInt3 - i2);
    i2 = this.c;
    int i3 = bajq.a(7.0F);
    int i4 = this.i;
    if (paramInt4 != -1)
    {
      this.jdField_a_of_type_Int = paramInt4;
      this.jdField_b_of_type_Int = paramInt5;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramActivity, new afuh(this));
      this.jdField_a_of_type_Afuj = afuk.a();
      if (this.jdField_a_of_type_Afuj == null) {
        this.jdField_a_of_type_Afuj = new afuj();
      }
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, "configData : " + this.jdField_a_of_type_Afuj.toString());
      }
      return;
      if (paramInt2 != 0)
      {
        this.jdField_a_of_type_Int = (paramInt1 - m * 4);
        this.jdField_b_of_type_Int = (i2 + i3);
      }
      else
      {
        this.jdField_a_of_type_Int = (paramInt1 - i1 - i4);
        this.jdField_b_of_type_Int = (paramInt3 - n);
      }
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(this);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int m = paramInt2;
    if (paramInt2 < this.c) {
      m = this.c;
    }
    int n = m;
    if (m > this.j) {
      n = this.j;
    }
    paramInt2 = paramInt1;
    if (paramInt1 < this.i) {
      paramInt2 = this.i;
    }
    paramInt1 = paramInt2;
    if (paramInt2 > this.jdField_a_of_type_Int) {
      paramInt1 = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = n;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramInt1;
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(paramView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
  
  public int[] a()
  {
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null) {
      localObject = null;
    }
    int[] arrayOfInt;
    do
    {
      return localObject;
      arrayOfInt = new int[2];
      localObject = arrayOfInt;
    } while (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams == null);
    arrayOfInt[0] = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x;
    arrayOfInt[1] = this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y;
    return arrayOfInt;
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void hide()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void hideUnread()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131304579).setVisibility(8);
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int m = this.jdField_a_of_type_Int;
    if (this.g < this.f / 2) {
      m = this.i;
    }
    int n = this.g;
    m = (int)((m - this.g) * f1) + n;
    com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, "onAnimationUpdate .curPx = " + m + " ,mTouchUpX = " + this.g);
    n = this.h;
    a(this.jdField_a_of_type_AndroidViewView, m, n);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int m = 0;
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return false;
    }
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    if (this.e != 0) {
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if ((!bool) && (m != 0)) {
        a();
      }
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      continue;
      a(paramView, (int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
      continue;
      a(paramView, (int)(f1 - this.jdField_a_of_type_Float), (int)(f2 - this.jdField_b_of_type_Float));
      this.g = ((int)(f1 - this.jdField_a_of_type_Float));
      this.h = ((int)(f2 - this.jdField_b_of_type_Float));
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_a_of_type_Float = 0.0F;
      m = 1;
    }
  }
  
  public boolean show(int paramInt)
  {
    if (!this.jdField_a_of_type_AndroidAppActivity.hasWindowFocus()) {
      return false;
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d("mini_msg_FloatViewManager", 2, "styleType = " + this.e + ",filterType = " + this.d);
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = View.inflate(localActivity.getApplicationContext(), 2131493706, null);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(this);
      Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131304577);
      ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304578);
      Object localObject1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304579);
      localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
      localObject1 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      if (this.e != 0)
      {
        m = bajq.b(38.0F);
        n = bajq.b(32.0F);
        ((RelativeLayout.LayoutParams)localObject2).width = m;
        ((RelativeLayout.LayoutParams)localObject2).height = n;
        m = bajq.b(24.0F);
        localLayoutParams.width = m;
        localLayoutParams.height = m;
        localLayoutParams.leftMargin = bajq.b(4.0F);
        localImageView.setPadding(0, 0, 0, 0);
        localImageView.setBackgroundDrawable(null);
        localImageView.setImageResource(2130840653);
        if (this.k != 1) {
          localImageView.setImageResource(2130840655);
        }
      }
      if (AppSetting.c) {
        azve.b(this.jdField_a_of_type_AndroidViewView, false);
      }
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localActivity.getApplicationContext().getSystemService("window"));
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("mini_msg_FloatViewManager", 0, "is activity window focused " + localActivity.hasWindowFocus());
      }
      int m = this.jdField_a_of_type_Int;
      int n = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1002;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 40;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = m;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = n;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.token = localActivity.getWindow().getDecorView().getWindowToken();
      this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    if (!this.jdField_a_of_type_Afuj.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    updateUnreadCount(paramInt, false);
    return this.jdField_a_of_type_Boolean;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Afuj.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304579);
      String str = String.valueOf(paramInt);
      if (paramInt > 99) {
        str = "99+";
      }
      localTextView.setText(str);
      if ((!paramBoolean) && (paramInt > 0)) {
        localTextView.setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afug
 * JD-Core Version:    0.7.0.1
 */