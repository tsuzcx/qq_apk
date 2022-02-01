package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.v;

final class b
  extends v<cm>
{
  protected MMSlideDelView.f GtD;
  private cn JoM;
  private MMActivity iXq;
  private int limit;
  protected MMSlideDelView.g snh;
  protected MMSlideDelView.c sni;
  protected MMSlideDelView.d snk;
  
  public b(Context paramContext, cn paramcn, int paramInt)
  {
    super(paramContext, new cm());
    AppMethodBeat.i(28371);
    this.limit = -1;
    this.snk = MMSlideDelView.getItemStatusCallBack();
    this.iXq = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.JoM = paramcn;
    AppMethodBeat.o(28371);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.GtD = paramf;
  }
  
  public final void aeA(int paramInt)
  {
    AppMethodBeat.i(28372);
    eKd();
    this.limit = paramInt;
    atr();
    AppMethodBeat.o(28372);
  }
  
  public final void atr()
  {
    AppMethodBeat.i(28374);
    v(this.JoM.Vo(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28374);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(28373);
    atr();
    AppMethodBeat.o(28373);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28375);
    cm localcm = (cm)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.iXq, R.i.base_slide_del_view, null);
      paramView = new a();
      paramViewGroup = View.inflate(this.iXq, R.i.say_hi_item, null);
      paramView.jiu = ((ImageView)paramViewGroup.findViewById(R.h.contactitem_avatar_iv));
      paramView.mUr = ((TextView)paramViewGroup.findViewById(R.h.display_name));
      paramView.ETn = ((TextView)paramViewGroup.findViewById(R.h.sayhi_content));
      paramView.snp = ((MMSlideDelView)localObject).findViewById(R.h.slide_del_del_view);
      paramView.snq = ((TextView)((MMSlideDelView)localObject).findViewById(R.h.slide_del_view_del_word));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.snh);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.sni);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.snk);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.snp.setTag(Long.valueOf(localcm.field_svrid));
      paramViewGroup.snp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28370);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.v("MicroMsg.SayHiAdapter", "on delView clicked");
          b.this.snk.eKn();
          if (b.this.GtD != null) {
            b.this.GtD.cW(paramAnonymousView.getTag());
          }
          a.a(this, "com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28370);
        }
      });
      paramView = ca.d.bxc(localcm.field_content);
      paramViewGroup.mUr.setText(l.b(this.iXq, paramView.getDisplayName(), paramViewGroup.mUr.getTextSize()));
      paramViewGroup.ETn.setText(localcm.field_sayhicontent);
      a.b.c(paramViewGroup.jiu, localcm.field_sayhiuser);
      AppMethodBeat.o(28375);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.sni = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.snh = paramg;
  }
  
  static final class a
  {
    TextView ETn;
    ImageView jiu;
    TextView mUr;
    View snp;
    TextView snq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */