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
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoPreference
  extends Preference
{
  private static DisplayMetrics uqe;
  private static int uyg;
  private static int uyh;
  private volatile boolean MUP;
  private volatile boolean MUQ;
  private View.OnClickListener MUR;
  private c qhK;
  private ImageView rIe;
  private TextView sUt;
  private List<WxaAttributes.WxaEntryInfo> uya;
  private View uyb;
  private TextView uyc;
  private LinearLayout uyd;
  private ViewGroup uye;
  private View uyf;
  private View.OnClickListener yAH;
  
  static
  {
    AppMethodBeat.i(26925);
    uqe = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    uyg = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 15);
    uyh = MMApplicationContext.getResources().getDimensionPixelSize(R.f.NormalIconSize);
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
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(uyh + uyg, uyh));
    localImageView.setPadding(0, 0, uyg, 0);
    this.uyd.addView(localImageView);
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
      com.tencent.mm.modelappbrand.a.b.bEY().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.bEX(), g.org);
    }
    if (paramTextView != null) {
      paramTextView.setText(Util.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(26924);
  }
  
  private void cnr()
  {
    AppMethodBeat.i(26921);
    if ((!this.MUP) || (this.uya == null))
    {
      AppMethodBeat.o(26921);
      return;
    }
    if (!this.MUQ)
    {
      AppMethodBeat.o(26921);
      return;
    }
    this.MUQ = false;
    if (!this.uya.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.uya.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.rIe, this.sUt);
      }
      this.uyc.setText(this.mContext.getString(R.l.contact_info_bind_weapp_count, new Object[] { Integer.valueOf(this.uya.size()) }));
      ju(this.uya);
      if (this.uya.size() == 1)
      {
        this.uyb.setVisibility(0);
        this.uye.setTag(((WxaAttributes.WxaEntryInfo)this.uya.get(0)).username);
        this.uye.setOnClickListener(this.yAH);
        AppMethodBeat.o(26921);
        return;
      }
      this.uyb.setVisibility(8);
      this.uye.setTag(null);
      this.uye.setOnClickListener(this.MUR);
      AppMethodBeat.o(26921);
      return;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(26920);
    this.yAH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26914);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26914);
          return;
        }
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).hzx = BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username;
        ((t)h.ax(t.class)).a(BizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26914);
      }
    };
    this.MUR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26915);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ((v)h.ax(v.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId, BizBindWxaInfoPreference.b(BizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26915);
      }
    };
    AppMethodBeat.o(26920);
  }
  
  private void ju(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26922);
    this.uyd.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(26922);
      return;
    }
    int k = paramList.size();
    int j = this.uye.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = uqe.widthPixels;
    }
    j = i - this.uye.getPaddingLeft() - this.uye.getPaddingRight();
    i = j / (uyh + uyg);
    if (i > k) {
      this.uyf.setVisibility(8);
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
      this.uyf.setVisibility(0);
      i = (j - this.uyf.getMeasuredWidth()) / (uyh + uyg);
    }
    Log.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(26922);
  }
  
  public final void a(c paramc, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26919);
    this.MUQ = true;
    this.qhK = paramc;
    if (this.uya == null) {
      this.uya = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.uya.addAll(paramList);
      }
      cnr();
      AppMethodBeat.o(26919);
      return;
      this.uya.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26918);
    this.uyb = paramView.findViewById(R.h.firstItemV);
    this.rIe = ((ImageView)paramView.findViewById(R.h.iconIv));
    this.sUt = ((TextView)paramView.findViewById(R.h.titleTv));
    this.uyc = ((TextView)paramView.findViewById(R.h.countTv));
    this.uyf = paramView.findViewById(R.h.moreV);
    this.uyd = ((LinearLayout)paramView.findViewById(R.h.containerV));
    this.uye = ((ViewGroup)paramView.findViewById(R.h.itemContainerV));
    this.MUP = true;
    if (this.uya != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.MUQ = bool;
      cnr();
      super.onBindView(paramView);
      AppMethodBeat.o(26918);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */