package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.platformtools.ae;

public final class x
{
  private ChatFooterCustom JUU;
  private FrameLayout JUV;
  private View.OnClickListener km;
  private LinearLayout pVM;
  
  public x(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34688);
    this.km = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34687);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        c.md(1);
        com.tencent.mm.model.x.Ap("gh_43f2581f6fd6");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_is_latest", true);
        ((Intent)localObject).putExtra("rank_id", "#");
        ((Intent)localObject).putExtra("key_only_show_latest_rank", true);
        ((Intent)localObject).putExtra("app_username", w.zP("gh_43f2581f6fd6"));
        ((Intent)localObject).putExtra("device_type", 1);
        d.b(paramAnonymousView.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34687);
      }
    };
    this.JUU = paramChatFooterCustom;
    AppMethodBeat.o(34688);
  }
  
  public final void fCL()
  {
    AppMethodBeat.i(34689);
    ae.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.JUU.findViewById(2131298098).setVisibility(8);
    this.JUU.findViewById(2131298092).setVisibility(8);
    this.pVM = ((LinearLayout)this.JUU.findViewById(2131298093));
    this.pVM.setWeightSum(1.0F);
    this.JUV = ((FrameLayout)this.pVM.getChildAt(0));
    this.JUV.setVisibility(0);
    this.JUV.setOnClickListener(this.km);
    ((TextView)this.JUV.findViewById(2131298095)).setText(2131758608);
    this.JUV.findViewById(2131298094).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.pVM.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */