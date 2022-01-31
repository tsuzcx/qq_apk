import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel;
import com.tencent.mobileqq.widget.BounceScrollView;

public class aflj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public aflj(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getWindow().getDecorView().getRootView().getHeight() - ((Rect)localObject).bottom;
    if (i <= 0) {}
    int j;
    do
    {
      return;
      j = this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getScrollY();
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getCurrentFocus();
    } while ((localObject == null) || (!(localObject instanceof EditText)) || (((View)localObject).getParent() == null));
    int k = ((ViewGroup)((View)localObject).getParent()).getBottom();
    int m = this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.getMeasuredHeight();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.smoothScrollBy(0, k + i - m - j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aflj
 * JD-Core Version:    0.7.0.1
 */