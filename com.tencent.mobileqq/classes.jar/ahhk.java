import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

class ahhk
  implements AbsListView.OnScrollListener
{
  ahhk(ahgz paramahgz) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition() == this.a.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) && (this.a.jdField_a_of_type_Aljn != null) && (this.a.jdField_a_of_type_Aljn.a() != 0) && (this.a.jdField_a_of_type_Aljn.a()))
    {
      this.a.jdField_a_of_type_Aljn.b();
      ahgz.a(this.a, this.a.jdField_a_of_type_Aljn.a(), 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhk
 * JD-Core Version:    0.7.0.1
 */