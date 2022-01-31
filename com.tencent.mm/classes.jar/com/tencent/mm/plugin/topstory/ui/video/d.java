package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
{
  public static final h c(b paramb)
  {
    AppMethodBeat.i(1709);
    int n = paramb.getLayoutManager().getChildCount();
    int j;
    label73:
    int k;
    Object localObject;
    if (n == 0)
    {
      paramb = null;
      if (!(paramb instanceof h))
      {
        AppMethodBeat.o(1709);
        return null;
      }
    }
    else if (paramb.getLayoutManager().getClipToPadding())
    {
      j = paramb.cJj().iI() + paramb.cJj().iK() / 2;
      int i = 2147483647;
      k = 0;
      localObject = null;
      label81:
      if (k >= n) {
        break label166;
      }
      View localView = paramb.getLayoutManager().getChildAt(k);
      int m = Math.abs(paramb.cJj().bh(localView) + paramb.cJj().bl(localView) / 2 - j);
      if (m >= i) {
        break label194;
      }
      localObject = localView;
      i = m;
    }
    label166:
    label194:
    for (;;)
    {
      k += 1;
      break label81;
      j = paramb.cJj().getEnd() / 2;
      break label73;
      paramb = paramb.getRecyclerView().bb(localObject);
      break;
      paramb = (h)paramb;
      AppMethodBeat.o(1709);
      return paramb;
    }
  }
  
  public void a(b paramb) {}
  
  public void a(b paramb, int paramInt) {}
  
  public void b(b paramb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.d
 * JD-Core Version:    0.7.0.1
 */