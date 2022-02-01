package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.b.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/popview/EmojiOperatePopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "TAG", "", "emojiPopView", "Lcom/tencent/mm/view/popview/EmojiPopView;", "lastAnchor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "dead", "", "onLongPress", "", "anchor", "item", "", "onMove", "onOutsideTouched", "onTouchEnd", "removePopup", "updatePopupView", "plugin-emojisdk_release"})
public final class b
  extends a
  implements com.tencent.mm.vending.e.a
{
  EmojiPopView JBx;
  private View JBy;
  private final String TAG;
  private final Context context;
  private final int type;
  final WindowManager windowManager;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(184003);
    this.context = paramContext;
    this.type = paramInt;
    this.TAG = "MicroMsg.EmojiOperatePopupHelper";
    paramContext = this.context.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new d.v("null cannot be cast to non-null type android.view.WindowManager");
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
        localObject3 = d.fVd;
        d.adu().fQ(((h)paramObject).fPB.azp());
      }
      Object localObject3 = d.fVd;
      d.lF(this.type);
      localObject3 = d.fVd;
      d.adu().fR(((h)paramObject).fPB.JC());
      localObject3 = d.fVd;
      d.lA(1);
      paramView.setPressed(true);
      Object localObject4;
      if (this.JBx == null)
      {
        this.JBx = new EmojiPopView(this.context);
        localObject2 = this.JBx;
        if (localObject2 != null) {
          ((EmojiPopView)localObject2).setOnDismissCallback((AbstractPopView.a)new a(this));
        }
        localObject2 = this.windowManager;
        localObject3 = (View)this.JBx;
        localObject4 = this.JBx;
        if (localObject4 != null) {
          localObject1 = ((EmojiPopView)localObject4).getWindowLayoutParams();
        }
        ((WindowManager)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        localObject1 = this.JBx;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).setVisibility(4);
        }
      }
      for (;;)
      {
        localObject1 = this.JBx;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).post((Runnable)new b(this, paramView));
        }
        paramView = this.JBx;
        if (paramView != null) {
          paramView.setEmojiInfo(((h)paramObject).fPB);
        }
        paramView = this.JBx;
        if (paramView == null) {
          break;
        }
        paramView.setPopupType(this.type);
        AppMethodBeat.o(184002);
        return;
        localObject1 = this.JBx;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).gU(paramView);
        }
        localObject3 = this.windowManager;
        localObject4 = (View)this.JBx;
        EmojiPopView localEmojiPopView = this.JBx;
        localObject1 = localObject2;
        if (localEmojiPopView != null) {
          localObject1 = localEmojiPopView.getWindowLayoutParams();
        }
        ((WindowManager)localObject3).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(184002);
      return;
    }
    paramView = this.JBx;
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
    this.JBy = paramView;
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
    if (k.g(this.JBy, paramView))
    {
      AppMethodBeat.o(183999);
      return;
    }
    View localView = this.JBy;
    if (localView != null) {
      localView.setPressed(false);
    }
    this.JBy = paramView;
    e(paramView, paramObject);
    AppMethodBeat.o(183999);
  }
  
  public final void dLc()
  {
    AppMethodBeat.i(184000);
    View localView = this.JBy;
    if (localView != null)
    {
      localView.setPressed(false);
      AppMethodBeat.o(184000);
      return;
    }
    AppMethodBeat.o(184000);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(209883);
    fzo();
    AppMethodBeat.o(209883);
  }
  
  final void fzo()
  {
    AppMethodBeat.i(209884);
    ac.i(this.TAG, "removePopup: " + this.JBx);
    Object localObject = this.JBy;
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    this.JBy = null;
    localObject = this.JBx;
    if (localObject != null) {
      this.windowManager.removeView((View)localObject);
    }
    this.JBx = null;
    AppMethodBeat.o(209884);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class a
    implements AbstractPopView.a
  {
    a(b paramb) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(183996);
      this.JBz.fzo();
      AppMethodBeat.o(183996);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(183997);
      WindowManager localWindowManager;
      View localView;
      if (this.JBz.JBx != null)
      {
        localObject = this.JBz.JBx;
        if (localObject != null) {
          ((EmojiPopView)localObject).setVisibility(0);
        }
        localObject = this.JBz.JBx;
        if (localObject != null) {
          ((EmojiPopView)localObject).gU(paramView);
        }
        localWindowManager = this.JBz.windowManager;
        localView = (View)this.JBz.JBx;
        localObject = this.JBz.JBx;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.popview.b
 * JD-Core Version:    0.7.0.1
 */