package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class l
  extends j
{
  private View uqN;
  
  public l(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30873);
    this.uqw.setVisibility(8);
    this.fDJ.setVisibility(8);
    this.ndX.setVisibility(8);
    this.uqw.setOnClickListener(null);
    this.uqB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30872);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        l.this.QKq.cSk();
        l.this.QKq.requestFocus();
        a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(30872);
      }
    });
    AppMethodBeat.o(30873);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30874);
    super.a(paramc, paramInt1, paramInt2);
    if (paramc.getType() != -1)
    {
      AppMethodBeat.o(30874);
      return;
    }
    paramc = (RelativeLayout.LayoutParams)this.uqC.getLayoutParams();
    paramc.bottomMargin = 0;
    paramc.topMargin = 0;
    this.uqC.setLayoutParams(paramc);
    this.uqB.setVisibility(0);
    this.uqN = this.amk.findViewById(R.h.dQe);
    AppMethodBeat.o(30874);
  }
  
  public final int cRD()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.l
 * JD-Core Version:    0.7.0.1
 */