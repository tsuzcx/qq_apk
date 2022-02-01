package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class i
{
  private ChatFooterCustom aegT;
  private FrameLayout aegU;
  private LinearLayout xYI;
  
  public i(ChatFooterCustom paramChatFooterCustom)
  {
    this.aegT = paramChatFooterCustom;
  }
  
  public final void jmr()
  {
    AppMethodBeat.i(253899);
    Log.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.aegT.findViewById(R.h.fyg).setVisibility(8);
    this.aegT.findViewById(R.h.fya).setVisibility(8);
    this.xYI = ((LinearLayout)this.aegT.findViewById(R.h.fyb));
    this.xYI.setWeightSum(1.0F);
    this.aegU = ((FrameLayout)this.xYI.getChildAt(0));
    this.aegU.setVisibility(0);
    this.aegU.setOnClickListener(new i.1(this));
    this.aegU.setBackgroundColor(this.aegU.getContext().getResources().getColor(R.e.BW_95));
    ((TextView)this.aegU.findViewById(R.h.fyd)).setText(R.l.dismiss_chatroom_cannot_send_tip);
    ((TextView)this.aegU.findViewById(R.h.fyd)).setTextColor(this.aegU.getContext().getResources().getColor(R.e.FG_1));
    ((TextView)this.aegU.findViewById(R.h.fyd)).setTextSize(0, this.aegU.getContext().getResources().getDimension(R.f.SmallTextSize));
    Context localContext = this.aegU.getContext();
    WeImageView localWeImageView = (WeImageView)this.aegU.findViewById(R.h.fyc);
    if (localWeImageView != null)
    {
      localWeImageView.setVisibility(0);
      localWeImageView.setImageDrawable(bb.m(localContext, R.k.icons_outlined_error, localContext.getResources().getColor(R.e.FG_1)));
      localWeImageView.setIconColor(localContext.getResources().getColor(R.e.FG_1));
      ViewGroup.LayoutParams localLayoutParams = localWeImageView.getLayoutParams();
      localLayoutParams.height = ((int)localContext.getResources().getDimension(R.f.Edge_2_5_A));
      localLayoutParams.width = ((int)localContext.getResources().getDimension(R.f.Edge_2_5_A));
      localWeImageView.setLayoutParams(localLayoutParams);
    }
    int i = 1;
    while (i < 6)
    {
      this.xYI.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(253899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i
 * JD-Core Version:    0.7.0.1
 */