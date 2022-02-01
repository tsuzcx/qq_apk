package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class l
  extends j
{
  private View olE;
  
  public l(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30873);
    this.oln.setVisibility(8);
    this.djK.setVisibility(8);
    this.irQ.setVisibility(8);
    this.oln.setOnClickListener(null);
    this.ols.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(30872);
        l.this.BGF.bSH();
        l.this.BGF.requestFocus();
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
    paramc = (RelativeLayout.LayoutParams)this.olt.getLayoutParams();
    paramc.bottomMargin = 0;
    paramc.topMargin = 0;
    this.olt.setLayoutParams(paramc);
    this.ols.setVisibility(0);
    this.olE = this.arI.findViewById(2131302940);
    AppMethodBeat.o(30874);
  }
  
  public final int bSa()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.l
 * JD-Core Version:    0.7.0.1
 */