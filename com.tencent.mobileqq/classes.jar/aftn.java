import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.PanelAdapter;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.ArrayList;

public class aftn
  implements Observer<ArrayList<ahvd>>
{
  public aftn(PlusPanel paramPlusPanel) {}
  
  public void a(@Nullable ArrayList<ahvd> paramArrayList)
  {
    this.a.a(paramArrayList);
    int i = PlusPanel.a(this.a).getCurrentItem();
    paramArrayList = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAdapter.a(i);
    PlusPanel.a(this.a).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, i, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftn
 * JD-Core Version:    0.7.0.1
 */