package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentIndex", "", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "mCurrentStr", "", "getMCurrentStr", "()Ljava/lang/String;", "setMCurrentStr", "(Ljava/lang/String;)V", "mLeftArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mLeftRoot", "Landroid/widget/FrameLayout;", "mMaxCount", "getMMaxCount", "setMMaxCount", "mRightArrow", "mRightRoot", "mScreenThumbIndexTv", "Landroid/widget/TextView;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "thumbnailIndexRoot", "applyTouchEvent", "", "getIconSelectColor", "isLeftArrow", "", "getLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "refreshLayout", "showIndexText", "str", "plugin-multitalk_release"})
public final class n
{
  int mMaxCount;
  int rmJ;
  a zQD;
  private WeImageView zXA;
  private String zXB;
  private TextView zXv;
  private FrameLayout zXw;
  private FrameLayout zXx;
  private FrameLayout zXy;
  private WeImageView zXz;
  
  public n(a parama)
  {
    AppMethodBeat.i(240036);
    this.zQD = parama;
    this.rmJ = -1;
    this.mMaxCount = -1;
    AppMethodBeat.o(240036);
  }
  
  private void epD()
  {
    AppMethodBeat.i(240034);
    Object localObject1 = this.zXw;
    if (localObject1 != null)
    {
      this.zXv = ((TextView)((FrameLayout)localObject1).findViewById(2131307321));
      Object localObject2 = this.zXv;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(4);
      }
      localObject2 = this.zXw;
      if (localObject2 != null) {
        ((FrameLayout)localObject2).setVisibility(4);
      }
      this.zXz = ((WeImageView)((FrameLayout)localObject1).findViewById(2131307324));
      this.zXA = ((WeImageView)((FrameLayout)localObject1).findViewById(2131307326));
      this.zXx = ((FrameLayout)((FrameLayout)localObject1).findViewById(2131307325));
      this.zXy = ((FrameLayout)((FrameLayout)localObject1).findViewById(2131307327));
      localObject2 = this.zXz;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setRotation(180.0F);
      }
      localObject2 = this.zXz;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setImageDrawable(ar.m(((FrameLayout)localObject1).getContext(), 2131690481, si(true)));
      }
      localObject2 = this.zXz;
      if (localObject2 != null)
      {
        Context localContext = ((FrameLayout)localObject1).getContext();
        p.g(localContext, "it.context");
        ((WeImageView)localObject2).setIconColor(localContext.getResources().getColor(si(true)));
      }
      localObject2 = this.zXA;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setImageDrawable(ar.m(((FrameLayout)localObject1).getContext(), 2131690481, si(false)));
      }
      localObject2 = this.zXA;
      if (localObject2 != null)
      {
        localObject1 = ((FrameLayout)localObject1).getContext();
        p.g(localObject1, "it.context");
        ((WeImageView)localObject2).setIconColor(((Context)localObject1).getResources().getColor(si(false)));
      }
      localObject1 = this.zXx;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject1 = this.zXy;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject1 = this.zXB;
      if (localObject1 != null)
      {
        aGE((String)localObject1);
        AppMethodBeat.o(240034);
        return;
      }
      AppMethodBeat.o(240034);
      return;
    }
    AppMethodBeat.o(240034);
  }
  
  private final int si(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.rmJ != 0) {}
    }
    while (this.rmJ == this.mMaxCount - 1)
    {
      return 2131100570;
      return 2131099844;
    }
    return 2131099844;
  }
  
  public final void aGE(String paramString)
  {
    AppMethodBeat.i(240032);
    p.h(paramString, "str");
    Object localObject = this.zXv;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.zXw;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    this.zXB = paramString;
    localObject = this.zXv;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    paramString = this.zXv;
    if (paramString != null)
    {
      localObject = this.zXz;
      if (localObject != null)
      {
        Context localContext = paramString.getContext();
        p.g(localContext, "it.context");
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(si(true)));
      }
      localObject = this.zXA;
      if (localObject != null)
      {
        paramString = paramString.getContext();
        p.g(paramString, "it.context");
        ((WeImageView)localObject).setIconColor(paramString.getResources().getColor(si(false)));
        AppMethodBeat.o(240032);
        return;
      }
      AppMethodBeat.o(240032);
      return;
    }
    AppMethodBeat.o(240032);
  }
  
  public final View c(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(240033);
    p.h(paramContext, "context");
    p.h(paramFrameLayout, "viewGroup");
    if (this.zQD.epg())
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131495746, (ViewGroup)paramFrameLayout);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(240033);
        throw paramContext;
      }
      this.zXw = ((FrameLayout)paramContext);
      epD();
    }
    for (;;)
    {
      paramContext = (View)this.zXw;
      AppMethodBeat.o(240033);
      return paramContext;
      paramContext = LayoutInflater.from(paramContext).inflate(2131495745, (ViewGroup)paramFrameLayout);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(240033);
        throw paramContext;
      }
      this.zXw = ((FrameLayout)paramContext);
      epD();
    }
  }
  
  public final void eoD()
  {
    AppMethodBeat.i(240035);
    Object localObject = this.zXv;
    if (localObject != null)
    {
      WeImageView localWeImageView = this.zXz;
      if (localWeImageView != null)
      {
        Context localContext = ((TextView)localObject).getContext();
        p.g(localContext, "it.context");
        localWeImageView.setIconColor(localContext.getResources().getColor(si(true)));
      }
      localWeImageView = this.zXA;
      if (localWeImageView != null)
      {
        localObject = ((TextView)localObject).getContext();
        p.g(localObject, "it.context");
        localWeImageView.setIconColor(((Context)localObject).getResources().getColor(si(false)));
        AppMethodBeat.o(240035);
        return;
      }
      AppMethodBeat.o(240035);
      return;
    }
    AppMethodBeat.o(240035);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240030);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.zXC.rmJ == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240030);
        return;
      }
      paramView = f.zZd;
      f.eqv();
      paramView = this.zXC;
      paramView.rmJ -= 1;
      this.zXC.aGE(this.zXC.rmJ + 1 + '/' + this.zXC.mMaxCount);
      paramView = new Bundle();
      paramView.putInt("thumb_flip_target_position", this.zXC.rmJ);
      this.zXC.zQD.a(a.c.zVu, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240030);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$1$2"})
  static final class b
    implements View.OnClickListener
  {
    b(n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240031);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.zXC.rmJ == this.zXC.mMaxCount - 1)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240031);
        return;
      }
      paramView = f.zZd;
      f.eqv();
      paramView = this.zXC;
      paramView.rmJ += 1;
      this.zXC.aGE(this.zXC.rmJ + 1 + '/' + this.zXC.mMaxCount);
      paramView = new Bundle();
      paramView.putInt("thumb_flip_target_position", this.zXC.rmJ);
      this.zXC.zQD.a(a.c.zVu, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240031);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.n
 * JD-Core Version:    0.7.0.1
 */