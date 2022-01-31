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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.d;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics hkX = ae.getContext().getResources().getDisplayMetrics();
  private static int hop = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 15);
  private static int hoq = ae.getResources().getDimensionPixelSize(R.f.NormalIconSize);
  d ftp;
  private TextView haW;
  List<WxaAttributes.WxaEntryInfo> hoi;
  private View hoj;
  private ImageView hok;
  private TextView hol;
  private LinearLayout hom;
  private ViewGroup hon;
  private View hoo;
  private View.OnClickListener jDE;
  private volatile boolean mVl;
  volatile boolean mVm;
  private View.OnClickListener mVn;
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private static void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo, ImageView paramImageView, TextView paramTextView)
  {
    if (paramWxaEntryInfo == null) {}
    do
    {
      return;
      String str = paramWxaEntryInfo.username;
      if (paramImageView != null)
      {
        paramImageView.setTag(str);
        b.JD().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.JC(), f.eaL);
      }
    } while (paramTextView == null);
    paramTextView.setText(bk.pm(paramWxaEntryInfo.title));
  }
  
  private void init()
  {
    this.jDE = new BizBindWxaInfoPreference.1(this);
    this.mVn = new BizBindWxaInfoPreference.2(this);
  }
  
  final void aeT()
  {
    if ((!this.mVl) || (this.hoi == null)) {}
    while (!this.mVm) {
      return;
    }
    this.mVm = false;
    if (!this.hoi.isEmpty()) {}
    for (Object localObject = (WxaAttributes.WxaEntryInfo)this.hoi.get(0);; localObject = null)
    {
      if (localObject != null) {
        a((WxaAttributes.WxaEntryInfo)localObject, this.hok, this.haW);
      }
      this.hol.setText(this.mContext.getString(R.l.contact_info_bind_weapp_count, new Object[] { Integer.valueOf(this.hoi.size()) }));
      localObject = this.hoi;
      this.hom.removeAllViews();
      if (!((List)localObject).isEmpty())
      {
        int k = ((List)localObject).size();
        int j = this.hon.getMeasuredWidth();
        int i = j;
        if (j == 0) {
          i = hkX.widthPixels;
        }
        j = i - this.hon.getPaddingLeft() - this.hon.getPaddingRight();
        i = j / (hoq + hop);
        if (i > k) {
          this.hoo.setVisibility(8);
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
            WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)((List)localObject).get(i);
            ImageView localImageView = new ImageView(this.mContext);
            localImageView.setLayoutParams(new ViewGroup.LayoutParams(hoq + hop, hoq));
            localImageView.setPadding(0, 0, hop, 0);
            this.hom.addView(localImageView);
            a(localWxaEntryInfo, localImageView, null);
            i += 1;
          }
          this.hoo.setVisibility(0);
          i = (j - this.hoo.getMeasuredWidth()) / (hoq + hop);
        }
        y.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(((List)localObject).size()) });
      }
      if (this.hoi.size() == 1)
      {
        this.hoj.setVisibility(0);
        this.hon.setTag(((WxaAttributes.WxaEntryInfo)this.hoi.get(0)).username);
        this.hon.setOnClickListener(this.jDE);
        return;
      }
      this.hoj.setVisibility(8);
      this.hon.setTag(null);
      this.hon.setOnClickListener(this.mVn);
      return;
    }
  }
  
  protected final void onBindView(View paramView)
  {
    this.hoj = paramView.findViewById(R.h.firstItemV);
    this.hok = ((ImageView)paramView.findViewById(R.h.iconIv));
    this.haW = ((TextView)paramView.findViewById(R.h.titleTv));
    this.hol = ((TextView)paramView.findViewById(R.h.countTv));
    this.hoo = paramView.findViewById(R.h.moreV);
    this.hom = ((LinearLayout)paramView.findViewById(R.h.containerV));
    this.hon = ((ViewGroup)paramView.findViewById(R.h.itemContainerV));
    this.mVl = true;
    if (this.hoi != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mVm = bool;
      aeT();
      super.onBindView(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */