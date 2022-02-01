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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class b
  extends r<cd>
{
  private MMActivity fLP;
  private int limit;
  protected MMSlideDelView.g nUw;
  protected MMSlideDelView.c nUx;
  protected MMSlideDelView.d nUz;
  protected MMSlideDelView.f wpH;
  private ce yOi;
  
  public b(Context paramContext, ce paramce, int paramInt)
  {
    super(paramContext, new cd());
    AppMethodBeat.i(28371);
    this.limit = -1;
    this.nUz = MMSlideDelView.getItemStatusCallBack();
    this.fLP = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.yOi = paramce;
    AppMethodBeat.o(28371);
  }
  
  public final void Pr(int paramInt)
  {
    AppMethodBeat.i(28372);
    det();
    this.limit = paramInt;
    Zu();
    AppMethodBeat.o(28372);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(28374);
    setCursor(this.yOi.IE(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28374);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(28373);
    Zu();
    AppMethodBeat.o(28373);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.wpH = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28375);
    cd localcd = (cd)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.fLP, 2131493169, null);
      paramView = new a();
      paramViewGroup = View.inflate(this.fLP, 2131495280, null);
      paramView.fRd = ((ImageView)paramViewGroup.findViewById(2131298722));
      paramView.jbW = ((TextView)paramViewGroup.findViewById(2131299149));
      paramView.vHM = ((TextView)paramViewGroup.findViewById(2131304296));
      paramView.nUE = ((MMSlideDelView)localObject).findViewById(2131304837);
      paramView.nUF = ((TextView)((MMSlideDelView)localObject).findViewById(2131304839));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.nUw);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.nUx);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.nUz);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.nUE.setTag(Long.valueOf(localcd.field_svrid));
      paramViewGroup.nUE.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28370);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.v("MicroMsg.SayHiAdapter", "on delView clicked");
          b.this.nUz.deD();
          if (b.this.wpH != null) {
            b.this.wpH.cP(paramAnonymousView.getTag());
          }
          a.a(this, "com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28370);
        }
      });
      paramView = bu.d.aUe(localcd.field_content);
      paramViewGroup.jbW.setText(k.b(this.fLP, paramView.getDisplayName(), paramViewGroup.jbW.getTextSize()));
      paramViewGroup.vHM.setText(localcd.field_sayhicontent);
      a.b.c(paramViewGroup.fRd, localcd.field_sayhiuser);
      AppMethodBeat.o(28375);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.nUx = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.nUw = paramg;
  }
  
  static final class a
  {
    ImageView fRd;
    TextView jbW;
    View nUE;
    TextView nUF;
    TextView vHM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */