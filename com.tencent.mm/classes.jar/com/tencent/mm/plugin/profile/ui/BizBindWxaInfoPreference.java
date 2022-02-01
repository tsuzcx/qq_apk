package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics mTt;
  private static int mYE;
  private static int mYF;
  private c juF;
  private ImageView kEm;
  private TextView lHk;
  private TextView mYA;
  private LinearLayout mYB;
  private ViewGroup mYC;
  private View mYD;
  private List<WxaAttributes.WxaEntryInfo> mYy;
  private View mYz;
  private View.OnClickListener qri;
  private volatile boolean xfr;
  private volatile boolean xfs;
  private View.OnClickListener xft;
  
  static
  {
    AppMethodBeat.i(26925);
    mTt = ak.getContext().getResources().getDisplayMetrics();
    mYE = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 15);
    mYF = ak.getResources().getDimensionPixelSize(2131165514);
    AppMethodBeat.o(26925);
  }
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26917);
    init();
    AppMethodBeat.o(26917);
  }
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26916);
    init();
    AppMethodBeat.o(26916);
  }
  
  private void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo)
  {
    AppMethodBeat.i(26923);
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(mYF + mYE, mYF));
    localImageView.setPadding(0, 0, mYE, 0);
    this.mYB.addView(localImageView);
    a(paramWxaEntryInfo, localImageView, null);
    AppMethodBeat.o(26923);
  }
  
  private static void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo, ImageView paramImageView, TextView paramTextView)
  {
    AppMethodBeat.i(26924);
    if (paramWxaEntryInfo == null)
    {
      AppMethodBeat.o(26924);
      return;
    }
    String str = paramWxaEntryInfo.username;
    if (paramImageView != null)
    {
      paramImageView.setTag(str);
      com.tencent.mm.modelappbrand.a.b.aEl().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
    }
    if (paramTextView != null) {
      paramTextView.setText(bu.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(26924);
  }
  
  private void bgn()
  {
    AppMethodBeat.i(26921);
    if ((!this.xfr) || (this.mYy == null))
    {
      AppMethodBeat.o(26921);
      return;
    }
    if (!this.xfs)
    {
      AppMethodBeat.o(26921);
      return;
    }
    this.xfs = false;
    if (!this.mYy.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.mYy.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.kEm, this.lHk);
      }
      this.mYA.setText(this.mContext.getString(2131757588, new Object[] { Integer.valueOf(this.mYy.size()) }));
      eV(this.mYy);
      if (this.mYy.size() == 1)
      {
        this.mYz.setVisibility(0);
        this.mYC.setTag(((WxaAttributes.WxaEntryInfo)this.mYy.get(0)).username);
        this.mYC.setOnClickListener(this.qri);
        AppMethodBeat.o(26921);
        return;
      }
      this.mYz.setVisibility(8);
      this.mYC.setTag(null);
      this.mYC.setOnClickListener(this.xft);
      AppMethodBeat.o(26921);
      return;
    }
  }
  
  private void eV(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26922);
    this.mYB.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(26922);
      return;
    }
    int k = paramList.size();
    int j = this.mYC.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = mTt.widthPixels;
    }
    j = i - this.mYC.getPaddingLeft() - this.mYC.getPaddingRight();
    i = j / (mYF + mYE);
    if (i > k) {
      this.mYD.setVisibility(8);
    }
    for (;;)
    {
      j = Math.min(i, k);
      if (j <= 1) {
        break;
      }
      i = 0;
      while (i < j)
      {
        a((WxaAttributes.WxaEntryInfo)paramList.get(i));
        i += 1;
      }
      this.mYD.setVisibility(0);
      i = (j - this.mYD.getMeasuredWidth()) / (mYF + mYE);
    }
    ae.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(26922);
  }
  
  private void init()
  {
    AppMethodBeat.i(26920);
    this.qri = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26914);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26914);
          return;
        }
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).dlj = BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username;
        ((p)com.tencent.mm.kernel.g.ab(p.class)).a(BizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26914);
      }
    };
    this.xft = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26915);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ((r)com.tencent.mm.kernel.g.ab(r.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId, BizBindWxaInfoPreference.b(BizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26915);
      }
    };
    AppMethodBeat.o(26920);
  }
  
  public final void a(c paramc, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26919);
    this.xfs = true;
    this.juF = paramc;
    if (this.mYy == null) {
      this.mYy = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.mYy.addAll(paramList);
      }
      bgn();
      AppMethodBeat.o(26919);
      return;
      this.mYy.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26918);
    this.mYz = paramView.findViewById(2131300108);
    this.kEm = ((ImageView)paramView.findViewById(2131300882));
    this.lHk = ((TextView)paramView.findViewById(2131305906));
    this.mYA = ((TextView)paramView.findViewById(2131298797));
    this.mYD = paramView.findViewById(2131302454);
    this.mYB = ((LinearLayout)paramView.findViewById(2131298737));
    this.mYC = ((ViewGroup)paramView.findViewById(2131301138));
    this.xfr = true;
    if (this.mYy != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.xfs = bool;
      bgn();
      super.onBindView(paramView);
      AppMethodBeat.o(26918);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */