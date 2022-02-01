package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class n
  extends j
{
  public n(View paramView, k paramk)
  {
    super(paramView, paramk);
    AppMethodBeat.i(30881);
    this.xwT.setVisibility(0);
    this.hIz.setVisibility(8);
    this.pZr.setVisibility(8);
    this.xwT.setTag(this);
    this.xwT.setOnClickListener(this.xxi);
    AppMethodBeat.o(30881);
  }
  
  public final void a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30882);
    this.xwW.setImageResource(R.k.msg_state_fail_resend);
    this.xwU.setText(((com.tencent.mm.plugin.wenote.model.a.j)paramc).title);
    this.xwV.setText(((com.tencent.mm.plugin.wenote.model.a.j)paramc).content);
    super.a(paramc, paramInt1, paramInt2);
    AppMethodBeat.o(30882);
  }
  
  public final int dvW()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.n
 * JD-Core Version:    0.7.0.1
 */