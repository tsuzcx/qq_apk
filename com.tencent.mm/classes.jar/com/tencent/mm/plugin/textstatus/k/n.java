package com.tencent.mm.plugin.textstatus.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.e;
import com.tencent.mm.am.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/UIHelper;", "", "()V", "TAG", "", "blurBitmap", "Landroid/graphics/Bitmap;", "bitmap", "context", "Landroid/content/Context;", "blurRadius", "", "getAvatarBitmap", "username", "recurSetTextColor", "", "v", "Landroid/view/View;", "textColor", "", "oriMap", "", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "resetOriTextColor", "map", "", "roundCorner", "view", "cornerRadius", "roundCornerWithWidthPercent", "widthPercent", "plugin-textstatus_release"})
public final class n
{
  public static final n MOY;
  
  static
  {
    AppMethodBeat.i(233022);
    MOY = new n();
    AppMethodBeat.o(233022);
  }
  
  public static void B(View paramView, float paramFloat)
  {
    AppMethodBeat.i(233015);
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new a(paramFloat));
    }
    if (paramView != null)
    {
      paramView.setClipToOutline(true);
      AppMethodBeat.o(233015);
      return;
    }
    AppMethodBeat.o(233015);
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(233017);
    p.k(paramContext, "context");
    try
    {
      paramContext = new com.tencent.mm.ui.blur.f(paramContext);
      if (paramBitmap != null)
      {
        localBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
        if (localBitmap != null) {}
      }
      else
      {
        AppMethodBeat.o(233017);
        return null;
      }
      Bitmap localBitmap = paramContext.b(localBitmap, paramFloat);
      paramContext.destroy();
      AppMethodBeat.o(233017);
      return localBitmap;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(233017);
    }
    return paramBitmap;
  }
  
  public static void aN(Map<TextView, ? extends ColorStateList> paramMap)
  {
    AppMethodBeat.i(233020);
    if (paramMap == null)
    {
      AppMethodBeat.o(233020);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      ((TextView)localEntry.getKey()).setTextColor((ColorStateList)localEntry.getValue());
    }
    AppMethodBeat.o(233020);
  }
  
  public static Bitmap beQ(String paramString)
  {
    AppMethodBeat.i(233019);
    Bitmap localBitmap2 = q.bhR().M(paramString, false);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = localBitmap2;
      if (p.h(a.crN(), paramString))
      {
        paramString = h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString = (String)paramString.aHp().j(ar.a.VuH);
        a.crN();
        localBitmap1 = com.tencent.mm.am.f.TL(paramString);
      }
    }
    if (localBitmap1 == null) {
      Log.e("MicroMsg.TextStatus.UIHelper", "[getAvatarFromFile] bitmap=null");
    }
    AppMethodBeat.o(233019);
    return localBitmap1;
  }
  
  public static void hb(View paramView)
  {
    AppMethodBeat.i(233016);
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new b());
    }
    if (paramView != null)
    {
      paramView.setClipToOutline(true);
      AppMethodBeat.o(233016);
      return;
    }
    AppMethodBeat.o(233016);
  }
  
  public final void a(View paramView, int paramInt, Map<TextView, ColorStateList> paramMap)
  {
    AppMethodBeat.i(233021);
    p.k(paramMap, "oriMap");
    if (paramView == null)
    {
      AppMethodBeat.o(233021);
      return;
    }
    if ((paramView instanceof ViewGroup))
    {
      int i = 0;
      int j = ((ViewGroup)paramView).getChildCount();
      while (i < j)
      {
        a(((ViewGroup)paramView).getChildAt(i), paramInt, paramMap);
        i += 1;
      }
    }
    if ((paramView instanceof TextView))
    {
      ColorStateList localColorStateList = ((TextView)paramView).getTextColors();
      p.j(localColorStateList, "v.textColors");
      if (paramInt != localColorStateList.getDefaultColor())
      {
        localColorStateList = ((TextView)paramView).getTextColors();
        p.j(localColorStateList, "v.textColors");
        paramMap.put(paramView, localColorStateList);
      }
      ((TextView)paramView).setTextColor(paramInt);
    }
    AppMethodBeat.o(233021);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/util/UIHelper$roundCorner$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"})
  public static final class a
    extends ViewOutlineProvider
  {
    a(float paramFloat) {}
    
    public final void getOutline(View paramView, Outline paramOutline)
    {
      AppMethodBeat.i(236052);
      p.k(paramView, "view");
      p.k(paramOutline, "outline");
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.MOZ);
      AppMethodBeat.o(236052);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/util/UIHelper$roundCornerWithWidthPercent$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"})
  public static final class b
    extends ViewOutlineProvider
  {
    public final void getOutline(View paramView, Outline paramOutline)
    {
      AppMethodBeat.i(238350);
      p.k(paramView, "view");
      p.k(paramOutline, "outline");
      paramOutline.setRoundRect(0, 0, paramView.getWidth(), paramView.getHeight(), this.MPa * paramView.getWidth());
      AppMethodBeat.o(238350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.n
 * JD-Core Version:    0.7.0.1
 */