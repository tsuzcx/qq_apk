package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;
import java.util.List;

public final class az
  implements AdapterView.OnItemClickListener
{
  private LayoutInflater Lu;
  private Context mContext;
  k phG;
  n.c phH;
  n.d phI;
  private l phJ;
  private az.a phK;
  private HashMap<Integer, CharSequence> phL = new HashMap();
  private HashMap<Integer, Integer> phM = new HashMap();
  
  public az(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(paramContext);
    this.phG = new k(paramContext);
    this.phJ = new l(paramContext);
  }
  
  private void dismiss()
  {
    if (this.phG.isShowing()) {
      this.phG.dismiss();
    }
  }
  
  public final Dialog bJQ()
  {
    if (this.phH != null)
    {
      this.phJ.clear();
      this.phJ = new l(this.mContext);
      this.phH.a(this.phJ);
    }
    if (this.phJ.cAR())
    {
      y.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
      return null;
    }
    if (this.phK == null) {
      this.phK = new az.a(this, (byte)0);
    }
    this.phG.iqN = this.phK;
    this.phG.slt = this;
    this.phG.setTitle(this.phJ.VF);
    this.phG.show();
    return this.phG;
  }
  
  public final void c(int paramInt, CharSequence paramCharSequence)
  {
    this.phL.put(Integer.valueOf(paramInt), paramCharSequence);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (m)this.phJ.uWD.get(paramInt);
    if (paramAdapterView.performClick())
    {
      y.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
      dismiss();
      return;
    }
    if (this.phI != null) {
      this.phI.onMMMenuItemSelected(paramAdapterView, paramInt);
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.az
 * JD-Core Version:    0.7.0.1
 */