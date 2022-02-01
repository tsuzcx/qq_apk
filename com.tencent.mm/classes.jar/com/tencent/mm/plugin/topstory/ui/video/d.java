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
    AppMethodBeat.i(126068);
    int n = paramb.getLayoutManager().getChildCount();
    int j;
    label71:
    int k;
    Object localObject;
    if (n == 0)
    {
      paramb = null;
      if (!(paramb instanceof h))
      {
        AppMethodBeat.o(126068);
        return null;
      }
    }
    else if (paramb.getLayoutManager().getClipToPadding())
    {
      j = paramb.etk().kB() + paramb.etk().kD() / 2;
      int i = 2147483647;
      k = 0;
      localObject = null;
      label79:
      if (k >= n) {
        break label164;
      }
      View localView = paramb.getLayoutManager().getChildAt(k);
      int m = Math.abs(paramb.etk().bn(localView) + paramb.etk().br(localView) / 2 - j);
      if (m >= i) {
        break label191;
      }
      localObject = localView;
      i = m;
    }
    label164:
    label191:
    for (;;)
    {
      k += 1;
      break label79;
      j = paramb.etk().getEnd() / 2;
      break label71;
      paramb = paramb.getRecyclerView().bh(localObject);
      break;
      paramb = (h)paramb;
      AppMethodBeat.o(126068);
      return paramb;
    }
  }
  
  public void a(b paramb) {}
  
  public void a(b paramb, int paramInt) {}
  
  public void b(b paramb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.d
 * JD-Core Version:    0.7.0.1
 */