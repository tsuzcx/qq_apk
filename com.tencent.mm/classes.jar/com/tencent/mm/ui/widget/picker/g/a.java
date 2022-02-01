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
  public b JkR;
  private Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199844);
    this.JkR = new b();
    this.context = paramContext;
    AppMethodBeat.o(199844);
  }
  
  public final boolean aMQ()
  {
    return this.Jja.isK;
  }
  
  public final void aMR()
  {
    AppMethodBeat.i(199848);
    if (this.Jja.JkL != null)
    {
      int[] arrayOfInt = this.JkR.aMV();
      this.Jja.JkL.qu(arrayOfInt[0]);
    }
    AppMethodBeat.o(199848);
  }
  
  public final void b(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(199845);
    this.Jja = parama;
    Object localObject = this.context;
    aMP();
    aMM();
    aMN();
    parama = this.JkR;
    localObject = new WheelView((Context)localObject);
    parama.isl = this.Jja.isl;
    if (parama.JkS == null) {
      parama.JkS = ((WheelView)localObject);
    }
    parama.JkT = parama.JkS;
    if (this.Jja.JkO != null) {
      this.JkR.JkO = this.Jja.JkO;
    }
    parama = this.JkR;
    localObject = this.Jja.label;
    if (localObject != null) {
      parama.JkT.setLabel((String)localObject);
    }
    parama = this.JkR;
    boolean bool = this.Jja.isk;
    parama.JkT.setCyclic(bool);
    yj(this.Jja.mz);
    this.JkR.setDividerColor(this.Jja.irK);
    this.JkR.JjZ = this.Jja.JjZ;
    this.JkR.isJ = this.Jja.isJ;
    parama = this.JkR;
    bool = this.Jja.irD;
    parama.JkT.irD = bool;
    this.JkR.qv(this.Jja.it);
    this.JkR.setDividerColor(this.Jja.irK);
    AppMethodBeat.o(199845);
  }
  
  public final void fwl()
  {
    AppMethodBeat.i(199846);
    if (this.JkR != null) {
      this.JkR.qv(this.Jja.option);
    }
    AppMethodBeat.o(199846);
  }
  
  public final WheelView fwm()
  {
    AppMethodBeat.i(199849);
    if (this.JkR.JkS == null) {
      this.JkR.JkS = new WheelView(this.context);
    }
    WheelView localWheelView = this.JkR.JkS;
    AppMethodBeat.o(199849);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199847);
    if (((String)paramView.getTag()).equals("submit")) {
      aMR();
    }
    dismiss();
    AppMethodBeat.o(199847);
  }
  
  public final void setOnValueChangedListener(d paramd)
  {
    this.Jja.JkO = paramd;
    this.JkR.JkO = this.Jja.JkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.a
 * JD-Core Version:    0.7.0.1
 */