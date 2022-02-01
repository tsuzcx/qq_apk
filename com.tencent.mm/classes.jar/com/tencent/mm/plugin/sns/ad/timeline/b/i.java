package com.tencent.mm.plugin.sns.ad.timeline.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.ad.adxml.k;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;

public final class i
{
  private int JCO;
  private RoundedCornerFrameLayout JJe;
  private ImageView JJf;
  private k JJg;
  c JJh;
  private Context mContext;
  private View.OnClickListener mOnClickListener;
  
  public i(Context paramContext, int paramInt, l paraml, RoundedCornerFrameLayout paramRoundedCornerFrameLayout, c.b paramb)
  {
    AppMethodBeat.i(223434);
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193794);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/timeline/helper/TimelineTagBtnHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        i.this.JJh.gd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/timeline/helper/TimelineTagBtnHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193794);
      }
    };
    this.mContext = paramContext;
    this.JCO = paramInt;
    this.JJe = paramRoundedCornerFrameLayout;
    this.JJf = ((ImageView)paramRoundedCornerFrameLayout.findViewById(i.f.sns_ad_tag_btn_img));
    this.JJe.setOnClickListener(this.mOnClickListener);
    this.JJh = new c(this.mContext, this.JCO, paraml, null, paramb);
    AppMethodBeat.o(223434);
  }
  
  public final void a(k paramk, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(223441);
    this.JJg = paramk;
    if (this.JJg.clickActionInfo != null) {
      this.JJh.a(paramk.clickActionInfo, paramSnsInfo, 0);
    }
    if (ar.isDarkMode()) {
      if (!TextUtils.isEmpty(this.JJg.JyH)) {
        com.tencent.mm.plugin.sns.ad.i.a.l(this.JJg.JyH, this.JJf);
      }
    }
    for (;;)
    {
      this.JJe.setRadius(this.JJg.bDI);
      paramk = this.JJf.getLayoutParams();
      paramk.width = this.JJg.zPO;
      paramk.height = this.JJg.zPP;
      this.JJf.setLayoutParams(paramk);
      AppMethodBeat.o(223441);
      return;
      if (!TextUtils.isEmpty(this.JJg.JyG)) {
        com.tencent.mm.plugin.sns.ad.i.a.l(this.JJg.JyG, this.JJf);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.i
 * JD-Core Version:    0.7.0.1
 */