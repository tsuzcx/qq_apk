package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;

final class b
  extends p<bt>
{
  private MMActivity cmc;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.d jSe;
  private int limit;
  protected MMSlideDelView.f pdU;
  private bu qPs;
  
  public b(Context paramContext, bu parambu, int paramInt)
  {
    super(paramContext, new bt());
    AppMethodBeat.i(24701);
    this.limit = -1;
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.cmc = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.qPs = parambu;
    AppMethodBeat.o(24701);
  }
  
  public final void Dp(int paramInt)
  {
    AppMethodBeat.i(24702);
    bKb();
    this.limit = paramInt;
    Ku();
    AppMethodBeat.o(24702);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(24704);
    setCursor(this.qPs.xL(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(24704);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(24703);
    Ku();
    AppMethodBeat.o(24703);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pdU = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24705);
    bt localbt = (bt)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.cmc, 2130968837, null);
      paramView = new b.a();
      paramViewGroup = View.inflate(this.cmc, 2130970595, null);
      paramView.ehv = ((ImageView)paramViewGroup.findViewById(2131823956));
      paramView.gvI = ((TextView)paramViewGroup.findViewById(2131827398));
      paramView.oBQ = ((TextView)paramViewGroup.findViewById(2131827399));
      paramView.jSj = ((MMSlideDelView)localObject).findViewById(2131821742);
      paramView.jSk = ((TextView)((MMSlideDelView)localObject).findViewById(2131821102));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.jSb);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.jSc);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.jSe);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jSj.setTag(Long.valueOf(localbt.field_svrid));
      paramViewGroup.jSj.setOnClickListener(new b.1(this));
      paramView = bi.d.asm(localbt.field_content);
      paramViewGroup.gvI.setText(j.b(this.cmc, paramView.getDisplayName(), paramViewGroup.gvI.getTextSize()));
      paramViewGroup.oBQ.setText(localbt.field_sayhicontent);
      a.b.c(paramViewGroup.ehv, localbt.field_sayhiuser);
      AppMethodBeat.o(24705);
      return localObject;
      paramViewGroup = (b.a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.jSc = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.jSb = paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */