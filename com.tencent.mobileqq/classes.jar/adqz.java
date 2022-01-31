import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter.MenuData;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class adqz
  implements View.OnClickListener
{
  public adqz(HorizontalListViewAdapter paramHorizontalListViewAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((HorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHorizontalListViewAdapter) != null) && (HorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHorizontalListViewAdapter).isShowing())) {
      HorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHorizontalListViewAdapter).dismiss();
    }
    ((HorizontalListViewAdapter.MenuData)HorizontalListViewAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetHorizontalListViewAdapter).get(this.jdField_a_of_type_Int)).a.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adqz
 * JD-Core Version:    0.7.0.1
 */