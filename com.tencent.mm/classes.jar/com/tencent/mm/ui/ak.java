package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/ScreenSizeUtil;", "", "()V", "get", "Lcom/tencent/mm/ui/ScreenSizeUtil$Size;", "_context", "Landroid/content/Context;", "Size", "wechat-ui-sdk_release"})
public final class ak
{
  public static final ak Web;
  
  static
  {
    AppMethodBeat.i(175972);
    Web = new ak();
    AppMethodBeat.o(175972);
  }
  
  public static final ak.a kU(Context paramContext)
  {
    AppMethodBeat.i(175971);
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = MMApplicationContext.getContext();
      localContext = paramContext;
      if (paramContext == null)
      {
        p.iCn();
        localContext = paramContext;
      }
    }
    Object localObject = (WindowManager)localContext.getSystemService("window");
    paramContext = new Point();
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (localObject != null) {
        ((Display)localObject).getRealSize(paramContext);
      }
    }
    if ((paramContext.x != 0) && (paramContext.y != 0))
    {
      paramContext = new ak.a(paramContext.x, paramContext.y);
      AppMethodBeat.o(175971);
      return paramContext;
    }
    paramContext = localContext.getResources();
    p.j(paramContext, "context.resources");
    int i = paramContext.getDisplayMetrics().widthPixels;
    paramContext = localContext.getResources();
    p.j(paramContext, "context.resources");
    paramContext = new ak.a(i, paramContext.getDisplayMetrics().heightPixels);
    AppMethodBeat.o(175971);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ak
 * JD-Core Version:    0.7.0.1
 */