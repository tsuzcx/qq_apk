import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

class aicd
  implements AbsListView.OnScrollListener
{
  aicd(aibs paramaibs) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition() == this.a.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) && (this.a.jdField_a_of_type_Amhn != null) && (this.a.jdField_a_of_type_Amhn.a() != 0) && (this.a.jdField_a_of_type_Amhn.a()))
    {
      this.a.jdField_a_of_type_Amhn.b();
      aibs.a(this.a, this.a.jdField_a_of_type_Amhn.a(), 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicd
 * JD-Core Version:    0.7.0.1
 */