import android.graphics.Point;
import android.view.View;
import com.tencent.mobileqq.emosm.view.DragSortListView;

public class acim
  extends aciq
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
  public acim(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getFirstVisiblePosition();
    int j = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.h + this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getDividerHeight()) / 2;
    View localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(this.jdField_a_of_type_Int - i);
    if (localView != null)
    {
      if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int) {
        return localView.getTop();
      }
      if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {
        return localView.getTop() - j;
      }
      return localView.getBottom() + j - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.i;
    }
    d();
    return -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.e;
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.g = 2;
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y - a());
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.x - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingLeft());
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int i = a();
    int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingLeft();
    paramFloat1 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y - i;
    float f = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.x - j;
    paramFloat2 = 1.0F - paramFloat2;
    if ((paramFloat2 < Math.abs(paramFloat1 / this.jdField_a_of_type_Float)) || (paramFloat2 < Math.abs(f / this.jdField_b_of_type_Float)))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.y = (i + (int)(this.jdField_a_of_type_Float * paramFloat2));
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a.x = (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingLeft() + (int)(this.jdField_b_of_type_Float * paramFloat2));
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(true);
    }
  }
  
  public void b()
  {
    DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acim
 * JD-Core Version:    0.7.0.1
 */