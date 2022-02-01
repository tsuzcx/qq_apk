package com.tencent.mm.plugin.textstatus.j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/UIHelper;", "", "()V", "TAG", "", "blurBitmap", "Landroid/graphics/Bitmap;", "bitmap", "context", "Landroid/content/Context;", "blurRadius", "", "getAvatarBitmap", "username", "recurSetTextColor", "", "v", "Landroid/view/View;", "textColor", "", "oriMap", "", "Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "resetOriTextColor", "map", "", "roundCorner", "view", "cornerRadius", "plugin-textstatus_release"})
public final class f
{
  public static final f Ggk;
  
  static
  {
    AppMethodBeat.i(216708);
    Ggk = new f();
    AppMethodBeat.o(216708);
  }
  
  public static void B(View paramView, float paramFloat)
  {
    AppMethodBeat.i(216702);
    if (paramView != null) {
      paramView.setOutlineProvider((ViewOutlineProvider)new f.a(paramFloat));
    }
    if (paramView != null)
    {
      paramView.setClipToOutline(true);
      AppMethodBeat.o(216702);
      return;
    }
    AppMethodBeat.o(216702);
  }
  
  public static Bitmap a(Bitmap paramBitmap, Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(216703);
    kotlin.g.b.p.h(paramContext, "context");
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
        AppMethodBeat.o(216703);
        return null;
      }
      Bitmap localBitmap = paramContext.b(localBitmap, paramFloat);
      paramContext.destroy();
      AppMethodBeat.o(216703);
      return localBitmap;
    }
    catch (Throwable paramContext)
    {
      AppMethodBeat.o(216703);
    }
    return paramBitmap;
  }
  
  public static void aT(Map<TextView, ? extends ColorStateList> paramMap)
  {
    AppMethodBeat.i(216706);
    if (paramMap == null)
    {
      AppMethodBeat.o(216706);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      ((TextView)localEntry.getKey()).setTextColor((ColorStateList)localEntry.getValue());
    }
    AppMethodBeat.o(216706);
  }
  
  public static Bitmap aTs(String paramString)
  {
    AppMethodBeat.i(216705);
    Bitmap localBitmap2 = com.tencent.mm.aj.p.aYD().K(paramString, false);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap1 = localBitmap2;
      if (kotlin.g.b.p.j(a.ceA(), paramString))
      {
        paramString = g.aAh();
        kotlin.g.b.p.g(paramString, "MMKernel.storage()");
        paramString = (String)paramString.azQ().i(ar.a.Ogr);
        a.ceA();
        localBitmap1 = com.tencent.mm.aj.e.Mq(paramString);
      }
    }
    if (localBitmap1 == null) {
      Log.e("MicroMsg.TxtStatus.UIHelper", "[getAvatarFromFile] bitmap=null");
    }
    AppMethodBeat.o(216705);
    return localBitmap1;
  }
  
  public final void a(View paramView, int paramInt, Map<TextView, ColorStateList> paramMap)
  {
    AppMethodBeat.i(216707);
    kotlin.g.b.p.h(paramMap, "oriMap");
    if (paramView == null)
    {
      AppMethodBeat.o(216707);
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
      kotlin.g.b.p.g(localColorStateList, "v.textColors");
      paramMap.put(paramView, localColorStateList);
      ((TextView)paramView).setTextColor(paramInt);
    }
    AppMethodBeat.o(216707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.f
 * JD-Core Version:    0.7.0.1
 */