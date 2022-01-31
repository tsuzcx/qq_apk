import com.tencent.mobileqq.nearby.myvistor.NearbyVisitorListActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.PinnedHeaderExpandableListView;

class afad
  implements Runnable
{
  afad(afac paramafac, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Afac.a.a(this.jdField_a_of_type_Boolean, this.b);
    this.jdField_a_of_type_Afac.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.springBackOverScrollHeaderView();
    if (this.b)
    {
      this.jdField_a_of_type_Afac.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Afac.a.jdField_a_of_type_ComTencentWidgetPinnedHeaderExpandableListView.setSelection(0);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_Afac.a, 1, this.jdField_a_of_type_Afac.a.getString(2131434365), 0).b(this.jdField_a_of_type_Afac.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afad
 * JD-Core Version:    0.7.0.1
 */