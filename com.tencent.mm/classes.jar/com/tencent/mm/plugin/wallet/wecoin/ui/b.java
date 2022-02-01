package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.ui.b.b;
import com.tencent.mm.plugin.wallet.wecoin.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEntranceTutorialDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "mBottomSheet", "Lcom/tencent/mm/plugin/wallet/ui/CommonBottomSheet;", "mCustomView", "Landroid/view/View;", "mOuterClickListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IBtnClickListener;", "initCustomView", "", "initView", "Landroid/content/Context;", "setSingleButtonClickListener", "clickListener", "plugin-wxpay_release"})
public final class b
  implements com.tencent.mm.plugin.wallet.wecoin.a.b
{
  com.tencent.mm.plugin.wallet.ui.b OFX;
  a OGR;
  private final Activity fDf;
  private View nX;
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(262173);
    this.fDf = paramActivity;
    paramActivity = (Context)this.fDf;
    this.OFX = new com.tencent.mm.plugin.wallet.ui.b(paramActivity, 2, 0);
    Object localObject = this.OFX;
    if (localObject == null) {
      p.bGy("mBottomSheet");
    }
    ((com.tencent.mm.plugin.wallet.ui.b)localObject).Ca(true);
    localObject = this.OFX;
    if (localObject == null) {
      p.bGy("mBottomSheet");
    }
    ((com.tencent.mm.plugin.wallet.ui.b)localObject).ah((CharSequence)paramActivity.getString(a.i.wecoin_dialog_left_button_common_wording));
    localObject = this.OFX;
    if (localObject == null) {
      p.bGy("mBottomSheet");
    }
    ((com.tencent.mm.plugin.wallet.ui.b)localObject).amr(paramActivity.getResources().getColor(a.c.UN_BW_0_Alpha_0_9));
    paramActivity = this.OFX;
    if (paramActivity == null) {
      p.bGy("mBottomSheet");
    }
    paramActivity.ams(a.e.wecoin_entrance_tutorial_dialog_btn_press_bg);
    paramActivity = this.OFX;
    if (paramActivity == null) {
      p.bGy("mBottomSheet");
    }
    paramActivity.a((b.b)new a(this));
    paramActivity = View.inflate((Context)this.fDf, a.g.layout_wecoin_entrance_tutorial_dialog, null);
    p.j(paramActivity, "View.inflate(context, R.…ce_tutorial_dialog, null)");
    this.nX = paramActivity;
    paramActivity = this.nX;
    if (paramActivity == null) {
      p.bGy("mCustomView");
    }
    paramActivity = (TextView)paramActivity.findViewById(a.f.wecoin_tutorial_content_tv);
    p.j(paramActivity, "textView");
    ar.a((Paint)paramActivity.getPaint(), 0.8F);
    paramActivity = this.nX;
    if (paramActivity == null) {
      p.bGy("mCustomView");
    }
    ImageView localImageView = (ImageView)paramActivity.findViewById(a.f.wecoin_avatar_iv);
    paramActivity = this.nX;
    if (paramActivity == null) {
      p.bGy("mCustomView");
    }
    TextView localTextView = (TextView)paramActivity.findViewById(a.f.wecoin_user_name_tv);
    p.j(localTextView, "userNameTV");
    ar.a((Paint)localTextView.getPaint(), 0.8F);
    localObject = z.bcZ();
    paramActivity = z.bdb();
    CharSequence localCharSequence = (CharSequence)paramActivity;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        paramActivity = z.bdc();
      }
      localCharSequence = (CharSequence)paramActivity;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label487;
      }
      i = 1;
      label371:
      if (i != 0) {
        paramActivity = (Activity)localObject;
      }
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label492;
      }
    }
    label487:
    label492:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (h.aHB())) {
        a.b.c(localImageView, (String)localObject);
      }
      localTextView.setText((CharSequence)paramActivity);
      paramActivity = this.OFX;
      if (paramActivity == null) {
        p.bGy("mBottomSheet");
      }
      localObject = this.nX;
      if (localObject == null) {
        p.bGy("mCustomView");
      }
      paramActivity.setCustomView((View)localObject);
      paramActivity = this.OFX;
      if (paramActivity == null) {
        p.bGy("mBottomSheet");
      }
      paramActivity.eik();
      AppMethodBeat.o(262173);
      return;
      i = 0;
      break;
      i = 0;
      break label371;
    }
  }
  
  public final void a(a parama)
  {
    this.OGR = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class a
    implements b.b
  {
    a(b paramb) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(269079);
      Object localObject = this.OGS.OFX;
      if (localObject == null) {
        p.bGy("mBottomSheet");
      }
      ((com.tencent.mm.plugin.wallet.ui.b)localObject).bYF();
      localObject = this.OGS.OGR;
      if (localObject != null)
      {
        ((a)localObject).onClick();
        AppMethodBeat.o(269079);
        return;
      }
      AppMethodBeat.o(269079);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.b
 * JD-Core Version:    0.7.0.1
 */