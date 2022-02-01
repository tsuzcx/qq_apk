package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

final class c
  extends r<at>
  implements n.b
{
  private final MMActivity fLP;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.f nUy;
  protected MMSlideDelView.d nUz;
  
  public c(Context paramContext, r.a parama)
  {
    super(paramContext, new at());
    AppMethodBeat.i(27759);
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.fLP = ((MMActivity)paramContext);
    AppMethodBeat.o(27759);
  }
  
  private static int WF(String paramString)
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
  
  public final void Zu()
  {
    AppMethodBeat.i(27760);
    com.tencent.mm.model.ba.aBQ();
    setCursor(com.tencent.mm.model.c.azv().aTI(w.hFg));
    if (this.JaF != null) {
      this.JaF.aSs();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(27760);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(27764);
    Zu();
    AppMethodBeat.o(27764);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.nUy = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27761);
    at localat = (at)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.fLP, 2131495763, null);
      paramViewGroup.fOf = ((ImageView)localView.findViewById(2131297008));
      paramViewGroup.fOg = ((TextView)localView.findViewById(2131302867));
      paramViewGroup.nUB = ((TextView)localView.findViewById(2131306207));
      paramViewGroup.nUC = ((TextView)localView.findViewById(2131301311));
      paramViewGroup.mYk = ((ImageView)localView.findViewById(2131305187));
      paramViewGroup.nUD = ((TextView)localView.findViewById(2131305882));
      localView.setTag(paramViewGroup);
      paramViewGroup.fOg.setText(v.zf(localat.field_username));
      localObject = paramViewGroup.nUB;
      if (localat.field_status != 1) {
        break label461;
      }
      paramView = this.fLP.getString(2131761075);
      label170:
      ((TextView)localObject).setText(paramView);
      a.b.c(paramViewGroup.fOf, localat.field_username);
      com.tencent.mm.model.ba.aBQ();
      localObject = com.tencent.mm.model.c.azv().Na();
      if (bt.isNullOrNil(localat.field_digest)) {
        break label518;
      }
      if (bt.isNullOrNil(localat.field_digestUser)) {
        break label508;
      }
      if ((localat.field_isSend != 0) || (!w.vF(localat.field_username))) {
        break label496;
      }
      paramView = v.getDisplayName(localat.field_digestUser, localat.field_username);
    }
    for (;;)
    {
      label461:
      label496:
      label508:
      try
      {
        paramView = String.format(localat.field_digest, new Object[] { paramView });
        paramViewGroup.nUC.setText(k.b(this.fLP, paramView, paramViewGroup.nUC.getTextSize()));
        switch (localat.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label580;
          }
          paramViewGroup.mYk.setBackgroundResource(paramInt);
          paramViewGroup.mYk.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localat.field_unReadCount <= 100) {
            break label592;
          }
          paramViewGroup.nUD.setText("...");
          paramViewGroup.nUD.setVisibility(0);
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
      if (localat.field_conversationTime == 9223372036854775807L)
      {
        paramView = "";
        break label170;
      }
      paramView = i.c(this.fLP, localat.field_conversationTime, true);
      break label170;
      paramView = v.zf(localat.field_digestUser);
      continue;
      paramView = localat.field_digest;
      continue;
      label518:
      paramView = ((bq.b)localObject).a(localat.field_isSend, localat.field_username, localat.field_content, WF(localat.field_msgType), this.fLP);
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
      paramViewGroup.mYk.setVisibility(8);
      continue;
      label592:
      if (localat.field_unReadCount > 0)
      {
        paramViewGroup.nUD.setText(localat.field_unReadCount);
        paramViewGroup.nUD.setVisibility(0);
      }
      else
      {
        paramViewGroup.nUD.setVisibility(4);
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
    if (this.nUz != null) {
      this.nUz.deC();
    }
    AppMethodBeat.o(27763);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  public static final class a
  {
    public ImageView fOf;
    public TextView fOg;
    public ImageView mYk;
    public TextView nUB;
    public TextView nUC;
    public TextView nUD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */