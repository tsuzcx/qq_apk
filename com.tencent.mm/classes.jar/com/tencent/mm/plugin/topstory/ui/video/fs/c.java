package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.protocal.c.byg;

public final class c
  extends d
{
  public final void a(b paramb)
  {
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = c(paramb);
    if ((localObject instanceof g))
    {
      localObject = (g)localObject;
      int i;
      int j;
      if (localObject != null)
      {
        i = ((g)localObject).id();
        if ((i != paramb.bNB()) && (paramb.bNx().pGx))
        {
          paramb.bNx().stopPlay();
          if (localObject != null) {
            paramb.bNt().b(((g)localObject).pDy);
          }
        }
        paramb.bNq();
        j = 0;
        label98:
        if (j >= localRecyclerView.getChildCount()) {
          return;
        }
        localObject = localRecyclerView.getChildAt(j);
        if (((View)localObject).getTag() != null)
        {
          localObject = (g)paramb.getRecyclerView().aT((View)localObject);
          if (((g)localObject).id() != i) {
            break label185;
          }
          ((g)localObject).bNp();
          if (!paramb.bNx().pGx) {
            ((g)localObject).pHp.bNL();
          }
        }
      }
      for (;;)
      {
        j += 1;
        break label98;
        i = -1;
        break;
        label185:
        ((g)localObject).pHp.bNM();
      }
    }
  }
  
  public final void b(b paramb)
  {
    h localh = c(paramb);
    if ((localh != null) && ((localh instanceof g))) {
      if (!paramb.bNx().pGx)
      {
        if ((!paramb.bNs().aIq()) && (!com.tencent.mm.plugin.topstory.a.g.bNg())) {
          break label75;
        }
        localh.jJ(true);
      }
    }
    for (;;)
    {
      localh.bNp();
      paramb.zx(localh.bNr());
      paramb.bNt().bOp();
      return;
      label75:
      byg localbyg = localh.pDy;
      paramb.bNH();
      if (paramb.bNs().pFL)
      {
        if (paramb.bNs().isConnected()) {
          localh.bNZ().bNO();
        }
        for (;;)
        {
          paramb.bNx().stopPlay();
          break;
          localh.bNZ().bNP();
        }
      }
      localh.jJ(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.c
 * JD-Core Version:    0.7.0.1
 */