package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sport.a.d;

final class z$1
  implements View.OnClickListener
{
  z$1(z paramz) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34687);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    d.rG(1);
    ab.IT("gh_43f2581f6fd6");
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_is_latest", true);
    ((Intent)localObject).putExtra("rank_id", "#");
    ((Intent)localObject).putExtra("key_only_show_latest_rank", true);
    ((Intent)localObject).putExtra("app_username", aa.getDisplayName("gh_43f2581f6fd6"));
    ((Intent)localObject).putExtra("device_type", 1);
    c.b(paramView.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/ui/chatting/ChattingSportFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.z.1
 * JD-Core Version:    0.7.0.1
 */