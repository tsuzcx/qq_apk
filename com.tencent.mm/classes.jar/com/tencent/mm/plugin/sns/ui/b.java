package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.g.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.w;

public final class b
{
  boolean jew;
  private Context mContext;
  private int qZo;
  private com.tencent.mm.plugin.sns.g.b rDQ;
  TextView rDR;
  ListView rDS;
  View rDT;
  private com.tencent.mm.plugin.sns.ui.d.b rks;
  private FrameLayout rkt;
  AbsoluteLayout rku;
  protected Animation rkv;
  protected Animation rkw;
  boolean rkx;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.g.b paramb1)
  {
    AppMethodBeat.i(38068);
    this.rku = null;
    this.rkx = false;
    this.jew = false;
    this.qZo = -1;
    this.mContext = paramContext;
    this.rDQ = paramb1;
    this.rks = paramb;
    this.rkt = paramFrameLayout;
    this.rkv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.rkv = AnimationUtils.loadAnimation(paramContext, 2131034161);
    this.rkw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.rkw = AnimationUtils.loadAnimation(paramContext, 2131034162);
    AppMethodBeat.o(38068);
  }
  
  public final boolean cpX()
  {
    AppMethodBeat.i(38070);
    if ((this.rDQ != null) && (ag.coX().cqa())) {
      this.rDQ.cpX();
    }
    if (this.rku != null)
    {
      this.rkt.removeView(this.rku);
      this.rku = null;
      AppMethodBeat.o(38070);
      return true;
    }
    this.rkx = false;
    this.rDS = null;
    this.rDT = null;
    AppMethodBeat.o(38070);
    return false;
  }
  
  public final boolean ctj()
  {
    AppMethodBeat.i(38071);
    int k = this.rDR.getHeight();
    this.rDR.setVisibility(8);
    int i = 0;
    Object localObject = null;
    int j = 0;
    while (i < this.rDS.getAdapter().getCount())
    {
      localObject = this.rDS.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.rDT.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.rDS.getLayoutParams()).bottomMargin = (k - j);
    this.rDS.setVisibility(0);
    localObject = new b.4(this, k, j);
    ((Animation)localObject).setDuration(250L);
    this.rDS.startAnimation((Animation)localObject);
    AppMethodBeat.o(38071);
    return true;
  }
  
  public final boolean dI(View paramView)
  {
    AppMethodBeat.i(38069);
    if ((ag.coX().cqa()) && (this.rDQ != null))
    {
      i = this.rDQ.dF(paramView);
      if ((i == 0) || (i == 1))
      {
        AppMethodBeat.o(38069);
        return true;
      }
      ab.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    if (this.rkx)
    {
      AppMethodBeat.o(38069);
      return false;
    }
    if (this.rku != null)
    {
      if ((this.rku.getTag() instanceof b.a))
      {
        paramView = ((b.a)this.rku.getTag()).qYp;
        this.rkx = true;
        paramView.startAnimation(this.rkw);
        this.rkw.setAnimationListener(new b.3(this, paramView));
      }
      for (;;)
      {
        AppMethodBeat.o(38069);
        return false;
        cpX();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(38069);
      return false;
    }
    com.tencent.mm.plugin.sns.data.b localb = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    Object localObject2 = localb.crk;
    this.rku = new AbsoluteLayout(this.mContext);
    this.rku.setId(2131820735);
    new FrameLayout.LayoutParams(-1, -1);
    this.rkt.addView(this.rku);
    int j = BackwardSupportUtil.b.b(this.mContext, 150.0F);
    int k = BackwardSupportUtil.b.b(this.mContext, 17.0F);
    BackwardSupportUtil.b.b(this.mContext, 40.0F);
    View localView = w.hM(this.mContext).inflate(2130968632, null);
    TextView localTextView = (TextView)localView.findViewById(2131821047);
    Object localObject1 = aa.gP(ah.getContext());
    com.tencent.mm.plugin.sns.storage.b localb1 = localb.rba.scq;
    if (localb1 != null)
    {
      if (!"zh_CN".equals(localObject1)) {
        break label572;
      }
      localObject1 = localb1.rqg;
      if (!bo.isNullOrNil((String)localObject1)) {
        localTextView.setText((CharSequence)localObject1);
      }
    }
    new Rect();
    int i = f.fK(this.mContext);
    localObject1 = localb.rba.cwH();
    ab.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
    this.qZo = af.hT(this.mContext);
    if (this.jew)
    {
      i = a.fromDPToPix(this.mContext, 2);
      this.qZo = 0;
    }
    for (;;)
    {
      localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.qZo - i + k);
      localObject2 = new b.a(this, (String)localObject2, localView);
      this.rku.setTag(localObject2);
      this.rku.addView(localView, (ViewGroup.LayoutParams)localObject1);
      localView.setVisibility(8);
      this.rkx = true;
      new ak().post(new b.1(this, paramView, localView));
      AppMethodBeat.o(38069);
      return true;
      label572:
      if (("zh_TW".equals(localObject1)) || ("zh_HK".equals(localObject1)))
      {
        localObject1 = localb1.rqi;
        break;
      }
      localObject1 = localb1.rqh;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */