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
  public b LyP;
  private Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200567);
    this.LyP = new b();
    this.context = paramContext;
    AppMethodBeat.o(200567);
  }
  
  public final boolean aQA()
  {
    return this.LwV.iOG;
  }
  
  public final void aQB()
  {
    AppMethodBeat.i(200571);
    if (this.LwV.LyJ != null)
    {
      int[] arrayOfInt = this.LyP.aQF();
      this.LwV.LyJ.qX(arrayOfInt[0]);
    }
    AppMethodBeat.o(200571);
  }
  
  public final void b(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(200568);
    this.LwV = parama;
    Object localObject = this.context;
    aQz();
    aQw();
    aQx();
    parama = this.LyP;
    localObject = new WheelView((Context)localObject);
    parama.iOh = this.LwV.iOh;
    if (parama.LyQ == null) {
      parama.LyQ = ((WheelView)localObject);
    }
    parama.LyR = parama.LyQ;
    if (this.LwV.LyM != null) {
      this.LyP.LyM = this.LwV.LyM;
    }
    parama = this.LyP;
    localObject = this.LwV.label;
    if (localObject != null) {
      parama.LyR.setLabel((String)localObject);
    }
    parama = this.LyP;
    boolean bool = this.LwV.iOg;
    parama.LyR.setCyclic(bool);
    zj(this.LwV.ov);
    this.LyP.setDividerColor(this.LwV.iNG);
    this.LyP.LxX = this.LwV.LxX;
    this.LyP.iOF = this.LwV.iOF;
    parama = this.LyP;
    bool = this.LwV.iNz;
    parama.LyR.iNz = bool;
    this.LyP.qY(this.LwV.kl);
    this.LyP.setDividerColor(this.LwV.iNG);
    AppMethodBeat.o(200568);
  }
  
  public final void fRu()
  {
    AppMethodBeat.i(200569);
    if (this.LyP != null) {
      this.LyP.qY(this.LwV.option);
    }
    AppMethodBeat.o(200569);
  }
  
  public final WheelView fRv()
  {
    AppMethodBeat.i(200572);
    if (this.LyP.LyQ == null) {
      this.LyP.LyQ = new WheelView(this.context);
    }
    WheelView localWheelView = this.LyP.LyQ;
    AppMethodBeat.o(200572);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(200570);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (((String)paramView.getTag()).equals("submit")) {
      aQB();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(200570);
  }
  
  public final void setOnValueChangedListener(d paramd)
  {
    this.LwV.LyM = paramd;
    this.LyP.LyM = this.LwV.LyM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.a
 * JD-Core Version:    0.7.0.1
 */