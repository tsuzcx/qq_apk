import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.PinnedHeaderExpandableListView;

class aeem
  implements Runnable
{
  aeem(aeel paramaeel, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aeel.a.a(this.jdField_a_of_type_Boolean, this.b);
    this.jdField_a_of_type_Aeel.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.springBackOverScrollHeaderView();
    if (this.b)
    {
      this.jdField_a_of_type_Aeel.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Aeel.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setSelection(0);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aeel.a, 1, this.jdField_a_of_type_Aeel.a.getString(2131434332), 0).b(this.jdField_a_of_type_Aeel.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeem
 * JD-Core Version:    0.7.0.1
 */