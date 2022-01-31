package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.ai.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.r.f;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference
  extends Preference
{
  private static final int hgL = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 25);
  private static final int hgM = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 20);
  private static final int hgN = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 2);
  private Context context;
  private ThreeDotsLoadingView haZ;
  private AppBrandNearbyShowcaseView hgS;
  private b.f hiS;
  private View hkK;
  private boolean hkL = false;
  List<WxaAttributes.WxaEntryInfo> hoi;
  private View.OnClickListener jDE;
  private View mView = null;
  private View.OnClickListener mVn;
  d mVy;
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    init();
  }
  
  private void bX(View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new NewBizBindWxaInfoPreference.4(this, paramView)).start();
    }
  }
  
  private static void c(View paramView, Runnable paramRunnable)
  {
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
  }
  
  private void init()
  {
    this.jDE = new NewBizBindWxaInfoPreference.1(this);
    this.mVn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        ((f)g.r(f.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId, NewBizBindWxaInfoPreference.b(NewBizBindWxaInfoPreference.this));
      }
    };
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  public final void ju()
  {
    if (this.haZ == null)
    {
      y.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      return;
    }
    if (this.hkL)
    {
      y.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      return;
    }
    this.hkL = true;
    bX(this.hkK);
    c(this.haZ, null);
    this.haZ.cKb();
    if ((this.mVy == null) || (this.hoi == null))
    {
      y.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      return;
    }
    this.haZ.cKc();
    bX(this.haZ);
    if (this.hoi.size() > 0)
    {
      this.hgS.setVisibility(0);
      this.hgS.setIconLayerCount(Math.min(this.hoi.size(), 4));
      boolean bool;
      int i;
      label185:
      b localb;
      ImageView localImageView;
      if (this.hkK.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.hgS.dK(false);
        }
        if (this.hiS == null) {
          this.hiS = new com.tencent.mm.plugin.appbrand.ui.widget.a(hgL, hgN);
        }
        i = 0;
        if (i >= this.hgS.getChildCount()) {
          break label274;
        }
        localb = b.JD();
        localImageView = this.hgS.mB(i);
        if (this.hoi.size() <= i) {
          break label269;
        }
      }
      label269:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.hoi.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.JC(), this.hiS);
        i += 1;
        break label185;
        bool = false;
        break;
      }
      label274:
      c(this.hkK, new NewBizBindWxaInfoPreference.3(this, bool));
      if (this.hoi.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.hoi.get(0)).username);
        this.mView.setOnClickListener(this.jDE);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.mVn);
      return;
    }
    this.hgS.setVisibility(8);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.hkK = paramView.findViewById(R.h.new_bizinfo_loading_icon_layout);
    this.haZ = ((ThreeDotsLoadingView)paramView.findViewById(R.h.new_bizinfo_loading_view));
    this.hgS = ((AppBrandNearbyShowcaseView)paramView.findViewById(R.h.new_bizinfo_loading_icon_view));
    this.hgS.setIconSize(hgL + hgN * 2);
    this.hgS.setIconGap(hgM);
    ju();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */