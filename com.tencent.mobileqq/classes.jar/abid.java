import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.FrameLayout;
import com.tencent.mobileqq.armap.ARGLSurfaceView;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.wealthgod.ARMapDPC;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashEntryView.ARMapSplashEntryListener;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils;
import com.tencent.qphone.base.util.QLog;

public class abid
  implements ARMapSplashEntryView.ARMapSplashEntryListener
{
  public abid(ARMapActivity paramARMapActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "onEntryAnimationClosed isFinishing:" + this.a.isFinishing());
    }
    if (this.a.isFinishing()) {
      return;
    }
    if (ARMapActivity.a(this.a) != null) {
      ARMapActivity.a(this.a).setVisibility(4);
    }
    ARMapActivity.i(this.a, true);
    if (!this.a.jdField_a_of_type_Boolean) {
      ARMapActivity.d(this.a);
    }
    ARMapActivity.m(this.a);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapActivity", 2, "onEntryAnimationEnd isFinishing:" + this.a.isFinishing());
    }
    if (this.a.isFinishing()) {
      return;
    }
    ARMapActivity.j(this.a, true);
    ARMapActivity.g(this.a);
    Object localObject;
    if (this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView != null)
    {
      localObject = SplashBitmapUtils.a();
      if (localObject != null)
      {
        int i = 33;
        if (((ARMapDPC)localObject).e != 0) {
          i = 1000 / ((ARMapDPC)localObject).e;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setLowFPSRate(((ARMapDPC)localObject).d, i, true);
      }
    }
    else
    {
      localObject = ArMapUtil.b(this.a.app);
      if (!((SharedPreferences)localObject).getBoolean("armap_first_enter", true)) {
        break label277;
      }
      ((SharedPreferences)localObject).edit().putBoolean("armap_first_enter", false).commit();
      this.a.q();
    }
    for (;;)
    {
      if (ARMapActivity.a(this.a) != null)
      {
        ARMapActivity.a(this.a).setSplashListener(null);
        ARMapActivity.a(this.a).f();
      }
      ARMapActivity.a(this.a).removeView(ARMapActivity.a(this.a));
      ARMapActivity.a(this.a).removeView(ARMapActivity.a(this.a));
      ARMapActivity.a(this.a, null);
      ARMapActivity.a(this.a, null);
      this.a.o();
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqArmapARGLSurfaceView.setLowFPSRate(false, 33L, false);
      break;
      label277:
      ARMapActivity.n(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abid
 * JD-Core Version:    0.7.0.1
 */