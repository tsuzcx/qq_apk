package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.plugin.multitalk.model.ab;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.multitalk.ui.widget.k;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "", "context", "Landroid/content/Context;", "filePath", "", "scene", "", "callback", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "indexLayout", "Landroid/widget/TextView;", "getIndexLayout", "()Landroid/widget/TextView;", "setIndexLayout", "(Landroid/widget/TextView;)V", "indexRootLayout", "Landroid/view/View;", "getIndexRootLayout", "()Landroid/view/View;", "setIndexRootLayout", "(Landroid/view/View;)V", "mCurrentIndex", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mSecurityObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/multitalk/model/SecurityParamsData;", "mToastUI", "Landroid/widget/Toast;", "maxCount", "getMaxCount", "setMaxCount", "readerLayout", "getReaderLayout", "setReaderLayout", "readerLayoutRootView", "Landroid/widget/RelativeLayout;", "getReaderLayoutRootView", "()Landroid/widget/RelativeLayout;", "setReaderLayoutRootView", "(Landroid/widget/RelativeLayout;)V", "startBtn", "getStartBtn", "setStartBtn", "applyClickEvent", "getLandscapeLayout", "rootView", "Landroid/view/ViewGroup;", "getPortraitLayout", "goToScreenCastShow", "refreshIndexLayout", "release", "showRotateScreenInfo", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
{
  public static final an.a adJw;
  private w RSB;
  private RelativeLayout adJA;
  private RelativeLayout adJB;
  public Toast adJC;
  private final androidx.lifecycle.y<ab> adJD;
  private View adJx;
  private TextView adJy;
  private View adJz;
  private kotlin.g.a.a<ah> callback;
  public Context context;
  private String filePath;
  public int lyL;
  private final int scene;
  public int xYG;
  
  static
  {
    AppMethodBeat.i(249298);
    adJw = new an.a((byte)0);
    AppMethodBeat.o(249298);
  }
  
  private an(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(249275);
    this.context = paramContext;
    this.filePath = paramString;
    this.scene = paramInt;
    this.callback = null;
    this.adJD = new an..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(249275);
  }
  
  private static final void a(an paraman, Context paramContext, View paramView)
  {
    AppMethodBeat.i(249296);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraman);
    localb.cH(paramContext);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/ScreenProfileReadyPluginUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraman, "this$0");
    s.u(paramContext, "$context");
    if (paraman.scene == 3)
    {
      ac.ggS().LoT.b(paraman.adJD);
      ac.ggS().LoT.a((q)paramContext, paraman.adJD);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/ScreenProfileReadyPluginUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(249296);
      return;
      if (paraman.scene == 4)
      {
        paramView = new Intent();
        paramView.putExtra("filePath", paraman.filePath);
        ((Activity)paramContext).setResult(-1, paramView);
        ((Activity)paramContext).finish();
      }
    }
  }
  
  private static final void a(an paraman, ab paramab)
  {
    AppMethodBeat.i(249293);
    s.u(paraman, "this$0");
    StringBuilder localStringBuilder = new StringBuilder("value is ").append(paramab).append(" and ");
    if (paramab == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(" and ");
      if (paramab != null) {
        break label127;
      }
      localObject = null;
      label53:
      localStringBuilder = localStringBuilder.append(localObject).append(" and ");
      if (paramab != null) {
        break label135;
      }
    }
    label135:
    for (Object localObject = null;; localObject = paramab.md5)
    {
      Log.i("MicroMsg.ScreenProfileReadyPluginUI", localObject);
      if (!ac.ggS().geW()) {
        break label597;
      }
      if (paramab != null) {
        break label143;
      }
      paraman = paraman.RSB;
      if (paraman == null) {
        break label621;
      }
      paraman.dismiss();
      AppMethodBeat.o(249293);
      return;
      localObject = Long.valueOf(paramab.LqE);
      break;
      label127:
      localObject = paramab.LqD;
      break label53;
    }
    label143:
    if (!s.p(paramab.md5, com.tencent.mm.vfs.y.bub(paraman.filePath)))
    {
      paramab = k.Lvg;
      paramab = com.tencent.mm.vfs.y.bub(paraman.filePath);
      s.s(paramab, "getFileMD5String(filePath)");
      k.a.aND(paramab);
      paraman.RSB = w.a(paraman.context, (CharSequence)paraman.context.getString(R.l.checking_security_loading), false, 3, null);
      AppMethodBeat.o(249293);
      return;
    }
    if ((s.p(paramab.LqD, Boolean.TRUE)) || ((System.currentTimeMillis() - paramab.LqE >= 3000L) && (paramab.LqD == null)))
    {
      paramab = paraman.adJC;
      if (paramab != null) {
        paramab.cancel();
      }
      paramab = paraman.RSB;
      if (paramab != null) {
        paramab.dismiss();
      }
      cV(paraman.context, paraman.filePath);
      AppMethodBeat.o(249293);
      return;
    }
    if (s.p(paramab.LqD, Boolean.FALSE))
    {
      paramab = paraman.adJC;
      if (paramab != null) {
        paramab.cancel();
      }
      paramab = paraman.RSB;
      if (paramab != null) {
        paramab.dismiss();
      }
      paraman.adJC = aa.c(paraman.context, (CharSequence)paraman.context.getString(R.l.gHL));
      ((MMActivity)paraman.context).setRequestedOrientation(1);
      ac.ggS().LoT.j((q)paraman.context);
      paramab = new Intent(paraman.context, MultiTalkMainUI.class);
      paramab.setFlags(603979776);
      paraman = paraman.context;
      paramab = new com.tencent.mm.hellhoundlib.b.a().cG(paramab);
      com.tencent.mm.hellhoundlib.a.a.b(paraman, paramab.aYi(), "com/tencent/mm/ui/ScreenProfileReadyPluginUI", "mSecurityObserver$lambda-0", "(Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;Lcom/tencent/mm/plugin/multitalk/model/SecurityParamsData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paraman.startActivity((Intent)paramab.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paraman, "com/tencent/mm/ui/ScreenProfileReadyPluginUI", "mSecurityObserver$lambda-0", "(Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;Lcom/tencent/mm/plugin/multitalk/model/SecurityParamsData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(249293);
      return;
    }
    if (System.currentTimeMillis() - paramab.LqE < 3000L)
    {
      paramab = paraman.adJC;
      if (paramab != null) {
        paramab.cancel();
      }
      paramab = paraman.RSB;
      if (paramab != null) {
        paramab.dismiss();
      }
      paraman.RSB = w.a(paraman.context, (CharSequence)paraman.context.getString(R.l.checking_security_loading), false, 3, null);
      AppMethodBeat.o(249293);
      return;
    }
    paramab = paraman.adJC;
    if (paramab != null) {
      paramab.cancel();
    }
    paraman = paraman.RSB;
    if (paraman != null)
    {
      paraman.dismiss();
      AppMethodBeat.o(249293);
      return;
      label597:
      paraman.adJC = aa.c(paraman.context, (CharSequence)paraman.context.getString(R.l.gUp));
    }
    label621:
    AppMethodBeat.o(249293);
  }
  
  private static void cV(Context paramContext, String paramString)
  {
    AppMethodBeat.i(249287);
    ac.ggS().LoT.j((q)paramContext);
    Intent localIntent = new Intent(paramContext, MultiTalkMainUI.class);
    localIntent.setFlags(603979776);
    localIntent.putExtra("filePath", paramString);
    paramString = g.LAS;
    g.gjh();
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString.aYi(), "com/tencent/mm/ui/ScreenProfileReadyPluginUI", "goToScreenCastShow", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/ScreenProfileReadyPluginUI", "goToScreenCastShow", "(Landroid/content/Context;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(249287);
  }
  
  private void mW(Context paramContext)
  {
    Object localObject2 = null;
    AppMethodBeat.i(249283);
    s.u(paramContext, "context");
    Object localObject1 = this.adJx;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.adJB = ((RelativeLayout)localObject1);
      localObject1 = this.adJx;
      if (localObject1 != null) {
        break label163;
      }
      localObject1 = null;
      label41:
      this.adJy = ((TextView)localObject1);
      localObject1 = this.adJy;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(4);
      }
      localObject1 = this.adJx;
      if (localObject1 != null) {
        break label177;
      }
      localObject1 = null;
      label71:
      this.adJz = ((View)localObject1);
      localObject1 = this.adJz;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(4);
      }
      localObject1 = this.adJx;
      if (localObject1 != null) {
        break label188;
      }
    }
    label163:
    label177:
    label188:
    for (localObject1 = localObject2;; localObject1 = (RelativeLayout)((View)localObject1).findViewById(R.h.screen_profile_start_btn))
    {
      this.adJA = ((RelativeLayout)localObject1);
      localObject1 = this.adJA;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setVisibility(4);
      }
      localObject1 = this.adJA;
      if (localObject1 != null) {
        ((RelativeLayout)localObject1).setOnClickListener(new an..ExternalSyntheticLambda0(this, paramContext));
      }
      AppMethodBeat.o(249283);
      return;
      localObject1 = (RelativeLayout)((View)localObject1).findViewById(R.h.screen_profile_content_ui);
      break;
      localObject1 = (TextView)((View)localObject1).findViewById(R.h.screen_profile_index_iv);
      break label41;
      localObject1 = ((View)localObject1).findViewById(R.h.screen_profile_index_iv_root);
      break label71;
    }
  }
  
  public final View ab(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(249309);
    s.u(paramViewGroup, "rootView");
    this.adJx = LayoutInflater.from(this.context).inflate(R.i.screen_projector_before_plugin, paramViewGroup);
    mW(this.context);
    paramViewGroup = this.adJx;
    AppMethodBeat.o(249309);
    return paramViewGroup;
  }
  
  public final View ac(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(249314);
    s.u(paramViewGroup, "rootView");
    this.adJx = LayoutInflater.from(this.context).inflate(R.i.screen_projector_before_plugin_land, paramViewGroup);
    mW(this.context);
    paramViewGroup = this.adJx;
    AppMethodBeat.o(249314);
    return paramViewGroup;
  }
  
  public final void jkH()
  {
    AppMethodBeat.i(249322);
    Object localObject = this.adJA;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
    localObject = this.adJx;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(R.h.screen_profile_index_iv_root))
    {
      this.adJz = ((View)localObject);
      localObject = this.adJz;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.adJy;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.adJy;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)(this.xYG + 1 + '/' + this.lyL));
      }
      AppMethodBeat.o(249322);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(249317);
    Object localObject = this.adJC;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    localObject = this.RSB;
    if (localObject != null) {
      ((w)localObject).dismiss();
    }
    ac.ggS().LoT.b(this.adJD);
    ac.ggS().LoT.j((q)this.context);
    AppMethodBeat.o(249317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.an
 * JD-Core Version:    0.7.0.1
 */