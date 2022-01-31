import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.DragHandler.1;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;

public class aeki
  extends aekm
{
  int jdField_a_of_type_Int;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  int[] jdField_a_of_type_ArrayOfInt;
  RelativeLayout.LayoutParams b;
  
  public aeki(aekh paramaekh, Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramaekh, paramContext, paramViewGroup);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131708136));
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setElevation(10.0F);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setElevation(50.0F);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(10.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838040);
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.defaultFromStyle(1));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)(6.0F * paramaekh.e));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
    this.jdField_a_of_type_ArrayOfInt = new int[2];
  }
  
  AnimationSet a()
  {
    float f1;
    int k;
    int m;
    int i;
    int j;
    switch ()
    {
    default: 
      f1 = this.jdField_a_of_type_Aekh.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_AndroidWidgetRelativeLayout.getWidth(), this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight());
      aung.a("PhotoListPanel", "createDragReleaseSendAnim", "d scale = " + f1);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      k = this.jdField_a_of_type_Aekh.jdField_a_of_type_ArrayOfInt[0] - (int)(65.0F * this.jdField_a_of_type_Aekh.e + 0.5F + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getWidth() * f1 + 0.5F) - this.jdField_a_of_type_ArrayOfInt[0];
      m = this.jdField_a_of_type_AndroidViewViewGroup.getHeight() + this.jdField_a_of_type_Aekh.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getHeight() - (int)(13.0F * this.jdField_a_of_type_Aekh.e + 0.5F + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight() * f1 + 0.5F) - this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.getItemViewType(this.jdField_b_of_type_Int) == 1)
      {
        i = m - (int)(70.0F * this.jdField_a_of_type_Aekh.e + 0.5F);
        j = k;
      }
      break;
    }
    for (;;)
    {
      aung.a("PhotoListPanel", "createDragReleaseSendAnim", " deltY = " + i + ", flyStartLocation[1] = " + this.jdField_a_of_type_ArrayOfInt[1] + ",inputBarRightTopCorner[1] = " + this.jdField_a_of_type_Aekh.jdField_a_of_type_ArrayOfInt[1] + ",top = " + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTop());
      Object localObject1 = new AnimationSet(false);
      Object localObject2 = new ScaleAnimation(1.0F, f1, 1.0F, f1);
      ((ScaleAnimation)localObject2).setStartOffset(0L);
      ((ScaleAnimation)localObject2).setDuration(500L);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      localObject2 = new AnimationSet(false);
      ((AnimationSet)localObject2).setStartOffset(0L);
      ((AnimationSet)localObject2).setDuration(500L);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
      localTranslateAnimation.setInterpolator(new LinearInterpolator());
      ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
      localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject2).setStartOffset(500L - 200L / 2L);
      ((AlphaAnimation)localObject2).setDuration(200L);
      ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
      ((AnimationSet)localObject1).setFillAfter(false);
      return localObject1;
      f1 = this.jdField_a_of_type_Aekh.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight());
      break;
      i = m;
      j = k;
      if (PhotoListPanel.f() == 1)
      {
        localObject1 = this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.a(this.jdField_a_of_type_Aekh.c);
        float f2 = ((LocalMediaInfo)localObject1).mediaHeight * 1.0F / ((LocalMediaInfo)localObject1).mediaWidth;
        if (((LocalMediaInfo)localObject1).mediaHeight > ((LocalMediaInfo)localObject1).mediaWidth)
        {
          i = m - (int)(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight() * 0.5F * (f2 - 1.0F) * f1);
          j = k;
        }
        else
        {
          j = k - (int)(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getHeight() * 0.5F * (1.0F / f2 - 1.0F) * f1);
          i = m;
        }
      }
    }
  }
  
  public void a()
  {
    if (PhotoListPanel.f() == 1)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.4F, 1.0F, 1.4F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setFillAfter(true);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localScaleAnimation);
      ((Vibrator)this.jdField_a_of_type_AndroidContentContext.getSystemService("vibrator")).vibrate(100L);
    }
  }
  
  boolean a(aeke paramaeke, int paramInt)
  {
    super.a(paramaeke, paramInt);
    paramInt = paramaeke.itemView.getWidth() - (int)(this.jdField_a_of_type_Aekh.e * 2.0F + 0.5F);
    int i = paramaeke.itemView.getHeight() - (int)(this.jdField_a_of_type_Aekh.e * 2.0F + 0.5F) * 2;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = (this.jdField_c_of_type_ArrayOfInt[0] + (int)(this.jdField_a_of_type_Aekh.e * 2.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = (this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_b_of_type_ArrayOfInt[1] - this.jdField_a_of_type_Aekh.jdField_a_of_type_Int + (int)(this.jdField_a_of_type_Aekh.e * 2.0F + 0.5F));
    this.jdField_a_of_type_Aekh.g = (i * 3 / 5);
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getParent();
    if (localViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.clearAnimation();
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView, new RelativeLayout.LayoutParams(paramInt, i));
    this.d = new RelativeLayout.LayoutParams(paramInt, i);
    this.d.leftMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin;
    this.d.topMargin = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin;
    if (PhotoListPanel.f() == 1)
    {
      float f2 = paramaeke.itemView.getWidth() - this.jdField_a_of_type_Aekh.jdField_b_of_type_Float;
      float f1 = f2;
      if (this.jdField_a_of_type_Aekh.jdField_b_of_type_Float > paramaeke.itemView.getWidth()) {
        f1 = f2 + paramaeke.itemView.getWidth();
      }
      f2 = paramaeke.itemView.getWidth() * 0.4F / 2.0F;
      paramaeke = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
      paramaeke.topMargin = ((int)(paramaeke.topMargin - (f1 + f2)));
    }
    if (PhotoListPanel.f() == 1) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130841048);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView.getParent() != null) {
      return false;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_Aeke.itemView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, this.d);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.invalidate();
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.post(new PhotoListPanel.SwipeUpAndDragListener.DragHandler.1(this));
    aung.a("PhotoListPanel", "DragHandler", "drag prepare, contentParent = " + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getParent());
    return true;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    float f2 = this.jdField_a_of_type_Aekh.d;
    paramMotionEvent = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    paramMotionEvent.topMargin = ((int)(f1 - f2 + paramMotionEvent.topMargin));
    this.jdField_a_of_type_Int = (this.jdField_b_of_type_ArrayOfInt[1] + this.jdField_a_of_type_Aekh.jdField_a_of_type_Int + paramMotionEvent.topMargin);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramMotionEvent);
    aung.a("PhotoListPanel", "DragHandler", "drag hanldeMove, contentParent = " + this.jdField_c_of_type_AndroidWidgetRelativeLayout.getParent());
    this.jdField_a_of_type_Aekh.d = f1;
    if (-(int)(f1 - this.jdField_a_of_type_Aekh.jdField_b_of_type_Float) > (int)this.jdField_a_of_type_Aekh.g) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.invalidate();
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    aung.a("PhotoListPanel", "handleUp", "handler = " + this);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 4)
    {
      if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_Aekh.jdField_a_of_type_Long < 200L) && (Math.abs(f2 - this.jdField_a_of_type_Aekh.jdField_b_of_type_Float) < this.jdField_a_of_type_Aekh.jdField_b_of_type_Int) && (Math.abs(f1 - this.jdField_a_of_type_Aekh.jdField_a_of_type_Float) < this.jdField_a_of_type_Aekh.jdField_b_of_type_Int))
      {
        b();
        return false;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_Aeke.itemView.getLocationInWindow(this.jdField_c_of_type_ArrayOfInt);
      paramMotionEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, (int)(2.0F * this.jdField_a_of_type_Aekh.e + 0.5F) + this.jdField_c_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ArrayOfInt[1]);
      paramMotionEvent.setFillAfter(true);
      paramMotionEvent.setDuration(200L);
      this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(paramMotionEvent);
      paramMotionEvent.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    }
    while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      return true;
    }
    aung.a("PhotoListPanel", "DragHandler", "@#handleUp, createFlyAnimation ");
    paramMotionEvent = a();
    this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean = true;
    aung.a("PhotoListPanel", "DragHandler", "@#handleUp, startFlyAnimation ");
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(paramMotionEvent);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    int i = this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.getItemViewType(this.jdField_b_of_type_Int);
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.a(this.jdField_b_of_type_Int).path);
    axqy.b(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", this.jdField_b_of_type_Int + 1, 0, "1", "", "", "");
    axqy.b(null, "dc00898", "", "", "0X800A914", "0X800A914", PhotoUtils.c(this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo), 0, "" + (this.jdField_b_of_type_Int + 1), "", "", "");
    boolean bool;
    if (this.jdField_a_of_type_Aekh.jdField_a_of_type_Aekg != null)
    {
      localObject = this.jdField_a_of_type_Aekh.jdField_a_of_type_Aekg;
      String str = this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Aekc.a(this.jdField_b_of_type_Int).path;
      if (this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g == 2)
      {
        bool = true;
        label507:
        ((aekg)localObject).a(str, bool);
      }
    }
    for (;;)
    {
      paramMotionEvent.setAnimationListener(new aekj(this, f2));
      break;
      bool = false;
      break label507;
      this.jdField_a_of_type_Aekh.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(this.jdField_b_of_type_Int, (ArrayList)localObject, false, true, "0X8005E0D", "0", i + "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeki
 * JD-Core Version:    0.7.0.1
 */