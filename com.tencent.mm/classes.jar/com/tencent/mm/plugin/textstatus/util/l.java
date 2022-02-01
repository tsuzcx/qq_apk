package com.tencent.mm.plugin.textstatus.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.blur.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/UIHelper;", "", "()V", "TAG", "", "blurBitmap", "Landroid/graphics/Bitmap;", "bitmap", "context", "Landroid/content/Context;", "blurRadius", "", "getAvatarBitmap", "username", "recurSetTextColor", "", "v", "Landroid/view/View;", "textColor", "", "oriMap", "", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "resetOriTextColor", "map", "", "roundCorner", "view", "cornerRadius", "roundCornerWithHeightPercent", "hPercent", "roundCornerWithWidthPercent", "widthPercent", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l TBz;
  
  static
  {
    AppMethodBeat.i(290409);
    TBz = new l();
    AppMethodBeat.o(290409);
  }
  
  public static void C(View paramView, float paramFloat)
  {
    AppMethodBeat.i(290380);
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new l.a(paramFloat));
    }
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    AppMethodBeat.o(290380);
  }
  
  public static void be(Map<TextView, ? extends ColorStateList> paramMap)
  {
    AppMethodBeat.i(290402);
    if (paramMap == null)
    {
      AppMethodBeat.o(290402);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      ((TextView)localEntry.getKey()).setTextColor((ColorStateList)localEntry.getValue());
    }
    AppMethodBeat.o(290402);
  }
  
  public static Bitmap e(Bitmap paramBitmap, Context paramContext)
  {
    AppMethodBeat.i(290397);
    s.u(paramContext, "context");
    try
    {
      f localf = new f(paramContext);
      if (paramBitmap == null) {}
      for (paramContext = null; paramContext == null; paramContext = paramBitmap.copy(paramBitmap.getConfig(), true)) {
        return null;
      }
      paramContext = localf.c(paramContext, 10.0F);
      localf.destroy();
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(290397);
    }
    return paramBitmap;
  }
  
  public static void km(View paramView)
  {
    AppMethodBeat.i(290387);
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new l.b());
    }
    if (paramView != null) {
      paramView.setClipToOutline(true);
    }
    AppMethodBeat.o(290387);
  }
  
  public final void a(View paramView, int paramInt, Map<TextView, ColorStateList> paramMap)
  {
    AppMethodBeat.i(290420);
    s.u(paramMap, "oriMap");
    if (paramView == null)
    {
      AppMethodBeat.o(290420);
      return;
    }
    int i;
    int k;
    if ((paramView instanceof ViewGroup))
    {
      i = 0;
      k = ((ViewGroup)paramView).getChildCount();
      if (k <= 0) {
        break label134;
      }
    }
    for (;;)
    {
      int j = i + 1;
      a(((ViewGroup)paramView).getChildAt(i), paramInt, paramMap);
      if (j >= k)
      {
        AppMethodBeat.o(290420);
        return;
        if ((paramView instanceof TextView))
        {
          if (paramInt != ((TextView)paramView).getTextColors().getDefaultColor())
          {
            ColorStateList localColorStateList = ((TextView)paramView).getTextColors();
            s.s(localColorStateList, "v.textColors");
            paramMap.put(paramView, localColorStateList);
          }
          ((TextView)paramView).setTextColor(paramInt);
        }
        label134:
        AppMethodBeat.o(290420);
        return;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.l
 * JD-Core Version:    0.7.0.1
 */