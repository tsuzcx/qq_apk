package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;

public final class d
  extends com.tencent.mm.plugin.topstory.ui.video.d
{
  public static RecyclerView.v e(b paramb)
  {
    int i = 0;
    View localView;
    if (i < paramb.getRecyclerView().getChildCount())
    {
      localView = paramb.getRecyclerView().getChildAt(i);
      RecyclerView.v localv = paramb.getRecyclerView().aT(localView);
      if ((localView.getTag() == null) || (!localView.getTag().equals("video")) || (localView.getTop() <= 0) || (localv.id() < 0)) {}
    }
    for (;;)
    {
      if (localView == null) {
        break label97;
      }
      return paramb.getRecyclerView().aT(localView);
      i += 1;
      break;
      localView = null;
    }
    label97:
    return null;
  }
  
  public final void a(b paramb)
  {
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = e(paramb);
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      int i;
      int j;
      if (localObject != null)
      {
        i = ((h)localObject).bNr();
        if ((i != paramb.bNB()) && (paramb.bNx().pGx)) {
          paramb.bNx().stopPlay();
        }
        paramb.bNq();
        j = 0;
        label79:
        if (j >= localRecyclerView.getChildCount()) {
          return;
        }
        localObject = localRecyclerView.getChildAt(j);
        if (((View)localObject).getTag() != null)
        {
          localObject = (h)paramb.getRecyclerView().aT((View)localObject);
          if (((h)localObject).bNr() != i) {
            break label171;
          }
          ((h)localObject).bOD();
          ((h)localObject).bNp();
          if (!paramb.bNx().pGx) {
            ((h)localObject).pHM.bNL();
          }
        }
      }
      for (;;)
      {
        j += 1;
        break label79;
        i = -1;
        break;
        label171:
        ((h)localObject).bOC();
        ((h)localObject).pHM.bNM();
      }
    }
  }
  
  public final void a(b paramb, int paramInt)
  {
    View localView1 = null;
    int i = 0;
    View localView2;
    for (;;)
    {
      localView2 = localView1;
      if (i >= paramb.getRecyclerView().getChildCount()) {
        break;
      }
      localView1 = paramb.getRecyclerView().getChildAt(i);
      localView2 = localView1;
      if (RecyclerView.bg(localView1) == paramInt) {
        break;
      }
      i += 1;
    }
    if (localView2 != null)
    {
      paramInt = paramb.bNA().aX(localView2);
      i = paramb.bNG();
      paramb.getRecyclerView().smoothScrollBy(0, paramInt - i);
    }
  }
  
  public final void b(b paramb)
  {
    Object localObject = e(paramb);
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (localObject != null) {
        if (!paramb.bNx().pGx)
        {
          if ((!paramb.bNs().aIq()) && (!g.bNg())) {
            break label80;
          }
          ((h)localObject).jJ(true);
        }
      }
    }
    for (;;)
    {
      ((h)localObject).bNp();
      paramb.zx(((h)localObject).bNr());
      paramb.bNt().bOp();
      return;
      label80:
      if (paramb.bNs().pFL)
      {
        if (paramb.bNs().isConnected()) {
          ((h)localObject).pHM.bNO();
        }
        for (;;)
        {
          paramb.bNx().stopPlay();
          break;
          ((h)localObject).pHM.bNP();
        }
      }
      ((h)localObject).jJ(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.d
 * JD-Core Version:    0.7.0.1
 */