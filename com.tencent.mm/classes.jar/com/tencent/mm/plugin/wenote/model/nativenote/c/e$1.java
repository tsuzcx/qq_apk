package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

final class e$1
  implements Runnable
{
  e$1(e parame, boolean paramBoolean) {}
  
  public final void run()
  {
    RecyclerView localRecyclerView = e.a(this.rKn);
    if (localRecyclerView == null) {
      return;
    }
    int i = 0;
    label15:
    Object localObject;
    c localc;
    if (i < localRecyclerView.getChildCount())
    {
      localObject = localRecyclerView.getChildAt(i);
      localc = f.ds((View)localObject);
      if (localc != null)
      {
        if (localc.rJB == null) {
          break label68;
        }
        if (this.rKm) {
          localc.rJB.postInvalidate();
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label15;
      break;
      label68:
      if ((localc.rJC != null) && (localc.rJD != null))
      {
        LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(R.h.other_cover_view);
        LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(R.h.other_up_cover_view);
        localObject = (LinearLayout)((View)localObject).findViewById(R.h.other_down_cover_view);
        this.rKn.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.rJC.getPosInDataList());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.1
 * JD-Core Version:    0.7.0.1
 */