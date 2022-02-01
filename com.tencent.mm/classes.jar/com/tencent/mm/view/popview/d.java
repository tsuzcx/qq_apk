package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ai;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/popview/SmileyPopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastAnchor", "Landroid/view/View;", "smileyPopView", "Lcom/tencent/mm/view/popview/AbstractPopView;", "windowManager", "Landroid/view/WindowManager;", "onLongPress", "", "anchor", "item", "", "onMove", "", "onTouchEnd", "updatePopupView", "plugin-emojisdk_release"})
public final class d
  extends a
{
  private View Rqc;
  private AbstractPopView Rqz;
  private final Context context;
  private final WindowManager windowManager;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(184008);
    this.context = paramContext;
    paramContext = this.context.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(184008);
      throw paramContext;
    }
    this.windowManager = ((WindowManager)paramContext);
    AppMethodBeat.o(184008);
  }
  
  private final void e(View paramView, Object paramObject)
  {
    AppMethodBeat.i(184006);
    if (((paramObject instanceof ai)) && (paramView.isEnabled()))
    {
      Object localObject;
      if (this.Rqz == null)
      {
        this.Rqz = c.b(this.context, paramObject);
        WindowManager localWindowManager = this.windowManager;
        View localView = (View)this.Rqz;
        localObject = this.Rqz;
        if (localObject != null)
        {
          localObject = ((AbstractPopView)localObject).getWindowLayoutParams();
          localWindowManager.addView(localView, (ViewGroup.LayoutParams)localObject);
        }
      }
      else
      {
        localObject = this.Rqz;
        if (localObject != null) {
          ((AbstractPopView)localObject).setVisibility(0);
        }
        c.a(this.Rqz, paramObject);
        paramObject = this.Rqz;
        if (paramObject != null) {
          paramObject.hI(paramView);
        }
        paramObject = this.windowManager;
        localObject = (View)this.Rqz;
        paramView = this.Rqz;
        if (paramView == null) {
          break label165;
        }
      }
      label165:
      for (paramView = paramView.getWindowLayoutParams();; paramView = null)
      {
        paramObject.updateViewLayout((View)localObject, (ViewGroup.LayoutParams)paramView);
        AppMethodBeat.o(184006);
        return;
        localObject = null;
        break;
      }
    }
    paramView = this.Rqz;
    if (paramView != null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(184006);
      return;
    }
    AppMethodBeat.o(184006);
  }
  
  public final boolean c(View paramView, Object paramObject)
  {
    AppMethodBeat.i(184004);
    p.h(paramView, "anchor");
    if (((paramObject instanceof ai)) && (paramView.isEnabled()))
    {
      this.Rqc = paramView;
      e(paramView, paramObject);
      AppMethodBeat.o(184004);
      return true;
    }
    AppMethodBeat.o(184004);
    return false;
  }
  
  public final void d(View paramView, Object paramObject)
  {
    AppMethodBeat.i(184005);
    p.h(paramView, "anchor");
    if (p.j(this.Rqc, paramView))
    {
      AppMethodBeat.o(184005);
      return;
    }
    this.Rqc = paramView;
    e(paramView, paramObject);
    AppMethodBeat.o(184005);
  }
  
  public final void fdM()
  {
    AppMethodBeat.i(184007);
    this.Rqc = null;
    AbstractPopView localAbstractPopView = this.Rqz;
    if (localAbstractPopView != null) {
      this.windowManager.removeView((View)localAbstractPopView);
    }
    this.Rqz = null;
    AppMethodBeat.o(184007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.popview.d
 * JD-Core Version:    0.7.0.1
 */