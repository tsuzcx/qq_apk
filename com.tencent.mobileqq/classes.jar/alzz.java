import android.graphics.Rect;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.widget.AbsListView;

public class alzz
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  private int d;
  private int e;
  private final int f;
  private int g;
  
  public alzz(AbsListView paramAbsListView)
  {
    this.f = ViewConfiguration.get(paramAbsListView.getContext()).getScaledFadingEdgeLength();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this);
    if (AbsListView.access$1900(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null) {
      AbsListView.access$1900(this.jdField_a_of_type_ComTencentWidgetAbsListView).b();
    }
  }
  
  public void a(int paramInt)
  {
    a();
    int i = this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition;
    int j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() + i - 1;
    if (paramInt <= i)
    {
      i = i - paramInt + 1;
      this.jdField_a_of_type_Int = 2;
      if (i <= 0) {
        break label97;
      }
    }
    label97:
    for (this.e = (400 / i);; this.e = 400)
    {
      this.b = paramInt;
      this.c = -1;
      this.d = -1;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      do
      {
        return;
      } while (paramInt < j);
      i = paramInt - j + 1;
      this.jdField_a_of_type_Int = 1;
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a();
    if (paramInt2 == -1) {
      a(paramInt1);
    }
    int j;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition;
      j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() + i - 1;
      if (paramInt1 > i) {
        break;
      }
      j -= paramInt2;
    } while (j < 1);
    int i = i - paramInt1 + 1;
    j -= 1;
    if (j < i)
    {
      this.jdField_a_of_type_Int = 4;
      i = j;
      label79:
      if (i <= 0) {
        break label180;
      }
    }
    label178:
    label180:
    for (this.e = (400 / i);; this.e = 400)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = -1;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      for (this.jdField_a_of_type_Int = 2;; this.jdField_a_of_type_Int = 1)
      {
        break label79;
        if (paramInt1 < j) {
          break label178;
        }
        int k = paramInt2 - i;
        if (k < 1) {
          break;
        }
        i = paramInt1 - j + 1;
        j = k - 1;
        if (j < i)
        {
          this.jdField_a_of_type_Int = 3;
          i = j;
          break label79;
        }
      }
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.b = paramInt1;
    this.g = paramInt2;
    this.c = -1;
    this.d = -1;
    this.jdField_a_of_type_Int = 5;
    int j = this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition;
    int i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount();
    int k = j + i - 1;
    if (paramInt1 < j) {
      paramInt1 = j - paramInt1;
    }
    for (;;)
    {
      float f1 = paramInt1 / i;
      this.e = ((int)(paramInt3 / f1));
      this.d = -1;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      if (paramInt1 <= k) {
        break;
      }
      paramInt1 -= k;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(paramInt1 - j).getTop();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(paramInt1 - paramInt2, paramInt3);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 400);
  }
  
  public void run()
  {
    int i = 0;
    int j = 0;
    int m = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
    int k = this.jdField_a_of_type_ComTencentWidgetAbsListView.mFirstPosition;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 1: 
    case 3: 
    case 2: 
    case 4: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1;
                    k += i;
                  } while (i < 0);
                  if (k == this.d)
                  {
                    this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
                    return;
                  }
                  localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(i);
                  n = localView.getHeight();
                  int i1 = localView.getTop();
                  int i2 = this.jdField_a_of_type_ComTencentWidgetAbsListView.mListPadding.bottom;
                  i = j;
                  if (k < this.b)
                  {
                    i = j;
                    if (k < this.jdField_a_of_type_ComTencentWidgetAbsListView.mItemCount - 1) {
                      i = this.f;
                    }
                  }
                  this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(i + (n - (m - i1 - i2)), this.e);
                  this.d = k;
                } while (k >= this.b);
                this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
                return;
                i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount();
              } while ((k == this.c) || (i <= 1) || (i + k >= this.jdField_a_of_type_ComTencentWidgetAbsListView.mItemCount));
              i = k + 1;
              if (i == this.d)
              {
                this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
                return;
              }
              localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(1);
              j = localView.getHeight();
              k = localView.getTop();
              m = this.f;
              if (i < this.c)
              {
                this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(Math.max(0, k + j - m), this.e);
                this.d = i;
                this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
                return;
              }
            } while (k <= m);
            this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(k - m, this.e);
            return;
            if (k == this.d)
            {
              this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
              return;
            }
            localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
          } while (localView == null);
          j = localView.getTop();
          if (k > 0) {}
          for (i = this.f;; i = this.jdField_a_of_type_ComTencentWidgetAbsListView.mListPadding.top)
          {
            this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(j - i, this.e);
            this.d = k;
            if (k <= this.b) {
              break;
            }
            this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
            return;
          }
          j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 2;
        } while (j < 0);
        i = k + j;
        if (i == this.d)
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
          return;
        }
        View localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(j);
        j = localView.getHeight();
        k = localView.getTop();
        this.d = i;
        if (i > this.c)
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(-(m - k - this.f), this.e);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
          return;
        }
        i = m - this.f;
        j = k + j;
      } while (i <= j);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(-(i - j), this.e);
      return;
    }
    if (this.d == k)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
    this.d = k;
    j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount();
    m = this.b;
    int n = k + j - 1;
    if (m < k) {
      i = k - m + 1;
    }
    float f1;
    for (;;)
    {
      f1 = Math.min(Math.abs(i / j), 1.0F);
      if (m >= k) {
        break;
      }
      this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy((int)(f1 * -this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight()), this.e);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      if (m > n) {
        i = m - n;
      }
    }
    if (m > n)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy((int)(f1 * this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight()), this.e);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
    i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(m - k).getTop() - this.g;
    j = Math.abs((int)(this.e * (i / this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight())));
    this.jdField_a_of_type_ComTencentWidgetAbsListView.smoothScrollBy(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzz
 * JD-Core Version:    0.7.0.1
 */