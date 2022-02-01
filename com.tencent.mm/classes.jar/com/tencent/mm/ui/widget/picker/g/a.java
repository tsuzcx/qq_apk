package com.tencent.mm.ui.widget.picker.g;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.d.d;
import com.tencent.mm.ui.widget.picker.d.e;

public final class a<T>
  extends com.tencent.mm.ui.widget.picker.a
  implements View.OnClickListener
{
  public b HKu;
  private Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195373);
    this.HKu = new b();
    this.context = paramContext;
    AppMethodBeat.o(195373);
  }
  
  public final boolean aGd()
  {
    return this.HID.hSF;
  }
  
  public final void aGe()
  {
    AppMethodBeat.i(195377);
    if (this.HID.HKo != null)
    {
      int[] arrayOfInt = this.HKu.aGi();
      this.HID.HKo.pH(arrayOfInt[0]);
    }
    AppMethodBeat.o(195377);
  }
  
  public final void b(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(195374);
    this.HID = parama;
    Object localObject = this.context;
    aGc();
    aFZ();
    aGa();
    parama = this.HKu;
    localObject = new WheelView((Context)localObject);
    parama.hSg = this.HID.hSg;
    if (parama.HKv == null) {
      parama.HKv = ((WheelView)localObject);
    }
    parama.HKw = parama.HKv;
    if (this.HID.HKr != null) {
      this.HKu.HKr = this.HID.HKr;
    }
    parama = this.HKu;
    localObject = this.HID.label;
    if (localObject != null) {
      parama.HKw.setLabel((String)localObject);
    }
    parama = this.HKu;
    boolean bool = this.HID.hSf;
    parama.HKw.setCyclic(bool);
    xa(this.HID.lA);
    this.HKu.setDividerColor(this.HID.hRF);
    this.HKu.HJC = this.HID.HJC;
    this.HKu.hSE = this.HID.hSE;
    parama = this.HKu;
    bool = this.HID.hRy;
    parama.HKw.hRy = bool;
    this.HKu.pI(this.HID.hr);
    this.HKu.setDividerColor(this.HID.hRF);
    AppMethodBeat.o(195374);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(195375);
    if (this.HKu != null) {
      this.HKu.pI(this.HID.option);
    }
    AppMethodBeat.o(195375);
  }
  
  public final WheelView fgm()
  {
    AppMethodBeat.i(195378);
    if (this.HKu.HKv == null) {
      this.HKu.HKv = new WheelView(this.context);
    }
    WheelView localWheelView = this.HKu.HKv;
    AppMethodBeat.o(195378);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195376);
    if (((String)paramView.getTag()).equals("submit")) {
      aGe();
    }
    dismiss();
    AppMethodBeat.o(195376);
  }
  
  public final void setOnValueChangedListener(d paramd)
  {
    this.HID.HKr = paramd;
    this.HKu.HKr = this.HID.HKr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.a
 * JD-Core Version:    0.7.0.1
 */