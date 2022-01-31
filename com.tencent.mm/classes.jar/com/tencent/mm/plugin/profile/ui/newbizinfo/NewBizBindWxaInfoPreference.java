package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.service.l;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference
  extends Preference
{
  private static final int eln;
  private static final int elo;
  private static final int elp;
  private Context context;
  private b.f elm;
  private ThreeDotsLoadingView iJJ;
  private AppBrandNearbyShowcaseView iSt;
  private View iXf;
  private boolean iXg;
  private List<WxaAttributes.WxaEntryInfo> jaN;
  private View.OnClickListener lNc;
  private View mView;
  private View.OnClickListener pxS;
  private d pyd;
  
  static
  {
    AppMethodBeat.i(23841);
    eln = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 25);
    elo = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 20);
    elp = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 2);
    AppMethodBeat.o(23841);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23831);
    this.mView = null;
    this.iXg = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(23831);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23832);
    this.mView = null;
    this.iXg = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(23832);
  }
  
  private void azw()
  {
    AppMethodBeat.i(23838);
    if ((this.pyd == null) || (this.jaN == null))
    {
      ab.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      AppMethodBeat.o(23838);
      return;
    }
    this.iJJ.dOW();
    cx(this.iJJ);
    if (this.jaN.size() > 0)
    {
      this.iSt.setVisibility(0);
      this.iSt.setIconLayerCount(Math.min(this.jaN.size(), 4));
      final boolean bool;
      int i;
      label139:
      b localb;
      ImageView localImageView;
      if (this.iXf.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.iSt.fa(false);
        }
        if (this.elm == null) {
          this.elm = new com.tencent.mm.plugin.appbrand.ui.widget.a(eln, elp);
        }
        i = 0;
        if (i >= this.iSt.getChildCount()) {
          break label228;
        }
        localb = b.acD();
        localImageView = this.iSt.pU(i);
        if (this.jaN.size() <= i) {
          break label223;
        }
      }
      label223:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.jaN.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.acC(), this.elm);
        i += 1;
        break label139;
        bool = false;
        break;
      }
      label228:
      c(this.iXf, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23829);
          if ((bool) && (NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this) != null)) {
            NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this).aOx();
          }
          AppMethodBeat.o(23829);
        }
      });
      if (this.jaN.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.jaN.get(0)).username);
        this.mView.setOnClickListener(this.lNc);
        AppMethodBeat.o(23838);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.pxS);
      AppMethodBeat.o(23838);
      return;
    }
    this.iSt.setVisibility(8);
    AppMethodBeat.o(23838);
  }
  
  private static void c(View paramView, Runnable paramRunnable)
  {
    AppMethodBeat.i(23839);
    if (paramView.getVisibility() != 0)
    {
      paramView.setAlpha(0.0F);
      paramView.setVisibility(0);
    }
    paramView.animate().setDuration(200L).alpha(1.0F).withEndAction(paramRunnable).start();
    AppMethodBeat.o(23839);
  }
  
  private void cx(View paramView)
  {
    AppMethodBeat.i(23840);
    if (paramView.getVisibility() == 0) {
      paramView.animate().setDuration(200L).alpha(0.0F).withEndAction(new NewBizBindWxaInfoPreference.4(this, paramView)).start();
    }
    AppMethodBeat.o(23840);
  }
  
  private void init()
  {
    AppMethodBeat.i(23833);
    this.lNc = new NewBizBindWxaInfoPreference.1(this);
    this.pxS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(23828);
        ((l)g.E(l.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId, NewBizBindWxaInfoPreference.b(NewBizBindWxaInfoPreference.this));
        AppMethodBeat.o(23828);
      }
    };
    AppMethodBeat.o(23833);
  }
  
  private void lo()
  {
    AppMethodBeat.i(23837);
    if (this.iJJ == null)
    {
      ab.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      AppMethodBeat.o(23837);
      return;
    }
    if (this.iXg)
    {
      ab.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      AppMethodBeat.o(23837);
      return;
    }
    this.iXg = true;
    cx(this.iXf);
    c(this.iJJ, null);
    this.iJJ.dOV();
    azw();
    AppMethodBeat.o(23837);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23834);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(23834);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23835);
    super.onBindView(paramView);
    this.iXf = paramView.findViewById(2131823043);
    this.iJJ = ((ThreeDotsLoadingView)paramView.findViewById(2131823045));
    this.iSt = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131823044));
    this.iSt.setIconSize(eln + elp * 2);
    this.iSt.setIconGap(elo);
    lo();
    AppMethodBeat.o(23835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */