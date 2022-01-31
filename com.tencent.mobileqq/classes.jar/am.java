import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.XListView;

public final class am
  implements Runnable
{
  public am(XListView paramXListView, ScrollerRunnable paramScrollerRunnable) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView.getCount() > 2) {
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     am
 * JD-Core Version:    0.7.0.1
 */