package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

final class ag$a
  extends com.tencent.mm.plugin.sns.model.h<String, Integer, Boolean>
{
  private ProgressDialog dnm = null;
  private ax oRa;
  private List<com.tencent.mm.plugin.sns.data.h> oSl;
  
  public ag$a(ax paramax, List<com.tencent.mm.plugin.sns.data.h> paramList)
  {
    this.oRa = paramList;
    Object localObject;
    this.oSl = localObject;
    paramList = paramax.bER;
    paramax.bER.getString(i.j.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(paramList, paramax.bER.getString(i.j.app_loading_data), false, new ag.a.1(this, paramax));
  }
  
  public final ah byB()
  {
    return af.bDs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.a
 * JD-Core Version:    0.7.0.1
 */