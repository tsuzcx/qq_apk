package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
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
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.i;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;

public final class b
{
  private int CHZ;
  private com.tencent.mm.plugin.sns.ui.d.c DQs;
  private FrameLayout DQt;
  AbsoluteLayout DQu;
  protected Animation DQv;
  protected Animation DQw;
  boolean DQx;
  k DzW;
  private com.tencent.mm.plugin.sns.h.b Eni;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.c Enj;
  TextView Enk;
  ListView Enl;
  View Enm;
  private Context mContext;
  boolean onr;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.h.b paramb)
  {
    AppMethodBeat.i(97689);
    this.DQu = null;
    this.DQx = false;
    this.onr = false;
    this.CHZ = -1;
    this.mContext = paramContext;
    this.Eni = paramb;
    this.DQs = paramc;
    this.DQt = paramFrameLayout;
    this.DQv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.DQv = AnimationUtils.loadAnimation(paramContext, 2130772028);
    this.DQw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.DQw = AnimationUtils.loadAnimation(paramContext, 2130772029);
    this.Enj = com.tencent.mm.plugin.sns.ad.timeline.feedback.c.a(paramContext, paramc);
    AppMethodBeat.o(97689);
  }
  
  public final boolean fcl()
  {
    AppMethodBeat.i(97691);
    if ((this.Eni != null) && (aj.faG().fco())) {
      this.Eni.fcl();
    }
    if (this.DQu != null)
    {
      this.DQt.removeView(this.DQu);
      this.DQu = null;
      AppMethodBeat.o(97691);
      return true;
    }
    this.DQx = false;
    this.Enl = null;
    this.Enm = null;
    AppMethodBeat.o(97691);
    return false;
  }
  
  public final boolean ffh()
  {
    AppMethodBeat.i(97692);
    final int k = this.Enk.getHeight();
    this.Enk.setVisibility(8);
    int i = 0;
    Object localObject = null;
    final int j = 0;
    while (i < this.Enl.getAdapter().getCount())
    {
      localObject = this.Enl.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.Enm.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.Enl.getLayoutParams()).bottomMargin = (k - j);
    this.Enl.setVisibility(0);
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(97688);
        paramAnonymousTransformation = (RelativeLayout.LayoutParams)b.this.Enl.getLayoutParams();
        if (paramAnonymousFloat == 1.0F) {}
        for (int i = 0;; i = (int)((k - j) * (1.0F - paramAnonymousFloat)))
        {
          paramAnonymousTransformation.bottomMargin = i;
          b.this.Enl.requestLayout();
          AppMethodBeat.o(97688);
          return;
        }
      }
      
      public final boolean willChangeBounds()
      {
        return true;
      }
    };
    ((Animation)localObject).setDuration(250L);
    this.Enl.startAnimation((Animation)localObject);
    AppMethodBeat.o(97692);
    return true;
  }
  
  public final boolean fn(final View paramView)
  {
    AppMethodBeat.i(97690);
    int i;
    if ((aj.faG().fco()) && (this.Eni != null))
    {
      i = this.Eni.fk(paramView);
      if ((i == 0) || (i == 1))
      {
        AppMethodBeat.o(97690);
        return true;
      }
      Log.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    for (;;)
    {
      if (this.DQx)
      {
        AppMethodBeat.o(97690);
        return false;
      }
      try
      {
        localObject1 = paramView.getTag();
        if (!(localObject1 instanceof com.tencent.mm.plugin.sns.data.c)) {
          continue;
        }
        localObject1 = aj.faO().aQm(((com.tencent.mm.plugin.sns.data.c)localObject1).dHp);
        i.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a((SnsInfo)localObject1, false, paramView, this.DzW));
        if (this.Enj == null) {
          continue;
        }
        boolean bool = this.Enj.a(paramView, (SnsInfo)localObject1);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(97690);
        return true;
      }
      catch (Throwable localThrowable) {}
      if (this.DQu != null)
      {
        if ((this.DQu.getTag() instanceof a))
        {
          paramView = ((a)this.DQu.getTag()).Atk;
          this.DQx = true;
          paramView.startAnimation(this.DQw);
          this.DQw.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(97687);
              if (paramView != null)
              {
                paramView.clearAnimation();
                paramView.setVisibility(8);
                b.this.fcl();
              }
              b.this.DQx = false;
              AppMethodBeat.o(97687);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation)
            {
              b.this.DQx = true;
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(97690);
          return false;
          fcl();
        }
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.c)))
      {
        AppMethodBeat.o(97690);
        return false;
      }
      com.tencent.mm.plugin.sns.data.c localc = (com.tencent.mm.plugin.sns.data.c)paramView.getTag();
      Object localObject2 = localc.dHp;
      this.DQu = new AbsoluteLayout(this.mContext);
      this.DQu.setId(2131296543);
      new FrameLayout.LayoutParams(-1, -1);
      this.DQt.addView(this.DQu);
      int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 150.0F);
      int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F);
      BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0F);
      final View localView = aa.jQ(this.mContext).inflate(2131492973, null);
      TextView localTextView = (TextView)localView.findViewById(2131296517);
      Object localObject1 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      ADXml localADXml = localc.DDr.EQY;
      if (localADXml != null)
      {
        if (!"zh_CN".equals(localObject1)) {
          break label654;
        }
        localObject1 = localADXml.expandInsideTitle_cn;
        if (!Util.isNullOrNil((String)localObject1))
        {
          localTextView.setText((CharSequence)localObject1);
          localTextView.setClickable(true);
        }
      }
      new Rect();
      i = h.im(this.mContext);
      localObject1 = localc.DDr.fjW();
      Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
      this.CHZ = ao.getStatusBarHeight(this.mContext);
      if (this.onr)
      {
        i = a.fromDPToPix(this.mContext, 2);
        this.CHZ = 0;
      }
      for (;;)
      {
        localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.CHZ - i + k);
        localObject2 = new a((String)localObject2, localView);
        this.DQu.setTag(localObject2);
        this.DQu.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localView.setVisibility(8);
        this.DQx = true;
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97686);
            b.a(b.this, paramView, localView);
            AppMethodBeat.o(97686);
          }
        });
        AppMethodBeat.o(97690);
        return true;
        label654:
        if (("zh_TW".equals(localObject1)) || ("zh_HK".equals(localObject1)))
        {
          localObject1 = localADXml.expandInsideTitle_tw;
          break;
        }
        localObject1 = localADXml.expandInsideTitle_en;
        break;
        i = a.fromDPToPix(this.mContext, 2) + i;
      }
    }
  }
  
  final class a
  {
    View Atk = null;
    String DQN;
    
    public a(String paramString, View paramView)
    {
      this.DQN = paramString;
      this.Atk = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */