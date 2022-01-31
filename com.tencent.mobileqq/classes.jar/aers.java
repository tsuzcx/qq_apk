import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.PinnedHeaderExpandableListView;

class aers
  implements Runnable
{
  aers(aerr paramaerr, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Aerr.a.a(this.jdField_a_of_type_Boolean, this.b);
    this.jdField_a_of_type_Aerr.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.springBackOverScrollHeaderView();
    if (this.b)
    {
      this.jdField_a_of_type_Aerr.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Aerr.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setSelection(0);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aerr.a, 1, this.jdField_a_of_type_Aerr.a.getString(2131434349), 0).b(this.jdField_a_of_type_Aerr.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aers
 * JD-Core Version:    0.7.0.1
 */