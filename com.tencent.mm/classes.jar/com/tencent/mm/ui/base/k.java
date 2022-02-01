package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.g;

public final class k
  extends g
{
  private Button gxv;
  private TextView kuu;
  private TextView titleTv;
  
  public k(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205229);
    apf(2131495002);
    this.titleTv = ((TextView)this.lJI.findViewById(2131309186));
    this.kuu = ((TextView)this.lJI.findViewById(2131309179));
    this.gxv = ((Button)this.lJI.findViewById(2131305423));
    AppMethodBeat.o(205229);
  }
  
  public final k bmc(String paramString)
  {
    AppMethodBeat.i(205230);
    this.titleTv.setText(paramString);
    AppMethodBeat.o(205230);
    return this;
  }
  
  public final k bmd(String paramString)
  {
    AppMethodBeat.i(205231);
    this.kuu.setText(paramString);
    AppMethodBeat.o(205231);
    return this;
  }
  
  public final k g(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(205232);
    this.gxv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(205232);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.k
 * JD-Core Version:    0.7.0.1
 */