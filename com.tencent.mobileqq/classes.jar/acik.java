import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DragScrollProfile;

public class acik
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long c;
  
  public acik(DragSortListView paramDragSortListView) {}
  
  public int a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_b_of_type_Int;
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = true;
      this.c = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Long = this.c;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.removeCallbacks(this);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getFirstVisiblePosition();
    int i = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getLastVisiblePosition();
    int m = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getCount();
    int k = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingTop();
    int n = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeight() - k - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getPaddingBottom();
    int i1 = Math.min(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.k, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.j);
    int i2 = Math.max(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.k, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.j);
    View localView;
    if (this.jdField_b_of_type_Int == 0)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(0);
      if (localView == null)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if ((j == 0) && (localView.getTop() == k))
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile.a((this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_b_of_type_Float - i2) / this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c, this.jdField_a_of_type_Long);
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Float = ((float)(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_Int = Math.round(this.jdField_b_of_type_Float * this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Int < 0) {
        break label470;
      }
      this.jdField_a_of_type_Int = Math.min(n, this.jdField_a_of_type_Int);
      i = j;
    }
    for (;;)
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i - j);
      m = localView.getTop() + this.jdField_a_of_type_Int;
      j = m;
      if (i == 0)
      {
        j = m;
        if (m > k) {
          j = k;
        }
      }
      DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, true);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setSelectionFromTop(i, j - k);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.layoutChildren();
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.invalidate();
      DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, false);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(i, localView, false);
      this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.post(this);
      return;
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i - j);
      if (localView == null)
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      if ((i == m - 1) && (localView.getBottom() <= n + k))
      {
        this.jdField_b_of_type_Boolean = false;
        return;
      }
      this.jdField_b_of_type_Float = (-this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile.a((i1 - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Float) / this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d, this.jdField_a_of_type_Long));
      break;
      label470:
      this.jdField_a_of_type_Int = Math.max(-n, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acik
 * JD-Core Version:    0.7.0.1
 */