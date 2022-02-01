package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Log;

public final class x
{
  private ChatFooterCustom Pgh;
  private FrameLayout Pgi;
  private View.OnClickListener ko;
  private LinearLayout rmL;
  
  public x(ChatFooterCustom paramChatFooterCustom)
  {
    AppMethodBeat.i(34688);
    this.ko = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34687);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        com.tencent.mm.plugin.sport.a.c.pl(1);
        ab.IU("gh_43f2581f6fd6");
        localObject = new Intent();
        ((Intent)localObject).putExtra("key_is_latest", true);
        ((Intent)localObject).putExtra("rank_id", "#");
        ((Intent)localObject).putExtra("key_only_show_latest_rank", true);
        ((Intent)localObject).putExtra("app_username", aa.getDisplayName("gh_43f2581f6fd6"));
        ((Intent)localObject).putExtra("device_type", 1);
        com.tencent.mm.br.c.b(paramAnonymousView.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", (Intent)localObject);
        a.a(this, "com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34687);
      }
    };
    this.Pgh = paramChatFooterCustom;
    AppMethodBeat.o(34688);
  }
  
  public final void gKK()
  {
    AppMethodBeat.i(34689);
    Log.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.Pgh.findViewById(2131298443).setVisibility(8);
    this.Pgh.findViewById(2131298437).setVisibility(8);
    this.rmL = ((LinearLayout)this.Pgh.findViewById(2131298438));
    this.rmL.setWeightSum(1.0F);
    this.Pgi = ((FrameLayout)this.rmL.getChildAt(0));
    this.Pgi.setVisibility(0);
    this.Pgi.setOnClickListener(this.ko);
    ((TextView)this.Pgi.findViewById(2131298440)).setText(2131758911);
    this.Pgi.findViewById(2131298439).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.rmL.getChildAt(i).setVisibility(8);
      i += 1;
    }
    AppMethodBeat.o(34689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.x
 * JD-Core Version:    0.7.0.1
 */