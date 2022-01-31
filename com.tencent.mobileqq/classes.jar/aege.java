import android.view.View;
import com.tencent.mobileqq.nearby.now.location.adapter.SelectableAdapter;
import com.tencent.mobileqq.nearby.now.widget.CommonViewHolder.ItemClickListener;
import java.util.List;

public class aege
  implements CommonViewHolder.ItemClickListener
{
  public aege(SelectableAdapter paramSelectableAdapter, CommonViewHolder.ItemClickListener paramItemClickListener) {}
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_Int == paramInt) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_AndroidViewView);
    }
    int i = paramInt;
    if (paramInt > this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_JavaUtilList.size()) {
      i = this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_JavaUtilList.size() - 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener.a(i, paramView);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_JavaLangObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_JavaUtilList.get(i);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowLocationAdapterSelectableAdapter.a(paramView);
  }
  
  public void b(int paramInt, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowWidgetCommonViewHolder$ItemClickListener.b(paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aege
 * JD-Core Version:    0.7.0.1
 */