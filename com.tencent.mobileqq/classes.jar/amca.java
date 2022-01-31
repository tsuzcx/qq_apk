import com.tencent.widget.HorizontalListView;
import com.tencent.widget.OverScroller;

public class amca
  implements Runnable
{
  public amca(HorizontalListView paramHorizontalListView) {}
  
  public void run()
  {
    if ((this.a.p != -1) || (HorizontalListView.a(this.a) != -1)) {}
    do
    {
      do
      {
        return;
      } while (!this.a.jdField_a_of_type_ComTencentWidgetOverScroller.a());
      if (HorizontalListView.jdField_a_of_type_Boolean) {
        this.a.a("mFlingRunnable", new Object[] { Integer.valueOf(this.a.p) });
      }
    } while (!this.a.jdField_a_of_type_ComTencentWidgetOverScroller.a(this.a.getScrollX() + this.a.h, this.a.getScrollY(), this.a.h, this.a.h, 0, 0));
    this.a.p = 6;
    if (HorizontalListView.jdField_a_of_type_Boolean) {
      this.a.a("mFlingRunnable", new Object[] { "TOUCH_MODE_OVERFLING" });
    }
    this.a.g(4099);
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amca
 * JD-Core Version:    0.7.0.1
 */