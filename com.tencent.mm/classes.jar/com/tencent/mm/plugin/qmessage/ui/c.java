package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;

final class c
  extends v<az>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity iXq;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.f snj;
  protected MMSlideDelView.d snk;
  
  public c(Context paramContext, v.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(27759);
    this.snk = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.iXq = ((MMActivity)paramContext);
    AppMethodBeat.o(27759);
  }
  
  private static int aoT(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(27762);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(27762);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.snj = paramf;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(27760);
    bh.beI();
    v(com.tencent.mm.model.c.bbR().bwG(ab.lsE));
    if (this.VZc != null) {
      this.VZc.bxN();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(27760);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(27764);
    atr();
    AppMethodBeat.o(27764);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27761);
    az localaz = (az)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.iXq, R.i.tmessage_item, null);
      paramViewGroup.iZG = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramViewGroup.iZH = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramViewGroup.snm = ((TextView)localView.findViewById(R.h.update_time_tv));
      paramViewGroup.snn = ((TextView)localView.findViewById(R.h.last_msg_tv));
      paramViewGroup.rql = ((ImageView)localView.findViewById(R.h.state_iv));
      paramViewGroup.sno = ((TextView)localView.findViewById(R.h.tipcnt_tv));
      localView.setTag(paramViewGroup);
      paramViewGroup.iZH.setText(aa.PJ(localaz.field_username));
      localObject = paramViewGroup.snm;
      if (localaz.field_status != 1) {
        break label469;
      }
      paramView = this.iXq.getString(R.l.eLv);
      label178:
      ((TextView)localObject).setText(paramView);
      a.b.c(paramViewGroup.iZG, localaz.field_username);
      bh.beI();
      localObject = com.tencent.mm.model.c.bbR().abK();
      if (Util.isNullOrNil(localaz.field_digest)) {
        break label526;
      }
      if (Util.isNullOrNil(localaz.field_digestUser)) {
        break label516;
      }
      if ((localaz.field_isSend != 0) || (!ab.Lj(localaz.field_username))) {
        break label504;
      }
      paramView = aa.aL(localaz.field_digestUser, localaz.field_username);
    }
    for (;;)
    {
      label469:
      label504:
      try
      {
        paramView = String.format(localaz.field_digest, new Object[] { paramView });
        paramViewGroup.snn.setText(l.b(this.iXq, paramView, paramViewGroup.snn.getTextSize()));
        switch (localaz.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label588;
          }
          paramViewGroup.rql.setBackgroundResource(paramInt);
          paramViewGroup.rql.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localaz.field_unReadCount <= 100) {
            break label600;
          }
          paramViewGroup.sno.setText("...");
          paramViewGroup.sno.setVisibility(0);
          localView.setBackgroundResource(R.g.mm_listitem);
          localView.setPadding(k, i, j, paramInt);
          AppMethodBeat.o(27761);
          return localView;
        }
      }
      catch (Exception paramView) {}
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      if (localaz.field_conversationTime == 9223372036854775807L)
      {
        paramView = "";
        break label178;
      }
      paramView = f.d(this.iXq, localaz.field_conversationTime, true);
      break label178;
      paramView = aa.PJ(localaz.field_digestUser);
      continue;
      label516:
      paramView = localaz.field_digest;
      continue;
      label526:
      paramView = ((bw.b)localObject).a(localaz.field_isSend, localaz.field_username, localaz.field_content, aoT(localaz.field_msgType), this.iXq);
      continue;
      paramInt = -1;
      continue;
      paramInt = R.k.msg_state_sending;
      continue;
      paramInt = -1;
      continue;
      paramInt = R.k.msg_state_failed;
      continue;
      label588:
      paramViewGroup.rql.setVisibility(8);
      continue;
      label600:
      if (localaz.field_unReadCount > 0)
      {
        paramViewGroup.sno.setText(localaz.field_unReadCount);
        paramViewGroup.sno.setVisibility(0);
      }
      else
      {
        paramViewGroup.sno.setVisibility(4);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(27763);
    if (this.snk != null) {
      this.snk.eKm();
    }
    AppMethodBeat.o(27763);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  public static final class a
  {
    public ImageView iZG;
    public TextView iZH;
    public ImageView rql;
    public TextView snm;
    public TextView snn;
    public TextView sno;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */