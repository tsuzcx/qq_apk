package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil;", "", "()V", "Companion", "plugin-multitalk_release"})
public final class c
{
  public static final a tRa;
  
  static
  {
    AppMethodBeat.i(178969);
    tRa = new a((byte)0);
    AppMethodBeat.o(178969);
  }
  
  public static final RelativeLayout a(Context paramContext, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(178972);
    k.h(paramContext, "context");
    k.h(paramViewGroup, "parent");
    k.h(paramOnClickListener, "clickListener");
    paramContext = LayoutInflater.from(paramContext).inflate(2131494685, paramViewGroup, false);
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramContext = (RelativeLayout)paramContext;
    paramViewGroup = new b((View)paramContext);
    Object localObject = paramContext.findViewById(2131305671);
    if (localObject == null)
    {
      paramContext = new v("null cannot be cast to non-null type com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.tQS = ((MultiTalkVideoView)localObject);
    localObject = paramViewGroup.tQS;
    if (localObject != null) {
      ((MultiTalkVideoView)localObject).setIndex(0);
    }
    localObject = paramViewGroup.tQS;
    if (localObject != null) {
      ((MultiTalkVideoView)localObject).setOnClickListener(paramOnClickListener);
    }
    paramViewGroup.lRB = paramContext.findViewById(2131302169);
    paramOnClickListener = paramContext.findViewById(2131306487);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.tQT = ((ImageView)paramOnClickListener);
    paramOnClickListener = paramContext.findViewById(2131302597);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.tQU = ((ImageView)paramOnClickListener);
    paramOnClickListener = paramContext.findViewById(2131305577);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.tQV = ((TextView)paramOnClickListener);
    paramOnClickListener = paramContext.findViewById(2131301502);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.tpa = ((ImageView)paramOnClickListener);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(178972);
    return paramContext;
  }
  
  public static final void a(b paramb)
  {
    AppMethodBeat.i(178970);
    a.a(paramb);
    AppMethodBeat.o(178970);
  }
  
  public static final void b(b paramb)
  {
    AppMethodBeat.i(178971);
    a.b(paramb);
    AppMethodBeat.o(178971);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil$Companion;", "", "()V", "inflateBigAvatarLayout", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "clickListener", "Landroid/view/View$OnClickListener;", "startLoadingAnimation", "", "holder", "Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarLayoutHolder;", "stopLoadingAnimation", "plugin-multitalk_release"})
  public static final class a
  {
    public static void a(b paramb)
    {
      AppMethodBeat.i(178967);
      k.h(paramb, "holder");
      Object localObject = paramb.tpa;
      if (localObject != null)
      {
        localObject = ((ImageView)localObject).getBackground();
        if (localObject == null) {
          break label142;
        }
        localObject = paramb.tpa;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = paramb.tpa;
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
      paramb = paramb.tpa;
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
    
    public static void b(b paramb)
    {
      Object localObject2 = null;
      AppMethodBeat.i(178968);
      k.h(paramb, "holder");
      Object localObject1 = paramb.tpa;
      if (localObject1 != null) {
        localObject1 = ((ImageView)localObject1).getBackground();
      }
      while (localObject1 != null)
      {
        ImageView localImageView = paramb.tpa;
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
      paramb = paramb.tpa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */