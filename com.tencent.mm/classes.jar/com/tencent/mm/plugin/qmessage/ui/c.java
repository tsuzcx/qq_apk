package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.as;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r.a;

final class c
  extends com.tencent.mm.ui.r<ak>
  implements m.b
{
  private final MMActivity bER;
  protected MMSlideDelView.g hZd;
  protected MMSlideDelView.c hZe;
  protected MMSlideDelView.f hZf;
  protected MMSlideDelView.d hZg = MMSlideDelView.getItemStatusCallBack();
  
  public c(Context paramContext, r.a parama)
  {
    super(paramContext, new ak());
    this.uMi = parama;
    this.bER = ((MMActivity)paramContext);
  }
  
  private static int xP(String paramString)
  {
    int j = 1;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return 1;
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.hZf = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ak localak = (ak)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.bER, R.i.tmessage_item, null);
      paramViewGroup.doU = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramViewGroup.doV = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramViewGroup.hZi = ((TextView)localView.findViewById(R.h.update_time_tv));
      paramViewGroup.hZj = ((TextView)localView.findViewById(R.h.last_msg_tv));
      paramViewGroup.hqD = ((ImageView)localView.findViewById(R.h.state_iv));
      paramViewGroup.hZk = ((TextView)localView.findViewById(R.h.tipcnt_tv));
      localView.setTag(paramViewGroup);
      paramViewGroup.doV.setText(com.tencent.mm.model.r.gV(localak.field_username));
      localObject = paramViewGroup.hZi;
      if (localak.field_status != 1) {
        break label455;
      }
      paramView = this.bER.getString(R.l.main_sending);
      label172:
      ((TextView)localObject).setText(paramView);
      a.b.a(paramViewGroup.doU, localak.field_username);
      au.Hx();
      localObject = com.tencent.mm.model.c.FB().tt();
      if (bk.bl(localak.field_digest)) {
        break label512;
      }
      if (bk.bl(localak.field_digestUser)) {
        break label502;
      }
      if ((localak.field_isSend != 0) || (!s.fn(localak.field_username))) {
        break label490;
      }
      paramView = com.tencent.mm.model.r.getDisplayName(localak.field_digestUser, localak.field_username);
    }
    for (;;)
    {
      label455:
      label490:
      label502:
      try
      {
        paramView = String.format(localak.field_digest, new Object[] { paramView });
        paramViewGroup.hZj.setText(j.a(this.bER, paramView, paramViewGroup.hZj.getTextSize()));
        switch (localak.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label574;
          }
          paramViewGroup.hqD.setBackgroundResource(paramInt);
          paramViewGroup.hqD.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localak.field_unReadCount <= 100) {
            break label586;
          }
          paramViewGroup.hZk.setText("...");
          paramViewGroup.hZk.setVisibility(0);
          localView.setBackgroundResource(R.g.mm_listitem);
          localView.setPadding(k, i, j, paramInt);
          return localView;
        }
      }
      catch (Exception paramView) {}
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      if (localak.field_conversationTime == 9223372036854775807L)
      {
        paramView = "";
        break label172;
      }
      paramView = h.c(this.bER, localak.field_conversationTime, true);
      break label172;
      paramView = com.tencent.mm.model.r.gV(localak.field_digestUser);
      continue;
      paramView = localak.field_digest;
      continue;
      label512:
      paramView = ((be.b)localObject).a(localak.field_isSend, localak.field_username, localak.field_content, xP(localak.field_msgType), this.bER);
      continue;
      paramInt = -1;
      continue;
      paramInt = R.k.msg_state_sending;
      continue;
      paramInt = -1;
      continue;
      paramInt = R.k.msg_state_failed;
      continue;
      label574:
      paramViewGroup.hqD.setVisibility(8);
      continue;
      label586:
      if (localak.field_unReadCount > 0)
      {
        paramViewGroup.hZk.setText(localak.field_unReadCount);
        paramViewGroup.hZk.setVisibility(0);
      }
      else
      {
        paramViewGroup.hZk.setVisibility(4);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    if (this.hZg != null) {
      this.hZg.bdb();
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.hZe = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.hZd = paramg;
  }
  
  public final void yc()
  {
    au.Hx();
    setCursor(com.tencent.mm.model.c.FB().abE(s.dUW));
    if (this.uMi != null) {
      this.uMi.Wp();
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
  
  public static final class a
  {
    public ImageView doU;
    public TextView doV;
    public TextView hZi;
    public TextView hZj;
    public TextView hZk;
    public ImageView hqD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */