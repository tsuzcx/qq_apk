import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FastScroller;
import com.tencent.widget.ListView;

public class almz
  extends alka
  implements alop
{
  public almz(ListView paramListView)
  {
    super(paramListView);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > paramInt5) || (paramInt1 < paramInt4)) {
      paramInt4 = -1;
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt1 < paramInt2);
    if (paramInt1 <= paramInt3) {
      return -1;
    }
    return paramInt1 - (paramInt3 - paramInt2 + 1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    View localView;
    Object localObject;
    if (paramBoolean)
    {
      paramInt2 = j;
      while (paramInt2 < paramInt1)
      {
        localView = this.a.getChildAt(paramInt2);
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(this.a.getDelAnimationDuration());
        localView.setAnimation((Animation)localObject);
        paramInt2 += 1;
      }
    }
    while (i <= paramInt2)
    {
      localView = this.a.getChildAt(i);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt3, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.a.getDelAnimationDuration());
      localView.setAnimation((Animation)localObject);
      i += 1;
    }
    paramInt2 += 1;
    while (paramInt2 < paramInt1)
    {
      localView = this.a.getChildAt(paramInt2);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt4, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.a.getDelAnimationDuration());
      localView.setAnimation((Animation)localObject);
      paramInt2 += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    System.nanoTime();
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    if ((paramInt1 < 0) || (paramInt2 >= this.a.mItemCount - this.a.getHeaderViewsCount() - this.a.getFooterViewsCount())) {
      throw new IllegalArgumentException("row index out of bound");
    }
    if ((this.a.mNeedSync) || (this.a.mDataChanged)) {
      onChanged();
    }
    int n;
    int i2;
    int i1;
    int i3;
    boolean bool1;
    int m;
    int k;
    int j;
    int i;
    label469:
    label483:
    label636:
    label638:
    Object localObject;
    label548:
    label701:
    label710:
    label747:
    do
    {
      int i4;
      do
      {
        return;
        n = paramInt1 + this.a.getHeaderViewsCount();
        i2 = paramInt2 + this.a.getHeaderViewsCount();
        paramInt1 = i2 - n + 1;
        i4 = this.a.getChildCount();
        i1 = this.a.mFirstPosition;
        i3 = this.a.mFirstPosition + i4 - 1;
        if (this.a.mFastScroller != null) {
          this.a.mFastScroller.a(this.a.mItemCount, this.a.mItemCount - paramInt1);
        }
        this.a.mItemCount -= paramInt1;
        if (this.a.mSelectedPosition >= 0)
        {
          paramInt1 = a(this.a.mSelectedPosition, n, i2, i1, i3);
          this.a.setSelectedPositionInt(paramInt1);
          this.a.setNextSelectedPositionInt(paramInt1);
          if (this.a.mMotionPosition >= 0) {
            this.a.mMotionPosition = a(this.a.mMotionPosition, n, i2, i1, i3);
          }
          if (this.a.mCheckStates != null) {
            break label469;
          }
        }
        for (paramInt2 = 0;; paramInt2 = this.a.mCheckStates.size())
        {
          if (paramInt2 <= 0) {
            break label483;
          }
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            int i5 = this.a.mCheckStates.keyAt(paramInt1);
            bool1 = this.a.mCheckStates.valueAt(paramInt1);
            m = paramInt1;
            k = paramInt2;
            if (i5 >= n)
            {
              this.a.mCheckStates.delete(i5);
              j = paramInt1;
              i = paramInt2;
              if (i5 <= i2)
              {
                j = paramInt1 - 1;
                i = paramInt2 - 1;
              }
              m = j;
              k = i;
              if (i5 > i2)
              {
                this.a.mCheckStates.put(i5 - (i2 - n + 1), bool1);
                k = i;
                m = j;
              }
            }
            paramInt1 = m + 1;
            paramInt2 = k;
          }
          if (this.a.mSelectorPosition < 0) {
            break;
          }
          this.a.mSelectedPosition = a(this.a.mSelectorPosition, n, i2, i1, i3);
          break;
        }
        if (ListView.access$300(this.a) != null)
        {
          paramInt1 = 0;
          if (paramInt1 < ListView.access$300(this.a).length)
          {
            paramInt2 = ListView.access$300(this.a)[paramInt1];
            if (paramInt2 >= n)
            {
              if (paramInt2 > i2) {
                break label548;
              }
              paramInt2 = -1;
            }
            for (;;)
            {
              ListView.access$300(this.a)[paramInt1] = paramInt2;
              paramInt1 += 1;
              break;
              paramInt2 -= i2 - n + 1;
            }
          }
        }
      } while ((i2 < i1) || (n > i3));
      m = this.a.mListPadding.top;
      k = ListView.access$1100(this.a) - ListView.access$1200(this.a) - this.a.mListPadding.bottom;
      if (n < i1)
      {
        paramInt1 = 0;
        if (i2 <= i3) {
          break label701;
        }
        paramInt2 = i4 - 1;
        i = 0;
        if (i >= i4) {
          break label747;
        }
        localObject = this.a.getChildAt(i);
        if ((i < paramInt1) || (i > paramInt2)) {
          break label710;
        }
        this.a.mRecycler.a((View)localObject, i);
        ((View)localObject).setTag(2131230829, null);
      }
      for (;;)
      {
        i += 1;
        break label638;
        paramInt1 = n - i1;
        break;
        paramInt2 = i2 - i1;
        break label636;
        if (ListView.access$1300(this.a)) {
          ((View)localObject).setTag(2131230829, new Point(((View)localObject).getTop(), ((View)localObject).getBottom()));
        }
      }
      ListView.access$1400(this.a, paramInt1, paramInt2 - paramInt1 + 1);
    } while (this.a.mItemCount == 0);
    paramInt2 = this.a.getChildCount();
    boolean bool2 = this.a.shouldShowSelector();
    if (this.a.mSelectedPosition >= 0)
    {
      j = this.a.mSelectedPosition;
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "first is:" + n + ",last is:" + i2 + ",firstPosition is:" + i1 + ",lastPosition is:" + i3 + ",newSelectionPosition is:" + j + ",mStackFromBottom is:" + this.a.mStackFromBottom);
      }
      if ((n > i1) || (i2 < i3)) {
        break label1154;
      }
      if (this.a.mStackFromBottom) {
        break label1119;
      }
      paramInt1 = n;
      if (n > this.a.mItemCount - 1) {
        paramInt1 = this.a.mItemCount - 1;
      }
      ListView.access$1500(this.a, paramInt1, m);
      bool1 = true;
      paramInt1 = -1;
      i = 0;
      paramInt2 = 0;
    }
    for (;;)
    {
      k = this.a.getChildCount();
      if ((j >= 0) && (j < k) && (bool2)) {
        this.a.positionSelector(j, this.a.getChildAt(j - this.a.mFirstPosition));
      }
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "upItemsMaxIndex is:" + paramInt1 + ",upItemsMoveDistance is:" + paramInt2 + ",downItemsMoveDistance is:" + i);
      }
      if (ListView.access$1300(this.a)) {
        a(k, paramInt1, paramInt2, i, bool1);
      }
      this.a.invalidate();
      return;
      if (bool2)
      {
        j = this.a.mSelectorPosition;
        break;
      }
      j = -1;
      break;
      label1119:
      localObject = this.a;
      if (n - 1 < 0) {}
      for (paramInt1 = 0;; paramInt1 = n - 1)
      {
        ListView.access$1600((ListView)localObject, paramInt1, k);
        break;
      }
      label1154:
      if (n <= i1)
      {
        if ((this.a.mStackFromBottom) || (j >= 0))
        {
          this.a.mFirstPosition = n;
          localObject = this.a.getChildAt(paramInt1);
          paramInt2 = ((View)localObject).getTop();
          this.a.fillGap(false);
          ListView.access$1000(this.a);
          paramInt1 = ((View)localObject).getTop();
          i = paramInt2 - paramInt1;
          if (paramInt1 - this.a.mDividerHeight > 0) {}
          for (paramInt1 = -paramInt1 + this.a.mDividerHeight;; paramInt1 = 0)
          {
            k = this.a.indexOfChild((View)localObject) - 1;
            paramInt2 = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.a.getChildAt(0);
        paramInt2 = ((View)localObject).getTop();
        this.a.offsetChildrenTopAndBottom(m - ((View)localObject).getTop());
        this.a.mFirstPosition = n;
        this.a.fillGap(true);
        ListView.access$1000(this.a);
        if (((View)localObject).getTop() - this.a.mDividerHeight > 0) {}
        for (paramInt1 = -((View)localObject).getTop() + this.a.mDividerHeight;; paramInt1 = 0)
        {
          i = paramInt2 - ((View)localObject).getTop();
          k = this.a.indexOfChild((View)localObject);
          paramInt2 = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      if (i2 >= i3)
      {
        if ((!this.a.mStackFromBottom) || (j >= 0))
        {
          localObject = this.a.getChildAt(paramInt2 - 1);
          paramInt2 = ((View)localObject).getBottom();
          this.a.fillGap(true);
          ListView.access$1000(this.a);
          paramInt1 = ((View)localObject).getBottom();
          paramInt2 -= paramInt1;
          if (k - paramInt1 - this.a.mDividerHeight > 0) {}
          for (paramInt1 = k - paramInt1 - this.a.mDividerHeight;; paramInt1 = 0)
          {
            k = this.a.indexOfChild((View)localObject);
            i = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.a.getChildAt(paramInt2 - 1);
        paramInt2 = ((View)localObject).getTop();
        this.a.offsetChildrenTopAndBottom(k - ((View)localObject).getBottom());
        this.a.fillGap(false);
        ListView.access$1000(this.a);
        if (k - ((View)localObject).getBottom() - this.a.mDividerHeight > 0) {}
        for (paramInt1 = k - ((View)localObject).getBottom() - this.a.mDividerHeight;; paramInt1 = 0)
        {
          paramInt2 -= ((View)localObject).getTop();
          k = this.a.indexOfChild((View)localObject);
          i = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      View localView;
      if (((j >= 0) && (j < n)) || ((j < 0) && (!this.a.mStackFromBottom)))
      {
        localObject = this.a.getChildAt(paramInt1 - 1);
        k = ((View)localObject).getTop();
        localView = this.a.getChildAt(paramInt1);
        i = localView.getTop();
        m = localView.getTop();
        i2 = ((View)localObject).getBottom();
        paramInt1 = n - i1;
        while (paramInt1 < paramInt2)
        {
          this.a.getChildAt(paramInt1).offsetTopAndBottom(-(m - i2) + this.a.mDividerHeight);
          paramInt1 += 1;
        }
        this.a.fillGap(true);
        ListView.access$1000(this.a);
        m = localView.getTop();
        paramInt2 = k - ((View)localObject).getTop();
        paramInt1 = this.a.indexOfChild((View)localObject);
        i -= m;
        bool1 = false;
      }
      else if ((j >= n) || ((j < 0) && (this.a.mStackFromBottom)))
      {
        localObject = this.a.getChildAt(paramInt1 - 1);
        paramInt2 = ((View)localObject).getTop();
        localView = this.a.getChildAt(paramInt1);
        i = localView.getTop();
        k = localView.getTop();
        m = this.a.getChildAt(paramInt1 - 1).getBottom();
        paramInt1 = 0;
        while (paramInt1 < n - i1)
        {
          this.a.getChildAt(paramInt1).offsetTopAndBottom(k - m - this.a.mDividerHeight);
          paramInt1 += 1;
        }
        this.a.fillGap(false);
        ListView.access$1000(this.a);
        k = localView.getTop();
        paramInt2 -= ((View)localObject).getTop();
        paramInt1 = this.a.indexOfChild((View)localObject);
        i -= k;
        bool1 = false;
      }
      else
      {
        paramInt1 = -1;
        i = 0;
        paramInt2 = 0;
        bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     almz
 * JD-Core Version:    0.7.0.1
 */