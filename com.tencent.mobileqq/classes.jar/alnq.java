import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.widget.PullToZoomListView;

public class alnq
  implements Runnable
{
  float jdField_a_of_type_Float;
  long jdField_a_of_type_Long;
  public boolean a;
  long b;
  
  public alnq(PullToZoomListView paramPullToZoomListView)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong)
  {
    if (!this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.jdField_a_of_type_Boolean) {
      return;
    }
    this.b = SystemClock.currentThreadTimeMillis();
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.jdField_a_of_type_AndroidWidgetFrameLayout.getBottom() / this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.b);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.post(this);
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.jdField_a_of_type_AndroidWidgetFrameLayout == null) {}
    while ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Float <= 1.0D)) {
      return;
    }
    float f1 = ((float)SystemClock.currentThreadTimeMillis() - (float)this.b) / (float)this.jdField_a_of_type_Long;
    float f2 = this.jdField_a_of_type_Float;
    float f3 = this.jdField_a_of_type_Float;
    f1 = f2 - PullToZoomListView.a().getInterpolation(f1) * (f3 - 1.0F);
    ViewGroup.LayoutParams localLayoutParams1 = this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams2 = this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (f1 > 1.0F)
    {
      localLayoutParams1.height = this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.b;
      localLayoutParams2.height = (this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.b - this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.c);
      localLayoutParams1.height = ((int)(f1 * this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.b));
      localLayoutParams1.height -= this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.c;
      this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams1);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams2);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.post(this);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     alnq
 * JD-Core Version:    0.7.0.1
 */