package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import java.util.Calendar;
import java.util.Locale;

public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private CustomDatePicker AIP;
  public a.a AIQ;
  private BottomSheetBehavior gE;
  private Button gtF;
  private View iDS;
  private Button jIG;
  private Context mContext;
  private c zRa;
  private int zRb;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112812);
    this.mContext = paramContext;
    this.zRa = new c(this.mContext);
    this.iDS = View.inflate(this.mContext, 2130969295, null);
    this.AIP = ((CustomDatePicker)this.iDS.findViewById(2131823302));
    this.gtF = ((Button)this.iDS.findViewById(2131823301));
    this.gtF.setOnClickListener(new a.1(this));
    this.jIG = ((Button)this.iDS.findViewById(2131822887));
    this.jIG.setOnClickListener(new a.2(this));
    this.zRa.setContentView(this.iDS);
    this.zRa.setOnCancelListener(new a.3(this));
    this.zRb = al.fromDPToPix(this.mContext, 288);
    this.gE = BottomSheetBehavior.i((View)this.iDS.getParent());
    if (this.gE != null)
    {
      this.gE.t(this.zRb);
      this.gE.go = false;
    }
    this.zRa.setOnDismissListener(new a.4(this));
    AppMethodBeat.o(112812);
  }
  
  public final void aA(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112813);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(112813);
      return;
    }
    if (this.AIP != null) {
      this.AIP.az(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(112813);
  }
  
  public final void aB(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112815);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(112815);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.AIP != null) {
      this.AIP.setMinDate(localCalendar.getTimeInMillis());
    }
    AppMethodBeat.o(112815);
  }
  
  public final void aC(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112816);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(112816);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.AIP != null) {
      this.AIP.setMaxDate(localCalendar.getTimeInMillis());
    }
    AppMethodBeat.o(112816);
  }
  
  public final void am(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(112814);
    if (this.AIP != null) {
      this.AIP.am(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(112814);
  }
  
  public final String dPo()
  {
    AppMethodBeat.i(139660);
    String str = null;
    if (this.AIP != null) {
      str = this.AIP.aRR();
    }
    AppMethodBeat.o(139660);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(112818);
    if (this.zRa != null) {
      this.zRa.dismiss();
    }
    AppMethodBeat.o(112818);
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    AppMethodBeat.i(112817);
    if (this.zRa != null)
    {
      if (this.AIP != null) {
        this.AIP.aRQ();
      }
      this.zRa.show();
    }
    AppMethodBeat.o(112817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */