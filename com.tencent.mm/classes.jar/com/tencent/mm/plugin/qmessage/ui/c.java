package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.q.a;

final class c
  extends q<am>
  implements n.b
{
  private final MMActivity imP;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.f mRm;
  protected MMSlideDelView.d mRn;
  
  public c(Context paramContext, q.a parama)
  {
    super(paramContext, new am());
    AppMethodBeat.i(27759);
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.imP = ((MMActivity)paramContext);
    AppMethodBeat.o(27759);
  }
  
  private static int OV(String paramString)
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
  
  public final void Wd()
  {
    AppMethodBeat.i(27760);
    az.arV();
    setCursor(com.tencent.mm.model.c.apR().aIw(w.gMq));
    if (this.FNn != null) {
      this.FNn.aIp();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(27760);
  }
  
  public final void We()
  {
    AppMethodBeat.i(27764);
    Wd();
    AppMethodBeat.o(27764);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.mRm = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27761);
    am localam = (am)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.imP, 2131495763, null);
      paramViewGroup.frr = ((ImageView)localView.findViewById(2131297008));
      paramViewGroup.frs = ((TextView)localView.findViewById(2131302867));
      paramViewGroup.mRp = ((TextView)localView.findViewById(2131306207));
      paramViewGroup.mRq = ((TextView)localView.findViewById(2131301311));
      paramViewGroup.lVB = ((ImageView)localView.findViewById(2131305187));
      paramViewGroup.mRr = ((TextView)localView.findViewById(2131305882));
      localView.setTag(paramViewGroup);
      paramViewGroup.frs.setText(v.sh(localam.field_username));
      localObject = paramViewGroup.mRp;
      if (localam.field_status != 1) {
        break label461;
      }
      paramView = this.imP.getString(2131761075);
      label170:
      ((TextView)localObject).setText(paramView);
      a.b.c(paramViewGroup.frr, localam.field_username);
      az.arV();
      localObject = com.tencent.mm.model.c.apR().Lu();
      if (bt.isNullOrNil(localam.field_digest)) {
        break label518;
      }
      if (bt.isNullOrNil(localam.field_digestUser)) {
        break label508;
      }
      if ((localam.field_isSend != 0) || (!w.pF(localam.field_username))) {
        break label496;
      }
      paramView = v.getDisplayName(localam.field_digestUser, localam.field_username);
    }
    for (;;)
    {
      label461:
      label496:
      label508:
      try
      {
        paramView = String.format(localam.field_digest, new Object[] { paramView });
        paramViewGroup.mRq.setText(k.b(this.imP, paramView, paramViewGroup.mRq.getTextSize()));
        switch (localam.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label580;
          }
          paramViewGroup.lVB.setBackgroundResource(paramInt);
          paramViewGroup.lVB.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localam.field_unReadCount <= 100) {
            break label592;
          }
          paramViewGroup.mRr.setText("...");
          paramViewGroup.mRr.setVisibility(0);
          localView.setBackgroundResource(2131233277);
          localView.setPadding(k, i, j, paramInt);
          AppMethodBeat.o(27761);
          return localView;
        }
      }
      catch (Exception paramView) {}
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
      break;
      if (localam.field_conversationTime == 9223372036854775807L)
      {
        paramView = "";
        break label170;
      }
      paramView = h.c(this.imP, localam.field_conversationTime, true);
      break label170;
      paramView = v.sh(localam.field_digestUser);
      continue;
      paramView = localam.field_digest;
      continue;
      label518:
      paramView = ((bh.b)localObject).a(localam.field_isSend, localam.field_username, localam.field_content, OV(localam.field_msgType), this.imP);
      continue;
      paramInt = -1;
      continue;
      paramInt = 2131690878;
      continue;
      paramInt = -1;
      continue;
      paramInt = 2131690877;
      continue;
      label580:
      paramViewGroup.lVB.setVisibility(8);
      continue;
      label592:
      if (localam.field_unReadCount > 0)
      {
        paramViewGroup.mRr.setText(localam.field_unReadCount);
        paramViewGroup.mRr.setVisibility(0);
      }
      else
      {
        paramViewGroup.mRr.setVisibility(4);
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
    if (this.mRn != null) {
      this.mRn.cIg();
    }
    AppMethodBeat.o(27763);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  public static final class a
  {
    public ImageView frr;
    public TextView frs;
    public ImageView lVB;
    public TextView mRp;
    public TextView mRq;
    public TextView mRr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */