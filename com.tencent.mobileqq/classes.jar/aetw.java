import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.widget.BounceScrollView;

public class aetw
  implements Runnable
{
  public aetw(NearbyProfileEditPanel paramNearbyProfileEditPanel, View paramView1, View paramView2) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int j = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.getScrollY();
    if ((this.b instanceof ViewGroup)) {}
    for (Object localObject = this.b;; localObject = this.b.getParent())
    {
      localObject = (View)localObject;
      if (localObject != null)
      {
        int k = ((View)localObject).getBottom();
        int m = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.getMeasuredHeight();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditPanel.a.smoothScrollBy(0, k + i - m - j);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aetw
 * JD-Core Version:    0.7.0.1
 */