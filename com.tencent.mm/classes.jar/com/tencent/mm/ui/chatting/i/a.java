package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;

public final class a
  extends b
{
  private int elr;
  com.tencent.mm.at.a.a.c zOV;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(32516);
    this.elr = -1;
    paramContext = new com.tencent.mm.at.a.a.c.a();
    paramContext.eNY = 2131230843;
    paramContext.cx(com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 50)).eNK = true;
    this.zOV = paramContext.ahY();
    AppMethodBeat.o(32516);
  }
  
  private static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    AppMethodBeat.i(32523);
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(32523);
      return null;
      paramString = com.tencent.mm.pluginsdk.model.app.g.ca(paramString, true);
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.field_packageName;
      }
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      AppMethodBeat.o(32523);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", paramContext, "", new Object[0]);
      AppMethodBeat.o(32523);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.ui.chatting.a.c.a parama, int paramInt)
  {
    AppMethodBeat.i(32522);
    parama = (a.b)parama;
    a.a locala = (a.a)PD(paramInt);
    if (bo.isNullOrNil(locala.desc)) {
      parama.gpM.setVisibility(8);
    }
    do
    {
      o.ahG().a(locala.imagePath, parama.ivs, this.zOV);
      AppMethodBeat.o(32522);
      return;
      parama.gpM.setVisibility(0);
      parama.gpM.setText(parama.gpL.getText());
      parama.gpL.setText(locala.desc);
      a.b.c(parama.gpM, this.zPd.zDO);
    } while (bo.isNullOrNil(locala.iXo));
    com.tencent.mm.modelappbrand.a.b.acD().a(new a.3(this, parama, locala), locala.iXo, null, ((i)com.tencent.mm.kernel.g.E(i.class)).cu(45, 45));
    AppMethodBeat.o(32522);
  }
  
  public final String apc()
  {
    AppMethodBeat.i(32518);
    String str = this.mContext.getString(2131302968);
    AppMethodBeat.o(32518);
    return str;
  }
  
  public final void dJQ()
  {
    AppMethodBeat.i(32517);
    ab.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.zPc.dJU();
    com.tencent.mm.plugin.appbrand.s.c.reset();
    com.tencent.mm.plugin.appbrand.s.c.a(this.ejr, new a.1(this));
    AppMethodBeat.o(32517);
  }
  
  public final c.e dJR()
  {
    AppMethodBeat.i(32520);
    a.2 local2 = new a.2(this);
    AppMethodBeat.o(32520);
    return local2;
  }
  
  public final String dJT()
  {
    AppMethodBeat.i(32519);
    String str = this.mContext.getString(2131302968);
    AppMethodBeat.o(32519);
    return str;
  }
  
  public final int getType()
  {
    return 33;
  }
  
  public final RecyclerView.v v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(32521);
    paramViewGroup = new a.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968769, paramViewGroup, false));
    AppMethodBeat.o(32521);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a
 * JD-Core Version:    0.7.0.1
 */