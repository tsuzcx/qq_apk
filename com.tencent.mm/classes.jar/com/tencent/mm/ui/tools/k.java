package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.a;
import com.tencent.mm.ui.base.n.b;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.y;

public final class k
  extends o
{
  private LayoutInflater Lu;
  private boolean oVw = true;
  public n.c phH;
  public n.d phI;
  private l phJ;
  private n.a wdr;
  private n.b wds;
  private k.a wdw;
  
  public k(Context paramContext)
  {
    super(paramContext);
    this.Lu = y.gt(paramContext);
    this.phJ = new l(paramContext);
  }
  
  public final boolean fy()
  {
    if (this.phH != null) {
      this.phH.a(this.phJ);
    }
    if ((this.phJ.VF != null) && (this.phJ.VF.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.oVw = bool;
      return super.fy();
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.oVw) && (paramInt == 0)) {
      return;
    }
    int i = paramInt;
    if (this.oVw) {
      i = paramInt - 1;
    }
    if (this.phI != null) {
      this.phI.onMMMenuItemSelected(this.phJ.getItem(i), i);
    }
    dismiss();
  }
  
  protected final BaseAdapter xX()
  {
    if (this.wdw == null) {
      this.wdw = new k.a(this, (byte)0);
    }
    return this.wdw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.k
 * JD-Core Version:    0.7.0.1
 */