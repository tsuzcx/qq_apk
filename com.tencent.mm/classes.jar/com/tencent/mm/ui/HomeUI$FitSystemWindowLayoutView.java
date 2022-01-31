package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.TestTimeForChatting;

public class HomeUI$FitSystemWindowLayoutView
  extends FrameLayout
{
  private Rect mRect = new Rect();
  private int uKD;
  private ViewGroup uKE = null;
  
  public HomeUI$FitSystemWindowLayoutView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HomeUI$FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @TargetApi(14)
  public boolean fitSystemWindows(Rect paramRect)
  {
    y.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d", new Object[] { paramRect.toString(), Integer.valueOf(this.uKD), Integer.valueOf(hashCode()) });
    this.uKD = paramRect.top;
    Object localObject1;
    int j;
    int k;
    int i;
    Object localObject2;
    label199:
    label251:
    boolean bool;
    if ((this.uKE != null) && ((this.uKE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.uKE.getLayoutParams();
      j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
      k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
      y.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
      i = 0;
      if (i < getChildCount())
      {
        localObject2 = getChildAt(i);
        if (!(localObject2 instanceof TestTimeForChatting)) {
          break label443;
        }
        localObject2 = (TestTimeForChatting)localObject2;
        if ((Float.compare(j, a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 1.5F) > 0) || (j < 0))
        {
          y.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
          ((TestTimeForChatting)localObject2).wfo = 0;
          if ((Float.compare(k, a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 1.5F) <= 0) && (k >= 0)) {
            break label433;
          }
          y.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
          ((TestTimeForChatting)localObject2).wfp = 0;
          y.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        }
      }
      else
      {
        ak.D(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
      }
    }
    else
    {
      this.mRect.set(paramRect);
      if (!d.gF(14)) {
        break label457;
      }
      i = 0;
      label318:
      if (i >= getChildCount()) {
        break label457;
      }
      localObject1 = getChildAt(i);
      if (!(localObject1 instanceof TestTimeForChatting)) {
        break label450;
      }
      ((View)localObject1).setFitsSystemWindows(true);
      bool = ((TestTimeForChatting)localObject1).fitSystemWindows(paramRect);
      ((View)localObject1).setFitsSystemWindows(false);
    }
    for (;;)
    {
      y.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
      bool = super.fitSystemWindows(this.mRect);
      y.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
      return bool;
      ((TestTimeForChatting)localObject2).wfo = j;
      break label199;
      label433:
      ((TestTimeForChatting)localObject2).wfp = k;
      break label251;
      label443:
      i += 1;
      break;
      label450:
      i += 1;
      break label318;
      label457:
      bool = false;
    }
  }
  
  public int getCacheInsetsTop()
  {
    return this.uKD;
  }
  
  public void setActionBarContainer(ViewGroup paramViewGroup)
  {
    this.uKE = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView
 * JD-Core Version:    0.7.0.1
 */