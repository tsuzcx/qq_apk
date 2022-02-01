package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.TestTimeForChatting;

public class HomeUI$FitSystemWindowLayoutView
  extends FrameLayout
{
  private int adBp;
  private ViewGroup adBq;
  private Rect mRect;
  
  public HomeUI$FitSystemWindowLayoutView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(33220);
    this.mRect = new Rect();
    this.adBq = null;
    AppMethodBeat.o(33220);
  }
  
  public HomeUI$FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(33219);
    this.mRect = new Rect();
    this.adBq = null;
    AppMethodBeat.o(33219);
  }
  
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(33221);
    Object localObject2 = paramRect.toString();
    int i = this.adBp;
    int j = hashCode();
    Object localObject1;
    int k;
    label156:
    label235:
    boolean bool;
    if (paramRect.height() == 0)
    {
      localObject1 = Util.getStack();
      Log.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), localObject1 });
      if (paramRect.top > 0) {
        this.adBp = paramRect.top;
      }
      if ((this.adBq != null) && ((this.adBq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject1 = (ViewGroup.MarginLayoutParams)this.adBq.getLayoutParams();
        j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
        k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
        Log.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        i = 0;
        if (i < getChildCount())
        {
          localObject2 = getChildAt(i);
          if (!(localObject2 instanceof TestTimeForChatting)) {
            break label490;
          }
          localObject2 = (TestTimeForChatting)localObject2;
          if ((Float.compare(j, a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (j >= 0)) {
            break label471;
          }
          Log.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
          ((TestTimeForChatting)localObject2).afLA = 0;
          if ((Float.compare(k, a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
            break label480;
          }
          Log.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
          ((TestTimeForChatting)localObject2).afLB = 0;
          label286:
          Log.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        }
        aw.ae(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
      }
      this.mRect.set(paramRect);
      if (!d.rb(14)) {
        break label504;
      }
      i = 0;
      label353:
      if (i >= getChildCount()) {
        break label504;
      }
      localObject1 = getChildAt(i);
      if (!(localObject1 instanceof TestTimeForChatting)) {
        break label497;
      }
      ((View)localObject1).setFitsSystemWindows(true);
      bool = ((TestTimeForChatting)localObject1).fitSystemWindows(paramRect);
      ((View)localObject1).setFitsSystemWindows(false);
    }
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
      bool = super.fitSystemWindows(this.mRect);
      Log.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(33221);
      return bool;
      localObject1 = "pass";
      break;
      label471:
      ((TestTimeForChatting)localObject2).afLA = j;
      break label235;
      label480:
      ((TestTimeForChatting)localObject2).afLB = k;
      break label286;
      label490:
      i += 1;
      break label156;
      label497:
      i += 1;
      break label353;
      label504:
      bool = false;
    }
  }
  
  public int getCacheInsetsTop()
  {
    return this.adBp;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33222);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(33222);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localClassCastException, "", new Object[0]);
      Log.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", new Object[] { getLayoutParams(), getLayoutParams().getClass() });
      int j = getChildCount();
      int i = 0;
      View localView;
      while (i < j)
      {
        localView = getChildAt(i);
        Log.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        localView = getChildAt(i);
        if (((localView instanceof ImageView)) && (localView.getId() == R.h.fTp) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
          localView.setLayoutParams(new FrameLayout.LayoutParams(localView.getLayoutParams()));
        }
        Log.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
        i += 1;
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(33222);
    }
  }
  
  public void setActionBarContainer(ViewGroup paramViewGroup)
  {
    this.adBq = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView
 * JD-Core Version:    0.7.0.1
 */