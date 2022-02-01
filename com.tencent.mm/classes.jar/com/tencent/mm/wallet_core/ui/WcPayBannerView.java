package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.wallet_core.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wallet_core/ui/WcPayBannerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "arrowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bannerLayout", "value", "", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "iconIv", "Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;", "rootView", "textColor", "getTextColor", "setTextColor", "titleTv", "Landroid/widget/TextView;", "init", "", "setBannerData", "bannerItem", "Lcom/tencent/mm/protocal/protobuf/NoticeItem;", "setOrangeStyle", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WcPayBannerView
  extends LinearLayout
{
  private LinearLayout Ikm;
  private CdnImageView agVq;
  private LinearLayout agVr;
  private int bgColor;
  private int textColor;
  private TextView titleTv;
  private WeImageView wEX;
  
  public WcPayBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(242164);
    paramContext = LinearLayout.inflate(paramContext, a.g.wc_pay_banner_view, (ViewGroup)this);
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(242164);
      throw paramContext;
    }
    this.Ikm = ((LinearLayout)paramContext);
    paramAttributeSet = this.Ikm;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("rootView");
      paramContext = null;
    }
    paramContext = paramContext.findViewById(a.f.wc_pay_banner_view_layout);
    s.s(paramContext, "rootView.findViewById(R.…c_pay_banner_view_layout)");
    this.agVr = ((LinearLayout)paramContext);
    paramAttributeSet = this.Ikm;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("rootView");
      paramContext = null;
    }
    paramContext = paramContext.findViewById(a.f.wc_pay_banner_icon_iv);
    s.s(paramContext, "rootView.findViewById(R.id.wc_pay_banner_icon_iv)");
    this.agVq = ((CdnImageView)paramContext);
    paramAttributeSet = this.Ikm;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("rootView");
      paramContext = null;
    }
    paramContext = paramContext.findViewById(a.f.wc_pay_banner_title_tv);
    s.s(paramContext, "rootView.findViewById(R.id.wc_pay_banner_title_tv)");
    this.titleTv = ((TextView)paramContext);
    paramAttributeSet = this.Ikm;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("rootView");
      paramContext = null;
    }
    paramContext = paramContext.findViewById(a.f.wc_pay_banner_arrow_iv);
    s.s(paramContext, "rootView.findViewById(R.id.wc_pay_banner_arrow_iv)");
    this.wEX = ((WeImageView)paramContext);
    paramAttributeSet = this.agVq;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("iconIv");
      paramContext = null;
    }
    paramContext.setUseSdcardCache(true);
    paramContext = this.agVq;
    if (paramContext == null)
    {
      s.bIx("iconIv");
      paramContext = localObject;
    }
    for (;;)
    {
      paramContext.setImgSavedDir(d.jOc());
      AppMethodBeat.o(242164);
      return;
    }
  }
  
  private static final void a(WcPayBannerView paramWcPayBannerView, dus paramdus, View paramView)
  {
    AppMethodBeat.i(242165);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramWcPayBannerView);
    localb.cH(paramdus);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/wallet_core/ui/WcPayBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramWcPayBannerView, "this$0");
    s.u(paramdus, "$this_apply");
    i.bC(paramWcPayBannerView.getContext(), paramdus.jump_url);
    h.OAn.b(24273, new Object[] { paramdus.YSS, Integer.valueOf(2) });
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/wallet_core/ui/WcPayBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242165);
  }
  
  public final int getBgColor()
  {
    return this.bgColor;
  }
  
  public final int getTextColor()
  {
    return this.textColor;
  }
  
  public final void jPz()
  {
    AppMethodBeat.i(242176);
    setBgColor(getResources().getColor(a.c.Orange));
    setTextColor(getResources().getColor(a.c.White));
    AppMethodBeat.o(242176);
  }
  
  public final void setBannerData(dus paramdus)
  {
    Object localObject2 = null;
    AppMethodBeat.i(242178);
    if (paramdus == null)
    {
      setVisibility(8);
      AppMethodBeat.o(242178);
      return;
    }
    if (paramdus.abaE == 0)
    {
      setVisibility(8);
      AppMethodBeat.o(242178);
      return;
    }
    setVisibility(0);
    Object localObject3 = this.titleTv;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("titleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setLineSpacing(2.0F, 1.0F);
    localObject1 = this.titleTv;
    int i;
    label140:
    int j;
    if (localObject1 == null)
    {
      s.bIx("titleTv");
      localObject1 = null;
      ((TextView)localObject1).setText((CharSequence)paramdus.wording);
      localObject1 = (CharSequence)paramdus.left_icon;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label376;
      }
      i = 1;
      if (i != 0) {
        break label381;
      }
      localObject3 = this.agVq;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("iconIv");
        localObject1 = null;
      }
      ((CdnImageView)localObject1).setUrl(paramdus.left_icon);
      localObject3 = this.agVq;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("iconIv");
        localObject1 = null;
      }
      ((CdnImageView)localObject1).setVisibility(0);
      j = 1;
      label207:
      localObject1 = (CharSequence)paramdus.jump_url;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label416;
      }
      i = 1;
      label233:
      if (i != 0) {
        break label421;
      }
      setOnClickListener(new WcPayBannerView..ExternalSyntheticLambda0(this, paramdus));
      localObject3 = this.wEX;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("arrowIv");
        localObject1 = null;
      }
      ((WeImageView)localObject1).setVisibility(0);
      if (Build.VERSION.SDK_INT < 23) {
        break label460;
      }
      setForeground(getResources().getDrawable(a.e.wc_pay_banner_fg));
      i = 1;
    }
    for (;;)
    {
      label304:
      if ((j == 0) && (i == 0))
      {
        localObject1 = this.titleTv;
        if (localObject1 != null) {
          break label457;
        }
        s.bIx("titleTv");
        localObject1 = localObject2;
      }
      label416:
      label421:
      label457:
      for (;;)
      {
        ((TextView)localObject1).setGravity(1);
        h.OAn.b(24273, new Object[] { paramdus.YSS, Integer.valueOf(1) });
        AppMethodBeat.o(242178);
        return;
        break;
        label376:
        i = 0;
        break label140;
        label381:
        localObject3 = this.agVq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("iconIv");
          localObject1 = null;
        }
        ((CdnImageView)localObject1).setVisibility(8);
        j = 0;
        break label207;
        i = 0;
        break label233;
        localObject3 = this.wEX;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("arrowIv");
          localObject1 = null;
        }
        ((WeImageView)localObject1).setVisibility(8);
        i = 0;
        break label304;
      }
      label460:
      i = 1;
    }
  }
  
  public final void setBgColor(int paramInt)
  {
    AppMethodBeat.i(242170);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setCornerRadius(com.tencent.mm.cd.a.fromDPToPix(getContext(), 8));
    localGradientDrawable.setColor(paramInt);
    LinearLayout localLinearLayout2 = this.agVr;
    LinearLayout localLinearLayout1 = localLinearLayout2;
    if (localLinearLayout2 == null)
    {
      s.bIx("bannerLayout");
      localLinearLayout1 = null;
    }
    localLinearLayout1.setBackground((Drawable)localGradientDrawable);
    AppMethodBeat.o(242170);
  }
  
  public final void setTextColor(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(242173);
    TextView localTextView = this.titleTv;
    Object localObject1 = localTextView;
    if (localTextView == null)
    {
      s.bIx("titleTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(paramInt);
    localObject1 = this.wEX;
    if (localObject1 == null)
    {
      s.bIx("arrowIv");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((WeImageView)localObject1).setIconColor(paramInt);
      AppMethodBeat.o(242173);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WcPayBannerView
 * JD-Core Version:    0.7.0.1
 */