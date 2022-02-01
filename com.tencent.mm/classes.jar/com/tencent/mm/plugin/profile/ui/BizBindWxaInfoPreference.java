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
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics mOp;
  private static int mTw;
  private static int mTx;
  private c jrM;
  private ImageView kAX;
  private TextView lCL;
  private List<WxaAttributes.WxaEntryInfo> mTq;
  private View mTr;
  private TextView mTs;
  private LinearLayout mTt;
  private ViewGroup mTu;
  private View mTv;
  private View.OnClickListener qkD;
  private volatile boolean wPA;
  private volatile boolean wPB;
  private View.OnClickListener wPC;
  
  static
  {
    AppMethodBeat.i(26925);
    mOp = aj.getContext().getResources().getDisplayMetrics();
    mTw = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 15);
    mTx = aj.getResources().getDimensionPixelSize(2131165514);
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
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(mTx + mTw, mTx));
    localImageView.setPadding(0, 0, mTw, 0);
    this.mTt.addView(localImageView);
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
      com.tencent.mm.modelappbrand.a.b.aDV().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
    }
    if (paramTextView != null) {
      paramTextView.setText(bt.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(26924);
  }
  
  private void bfF()
  {
    AppMethodBeat.i(26921);
    if ((!this.wPA) || (this.mTq == null))
    {
      AppMethodBeat.o(26921);
      return;
    }
    if (!this.wPB)
    {
      AppMethodBeat.o(26921);
      return;
    }
    this.wPB = false;
    if (!this.mTq.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.mTq.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.kAX, this.lCL);
      }
      this.mTs.setText(this.mContext.getString(2131757588, new Object[] { Integer.valueOf(this.mTq.size()) }));
      eN(this.mTq);
      if (this.mTq.size() == 1)
      {
        this.mTr.setVisibility(0);
        this.mTu.setTag(((WxaAttributes.WxaEntryInfo)this.mTq.get(0)).username);
        this.mTu.setOnClickListener(this.qkD);
        AppMethodBeat.o(26921);
        return;
      }
      this.mTr.setVisibility(8);
      this.mTu.setTag(null);
      this.mTu.setOnClickListener(this.wPC);
      AppMethodBeat.o(26921);
      return;
    }
  }
  
  private void eN(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26922);
    this.mTt.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(26922);
      return;
    }
    int k = paramList.size();
    int j = this.mTu.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = mOp.widthPixels;
    }
    j = i - this.mTu.getPaddingLeft() - this.mTu.getPaddingRight();
    i = j / (mTx + mTw);
    if (i > k) {
      this.mTv.setVisibility(8);
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
      this.mTv.setVisibility(0);
      i = (j - this.mTv.getMeasuredWidth()) / (mTx + mTw);
    }
    ad.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(26922);
  }
  
  private void init()
  {
    AppMethodBeat.i(26920);
    this.qkD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26914);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26914);
          return;
        }
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).dkh = BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username;
        ((o)com.tencent.mm.kernel.g.ab(o.class)).a(BizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26914);
      }
    };
    this.wPC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26915);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ((q)com.tencent.mm.kernel.g.ab(q.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId, BizBindWxaInfoPreference.b(BizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26915);
      }
    };
    AppMethodBeat.o(26920);
  }
  
  public final void a(c paramc, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26919);
    this.wPB = true;
    this.jrM = paramc;
    if (this.mTq == null) {
      this.mTq = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.mTq.addAll(paramList);
      }
      bfF();
      AppMethodBeat.o(26919);
      return;
      this.mTq.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26918);
    this.mTr = paramView.findViewById(2131300108);
    this.kAX = ((ImageView)paramView.findViewById(2131300882));
    this.lCL = ((TextView)paramView.findViewById(2131305906));
    this.mTs = ((TextView)paramView.findViewById(2131298797));
    this.mTv = paramView.findViewById(2131302454);
    this.mTt = ((LinearLayout)paramView.findViewById(2131298737));
    this.mTu = ((ViewGroup)paramView.findViewById(2131301138));
    this.wPA = true;
    if (this.mTq != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.wPB = bool;
      bfF();
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