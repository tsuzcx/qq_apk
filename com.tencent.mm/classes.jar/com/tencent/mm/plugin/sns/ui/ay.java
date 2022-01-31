package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;
import java.util.List;

public final class ay
  implements AdapterView.OnItemClickListener
{
  private Context mContext;
  private LayoutInflater mInflater;
  k san;
  n.c sao;
  n.d sap;
  private l saq;
  private ay.a sar;
  private HashMap<Integer, CharSequence> sas;
  private HashMap<Integer, Integer> sat;
  
  public ay(Context paramContext)
  {
    AppMethodBeat.i(39617);
    this.sas = new HashMap();
    this.sat = new HashMap();
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.san = new k(paramContext);
    this.saq = new l(paramContext);
    AppMethodBeat.o(39617);
  }
  
  private void dismiss()
  {
    AppMethodBeat.i(39620);
    if (this.san.isShowing()) {
      this.san.dismiss();
    }
    AppMethodBeat.o(39620);
  }
  
  public final void c(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(39618);
    this.sas.put(Integer.valueOf(paramInt), paramCharSequence);
    AppMethodBeat.o(39618);
  }
  
  public final Dialog cwt()
  {
    AppMethodBeat.i(39621);
    if (this.sao != null)
    {
      this.saq.clear();
      this.saq = new l(this.mContext);
      this.sao.onCreateMMMenu(this.saq);
    }
    if (this.saq.dEc())
    {
      ab.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
      AppMethodBeat.o(39621);
      return null;
    }
    if (this.sar == null) {
      this.sar = new ay.a(this, (byte)0);
    }
    this.san.krV = this.sar;
    this.san.wdV = this;
    this.san.setTitle(this.saq.Wu);
    this.san.show();
    k localk = this.san;
    AppMethodBeat.o(39621);
    return localk;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(39619);
    paramAdapterView = (m)this.saq.zkW.get(paramInt);
    if (paramAdapterView.performClick())
    {
      ab.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
      dismiss();
      AppMethodBeat.o(39619);
      return;
    }
    if (this.sap != null) {
      this.sap.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
    AppMethodBeat.o(39619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay
 * JD-Core Version:    0.7.0.1
 */