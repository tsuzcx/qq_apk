package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil;", "", "()V", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final a Ltc;
  
  static
  {
    AppMethodBeat.i(178969);
    Ltc = new a((byte)0);
    AppMethodBeat.o(178969);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil$Companion;", "", "()V", "inflateBigAvatarLayout", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "clickListener", "Landroid/view/View$OnClickListener;", "startLoadingAnimation", "", "holder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "stopLoadingAnimation", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void h(b paramb)
    {
      AppMethodBeat.i(178967);
      s.u(paramb, "holder");
      Object localObject = paramb.KGG;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label142;
        }
        localObject = paramb.KGG;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = paramb.KGG;
        if (localObject != null) {
          break label80;
        }
      }
      label80:
      for (localObject = null;; localObject = ((ImageView)localObject).getBackground())
      {
        if (localObject != null) {
          break label88;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(178967);
        throw paramb;
        localObject = ((ImageView)localObject).getBackground();
        break;
      }
      label88:
      ((AnimationDrawable)localObject).stop();
      paramb = paramb.KGG;
      if (paramb == null) {}
      for (paramb = null; paramb == null; paramb = paramb.getBackground())
      {
        paramb = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(178967);
        throw paramb;
      }
      ((AnimationDrawable)paramb).start();
      label142:
      AppMethodBeat.o(178967);
    }
    
    public static void i(b paramb)
    {
      Object localObject2 = null;
      AppMethodBeat.i(178968);
      s.u(paramb, "holder");
      Object localObject1 = paramb.KGG;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label83;
        }
        localObject1 = paramb.KGG;
        if (localObject1 != null) {
          break label68;
        }
      }
      label68:
      for (localObject1 = localObject2;; localObject1 = ((ImageView)localObject1).getBackground())
      {
        if (localObject1 != null) {
          break label76;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AppMethodBeat.o(178968);
        throw paramb;
        localObject1 = ((ImageView)localObject1).getBackground();
        break;
      }
      label76:
      ((AnimationDrawable)localObject1).stop();
      label83:
      paramb = paramb.KGG;
      if (paramb != null) {
        paramb.setVisibility(8);
      }
      AppMethodBeat.o(178968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */