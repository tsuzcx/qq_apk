import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.qphone.base.util.QLog;

public class aexh
{
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  public aexh(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "playAnimation");
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setOnCloseClickListener");
    }
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    if ((this.jdField_a_of_type_AndroidViewView$OnClickListener != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setBackgroundView");
    }
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofObject(new aexj(null), new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(3350L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aexi(this));
  }
  
  public void a(FriendShipLayout paramFriendShipLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setRootContainer");
    }
    if (paramFriendShipLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = azkz.a(30.0F);
      localLayoutParams.rightMargin = azkz.a(30.0F);
      paramFriendShipLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "setCloseBtnBitmapPath: " + paramString);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = 320;
    try
    {
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a(paramString, localOptions);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("LottieAnimController", 1, "Decode bitmap error");
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("LottieAnimController", 1, "Decode bitmap OOM");
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "isAnimating");
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning();
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "cancelAnimation");
    }
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "recycleBitmaps");
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "pauseAnimation");
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.pause();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LottieAnimController", 2, "resumeAnimation");
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (Build.VERSION.SDK_INT >= 19)) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.resume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexh
 * JD-Core Version:    0.7.0.1
 */