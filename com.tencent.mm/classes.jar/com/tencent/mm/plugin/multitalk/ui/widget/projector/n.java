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
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentIndex", "", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "mCurrentStr", "", "getMCurrentStr", "()Ljava/lang/String;", "setMCurrentStr", "(Ljava/lang/String;)V", "mLeftArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mLeftRoot", "Landroid/widget/FrameLayout;", "mMaxCount", "getMMaxCount", "setMMaxCount", "mRightArrow", "mRightRoot", "mScreenThumbIndexTv", "Landroid/widget/TextView;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "thumbnailIndexRoot", "applyTouchEvent", "", "getIconSelectColor", "isLeftArrow", "", "getLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "refreshLayout", "showIndexText", "str", "plugin-multitalk_release"})
public final class n
{
  private TextView FDh;
  private FrameLayout FDi;
  private FrameLayout FDj;
  private FrameLayout FDk;
  private WeImageView FDl;
  private WeImageView FDm;
  private String FDn;
  a Fwg;
  int mMaxCount;
  int uPV;
  
  public n(a parama)
  {
    AppMethodBeat.i(206626);
    this.Fwg = parama;
    this.uPV = -1;
    this.mMaxCount = -1;
    AppMethodBeat.o(206626);
  }
  
  private void eZr()
  {
    AppMethodBeat.i(206619);
    Object localObject1 = this.FDi;
    if (localObject1 != null)
    {
      this.FDh = ((TextView)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_iv));
      Object localObject2 = this.FDh;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(4);
      }
      localObject2 = this.FDi;
      if (localObject2 != null) {
        ((FrameLayout)localObject2).setVisibility(4);
      }
      this.FDl = ((WeImageView)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_left_iv));
      this.FDm = ((WeImageView)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_right_iv));
      this.FDj = ((FrameLayout)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_left_root));
      this.FDk = ((FrameLayout)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_right_root));
      localObject2 = this.FDl;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setRotation(180.0F);
      }
      localObject2 = this.FDl;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setImageDrawable(au.o(((FrameLayout)localObject1).getContext(), a.g.icons_filled_arrow, vk(true)));
      }
      localObject2 = this.FDl;
      if (localObject2 != null)
      {
        Context localContext = ((FrameLayout)localObject1).getContext();
        p.j(localContext, "it.context");
        ((WeImageView)localObject2).setIconColor(localContext.getResources().getColor(vk(true)));
      }
      localObject2 = this.FDm;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setImageDrawable(au.o(((FrameLayout)localObject1).getContext(), a.g.icons_filled_arrow, vk(false)));
      }
      localObject2 = this.FDm;
      if (localObject2 != null)
      {
        localObject1 = ((FrameLayout)localObject1).getContext();
        p.j(localObject1, "it.context");
        ((WeImageView)localObject2).setIconColor(((Context)localObject1).getResources().getColor(vk(false)));
      }
      localObject1 = this.FDj;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new a(this));
      }
      localObject1 = this.FDk;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new b(this));
      }
      localObject1 = this.FDn;
      if (localObject1 != null)
      {
        aQS((String)localObject1);
        AppMethodBeat.o(206619);
        return;
      }
      AppMethodBeat.o(206619);
      return;
    }
    AppMethodBeat.o(206619);
  }
  
  private final int vk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.uPV == 0) {
        return a.b.grey;
      }
      return a.b.White;
    }
    if (this.uPV == this.mMaxCount - 1) {
      return a.b.grey;
    }
    return a.b.White;
  }
  
  public final void aQS(String paramString)
  {
    AppMethodBeat.i(206613);
    p.k(paramString, "str");
    Object localObject = this.FDh;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.FDi;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    this.FDn = paramString;
    localObject = this.FDh;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    paramString = this.FDh;
    if (paramString != null)
    {
      localObject = this.FDl;
      if (localObject != null)
      {
        Context localContext = paramString.getContext();
        p.j(localContext, "it.context");
        ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(vk(true)));
      }
      localObject = this.FDm;
      if (localObject != null)
      {
        paramString = paramString.getContext();
        p.j(paramString, "it.context");
        ((WeImageView)localObject).setIconColor(paramString.getResources().getColor(vk(false)));
        AppMethodBeat.o(206613);
        return;
      }
      AppMethodBeat.o(206613);
      return;
    }
    AppMethodBeat.o(206613);
  }
  
  public final View c(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(206616);
    p.k(paramContext, "context");
    p.k(paramFrameLayout, "viewGroup");
    if (this.Fwg.eYW())
    {
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.multitalk_screen_project_thumb_index_layout_in_doodle, (ViewGroup)paramFrameLayout);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(206616);
        throw paramContext;
      }
      this.FDi = ((FrameLayout)paramContext);
      eZr();
    }
    for (;;)
    {
      paramContext = (View)this.FDi;
      AppMethodBeat.o(206616);
      return paramContext;
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.multitalk_screen_project_thumb_index_layout, (ViewGroup)paramFrameLayout);
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(206616);
        throw paramContext;
      }
      this.FDi = ((FrameLayout)paramContext);
      eZr();
    }
  }
  
  public final void dGn()
  {
    AppMethodBeat.i(206624);
    Object localObject = this.FDh;
    if (localObject != null)
    {
      WeImageView localWeImageView = this.FDl;
      if (localWeImageView != null)
      {
        Context localContext = ((TextView)localObject).getContext();
        p.j(localContext, "it.context");
        localWeImageView.setIconColor(localContext.getResources().getColor(vk(true)));
      }
      localWeImageView = this.FDm;
      if (localWeImageView != null)
      {
        localObject = ((TextView)localObject).getContext();
        p.j(localObject, "it.context");
        localWeImageView.setIconColor(((Context)localObject).getResources().getColor(vk(false)));
        AppMethodBeat.o(206624);
        return;
      }
      AppMethodBeat.o(206624);
      return;
    }
    AppMethodBeat.o(206624);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(195719);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.FDo.uPV == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(195719);
        return;
      }
      paramView = f.FEQ;
      f.fal();
      paramView = this.FDo;
      paramView.uPV -= 1;
      this.FDo.aQS(this.FDo.uPV + 1 + '/' + this.FDo.mMaxCount);
      paramView = new Bundle();
      paramView.putInt("thumb_flip_target_position", this.FDo.uPV);
      this.FDo.Fwg.a(a.c.FBe, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(195719);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$1$2"})
  static final class b
    implements View.OnClickListener
  {
    b(n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201878);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.FDo.uPV == this.FDo.mMaxCount - 1)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201878);
        return;
      }
      paramView = f.FEQ;
      f.fal();
      paramView = this.FDo;
      paramView.uPV += 1;
      this.FDo.aQS(this.FDo.uPV + 1 + '/' + this.FDo.mMaxCount);
      paramView = new Bundle();
      paramView.putInt("thumb_flip_target_position", this.FDo.uPV);
      this.FDo.Fwg.a(a.c.FBe, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI$applyTouchEvent$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201878);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.n
 * JD-Core Version:    0.7.0.1
 */