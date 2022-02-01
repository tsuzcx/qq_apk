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
  public b QUF;
  private Context context;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(198525);
    this.QUF = new b();
    this.context = paramContext;
    AppMethodBeat.o(198525);
  }
  
  public final void b(com.tencent.mm.ui.widget.picker.c.a parama)
  {
    AppMethodBeat.i(198526);
    this.QSH = parama;
    Object localObject = this.context;
    ble();
    blb();
    blc();
    parama = this.QUF;
    localObject = new WheelView((Context)localObject);
    parama.jKW = this.QSH.jKW;
    if (parama.QUG == null) {
      parama.QUG = ((WheelView)localObject);
    }
    parama.QUH = parama.QUG;
    if (this.QSH.QUC != null) {
      this.QUF.QUC = this.QSH.QUC;
    }
    parama = this.QUF;
    localObject = this.QSH.label;
    if (localObject != null) {
      parama.QUH.setLabel((String)localObject);
    }
    parama = this.QUF;
    boolean bool = this.QSH.jKV;
    parama.QUH.setCyclic(bool);
    Ds(this.QSH.ox);
    this.QUF.setDividerColor(this.QSH.jKu);
    this.QUF.QTM = this.QSH.QTM;
    this.QUF.jLu = this.QSH.jLu;
    parama = this.QUF;
    bool = this.QSH.jKn;
    parama.QUH.jKn = bool;
    this.QUF.uQ(this.QSH.kn);
    this.QUF.setDividerColor(this.QSH.jKu);
    AppMethodBeat.o(198526);
  }
  
  public final boolean blf()
  {
    return this.QSH.jLv;
  }
  
  public final void blg()
  {
    AppMethodBeat.i(198529);
    if (this.QSH.QUz != null)
    {
      int[] arrayOfInt = this.QUF.blk();
      this.QSH.QUz.uP(arrayOfInt[0]);
    }
    AppMethodBeat.o(198529);
  }
  
  public final void hcw()
  {
    AppMethodBeat.i(198527);
    if (this.QUF != null) {
      this.QUF.uQ(this.QSH.option);
    }
    AppMethodBeat.o(198527);
  }
  
  public final WheelView hcx()
  {
    AppMethodBeat.i(198530);
    if (this.QUF.QUG == null) {
      this.QUF.QUG = new WheelView(this.context);
    }
    WheelView localWheelView = this.QUF.QUG;
    AppMethodBeat.o(198530);
    return localWheelView;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(198528);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (((String)paramView.getTag()).equals("submit")) {
      blg();
    }
    dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/view/OptionsPickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(198528);
  }
  
  public final void setOnValueChangedListener(d paramd)
  {
    this.QSH.QUC = paramd;
    this.QUF.QUC = this.QSH.QUC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.g.a
 * JD-Core Version:    0.7.0.1
 */