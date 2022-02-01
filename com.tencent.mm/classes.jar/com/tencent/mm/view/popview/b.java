package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/popview/EmojiOperatePopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "TAG", "", "emojiPopView", "Lcom/tencent/mm/view/popview/EmojiPopView;", "lastAnchor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "dead", "", "onLongPress", "", "anchor", "item", "", "onMove", "onOutsideTouched", "onTouchEnd", "removePopup", "updatePopupView", "plugin-emojisdk_release"})
public final class b
  extends a
  implements com.tencent.mm.vending.e.a
{
  EmojiPopView Rqb;
  private View Rqc;
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
        localObject3 = e.hcl;
        e.awe().iv(((h)paramObject).gWm.avy());
      }
      Object localObject3 = e.hcl;
      e.ps(this.type);
      localObject3 = e.hcl;
      e.awe().iw(((h)paramObject).gWm.getMd5());
      localObject3 = e.hcl;
      e.pl(1);
      paramView.setPressed(true);
      Object localObject4;
      if (this.Rqb == null)
      {
        this.Rqb = new EmojiPopView(this.context);
        localObject2 = this.Rqb;
        if (localObject2 != null) {
          ((EmojiPopView)localObject2).setOnDismissCallback((AbstractPopView.a)new a(this));
        }
        localObject2 = this.windowManager;
        localObject3 = (View)this.Rqb;
        localObject4 = this.Rqb;
        if (localObject4 != null) {
          localObject1 = ((EmojiPopView)localObject4).getWindowLayoutParams();
        }
        ((WindowManager)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
        localObject1 = this.Rqb;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).setVisibility(4);
        }
      }
      for (;;)
      {
        localObject1 = this.Rqb;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).post((Runnable)new b(this, paramView));
        }
        paramView = this.Rqb;
        if (paramView != null) {
          paramView.setEmojiInfo(((h)paramObject).gWm);
        }
        paramView = this.Rqb;
        if (paramView == null) {
          break;
        }
        paramView.setPopupType(this.type);
        AppMethodBeat.o(184002);
        return;
        localObject1 = this.Rqb;
        if (localObject1 != null) {
          ((EmojiPopView)localObject1).hI(paramView);
        }
        localObject3 = this.windowManager;
        localObject4 = (View)this.Rqb;
        EmojiPopView localEmojiPopView = this.Rqb;
        localObject1 = localObject2;
        if (localEmojiPopView != null) {
          localObject1 = localEmojiPopView.getWindowLayoutParams();
        }
        ((WindowManager)localObject3).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(184002);
      return;
    }
    paramView = this.Rqb;
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
    this.Rqc = paramView;
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
    if (p.j(this.Rqc, paramView))
    {
      AppMethodBeat.o(183999);
      return;
    }
    View localView = this.Rqc;
    if (localView != null) {
      localView.setPressed(false);
    }
    this.Rqc = paramView;
    e(paramView, paramObject);
    AppMethodBeat.o(183999);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(200102);
    hgq();
    AppMethodBeat.o(200102);
  }
  
  public final void fdM()
  {
    AppMethodBeat.i(184000);
    View localView = this.Rqc;
    if (localView != null)
    {
      localView.setPressed(false);
      AppMethodBeat.o(184000);
      return;
    }
    AppMethodBeat.o(184000);
  }
  
  final void hgq()
  {
    AppMethodBeat.i(200103);
    Log.i(this.TAG, "removePopup: " + this.Rqb);
    Object localObject = this.Rqc;
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    this.Rqc = null;
    localObject = this.Rqb;
    if (localObject != null) {
      this.windowManager.removeView((View)localObject);
    }
    this.Rqb = null;
    AppMethodBeat.o(200103);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class a
    implements AbstractPopView.a
  {
    a(b paramb) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(183996);
      this.Rqd.hgq();
      AppMethodBeat.o(183996);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(183997);
      WindowManager localWindowManager;
      View localView;
      if (this.Rqd.Rqb != null)
      {
        localObject = this.Rqd.Rqb;
        if (localObject != null) {
          ((EmojiPopView)localObject).setVisibility(0);
        }
        localObject = this.Rqd.Rqb;
        if (localObject != null) {
          ((EmojiPopView)localObject).hI(paramView);
        }
        localWindowManager = this.Rqd.windowManager;
        localView = (View)this.Rqd.Rqb;
        localObject = this.Rqd.Rqb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.view.popview.b
 * JD-Core Version:    0.7.0.1
 */