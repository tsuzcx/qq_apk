package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.widget.a.j;

public final class o
  extends j
{
  private Button lDJ;
  private TextView qjr;
  private TextView titleTv;
  
  public o(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(251358);
    aFf(a.h.half_bottom_tips_dlg_layout);
    this.titleTv = ((TextView)this.rootView.findViewById(a.g.tips_title));
    this.qjr = ((TextView)this.rootView.findViewById(a.g.tips_hint));
    this.lDJ = ((Button)this.rootView.findViewById(a.g.next_btn));
    AppMethodBeat.o(251358);
  }
  
  public final o bAc(String paramString)
  {
    AppMethodBeat.i(251361);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(251361);
    return this;
  }
  
  public final o bAd(String paramString)
  {
    AppMethodBeat.i(251365);
    this.qjr.setText(paramString);
    AppMethodBeat.o(251365);
    return this;
  }
  
  public final o i(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(251371);
    this.lDJ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(251371);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.o
 * JD-Core Version:    0.7.0.1
 */