package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.a.g;

public final class l
  extends g
{
  private Button jbJ;
  private TextView nmi;
  private TextView titleTv;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(218529);
    ayv(a.h.half_bottom_tips_dlg_layout);
    this.titleTv = ((TextView)this.oFW.findViewById(a.g.tips_title));
    this.nmi = ((TextView)this.oFW.findViewById(a.g.tips_hint));
    this.jbJ = ((Button)this.oFW.findViewById(a.g.next_btn));
    AppMethodBeat.o(218529);
  }
  
  public final l byC(String paramString)
  {
    AppMethodBeat.i(218530);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(218530);
    return this;
  }
  
  public final l byD(String paramString)
  {
    AppMethodBeat.i(218532);
    this.nmi.setText(paramString);
    AppMethodBeat.o(218532);
    return this;
  }
  
  public final l h(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(218533);
    this.jbJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(218533);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.l
 * JD-Core Version:    0.7.0.1
 */