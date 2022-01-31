import android.annotation.TargetApi;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.EdgeEffect;
import com.tencent.widget.OverScroller;

public class alzu
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private final OverScroller jdField_a_of_type_ComTencentWidgetOverScroller;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new alzv(this);
  
  public alzu(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(paramAbsListView.getContext());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode = -1;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.reportScrollStateChange(0);
    AbsListView.access$2000(this.jdField_a_of_type_ComTencentWidgetAbsListView);
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
    if (AbsListView.access$1600(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null) {
      AbsListView.access$1602(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.access$2100(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.access$1600(this.jdField_a_of_type_ComTencentWidgetAbsListView)));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode = 4;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      if (AbsListView.access$1600(this.jdField_a_of_type_ComTencentWidgetAbsListView) == null) {
        AbsListView.access$1602(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.access$1700(this.jdField_a_of_type_ComTencentWidgetAbsListView, "AbsListView-fling"));
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, i, 0, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode = 4;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 40L);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), paramInt, paramInt, paramInt, paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode = 6;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode = -1;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.reportScrollStateChange(0);
  }
  
  @TargetApi(9)
  void c(int paramInt)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView.mForHongBao) {
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getSpringbackOffset();
    }
    OverScroller localOverScroller = this.jdField_a_of_type_ComTencentWidgetOverScroller;
    int j;
    if (paramInt > 0)
    {
      j = this.jdField_a_of_type_ComTencentWidgetAbsListView.mTopOverflingDistance;
      localOverScroller.a(paramInt, i, j);
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getOverScrollMode();
      if ((i != 0) && ((i != 1) || (AbsListView.access$1800(this.jdField_a_of_type_ComTencentWidgetAbsListView)))) {
        break label158;
      }
      this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode = 6;
      i = (int)this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView.mEdgeGlowTop != null)
      {
        if (paramInt <= 0) {
          break label144;
        }
        this.jdField_a_of_type_ComTencentWidgetAbsListView.mEdgeGlowTop.a(i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      j = this.jdField_a_of_type_ComTencentWidgetAbsListView.mBottomOverflingDistance;
      break;
      label144:
      this.jdField_a_of_type_ComTencentWidgetAbsListView.mEdgeGlowBottom.a(i);
      continue;
      label158:
      this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode = -1;
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView.mPositionScroller != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView.mPositionScroller.a();
      }
      if (AbsListView.access$1900(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null) {
        AbsListView.access$1900(this.jdField_a_of_type_ComTencentWidgetAbsListView).b();
      }
    }
  }
  
  @TargetApi(9)
  public void run()
  {
    int k = 1;
    int i;
    int j;
    switch (this.jdField_a_of_type_ComTencentWidgetAbsListView.mTouchMode)
    {
    case 5: 
    default: 
      a();
    case 3: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetOverScroller.a());
    case 4: 
      AdapterView.traceBegin("AbsListView.FlingRunable.onfling");
      try
      {
        if (this.jdField_a_of_type_ComTencentWidgetAbsListView.mDataChanged) {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.layoutChildren();
        }
        if ((this.jdField_a_of_type_ComTencentWidgetAbsListView.mItemCount == 0) || (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() == 0))
        {
          a();
          return;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentWidgetOverScroller;
        boolean bool = ((OverScroller)localObject1).b();
        int m = ((OverScroller)localObject1).b();
        i = this.jdField_a_of_type_Int - m;
        if (i > 0)
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.mMotionPosition = this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition;
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.mMotionViewOriginalTop = ((View)localObject1).getTop();
        }
        for (i = Math.min(this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - AbsListView.access$2200(this.jdField_a_of_type_ComTencentWidgetAbsListView) - AbsListView.access$2300(this.jdField_a_of_type_ComTencentWidgetAbsListView) - 1, i);; i = Math.max(-(this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - AbsListView.access$2400(this.jdField_a_of_type_ComTencentWidgetAbsListView) - AbsListView.access$2500(this.jdField_a_of_type_ComTencentWidgetAbsListView) - 1), i))
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.mMotionPosition - this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition);
          if (localObject1 == null) {
            break label611;
          }
          j = ((View)localObject1).getTop();
          if ((!this.jdField_a_of_type_ComTencentWidgetAbsListView.trackMotionScroll(i, i)) || (i == 0)) {
            break label616;
          }
          label254:
          if (k == 0) {
            break;
          }
          if (localObject1 != null)
          {
            j = -(i - (((View)localObject1).getTop() - j));
            if ((!this.jdField_a_of_type_ComTencentWidgetAbsListView.mForHongBao) || (j <= 0))
            {
              i = j;
              if (bool)
              {
                c(j);
                i = this.jdField_a_of_type_ComTencentWidgetOverScroller.b();
              }
              this.jdField_a_of_type_ComTencentWidgetAbsListView.overScrollBy(0, i, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), 0, 0, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.mOverscrollDistance, false);
            }
          }
          return;
          j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.mMotionPosition = (this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition + j);
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(j);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.mMotionViewOriginalTop = ((View)localObject1).getTop();
        }
        if ((bool) && (k == 0))
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
          this.jdField_a_of_type_Int = m;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        }
        for (;;)
        {
          return;
          a();
        }
        try
        {
          localOverScroller = this.jdField_a_of_type_ComTencentWidgetOverScroller;
          if (localOverScroller.b())
          {
            j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY();
            k = localOverScroller.b();
            if (this.jdField_a_of_type_ComTencentWidgetAbsListView.overScrollBy(0, k - j, 0, j, 0, 0, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.mOverscrollDistance, false)) {
              if ((j <= 0) && (k > 0))
              {
                i = 1;
                break label621;
              }
            }
          }
        }
        finally {}
      }
      finally
      {
        AdapterView.traceEnd();
      }
    }
    for (;;)
    {
      OverScroller localOverScroller;
      label541:
      k = (int)localOverScroller.a();
      i = k;
      if (j != 0) {
        i = -k;
      }
      localOverScroller.a();
      a(i);
      return;
      i = 0;
      break label621;
      label578:
      j = 0;
      label611:
      label616:
      label621:
      do
      {
        b(0);
        return;
        this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
        this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        return;
        a();
        return;
        j = 0;
        break;
        k = 0;
        break label254;
        if ((j < 0) || (k >= 0)) {
          break label578;
        }
        j = 1;
        if (i != 0) {
          break label541;
        }
      } while (j == 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzu
 * JD-Core Version:    0.7.0.1
 */