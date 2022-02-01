package com.tencent.mm.plugin.talkroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.i;

final class TalkRoomUI$12
  implements View.OnClickListener
{
  TalkRoomUI$12(TalkRoomUI paramTalkRoomUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29600);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = this.Mlw;
    bh.beI();
    if (Util.nullAs((Integer)c.aHp().b(144641, null), 0) > 0) {}
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        this.Mlw.onBackPressed();
      }
      a.a(this, "com/tencent/mm/plugin/talkroom/ui/TalkRoomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(29600);
      return;
      localObject = new i(paramView, R.m.mmdialog);
      LinearLayout localLinearLayout = (LinearLayout)ad.kS(MMApplicationContext.getContext()).inflate(R.i.elx, null);
      localLinearLayout.setMinimumWidth(10000);
      Button localButton = (Button)localLinearLayout.findViewById(R.h.i_know_btn);
      ((i)localObject).setCanceledOnTouchOutside(true);
      ((i)localObject).setOnDismissListener(new TalkRoomUI.17(paramView));
      ((i)localObject).setCancelable(false);
      localButton.setOnClickListener(new TalkRoomUI.2(paramView, (i)localObject));
      ((i)localObject).setContentView(localLinearLayout);
      ((i)localObject).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.TalkRoomUI.12
 * JD-Core Version:    0.7.0.1
 */