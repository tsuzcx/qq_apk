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
  private static final int gCk;
  private static final int gCl;
  private static final int gCm;
  private static int gCn;
  private View.OnClickListener BcZ;
  private com.tencent.mm.api.c Bdk;
  private Context context;
  private b.h gCj;
  private View mView;
  private ThreeDotsLoadingView nNl;
  private AppBrandNearbyShowcaseView ogf;
  private View ogg;
  private boolean ogh;
  private List<WxaAttributes.WxaEntryInfo> olD;
  private View.OnClickListener rID;
  
  static
  {
    AppMethodBeat.i(27491);
    gCk = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 25);
    gCl = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 20);
    gCm = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
    gCn = -1;
    AppMethodBeat.o(27491);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27482);
    this.mView = null;
    this.ogh = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27482);
  }
  
  public NewBizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27483);
    this.mView = null;
    this.ogh = false;
    this.context = paramContext;
    init();
    AppMethodBeat.o(27483);
  }
  
  private void bBG()
  {
    AppMethodBeat.i(27488);
    if ((this.Bdk == null) || (this.olD == null))
    {
      Log.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
      AppMethodBeat.o(27488);
      return;
    }
    this.nNl.gZi();
    cH(this.nNl);
    if (this.olD.size() > 0)
    {
      this.ogf.setVisibility(0);
      this.ogf.setIconLayerCount(Math.min(this.olD.size(), 4));
      final boolean bool;
      int i;
      label141:
      com.tencent.mm.modelappbrand.a.b localb;
      ImageView localImageView;
      if (this.ogg.getVisibility() != 0)
      {
        bool = true;
        if (bool) {
          this.ogf.bZV();
        }
        if (this.gCj == null) {
          this.gCj = new com.tencent.mm.plugin.appbrand.ui.widget.a(gCk, gCm, gCn);
        }
        i = 0;
        if (i >= this.ogf.getChildCount()) {
          break label230;
        }
        localb = com.tencent.mm.modelappbrand.a.b.aXY();
        localImageView = this.ogf.zK(i);
        if (this.olD.size() <= i) {
          break label225;
        }
      }
      label225:
      for (String str = ((WxaAttributes.WxaEntryInfo)this.olD.get(i)).iconUrl;; str = null)
      {
        localb.a(localImageView, str, com.tencent.mm.modelappbrand.a.a.aXX(), this.gCj);
        i += 1;
        break label141;
        bool = false;
        break;
      }
      label230:
      g(this.ogg, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27480);
          if ((bool) && (NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this) != null)) {
            NewBizBindWxaInfoPreference.c(NewBizBindWxaInfoPreference.this).bZW();
          }
          AppMethodBeat.o(27480);
        }
      });
      if (this.olD.size() == 1)
      {
        this.mView.setTag(((WxaAttributes.WxaEntryInfo)this.olD.get(0)).username);
        this.mView.setOnClickListener(this.rID);
        AppMethodBeat.o(27488);
        return;
      }
      this.mView.setTag(null);
      this.mView.setOnClickListener(this.BcZ);
      AppMethodBeat.o(27488);
      return;
    }
    this.ogf.setVisibility(8);
    AppMethodBeat.o(27488);
  }
  
  private void cH(final View paramView)
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
    this.rID = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27478);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
        ((AppBrandStatObject)localObject).dCw = NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username;
        ((r)g.af(r.class)).a(NewBizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.I(NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, 500, 0L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27478);
      }
    };
    this.BcZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(27479);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((t)g.af(t.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_username, NewBizBindWxaInfoPreference.a(NewBizBindWxaInfoPreference.this).field_appId, NewBizBindWxaInfoPreference.b(NewBizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/NewBizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(27479);
      }
    };
    gCn = this.context.getResources().getColor(2131100633);
    AppMethodBeat.o(27484);
  }
  
  private void rJ()
  {
    AppMethodBeat.i(27487);
    if (this.nNl == null)
    {
      Log.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
      AppMethodBeat.o(27487);
      return;
    }
    if (this.ogh)
    {
      Log.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
      AppMethodBeat.o(27487);
      return;
    }
    this.ogh = true;
    cH(this.ogg);
    g(this.nNl, null);
    this.nNl.gZh();
    bBG();
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
    this.ogg = paramView.findViewById(2131305290);
    this.nNl = ((ThreeDotsLoadingView)paramView.findViewById(2131305292));
    this.ogf = ((AppBrandNearbyShowcaseView)paramView.findViewById(2131305291));
    this.ogf.setIconSize(gCk + gCm * 2);
    this.ogf.setIconGap(gCl);
    rJ();
    AppMethodBeat.o(27486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */