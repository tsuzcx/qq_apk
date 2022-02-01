package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil;", "", "()V", "Companion", "plugin-multitalk_release"})
public final class c
{
  public static final a zRp;
  
  static
  {
    AppMethodBeat.i(178969);
    zRp = new a((byte)0);
    AppMethodBeat.o(178969);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil$Companion;", "", "()V", "inflateBigAvatarLayout", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "clickListener", "Landroid/view/View$OnClickListener;", "startLoadingAnimation", "", "holder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "stopLoadingAnimation", "plugin-multitalk_release"})
  public static final class a
  {
    public static void g(b paramb)
    {
      AppMethodBeat.i(178967);
      p.h(paramb, "holder");
      Object localObject = paramb.zhh;
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).getBackground();
        if (localObject == null) {
          break label142;
        }
        localObject = paramb.zhh;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = paramb.zhh;
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
        paramb = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(178967);
        throw paramb;
        localObject = null;
        break;
      }
      label88:
      ((AnimationDrawable)localObject).stop();
      paramb = paramb.zhh;
      if (paramb != null) {}
      for (paramb = paramb.getBackground(); paramb == null; paramb = null)
      {
        paramb = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(178967);
        throw paramb;
      }
      ((AnimationDrawable)paramb).start();
      label142:
      AppMethodBeat.o(178967);
    }
    
    public static void h(b paramb)
    {
      Object localObject2 = null;
      AppMethodBeat.i(178968);
      p.h(paramb, "holder");
      Object localObject1 = paramb.zhh;
      if (localObject1 != null) {
        localObject1 = ((ImageView)localObject1).getBackground();
      }
      while (localObject1 != null)
      {
        ImageView localImageView = paramb.zhh;
        localObject1 = localObject2;
        if (localImageView != null) {
          localObject1 = localImageView.getBackground();
        }
        if (localObject1 == null)
        {
          paramb = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(178968);
          throw paramb;
          localObject1 = null;
        }
        else
        {
          ((AnimationDrawable)localObject1).stop();
        }
      }
      paramb = paramb.zhh;
      if (paramb != null)
      {
        paramb.setVisibility(8);
        AppMethodBeat.o(178968);
        return;
      }
      AppMethodBeat.o(178968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */