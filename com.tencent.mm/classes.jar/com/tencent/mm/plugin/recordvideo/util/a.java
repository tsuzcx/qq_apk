package com.tencent.mm.plugin.recordvideo.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/AccessibilityUtil;", "", "()V", "getFontSizeWithoutScale", "", "context", "Landroid/content/Context;", "fontSize", "withOutScale", "", "Landroid/view/View;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Obi;
  
  static
  {
    AppMethodBeat.i(279561);
    Obi = new a();
    AppMethodBeat.o(279561);
  }
  
  public static float g(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(279532);
    s.u(paramContext, "context");
    Object localObject1 = paramContext.getSystemService("window");
    if (localObject1 == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(279532);
      throw paramContext;
    }
    Object localObject2 = (WindowManager)localObject1;
    localObject1 = new DisplayMetrics();
    localObject2 = ((WindowManager)localObject2).getDefaultDisplay();
    if (localObject2 != null) {
      ((Display)localObject2).getMetrics((DisplayMetrics)localObject1);
    }
    paramFloat = ((DisplayMetrics)localObject1).density * paramFloat / paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(279532);
    return paramFloat;
  }
  
  public static void iM(View paramView)
  {
    AppMethodBeat.i(279540);
    s.u(paramView, "<this>");
    paramView.post(new a..ExternalSyntheticLambda0(paramView));
    AppMethodBeat.o(279540);
  }
  
  private static final void iN(View paramView)
  {
    AppMethodBeat.i(279554);
    s.u(paramView, "$this_withOutScale");
    Object localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int i = (int)g((Context)localObject1, paramView.getPaddingLeft());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int j = (int)g((Context)localObject1, paramView.getPaddingRight());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    int k = (int)g((Context)localObject1, paramView.getPaddingTop());
    localObject1 = paramView.getContext();
    s.s(localObject1, "context");
    paramView.setPadding(i, k, j, (int)g((Context)localObject1, paramView.getPaddingBottom()));
    localObject1 = paramView.getLayoutParams();
    Object localObject2;
    if (((ViewGroup.LayoutParams)localObject1).width > 0)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "context");
      ((ViewGroup.LayoutParams)localObject1).width = ((int)g((Context)localObject2, ((ViewGroup.LayoutParams)localObject1).width));
    }
    if (((ViewGroup.LayoutParams)localObject1).height > 0)
    {
      localObject2 = paramView.getContext();
      s.s(localObject2, "context");
      ((ViewGroup.LayoutParams)localObject1).height = ((int)g((Context)localObject2, ((ViewGroup.LayoutParams)localObject1).height));
    }
    if ((localObject1 instanceof FrameLayout.LayoutParams))
    {
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      Context localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).leftMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).leftMargin));
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).rightMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).rightMargin));
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).topMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).topMargin));
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      localContext = paramView.getContext();
      s.s(localContext, "context");
      ((FrameLayout.LayoutParams)localObject2).bottomMargin = ((int)g(localContext, ((FrameLayout.LayoutParams)localObject1).bottomMargin));
    }
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    AppMethodBeat.o(279554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.a
 * JD-Core Version:    0.7.0.1
 */