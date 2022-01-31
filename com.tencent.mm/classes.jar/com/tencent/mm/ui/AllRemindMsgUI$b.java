package com.tencent.mm.ui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import java.util.LinkedList;

final class AllRemindMsgUI$b
  extends RecyclerView.a
{
  AllRemindMsgUI$b(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(29118);
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970565, paramViewGroup, false);
    paramViewGroup = new AllRemindMsgUI.c(this.yTD, paramViewGroup);
    AppMethodBeat.o(29118);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(29119);
    AllRemindMsgUI.d locald = (AllRemindMsgUI.d)AllRemindMsgUI.d(this.yTD).get(paramInt);
    ((AllRemindMsgUI.c)paramv).aku.setTag(locald);
    ((AllRemindMsgUI.c)paramv).kgG.setText(j.b(this.yTD.getContext(), locald.nickname, ((AllRemindMsgUI.c)paramv).kgG.getTextSize()));
    ((AllRemindMsgUI.c)paramv).titleTv.setText(j.b(this.yTD.getContext(), locald.title, ((AllRemindMsgUI.c)paramv).titleTv.getTextSize()));
    long l = System.currentTimeMillis();
    if (locald.timestamp - l < 60000L) {
      ((AllRemindMsgUI.c)paramv).yTG.setText(this.yTD.getContext().getString(2131300047, new Object[] { Integer.valueOf(1) }));
    }
    while (locald.subType == 2)
    {
      ((AllRemindMsgUI.c)paramv).gxs.setImageDrawable(this.yTD.getContext().getResources().getDrawable(2130837707));
      AppMethodBeat.o(29119);
      return;
      if (locald.timestamp - l < 3600000L) {
        ((AllRemindMsgUI.c)paramv).yTG.setText(this.yTD.getContext().getString(2131300047, new Object[] { Long.valueOf((locald.timestamp - l) / 60000L) }));
      } else if (locald.timestamp - l < 10800000L) {
        ((AllRemindMsgUI.c)paramv).yTG.setText(this.yTD.getContext().getString(2131300046, new Object[] { Long.valueOf((locald.timestamp - l) / 3600000L), Long.valueOf((locald.timestamp - l - (locald.timestamp - l) / 3600000L * 3600000L) / 60000L) }));
      } else {
        ((AllRemindMsgUI.c)paramv).yTG.setText(h.c(this.yTD.getContext(), locald.timestamp, true));
      }
    }
    a.b.c(((AllRemindMsgUI.c)paramv).gxs, locald.username);
    AppMethodBeat.o(29119);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(29120);
    if (AllRemindMsgUI.d(this.yTD) == null)
    {
      AppMethodBeat.o(29120);
      return 0;
    }
    int i = AllRemindMsgUI.d(this.yTD).size();
    AppMethodBeat.o(29120);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.b
 * JD-Core Version:    0.7.0.1
 */