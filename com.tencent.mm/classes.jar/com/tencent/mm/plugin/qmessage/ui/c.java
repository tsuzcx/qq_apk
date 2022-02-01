package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

final class c
  extends r<ap>
  implements n.b
{
  private final MMActivity iMV;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.f ntC;
  protected MMSlideDelView.d ntD;
  
  public c(Context paramContext, r.a parama)
  {
    super(paramContext, new ap());
    AppMethodBeat.i(27759);
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    super.a(parama);
    this.iMV = ((MMActivity)paramContext);
    AppMethodBeat.o(27759);
  }
  
  private static int Tf(String paramString)
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
  
  public final void Xb()
  {
    AppMethodBeat.i(27760);
    com.tencent.mm.model.az.ayM();
    setCursor(com.tencent.mm.model.c.awG().aNR(w.hmQ));
    if (this.HmY != null) {
      this.HmY.aPg();
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(27760);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(27764);
    Xb();
    AppMethodBeat.o(27764);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.ntC = paramf;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27761);
    ap localap = (ap)getItem(paramInt);
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new a();
      localView = View.inflate(this.iMV, 2131495763, null);
      paramViewGroup.fuY = ((ImageView)localView.findViewById(2131297008));
      paramViewGroup.fuZ = ((TextView)localView.findViewById(2131302867));
      paramViewGroup.ntF = ((TextView)localView.findViewById(2131306207));
      paramViewGroup.ntG = ((TextView)localView.findViewById(2131301311));
      paramViewGroup.mxD = ((ImageView)localView.findViewById(2131305187));
      paramViewGroup.ntH = ((TextView)localView.findViewById(2131305882));
      localView.setTag(paramViewGroup);
      paramViewGroup.fuZ.setText(v.wk(localap.field_username));
      localObject = paramViewGroup.ntF;
      if (localap.field_status != 1) {
        break label461;
      }
      paramView = this.iMV.getString(2131761075);
      label170:
      ((TextView)localObject).setText(paramView);
      a.b.c(paramViewGroup.fuY, localap.field_username);
      com.tencent.mm.model.az.ayM();
      localObject = com.tencent.mm.model.c.awG().Ls();
      if (bs.isNullOrNil(localap.field_digest)) {
        break label518;
      }
      if (bs.isNullOrNil(localap.field_digestUser)) {
        break label508;
      }
      if ((localap.field_isSend != 0) || (!w.sQ(localap.field_username))) {
        break label496;
      }
      paramView = v.getDisplayName(localap.field_digestUser, localap.field_username);
    }
    for (;;)
    {
      label461:
      label496:
      label508:
      try
      {
        paramView = String.format(localap.field_digest, new Object[] { paramView });
        paramViewGroup.ntG.setText(k.b(this.iMV, paramView, paramViewGroup.ntG.getTextSize()));
        switch (localap.field_status)
        {
        case 3: 
        case 4: 
        default: 
          paramInt = -1;
          if (paramInt == -1) {
            break label580;
          }
          paramViewGroup.mxD.setBackgroundResource(paramInt);
          paramViewGroup.mxD.setVisibility(0);
          paramInt = localView.getPaddingBottom();
          int i = localView.getPaddingTop();
          int j = localView.getPaddingRight();
          int k = localView.getPaddingLeft();
          if (localap.field_unReadCount <= 100) {
            break label592;
          }
          paramViewGroup.ntH.setText("...");
          paramViewGroup.ntH.setVisibility(0);
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
      if (localap.field_conversationTime == 9223372036854775807L)
      {
        paramView = "";
        break label170;
      }
      paramView = h.c(this.iMV, localap.field_conversationTime, true);
      break label170;
      paramView = v.wk(localap.field_digestUser);
      continue;
      paramView = localap.field_digest;
      continue;
      label518:
      paramView = ((bk.b)localObject).a(localap.field_isSend, localap.field_username, localap.field_content, Tf(localap.field_msgType), this.iMV);
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
      paramViewGroup.mxD.setVisibility(8);
      continue;
      label592:
      if (localap.field_unReadCount > 0)
      {
        paramViewGroup.ntH.setText(localap.field_unReadCount);
        paramViewGroup.ntH.setVisibility(0);
      }
      else
      {
        paramViewGroup.ntH.setVisibility(4);
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
    if (this.ntD != null) {
      this.ntD.cVr();
    }
    AppMethodBeat.o(27763);
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  public static final class a
  {
    public ImageView fuY;
    public TextView fuZ;
    public ImageView mxD;
    public TextView ntF;
    public TextView ntG;
    public TextView ntH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.c
 * JD-Core Version:    0.7.0.1
 */