package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.s;
import java.util.GregorianCalendar;

final class ShakeTvHistoryListUI$a
  extends r<n>
{
  private LayoutInflater Lu;
  
  public ShakeTvHistoryListUI$a(ShakeTvHistoryListUI paramShakeTvHistoryListUI, Context paramContext)
  {
    super(paramContext, new n());
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    long l1;
    if (paramView == null)
    {
      paramViewGroup = this.Lu.inflate(R.i.shake_tv_history_item, paramViewGroup, false);
      localObject1 = new ShakeTvHistoryListUI.a.a(this);
      ((ShakeTvHistoryListUI.a.a)localObject1).odB = ((MMImageView)paramViewGroup.findViewById(R.h.shake_tv_history_item_icon));
      ((ShakeTvHistoryListUI.a.a)localObject1).haW = ((TextView)paramViewGroup.findViewById(R.h.shake_tv_history_item_title));
      ((ShakeTvHistoryListUI.a.a)localObject1).lLL = ((TextView)paramViewGroup.findViewById(R.h.shake_tv_history_item_time));
      paramViewGroup.setTag(localObject1);
      localObject2 = (n)getItem(paramInt);
      e.a(((ShakeTvHistoryListUI.a.a)localObject1).odB, ((n)localObject2).field_iconurl, 0, true);
      ((ShakeTvHistoryListUI.a.a)localObject1).haW.setText(((n)localObject2).field_title);
      localObject1 = ((ShakeTvHistoryListUI.a.a)localObject1).lLL;
      paramView = this.odz.mController.uMN;
      l1 = ((n)localObject2).field_createtime * 1000L;
      localObject2 = new GregorianCalendar();
      if (l1 >= 3600000L) {
        break label188;
      }
      paramView = "";
    }
    for (;;)
    {
      ((TextView)localObject1).setText(paramView);
      return paramViewGroup;
      localObject1 = (ShakeTvHistoryListUI.a.a)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label188:
      localObject2 = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
      long l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
      if ((l2 > 0L) && (l2 <= 86400000L))
      {
        paramView = h.g(paramView.getString(R.l.fmt_normal_time_24), l1 / 1000L);
      }
      else
      {
        l2 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
        if ((l2 > 0L) && (l2 <= 86400000L)) {
          paramView = paramView.getString(R.l.fmt_pre_yesterday);
        } else {
          paramView = h.g(paramView.getString(R.l.fmt_longdate), l1 / 1000L);
        }
      }
    }
  }
  
  public final void yc()
  {
    setCursor(m.bzW().bAA());
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeTvHistoryListUI.a
 * JD-Core Version:    0.7.0.1
 */