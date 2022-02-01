package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class b
  extends r<ce>
{
  private MMActivity fNT;
  private int limit;
  protected MMSlideDelView.g oac;
  protected MMSlideDelView.c oad;
  protected MMSlideDelView.d oaf;
  protected MMSlideDelView.f wFq;
  private cf zes;
  
  public b(Context paramContext, cf paramcf, int paramInt)
  {
    super(paramContext, new ce());
    AppMethodBeat.i(28371);
    this.limit = -1;
    this.oaf = MMSlideDelView.getItemStatusCallBack();
    this.fNT = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.zes = paramcf;
    AppMethodBeat.o(28371);
  }
  
  public final void PY(int paramInt)
  {
    AppMethodBeat.i(28372);
    dhl();
    this.limit = paramInt;
    ZD();
    AppMethodBeat.o(28372);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(28374);
    setCursor(this.zes.Jc(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28374);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(28373);
    ZD();
    AppMethodBeat.o(28373);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.wFq = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28375);
    ce localce = (ce)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.fNT, 2131493169, null);
      paramView = new a();
      paramViewGroup = View.inflate(this.fNT, 2131495280, null);
      paramView.fTj = ((ImageView)paramViewGroup.findViewById(2131298722));
      paramView.jeP = ((TextView)paramViewGroup.findViewById(2131299149));
      paramView.vTQ = ((TextView)paramViewGroup.findViewById(2131304296));
      paramView.oak = ((MMSlideDelView)localObject).findViewById(2131304837);
      paramView.oal = ((TextView)((MMSlideDelView)localObject).findViewById(2131304839));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.oac);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.oad);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.oaf);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.oak.setTag(Long.valueOf(localce.field_svrid));
      paramViewGroup.oak.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28370);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.v("MicroMsg.SayHiAdapter", "on delView clicked");
          b.this.oaf.dhv();
          if (b.this.wFq != null) {
            b.this.wFq.cQ(paramAnonymousView.getTag());
          }
          a.a(this, "com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28370);
        }
      });
      paramView = bv.d.aVF(localce.field_content);
      paramViewGroup.jeP.setText(k.b(this.fNT, paramView.getDisplayName(), paramViewGroup.jeP.getTextSize()));
      paramViewGroup.vTQ.setText(localce.field_sayhicontent);
      a.b.c(paramViewGroup.fTj, localce.field_sayhiuser);
      AppMethodBeat.o(28375);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.oad = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.oac = paramg;
  }
  
  static final class a
  {
    ImageView fTj;
    TextView jeP;
    View oak;
    TextView oal;
    TextView vTQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */