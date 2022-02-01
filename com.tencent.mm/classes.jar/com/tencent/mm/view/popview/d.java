package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ak;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/popview/SmileyPopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lastAnchor", "Landroid/view/View;", "smileyPopView", "Lcom/tencent/mm/view/popview/AbstractPopView;", "windowManager", "Landroid/view/WindowManager;", "onLongPress", "", "anchor", "item", "", "onMove", "", "onTouchEnd", "updatePopupView", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  private AbstractPopView agNB;
  private View agNg;
  private final Context context;
  private final WindowManager windowManager;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(184008);
    this.context = paramContext;
    paramContext = this.context.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(184008);
      throw paramContext;
    }
    this.windowManager = ((WindowManager)paramContext);
    AppMethodBeat.o(184008);
  }
  
  private final void d(View paramView, Object paramObject)
  {
    AppMethodBeat.i(184006);
    if (((paramObject instanceof ak)) && (paramView.isEnabled()))
    {
      Object localObject;
      if (this.agNB == null)
      {
        this.agNB = c.c(this.context, paramObject);
        WindowManager localWindowManager = this.windowManager;
        View localView = (View)this.agNB;
        localObject = this.agNB;
        if (localObject == null)
        {
          localObject = null;
          localWindowManager.addView(localView, (ViewGroup.LayoutParams)localObject);
        }
      }
      else
      {
        localObject = this.agNB;
        if (localObject != null) {
          ((AbstractPopView)localObject).setVisibility(0);
        }
        c.a(this.agNB, paramObject);
        paramObject = this.agNB;
        if (paramObject != null) {
          paramObject.mB(paramView);
        }
        paramObject = this.windowManager;
        localObject = (View)this.agNB;
        paramView = this.agNB;
        if (paramView != null) {
          break label162;
        }
      }
      label162:
      for (paramView = null;; paramView = paramView.getWindowLayoutParams())
      {
        paramObject.updateViewLayout((View)localObject, (ViewGroup.LayoutParams)paramView);
        AppMethodBeat.o(184006);
        return;
        localObject = ((AbstractPopView)localObject).getWindowLayoutParams();
        break;
      }
    }
    paramView = this.agNB;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(184006);
  }
  
  public final boolean b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(184004);
    s.u(paramView, "anchor");
    if (((paramObject instanceof ak)) && (paramView.isEnabled()))
    {
      this.agNg = paramView;
      d(paramView, paramObject);
      AppMethodBeat.o(184004);
      return true;
    }
    AppMethodBeat.o(184004);
    return false;
  }
  
  public final void c(View paramView, Object paramObject)
  {
    AppMethodBeat.i(184005);
    s.u(paramView, "anchor");
    if (s.p(this.agNg, paramView))
    {
      AppMethodBeat.o(184005);
      return;
    }
    this.agNg = paramView;
    d(paramView, paramObject);
    AppMethodBeat.o(184005);
  }
  
  public final void hjF()
  {
    AppMethodBeat.i(184007);
    this.agNg = null;
    AbstractPopView localAbstractPopView = this.agNB;
    if (localAbstractPopView != null) {
      this.windowManager.removeView((View)localAbstractPopView);
    }
    this.agNB = null;
    AppMethodBeat.o(184007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.d
 * JD-Core Version:    0.7.0.1
 */