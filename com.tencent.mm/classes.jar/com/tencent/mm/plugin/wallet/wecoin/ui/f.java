package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.wecoin.a.c;
import com.tencent.mm.plugin.wallet.wecoin.a.c.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.a.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEntranceTutorialDialog;", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog;", "context", "Landroid/content/Context;", "alwaysDarkMode", "", "(Landroid/content/Context;Z)V", "getAlwaysDarkMode", "()Z", "getContext", "()Landroid/content/Context;", "dismissListener", "Lcom/tencent/mm/plugin/wallet/wecoin/api/IWeCoinEntranceTutorialDialog$OnDismissListener;", "mBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "mCustomView", "Landroid/view/View;", "initCustomView", "", "initView", "setDialogDismissListener", "listener", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements c
{
  private c.a VwA;
  private final boolean Vwm;
  private j Vwz;
  private final Context context;
  private View oW;
  
  public f(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(315968);
    this.context = paramContext;
    this.Vwm = paramBoolean;
    Object localObject1 = this.context;
    this.Vwz = new j((Context)localObject1, 2, 0, this.Vwm, (byte)0);
    paramContext = this.Vwz;
    int i;
    if (paramContext == null)
    {
      s.bIx("mBottomSheet");
      paramContext = null;
      paramContext.au((CharSequence)((Context)localObject1).getString(a.i.wecoin_dialog_left_button_common_wording));
      localObject1 = this.Vwz;
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mBottomSheet");
        paramContext = null;
      }
      paramContext.agfR = new f..ExternalSyntheticLambda0(this);
      localObject1 = this.Vwz;
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mBottomSheet");
        paramContext = null;
      }
      paramContext.agfT = new f..ExternalSyntheticLambda1(this);
      paramContext = View.inflate(this.context, a.g.layout_wecoin_entrance_tutorial_dialog, null);
      s.s(paramContext, "inflate(context, R.layou…ce_tutorial_dialog, null)");
      this.oW = paramContext;
      localObject1 = this.oW;
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mCustomView");
        paramContext = null;
      }
      Object localObject3 = (TextView)paramContext.findViewById(a.f.wecoin_tutorial_content_tv);
      aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
      localObject1 = this.oW;
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mCustomView");
        paramContext = null;
      }
      ImageView localImageView = (ImageView)paramContext.findViewById(a.f.wecoin_avatar_iv);
      localObject1 = this.oW;
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mCustomView");
        paramContext = null;
      }
      TextView localTextView = (TextView)paramContext.findViewById(a.f.wecoin_user_name_tv);
      aw.a((Paint)localTextView.getPaint(), 0.8F);
      localObject1 = z.bAM();
      paramContext = z.bAO();
      CharSequence localCharSequence = (CharSequence)paramContext;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label582;
      }
      i = 1;
      label334:
      if (i != 0) {
        paramContext = z.bAP();
      }
      localCharSequence = (CharSequence)paramContext;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label587;
      }
      i = 1;
      label365:
      if (i != 0) {
        paramContext = (Context)localObject1;
      }
      localCharSequence = (CharSequence)localObject1;
      if (localCharSequence != null)
      {
        i = j;
        if (localCharSequence.length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if ((i == 0) && (h.baz())) {
        a.b.g(localImageView, (String)localObject1);
      }
      localTextView.setText((CharSequence)paramContext);
      if (this.Vwm)
      {
        localObject1 = this.oW;
        paramContext = (Context)localObject1;
        if (localObject1 == null)
        {
          s.bIx("mCustomView");
          paramContext = null;
        }
        paramContext.findViewById(a.f.wecoin_tutorial_content_profile_ll).setBackgroundResource(a.e.wecoin_entrance_guide_dark);
        ((TextView)localObject3).setTextColor(this.context.getResources().getColor(a.c.BW_100_Alpha_0_8));
        localTextView.setTextColor(this.context.getResources().getColor(a.c.BW_100_Alpha_0_8));
      }
      localObject1 = this.Vwz;
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        s.bIx("mBottomSheet");
        paramContext = null;
      }
      localObject3 = this.oW;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("mCustomView");
        localObject1 = null;
      }
      paramContext.setCustomView((View)localObject1);
      paramContext = this.Vwz;
      if (paramContext != null) {
        break label592;
      }
      s.bIx("mBottomSheet");
      paramContext = localObject2;
    }
    label582:
    label587:
    label592:
    for (;;)
    {
      paramContext.dDn();
      AppMethodBeat.o(315968);
      return;
      break;
      i = 0;
      break label334;
      i = 0;
      break label365;
    }
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(315974);
    s.u(paramf, "this$0");
    j localj = paramf.Vwz;
    paramf = localj;
    if (localj == null)
    {
      s.bIx("mBottomSheet");
      paramf = null;
    }
    paramf.cyW();
    AppMethodBeat.o(315974);
  }
  
  private static final void b(f paramf)
  {
    AppMethodBeat.i(315976);
    s.u(paramf, "this$0");
    c.a locala = paramf.VwA;
    if (locala != null) {
      locala.onDismiss((c)paramf);
    }
    AppMethodBeat.o(315976);
  }
  
  public final void a(c.a parama)
  {
    this.VwA = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.wecoin.ui.f
 * JD-Core Version:    0.7.0.1
 */