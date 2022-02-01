package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.platformtools.ac;

public final class w
{
  private ChatFooterCustom HMn;
  private FrameLayout HMo;
  private View.OnClickListener iu;
  private LinearLayout plH;
  
  public w(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34688);
    this.iu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34687);
        c.lA(1);
        com.tencent.mm.model.w.wI("gh_43f2581f6fd6");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_is_latest", true);
        localIntent.putExtra("rank_id", "#");
        localIntent.putExtra("key_only_show_latest_rank", true);
        localIntent.putExtra("app_username", v.wk("gh_43f2581f6fd6"));
        localIntent.putExtra("device_type", 1);
        d.b(paramAnonymousView.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        AppMethodBeat.o(34687);
      }
    };
    this.HMn = paramChatFooterCustom;
    AppMethodBeat.o(34688);
  }
  
  public final void fiu()
  {
    AppMethodBeat.i(34689);
    ac.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.HMn.findViewById(2131298098).setVisibility(8);
    this.HMn.findViewById(2131298092).setVisibility(8);
    this.plH = ((LinearLayout)this.HMn.findViewById(2131298093));
    this.plH.setWeightSum(1.0F);
    this.HMo = ((FrameLayout)this.plH.getChildAt(0));
    this.HMo.setVisibility(0);
    this.HMo.setOnClickListener(this.iu);
    ((TextView)this.HMo.findViewById(2131298095)).setText(2131758608);
    this.HMo.findViewById(2131298094).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.plH.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */