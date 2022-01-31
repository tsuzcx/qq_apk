package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.e.b.b;

public final class d
  extends b
{
  int elr = -1;
  int zPk = 0;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    AppMethodBeat.i(32550);
    parama = (d.b)parama;
    d.a locala = (d.a)PD(paramInt);
    if (bo.isNullOrNil(locala.desc)) {
      parama.gpM.setVisibility(8);
    }
    for (;;)
    {
      parama.ivs.setImageResource(locala.iconRes);
      AppMethodBeat.o(32550);
      return;
      parama.gpM.setVisibility(0);
      parama.gpM.setText(bo.bf(locala.desc, ""));
    }
  }
  
  public final String apc()
  {
    AppMethodBeat.i(32546);
    String str = this.mContext.getString(2131296521);
    AppMethodBeat.o(32546);
    return str;
  }
  
  public final void dJQ()
  {
    AppMethodBeat.i(32545);
    ab.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.TRUE });
    this.zPc.dJU();
    g.RM();
    g.RO().ac(new d.1(this));
    AppMethodBeat.o(32545);
  }
  
  public final c.e dJR()
  {
    AppMethodBeat.i(32548);
    d.2 local2 = new d.2(this);
    AppMethodBeat.o(32548);
    return local2;
  }
  
  public final String dJT()
  {
    AppMethodBeat.i(32547);
    String str = this.mContext.getString(2131296521);
    AppMethodBeat.o(32547);
    return str;
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final RecyclerView.v v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(32549);
    paramViewGroup = new d.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969580, paramViewGroup, false));
    AppMethodBeat.o(32549);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.d
 * JD-Core Version:    0.7.0.1
 */