package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil$Companion;", "", "()V", "inflateBigAvatarLayout", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "clickListener", "Landroid/view/View$OnClickListener;", "startLoadingAnimation", "", "holder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "stopLoadingAnimation", "plugin-multitalk_release"})
public final class c$a
{
  public static void e(b paramb)
  {
    AppMethodBeat.i(178967);
    k.h(paramb, "holder");
    Object localObject = paramb.uxs;
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getBackground();
      if (localObject == null) {
        break label142;
      }
      localObject = paramb.uxs;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = paramb.uxs;
      if (localObject == null) {
        break label83;
      }
    }
    label83:
    for (localObject = ((ImageView)localObject).getBackground();; localObject = null)
    {
      if (localObject != null) {
        break label88;
      }
      paramb = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      AppMethodBeat.o(178967);
      throw paramb;
      localObject = null;
      break;
    }
    label88:
    ((AnimationDrawable)localObject).stop();
    paramb = paramb.uxs;
    if (paramb != null) {}
    for (paramb = paramb.getBackground(); paramb == null; paramb = null)
    {
      paramb = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      AppMethodBeat.o(178967);
      throw paramb;
    }
    ((AnimationDrawable)paramb).start();
    label142:
    AppMethodBeat.o(178967);
  }
  
  public static void f(b paramb)
  {
    Object localObject2 = null;
    AppMethodBeat.i(178968);
    k.h(paramb, "holder");
    Object localObject1 = paramb.uxs;
    if (localObject1 != null) {
      localObject1 = ((ImageView)localObject1).getBackground();
    }
    while (localObject1 != null)
    {
      ImageView localImageView = paramb.uxs;
      localObject1 = localObject2;
      if (localImageView != null) {
        localObject1 = localImageView.getBackground();
      }
      if (localObject1 == null)
      {
        paramb = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(178968);
        throw paramb;
        localObject1 = null;
      }
      else
      {
        ((AnimationDrawable)localObject1).stop();
      }
    }
    paramb = paramb.uxs;
    if (paramb != null)
    {
      paramb.setVisibility(8);
      AppMethodBeat.o(178968);
      return;
    }
    AppMethodBeat.o(178968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.c.a
 * JD-Core Version:    0.7.0.1
 */