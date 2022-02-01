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
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics lLQ;
  private static int lQN;
  private static int lQO;
  private c iyA;
  private ImageView jFL;
  private TextView kEu;
  private List<WxaAttributes.WxaEntryInfo> lQH;
  private View lQI;
  private TextView lQJ;
  private LinearLayout lQK;
  private ViewGroup lQL;
  private View lQM;
  private View.OnClickListener pdN;
  private volatile boolean uzA;
  private volatile boolean uzB;
  private View.OnClickListener uzC;
  
  static
  {
    AppMethodBeat.i(26925);
    lLQ = aj.getContext().getResources().getDisplayMetrics();
    lQN = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 15);
    lQO = aj.getResources().getDimensionPixelSize(2131165514);
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
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(lQO + lQN, lQO));
    localImageView.setPadding(0, 0, lQN, 0);
    this.lQK.addView(localImageView);
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
      b.aub().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
    }
    if (paramTextView != null) {
      paramTextView.setText(bt.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(26924);
  }
  
  private void aVd()
  {
    AppMethodBeat.i(26921);
    if ((!this.uzA) || (this.lQH == null))
    {
      AppMethodBeat.o(26921);
      return;
    }
    if (!this.uzB)
    {
      AppMethodBeat.o(26921);
      return;
    }
    this.uzB = false;
    if (!this.lQH.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.lQH.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.jFL, this.kEu);
      }
      this.lQJ.setText(this.mContext.getString(2131757588, new Object[] { Integer.valueOf(this.lQH.size()) }));
      ew(this.lQH);
      if (this.lQH.size() == 1)
      {
        this.lQI.setVisibility(0);
        this.lQL.setTag(((WxaAttributes.WxaEntryInfo)this.lQH.get(0)).username);
        this.lQL.setOnClickListener(this.pdN);
        AppMethodBeat.o(26921);
        return;
      }
      this.lQI.setVisibility(8);
      this.lQL.setTag(null);
      this.lQL.setOnClickListener(this.uzC);
      AppMethodBeat.o(26921);
      return;
    }
  }
  
  private void ew(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26922);
    this.lQK.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(26922);
      return;
    }
    int k = paramList.size();
    int j = this.lQL.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = lLQ.widthPixels;
    }
    j = i - this.lQL.getPaddingLeft() - this.lQL.getPaddingRight();
    i = j / (lQO + lQN);
    if (i > k) {
      this.lQM.setVisibility(8);
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
      this.lQM.setVisibility(0);
      i = (j - this.lQM.getMeasuredWidth()) / (lQO + lQN);
    }
    ad.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(26922);
  }
  
  private void init()
  {
    AppMethodBeat.i(26920);
    this.pdN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26914);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          AppMethodBeat.o(26914);
          return;
        }
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1020;
        localAppBrandStatObject.dbt = BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username;
        ((n)com.tencent.mm.kernel.g.ab(n.class)).a(BizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, localAppBrandStatObject, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId);
        AppMethodBeat.o(26914);
      }
    };
    this.uzC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26915);
        ((p)com.tencent.mm.kernel.g.ab(p.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId, BizBindWxaInfoPreference.b(BizBindWxaInfoPreference.this));
        AppMethodBeat.o(26915);
      }
    };
    AppMethodBeat.o(26920);
  }
  
  public final void a(c paramc, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26919);
    this.uzB = true;
    this.iyA = paramc;
    if (this.lQH == null) {
      this.lQH = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.lQH.addAll(paramList);
      }
      aVd();
      AppMethodBeat.o(26919);
      return;
      this.lQH.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26918);
    this.lQI = paramView.findViewById(2131300108);
    this.jFL = ((ImageView)paramView.findViewById(2131300882));
    this.kEu = ((TextView)paramView.findViewById(2131305906));
    this.lQJ = ((TextView)paramView.findViewById(2131298797));
    this.lQM = paramView.findViewById(2131302454);
    this.lQK = ((LinearLayout)paramView.findViewById(2131298737));
    this.lQL = ((ViewGroup)paramView.findViewById(2131301138));
    this.uzA = true;
    if (this.lQH != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.uzB = bool;
      aVd();
      super.onBindView(paramView);
      AppMethodBeat.o(26918);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */