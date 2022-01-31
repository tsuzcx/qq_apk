import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.widget.DynamicGridView;

public class allm
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = -1;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  
  public allm(DynamicGridView paramDynamicGridView) {}
  
  private void c()
  {
    if ((this.d > 0) && (this.e == 0))
    {
      if ((!DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) || (!DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView))) {
        break label42;
      }
      DynamicGridView.b(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
    }
    label42:
    while (!DynamicGridView.c(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) {
      return;
    }
    DynamicGridView.c(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
  }
  
  public void a()
  {
    if ((this.c != this.jdField_a_of_type_Int) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != -1L))
    {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView));
      DynamicGridView.d(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
    }
  }
  
  public void b()
  {
    if ((this.c + this.d != this.jdField_a_of_type_Int + this.b) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView)) && (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != -1L))
    {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView));
      DynamicGridView.d(this.jdField_a_of_type_ComTencentWidgetDynamicGridView);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    if (this.jdField_a_of_type_Int == -1)
    {
      i = this.c;
      this.jdField_a_of_type_Int = i;
      if (this.b != -1) {
        break label111;
      }
    }
    label111:
    for (int i = this.d;; i = this.b)
    {
      this.b = i;
      a();
      b();
      this.jdField_a_of_type_Int = this.c;
      this.b = this.d;
      if (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != null) {
        DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
      i = this.jdField_a_of_type_Int;
      break;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    DynamicGridView.c(this.jdField_a_of_type_ComTencentWidgetDynamicGridView, paramInt);
    c();
    if (DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView) != null) {
      DynamicGridView.a(this.jdField_a_of_type_ComTencentWidgetDynamicGridView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     allm
 * JD-Core Version:    0.7.0.1
 */