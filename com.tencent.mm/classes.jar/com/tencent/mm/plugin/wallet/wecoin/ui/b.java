package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.ui.b.b;
import com.tencent.mm.plugin.wallet.wecoin.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEntranceTutorialDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getContext", "()Landroid/app/Activity;", "mBottomSheet", "Lcom/tencent/mm/plugin/wallet/ui/CommonBottomSheet;", "mCustomView", "Landroid/view/View;", "mOuterClickListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IBtnClickListener;", "initCustomView", "", "initView", "Landroid/content/Context;", "setSingleButtonClickListener", "clickListener", "plugin-wxpay_release"})
public final class b
  implements com.tencent.mm.plugin.wallet.wecoin.a.b
{
  a HOU;
  com.tencent.mm.plugin.wallet.ui.b HOb;
  private View ahJ;
  private final Activity dKq;
  
  public b(Activity paramActivity)
  {
    AppMethodBeat.i(212841);
    this.dKq = paramActivity;
    paramActivity = (Context)this.dKq;
    this.HOb = new com.tencent.mm.plugin.wallet.ui.b(paramActivity, 2, 0);
    Object localObject = this.HOb;
    if (localObject == null) {
      p.btv("mBottomSheet");
    }
    ((com.tencent.mm.plugin.wallet.ui.b)localObject).yf(true);
    localObject = this.HOb;
    if (localObject == null) {
      p.btv("mBottomSheet");
    }
    ((com.tencent.mm.plugin.wallet.ui.b)localObject).T((CharSequence)paramActivity.getString(2131768685));
    localObject = this.HOb;
    if (localObject == null) {
      p.btv("mBottomSheet");
    }
    ((com.tencent.mm.plugin.wallet.ui.b)localObject).aeF(paramActivity.getResources().getColor(2131099836));
    paramActivity = this.HOb;
    if (paramActivity == null) {
      p.btv("mBottomSheet");
    }
    paramActivity.fPx();
    paramActivity = this.HOb;
    if (paramActivity == null) {
      p.btv("mBottomSheet");
    }
    paramActivity.a((b.b)new a(this));
    paramActivity = View.inflate((Context)this.dKq, 2131495205, null);
    p.g(paramActivity, "View.inflate(context, R.…ce_tutorial_dialog, null)");
    this.ahJ = paramActivity;
    paramActivity = this.ahJ;
    if (paramActivity == null) {
      p.btv("mCustomView");
    }
    paramActivity = (TextView)paramActivity.findViewById(2131310457);
    p.g(paramActivity, "textView");
    ao.a((Paint)paramActivity.getPaint(), 0.8F);
    paramActivity = this.ahJ;
    if (paramActivity == null) {
      p.btv("mCustomView");
    }
    ImageView localImageView = (ImageView)paramActivity.findViewById(2131310434);
    paramActivity = this.ahJ;
    if (paramActivity == null) {
      p.btv("mCustomView");
    }
    TextView localTextView = (TextView)paramActivity.findViewById(2131310458);
    p.g(localTextView, "userNameTV");
    ao.a((Paint)localTextView.getPaint(), 0.8F);
    localObject = z.aTY();
    paramActivity = z.aUa();
    CharSequence localCharSequence = (CharSequence)paramActivity;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0) {
        paramActivity = z.aUb();
      }
      localCharSequence = (CharSequence)paramActivity;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label478;
      }
      i = 1;
      label362:
      if (i != 0) {
        paramActivity = (Activity)localObject;
      }
      localCharSequence = (CharSequence)localObject;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label483;
      }
    }
    label478:
    label483:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (g.aAc())) {
        a.b.c(localImageView, (String)localObject);
      }
      localTextView.setText((CharSequence)paramActivity);
      paramActivity = this.HOb;
      if (paramActivity == null) {
        p.btv("mBottomSheet");
      }
      localObject = this.ahJ;
      if (localObject == null) {
        p.btv("mCustomView");
      }
      paramActivity.setCustomView((View)localObject);
      paramActivity = this.HOb;
      if (paramActivity == null) {
        p.btv("mBottomSheet");
      }
      paramActivity.dGm();
      AppMethodBeat.o(212841);
      return;
      i = 0;
      break;
      i = 0;
      break label362;
    }
  }
  
  public final void a(a parama)
  {
    this.HOU = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class a
    implements b.b
  {
    a(b paramb) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(212840);
      Object localObject = this.HOV.HOb;
      if (localObject == null) {
        p.btv("mBottomSheet");
      }
      ((com.tencent.mm.plugin.wallet.ui.b)localObject).bMo();
      localObject = this.HOV.HOU;
      if (localObject != null)
      {
        ((a)localObject).onClick();
        AppMethodBeat.o(212840);
        return;
      }
      AppMethodBeat.o(212840);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.b
 * JD-Core Version:    0.7.0.1
 */