package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.d.b.b;

public final class d
  extends b
{
  int hkM = -1;
  int vyN = 0;
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  public final String VE()
  {
    return this.mContext.getString(R.l.all_history_file);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    parama = (b)parama;
    d.a locala = (d.a)Ha(paramInt);
    if (bk.bl(locala.desc)) {
      parama.eXP.setVisibility(8);
    }
    for (;;)
    {
      parama.gSx.setImageResource(locala.iconRes);
      return;
      parama.eXP.setVisibility(0);
      parama.eXP.setText(bk.aM(locala.desc, ""));
    }
  }
  
  public final void cFN()
  {
    y.i("MicroMsg.FileHistoryListPresenter", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(true) });
    this.vyD.cFR();
    g.DQ();
    g.DS().O(new d.1(this));
  }
  
  public final c.e cFO()
  {
    return new d.2(this);
  }
  
  public final String cFQ()
  {
    return this.mContext.getString(R.l.all_history_file);
  }
  
  public final int getType()
  {
    return 6;
  }
  
  public final RecyclerView.v q(ViewGroup paramViewGroup)
  {
    return new b(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.file_list_item, paramViewGroup, false));
  }
  
  final class b
    extends c.a
  {
    TextView eXP;
    ImageView gSx;
    
    public b(View paramView)
    {
      super();
      this.gSx = ((ImageView)paramView.findViewById(R.h.fav_icon));
      this.eXO.setSingleLine(false);
      this.eXO.setMaxLines(2);
      this.eXP = ((TextView)paramView.findViewById(R.h.fav_detail));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d
 * JD-Core Version:    0.7.0.1
 */