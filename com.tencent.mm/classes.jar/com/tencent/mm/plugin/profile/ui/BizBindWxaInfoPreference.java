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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics rii;
  private static int rol;
  private static int rom;
  private volatile boolean GWW;
  private volatile boolean GWX;
  private View.OnClickListener GWY;
  private c nkB;
  private ImageView oFa;
  private TextView pPT;
  private List<WxaAttributes.WxaEntryInfo> rof;
  private View rog;
  private TextView roh;
  private LinearLayout roi;
  private ViewGroup roj;
  private View rok;
  private View.OnClickListener vol;
  
  static
  {
    AppMethodBeat.i(26925);
    rii = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    rol = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 15);
    rom = MMApplicationContext.getResources().getDimensionPixelSize(R.f.NormalIconSize);
    AppMethodBeat.o(26925);
  }
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26917);
    init();
    AppMethodBeat.o(26917);
  }
  
  public BizBindWxaInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(26916);
    init();
    AppMethodBeat.o(26916);
  }
  
  private void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo)
  {
    AppMethodBeat.i(26923);
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(rom + rol, rom));
    localImageView.setPadding(0, 0, rol, 0);
    this.roi.addView(localImageView);
    a(paramWxaEntryInfo, localImageView, null);
    AppMethodBeat.o(26923);
  }
  
  private static void a(WxaAttributes.WxaEntryInfo paramWxaEntryInfo, ImageView paramImageView, TextView paramTextView)
  {
    AppMethodBeat.i(26924);
    if (paramWxaEntryInfo == null)
    {
      AppMethodBeat.o(26924);
      return;
    }
    String str = paramWxaEntryInfo.username;
    if (paramImageView != null)
    {
      paramImageView.setTag(str);
      com.tencent.mm.modelappbrand.a.b.bhh().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.bhg(), g.lzF);
    }
    if (paramTextView != null) {
      paramTextView.setText(Util.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(26924);
  }
  
  private void bNc()
  {
    AppMethodBeat.i(26921);
    if ((!this.GWW) || (this.rof == null))
    {
      AppMethodBeat.o(26921);
      return;
    }
    if (!this.GWX)
    {
      AppMethodBeat.o(26921);
      return;
    }
    this.GWX = false;
    if (!this.rof.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.rof.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.oFa, this.pPT);
      }
      this.roh.setText(this.mContext.getString(R.l.contact_info_bind_weapp_count, new Object[] { Integer.valueOf(this.rof.size()) }));
      gu(this.rof);
      if (this.rof.size() == 1)
      {
        this.rog.setVisibility(0);
        this.roj.setTag(((WxaAttributes.WxaEntryInfo)this.rof.get(0)).username);
        this.roj.setOnClickListener(this.vol);
        AppMethodBeat.o(26921);
        return;
      }
      this.rog.setVisibility(8);
      this.roj.setTag(null);
      this.roj.setOnClickListener(this.GWY);
      AppMethodBeat.o(26921);
      return;
    }
  }
  
  private void gu(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26922);
    this.roi.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(26922);
      return;
    }
    int k = paramList.size();
    int j = this.roj.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = rii.widthPixels;
    }
    j = i - this.roj.getPaddingLeft() - this.roj.getPaddingRight();
    i = j / (rom + rol);
    if (i > k) {
      this.rok.setVisibility(8);
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
      this.rok.setVisibility(0);
      i = (j - this.rok.getMeasuredWidth()) / (rom + rol);
    }
    Log.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(26922);
  }
  
  private void init()
  {
    AppMethodBeat.i(26920);
    this.vol = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26914);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26914);
          return;
        }
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).fvd = BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username;
        ((r)h.ae(r.class)).a(BizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26914);
      }
    };
    this.GWY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26915);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        ((t)h.ae(t.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId, BizBindWxaInfoPreference.b(BizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26915);
      }
    };
    AppMethodBeat.o(26920);
  }
  
  public final void a(c paramc, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26919);
    this.GWX = true;
    this.nkB = paramc;
    if (this.rof == null) {
      this.rof = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.rof.addAll(paramList);
      }
      bNc();
      AppMethodBeat.o(26919);
      return;
      this.rof.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26918);
    this.rog = paramView.findViewById(R.h.firstItemV);
    this.oFa = ((ImageView)paramView.findViewById(R.h.iconIv));
    this.pPT = ((TextView)paramView.findViewById(R.h.titleTv));
    this.roh = ((TextView)paramView.findViewById(R.h.countTv));
    this.rok = paramView.findViewById(R.h.moreV);
    this.roi = ((LinearLayout)paramView.findViewById(R.h.containerV));
    this.roj = ((ViewGroup)paramView.findViewById(R.h.itemContainerV));
    this.GWW = true;
    if (this.rof != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.GWX = bool;
      bNc();
      super.onBindView(paramView);
      AppMethodBeat.o(26918);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */