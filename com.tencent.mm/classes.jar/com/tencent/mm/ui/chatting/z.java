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

public final class z
{
  private ChatFooterCustom aegT;
  private FrameLayout aegU;
  private View.OnClickListener dpY;
  private LinearLayout xYI;
  
  public z(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34688);
    this.dpY = new z.1(this);
    this.aegT = paramChatFooterCustom;
    AppMethodBeat.o(34688);
  }
  
  public final void jmr()
  {
    AppMethodBeat.i(34689);
    Log.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.aegT.findViewById(R.h.fyg).setVisibility(8);
    this.aegT.findViewById(R.h.fya).setVisibility(8);
    this.xYI = ((LinearLayout)this.aegT.findViewById(R.h.fyb));
    this.xYI.setWeightSum(1.0F);
    this.aegU = ((FrameLayout)this.xYI.getChildAt(0));
    this.aegU.setVisibility(0);
    this.aegU.setOnClickListener(this.dpY);
    ((TextView)this.aegU.findViewById(R.h.fyd)).setText(R.l.gGW);
    this.aegU.findViewById(R.h.fyc).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.xYI.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z
 * JD-Core Version:    0.7.0.1
 */