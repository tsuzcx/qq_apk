package com.tencent.mm.plugin.topstory.ui.video;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.u;
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
      j = paramb.gqD().kT() + paramb.gqD().kV() / 2;
      int i = 2147483647;
      k = 0;
      localObject = null;
      label79:
      if (k >= n) {
        break label164;
      }
      View localView = paramb.getLayoutManager().getChildAt(k);
      int m = Math.abs(paramb.gqD().aZ(localView) + paramb.gqD().bd(localView) / 2 - j);
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
      j = paramb.gqD().getEnd() / 2;
      break label71;
      paramb = paramb.getRecyclerView().aQ(localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.d
 * JD-Core Version:    0.7.0.1
 */