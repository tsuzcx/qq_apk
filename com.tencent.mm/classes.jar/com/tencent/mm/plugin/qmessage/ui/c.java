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
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;

final class c
  extends x<bb>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity lzt;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.f vzh;
  protected MMSlideDelView.d vzi;
  
  public c(Context paramContext, x.a parama)
  {
    super(paramContext, new bb());
    AppMethodBeat.i(27759);
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.lzt = ((MMActivity)paramContext);
    AppMethodBeat.o(27759);
  }
  
  private static int aip(String paramString)
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
    this.vzh = paramf;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(27760);
    bh.bCz();
    w(com.tencent.mm.model.c.bzG().bxY(ab.okd));
    if (this.adDx != null) {
      this.adDx.bWC();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(27760);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(27764);
    aNy();
    AppMethodBeat.o(27764);
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27761);
    bb localbb = (bb)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.lzt, R.i.tmessage_item, null);
      paramViewGroup.lBC = ((ImageView)localView.findViewById(R.h.avatar_iv));
      paramViewGroup.lBD = ((TextView)localView.findViewById(R.h.nickname_tv));
      paramViewGroup.vzk = ((TextView)localView.findViewById(R.h.update_time_tv));
      paramViewGroup.vzl = ((TextView)localView.findViewById(R.h.last_msg_tv));
      paramViewGroup.uAw = ((ImageView)localView.findViewById(R.h.state_iv));
      paramViewGroup.vzm = ((TextView)localView.findViewById(R.h.tipcnt_tv));
      localView.setTag(paramViewGroup);
      paramViewGroup.lBD.setText(aa.getDisplayName(localbb.field_username));
      localObject = paramViewGroup.vzk;
      if (localbb.field_status != 1) {
        break label469;
      }
      paramView = this.lzt.getString(R.l.gNp);
      label178:
      ((TextView)localObject).setText(paramView);
      a.b.g(paramViewGroup.lBC, localbb.field_username);
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzG().aDH();
      if (Util.isNullOrNil(localbb.field_digest)) {
        break label526;
      }
      if (Util.isNullOrNil(localbb.field_digestUser)) {
        break label516;
      }
      if ((localbb.field_isSend != 0) || (!au.bwE(localbb.field_username))) {
        break label504;
      }
      paramView = aa.aV(localbb.field_digestUser, localbb.field_username);
    }
    for (;;)
    {
      label469:
      label504:
      try
      {
        paramView = String.format(localbb.field_digest, new Object[] { paramView });
        paramViewGroup.vzl.setText(p.b(this.lzt, paramView, paramViewGroup.vzl.getTextSize()));
        switch (localbb.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label588;
          }
          paramViewGroup.uAw.setBackgroundResource(paramInt);
          paramViewGroup.uAw.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localbb.field_unReadCount <= 100) {
            break label600;
          }
          paramViewGroup.vzm.setText("...");
          paramViewGroup.vzm.setVisibility(0);
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
      if (localbb.field_conversationTime == 9223372036854775807L)
      {
        paramView = "";
        break label178;
      }
      paramView = f.d(this.lzt, localbb.field_conversationTime, true);
      break label178;
      paramView = aa.getDisplayName(localbb.field_digestUser);
      continue;
      label516:
      paramView = localbb.field_digest;
      continue;
      label526:
      paramView = ((by.b)localObject).a(localbb.field_isSend, localbb.field_username, localbb.field_content, aip(localbb.field_msgType), this.lzt);
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
      paramViewGroup.uAw.setVisibility(8);
      continue;
      label600:
      if (localbb.field_unReadCount > 0)
      {
        paramViewGroup.vzm.setText(localbb.field_unReadCount);
        paramViewGroup.vzm.setVisibility(0);
      }
      else
      {
        paramViewGroup.vzm.setVisibility(4);
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
    if (this.vzi != null) {
      this.vzi.fSm();
    }
    AppMethodBeat.o(27763);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  public static final class a
  {
    public ImageView lBC;
    public TextView lBD;
    public ImageView uAw;
    public TextView vzk;
    public TextView vzl;
    public TextView vzm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */