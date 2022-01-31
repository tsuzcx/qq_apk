package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends com.tencent.mm.plugin.topstory.ui.video.d
{
  private static View e(b paramb)
  {
    AppMethodBeat.i(2026);
    int i = 0;
    while (i < paramb.getRecyclerView().getChildCount())
    {
      View localView = paramb.getRecyclerView().getChildAt(i);
      RecyclerView.v localv = paramb.getRecyclerView().bb(localView);
      if ((localView.getTag() != null) && (localView.getTag().equals("video")) && (localView.getTop() > 0) && (localv.jN() >= 0))
      {
        AppMethodBeat.o(2026);
        return localView;
      }
      ab.i("MicroMsg.TopStory.TopStoryHItemViewController", "findTargetPlayView index:%s, top:%s, pos:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(localView.getTop()), Integer.valueOf(localv.jN()) });
      i += 1;
    }
    AppMethodBeat.o(2026);
    return null;
  }
  
  public static RecyclerView.v f(b paramb)
  {
    AppMethodBeat.i(2027);
    View localView = e(paramb);
    if (localView != null)
    {
      paramb = paramb.getRecyclerView().bb(localView);
      AppMethodBeat.o(2027);
      return paramb;
    }
    AppMethodBeat.o(2027);
    return null;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(2023);
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = f(paramb);
    int i;
    int j;
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (localObject == null) {
        break label179;
      }
      i = ((h)localObject).cJb();
      if ((i != paramb.cJk()) && (paramb.cJh().tjS)) {
        paramb.cJh().stopPlay();
      }
      paramb.cJa();
      j = 0;
      label85:
      if (j >= localRecyclerView.getChildCount()) {
        break label200;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (h)paramb.getRecyclerView().bb((View)localObject);
        if (((h)localObject).cJb() != i) {
          break label184;
        }
        ((h)localObject).cKu();
        ((h)localObject).cIZ();
        if (!paramb.cJh().tjS) {
          ((h)localObject).tlw.cJz();
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label85;
      AppMethodBeat.o(2023);
      return;
      label179:
      i = -1;
      break;
      label184:
      ((h)localObject).cKt();
      ((h)localObject).tlw.cJA();
    }
    label200:
    AppMethodBeat.o(2023);
  }
  
  public final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(2025);
    int i = 0;
    View localView1 = null;
    View localView2;
    for (;;)
    {
      localView2 = localView1;
      if (i >= paramb.getRecyclerView().getChildCount()) {
        break;
      }
      localView1 = paramb.getRecyclerView().getChildAt(i);
      localView2 = localView1;
      if (RecyclerView.bq(localView1) == paramInt) {
        break;
      }
      i += 1;
    }
    if (localView2 != null)
    {
      paramInt = paramb.cJj().bh(localView2);
      i = paramb.cJp();
      paramb.getRecyclerView().a(0, paramInt - i, null);
    }
    AppMethodBeat.o(2025);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(2024);
    Object localObject = f(paramb);
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (!paramb.cJh().tjS)
      {
        if (!paramb.cJc().isConnected()) {
          break label89;
        }
        ((h)localObject).mA(true);
      }
    }
    for (;;)
    {
      ((h)localObject).cIZ();
      paramb.GA(((h)localObject).cJb());
      paramb.cJd().cKd();
      AppMethodBeat.o(2024);
      return;
      AppMethodBeat.o(2024);
      return;
      label89:
      ((h)localObject).tlw.cJD();
      paramb.cJh().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.d
 * JD-Core Version:    0.7.0.1
 */