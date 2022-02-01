package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/multitalk/ui/widget/AvatarOperatorUtil;", "", "()V", "Companion", "plugin-multitalk_release"})
public final class c
{
  public static final c.a uZI;
  
  static
  {
    AppMethodBeat.i(178969);
    uZI = new c.a((byte)0);
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
    paramViewGroup.uZv = ((MultiTalkVideoView)localObject);
    localObject = paramViewGroup.uZv;
    if (localObject != null) {
      ((MultiTalkVideoView)localObject).setIndex(0);
    }
    localObject = paramViewGroup.uZv;
    if (localObject != null) {
      ((MultiTalkVideoView)localObject).setOnClickListener(paramOnClickListener);
    }
    paramViewGroup.gGk = paramContext.findViewById(2131302169);
    paramOnClickListener = paramContext.findViewById(2131306487);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.uZw = ((ImageView)paramOnClickListener);
    paramOnClickListener = paramContext.findViewById(2131302597);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.uZx = ((ImageView)paramOnClickListener);
    paramOnClickListener = paramContext.findViewById(2131305577);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.uZy = ((TextView)paramOnClickListener);
    paramOnClickListener = paramContext.findViewById(2131301502);
    if (paramOnClickListener == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.widget.ImageView");
      AppMethodBeat.o(178972);
      throw paramContext;
    }
    paramViewGroup.uxs = ((ImageView)paramOnClickListener);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(178972);
    return paramContext;
  }
  
  public static final void e(b paramb)
  {
    AppMethodBeat.i(178970);
    c.a.e(paramb);
    AppMethodBeat.o(178970);
  }
  
  public static final void f(b paramb)
  {
    AppMethodBeat.i(178971);
    c.a.f(paramb);
    AppMethodBeat.o(178971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */