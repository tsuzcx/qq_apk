package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.f.b.a.az;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/popview/EmojiOperatePopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "TAG", "", "emojiPopView", "Lcom/tencent/mm/view/popview/EmojiPopView;", "lastAnchor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "dead", "", "onLongPress", "", "anchor", "item", "", "onMove", "onOutsideTouched", "onTouchEnd", "removePopup", "updatePopupView", "plugin-emojisdk_release"})
public final class b
  extends a
  implements com.tencent.mm.vending.e.a
{
  private final String TAG;
  private View YRA;
  private EmojiPopView YRz;
  private final Context context;
  private final int type;
  private final WindowManager windowManager;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(184003);
    this.context = paramContext;
    this.type = paramInt;
    this.TAG = "MicroMsg.EmojiOperatePopupHelper";
    paramContext = this.context.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.WindowManager");
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
      if ((this.type == 2) || (this.type == 3) || (this.type == 4))
      {
        localObject3 = e.jNv;
        e.aDd().jw(((h)paramObject).jHh.aCt());
      }
      Object localObject3 = e.jNv;
      e.rL(this.type);
      localObject3 = e.jNv;
      e.aDd().jx(((h)paramObject).jHh.getMd5());
      localObject3 = e.jNv;
      e.rE(1);
      paramView.setPressed(true);
      Object localObject4;
      if (this.YRz == null)
      {
        this.YRz = new EmojiPopView(this.context);
        localObject2 = this.YRz;
        if (localObject2 != null) {
          ((EmojiPopView)localObject2).setOnDismissCallback((AbstractPopView.a)new a(this));
        }
        localObject2 = this.windowManager;
        localObject3 = (View)this.YRz;
        localObject4 = this.YRz;
        if (localObject4 != null) {
          localObject1 = ((EmojiPopView)localObject4).getWindowLayoutParams();
        }
        ((WindowManager)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        localObject1 = this.YRz;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).setVisibility(4);
        }
      }
      for (;;)
      {
        localObject1 = this.YRz;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).post((Runnable)new b(this, paramView));
        }
        paramView = this.YRz;
        if (paramView != null) {
          paramView.setEmojiInfo(((h)paramObject).jHh);
        }
        paramView = this.YRz;
        if (paramView == null) {
          break;
        }
        paramView.setPopupType(this.type);
        AppMethodBeat.o(184002);
        return;
        localObject1 = this.YRz;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).jd(paramView);
        }
        localObject3 = this.windowManager;
        localObject4 = (View)this.YRz;
        EmojiPopView localEmojiPopView = this.YRz;
        localObject1 = localObject2;
        if (localEmojiPopView != null) {
          localObject1 = localEmojiPopView.getWindowLayoutParams();
        }
        ((WindowManager)localObject3).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(184002);
      return;
    }
    paramView = this.YRz;
    if (paramView != null)
    {
      paramView.setVisibility(8);
      AppMethodBeat.o(184002);
      return;
    }
    AppMethodBeat.o(184002);
  }
  
  private final void ihS()
  {
    AppMethodBeat.i(227128);
    Log.i(this.TAG, "removePopup: " + this.YRz);
    Object localObject = this.YRA;
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    this.YRA = null;
    localObject = this.YRz;
    if (localObject != null) {
      this.windowManager.removeView((View)localObject);
    }
    this.YRz = null;
    AppMethodBeat.o(227128);
  }
  
  public final boolean c(View paramView, Object paramObject)
  {
    AppMethodBeat.i(183998);
    p.k(paramView, "anchor");
    if ((!(paramObject instanceof h)) || (!paramView.isEnabled()))
    {
      AppMethodBeat.o(183998);
      return false;
    }
    this.YRA = paramView;
    paramView.setPressed(true);
    e(paramView, paramObject);
    AppMethodBeat.o(183998);
    return true;
  }
  
  public final void d(View paramView, Object paramObject)
  {
    AppMethodBeat.i(183999);
    p.k(paramView, "anchor");
    paramView.setPressed(true);
    if (p.h(this.YRA, paramView))
    {
      AppMethodBeat.o(183999);
      return;
    }
    View localView = this.YRA;
    if (localView != null) {
      localView.setPressed(false);
    }
    this.YRA = paramView;
    e(paramView, paramObject);
    AppMethodBeat.o(183999);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(227090);
    ihS();
    AppMethodBeat.o(227090);
  }
  
  public final void fRF()
  {
    AppMethodBeat.i(184000);
    View localView = this.YRA;
    if (localView != null)
    {
      localView.setPressed(false);
      AppMethodBeat.o(184000);
      return;
    }
    AppMethodBeat.o(184000);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class a
    implements AbstractPopView.a
  {
    a(b paramb) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(183996);
      b.a(this.YRB);
      AppMethodBeat.o(183996);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(183997);
      WindowManager localWindowManager;
      View localView;
      if (b.b(this.YRB) != null)
      {
        localObject = b.b(this.YRB);
        if (localObject != null) {
          ((EmojiPopView)localObject).setVisibility(0);
        }
        localObject = b.b(this.YRB);
        if (localObject != null) {
          ((EmojiPopView)localObject).jd(paramView);
        }
        localWindowManager = b.c(this.YRB);
        localView = (View)b.b(this.YRB);
        localObject = b.b(this.YRB);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.b
 * JD-Core Version:    0.7.0.1
 */