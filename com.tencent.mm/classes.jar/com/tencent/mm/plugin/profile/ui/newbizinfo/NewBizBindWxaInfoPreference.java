package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference
  extends Preference
{
  private static final int fye;
  private static final int fyf;
  private static final int fyg;
  private static int fyh;
  private Context context;
  private b.h fyd;
  private View lLA;
  private boolean lLB;
  private AppBrandNearbyShowcaseView lLz;
  private List<WxaAttributes.WxaEntryInfo> lQH;
  private ThreeDotsLoadingView luZ;
  private View mView;
  private View.OnClickListener pdN;
  private View.OnClickListener uzC;
  private c uzN;
  
  static
  {
    AppMethodBeat.i(27491);
    fye = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 25);
    fyf = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 20);
    fyg = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 2);
    fyh = -1;
    AppMethodBeat.o(27491);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27482);
    this.mView = null;
    this.lLB = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27482);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27483);
    this.mView = null;
    this.lLB = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27483);
  }
  
  private void aVd()
  {
    AppMethodBeat.i(27488);
    if ((this.uzN == null) || (this.lQH == null))
    {
      ad.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      AppMethodBeat.o(27488);
      return;
    }
    this.luZ.ffc();
    cJ(this.luZ);
    if (this.lQH.size() > 0)
    {
      this.lLz.setVisibility(0);
      this.lLz.setIconLayerCount(Math.min(this.lQH.size(), 4));
      final boolean bool;
      int i;
      label141:
      b localb;
      ImageView localImageView;
      if (this.lLA.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.lLz.bqR();
        }
        if (this.fyd == null) {
          this.fyd = new com.tencent.mm.plugin.appbrand.ui.widget.a(fye, fyg, fyh);
        }
        i = 0;
        if (i >= this.lLz.getChildCount()) {
          break label230;
        }
        localb = b.aub();
        localImageView = this.lLz.us(i);
        if (this.lQH.size() <= i) {
          break label225;
        }
      }
      label225:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.lQH.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.aua(), this.fyd);
        i += 1;
        break label141;
        bool = false;
        break;
      }
      label230:
      c(this.lLA, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27480);
          if ((bool) && (NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this) != null)) {
            NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this).hm(true);
          }
          AppMethodBeat.o(27480);
        }
      });
      if (this.lQH.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.lQH.get(0)).username);
        this.mView.setOnClickListener(this.pdN);
        AppMethodBeat.o(27488);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.uzC);
      AppMethodBeat.o(27488);
      return;
    }
    this.lLz.setVisibility(8);
    AppMethodBeat.o(27488);
  }
  
  private static void c(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(27489);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
    AppMethodBeat.o(27489);
  }
  
  private void cJ(final View paramView)
  {
    AppMethodBeat.i(27490);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27481);
          paramView.setVisibility(8);
          AppMethodBeat.o(27481);
        }
      }).start();
    }
    AppMethodBeat.o(27490);
  }
  
  private void init()
  {
    AppMethodBeat.i(27484);
    this.pdN = new NewBizBindWxaInfoPreference.1(this);
    this.uzC = new NewBizBindWxaInfoPreference.2(this);
    fyh = this.context.getResources().getColor(2131100498);
    AppMethodBeat.o(27484);
  }
  
  private void pY()
  {
    AppMethodBeat.i(27487);
    if (this.luZ == null)
    {
      ad.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      AppMethodBeat.o(27487);
      return;
    }
    if (this.lLB)
    {
      ad.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      AppMethodBeat.o(27487);
      return;
    }
    this.lLB = true;
    cJ(this.lLA);
    c(this.luZ, null);
    this.luZ.ffb();
    aVd();
    AppMethodBeat.o(27487);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27485);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(27485);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27486);
    super.onBindView(paramView);
    this.lLA = paramView.findViewById(2131302723);
    this.luZ = ((ThreeDotsLoadingView)paramView.findViewById(2131302725));
    this.lLz = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131302724));
    this.lLz.setIconSize(fye + fyg * 2);
    this.lLz.setIconGap(fyf);
    pY();
    AppMethodBeat.o(27486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */