package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

final class e$1
  implements Runnable
{
  e$1(e parame, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(26858);
    RecyclerView localRecyclerView = e.a(this.vAR);
    if (localRecyclerView == null)
    {
      AppMethodBeat.o(26858);
      return;
    }
    int i = 0;
    if (i < localRecyclerView.getChildCount())
    {
      Object localObject = localRecyclerView.getChildAt(i);
      c localc = f.ey((View)localObject);
      if (localc != null)
      {
        if (localc.vAf == null) {
          break label80;
        }
        if (this.vAQ) {
          localc.vAf.postInvalidate();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label80:
        if ((localc.vAg != null) && (localc.vAh != null))
        {
          LinearLayout localLinearLayout1 = (LinearLayout)((View)localObject).findViewById(2131826601);
          LinearLayout localLinearLayout2 = (LinearLayout)((View)localObject).findViewById(2131826570);
          localObject = (LinearLayout)((View)localObject).findViewById(2131826602);
          this.vAR.a(localLinearLayout1, localLinearLayout2, (View)localObject, localc.vAg.getPosInDataList());
        }
      }
    }
    AppMethodBeat.o(26858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.nativenote.c.e.1
 * JD-Core Version:    0.7.0.1
 */