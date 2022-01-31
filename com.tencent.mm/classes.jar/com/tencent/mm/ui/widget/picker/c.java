package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public CustomTimePicker AIY;
  public c.a AIZ;
  private BottomSheetBehavior gE;
  private Button gtF;
  private View iDS;
  private Button jIG;
  private Context mContext;
  public android.support.design.widget.c zRa;
  private int zRb;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(112838);
    this.mContext = paramContext;
    this.zRa = new android.support.design.widget.c(this.mContext);
    this.iDS = View.inflate(this.mContext, 2130970994, null);
    this.AIY = ((CustomTimePicker)this.iDS.findViewById(2131828491));
    this.gtF = ((Button)this.iDS.findViewById(2131823301));
    this.gtF.setOnClickListener(new c.1(this));
    this.jIG = ((Button)this.iDS.findViewById(2131822887));
    this.jIG.setOnClickListener(new c.2(this));
    this.zRa.setContentView(this.iDS);
    this.zRb = al.fromDPToPix(this.mContext, 288);
    this.gE = BottomSheetBehavior.i((View)this.iDS.getParent());
    if (this.gE != null)
    {
      this.gE.t(this.zRb);
      this.gE.go = false;
    }
    this.zRa.setOnDismissListener(new c.3(this));
    AppMethodBeat.o(112838);
  }
  
  public final void onGlobalLayout() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */