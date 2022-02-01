package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.s;

final class b
  extends s<cl>
{
  protected MMSlideDelView.f AAA;
  private cm Djk;
  private MMActivity gte;
  private int limit;
  protected MMSlideDelView.g pkY;
  protected MMSlideDelView.c pkZ;
  protected MMSlideDelView.d plb;
  
  public b(Context paramContext, cm paramcm, int paramInt)
  {
    super(paramContext, new cl());
    AppMethodBeat.i(28371);
    this.limit = -1;
    this.plb = MMSlideDelView.getItemStatusCallBack();
    this.gte = ((MMActivity)paramContext);
    this.limit = paramInt;
    this.Djk = paramcm;
    AppMethodBeat.o(28371);
  }
  
  public final void XB(int paramInt)
  {
    AppMethodBeat.i(28372);
    ebf();
    this.limit = paramInt;
    anp();
    AppMethodBeat.o(28372);
  }
  
  public final void a(MMSlideDelView.f paramf)
  {
    this.AAA = paramf;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(28374);
    setCursor(this.Djk.Pf(this.limit));
    super.notifyDataSetChanged();
    AppMethodBeat.o(28374);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(28373);
    anp();
    AppMethodBeat.o(28373);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28375);
    cl localcl = (cl)getItem(paramInt);
    Object localObject;
    if (paramView == null)
    {
      localObject = (MMSlideDelView)View.inflate(this.gte, 2131493215, null);
      paramView = new a();
      paramViewGroup = View.inflate(this.gte, 2131496130, null);
      paramView.gyr = ((ImageView)paramViewGroup.findViewById(2131299160));
      paramView.kcS = ((TextView)paramViewGroup.findViewById(2131299677));
      paramView.znW = ((TextView)paramViewGroup.findViewById(2131307224));
      paramView.plg = ((MMSlideDelView)localObject).findViewById(2131307923);
      paramView.plh = ((TextView)((MMSlideDelView)localObject).findViewById(2131307925));
      ((MMSlideDelView)localObject).setView(paramViewGroup);
      ((MMSlideDelView)localObject).setPerformItemClickListener(this.pkY);
      ((MMSlideDelView)localObject).setGetViewPositionCallback(this.pkZ);
      ((MMSlideDelView)localObject).setItemStatusCallBack(this.plb);
      ((MMSlideDelView)localObject).setEnable(false);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.plg.setTag(Long.valueOf(localcl.field_svrid));
      paramViewGroup.plg.setOnClickListener(new b.1(this));
      paramView = ca.d.bkD(localcl.field_content);
      paramViewGroup.kcS.setText(l.b(this.gte, paramView.getDisplayName(), paramViewGroup.kcS.getTextSize()));
      paramViewGroup.znW.setText(localcl.field_sayhicontent);
      a.b.c(paramViewGroup.gyr, localcl.field_sayhiuser);
      AppMethodBeat.o(28375);
      return localObject;
      paramViewGroup = (a)paramView.getTag();
      localObject = paramView;
    }
  }
  
  public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
  {
    this.pkZ = paramc;
  }
  
  public final void setPerformItemClickListener(MMSlideDelView.g paramg)
  {
    this.pkY = paramg;
  }
  
  static final class a
  {
    ImageView gyr;
    TextView kcS;
    View plg;
    TextView plh;
    TextView znW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.b
 * JD-Core Version:    0.7.0.1
 */