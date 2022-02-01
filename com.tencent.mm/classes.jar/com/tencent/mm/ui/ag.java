package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "", "filePath", "", "callback", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "indexLayout", "Landroid/widget/TextView;", "getIndexLayout", "()Landroid/widget/TextView;", "setIndexLayout", "(Landroid/widget/TextView;)V", "indexRootLayout", "Landroid/view/View;", "getIndexRootLayout", "()Landroid/view/View;", "setIndexRootLayout", "(Landroid/view/View;)V", "mCurrentIndex", "", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "maxCount", "getMaxCount", "setMaxCount", "readerLayout", "getReaderLayout", "setReaderLayout", "readerLayoutRootView", "Landroid/widget/RelativeLayout;", "getReaderLayoutRootView", "()Landroid/widget/RelativeLayout;", "setReaderLayoutRootView", "(Landroid/widget/RelativeLayout;)V", "startBtn", "getStartBtn", "setStartBtn", "applyClickEvent", "context", "Landroid/content/Context;", "getLandscapeLayout", "rootView", "Landroid/view/ViewGroup;", "getPortraitLayout", "refreshIndexLayout", "app_release"})
public final class ag
{
  private RelativeLayout OKA;
  private RelativeLayout OKB;
  private View OKx;
  private TextView OKy;
  private View OKz;
  String filePath;
  public int maxCount;
  public int rmJ;
  private kotlin.g.a.a<x> uGD;
  
  private ag(String paramString)
  {
    AppMethodBeat.i(231172);
    this.filePath = paramString;
    this.uGD = null;
    AppMethodBeat.o(231172);
  }
  
  private void jR(final Context paramContext)
  {
    AppMethodBeat.i(231170);
    p.h(paramContext, "context");
    Object localObject = this.OKx;
    if (localObject != null)
    {
      localObject = (RelativeLayout)((View)localObject).findViewById(2131307306);
      this.OKB = ((RelativeLayout)localObject);
      localObject = this.OKx;
      if (localObject == null) {
        break label182;
      }
      localObject = (TextView)((View)localObject).findViewById(2131307307);
      label54:
      this.OKy = ((TextView)localObject);
      localObject = this.OKy;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      localObject = this.OKx;
      if (localObject == null) {
        break label187;
      }
      localObject = ((View)localObject).findViewById(2131307308);
      label89:
      this.OKz = ((View)localObject);
      localObject = this.OKz;
      if (localObject != null) {
        ((View)localObject).setVisibility(4);
      }
      localObject = this.OKx;
      if (localObject == null) {
        break label192;
      }
    }
    label182:
    label187:
    label192:
    for (localObject = (RelativeLayout)((View)localObject).findViewById(2131307310);; localObject = null)
    {
      this.OKA = ((RelativeLayout)localObject);
      localObject = this.OKA;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
      localObject = this.OKA;
      if (localObject == null) {
        break label197;
      }
      ((RelativeLayout)localObject).setOnClickListener((View.OnClickListener)new a(this, paramContext));
      AppMethodBeat.o(231170);
      return;
      localObject = null;
      break;
      localObject = null;
      break label54;
      localObject = null;
      break label89;
    }
    label197:
    AppMethodBeat.o(231170);
  }
  
  public final View f(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(231168);
    p.h(paramContext, "context");
    p.h(paramViewGroup, "rootView");
    this.OKx = LayoutInflater.from(paramContext).inflate(2131496165, paramViewGroup);
    jR(paramContext);
    paramContext = this.OKx;
    AppMethodBeat.o(231168);
    return paramContext;
  }
  
  public final View g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(231169);
    p.h(paramContext, "context");
    p.h(paramViewGroup, "rootView");
    this.OKx = LayoutInflater.from(paramContext).inflate(2131496166, paramViewGroup);
    jR(paramContext);
    paramContext = this.OKx;
    AppMethodBeat.o(231169);
    return paramContext;
  }
  
  public final void gJA()
  {
    AppMethodBeat.i(231171);
    Object localObject = this.OKA;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(0);
    }
    localObject = this.OKx;
    if (localObject != null) {}
    for (localObject = ((View)localObject).findViewById(2131307308);; localObject = null)
    {
      this.OKz = ((View)localObject);
      localObject = this.OKz;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.OKy;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.OKy;
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setText((CharSequence)(this.rmJ + 1 + '/' + this.maxCount));
      AppMethodBeat.o(231171);
      return;
    }
    AppMethodBeat.o(231171);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(ag paramag, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231167);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = ac.eom();
      p.g(paramView, "SubCoreMultiTalk.getMultiTalkManager()");
      if (paramView.emr())
      {
        paramView = new Intent(paramContext, MultiTalkMainUI.class);
        paramView.setFlags(603979776);
        paramView.putExtra("filePath", this.OKC.filePath);
        localObject = f.zZd;
        f.eqm();
        localObject = paramContext;
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((Context)localObject).startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231167);
        return;
        u.cH(paramContext, paramContext.getString(2131765012));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ag
 * JD-Core Version:    0.7.0.1
 */