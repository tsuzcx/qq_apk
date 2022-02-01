package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.q;

final class b
  extends q<bu>
{
  private MMActivity imP;
  private int limit;
  protected MMSlideDelView.g mRk;
  protected MMSlideDelView.c mRl;
  protected MMSlideDelView.d mRn;
  protected MMSlideDelView.f ubr;
  private bv woh;
  
  public b(Context paramContext, bv parambv, int paramInt)
  {
    super(paramContext, new bu());
    AppMethodBeat.i(28371);
    this.limit = -1;
    this.mRn = MMSlideDelView.getItemStatusCallBack();
    this.imP = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.woh = parambv;
    AppMethodBeat.o(28371);
  }
  
  public final void LO(int paramInt)
  {
    AppMethodBeat.i(28372);
    cHX();
    this.limit = paramInt;
    Wd();
    AppMethodBeat.o(28372);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(28374);
    setCursor(this.woh.Fn(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28374);
  }
  
  public final void We()
  {
    AppMethodBeat.i(28373);
    Wd();
    AppMethodBeat.o(28373);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.ubr = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28375);
    bu localbu = (bu)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.imP, 2131493169, null);
      paramView = new a();
      paramViewGroup = View.inflate(this.imP, 2131495280, null);
      paramView.fuj = ((ImageView)paramViewGroup.findViewById(2131298722));
      paramView.iiF = ((TextView)paramViewGroup.findViewById(2131299149));
      paramView.twu = ((TextView)paramViewGroup.findViewById(2131304296));
      paramView.mRs = ((MMSlideDelView)localObject).findViewById(2131304837);
      paramView.mRt = ((TextView)((MMSlideDelView)localObject).findViewById(2131304839));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.mRk);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.mRl);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.mRn);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.mRs.setTag(Long.valueOf(localbu.field_svrid));
      paramViewGroup.mRs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28370);
          ad.v("MicroMsg.SayHiAdapter", "on delView clicked");
          b.this.mRn.cIh();
          if (b.this.ubr != null) {
            b.this.ubr.cO(paramAnonymousView.getTag());
          }
          AppMethodBeat.o(28370);
        }
      });
      paramView = bl.d.aIR(localbu.field_content);
      paramViewGroup.iiF.setText(k.b(this.imP, paramView.getDisplayName(), paramViewGroup.iiF.getTextSize()));
      paramViewGroup.twu.setText(localbu.field_sayhicontent);
      a.b.c(paramViewGroup.fuj, localbu.field_sayhiuser);
      AppMethodBeat.o(28375);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.mRl = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.mRk = paramg;
  }
  
  static final class a
  {
    ImageView fuj;
    TextView iiF;
    View mRs;
    TextView mRt;
    TextView twu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */