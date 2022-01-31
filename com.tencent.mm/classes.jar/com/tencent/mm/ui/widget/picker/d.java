package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;

public final class d
{
  public ListView AJb;
  public View AJc;
  public ArrayList<Integer> AJd;
  public d.a AJe;
  public d.b AJf;
  private BottomSheetBehavior gE;
  public Button gtF;
  public View iDS;
  public Button jIG;
  public Context mContext;
  public n.c sao;
  public n.d sap;
  public l saq;
  public TextView smo;
  public c zRa;
  public int zRb;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(112849);
    this.mContext = paramContext;
    this.saq = new l(this.mContext);
    this.zRa = new c(this.mContext);
    this.iDS = View.inflate(this.mContext, 2130970318, null);
    this.AJb = ((ListView)this.iDS.findViewById(2131826405));
    this.gtF = ((Button)this.iDS.findViewById(2131823301));
    this.jIG = ((Button)this.iDS.findViewById(2131822887));
    this.AJc = this.iDS.findViewById(2131826404);
    this.smo = ((TextView)this.iDS.findViewById(2131824068));
    this.zRa.setContentView(this.iDS);
    this.zRb = (al.ap(this.mContext, 2131427510) + al.ap(this.mContext, 2131427511));
    this.gE = BottomSheetBehavior.i((View)this.iDS.getParent());
    if (this.gE != null)
    {
      this.gE.t(this.zRb);
      this.gE.go = false;
    }
    this.zRa.setOnDismissListener(new d.1(this));
    AppMethodBeat.o(112849);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(112850);
    if (this.zRa != null) {
      this.zRa.dismiss();
    }
    AppMethodBeat.o(112850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */