package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.chatting.a.c.a;
import com.tencent.mm.ui.chatting.a.c.e;
import com.tencent.mm.ui.chatting.d.b.b;

public final class g
  extends b
{
  int hkM = -1;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static boolean mv(int paramInt)
  {
    return (bk.ZR("1001") == paramInt) || (bk.ZR("1002") == paramInt) || (419430449 == paramInt);
  }
  
  public final String VE()
  {
    return this.mContext.getString(R.l.search_chatroom_pay);
  }
  
  public final void a(c.a parama, int paramInt)
  {
    parama = (g.b)parama;
    g.a locala = (g.a)Ha(paramInt);
    if (bk.bl(locala.desc)) {
      parama.eXP.setVisibility(8);
    }
    for (;;)
    {
      paramInt = a.fromDPToPix(this.mContext, 6);
      parama.gSx.setPadding(paramInt, paramInt, paramInt, paramInt);
      parama.gSx.setImageResource(locala.iconRes);
      parama.gSx.setBackgroundColor(locala.vzg);
      return;
      parama.eXP.setVisibility(0);
      parama.eXP.setText(bk.aM(locala.desc, ""));
    }
  }
  
  public final void cFN()
  {
    this.vyD.cFR();
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new g.1(this));
  }
  
  public final c.e cFO()
  {
    return new g.2(this);
  }
  
  public final String cFQ()
  {
    return this.mContext.getString(R.l.search_chatroom_pay);
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final RecyclerView.v q(ViewGroup paramViewGroup)
  {
    return new g.b(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.file_list_item, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.g
 * JD-Core Version:    0.7.0.1
 */