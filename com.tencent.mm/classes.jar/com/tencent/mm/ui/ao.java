package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/ScreenSizeUtil;", "", "()V", "get", "Lcom/tencent/mm/ui/ScreenSizeUtil$Size;", "_context", "Landroid/content/Context;", "Size", "wechat-ui-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  public static final ao adJE;
  
  static
  {
    AppMethodBeat.i(175972);
    adJE = new ao();
    AppMethodBeat.o(175972);
  }
  
  public static final a mX(Context paramContext)
  {
    Object localObject2 = null;
    AppMethodBeat.i(175971);
    Context localContext = paramContext;
    if (paramContext == null)
    {
      localContext = MMApplicationContext.getContext();
      s.checkNotNull(localContext);
    }
    WindowManager localWindowManager = (WindowManager)localContext.getSystemService("window");
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 30) {
      if (localWindowManager == null)
      {
        paramContext = null;
        if (localWindowManager != null) {
          break label139;
        }
        localObject1 = localObject2;
        label56:
        if (paramContext != null) {
          break label183;
        }
        label60:
        if (localObject1 != null) {
          break label257;
        }
      }
    }
    for (;;)
    {
      s.checkNotNull(paramContext);
      int i = paramContext.intValue();
      s.checkNotNull(localObject1);
      paramContext = new a(i, ((Integer)localObject1).intValue());
      AppMethodBeat.o(175971);
      return paramContext;
      paramContext = localWindowManager.getCurrentWindowMetrics();
      if (paramContext == null)
      {
        paramContext = null;
        break;
      }
      paramContext = paramContext.getBounds();
      if (paramContext == null)
      {
        paramContext = null;
        break;
      }
      paramContext = Integer.valueOf(paramContext.width());
      break;
      label139:
      Object localObject3 = localWindowManager.getCurrentWindowMetrics();
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label56;
      }
      localObject3 = ((WindowMetrics)localObject3).getBounds();
      localObject1 = localObject2;
      if (localObject3 == null) {
        break label56;
      }
      localObject1 = Integer.valueOf(((Rect)localObject3).height());
      break label56;
      label183:
      if (paramContext.intValue() != 0) {
        break label60;
      }
      label257:
      do
      {
        paramContext = new Point();
        if (localWindowManager != null)
        {
          localObject1 = localWindowManager.getDefaultDisplay();
          if (localObject1 != null) {
            ((Display)localObject1).getRealSize(paramContext);
          }
        }
        if ((paramContext.x == 0) || (paramContext.y == 0)) {
          break;
        }
        paramContext = new a(paramContext.x, paramContext.y);
        AppMethodBeat.o(175971);
        return paramContext;
      } while (((Integer)localObject1).intValue() == 0);
    }
    paramContext = new a(localContext.getResources().getDisplayMetrics().widthPixels, localContext.getResources().getDisplayMetrics().heightPixels);
    AppMethodBeat.o(175971);
    return paramContext;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/ScreenSizeUtil$Size;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "wechat-ui-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.width != paramObject.width) {
          return false;
        }
      } while (this.height == paramObject.height);
      return false;
    }
    
    public final int hashCode()
    {
      return this.width * 31 + this.height;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(175970);
      String str = "Size(width=" + this.width + ", height=" + this.height + ')';
      AppMethodBeat.o(175970);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ao
 * JD-Core Version:    0.7.0.1
 */