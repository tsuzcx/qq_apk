package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.b.d;
import com.tencent.mm.g.b.a.t;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/popview/EmojiOperatePopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "emojiPopView", "Lcom/tencent/mm/view/popview/EmojiPopView;", "lastAnchor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "dead", "", "onLongPress", "", "anchor", "item", "", "onMove", "onOutsideTouched", "onTouchEnd", "removePopup", "updatePopupView", "plugin-emojisdk_release"})
public final class b
  extends a
  implements com.tencent.mm.vending.e.a
{
  EmojiPopView IaH;
  private View IaI;
  private final Context context;
  private final int type;
  final WindowManager windowManager;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(184003);
    this.context = paramContext;
    this.type = paramInt;
    paramContext = this.context.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(184003);
      throw paramContext;
    }
    this.windowManager = ((WindowManager)paramContext);
    AppMethodBeat.o(184003);
  }
  
  private final void e(final View paramView, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(184002);
    if (((paramObject instanceof h)) && (paramView.isEnabled()))
    {
      if ((this.type == 2) || (this.type == 3))
      {
        localObject3 = d.fRi;
        d.aco().fZ(((h)paramObject).fLP.asy());
      }
      Object localObject3 = d.fRi;
      d.lJ(this.type);
      localObject3 = d.fRi;
      d.aco().ga(((h)paramObject).fLP.JS());
      localObject3 = d.fRi;
      d.lI(1);
      paramView.setPressed(true);
      Object localObject4;
      if (this.IaH == null)
      {
        this.IaH = new EmojiPopView(this.context);
        localObject2 = this.IaH;
        if (localObject2 != null) {
          ((EmojiPopView)localObject2).setOnDismissCallback((AbstractPopView.a)new a(this));
        }
        localObject2 = this.windowManager;
        localObject3 = (View)this.IaH;
        localObject4 = this.IaH;
        if (localObject4 != null) {
          localObject1 = ((EmojiPopView)localObject4).getWindowLayoutParams();
        }
        ((WindowManager)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        localObject1 = this.IaH;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).setVisibility(4);
        }
      }
      for (;;)
      {
        localObject1 = this.IaH;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).post((Runnable)new b(this, paramView));
        }
        paramView = this.IaH;
        if (paramView != null) {
          paramView.setEmojiInfo(((h)paramObject).fLP);
        }
        paramView = this.IaH;
        if (paramView == null) {
          break;
        }
        paramView.setPopupType(this.type);
        AppMethodBeat.o(184002);
        return;
        localObject1 = this.IaH;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).gD(paramView);
        }
        localObject3 = this.windowManager;
        localObject4 = (View)this.IaH;
        EmojiPopView localEmojiPopView = this.IaH;
        localObject1 = localObject2;
        if (localEmojiPopView != null) {
          localObject1 = localEmojiPopView.getWindowLayoutParams();
        }
        ((WindowManager)localObject3).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(184002);
      return;
    }
    paramView = this.IaH;
    if (paramView != null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(184002);
      return;
    }
    AppMethodBeat.o(184002);
  }
  
  public final boolean c(View paramView, Object paramObject)
  {
    AppMethodBeat.i(183998);
    k.h(paramView, "anchor");
    if ((!(paramObject instanceof h)) || (!paramView.isEnabled()))
    {
      AppMethodBeat.o(183998);
      return false;
    }
    this.IaI = paramView;
    paramView.setPressed(true);
    e(paramView, paramObject);
    AppMethodBeat.o(183998);
    return true;
  }
  
  public final void d(View paramView, Object paramObject)
  {
    AppMethodBeat.i(183999);
    k.h(paramView, "anchor");
    paramView.setPressed(true);
    if (k.g(this.IaI, paramView))
    {
      AppMethodBeat.o(183999);
      return;
    }
    View localView = this.IaI;
    if (localView != null) {
      localView.setPressed(false);
    }
    this.IaI = paramView;
    e(paramView, paramObject);
    AppMethodBeat.o(183999);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(193416);
    fjb();
    AppMethodBeat.o(193416);
  }
  
  public final void dwD()
  {
    AppMethodBeat.i(184000);
    View localView = this.IaI;
    if (localView != null)
    {
      localView.setPressed(false);
      AppMethodBeat.o(184000);
      return;
    }
    AppMethodBeat.o(184000);
  }
  
  final void fjb()
  {
    AppMethodBeat.i(193417);
    Object localObject = this.IaI;
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    this.IaI = null;
    localObject = this.IaH;
    if (localObject != null) {
      this.windowManager.removeView((View)localObject);
    }
    this.IaH = null;
    AppMethodBeat.o(193417);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class a
    implements AbstractPopView.a
  {
    a(b paramb) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(183996);
      this.IaJ.fjb();
      AppMethodBeat.o(183996);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(183997);
      WindowManager localWindowManager;
      View localView;
      if (this.IaJ.IaH != null)
      {
        localObject = this.IaJ.IaH;
        if (localObject != null) {
          ((EmojiPopView)localObject).setVisibility(0);
        }
        localObject = this.IaJ.IaH;
        if (localObject != null) {
          ((EmojiPopView)localObject).gD(paramView);
        }
        localWindowManager = this.IaJ.windowManager;
        localView = (View)this.IaJ.IaH;
        localObject = this.IaJ.IaH;
        if (localObject == null) {
          break label105;
        }
      }
      label105:
      for (Object localObject = ((EmojiPopView)localObject).getWindowLayoutParams();; localObject = null)
      {
        localWindowManager.updateViewLayout(localView, (ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(183997);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.view.popview.b
 * JD-Core Version:    0.7.0.1
 */