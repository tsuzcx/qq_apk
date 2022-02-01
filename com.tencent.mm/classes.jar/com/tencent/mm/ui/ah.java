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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/ScreenSizeUtil;", "", "()V", "get", "Lcom/tencent/mm/ui/ScreenSizeUtil$Size;", "_context", "Landroid/content/Context;", "Size", "wechat-ui-sdk_release"})
public final class ah
{
  public static final ah OKD;
  
  static
  {
    AppMethodBeat.i(175972);
    OKD = new ah();
    AppMethodBeat.o(175972);
  }
  
  public static final a jS(Context paramContext)
  {
    AppMethodBeat.i(175971);
    Context localContext = paramContext;
    if (paramContext == null)
    {
      paramContext = MMApplicationContext.getContext();
      localContext = paramContext;
      if (paramContext == null)
      {
        p.hyc();
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
      paramContext = new a(paramContext.x, paramContext.y);
      AppMethodBeat.o(175971);
      return paramContext;
    }
    paramContext = localContext.getResources();
    p.g(paramContext, "context.resources");
    int i = paramContext.getDisplayMetrics().widthPixels;
    paramContext = localContext.getResources();
    p.g(paramContext, "context.resources");
    paramContext = new a(i, paramContext.getDisplayMetrics().heightPixels);
    AppMethodBeat.o(175971);
    return paramContext;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/ScreenSizeUtil$Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "wechat-ui-sdk_release"})
  public static final class a
  {
    public final int height;
    public final int width;
    
    public a(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.width * 31 + this.height;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(175970);
      String str = "Size(width=" + this.width + ", height=" + this.height + ")";
      AppMethodBeat.o(175970);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ah
 * JD-Core Version:    0.7.0.1
 */