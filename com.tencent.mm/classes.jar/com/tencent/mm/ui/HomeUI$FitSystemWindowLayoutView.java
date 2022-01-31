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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.TestTimeForChatting;

public class HomeUI$FitSystemWindowLayoutView
  extends FrameLayout
{
  private Rect mRect;
  private int yYF;
  private ViewGroup yYG;
  
  public HomeUI$FitSystemWindowLayoutView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(29389);
    this.mRect = new Rect();
    this.yYG = null;
    AppMethodBeat.o(29389);
  }
  
  public HomeUI$FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29388);
    this.mRect = new Rect();
    this.yYG = null;
    AppMethodBeat.o(29388);
  }
  
  @TargetApi(14)
  public boolean fitSystemWindows(Rect paramRect)
  {
    AppMethodBeat.i(29390);
    Object localObject2 = paramRect.toString();
    int i = this.yYF;
    int j = hashCode();
    Object localObject1;
    int k;
    label157:
    label236:
    boolean bool;
    if (paramRect.height() == 0)
    {
      localObject1 = ah.aoA();
      ab.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), localObject1 });
      if (paramRect.top > 0) {
        this.yYF = paramRect.top;
      }
      if ((this.yYG != null) && ((this.yYG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
      {
        localObject1 = (ViewGroup.MarginLayoutParams)this.yYG.getLayoutParams();
        j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
        k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
        ab.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        i = 0;
        if (i < getChildCount())
        {
          localObject2 = getChildAt(i);
          if (!(localObject2 instanceof TestTimeForChatting)) {
            break label492;
          }
          localObject2 = (TestTimeForChatting)localObject2;
          if ((Float.compare(j, a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (j >= 0)) {
            break label473;
          }
          ab.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
          ((TestTimeForChatting)localObject2).Aye = 0;
          if ((Float.compare(k, a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
            break label482;
          }
          ab.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
          ((TestTimeForChatting)localObject2).Ayf = 0;
          label287:
          ab.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        }
        af.J(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
      }
      this.mRect.set(paramRect);
      if (!d.fv(14)) {
        break label506;
      }
      i = 0;
      label354:
      if (i >= getChildCount()) {
        break label506;
      }
      localObject1 = getChildAt(i);
      if (!(localObject1 instanceof TestTimeForChatting)) {
        break label499;
      }
      ((View)localObject1).setFitsSystemWindows(true);
      bool = ((TestTimeForChatting)localObject1).fitSystemWindows(paramRect);
      ((View)localObject1).setFitsSystemWindows(false);
    }
    for (;;)
    {
      ab.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
      bool = super.fitSystemWindows(this.mRect);
      ab.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(29390);
      return bool;
      localObject1 = "pass";
      break;
      label473:
      ((TestTimeForChatting)localObject2).Aye = j;
      break label236;
      label482:
      ((TestTimeForChatting)localObject2).Ayf = k;
      break label287;
      label492:
      i += 1;
      break label157;
      label499:
      i += 1;
      break label354;
      label506:
      bool = false;
    }
  }
  
  public int getCacheInsetsTop()
  {
    return this.yYF;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29391);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(29391);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localClassCastException, "", new Object[0]);
      ab.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", new Object[] { getLayoutParams(), getLayoutParams().getClass() });
      int j = getChildCount();
      int i = 0;
      View localView;
      while (i < j)
      {
        localView = getChildAt(i);
        ab.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        localView = getChildAt(i);
        if (((localView instanceof ImageView)) && (localView.getId() == 2131820649) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
          localView.setLayoutParams(new FrameLayout.LayoutParams(localView.getLayoutParams()));
        }
        ab.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
        i += 1;
      }
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(29391);
    }
  }
  
  public void setActionBarContainer(ViewGroup paramViewGroup)
  {
    this.yYG = paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView
 * JD-Core Version:    0.7.0.1
 */