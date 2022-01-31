import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ARMapHongBaoListView;
import mqq.app.Constants.LogoutReason;

public class alij
  implements Handler.Callback
{
  public int a;
  public Activity a;
  public Handler a;
  public ViewGroup a;
  public Interpolator a;
  public FrameLayout a;
  public ImageView a;
  public Animator.AnimatorListener a;
  public ValueAnimator a;
  public Conversation a;
  public ARMapHongBaoListView a;
  public String a;
  public boolean a;
  public int b;
  public Animator.AnimatorListener b;
  public ValueAnimator b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public boolean e;
  public boolean f = true;
  public boolean g = befo.e();
  public boolean h;
  
  public alij(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_a_of_type_AndroidAppActivity = paramConversation.a();
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  private void a(View paramView1, View paramView2)
  {
    this.jdField_d_of_type_Int = (((RelativeLayout.LayoutParams)paramView2.getLayoutParams()).topMargin + paramView2.getHeight());
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.addRule(3, 0);
    paramView2.topMargin = this.jdField_d_of_type_Int;
    paramView1.setLayoutParams(paramView2);
    this.h = true;
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2, View paramView3)
  {
    if (!this.h) {
      a(paramView2, paramView1);
    }
    if (this.jdField_d_of_type_Int <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new alin(this, paramView2, paramView1, paramView3));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new alio(this, paramView3);
    }
    if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  @TargetApi(11)
  private void b(View paramView1, View paramView2, View paramView3)
  {
    if (!this.h) {
      a(paramView2, paramView1);
    }
    if (this.jdField_d_of_type_Int <= 0) {
      return;
    }
    paramView2 = (RelativeLayout.LayoutParams)paramView1.getLayoutParams();
    if (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator == null)
    {
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setDuration(300L);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addUpdateListener(new alip(this, paramView2, paramView1, paramView3));
      this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener = new aliq(this, paramView3, paramView1);
    }
    if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.addListener(this.jdField_b_of_type_ComNineoldandroidsAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.start();
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "springBackPromptly, offset=" + paramInt + ",delay=" + paramLong);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 1003);
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason)
  {
    if (!b()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onLogout");
    }
    a();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    try
    {
      if (!b()) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "onNetStateChanged, isNetSupport=" + paramBoolean);
      }
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("ConversationPullDownActiveBase", 2, "onNetStateChanged error" + localThrowable.getMessage());
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "springBackPromptly, offset=" + paramInt);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSelection(0);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.setSpringbackOffset(paramInt);
    this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.springBackTo(this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.jdField_c_of_type_Int);
  }
  
  @TargetApi(11)
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle  direct=" + paramBoolean + "  mTitleIsVisible:" + this.f + "  mTitleBarOffset:" + this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null) {}
    View localView1;
    View localView2;
    View localView3;
    do
    {
      do
      {
        return;
        localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
        localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
        localView3 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b();
        if ((localView1 != null) && (localView2 != null) && (localView3 != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle  exit title:" + localView1 + "  head:" + localView2 + "  container:" + localView3);
      return;
      if (paramBoolean)
      {
        if ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
        {
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
          this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
        }
        if ((this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator != null) && (this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()))
        {
          this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.removeAllListeners();
          this.jdField_b_of_type_ComNineoldandroidsAnimationValueAnimator.cancel();
        }
        p();
        this.f = true;
        return;
      }
      if (!this.f) {
        break;
      }
    } while ((this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator == null) || (this.jdField_a_of_type_ComNineoldandroidsAnimationValueAnimator.isRunning()) || (((RelativeLayout.LayoutParams)localView1.getLayoutParams()).topMargin == 0));
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "showTitle catch a display exception");
    }
    p();
    return;
    this.f = true;
    a(localView1, localView3, localView2);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d(int paramInt) {}
  
  @TargetApi(11)
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "hideTitle direct=" + paramBoolean + "  mTitleIsVisible:" + this.f + "  mTitleBarOffset:" + this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null) {}
    View localView2;
    do
    {
      View localView1;
      do
      {
        do
        {
          return;
        } while (!this.f);
        localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
        localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.b();
        if ((localView1 != null) && (localView2 != null) && (localObject != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConversationPullDownActiveBase", 2, "hideTitle exit  title:" + localView1 + "  head:" + localView2 + "  container:" + localObject);
      return;
      this.f = false;
      if (!paramBoolean)
      {
        b(localView1, (View)localObject, localView2);
        return;
      }
      Object localObject = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = (-this.jdField_d_of_type_Int);
      localView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localView2.setVisibility(8);
    } while (!this.g);
    localView2.setAlpha(0.0F);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
  }
  
  public void f()
  {
    if (!b()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "onDestroy");
      }
      a();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getHeight();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.getWidth();
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getDisplayMetrics().heightPixels - this.jdField_c_of_type_Int);
      }
      if (this.jdField_b_of_type_Int <= 0) {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getDisplayMetrics().widthPixels;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ConversationPullDownActiveBase", 2, "reInitListViewSize  mListViewHeight:" + this.jdField_a_of_type_Int + "  mListViewWidth:" + this.jdField_b_of_type_Int);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "removeSpringBackPromptly");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1001: 
      n();
      o();
      return false;
    case 1002: 
      d();
      return false;
    }
    int j = paramMessage.arg1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    c(i);
    return false;
  }
  
  public void i()
  {
    if (!b()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onBeforeAccountChanged");
    }
    a();
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1002);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1002, 800L);
  }
  
  public void k() {}
  
  public void l()
  {
    if (!b()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "onDrawerOpened");
    }
    c(true);
  }
  
  public void m() {}
  
  public void n()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301966));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "stopGestureGuide");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1001);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131301966));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "doGestureGuide  this=" + this);
    }
    AnimationSet localAnimationSet = new AnimationSet(false);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(1L);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
    localAlphaAnimation.setAnimationListener(new alik(this));
    int i = (int)this.jdField_a_of_type_AndroidViewViewGroup.getResources().getDimension(2131166937);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 0, -this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a(), 0, i + -this.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.a());
    localTranslateAnimation.setDuration(1500L);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    localTranslateAnimation.setAnimationListener(new alil(this));
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setStartOffset(1000L);
    localAlphaAnimation.setAnimationListener(new alim(this));
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
  }
  
  @TargetApi(11)
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConversationPullDownActiveBase", 2, "resetTitle  mTitleIsVisible:" + this.f + "  mTitleBarOffset:" + this.jdField_d_of_type_Int);
    }
    View localView1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
    View localView2 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c();
    if ((localView1 == null) || (localView2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConversationPullDownActiveBase", 2, "resetTitle exit title:" + localView1 + "  head:" + localView2);
      }
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView1.getLayoutParams();
    localLayoutParams.topMargin = 0;
    localView1.setLayoutParams(localLayoutParams);
    if (this.g) {
      localView2.setAlpha(1.0F);
    }
    localView2.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alij
 * JD-Core Version:    0.7.0.1
 */