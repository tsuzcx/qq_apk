package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FeedbackContentViewGroup
  extends ViewGroup
{
  private List<a> PZE;
  private int PZF;
  
  public FeedbackContentViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FeedbackContentViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FeedbackContentViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(311002);
    this.PZE = new LinkedList();
    try
    {
      this.PZF = a.fromDPToPix(getContext(), 12);
      return;
    }
    finally
    {
      AppMethodBeat.o(311002);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(311032);
    try
    {
      Object localObject1 = this.PZE;
      int j = getChildCount();
      paramInt3 = 0;
      int k = this.PZF;
      paramInt2 = 0;
      localObject1 = ((List)localObject1).iterator();
      paramInt1 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        int m = ((a)((Iterator)localObject1).next()).xHh;
        int i = 0;
        paramInt4 = 0;
        while ((paramInt4 < m) && (paramInt3 < j))
        {
          View localView = getChildAt(paramInt3);
          int n = localView.getMeasuredWidth();
          paramInt1 = localView.getMeasuredHeight();
          localView.layout(i, paramInt2, n + i, paramInt1 + paramInt2);
          paramInt3 += 1;
          i += n + k;
          paramInt4 += 1;
        }
        paramInt2 += paramInt1 + k;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311032);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311016);
    super.onMeasure(paramInt1, paramInt2);
    for (;;)
    {
      int j;
      int i;
      Object localObject3;
      try
      {
        measureChildren(paramInt1, paramInt2);
        j = this.PZF;
        k = getChildCount();
        i = getMeasuredWidth();
        this.PZE.clear();
        paramInt1 = 0;
        if (paramInt1 >= k) {
          break label355;
        }
        Object localObject1 = this.PZE;
        localObject3 = new a();
        ((a)localObject3).xHh = 0;
        ((a)localObject3).PZG = i;
        ((a)localObject3).PZH = false;
        ((List)localObject1).add(localObject3);
        paramInt1 += 1;
        continue;
        if (paramInt2 >= k) {
          break label250;
        }
        localObject3 = getChildAt(paramInt2);
        int m = Math.min(((View)localObject3).getMeasuredWidth(), i);
        Iterator localIterator2 = this.PZE.iterator();
        if (localIterator2.hasNext())
        {
          localObject1 = (a)localIterator2.next();
          if ((localObject1 == null) || (((a)localObject1).PZH)) {
            continue;
          }
          if (((a)localObject1).PZG >= m)
          {
            if (localObject1 != null)
            {
              ((a)localObject1).xHh += 1;
              ((a)localObject1).PZG -= m + j;
            }
            if (paramInt1 != 0) {
              break label352;
            }
            paramInt1 = ((View)localObject3).getMeasuredHeight();
            break label362;
          }
          ((a)localObject1).PZH = true;
          continue;
        }
        localIterator1 = null;
      }
      finally
      {
        AppMethodBeat.o(311016);
        return;
      }
      continue;
      label250:
      Iterator localIterator1 = this.PZE.iterator();
      while (localIterator1.hasNext())
      {
        localObject3 = (a)localIterator1.next();
        if ((localObject3 == null) || (((a)localObject3).xHh == 0)) {
          localIterator1.remove();
        }
      }
      int k = this.PZE.size();
      paramInt2 = k * paramInt1;
      paramInt1 = paramInt2;
      if (k > 1) {
        paramInt1 = paramInt2 + (k - 1) * j;
      }
      setMeasuredDimension(i, paramInt1);
      AppMethodBeat.o(311016);
      return;
      label352:
      break label362;
      label355:
      paramInt2 = 0;
      paramInt1 = 0;
      continue;
      label362:
      paramInt2 += 1;
    }
  }
  
  static final class a
  {
    int PZG;
    boolean PZH;
    int xHh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.FeedbackContentViewGroup
 * JD-Core Version:    0.7.0.1
 */