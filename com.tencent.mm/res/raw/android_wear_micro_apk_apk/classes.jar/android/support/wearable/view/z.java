package android.support.wearable.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.ab;
import android.support.v7.widget.af;
import android.support.v7.widget.ai;
import android.support.v7.widget.ak;
import android.view.View;
import java.util.Iterator;
import java.util.List;

final class z
  extends ab
{
  private int Hb;
  private boolean Hc;
  private int Hd;
  private boolean He = true;
  private boolean Hf = false;
  private ai Hg;
  private ai wb;
  
  private z(WearableListView paramWearableListView) {}
  
  private void aS(View paramView)
  {
    q(paramView, (int)(1.0F + getHeight() / 3.0F));
  }
  
  private void br(int paramInt)
  {
    this.Hd = paramInt;
    Iterator localIterator = WearableListView.e(this.Ha).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  private int fO()
  {
    int n = getChildCount();
    int j = 2147483647;
    int i1 = WearableListView.aR(this.Ha);
    int i = 0;
    int k = -1;
    if (i < n)
    {
      View localView = this.Ha.jdMethod_do().getChildAt(i);
      int m = this.Ha.getTop();
      m = Math.abs(i1 - (WearableListView.aR(localView) + m));
      if (m >= j) {
        break label101;
      }
      k = i;
      j = m;
    }
    label101:
    for (;;)
    {
      i += 1;
      break;
      if (k == -1) {
        throw new IllegalStateException("Can't find central view.");
      }
      return k;
    }
  }
  
  private void q(View paramView, int paramInt)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    int i = a(getWidth(), getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width, cX());
    int j = getHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    int n = localLayoutParams.topMargin;
    paramView.measure(i, a(j, localLayoutParams.bottomMargin + (k + m + n), paramInt, cY()));
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt)
  {
    ai localai2 = this.wb;
    ai localai1 = localai2;
    if (localai2 == null)
    {
      if (this.Hg == null) {
        this.Hg = new ae(paramRecyclerView.getContext(), this);
      }
      localai1 = this.Hg;
    }
    localai1.aI(paramInt);
    a(localai1);
  }
  
  public final void as(int paramInt)
  {
    this.He = false;
    if (paramInt > 0) {
      this.Hb = (paramInt - 1);
    }
    for (this.Hc = true;; this.Hc = false)
    {
      requestLayout();
      return;
      this.Hb = paramInt;
    }
  }
  
  public final int b(int paramInt, af paramaf, ak paramak)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int k = getPaddingLeft();
    int m = getWidth() - getPaddingRight();
    int i;
    int n;
    int j;
    View localView;
    if (paramInt < 0)
    {
      i = 0;
      for (;;)
      {
        if (i > paramInt)
        {
          paramak = getChildAt(0);
          if (this.Hb > 0)
          {
            n = Math.min(i - paramInt, Math.max(-paramak.getTop(), 0));
            j = i - n;
            az(n);
            i = j;
            if (this.Hb > 0)
            {
              i = j;
              if (j > paramInt)
              {
                this.Hb -= 1;
                localView = paramaf.aF(this.Hb);
                addView(localView, 0);
                aS(localView);
                i = paramak.getTop();
                localView.layout(k, i - WearableListView.h(this.Ha), m, i);
                i = j;
              }
            }
          }
          else
          {
            this.Hc = false;
            if (WearableListView.k(this.Ha) == null) {
              break label392;
            }
            j = getHeight();
            paramInt = Math.min(-paramInt + i, j - paramak.getTop());
            i -= paramInt;
            az(paramInt);
          }
        }
      }
    }
    for (;;)
    {
      label219:
      int i3 = getChildCount();
      int i4 = getWidth();
      int i5 = getHeight();
      paramInt = 0;
      m = 0;
      j = 0;
      k = 0;
      for (;;)
      {
        if (paramInt < i3)
        {
          paramak = getChildAt(paramInt);
          int i2;
          int i1;
          if (!paramak.hasFocus())
          {
            i2 = j;
            i1 = k;
            n = m;
            if (paramak.getRight() >= 0)
            {
              i2 = j;
              i1 = k;
              n = m;
              if (paramak.getLeft() <= i4)
              {
                i2 = j;
                i1 = k;
                n = m;
                if (paramak.getBottom() >= 0)
                {
                  i2 = j;
                  i1 = k;
                  n = m;
                  if (paramak.getTop() > i5) {}
                }
              }
            }
          }
          else
          {
            m = k;
            if (k == 0)
            {
              j = paramInt;
              m = 1;
            }
            n = paramInt;
            i1 = m;
            i2 = j;
          }
          paramInt += 1;
          j = i2;
          k = i1;
          m = n;
          continue;
          label392:
          j = WearableListView.l(this.Ha);
          break;
          if (paramInt <= 0) {
            break label697;
          }
          n = getHeight();
          j = 0;
          for (;;)
          {
            i = j;
            if (j >= paramInt) {
              break;
            }
            localView = getChildAt(getChildCount() - 1);
            if (paramak.getItemCount() <= this.Hb + getChildCount()) {
              break label566;
            }
            i = -Math.min(paramInt - j, Math.max(localView.getBottom() - n, 0));
            j -= i;
            az(i);
            i = j;
            if (j >= paramInt) {
              break;
            }
            localView = paramaf.aF(this.Hb + getChildCount());
            i = getChildAt(getChildCount() - 1).getBottom();
            addView(localView);
            aS(localView);
            localView.layout(k, i, m, WearableListView.h(this.Ha) + i);
          }
          label566:
          paramInt = Math.max(-paramInt + j, getHeight() / 2 - localView.getBottom());
          i = j - paramInt;
          az(paramInt);
          break label219;
        }
      }
      paramInt = i3 - 1;
      while (paramInt > m)
      {
        a(paramInt, paramaf);
        paramInt -= 1;
      }
      paramInt = j - 1;
      while (paramInt >= 0)
      {
        a(paramInt, paramaf);
        paramInt -= 1;
      }
      if (getChildCount() == 0) {
        this.Hb = 0;
      }
      for (;;)
      {
        br(this.Hd + i);
        return i;
        if (j > 0)
        {
          this.Hc = true;
          this.Hb += j;
        }
      }
      label697:
      i = 0;
    }
  }
  
  public final void c(af paramaf, ak paramak)
  {
    int i2 = getHeight() - getPaddingBottom();
    int i = this.Ha.fR();
    int m = WearableListView.g(this.Ha) + i;
    int i1;
    int j;
    int k;
    int i3;
    int n;
    if ((this.He) && (getChildCount() > 0))
    {
      i1 = fO();
      j = av(getChildAt(i1));
      i = j;
      k = i1;
      if (j == -1)
      {
        i3 = getChildCount();
        n = 0;
      }
      for (;;)
      {
        View localView;
        if (i1 + n >= i3)
        {
          i = j;
          k = i1;
          if (i1 - n < 0) {}
        }
        else
        {
          localView = getChildAt(i1 + n);
          if (localView == null) {
            break label201;
          }
          i = av(localView);
          j = i;
          if (i == -1) {
            break label201;
          }
        }
        for (k = i1 + n;; k = i1 - n)
        {
          if (i != -1) {
            break label250;
          }
          j = getChildAt(0).getTop();
          k = paramak.getItemCount();
          for (;;)
          {
            i = j;
            if (this.Hb < k) {
              break;
            }
            i = j;
            if (this.Hb <= 0) {
              break;
            }
            this.Hb -= 1;
          }
          label201:
          localView = getChildAt(i1 - n);
          if (localView == null) {
            break;
          }
          i = av(localView);
          j = i;
          if (i == -1) {
            break;
          }
        }
        n += 1;
      }
      label250:
      n = i;
      j = m;
      if (!this.Hf)
      {
        j = getChildAt(k).getTop();
        n = i;
      }
      while ((j > getPaddingTop()) && (n > 0))
      {
        n -= 1;
        j -= WearableListView.h(this.Ha);
      }
      i = j;
      if (n == 0)
      {
        i = j;
        if (j > this.Ha.fR()) {
          i = this.Ha.fR();
        }
      }
      this.Hb = n;
      b(paramaf);
      if ((!WearableListView.i(this.Ha)) || (paramak.getItemCount() != 1)) {
        break label505;
      }
      i = getWidth();
      j = getPaddingRight();
      paramaf = paramaf.aF(this.Hb);
      addView(paramaf, 0);
      q(paramaf, getHeight());
      paramaf.layout(getPaddingLeft(), getPaddingTop(), i - j, i2);
      this.Hf = true;
      label431:
      if (getChildCount() > 0) {
        this.Ha.post(WearableListView.j(this.Ha));
      }
      if (getChildCount() != 0) {
        break label624;
      }
      br(0);
    }
    for (;;)
    {
      this.He = true;
      this.Hc = false;
      return;
      i = m;
      if (!this.Hc) {
        break;
      }
      i = this.Ha.fR() - WearableListView.h(this.Ha);
      break;
      label505:
      m = getPaddingLeft();
      n = getWidth();
      i1 = getPaddingRight();
      i3 = paramak.getItemCount();
      k = 0;
      j = i;
      i = k;
      while ((this.Hb + i < i3) && (j < i2))
      {
        paramak = paramaf.aF(this.Hb + i);
        addView(paramak, i);
        aS(paramak);
        k = WearableListView.h(this.Ha) + j;
        paramak.layout(m, j, n - i1, k);
        i += 1;
        j = k;
      }
      this.Hf = false;
      break label431;
      label624:
      paramaf = getChildAt(fO());
      i = paramaf.getTop();
      j = this.Ha.fR();
      br(av(paramaf) * WearableListView.h(this.Ha) + (i - j));
    }
  }
  
  public final RecyclerView.LayoutParams cS()
  {
    return new RecyclerView.LayoutParams(-1, -2);
  }
  
  public final boolean cY()
  {
    return (getItemCount() != 1) || (!this.Hf);
  }
  
  public final void ec()
  {
    removeAllViews();
  }
  
  public final int fT()
  {
    return this.Hb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.z
 * JD-Core Version:    0.7.0.1
 */