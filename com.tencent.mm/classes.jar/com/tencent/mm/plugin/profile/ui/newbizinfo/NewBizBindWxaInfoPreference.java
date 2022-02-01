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
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference
  extends Preference
{
  private static final int fBL;
  private static final int fBM;
  private static final int fBN;
  private static int fBO;
  private Context context;
  private b.h fBK;
  private ThreeDotsLoadingView lWT;
  private View mView;
  private AppBrandNearbyShowcaseView mnw;
  private View mnx;
  private boolean mny;
  private List<WxaAttributes.WxaEntryInfo> msK;
  private View.OnClickListener pGY;
  private com.tencent.mm.api.c vIG;
  private View.OnClickListener vIv;
  
  static
  {
    AppMethodBeat.i(27491);
    fBL = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 25);
    fBM = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 20);
    fBN = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 2);
    fBO = -1;
    AppMethodBeat.o(27491);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27482);
    this.mView = null;
    this.mny = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27482);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27483);
    this.mView = null;
    this.mny = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27483);
  }
  
  private void bcb()
  {
    AppMethodBeat.i(27488);
    if ((this.vIG == null) || (this.msK == null))
    {
      ac.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      AppMethodBeat.o(27488);
      return;
    }
    this.lWT.fuX();
    cL(this.lWT);
    if (this.msK.size() > 0)
    {
      this.mnw.setVisibility(0);
      this.mnw.setIconLayerCount(Math.min(this.msK.size(), 4));
      final boolean bool;
      int i;
      label141:
      b localb;
      ImageView localImageView;
      if (this.mnx.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.mnw.bxR();
        }
        if (this.fBK == null) {
          this.fBK = new com.tencent.mm.plugin.appbrand.ui.widget.a(fBL, fBN, fBO);
        }
        i = 0;
        if (i >= this.mnw.getChildCount()) {
          break label230;
        }
        localb = b.aAS();
        localImageView = this.mnw.vk(i);
        if (this.msK.size() <= i) {
          break label225;
        }
      }
      label225:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.msK.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.aAR(), this.fBK);
        i += 1;
        break label141;
        bool = false;
        break;
      }
      label230:
      e(this.mnx, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27480);
          if ((bool) && (NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this) != null)) {
            NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this).hJ(true);
          }
          AppMethodBeat.o(27480);
        }
      });
      if (this.msK.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.msK.get(0)).username);
        this.mView.setOnClickListener(this.pGY);
        AppMethodBeat.o(27488);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.vIv);
      AppMethodBeat.o(27488);
      return;
    }
    this.mnw.setVisibility(8);
    AppMethodBeat.o(27488);
  }
  
  private void cL(final View paramView)
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
  
  private static void e(View paramView, Runnable paramRunnable)
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
  
  private void init()
  {
    AppMethodBeat.i(27484);
    this.pGY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27478);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          ac.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
          AppMethodBeat.o(27478);
          return;
        }
        ac.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[] { (String)paramAnonymousView });
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.scene = 1020;
        localAppBrandStatObject.cYP = NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username;
        ((n)g.ab(n.class)).a(NewBizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, localAppBrandStatObject, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.bS(NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, 500);
        AppMethodBeat.o(27478);
      }
    };
    this.vIv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27479);
        ((p)g.ab(p.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId, NewBizBindWxaInfoPreference.b(NewBizBindWxaInfoPreference.this));
        AppMethodBeat.o(27479);
      }
    };
    fBO = this.context.getResources().getColor(2131100498);
    AppMethodBeat.o(27484);
  }
  
  private void qi()
  {
    AppMethodBeat.i(27487);
    if (this.lWT == null)
    {
      ac.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      AppMethodBeat.o(27487);
      return;
    }
    if (this.mny)
    {
      ac.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      AppMethodBeat.o(27487);
      return;
    }
    this.mny = true;
    cL(this.mnx);
    e(this.lWT, null);
    this.lWT.fuW();
    bcb();
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
    this.mnx = paramView.findViewById(2131302723);
    this.lWT = ((ThreeDotsLoadingView)paramView.findViewById(2131302725));
    this.mnw = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131302724));
    this.mnw.setIconSize(fBL + fBN * 2);
    this.mnw.setIconGap(fBM);
    qi();
    AppMethodBeat.o(27486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */