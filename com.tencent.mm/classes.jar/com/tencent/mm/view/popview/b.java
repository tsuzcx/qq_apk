package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.b.d;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/popview/EmojiOperatePopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "TAG", "", "emojiPopView", "Lcom/tencent/mm/view/popview/EmojiPopView;", "lastAnchor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "dead", "", "onLongPress", "", "anchor", "item", "", "onMove", "onOutsideTouched", "onTouchEnd", "removePopup", "updatePopupView", "plugin-emojisdk_release"})
public final class b
  extends a
  implements com.tencent.mm.vending.e.a
{
  EmojiPopView LuE;
  private View LuF;
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
        localObject3 = d.goG;
        d.aga().gS(((h)paramObject).gjb.afw());
      }
      Object localObject3 = d.goG;
      d.mf(this.type);
      localObject3 = d.goG;
      d.aga().gT(((h)paramObject).gjb.Lb());
      localObject3 = d.goG;
      d.ma(1);
      paramView.setPressed(true);
      Object localObject4;
      if (this.LuE == null)
      {
        this.LuE = new EmojiPopView(this.context);
        localObject2 = this.LuE;
        if (localObject2 != null) {
          ((EmojiPopView)localObject2).setOnDismissCallback((AbstractPopView.a)new a(this));
        }
        localObject2 = this.windowManager;
        localObject3 = (View)this.LuE;
        localObject4 = this.LuE;
        if (localObject4 != null) {
          localObject1 = ((EmojiPopView)localObject4).getWindowLayoutParams();
        }
        ((WindowManager)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        localObject1 = this.LuE;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).setVisibility(4);
        }
      }
      for (;;)
      {
        localObject1 = this.LuE;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).post((Runnable)new b(this, paramView));
        }
        paramView = this.LuE;
        if (paramView != null) {
          paramView.setEmojiInfo(((h)paramObject).gjb);
        }
        paramView = this.LuE;
        if (paramView == null) {
          break;
        }
        paramView.setPopupType(this.type);
        AppMethodBeat.o(184002);
        return;
        localObject1 = this.LuE;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).hl(paramView);
        }
        localObject3 = this.windowManager;
        localObject4 = (View)this.LuE;
        EmojiPopView localEmojiPopView = this.LuE;
        localObject1 = localObject2;
        if (localEmojiPopView != null) {
          localObject1 = localEmojiPopView.getWindowLayoutParams();
        }
        ((WindowManager)localObject3).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(184002);
      return;
    }
    paramView = this.LuE;
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
    p.h(paramView, "anchor");
    if ((!(paramObject instanceof h)) || (!paramView.isEnabled()))
    {
      AppMethodBeat.o(183998);
      return false;
    }
    this.LuF = paramView;
    paramView.setPressed(true);
    e(paramView, paramObject);
    AppMethodBeat.o(183998);
    return true;
  }
  
  public final void d(View paramView, Object paramObject)
  {
    AppMethodBeat.i(183999);
    p.h(paramView, "anchor");
    paramView.setPressed(true);
    if (p.i(this.LuF, paramView))
    {
      AppMethodBeat.o(183999);
      return;
    }
    View localView = this.LuF;
    if (localView != null) {
      localView.setPressed(false);
    }
    this.LuF = paramView;
    e(paramView, paramObject);
    AppMethodBeat.o(183999);
  }
  
  public final void dXt()
  {
    AppMethodBeat.i(184000);
    View localView = this.LuF;
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
    AppMethodBeat.i(219009);
    fQx();
    AppMethodBeat.o(219009);
  }
  
  final void fQx()
  {
    AppMethodBeat.i(219010);
    ad.i(this.TAG, "removePopup: " + this.LuE);
    Object localObject = this.LuF;
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    this.LuF = null;
    localObject = this.LuE;
    if (localObject != null) {
      this.windowManager.removeView((View)localObject);
    }
    this.LuE = null;
    AppMethodBeat.o(219010);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class a
    implements AbstractPopView.a
  {
    a(b paramb) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(183996);
      this.LuG.fQx();
      AppMethodBeat.o(183996);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(183997);
      WindowManager localWindowManager;
      View localView;
      if (this.LuG.LuE != null)
      {
        localObject = this.LuG.LuE;
        if (localObject != null) {
          ((EmojiPopView)localObject).setVisibility(0);
        }
        localObject = this.LuG.LuE;
        if (localObject != null) {
          ((EmojiPopView)localObject).hl(paramView);
        }
        localWindowManager = this.LuG.windowManager;
        localView = (View)this.LuG.LuE;
        localObject = this.LuG.LuE;
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