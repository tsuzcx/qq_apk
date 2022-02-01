package com.tencent.mm.plugin.sns.ad.timeline.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FeedbackContentViewGroup
  extends ViewGroup
{
  private List<a> JIC;
  private int JID;
  
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
    AppMethodBeat.i(266920);
    this.JIC = new LinkedList();
    try
    {
      this.JID = a.fromDPToPix(getContext(), 12);
      AppMethodBeat.o(266920);
      return;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(266920);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(266922);
    try
    {
      Object localObject = this.JIC;
      int j = getChildCount();
      paramInt3 = 0;
      int k = this.JID;
      paramInt2 = 0;
      localObject = ((List)localObject).iterator();
      paramInt1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        int m = ((a)((Iterator)localObject).next()).uAE;
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
      AppMethodBeat.o(266922);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(266922);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(266921);
    super.onMeasure(paramInt1, paramInt2);
    for (;;)
    {
      int j;
      int i;
      Object localObject2;
      try
      {
        measureChildren(paramInt1, paramInt2);
        j = this.JID;
        k = getChildCount();
        i = getMeasuredWidth();
        this.JIC.clear();
        paramInt1 = 0;
        if (paramInt1 >= k) {
          break label355;
        }
        Object localObject1 = this.JIC;
        localObject2 = new a();
        ((a)localObject2).uAE = 0;
        ((a)localObject2).JIE = i;
        ((a)localObject2).JIF = false;
        ((List)localObject1).add(localObject2);
        paramInt1 += 1;
        continue;
        if (paramInt2 >= k) {
          break label250;
        }
        localObject2 = getChildAt(paramInt2);
        int m = Math.min(((View)localObject2).getMeasuredWidth(), i);
        Iterator localIterator2 = this.JIC.iterator();
        if (localIterator2.hasNext())
        {
          localObject1 = (a)localIterator2.next();
          if ((localObject1 == null) || (((a)localObject1).JIF)) {
            continue;
          }
          if (((a)localObject1).JIE >= m)
          {
            if (localObject1 != null)
            {
              ((a)localObject1).uAE += 1;
              ((a)localObject1).JIE -= m + j;
            }
            if (paramInt1 != 0) {
              break label352;
            }
            paramInt1 = ((View)localObject2).getMeasuredHeight();
            break label362;
          }
          ((a)localObject1).JIF = true;
          continue;
        }
        localIterator1 = null;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(266921);
        return;
      }
      continue;
      label250:
      Iterator localIterator1 = this.JIC.iterator();
      while (localIterator1.hasNext())
      {
        localObject2 = (a)localIterator1.next();
        if ((localObject2 == null) || (((a)localObject2).uAE == 0)) {
          localIterator1.remove();
        }
      }
      int k = this.JIC.size();
      paramInt2 = k * paramInt1;
      paramInt1 = paramInt2;
      if (k > 1) {
        paramInt1 = paramInt2 + (k - 1) * j;
      }
      setMeasuredDimension(i, paramInt1);
      AppMethodBeat.o(266921);
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
    int JIE;
    boolean JIF;
    int uAE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.FeedbackContentViewGroup
 * JD-Core Version:    0.7.0.1
 */