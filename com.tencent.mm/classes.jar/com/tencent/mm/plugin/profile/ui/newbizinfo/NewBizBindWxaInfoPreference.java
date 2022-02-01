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
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference
  extends Preference
{
  private static final int fUY;
  private static final int fUZ;
  private static final int fVa;
  private static int fVb;
  private Context context;
  private b.h fUX;
  private AppBrandNearbyShowcaseView mNY;
  private View mNZ;
  private boolean mOa;
  private List<WxaAttributes.WxaEntryInfo> mTq;
  private View mView;
  private ThreeDotsLoadingView mwI;
  private View.OnClickListener qkD;
  private View.OnClickListener wPC;
  private com.tencent.mm.api.c wPN;
  
  static
  {
    AppMethodBeat.i(27491);
    fUY = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 25);
    fUZ = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 20);
    fVa = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 2);
    fVb = -1;
    AppMethodBeat.o(27491);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27482);
    this.mView = null;
    this.mOa = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27482);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27483);
    this.mView = null;
    this.mOa = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27483);
  }
  
  private void bfF()
  {
    AppMethodBeat.i(27488);
    if ((this.wPN == null) || (this.mTq == null))
    {
      ad.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      AppMethodBeat.o(27488);
      return;
    }
    this.mwI.fLK();
    cN(this.mwI);
    if (this.mTq.size() > 0)
    {
      this.mNY.setVisibility(0);
      this.mNY.setIconLayerCount(Math.min(this.mTq.size(), 4));
      final boolean bool;
      int i;
      label141:
      com.tencent.mm.modelappbrand.a.b localb;
      ImageView localImageView;
      if (this.mNZ.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.mNY.bBW();
        }
        if (this.fUX == null) {
          this.fUX = new com.tencent.mm.plugin.appbrand.ui.widget.a(fUY, fVa, fVb);
        }
        i = 0;
        if (i >= this.mNY.getChildCount()) {
          break label230;
        }
        localb = com.tencent.mm.modelappbrand.a.b.aDV();
        localImageView = this.mNY.vQ(i);
        if (this.mTq.size() <= i) {
          break label225;
        }
      }
      label225:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.mTq.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.aDU(), this.fUX);
        i += 1;
        break label141;
        bool = false;
        break;
      }
      label230:
      f(this.mNZ, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27480);
          if ((bool) && (NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this) != null)) {
            NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this).bBX();
          }
          AppMethodBeat.o(27480);
        }
      });
      if (this.mTq.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.mTq.get(0)).username);
        this.mView.setOnClickListener(this.qkD);
        AppMethodBeat.o(27488);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.wPC);
      AppMethodBeat.o(27488);
      return;
    }
    this.mNY.setVisibility(8);
    AppMethodBeat.o(27488);
  }
  
  private void cN(final View paramView)
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
  
  private static void f(View paramView, Runnable paramRunnable)
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
    this.qkD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27478);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          ad.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27478);
          return;
        }
        ad.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[] { (String)paramAnonymousView });
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).dkh = NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username;
        ((o)g.ab(o.class)).a(NewBizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.K(NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, 500, 0L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27478);
      }
    };
    this.wPC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27479);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ((q)g.ab(q.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId, NewBizBindWxaInfoPreference.b(NewBizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27479);
      }
    };
    fVb = this.context.getResources().getColor(2131100498);
    AppMethodBeat.o(27484);
  }
  
  private void rG()
  {
    AppMethodBeat.i(27487);
    if (this.mwI == null)
    {
      ad.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      AppMethodBeat.o(27487);
      return;
    }
    if (this.mOa)
    {
      ad.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      AppMethodBeat.o(27487);
      return;
    }
    this.mOa = true;
    cN(this.mNZ);
    f(this.mwI, null);
    this.mwI.fLJ();
    bfF();
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
    this.mNZ = paramView.findViewById(2131302723);
    this.mwI = ((ThreeDotsLoadingView)paramView.findViewById(2131302725));
    this.mNY = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131302724));
    this.mNY.setIconSize(fUY + fVa * 2);
    this.mNY.setIconGap(fUZ);
    rG();
    AppMethodBeat.o(27486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */