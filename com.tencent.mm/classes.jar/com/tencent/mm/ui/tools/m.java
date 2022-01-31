package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.w;

public final class m
  extends r
{
  private n.a AvY;
  private n.b AvZ;
  private m.a Awd;
  private LayoutInflater mInflater;
  private boolean rNQ;
  public n.c sao;
  public n.d sap;
  private l saq;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107719);
    this.rNQ = true;
    this.mInflater = w.hM(paramContext);
    this.saq = new l(paramContext);
    AppMethodBeat.o(107719);
  }
  
  protected final BaseAdapter Kp()
  {
    AppMethodBeat.i(107722);
    if (this.Awd == null) {
      this.Awd = new m.a(this, (byte)0);
    }
    m.a locala = this.Awd;
    AppMethodBeat.o(107722);
    return locala;
  }
  
  public final boolean gr()
  {
    AppMethodBeat.i(107720);
    if (this.sao != null) {
      this.sao.onCreateMMMenu(this.saq);
    }
    if ((this.saq.Wu != null) && (this.saq.Wu.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.rNQ = bool;
      bool = super.gr();
      AppMethodBeat.o(107720);
      return bool;
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(107721);
    if ((this.rNQ) && (paramInt == 0))
    {
      AppMethodBeat.o(107721);
      return;
    }
    int i = paramInt;
    if (this.rNQ) {
      i = paramInt - 1;
    }
    if (this.sap != null) {
      this.sap.onMMMenuItemSelected(this.saq.getItem(i), i);
    }
    dismiss();
    AppMethodBeat.o(107721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */