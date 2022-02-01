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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics mnN;
  private static int msQ;
  private static int msR;
  private c iYD;
  private ImageView kgj;
  private TextView lfN;
  private List<WxaAttributes.WxaEntryInfo> msK;
  private View msL;
  private TextView msM;
  private LinearLayout msN;
  private ViewGroup msO;
  private View msP;
  private View.OnClickListener pGY;
  private volatile boolean vIt;
  private volatile boolean vIu;
  private View.OnClickListener vIv;
  
  static
  {
    AppMethodBeat.i(26925);
    mnN = ai.getContext().getResources().getDisplayMetrics();
    msQ = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 15);
    msR = ai.getResources().getDimensionPixelSize(2131165514);
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
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(msR + msQ, msR));
    localImageView.setPadding(0, 0, msQ, 0);
    this.msN.addView(localImageView);
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
      b.aAS().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
    }
    if (paramTextView != null) {
      paramTextView.setText(bs.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(26924);
  }
  
  private void bcb()
  {
    AppMethodBeat.i(26921);
    if ((!this.vIt) || (this.msK == null))
    {
      AppMethodBeat.o(26921);
      return;
    }
    if (!this.vIu)
    {
      AppMethodBeat.o(26921);
      return;
    }
    this.vIu = false;
    if (!this.msK.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.msK.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.kgj, this.lfN);
      }
      this.msM.setText(this.mContext.getString(2131757588, new Object[] { Integer.valueOf(this.msK.size()) }));
      eA(this.msK);
      if (this.msK.size() == 1)
      {
        this.msL.setVisibility(0);
        this.msO.setTag(((WxaAttributes.WxaEntryInfo)this.msK.get(0)).username);
        this.msO.setOnClickListener(this.pGY);
        AppMethodBeat.o(26921);
        return;
      }
      this.msL.setVisibility(8);
      this.msO.setTag(null);
      this.msO.setOnClickListener(this.vIv);
      AppMethodBeat.o(26921);
      return;
    }
  }
  
  private void eA(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26922);
    this.msN.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(26922);
      return;
    }
    int k = paramList.size();
    int j = this.msO.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = mnN.widthPixels;
    }
    j = i - this.msO.getPaddingLeft() - this.msO.getPaddingRight();
    i = j / (msR + msQ);
    if (i > k) {
      this.msP.setVisibility(8);
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
      this.msP.setVisibility(0);
      i = (j - this.msP.getMeasuredWidth()) / (msR + msQ);
    }
    ac.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(26922);
  }
  
  private void init()
  {
    AppMethodBeat.i(26920);
    this.pGY = new View.OnClickListener()
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
        localAppBrandStatObject.cYP = BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username;
        ((n)com.tencent.mm.kernel.g.ab(n.class)).a(BizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, localAppBrandStatObject, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId);
        AppMethodBeat.o(26914);
      }
    };
    this.vIv = new View.OnClickListener()
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
    this.vIu = true;
    this.iYD = paramc;
    if (this.msK == null) {
      this.msK = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.msK.addAll(paramList);
      }
      bcb();
      AppMethodBeat.o(26919);
      return;
      this.msK.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26918);
    this.msL = paramView.findViewById(2131300108);
    this.kgj = ((ImageView)paramView.findViewById(2131300882));
    this.lfN = ((TextView)paramView.findViewById(2131305906));
    this.msM = ((TextView)paramView.findViewById(2131298797));
    this.msP = paramView.findViewById(2131302454);
    this.msN = ((LinearLayout)paramView.findViewById(2131298737));
    this.msO = ((ViewGroup)paramView.findViewById(2131301138));
    this.vIt = true;
    if (this.msK != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.vIu = bool;
      bcb();
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