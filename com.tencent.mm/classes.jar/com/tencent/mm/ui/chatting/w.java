package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.platformtools.ad;

public final class w
{
  private ChatFooterCustom JAd;
  private FrameLayout JAe;
  private View.OnClickListener km;
  private LinearLayout pPh;
  
  public w(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34688);
    this.km = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34687);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        c.ma(1);
        com.tencent.mm.model.w.zF("gh_43f2581f6fd6");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_is_latest", true);
        ((Intent)localObject).putExtra("rank_id", "#");
        ((Intent)localObject).putExtra("key_only_show_latest_rank", true);
        ((Intent)localObject).putExtra("app_username", v.zf("gh_43f2581f6fd6"));
        ((Intent)localObject).putExtra("device_type", 1);
        d.b(paramAnonymousView.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34687);
      }
    };
    this.JAd = paramChatFooterCustom;
    AppMethodBeat.o(34688);
  }
  
  public final void fyJ()
  {
    AppMethodBeat.i(34689);
    ad.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.JAd.findViewById(2131298098).setVisibility(8);
    this.JAd.findViewById(2131298092).setVisibility(8);
    this.pPh = ((LinearLayout)this.JAd.findViewById(2131298093));
    this.pPh.setWeightSum(1.0F);
    this.JAe = ((FrameLayout)this.pPh.getChildAt(0));
    this.JAe.setVisibility(0);
    this.JAe.setOnClickListener(this.km);
    ((TextView)this.JAe.findViewById(2131298095)).setText(2131758608);
    this.JAe.findViewById(2131298094).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.pPh.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */