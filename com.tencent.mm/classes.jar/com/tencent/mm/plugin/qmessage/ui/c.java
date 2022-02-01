package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.i.f;
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
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.a;

final class c
  extends s<az>
  implements MStorageEx.IOnStorageChange
{
  private final MMActivity gte;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.f pla;
  protected MMSlideDelView.d plb;
  
  public c(Context paramContext, s.a parama)
  {
    super(paramContext, new az());
    AppMethodBeat.i(27759);
    this.plb = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.gte = ((MMActivity)paramContext);
    AppMethodBeat.o(27759);
  }
  
  private static int ahn(String paramString)
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
    this.pla = paramf;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(27760);
    bg.aVF();
    setCursor(com.tencent.mm.model.c.aST().bkh(ab.iCI));
    if (this.OFI != null) {
      this.OFI.bnE();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(27760);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(27764);
    anp();
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
      localView = View.inflate(this.gte, 2131496721, null);
      paramViewGroup.gvv = ((ImageView)localView.findViewById(2131297134));
      paramViewGroup.gvw = ((TextView)localView.findViewById(2131305440));
      paramViewGroup.pld = ((TextView)localView.findViewById(2131309606));
      paramViewGroup.ple = ((TextView)localView.findViewById(2131303011));
      paramViewGroup.ooE = ((ImageView)localView.findViewById(2131308378));
      paramViewGroup.plf = ((TextView)localView.findViewById(2131309165));
      localView.setTag(paramViewGroup);
      paramViewGroup.gvw.setText(aa.getDisplayName(localaz.field_username));
      localObject = paramViewGroup.pld;
      if (localaz.field_status != 1) {
        break label461;
      }
      paramView = this.gte.getString(2131762861);
      label170:
      ((TextView)localObject).setText(paramView);
      a.b.c(paramViewGroup.gvv, localaz.field_username);
      bg.aVF();
      localObject = com.tencent.mm.model.c.aST().Xh();
      if (Util.isNullOrNil(localaz.field_digest)) {
        break label518;
      }
      if (Util.isNullOrNil(localaz.field_digestUser)) {
        break label508;
      }
      if ((localaz.field_isSend != 0) || (!ab.Eq(localaz.field_username))) {
        break label496;
      }
      paramView = aa.getDisplayName(localaz.field_digestUser, localaz.field_username);
    }
    for (;;)
    {
      label461:
      label496:
      label508:
      try
      {
        paramView = String.format(localaz.field_digest, new Object[] { paramView });
        paramViewGroup.ple.setText(l.b(this.gte, paramView, paramViewGroup.ple.getTextSize()));
        switch (localaz.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label580;
          }
          paramViewGroup.ooE.setBackgroundResource(paramInt);
          paramViewGroup.ooE.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localaz.field_unReadCount <= 100) {
            break label592;
          }
          paramViewGroup.plf.setText("...");
          paramViewGroup.plf.setVisibility(0);
          localView.setBackgroundResource(2131233952);
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
        break label170;
      }
      paramView = f.c(this.gte, localaz.field_conversationTime, true);
      break label170;
      paramView = aa.getDisplayName(localaz.field_digestUser);
      continue;
      paramView = localaz.field_digest;
      continue;
      label518:
      paramView = ((bw.b)localObject).a(localaz.field_isSend, localaz.field_username, localaz.field_content, ahn(localaz.field_msgType), this.gte);
      continue;
      paramInt = -1;
      continue;
      paramInt = 2131691165;
      continue;
      paramInt = -1;
      continue;
      paramInt = 2131691164;
      continue;
      label580:
      paramViewGroup.ooE.setVisibility(8);
      continue;
      label592:
      if (localaz.field_unReadCount > 0)
      {
        paramViewGroup.plf.setText(localaz.field_unReadCount);
        paramViewGroup.plf.setVisibility(0);
      }
      else
      {
        paramViewGroup.plf.setVisibility(4);
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
    if (this.plb != null) {
      this.plb.ebo();
    }
    AppMethodBeat.o(27763);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  public static final class a
  {
    public ImageView gvv;
    public TextView gvw;
    public ImageView ooE;
    public TextView pld;
    public TextView ple;
    public TextView plf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */