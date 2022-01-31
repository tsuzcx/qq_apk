import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.widget.XListView;

class acpe
  implements MessageQueue.IdleHandler
{
  acpe(acpd paramacpd) {}
  
  public boolean queueIdle()
  {
    View localView = this.a.a.jdField_a_of_type_ArrayOfAndroidViewView[40];
    int i = localView.getTop();
    int j = (this.a.a.jdField_a_of_type_ComTencentWidgetXListView.getHeight() - localView.getHeight()) / 2;
    this.a.a.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollBy(i - j, 1000);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpe
 * JD-Core Version:    0.7.0.1
 */