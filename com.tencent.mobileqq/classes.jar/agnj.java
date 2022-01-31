import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;

class agnj
  implements bhpo
{
  agnj(agmy paramagmy) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.a.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.a.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition() == this.a.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) && (this.a.jdField_a_of_type_Akes != null) && (this.a.jdField_a_of_type_Akes.a() != 0) && (this.a.jdField_a_of_type_Akes.a()))
    {
      this.a.jdField_a_of_type_Akes.b();
      agmy.a(this.a, this.a.jdField_a_of_type_Akes.a(), 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnj
 * JD-Core Version:    0.7.0.1
 */