import android.graphics.Rect;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;

public class alkg
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  
  public alkg(AbsListView paramAbsListView) {}
  
  public void a()
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition;
    int j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount();
    i = this.jdField_a_of_type_ComTencentWidgetAbsListView.mItemCount - (i + j - 1) - 1;
    if (i == 0)
    {
      i = AbsListView.access$2600(this.jdField_a_of_type_ComTencentWidgetAbsListView);
      j = AbsListView.access$2700(this.jdField_a_of_type_ComTencentWidgetAbsListView);
      int k = this.jdField_a_of_type_ComTencentWidgetAbsListView.mListPadding.bottom;
      this.e = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).getBottom() - (i - j - k));
      if (this.e == 0)
      {
        b();
        return;
      }
      this.d = 400;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() * i / this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() / 300.0F);
    this.jdField_a_of_type_Float = (this.jdField_c_of_type_Float / 100.0F);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetAbsListView.mItemCount - 1);
    if (i == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.mScrollToBottom = false;
  }
  
  public void run()
  {
    int i = 0;
    AdapterView.traceBegin("AbsListView.MoveToBottomScroller.run");
    for (;;)
    {
      int j;
      try
      {
        j = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
        switch (this.jdField_b_of_type_Int)
        {
        case 0: 
          i -= this.jdField_a_of_type_Int;
          if (this.jdField_a_of_type_ComTencentWidgetAbsListView.trackMotionScroll(-i, -i)) {
            break label545;
          }
          i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount();
          int k = this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition;
          if ((this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 1) || (k + i - 1 < this.jdField_c_of_type_Int)) {
            break label524;
          }
          k = AbsListView.access$2800(this.jdField_a_of_type_ComTencentWidgetAbsListView);
          int m = AbsListView.access$2900(this.jdField_a_of_type_ComTencentWidgetAbsListView);
          int n = this.jdField_a_of_type_ComTencentWidgetAbsListView.mListPadding.bottom;
          this.e = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(i - 1).getBottom() - (k - m - n));
          if (this.e != 0) {
            break label426;
          }
          b();
          return;
        }
      }
      finally
      {
        AdapterView.traceEnd();
      }
      if (j > 100)
      {
        this.jdField_b_of_type_Float = this.jdField_c_of_type_Float;
        i = (int)(this.jdField_c_of_type_Float * j - this.jdField_c_of_type_Float * 400.0F / 8.0F);
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_b_of_type_Int = 2;
      }
      else
      {
        this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * j);
        i = (int)(this.jdField_b_of_type_Float * j / 2.0F);
        continue;
        i = (int)(this.jdField_c_of_type_Float * j - this.jdField_c_of_type_Float * 400.0F / 8.0F);
        continue;
        if (j > this.d)
        {
          i = this.e - this.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.trackMotionScroll(-i, -i);
          AdapterView.traceEnd();
          return;
        }
        this.jdField_b_of_type_Float -= this.jdField_a_of_type_Float * j;
        i = (int)(this.e - this.jdField_b_of_type_Float * (this.d - j) / 2.0F);
        continue;
        if (j > this.d)
        {
          i = this.e - this.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.trackMotionScroll(-i, -i);
          AdapterView.traceEnd();
          return;
        }
        float f = j;
        i = (int)(AnimateUtils.a(f / this.d) * this.e);
        continue;
        label426:
        this.d = (400 - j);
        if (this.d < 100) {
          this.d = 100;
        }
        this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        this.jdField_a_of_type_Int = 0;
        if ((this.jdField_b_of_type_Float * 1000.0F > AbsListView.access$1500(this.jdField_a_of_type_ComTencentWidgetAbsListView)) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_b_of_type_Int = 1;
          this.jdField_b_of_type_Float = (this.e * 2.0F / this.d);
          this.jdField_a_of_type_Float = (this.jdField_b_of_type_Float / this.d);
          label524:
          this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        }
        for (;;)
        {
          AdapterView.traceEnd();
          return;
          this.jdField_b_of_type_Int = 3;
          break;
          label545:
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alkg
 * JD-Core Version:    0.7.0.1
 */