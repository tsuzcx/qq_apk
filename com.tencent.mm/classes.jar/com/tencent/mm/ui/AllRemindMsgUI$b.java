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
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
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
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.remind_item, paramViewGroup, false);
    return new AllRemindMsgUI.c(this.uGB, paramViewGroup);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AllRemindMsgUI.d locald = (AllRemindMsgUI.d)AllRemindMsgUI.d(this.uGB).get(paramInt);
    ((AllRemindMsgUI.c)paramv).aie.setTag(locald);
    ((AllRemindMsgUI.c)paramv).nXe.setText(j.a(this.uGB.mController.uMN, locald.nickname, ((AllRemindMsgUI.c)paramv).nXe.getTextSize()));
    ((AllRemindMsgUI.c)paramv).eXr.setText(j.a(this.uGB.mController.uMN, locald.title, ((AllRemindMsgUI.c)paramv).eXr.getTextSize()));
    long l = System.currentTimeMillis();
    if (locald.timestamp - l < 60000L) {
      ((AllRemindMsgUI.c)paramv).uGE.setText(this.uGB.mController.uMN.getString(R.l.fmt_in_some_min, new Object[] { Integer.valueOf(1) }));
    }
    while (locald.brC == 2)
    {
      ((AllRemindMsgUI.c)paramv).ffK.setImageDrawable(this.uGB.mController.uMN.getResources().getDrawable(R.g.app_add_to_favorite));
      return;
      if (locald.timestamp - l < 3600000L) {
        ((AllRemindMsgUI.c)paramv).uGE.setText(this.uGB.mController.uMN.getString(R.l.fmt_in_some_min, new Object[] { Long.valueOf((locald.timestamp - l) / 60000L) }));
      } else if (locald.timestamp - l < 10800000L) {
        ((AllRemindMsgUI.c)paramv).uGE.setText(this.uGB.mController.uMN.getString(R.l.fmt_in_some_hour_min, new Object[] { Long.valueOf((locald.timestamp - l) / 3600000L), Long.valueOf((locald.timestamp - l - (locald.timestamp - l) / 3600000L * 3600000L) / 60000L) }));
      } else {
        ((AllRemindMsgUI.c)paramv).uGE.setText(h.c(this.uGB.mController.uMN, locald.timestamp, true));
      }
    }
    a.b.a(((AllRemindMsgUI.c)paramv).ffK, locald.username);
  }
  
  public final int getItemCount()
  {
    if (AllRemindMsgUI.d(this.uGB) == null) {
      return 0;
    }
    return AllRemindMsgUI.d(this.uGB).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.b
 * JD-Core Version:    0.7.0.1
 */