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
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference
  extends Preference
{
  private static final int fXe;
  private static final int fXf;
  private static final int fXg;
  private static int fXh;
  private Context context;
  private b.h fXd;
  private ThreeDotsLoadingView mBF;
  private AppBrandNearbyShowcaseView mTc;
  private View mTd;
  private boolean mTe;
  private View mView;
  private List<WxaAttributes.WxaEntryInfo> mYy;
  private View.OnClickListener qri;
  private com.tencent.mm.api.c xfE;
  private View.OnClickListener xft;
  
  static
  {
    AppMethodBeat.i(27491);
    fXe = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 25);
    fXf = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 20);
    fXg = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 2);
    fXh = -1;
    AppMethodBeat.o(27491);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27482);
    this.mView = null;
    this.mTe = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27482);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27483);
    this.mView = null;
    this.mTe = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27483);
  }
  
  private void bgn()
  {
    AppMethodBeat.i(27488);
    if ((this.xfE == null) || (this.mYy == null))
    {
      ae.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      AppMethodBeat.o(27488);
      return;
    }
    this.mBF.fQe();
    cO(this.mBF);
    if (this.mYy.size() > 0)
    {
      this.mTc.setVisibility(0);
      this.mTc.setIconLayerCount(Math.min(this.mYy.size(), 4));
      final boolean bool;
      int i;
      label141:
      com.tencent.mm.modelappbrand.a.b localb;
      ImageView localImageView;
      if (this.mTd.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.mTc.bCQ();
        }
        if (this.fXd == null) {
          this.fXd = new com.tencent.mm.plugin.appbrand.ui.widget.a(fXe, fXg, fXh);
        }
        i = 0;
        if (i >= this.mTc.getChildCount()) {
          break label230;
        }
        localb = com.tencent.mm.modelappbrand.a.b.aEl();
        localImageView = this.mTc.vV(i);
        if (this.mYy.size() <= i) {
          break label225;
        }
      }
      label225:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.mYy.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.aEk(), this.fXd);
        i += 1;
        break label141;
        bool = false;
        break;
      }
      label230:
      f(this.mTd, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27480);
          if ((bool) && (NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this) != null)) {
            NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this).bCR();
          }
          AppMethodBeat.o(27480);
        }
      });
      if (this.mYy.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.mYy.get(0)).username);
        this.mView.setOnClickListener(this.qri);
        AppMethodBeat.o(27488);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.xft);
      AppMethodBeat.o(27488);
      return;
    }
    this.mTc.setVisibility(8);
    AppMethodBeat.o(27488);
  }
  
  private void cO(final View paramView)
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
    this.qri = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27478);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          ae.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27478);
          return;
        }
        ae.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[] { (String)paramAnonymousView });
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).dlj = NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username;
        ((p)g.ab(p.class)).a(NewBizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, 500, 0L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27478);
      }
    };
    this.xft = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27479);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ((r)g.ab(r.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId, NewBizBindWxaInfoPreference.b(NewBizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27479);
      }
    };
    fXh = this.context.getResources().getColor(2131100498);
    AppMethodBeat.o(27484);
  }
  
  private void rG()
  {
    AppMethodBeat.i(27487);
    if (this.mBF == null)
    {
      ae.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      AppMethodBeat.o(27487);
      return;
    }
    if (this.mTe)
    {
      ae.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      AppMethodBeat.o(27487);
      return;
    }
    this.mTe = true;
    cO(this.mTd);
    f(this.mBF, null);
    this.mBF.fQd();
    bgn();
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
    this.mTd = paramView.findViewById(2131302723);
    this.mBF = ((ThreeDotsLoadingView)paramView.findViewById(2131302725));
    this.mTc = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131302724));
    this.mTc.setIconSize(fXe + fXg * 2);
    this.mTc.setIconGap(fXf);
    rG();
    AppMethodBeat.o(27486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */