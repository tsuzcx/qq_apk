import android.view.View;
import com.tencent.biz.ui.RefreshView;
import com.tencent.widget.ListView;

public class aaku
  implements bldp
{
  public aaku(RefreshView paramRefreshView) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int == 2)
    {
      this.a.jdField_a_of_type_Aakn.ai_();
      return;
    }
    this.a.jdField_a_of_type_Aakn.c(0L);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2) {
      this.a.jdField_a_of_type_Aakn.b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2)
    {
      RefreshView.a(this.a, false);
      this.a.a(RefreshView.a(this.a));
      this.a.jdField_a_of_type_Aakn.a(0L);
      this.a.jdField_a_of_type_Int = 2;
      RefreshView.a(this.a);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaku
 * JD-Core Version:    0.7.0.1
 */