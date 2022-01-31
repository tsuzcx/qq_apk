import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.activity.leba.QzoneFrame.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class afqb
  extends ajii
{
  public static int a;
  public static String a;
  public static int b;
  private afqe jdField_a_of_type_Afqe = new afqd(this);
  private Fragment jdField_a_of_type_AndroidAppFragment;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new afqc(this);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean = true;
  private Fragment jdField_b_of_type_AndroidAppFragment;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 255;
  private Fragment jdField_c_of_type_AndroidAppFragment;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
    jdField_a_of_type_JavaLangString = "qzone_publish_queue_notify";
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131496321, null);
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    super.a();
    bfsz.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    f();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    if (this.jdField_b_of_type_AndroidAppFragment != null) {
      this.jdField_b_of_type_AndroidAppFragment.onConfigurationChanged(paramConfiguration);
    }
    if (this.jdField_c_of_type_AndroidAppFragment != null) {
      this.jdField_c_of_type_AndroidAppFragment.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    super.a(paramBaseActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.executeOnSubThread(new QzoneFrame.3(this));
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidAppFragment != null) && ((this.jdField_a_of_type_AndroidAppFragment instanceof bftc))) {
      ((bftc)this.jdField_a_of_type_AndroidAppFragment).setQzoneSwitchlistener(this.jdField_a_of_type_Afqe);
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidAppFragment != null;
  }
  
  public void c()
  {
    try
    {
      ImmersiveUtils.a(awnu.d(), a().getWindow());
      ImageLoader.getInstance().clear(false);
      if (this.jdField_a_of_type_AndroidAppFragment != null) {
        ((bftc)this.jdField_a_of_type_AndroidAppFragment).onSwitchOutofQzone();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QzoneFrame", 1, "onSwitchOutofQzone" + localThrowable);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (this.jdField_b_of_type_AndroidAppFragment == null) {}
    do
    {
      return;
      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131302804) != null)) {
        this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131302804).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidAppFragment.onResume();
      FrameHelperActivity.c(false);
    } while (!FrameHelperActivity.b());
    FrameHelperActivity.s();
  }
  
  public void e()
  {
    super.e();
    l();
  }
  
  public void f()
  {
    super.f();
    bfsz.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    bfsz.b(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131308463));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131308090));
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131308456));
    this.jdField_b_of_type_AndroidAppFragment = bfsz.a(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "com.qzone.feed.ui.activity.QQLebaFriendFeedFragment");
    this.jdField_a_of_type_AndroidAppFragment = this.jdField_b_of_type_AndroidAppFragment;
    b();
    Object localObject;
    if (this.jdField_a_of_type_AndroidAppFragment != null)
    {
      ((bftc)this.jdField_b_of_type_AndroidAppFragment).setTitleView(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_AndroidAppFragment.onAttach(a());
      this.jdField_a_of_type_AndroidAppFragment.onCreate(null);
      localObject = this.jdField_a_of_type_AndroidAppFragment.onCreateView(a().getLayoutInflater(), null, null);
      if (localObject == null) {
        return;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.addView((View)localObject);
      this.jdField_a_of_type_AndroidAppFragment.onActivityCreated(null);
      this.jdField_a_of_type_AndroidAppFragment.onStart();
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      localObject = new IntentFilter(new IntentFilter(jdField_a_of_type_JavaLangString));
      try
      {
        a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("QzoneFrame", 1, "registerReceiver" + localException);
        return;
      }
      if ((this.jdField_b_of_type_AndroidAppFragment instanceof bftc)) {
        ((bftc)this.jdField_b_of_type_AndroidAppFragment).forceRefresh();
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppFragment.onStart();
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_AndroidAppFragment.onPause();
    FrameHelperActivity.c(true);
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_AndroidAppFragment == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidAppFragment.onStop();
  }
  
  public void j()
  {
    super.j();
    try
    {
      a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_AndroidAppFragment == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("QzoneFrame", 1, "registerReceiver" + localException);
        }
        if (this.jdField_b_of_type_AndroidAppFragment != null)
        {
          this.jdField_b_of_type_AndroidAppFragment.onDestroy();
          this.jdField_b_of_type_AndroidAppFragment = null;
        }
      } while (this.jdField_c_of_type_AndroidAppFragment == null);
      this.jdField_c_of_type_AndroidAppFragment.onDestroy();
      this.jdField_c_of_type_AndroidAppFragment = null;
    }
  }
  
  public void k()
  {
    l();
    awnu.jdField_c_of_type_Int = 0;
    awnu.d = 0;
    f();
  }
  
  public void l()
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    if (this.jdField_b_of_type_AndroidAppFragment != null) {
      this.jdField_b_of_type_AndroidAppFragment.onDestroy();
    }
    if (this.jdField_c_of_type_AndroidAppFragment != null) {
      this.jdField_c_of_type_AndroidAppFragment.onDestroy();
    }
    if ((this.jdField_b_of_type_AndroidAppFragment instanceof bftc)) {
      ((bftc)this.jdField_b_of_type_AndroidAppFragment).clearCache();
    }
    if ((this.jdField_c_of_type_AndroidAppFragment instanceof bftc)) {
      ((bftc)this.jdField_c_of_type_AndroidAppFragment).clearCache();
    }
    this.jdField_b_of_type_AndroidAppFragment = null;
    this.jdField_c_of_type_AndroidAppFragment = null;
    a().getIntent().putExtra("newflag", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqb
 * JD-Core Version:    0.7.0.1
 */