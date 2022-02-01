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
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public class NewBizBindWxaInfoPreference
  extends Preference
{
  private static final int jmq;
  private static final int jmr;
  private static final int jms;
  private static int jmt;
  private View.OnClickListener GWY;
  private com.tencent.mm.api.c GXj;
  private Context context;
  private b.h jmp;
  private View mView;
  private ThreeDotsLoadingView qPG;
  private AppBrandNearbyShowcaseView rhQ;
  private View rhR;
  private boolean rhS;
  private List<WxaAttributes.WxaEntryInfo> rof;
  private View.OnClickListener vol;
  
  static
  {
    AppMethodBeat.i(27491);
    jmq = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 25);
    jmr = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 20);
    jms = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    jmt = -1;
    AppMethodBeat.o(27491);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27482);
    this.mView = null;
    this.rhS = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27482);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27483);
    this.mView = null;
    this.rhS = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27483);
  }
  
  private void bNc()
  {
    AppMethodBeat.i(27488);
    if ((this.GXj == null) || (this.rof == null))
    {
      Log.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      AppMethodBeat.o(27488);
      return;
    }
    this.qPG.hZY();
    db(this.qPG);
    if (this.rof.size() > 0)
    {
      this.rhQ.setVisibility(0);
      this.rhQ.setIconLayerCount(Math.min(this.rof.size(), 4));
      final boolean bool;
      int i;
      label141:
      com.tencent.mm.modelappbrand.a.b localb;
      ImageView localImageView;
      if (this.rhR.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.rhQ.cmQ();
        }
        if (this.jmp == null) {
          this.jmp = new com.tencent.mm.plugin.appbrand.ui.widget.a(jmq, jms, jmt);
        }
        i = 0;
        if (i >= this.rhQ.getChildCount()) {
          break label230;
        }
        localb = com.tencent.mm.modelappbrand.a.b.bhh();
        localImageView = this.rhQ.Dt(i);
        if (this.rof.size() <= i) {
          break label225;
        }
      }
      label225:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.rof.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.bhg(), this.jmp);
        i += 1;
        break label141;
        bool = false;
        break;
      }
      label230:
      g(this.rhR, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27480);
          if ((bool) && (NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this) != null)) {
            NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this).cmR();
          }
          AppMethodBeat.o(27480);
        }
      });
      if (this.rof.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.rof.get(0)).username);
        this.mView.setOnClickListener(this.vol);
        AppMethodBeat.o(27488);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.GWY);
      AppMethodBeat.o(27488);
      return;
    }
    this.rhQ.setVisibility(8);
    AppMethodBeat.o(27488);
  }
  
  private void db(final View paramView)
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
  
  private static void g(View paramView, Runnable paramRunnable)
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
    this.vol = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27478);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          Log.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27478);
          return;
        }
        Log.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", new Object[] { (String)paramAnonymousView });
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).fvd = NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username;
        ((r)h.ae(r.class)).a(NewBizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.J(NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, 500, 0L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27478);
      }
    };
    this.GWY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27479);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((t)h.ae(t.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId, NewBizBindWxaInfoPreference.b(NewBizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27479);
      }
    };
    jmt = this.context.getResources().getColor(R.e.icon_border_color);
    AppMethodBeat.o(27484);
  }
  
  private void px()
  {
    AppMethodBeat.i(27487);
    if (this.qPG == null)
    {
      Log.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      AppMethodBeat.o(27487);
      return;
    }
    if (this.rhS)
    {
      Log.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      AppMethodBeat.o(27487);
      return;
    }
    this.rhS = true;
    db(this.rhR);
    g(this.qPG, null);
    this.qPG.hZX();
    bNc();
    AppMethodBeat.o(27487);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    this.rhR = paramView.findViewById(R.h.dNu);
    this.qPG = ((ThreeDotsLoadingView)paramView.findViewById(R.h.dNw));
    this.rhQ = ((AppBrandNearbyShowcaseView)paramView.findViewById(R.h.dNv));
    this.rhQ.setIconSize(jmq + jms * 2);
    this.rhQ.setIconGap(jmr);
    px();
    AppMethodBeat.o(27486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */