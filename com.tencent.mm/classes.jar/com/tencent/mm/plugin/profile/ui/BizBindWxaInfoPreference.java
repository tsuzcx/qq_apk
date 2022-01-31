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
import com.tencent.mm.aj.d;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics iXq;
  private static int jaT;
  private static int jaU;
  private d gKR;
  private ImageView iCl;
  private TextView iJG;
  private List<WxaAttributes.WxaEntryInfo> jaN;
  private View jaO;
  private TextView jaP;
  private LinearLayout jaQ;
  private ViewGroup jaR;
  private View jaS;
  private View.OnClickListener lNc;
  private volatile boolean pxQ;
  private volatile boolean pxR;
  private View.OnClickListener pxS;
  
  static
  {
    AppMethodBeat.i(23305);
    iXq = ah.getContext().getResources().getDisplayMetrics();
    jaT = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 15);
    jaU = ah.getResources().getDimensionPixelSize(2131427806);
    AppMethodBeat.o(23305);
  }
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23297);
    init();
    AppMethodBeat.o(23297);
  }
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23296);
    init();
    AppMethodBeat.o(23296);
  }
  
  private void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo)
  {
    AppMethodBeat.i(23303);
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(jaU + jaT, jaU));
    localImageView.setPadding(0, 0, jaT, 0);
    this.jaQ.addView(localImageView);
    a(paramWxaEntryInfo, localImageView, null);
    AppMethodBeat.o(23303);
  }
  
  private static void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo, ImageView paramImageView, TextView paramTextView)
  {
    AppMethodBeat.i(23304);
    if (paramWxaEntryInfo == null)
    {
      AppMethodBeat.o(23304);
      return;
    }
    String str = paramWxaEntryInfo.username;
    if (paramImageView != null)
    {
      paramImageView.setTag(str);
      b.acD().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.acC(), f.fqU);
    }
    if (paramTextView != null) {
      paramTextView.setText(bo.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(23304);
  }
  
  private void azw()
  {
    AppMethodBeat.i(23301);
    if ((!this.pxQ) || (this.jaN == null))
    {
      AppMethodBeat.o(23301);
      return;
    }
    if (!this.pxR)
    {
      AppMethodBeat.o(23301);
      return;
    }
    this.pxR = false;
    if (!this.jaN.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.jaN.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.iCl, this.iJG);
      }
      this.jaP.setText(this.mContext.getString(2131298529, new Object[] { Integer.valueOf(this.jaN.size()) }));
      cz(this.jaN);
      if (this.jaN.size() == 1)
      {
        this.jaO.setVisibility(0);
        this.jaR.setTag(((WxaAttributes.WxaEntryInfo)this.jaN.get(0)).username);
        this.jaR.setOnClickListener(this.lNc);
        AppMethodBeat.o(23301);
        return;
      }
      this.jaO.setVisibility(8);
      this.jaR.setTag(null);
      this.jaR.setOnClickListener(this.pxS);
      AppMethodBeat.o(23301);
      return;
    }
  }
  
  private void cz(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(23302);
    this.jaQ.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(23302);
      return;
    }
    int k = paramList.size();
    int j = this.jaR.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = iXq.widthPixels;
    }
    j = i - this.jaR.getPaddingLeft() - this.jaR.getPaddingRight();
    i = j / (jaU + jaT);
    if (i > k) {
      this.jaS.setVisibility(8);
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
      this.jaS.setVisibility(0);
      i = (j - this.jaS.getMeasuredWidth()) / (jaU + jaT);
    }
    ab.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(23302);
  }
  
  private void init()
  {
    AppMethodBeat.i(23300);
    this.lNc = new BizBindWxaInfoPreference.1(this);
    this.pxS = new BizBindWxaInfoPreference.2(this);
    AppMethodBeat.o(23300);
  }
  
  public final void a(d paramd, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(23299);
    this.pxR = true;
    this.gKR = paramd;
    if (this.jaN == null) {
      this.jaN = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jaN.addAll(paramList);
      }
      azw();
      AppMethodBeat.o(23299);
      return;
      this.jaN.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23298);
    this.jaO = paramView.findViewById(2131821333);
    this.iCl = ((ImageView)paramView.findViewById(2131821334));
    this.iJG = ((TextView)paramView.findViewById(2131821335));
    this.jaP = ((TextView)paramView.findViewById(2131821338));
    this.jaS = paramView.findViewById(2131821337);
    this.jaQ = ((LinearLayout)paramView.findViewById(2131821336));
    this.jaR = ((ViewGroup)paramView.findViewById(2131821332));
    this.pxQ = true;
    if (this.jaN != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.pxR = bool;
      azw();
      super.onBindView(paramView);
      AppMethodBeat.o(23298);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */