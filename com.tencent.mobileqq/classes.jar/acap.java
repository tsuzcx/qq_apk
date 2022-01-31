import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.emosm.view.DragSortListView;

public class acap
  extends acaq
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = -1;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  
  public acap(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt);
  }
  
  public void a()
  {
    int i = -1;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_c_of_type_Int;
    this.d = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d;
    this.e = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.e;
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.g = 1;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_AndroidGraphicsPoint.x;
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Boolean)
    {
      float f = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getWidth() * 2.0F;
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f == 0.0F)
      {
        DragSortListView localDragSortListView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
        if (this.jdField_a_of_type_Float < 0.0F) {
          localDragSortListView.f = (i * f);
        }
      }
      do
      {
        return;
        i = 1;
        break;
        f *= 2.0F;
        if ((this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f < 0.0F) && (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f > -f))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f = (-f);
          return;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f <= 0.0F) || (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f >= f));
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f = f;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F - paramFloat2;
    int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getFirstVisiblePosition();
    View localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(this.jdField_c_of_type_Int - j);
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Boolean)
    {
      paramFloat2 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / 1000.0F;
      if (paramFloat2 != 0.0F) {}
    }
    do
    {
      do
      {
        return;
        float f1 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f;
        int k = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getWidth();
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
        float f2 = ((DragSortListView)localObject).f;
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.f > 0.0F) {}
        for (i = 1;; i = -1)
        {
          ((DragSortListView)localObject).f = (i * paramFloat2 * k + f2);
          this.jdField_a_of_type_Float += f1 * paramFloat2;
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_AndroidGraphicsPoint.x = ((int)this.jdField_a_of_type_Float);
          if ((this.jdField_a_of_type_Float >= k) || (this.jdField_a_of_type_Float <= -k)) {
            break;
          }
          this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(true);
          return;
        }
        if (localView != null)
        {
          if (this.jdField_a_of_type_Int == -1)
          {
            this.jdField_a_of_type_Int = DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, this.jdField_c_of_type_Int, localView, false);
            this.jdField_b_of_type_Float = (localView.getHeight() - this.jdField_a_of_type_Int);
          }
          i = Math.max((int)(this.jdField_b_of_type_Float * paramFloat1), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.jdField_a_of_type_Int);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      } while (this.d == this.jdField_c_of_type_Int);
      localView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(this.d - j);
    } while (localView == null);
    if (this.jdField_b_of_type_Int == -1)
    {
      this.jdField_b_of_type_Int = DragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView, this.d, localView, false);
      this.jdField_c_of_type_Float = (localView.getHeight() - this.jdField_b_of_type_Int);
    }
    int i = Math.max((int)(this.jdField_c_of_type_Float * paramFloat1), 1);
    Object localObject = localView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i + this.jdField_b_of_type_Int);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void b()
  {
    DragSortListView.b(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acap
 * JD-Core Version:    0.7.0.1
 */