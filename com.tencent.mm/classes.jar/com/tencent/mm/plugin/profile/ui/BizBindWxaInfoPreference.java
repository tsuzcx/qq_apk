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
import com.tencent.mm.api.c;
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
  private static DisplayMetrics ogw;
  private static int olJ;
  private static int olK;
  private volatile boolean BcX;
  private volatile boolean BcY;
  private View.OnClickListener BcZ;
  private c ksU;
  private ImageView lIM;
  private TextView mPa;
  private List<WxaAttributes.WxaEntryInfo> olD;
  private View olE;
  private TextView olF;
  private LinearLayout olG;
  private ViewGroup olH;
  private View olI;
  private View.OnClickListener rID;
  
  static
  {
    AppMethodBeat.i(26925);
    ogw = MMApplicationContext.getContext().getResources().getDisplayMetrics();
    olJ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 15);
    olK = MMApplicationContext.getResources().getDimensionPixelSize(2131165532);
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
    localImageView.setLayoutParams(new ViewGroup.LayoutParams(olK + olJ, olK));
    localImageView.setPadding(0, 0, olJ, 0);
    this.olG.addView(localImageView);
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
      com.tencent.mm.modelappbrand.a.b.aXY().a(paramImageView, paramWxaEntryInfo.iconUrl, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
    }
    if (paramTextView != null) {
      paramTextView.setText(Util.nullAsNil(paramWxaEntryInfo.title));
    }
    AppMethodBeat.o(26924);
  }
  
  private void bBG()
  {
    AppMethodBeat.i(26921);
    if ((!this.BcX) || (this.olD == null))
    {
      AppMethodBeat.o(26921);
      return;
    }
    if (!this.BcY)
    {
      AppMethodBeat.o(26921);
      return;
    }
    this.BcY = false;
    if (!this.olD.isEmpty()) {}
    for (WxaAttributes.WxaEntryInfo localWxaEntryInfo = (WxaAttributes.WxaEntryInfo)this.olD.get(0);; localWxaEntryInfo = null)
    {
      if (localWxaEntryInfo != null) {
        a(localWxaEntryInfo, this.lIM, this.mPa);
      }
      this.olF.setText(this.mContext.getString(2131757815, new Object[] { Integer.valueOf(this.olD.size()) }));
      fQ(this.olD);
      if (this.olD.size() == 1)
      {
        this.olE.setVisibility(0);
        this.olH.setTag(((WxaAttributes.WxaEntryInfo)this.olD.get(0)).username);
        this.olH.setOnClickListener(this.rID);
        AppMethodBeat.o(26921);
        return;
      }
      this.olE.setVisibility(8);
      this.olH.setTag(null);
      this.olH.setOnClickListener(this.BcZ);
      AppMethodBeat.o(26921);
      return;
    }
  }
  
  private void fQ(List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26922);
    this.olG.removeAllViews();
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(26922);
      return;
    }
    int k = paramList.size();
    int j = this.olH.getMeasuredWidth();
    int i = j;
    if (j == 0) {
      i = ogw.widthPixels;
    }
    j = i - this.olH.getPaddingLeft() - this.olH.getPaddingRight();
    i = j / (olK + olJ);
    if (i > k) {
      this.olI.setVisibility(8);
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
      this.olI.setVisibility(0);
      i = (j - this.olI.getMeasuredWidth()) / (olK + olJ);
    }
    Log.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(26922);
  }
  
  private void init()
  {
    AppMethodBeat.i(26920);
    this.rID = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26914);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView == null) || (!(paramAnonymousView instanceof String)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26914);
          return;
        }
        localObject = new AppBrandStatObject();
        ((AppBrandStatObject)localObject).scene = 1020;
        ((AppBrandStatObject)localObject).dCw = BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username;
        ((r)com.tencent.mm.kernel.g.af(r.class)).a(BizBindWxaInfoPreference.this.mContext, (String)paramAnonymousView, null, 0, 0, null, (AppBrandStatObject)localObject, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26914);
      }
    };
    this.BcZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26915);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((t)com.tencent.mm.kernel.g.af(t.class)).a(BizBindWxaInfoPreference.this.mContext, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_username, BizBindWxaInfoPreference.a(BizBindWxaInfoPreference.this).field_appId, BizBindWxaInfoPreference.b(BizBindWxaInfoPreference.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/BizBindWxaInfoPreference$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(26915);
      }
    };
    AppMethodBeat.o(26920);
  }
  
  public final void a(c paramc, List<WxaAttributes.WxaEntryInfo> paramList)
  {
    AppMethodBeat.i(26919);
    this.BcY = true;
    this.ksU = paramc;
    if (this.olD == null) {
      this.olD = new LinkedList();
    }
    for (;;)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.olD.addAll(paramList);
      }
      bBG();
      AppMethodBeat.o(26919);
      return;
      this.olD.clear();
    }
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(26918);
    this.olE = paramView.findViewById(2131301547);
    this.lIM = ((ImageView)paramView.findViewById(2131302477));
    this.mPa = ((TextView)paramView.findViewById(2131309199));
    this.olF = ((TextView)paramView.findViewById(2131299256));
    this.olI = paramView.findViewById(2131304859);
    this.olG = ((LinearLayout)paramView.findViewById(2131299176));
    this.olH = ((ViewGroup)paramView.findViewById(2131302792));
    this.BcX = true;
    if (this.olD != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.BcY = bool;
      bBG();
      super.onBindView(paramView);
      AppMethodBeat.o(26918);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizBindWxaInfoPreference
 * JD-Core Version:    0.7.0.1
 */