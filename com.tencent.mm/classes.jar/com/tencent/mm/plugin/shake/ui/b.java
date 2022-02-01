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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class b
  extends r<bx>
{
  private MMActivity iMV;
  private int limit;
  protected MMSlideDelView.g ntA;
  protected MMSlideDelView.c ntB;
  protected MMSlideDelView.d ntD;
  protected MMSlideDelView.f vkp;
  private by xzy;
  
  public b(Context paramContext, by paramby, int paramInt)
  {
    super(paramContext, new bx());
    AppMethodBeat.i(28371);
    this.limit = -1;
    this.ntD = MMSlideDelView.getItemStatusCallBack();
    this.iMV = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.xzy = paramby;
    AppMethodBeat.o(28371);
  }
  
  public final void NO(int paramInt)
  {
    AppMethodBeat.i(28372);
    cVi();
    this.limit = paramInt;
    Xb();
    AppMethodBeat.o(28372);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(28374);
    setCursor(this.xzy.Hi(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28374);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(28373);
    Xb();
    AppMethodBeat.o(28373);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.vkp = paramf;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28375);
    bx localbx = (bx)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.iMV, 2131493169, null);
      paramView = new a();
      paramViewGroup = View.inflate(this.iMV, 2131495280, null);
      paramView.fxQ = ((ImageView)paramViewGroup.findViewById(2131298722));
      paramView.iIN = ((TextView)paramViewGroup.findViewById(2131299149));
      paramView.uEM = ((TextView)paramViewGroup.findViewById(2131304296));
      paramView.ntI = ((MMSlideDelView)localObject).findViewById(2131304837);
      paramView.ntJ = ((TextView)((MMSlideDelView)localObject).findViewById(2131304839));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.ntA);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.ntB);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.ntD);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.ntI.setTag(Long.valueOf(localbx.field_svrid));
      paramViewGroup.ntI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(28370);
          ac.v("MicroMsg.SayHiAdapter", "on delView clicked");
          b.this.ntD.cVs();
          if (b.this.vkp != null) {
            b.this.vkp.cN(paramAnonymousView.getTag());
          }
          AppMethodBeat.o(28370);
        }
      });
      paramView = bo.d.aOn(localbx.field_content);
      paramViewGroup.iIN.setText(k.b(this.iMV, paramView.getDisplayName(), paramViewGroup.iIN.getTextSize()));
      paramViewGroup.uEM.setText(localbx.field_sayhicontent);
      a.b.c(paramViewGroup.fxQ, localbx.field_sayhiuser);
      AppMethodBeat.o(28375);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.ntB = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.ntA = paramg;
  }
  
  static final class a
  {
    ImageView fxQ;
    TextView iIN;
    View ntI;
    TextView ntJ;
    TextView uEM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */