package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
{
  private ChatFooterCustom WzA;
  private FrameLayout WzB;
  private View.OnClickListener bwV;
  private LinearLayout uPX;
  
  public x(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34688);
    this.bwV = new x.1(this);
    this.WzA = paramChatFooterCustom;
    AppMethodBeat.o(34688);
  }
  
  public final void hJJ()
  {
    AppMethodBeat.i(34689);
    Log.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.WzA.findViewById(R.h.dxC).setVisibility(8);
    this.WzA.findViewById(R.h.dxw).setVisibility(8);
    this.uPX = ((LinearLayout)this.WzA.findViewById(R.h.dxx));
    this.uPX.setWeightSum(1.0F);
    this.WzB = ((FrameLayout)this.uPX.getChildAt(0));
    this.WzB.setVisibility(0);
    this.WzB.setOnClickListener(this.bwV);
    ((TextView)this.WzB.findViewById(R.h.dxz)).setText(R.l.eEg);
    this.WzB.findViewById(R.h.dxy).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.uPX.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */