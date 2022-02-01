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
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.x;

final class b
  extends x<cp>
{
  protected MMSlideDelView.f MpD;
  private cq PBJ;
  private int limit;
  private MMActivity lzt;
  protected MMSlideDelView.g vzf;
  protected MMSlideDelView.c vzg;
  protected MMSlideDelView.d vzi;
  
  public b(Context paramContext, cq paramcq, int paramInt)
  {
    super(paramContext, new cp());
    AppMethodBeat.i(28371);
    this.limit = -1;
    this.vzi = MMSlideDelView.getItemStatusCallBack();
    this.lzt = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.PBJ = paramcq;
    AppMethodBeat.o(28371);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.MpD = paramf;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(28374);
    w(this.PBJ.Zj(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28374);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(28373);
    aNy();
    AppMethodBeat.o(28373);
  }
  
  public final void ajh(int paramInt)
  {
    AppMethodBeat.i(28372);
    fSd();
    this.limit = paramInt;
    aNy();
    AppMethodBeat.o(28372);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28375);
    cp localcp = (cp)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.lzt, R.i.base_slide_del_view, null);
      paramView = new a();
      paramViewGroup = View.inflate(this.lzt, R.i.say_hi_item, null);
      paramView.lKK = ((ImageView)paramViewGroup.findViewById(R.h.contactitem_avatar_iv));
      paramView.pQZ = ((TextView)paramViewGroup.findViewById(R.h.display_name));
      paramView.KNR = ((TextView)paramViewGroup.findViewById(R.h.sayhi_content));
      paramView.vzn = ((MMSlideDelView)localObject).findViewById(R.h.slide_del_del_view);
      paramView.vzo = ((TextView)((MMSlideDelView)localObject).findViewById(R.h.slide_del_view_del_word));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.vzf);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.vzg);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.vzi);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.vzn.setTag(Long.valueOf(localcp.field_svrid));
      paramViewGroup.vzn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28370);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.v("MicroMsg.SayHiAdapter", "on delView clicked");
          b.this.vzi.fSn();
          if (b.this.MpD != null) {
            b.this.MpD.es(paramAnonymousView.getTag());
          }
          a.a(this, "com/tencent/mm/plugin/shake/ui/SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28370);
        }
      });
      paramView = cc.f.byv(localcp.field_content);
      paramViewGroup.pQZ.setText(p.b(this.lzt, paramView.getDisplayName(), paramViewGroup.pQZ.getTextSize()));
      paramViewGroup.KNR.setText(localcp.field_sayhicontent);
      a.b.g(paramViewGroup.lKK, localcp.field_sayhiuser);
      AppMethodBeat.o(28375);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.vzg = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.vzf = paramg;
  }
  
  static final class a
  {
    TextView KNR;
    ImageView lKK;
    TextView pQZ;
    View vzn;
    TextView vzo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */