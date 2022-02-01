package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "", "context", "Landroid/content/Context;", "filePath", "", "scene", "", "callback", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "indexLayout", "Landroid/widget/TextView;", "getIndexLayout", "()Landroid/widget/TextView;", "setIndexLayout", "(Landroid/widget/TextView;)V", "indexRootLayout", "Landroid/view/View;", "getIndexRootLayout", "()Landroid/view/View;", "setIndexRootLayout", "(Landroid/view/View;)V", "mCurrentIndex", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mSecurityObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/plugin/multitalk/model/SecurityParamsData;", "mToastUI", "Landroid/widget/Toast;", "maxCount", "getMaxCount", "setMaxCount", "readerLayout", "getReaderLayout", "setReaderLayout", "readerLayoutRootView", "Landroid/widget/RelativeLayout;", "getReaderLayoutRootView", "()Landroid/widget/RelativeLayout;", "setReaderLayoutRootView", "(Landroid/widget/RelativeLayout;)V", "startBtn", "getStartBtn", "setStartBtn", "applyClickEvent", "getLandscapeLayout", "rootView", "Landroid/view/ViewGroup;", "getPortraitLayout", "goToScreenCastShow", "refreshIndexLayout", "release", "showRotateScreenInfo", "Companion", "app_release"})
public final class aj
{
  public static final aj.a WdZ;
  private com.tencent.mm.ui.base.s PIW;
  private View WdS;
  private TextView WdT;
  private View WdU;
  private RelativeLayout WdV;
  private RelativeLayout WdW;
  public Toast WdX;
  private final androidx.lifecycle.s<ac> WdY;
  public Context context;
  String filePath;
  public int iWH;
  private final int scene;
  public int uPV;
  private kotlin.g.a.a<x> zoa;
  
  static
  {
    AppMethodBeat.i(282576);
    WdZ = new aj.a((byte)0);
    AppMethodBeat.o(282576);
  }
  
  private aj(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(282575);
    this.context = paramContext;
    this.filePath = paramString;
    this.scene = paramInt;
    this.zoa = null;
    this.WdY = ((androidx.lifecycle.s)new c(this));
    AppMethodBeat.o(282575);
  }
  
  private void kT(final Context paramContext)
  {
    AppMethodBeat.i(282570);
    p.k(paramContext, "context");
    Object localObject = this.WdS;
    if (localObject != null)
    {
      localObject = (RelativeLayout)((View)localObject).findViewById(R.h.screen_profile_content_ui);
      this.WdW = ((RelativeLayout)localObject);
      localObject = this.WdS;
      if (localObject == null) {
        break label188;
      }
      localObject = (TextView)((View)localObject).findViewById(R.h.screen_profile_index_iv);
      label57:
      this.WdT = ((TextView)localObject);
      localObject = this.WdT;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      localObject = this.WdS;
      if (localObject == null) {
        break label193;
      }
      localObject = ((View)localObject).findViewById(R.h.screen_profile_index_iv_root);
      label93:
      this.WdU = ((View)localObject);
      localObject = this.WdU;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      localObject = this.WdS;
      if (localObject == null) {
        break label198;
      }
    }
    label188:
    label193:
    label198:
    for (localObject = (RelativeLayout)((View)localObject).findViewById(R.h.screen_profile_start_btn);; localObject = null)
    {
      this.WdV = ((RelativeLayout)localObject);
      localObject = this.WdV;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
      localObject = this.WdV;
      if (localObject == null) {
        break label203;
      }
      ((RelativeLayout)localObject).setOnClickListener((View.OnClickListener)new b(this, paramContext));
      AppMethodBeat.o(282570);
      return;
      localObject = null;
      break;
      localObject = null;
      break label57;
      localObject = null;
      break label93;
    }
    label203:
    AppMethodBeat.o(282570);
  }
  
  public final View R(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(282566);
    p.k(paramViewGroup, "rootView");
    this.WdS = LayoutInflater.from(this.context).inflate(R.i.screen_projector_before_plugin, paramViewGroup);
    kT(this.context);
    paramViewGroup = this.WdS;
    AppMethodBeat.o(282566);
    return paramViewGroup;
  }
  
  public final View S(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(282568);
    p.k(paramViewGroup, "rootView");
    this.WdS = LayoutInflater.from(this.context).inflate(R.i.screen_projector_before_plugin_land, paramViewGroup);
    kT(this.context);
    paramViewGroup = this.WdS;
    AppMethodBeat.o(282568);
    return paramViewGroup;
  }
  
  public final void hIx()
  {
    AppMethodBeat.i(282574);
    Object localObject = this.WdV;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
    localObject = this.WdS;
    if (localObject != null) {}
    for (localObject = ((View)localObject).findViewById(R.h.screen_profile_index_iv_root);; localObject = null)
    {
      this.WdU = ((View)localObject);
      localObject = this.WdU;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.WdT;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.WdT;
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setText((CharSequence)(this.uPV + 1 + '/' + this.iWH));
      AppMethodBeat.o(282574);
      return;
    }
    AppMethodBeat.o(282574);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282572);
    Object localObject = this.WdX;
    if (localObject != null) {
      ((Toast)localObject).cancel();
    }
    localObject = this.PIW;
    if (localObject != null) {
      ((com.tencent.mm.ui.base.s)localObject).dismiss();
    }
    ad.eYc().FsB.b(this.WdY);
    localObject = ad.eYc().FsB;
    Context localContext = this.context;
    if (localContext == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282572);
      throw ((Throwable)localObject);
    }
    ((r)localObject).c((androidx.lifecycle.l)localContext);
    AppMethodBeat.o(282572);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(aj paramaj, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289693);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      if (aj.a(this.Wea) == 3)
      {
        ad.eYc().FsB.b(aj.b(this.Wea));
        paramView = ad.eYc().FsB;
        localObject = paramContext;
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(289693);
          throw paramView;
        }
        paramView.a((androidx.lifecycle.l)localObject, aj.b(this.Wea));
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(289693);
        return;
        if (aj.a(this.Wea) == 4)
        {
          paramView = new Intent();
          paramView.putExtra("filePath", this.Wea.filePath);
          localObject = paramContext;
          if (localObject == null)
          {
            paramView = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(289693);
            throw paramView;
          }
          ((Activity)localObject).setResult(-1, paramView);
          paramView = paramContext;
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(289693);
            throw paramView;
          }
          ((Activity)paramView).finish();
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/multitalk/model/SecurityParamsData;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class c<T>
    implements androidx.lifecycle.s<ac>
  {
    c(aj paramaj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.aj
 * JD-Core Version:    0.7.0.1
 */