package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class l
  extends j
{
  private View psM;
  
  public l(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30873);
    this.psv.setVisibility(8);
    this.dsD.setVisibility(8);
    this.jld.setVisibility(8);
    this.psv.setOnClickListener(null);
    this.psA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30872);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        l.this.ECI.ceA();
        l.this.ECI.requestFocus();
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
    paramc = (RelativeLayout.LayoutParams)this.psB.getLayoutParams();
    paramc.bottomMargin = 0;
    paramc.topMargin = 0;
    this.psB.setLayoutParams(paramc);
    this.psA.setVisibility(0);
    this.psM = this.auu.findViewById(2131302940);
    AppMethodBeat.o(30874);
  }
  
  public final int cdT()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.l
 * JD-Core Version:    0.7.0.1
 */