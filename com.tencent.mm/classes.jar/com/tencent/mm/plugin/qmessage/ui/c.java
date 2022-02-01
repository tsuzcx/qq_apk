package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

final class c
  extends r<au>
  implements n.b
{
  private final MMActivity fNT;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.f oae;
  protected MMSlideDelView.d oaf;
  
  public c(Context paramContext, r.a parama)
  {
    super(paramContext, new au());
    AppMethodBeat.i(27759);
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.fNT = ((MMActivity)paramContext);
    AppMethodBeat.o(27759);
  }
  
  private static int Xr(String paramString)
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
  
  public final void ZD()
  {
    AppMethodBeat.i(27760);
    bc.aCg();
    setCursor(com.tencent.mm.model.c.azL().aVj(x.hHY));
    if (this.Jvn != null) {
      this.Jvn.aSR();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(27760);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(27764);
    ZD();
    AppMethodBeat.o(27764);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.oae = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27761);
    au localau = (au)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.fNT, 2131495763, null);
      paramViewGroup.fQl = ((ImageView)localView.findViewById(2131297008));
      paramViewGroup.fQm = ((TextView)localView.findViewById(2131302867));
      paramViewGroup.oah = ((TextView)localView.findViewById(2131306207));
      paramViewGroup.oai = ((TextView)localView.findViewById(2131301311));
      paramViewGroup.ndr = ((ImageView)localView.findViewById(2131305187));
      paramViewGroup.oaj = ((TextView)localView.findViewById(2131305882));
      localView.setTag(paramViewGroup);
      paramViewGroup.fQm.setText(w.zP(localau.field_username));
      localObject = paramViewGroup.oah;
      if (localau.field_status != 1) {
        break label461;
      }
      paramView = this.fNT.getString(2131761075);
      label170:
      ((TextView)localObject).setText(paramView);
      a.b.c(paramViewGroup.fQl, localau.field_username);
      bc.aCg();
      localObject = com.tencent.mm.model.c.azL().MV();
      if (bu.isNullOrNil(localau.field_digest)) {
        break label518;
      }
      if (bu.isNullOrNil(localau.field_digestUser)) {
        break label508;
      }
      if ((localau.field_isSend != 0) || (!x.wb(localau.field_username))) {
        break label496;
      }
      paramView = w.getDisplayName(localau.field_digestUser, localau.field_username);
    }
    for (;;)
    {
      label461:
      label496:
      label508:
      try
      {
        paramView = String.format(localau.field_digest, new Object[] { paramView });
        paramViewGroup.oai.setText(k.b(this.fNT, paramView, paramViewGroup.oai.getTextSize()));
        switch (localau.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label580;
          }
          paramViewGroup.ndr.setBackgroundResource(paramInt);
          paramViewGroup.ndr.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localau.field_unReadCount <= 100) {
            break label592;
          }
          paramViewGroup.oaj.setText("...");
          paramViewGroup.oaj.setVisibility(0);
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
      if (localau.field_conversationTime == 9223372036854775807L)
      {
        paramView = "";
        break label170;
      }
      paramView = i.c(this.fNT, localau.field_conversationTime, true);
      break label170;
      paramView = w.zP(localau.field_digestUser);
      continue;
      paramView = localau.field_digest;
      continue;
      label518:
      paramView = ((br.b)localObject).a(localau.field_isSend, localau.field_username, localau.field_content, Xr(localau.field_msgType), this.fNT);
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
      paramViewGroup.ndr.setVisibility(8);
      continue;
      label592:
      if (localau.field_unReadCount > 0)
      {
        paramViewGroup.oaj.setText(localau.field_unReadCount);
        paramViewGroup.oaj.setVisibility(0);
      }
      else
      {
        paramViewGroup.oaj.setVisibility(4);
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
    if (this.oaf != null) {
      this.oaf.dhu();
    }
    AppMethodBeat.o(27763);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
  }
  
  public static final class a
  {
    public ImageView fQl;
    public TextView fQm;
    public ImageView ndr;
    public TextView oah;
    public TextView oai;
    public TextView oaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */