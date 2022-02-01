package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI;", "", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "mCurrentIndex", "", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "mCurrentStr", "", "getMCurrentStr", "()Ljava/lang/String;", "setMCurrentStr", "(Ljava/lang/String;)V", "mLeftArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mLeftRoot", "Landroid/widget/FrameLayout;", "mMaxCount", "getMMaxCount", "setMMaxCount", "mRightArrow", "mRightRoot", "mScreenThumbIndexTv", "Landroid/widget/TextView;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "thumbnailIndexRoot", "applyTouchEvent", "", "getIconSelectColor", "isLeftArrow", "", "getLayout", "Landroid/view/View;", "context", "Landroid/content/Context;", "viewGroup", "refreshLayout", "showIndexText", "str", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  private a Lsq;
  private TextView LyX;
  private FrameLayout LyY;
  private FrameLayout LyZ;
  private FrameLayout Lza;
  private WeImageView Lzb;
  private WeImageView Lzc;
  private String Lzd;
  int sfk;
  int xYG;
  
  public l(a parama)
  {
    AppMethodBeat.i(285626);
    this.Lsq = parama;
    this.xYG = -1;
    this.sfk = -1;
    AppMethodBeat.o(285626);
  }
  
  private static final void a(l paraml, View paramView)
  {
    AppMethodBeat.i(285653);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    if (paraml.xYG == 0)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285653);
      return;
    }
    paramView = g.LAS;
    g.gjq();
    paraml.xYG -= 1;
    paraml.aNJ(paraml.xYG + 1 + '/' + paraml.sfk);
    paramView = new Bundle();
    paramView.putInt("thumb_flip_target_position", paraml.xYG);
    paraml.Lsq.a(a.c.Lxg, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(285653);
  }
  
  private static final void b(l paraml, View paramView)
  {
    AppMethodBeat.i(285660);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    if (paraml.xYG == paraml.sfk - 1)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285660);
      return;
    }
    paramView = g.LAS;
    g.gjq();
    paraml.xYG += 1;
    paraml.aNJ(paraml.xYG + 1 + '/' + paraml.sfk);
    paramView = new Bundle();
    paramView.putInt("thumb_flip_target_position", paraml.xYG);
    paraml.Lsq.a(a.c.Lxg, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectThumbIndexUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(285660);
  }
  
  private void giq()
  {
    AppMethodBeat.i(285634);
    Object localObject1 = this.LyY;
    if (localObject1 != null)
    {
      this.LyX = ((TextView)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_iv));
      Object localObject2 = this.LyX;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(4);
      }
      localObject2 = this.LyY;
      if (localObject2 != null) {
        ((FrameLayout)localObject2).setVisibility(4);
      }
      this.Lzb = ((WeImageView)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_left_iv));
      this.Lzc = ((WeImageView)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_right_iv));
      this.LyZ = ((FrameLayout)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_left_root));
      this.Lza = ((FrameLayout)((FrameLayout)localObject1).findViewById(a.e.screen_thumb_index_right_root));
      localObject2 = this.Lzb;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setRotation(180.0F);
      }
      localObject2 = this.Lzb;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setImageDrawable(bb.m(((FrameLayout)localObject1).getContext(), a.g.icons_filled_arrow, zy(true)));
      }
      localObject2 = this.Lzb;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(((FrameLayout)localObject1).getContext().getResources().getColor(zy(true)));
      }
      localObject2 = this.Lzc;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setImageDrawable(bb.m(((FrameLayout)localObject1).getContext(), a.g.icons_filled_arrow, zy(false)));
      }
      localObject2 = this.Lzc;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setIconColor(((FrameLayout)localObject1).getContext().getResources().getColor(zy(false)));
      }
      localObject1 = this.LyZ;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setOnClickListener(new l..ExternalSyntheticLambda1(this));
      }
      localObject1 = this.Lza;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).setOnClickListener(new l..ExternalSyntheticLambda0(this));
      }
      localObject1 = this.Lzd;
      if (localObject1 != null) {
        aNJ((String)localObject1);
      }
    }
    AppMethodBeat.o(285634);
  }
  
  private final int zy(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.xYG == 0) {
        return a.b.grey;
      }
      return a.b.White;
    }
    if (this.xYG == this.sfk - 1) {
      return a.b.grey;
    }
    return a.b.White;
  }
  
  public final void aNJ(String paramString)
  {
    AppMethodBeat.i(285679);
    s.u(paramString, "str");
    Object localObject = this.LyX;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.LyY;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    this.Lzd = paramString;
    localObject = this.LyX;
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)paramString);
    }
    paramString = this.LyX;
    if (paramString != null)
    {
      localObject = this.Lzb;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramString.getContext().getResources().getColor(zy(true)));
      }
      localObject = this.Lzc;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(paramString.getContext().getResources().getColor(zy(false)));
      }
    }
    AppMethodBeat.o(285679);
  }
  
  public final void exz()
  {
    AppMethodBeat.i(285698);
    TextView localTextView = this.LyX;
    if (localTextView != null)
    {
      WeImageView localWeImageView = this.Lzb;
      if (localWeImageView != null) {
        localWeImageView.setIconColor(localTextView.getContext().getResources().getColor(zy(true)));
      }
      localWeImageView = this.Lzc;
      if (localWeImageView != null) {
        localWeImageView.setIconColor(localTextView.getContext().getResources().getColor(zy(false)));
      }
    }
    AppMethodBeat.o(285698);
  }
  
  public final View f(Context paramContext, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(285687);
    s.u(paramContext, "context");
    s.u(paramFrameLayout, "viewGroup");
    if (this.Lsq.ghV())
    {
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.multitalk_screen_project_thumb_index_layout_in_doodle, (ViewGroup)paramFrameLayout);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(285687);
        throw paramContext;
      }
      this.LyY = ((FrameLayout)paramContext);
      giq();
    }
    for (;;)
    {
      paramContext = (View)this.LyY;
      AppMethodBeat.o(285687);
      return paramContext;
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.multitalk_screen_project_thumb_index_layout, (ViewGroup)paramFrameLayout);
      if (paramContext == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        AppMethodBeat.o(285687);
        throw paramContext;
      }
      this.LyY = ((FrameLayout)paramContext);
      giq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.l
 * JD-Core Version:    0.7.0.1
 */