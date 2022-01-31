package com.tencent.toybrick.c;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public final class a$a
  extends com.tencent.toybrick.f.a
{
  public TextView Bxf;
  public ImageView Bxg;
  public ImageView Bxh;
  public MMSwitchBtn Bxi;
  public TextView pAD;
  public TextView titleTv;
  
  public a$a(final a parama, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(113196);
    this.titleTv = ((TextView)paramView.findViewById(16908310));
    this.Bxh = ((ImageView)paramView.findViewById(2131822804));
    this.Bxf = ((TextView)paramView.findViewById(2131822410));
    this.Bxg = ((ImageView)paramView.findViewById(2131822805));
    this.pAD = ((TextView)paramView.findViewById(2131821890));
    this.Bxi = ((MMSwitchBtn)paramView.findViewById(2131820950));
    this.Bxi.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean) {}
    });
    AppMethodBeat.o(113196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.c.a.a
 * JD-Core Version:    0.7.0.1
 */