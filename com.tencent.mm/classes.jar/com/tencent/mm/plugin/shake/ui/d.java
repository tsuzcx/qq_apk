package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.r;
import java.util.GregorianCalendar;

final class d
  extends r<f>
{
  private LayoutInflater Lu;
  private Context mContext;
  int obN = 20;
  
  public d(Context paramContext)
  {
    super(paramContext, new f());
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    label141:
    label162:
    long l1;
    if (paramView == null)
    {
      paramViewGroup = this.Lu.inflate(R.i.shake_msg_item, paramViewGroup, false);
      localObject1 = new d.a(this);
      ((d.a)localObject1).obO = ((MMImageView)paramViewGroup.findViewById(R.h.shake_msg_item_thumb));
      ((d.a)localObject1).haW = ((TextView)paramViewGroup.findViewById(R.h.shake_msg_item_title));
      ((d.a)localObject1).iIV = ((TextView)paramViewGroup.findViewById(R.h.shake_msg_item_desc));
      ((d.a)localObject1).lLL = ((TextView)paramViewGroup.findViewById(R.h.shake_msg_item_time));
      paramViewGroup.setTag(localObject1);
      localObject2 = (f)getItem(paramInt);
      e.a(((d.a)localObject1).obO, ((f)localObject2).field_thumburl, R.k.app_attach_file_icon_webpage, false);
      if (!bk.bl(((f)localObject2).field_title)) {
        break label228;
      }
      ((d.a)localObject1).haW.setVisibility(8);
      if (!bk.bl(((f)localObject2).field_desc)) {
        break label268;
      }
      ((d.a)localObject1).iIV.setVisibility(8);
      localObject1 = ((d.a)localObject1).lLL;
      paramView = this.mContext;
      l1 = ((f)localObject2).field_createtime * 1000L;
      localObject2 = new GregorianCalendar();
      if (l1 >= 3600000L) {
        break label308;
      }
      paramView = "";
    }
    for (;;)
    {
      ((TextView)localObject1).setText(paramView);
      return paramViewGroup;
      localObject1 = (d.a)paramView.getTag();
      paramViewGroup = paramView;
      break;
      label228:
      ((d.a)localObject1).haW.setText(j.a(this.mContext, ((f)localObject2).field_title, ((d.a)localObject1).haW.getTextSize()));
      ((d.a)localObject1).haW.setVisibility(0);
      break label141;
      label268:
      ((d.a)localObject1).iIV.setText(j.a(this.mContext, ((f)localObject2).field_desc, ((d.a)localObject1).iIV.getTextSize()));
      ((d.a)localObject1).iIV.setVisibility(0);
      break label162;
      label308:
      long l2 = ((GregorianCalendar)localObject2).getTimeInMillis();
      int i;
      if ((l2 - l1) / 3600000L == 0L)
      {
        i = (int)((l2 - l1) / 60000L);
        paramInt = i;
        if (i <= 0) {
          paramInt = 1;
        }
        paramView = paramView.getResources().getQuantityString(R.j.fmt_in60min, paramInt, new Object[] { Integer.valueOf(paramInt) });
      }
      else
      {
        localObject2 = new GregorianCalendar(((GregorianCalendar)localObject2).get(1), ((GregorianCalendar)localObject2).get(2), ((GregorianCalendar)localObject2).get(5));
        long l3 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis();
        if ((l3 > 0L) && (l3 <= 86400000L))
        {
          i = (int)((l2 - l1) / 3600000L);
          paramInt = i;
          if (i <= 0) {
            paramInt = 1;
          }
          paramView = paramView.getResources().getQuantityString(R.j.fmt_in24h, paramInt, new Object[] { Integer.valueOf(paramInt) });
        }
        else
        {
          l3 = l1 - ((GregorianCalendar)localObject2).getTimeInMillis() + 86400000L;
          if ((l3 > 0L) && (l3 <= 86400000L))
          {
            paramView = paramView.getString(R.l.fmt_pre_yesterday);
          }
          else
          {
            i = (int)((l2 - l1) / 86400000L);
            paramInt = i;
            if (i <= 0) {
              paramInt = 1;
            }
            paramView = paramView.getResources().getQuantityString(R.j.fmt_indayh, paramInt, new Object[] { Integer.valueOf(paramInt) });
          }
        }
      }
    }
  }
  
  public final void xp(int paramInt)
  {
    bcS();
    this.obN = paramInt;
    yc();
  }
  
  public final void yc()
  {
    g localg = m.bzV();
    int i = this.obN;
    String str = "SELECT * FROM " + localg.getTableName() + " ORDER BY rowid DESC LIMIT " + i;
    setCursor(localg.dXw.rawQuery(str, null));
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.d
 * JD-Core Version:    0.7.0.1
 */