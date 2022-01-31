import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel;
import com.tencent.mobileqq.widget.BounceScrollView;

public class aevg
  implements Runnable
{
  public aevg(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, View paramView1, View paramView2) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int j = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.getScrollY();
    if ((this.b instanceof ViewGroup)) {}
    for (Object localObject = this.b;; localObject = this.b.getParent())
    {
      localObject = (View)localObject;
      if (localObject != null)
      {
        int k = ((View)localObject).getBottom();
        int m = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.getMeasuredHeight();
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyProfileEditTribePanel.a.smoothScrollBy(0, k + i - m - j);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aevg
 * JD-Core Version:    0.7.0.1
 */