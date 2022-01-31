package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.aj;
import android.view.View;

public class d
{
  public static final h c(b paramb)
  {
    int n = paramb.getLayoutManager().getChildCount();
    int j;
    label61:
    int k;
    Object localObject;
    if (n == 0)
    {
      paramb = null;
      if (!(paramb instanceof h)) {
        return null;
      }
    }
    else if (paramb.getLayoutManager().getClipToPadding())
    {
      j = paramb.bNA().hh() + paramb.bNA().hj() / 2;
      int i = 2147483647;
      k = 0;
      localObject = null;
      label69:
      if (k >= n) {
        break label154;
      }
      View localView = paramb.getLayoutManager().getChildAt(k);
      int m = Math.abs(paramb.bNA().aX(localView) + paramb.bNA().bb(localView) / 2 - j);
      if (m >= i) {
        break label174;
      }
      localObject = localView;
      i = m;
    }
    label154:
    label174:
    for (;;)
    {
      k += 1;
      break label69;
      j = paramb.bNA().getEnd() / 2;
      break label61;
      paramb = paramb.getRecyclerView().aT(localObject);
      break;
      return (h)paramb;
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