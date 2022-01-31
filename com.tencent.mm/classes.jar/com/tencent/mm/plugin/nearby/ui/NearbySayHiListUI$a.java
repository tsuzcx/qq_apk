package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bo.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.p;

final class NearbySayHiListUI$a
  extends p<bf>
{
  private MMActivity cmc;
  protected MMSlideDelView.g jSb;
  protected MMSlideDelView.c jSc;
  protected MMSlideDelView.d jSe;
  int limit;
  private bg pdK;
  protected MMSlideDelView.f pdU;
  
  public NearbySayHiListUI$a(NearbySayHiListUI paramNearbySayHiListUI, Context paramContext, bg parambg, int paramInt)
  {
    super(paramContext, new bf());
    AppMethodBeat.i(55508);
    this.limit = -1;
    this.jSe = MMSlideDelView.getItemStatusCallBack();
    this.cmc = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.pdK = parambg;
    AppMethodBeat.o(55508);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(55510);
    if (a.dkM()) {
      setCursor(this.pdK.Nw(this.limit));
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(55510);
      return;
      setCursor(this.pdK.xL(this.limit));
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(55509);
    Ku();
    AppMethodBeat.o(55509);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.pdU = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(55511);
    bf localbf = (bf)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new NearbySayHiListUI.a.a(this);
      paramView = (MMSlideDelView)View.inflate(this.cmc, 2130968837, null);
      localObject = View.inflate(this.cmc, 2130970595, null);
      paramViewGroup.ehv = ((ImageView)((View)localObject).findViewById(2131823956));
      paramViewGroup.gvI = ((TextView)((View)localObject).findViewById(2131827398));
      paramViewGroup.oBQ = ((TextView)((View)localObject).findViewById(2131827399));
      paramViewGroup.jSj = paramView.findViewById(2131821742);
      paramViewGroup.jSk = ((TextView)paramView.findViewById(2131821102));
      paramView.setView((View)localObject);
      paramView.setPerformItemClickListener(this.jSb);
      paramView.setGetViewPositionCallback(this.jSc);
      paramView.setItemStatusCallBack(this.jSe);
      paramView.setEnable(false);
      paramView.setTag(paramViewGroup);
      if (localbf.field_flag == 0) {
        break label289;
      }
    }
    label289:
    for (Object localObject = bi.d.asm(localbf.field_content).nickname;; localObject = localbf.field_talker)
    {
      paramViewGroup.gvI.setText(j.b(this.cmc, (CharSequence)localObject, paramViewGroup.gvI.getTextSize()));
      paramViewGroup.oBQ.setText(j.b(this.cmc, localbf.field_sayhicontent, paramViewGroup.oBQ.getTextSize()));
      paramViewGroup.jSj.setTag(Long.valueOf(localbf.field_svrid));
      paramViewGroup.jSj.setOnClickListener(new NearbySayHiListUI.a.1(this));
      a.b.c(paramViewGroup.ehv, localbf.field_sayhiuser);
      AppMethodBeat.o(55511);
      return paramView;
      paramViewGroup = (NearbySayHiListUI.a.a)paramView.getTag();
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.a
 * JD-Core Version:    0.7.0.1
 */