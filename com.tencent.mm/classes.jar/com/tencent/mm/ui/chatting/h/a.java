package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.as.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.d.b.b;

public final class a
  extends b
{
  private int hkM = -1;
  private com.tencent.mm.as.a.a.c vyz;
  
  public a(Context paramContext)
  {
    super(paramContext);
    paramContext = new com.tencent.mm.as.a.a.c.a();
    paramContext.eru = R.k.app_brand_app_default_icon_for_tail;
    paramContext.bn(com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 50)).erd = true;
    this.vyz = paramContext.OV();
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      return null;
      paramString = g.by(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public final String VE()
  {
    return "";
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    parama = (a.b)parama;
    a.a locala = (a.a)Ha(paramInt);
    if (bk.bl(locala.desc)) {
      parama.eXP.setVisibility(8);
    }
    for (;;)
    {
      o.ON().a(locala.imagePath, parama.doU, this.vyz);
      return;
      parama.eXP.setVisibility(0);
      parama.eXP.setText(bk.aM(locala.desc, ""));
    }
  }
  
  public final void cFN()
  {
    y.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(true) });
    this.vyD.cFR();
    com.tencent.mm.plugin.appbrand.u.c.a(this.drJ, new a.1(this));
  }
  
  public final c.e cFO()
  {
    return new a.2(this);
  }
  
  public final String cFQ()
  {
    return "";
  }
  
  public final int getType()
  {
    return 33;
  }
  
  public final RecyclerView.v q(ViewGroup paramViewGroup)
  {
    return new a.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.appbrand_history_list_item, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */