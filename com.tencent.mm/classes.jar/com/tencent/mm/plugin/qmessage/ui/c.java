package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;

final class c
  extends p<ak>
  implements n.b
{
  private final MMActivity cmc;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.f jSd;
  protected MMSlideDelView.d jSe;
  
  public c(Context paramContext, p.a parama)
  {
    super(paramContext, new ak());
    AppMethodBeat.i(24119);
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.cmc = ((MMActivity)paramContext);
    AppMethodBeat.o(24119);
  }
  
  private static int GH(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(24122);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(24122);
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
  
  public final void Ku()
  {
    AppMethodBeat.i(24120);
    aw.aaz();
    setCursor(com.tencent.mm.model.c.YF().arQ(t.flf));
    if (this.zaq != null) {
      this.zaq.apT();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(24120);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(24124);
    Ku();
    AppMethodBeat.o(24124);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.jSd = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24121);
    ak localak = (ak)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.cmc, 2130971001, null);
      paramViewGroup.egq = ((ImageView)localView.findViewById(2131821210));
      paramViewGroup.egr = ((TextView)localView.findViewById(2131823254));
      paramViewGroup.jSg = ((TextView)localView.findViewById(2131823255));
      paramViewGroup.jSh = ((TextView)localView.findViewById(2131823256));
      paramViewGroup.jfv = ((ImageView)localView.findViewById(2131828503));
      paramViewGroup.jSi = ((TextView)localView.findViewById(2131821087));
      localView.setTag(paramViewGroup);
      paramViewGroup.egr.setText(s.nE(localak.field_username));
      localObject = paramViewGroup.jSg;
      if (localak.field_status != 1) {
        break label461;
      }
      paramView = this.cmc.getString(2131301428);
      label170:
      ((TextView)localObject).setText(paramView);
      a.b.c(paramViewGroup.egq, localak.field_username);
      aw.aaz();
      localObject = com.tencent.mm.model.c.YF().BX();
      if (bo.isNullOrNil(localak.field_digest)) {
        break label518;
      }
      if (bo.isNullOrNil(localak.field_digestUser)) {
        break label508;
      }
      if ((localak.field_isSend != 0) || (!t.lA(localak.field_username))) {
        break label496;
      }
      paramView = s.getDisplayName(localak.field_digestUser, localak.field_username);
    }
    for (;;)
    {
      label461:
      label496:
      label508:
      try
      {
        paramView = String.format(localak.field_digest, new Object[] { paramView });
        paramViewGroup.jSh.setText(j.b(this.cmc, paramView, paramViewGroup.jSh.getTextSize()));
        switch (localak.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label580;
          }
          paramViewGroup.jfv.setBackgroundResource(paramInt);
          paramViewGroup.jfv.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localak.field_unReadCount <= 100) {
            break label592;
          }
          paramViewGroup.jSi.setText("...");
          paramViewGroup.jSi.setVisibility(0);
          localView.setBackgroundResource(2130839654);
          localView.setPadding(k, i, j, paramInt);
          AppMethodBeat.o(24121);
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
        break label170;
      }
      paramView = h.c(this.cmc, localak.field_conversationTime, true);
      break label170;
      paramView = s.nE(localak.field_digestUser);
      continue;
      paramView = localak.field_digest;
      continue;
      label518:
      paramView = ((be.b)localObject).a(localak.field_isSend, localak.field_username, localak.field_content, GH(localak.field_msgType), this.cmc);
      continue;
      paramInt = -1;
      continue;
      paramInt = 2131231716;
      continue;
      paramInt = -1;
      continue;
      paramInt = 2131231715;
      continue;
      label580:
      paramViewGroup.jfv.setVisibility(8);
      continue;
      label592:
      if (localak.field_unReadCount > 0)
      {
        paramViewGroup.jSi.setText(localak.field_unReadCount);
        paramViewGroup.jSi.setVisibility(0);
      }
      else
      {
        paramViewGroup.jSi.setVisibility(4);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(24123);
    if (this.jSe != null) {
      this.jSe.bKk();
    }
    AppMethodBeat.o(24123);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
  
  public static final class a
  {
    public ImageView egq;
    public TextView egr;
    public TextView jSg;
    public TextView jSh;
    public TextView jSi;
    public ImageView jfv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */