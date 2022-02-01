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
  public b Lco;
  private Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(192794);
    this.Lco = new b();
    this.context = paramContext;
    AppMethodBeat.o(192794);
  }
  
  public final boolean aQb()
  {
    return this.Lax.iLN;
  }
  
  public final void aQc()
  {
    AppMethodBeat.i(192798);
    if (this.Lax.Lci != null)
    {
      int[] arrayOfInt = this.Lco.aQg();
      this.Lax.Lci.qU(arrayOfInt[0]);
    }
    AppMethodBeat.o(192798);
  }
  
  public final void b(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(192795);
    this.Lax = parama;
    Object localObject = this.context;
    aQa();
    aPX();
    aPY();
    parama = this.Lco;
    localObject = new WheelView((Context)localObject);
    parama.iLo = this.Lax.iLo;
    if (parama.Lcp == null) {
      parama.Lcp = ((WheelView)localObject);
    }
    parama.Lcq = parama.Lcp;
    if (this.Lax.Lcl != null) {
      this.Lco.Lcl = this.Lax.Lcl;
    }
    parama = this.Lco;
    localObject = this.Lax.label;
    if (localObject != null) {
      parama.Lcq.setLabel((String)localObject);
    }
    parama = this.Lco;
    boolean bool = this.Lax.iLn;
    parama.Lcq.setCyclic(bool);
    yV(this.Lax.ov);
    this.Lco.setDividerColor(this.Lax.iKN);
    this.Lco.Lbw = this.Lax.Lbw;
    this.Lco.iLM = this.Lax.iLM;
    parama = this.Lco;
    bool = this.Lax.iKG;
    parama.Lcq.iKG = bool;
    this.Lco.qV(this.Lax.kl);
    this.Lco.setDividerColor(this.Lax.iKN);
    AppMethodBeat.o(192795);
  }
  
  public final void fMZ()
  {
    AppMethodBeat.i(192796);
    if (this.Lco != null) {
      this.Lco.qV(this.Lax.option);
    }
    AppMethodBeat.o(192796);
  }
  
  public final WheelView fNa()
  {
    AppMethodBeat.i(192799);
    if (this.Lco.Lcp == null) {
      this.Lco.Lcp = new WheelView(this.context);
    }
    WheelView localWheelView = this.Lco.Lcp;
    AppMethodBeat.o(192799);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(192797);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (((String)paramView.getTag()).equals("submit")) {
      aQc();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(192797);
  }
  
  public final void setOnValueChangedListener(d paramd)
  {
    this.Lax.Lcl = paramd;
    this.Lco.Lcl = this.Lax.Lcl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.a
 * JD-Core Version:    0.7.0.1
 */