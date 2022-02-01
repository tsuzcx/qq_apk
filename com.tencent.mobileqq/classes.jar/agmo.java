import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector.1;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.BoatAnimDirector.2;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.base.FriendShipLayout;
import com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView;
import com.tencent.qphone.base.util.QLog;

public class agmo
  extends agmz
{
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public ImageView a;
  private bdym jdField_a_of_type_Bdym = new agmp(this);
  FriendShipWaveView jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
  String jdField_a_of_type_JavaLangString = "aio_ship_ship.png";
  boolean jdField_a_of_type_Boolean = false;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  String jdField_b_of_type_JavaLangString = "aio_ship_banner.png";
  boolean jdField_b_of_type_Boolean = false;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  String jdField_c_of_type_JavaLangString = "aio_ship_blink.png";
  Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  String jdField_d_of_type_JavaLangString = "aio_ship_close.png";
  Bitmap jdField_e_of_type_AndroidGraphicsBitmap;
  String jdField_e_of_type_JavaLangString = "aio_ship_star1.png";
  Bitmap jdField_f_of_type_AndroidGraphicsBitmap;
  String jdField_f_of_type_JavaLangString = "aio_ship_star2.png";
  Bitmap jdField_g_of_type_AndroidGraphicsBitmap;
  String jdField_g_of_type_JavaLangString = "aio_ship_star3.png";
  Bitmap jdField_h_of_type_AndroidGraphicsBitmap;
  String jdField_h_of_type_JavaLangString = "aio_ship_star4.png";
  Bitmap jdField_i_of_type_AndroidGraphicsBitmap;
  String jdField_i_of_type_JavaLangString = "aio_ship_wave1.png";
  Bitmap jdField_j_of_type_AndroidGraphicsBitmap;
  String jdField_j_of_type_JavaLangString = "aio_ship_wave2.png";
  Bitmap jdField_k_of_type_AndroidGraphicsBitmap;
  String jdField_k_of_type_JavaLangString = "aio_ship_wave3.png";
  Bitmap jdField_l_of_type_AndroidGraphicsBitmap;
  String jdField_l_of_type_JavaLangString = "aio_ship_wording.png";
  
  public agmo(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.a(paramInt1, paramInt2, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bdym, this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_d_of_type_AndroidGraphicsBitmap, this.jdField_e_of_type_AndroidGraphicsBitmap, this.jdField_f_of_type_AndroidGraphicsBitmap, this.jdField_g_of_type_AndroidGraphicsBitmap, this.jdField_h_of_type_AndroidGraphicsBitmap, this.jdField_i_of_type_AndroidGraphicsBitmap, this.jdField_j_of_type_AndroidGraphicsBitmap, this.jdField_k_of_type_AndroidGraphicsBitmap, this.jdField_l_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.a();
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a()
  {
    super.a();
    if (!this.jdField_b_of_type_Boolean)
    {
      FriendShipLayout localFriendShipLayout = a();
      if (localFriendShipLayout != null)
      {
        if (localFriendShipLayout.getChildCount() > 0) {
          localFriendShipLayout.removeAllViews();
        }
        a(0);
        this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView = new FriendShipWaveView(this.jdField_a_of_type_AndroidContentContext, null);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        localFriendShipLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
        localFriendShipLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView);
        a(bdep.a, bdep.b);
        this.jdField_b_of_type_Boolean = true;
      }
    }
    bdll.b(null, "dc00898", "", "", "0X8007777", "0X8007777", 0, 0, "", "", "", "");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new BoatAnimDirector.2(this), 1000L);
    }
  }
  
  @TargetApi(9)
  public void a(agnf paramagnf)
  {
    String str = axtp.b();
    if (bhmi.a(str)) {}
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inScaled = true;
        localOptions.inDensity = 320;
        localOptions.inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
        this.jdField_a_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_a_of_type_JavaLangString, localOptions);
        this.jdField_b_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_b_of_type_JavaLangString, localOptions);
        this.jdField_c_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_c_of_type_JavaLangString, localOptions);
        this.jdField_d_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_d_of_type_JavaLangString, localOptions);
        this.jdField_e_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_e_of_type_JavaLangString, localOptions);
        this.jdField_f_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_f_of_type_JavaLangString, localOptions);
        this.jdField_g_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_g_of_type_JavaLangString, localOptions);
        this.jdField_h_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_h_of_type_JavaLangString, localOptions);
        this.jdField_i_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_i_of_type_JavaLangString, localOptions);
        this.jdField_j_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_j_of_type_JavaLangString, localOptions);
        this.jdField_k_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_k_of_type_JavaLangString, localOptions);
        this.jdField_l_of_type_AndroidGraphicsBitmap = bhmq.a(str + this.jdField_l_of_type_JavaLangString, localOptions);
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (this.jdField_d_of_type_AndroidGraphicsBitmap != null) && (this.jdField_i_of_type_AndroidGraphicsBitmap != null) && (this.jdField_j_of_type_AndroidGraphicsBitmap != null) && (this.jdField_k_of_type_AndroidGraphicsBitmap != null))
        {
          this.jdField_a_of_type_Boolean = true;
          if (QLog.isColorLevel()) {
            QLog.d("FriendShipViewManager", 2, "checkImageRes isResOk=" + this.jdField_a_of_type_Boolean);
          }
          super.a(paramagnf);
          paramagnf.a(this.jdField_a_of_type_Boolean);
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendShipViewManager", 2, "checkImageRes bitmap is null");
        continue;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_Boolean = false;
        QLog.e("FriendShipViewManager", 4, localException, new Object[0]);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d("FriendShipViewManager", 2, "checkImageRes bitmap failed");
        continue;
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.i();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView.postDelayed(new BoatAnimDirector.1(this, (FriendShipWaveView)localObject), 300L);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendshipImplBoatFriendShipWaveView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    super.b();
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      a(4);
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean) {
      a(0);
    }
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_Boolean) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmo
 * JD-Core Version:    0.7.0.1
 */