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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.f.g;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;

public final class b
{
  boolean hqp = false;
  private Context mContext;
  private com.tencent.mm.plugin.sns.f.b oMf;
  TextView oMg;
  ListView oMh;
  View oMi;
  private int olg = -1;
  protected Animation ovA;
  protected Animation ovB;
  boolean ovC = false;
  private com.tencent.mm.plugin.sns.ui.d.b ovx;
  private FrameLayout ovy;
  AbsoluteLayout ovz = null;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.f.b paramb1)
  {
    this.mContext = paramContext;
    this.oMf = paramb1;
    this.ovx = paramb;
    this.ovy = paramFrameLayout;
    this.ovA = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.ovA = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_down);
    this.ovB = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.ovB = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_up);
  }
  
  public final boolean bEx()
  {
    if ((this.oMf != null) && (af.bDx().bEy())) {
      this.oMf.bEx();
    }
    if (this.ovz != null)
    {
      this.ovy.removeView(this.ovz);
      this.ovz = null;
      return true;
    }
    this.ovC = false;
    this.oMh = null;
    this.oMi = null;
    return false;
  }
  
  public final boolean bHf()
  {
    int k = this.oMg.getHeight();
    this.oMg.setVisibility(8);
    int i = 0;
    Object localObject = null;
    int j = 0;
    while (i < this.oMh.getAdapter().getCount())
    {
      localObject = this.oMh.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.oMi.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.oMh.getLayoutParams()).bottomMargin = (k - j);
    this.oMh.setVisibility(0);
    localObject = new b.4(this, k, j);
    ((Animation)localObject).setDuration(250L);
    this.oMh.startAnimation((Animation)localObject);
    return true;
  }
  
  public final boolean cS(View paramView)
  {
    if ((af.bDx().bEy()) && (this.oMf != null))
    {
      i = this.oMf.cP(paramView);
      if ((i == 0) || (i == 1)) {
        return true;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    if (this.ovC) {
      return false;
    }
    if (this.ovz != null)
    {
      if ((this.ovz.getTag() instanceof b.a))
      {
        paramView = ((b.a)this.ovz.getTag()).okf;
        this.ovC = true;
        paramView.startAnimation(this.ovB);
        this.ovB.setAnimationListener(new b.3(this, paramView));
      }
      for (;;)
      {
        return false;
        bEx();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b))) {
      return false;
    }
    com.tencent.mm.plugin.sns.data.b localb = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    Object localObject2 = localb.bJQ;
    this.ovz = new AbsoluteLayout(this.mContext);
    this.ovz.setId(i.f.address);
    new FrameLayout.LayoutParams(-1, -1);
    this.ovy.addView(this.ovz);
    int j = BackwardSupportUtil.b.b(this.mContext, 150.0F);
    int k = BackwardSupportUtil.b.b(this.mContext, 17.0F);
    BackwardSupportUtil.b.b(this.mContext, 40.0F);
    View localView = com.tencent.mm.ui.y.gt(this.mContext).inflate(i.g.ad_unlike_content, null);
    TextView localTextView = (TextView)localView.findViewById(i.f.ad_unlike_tip);
    Object localObject1 = x.fB(ae.getContext());
    com.tencent.mm.plugin.sns.storage.b localb1 = localb.omM.pjM;
    if (localb1 != null)
    {
      if (!"zh_CN".equals(localObject1)) {
        break label536;
      }
      localObject1 = localb1.oAW;
      if (!bk.bl((String)localObject1)) {
        localTextView.setText((CharSequence)localObject1);
      }
    }
    new Rect();
    int i = e.eK(this.mContext);
    localObject1 = localb.omM.bKf();
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
    this.olg = ak.gz(this.mContext);
    if (this.hqp)
    {
      i = a.fromDPToPix(this.mContext, 2);
      this.olg = 0;
    }
    for (;;)
    {
      localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.olg - i + k);
      localObject2 = new b.a(this, (String)localObject2, localView);
      this.ovz.setTag(localObject2);
      this.ovz.addView(localView, (ViewGroup.LayoutParams)localObject1);
      localView.setVisibility(8);
      this.ovC = true;
      new ah().post(new b.1(this, paramView, localView));
      return true;
      label536:
      if (("zh_TW".equals(localObject1)) || ("zh_HK".equals(localObject1)))
      {
        localObject1 = localb1.oAY;
        break;
      }
      localObject1 = localb1.oAX;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */