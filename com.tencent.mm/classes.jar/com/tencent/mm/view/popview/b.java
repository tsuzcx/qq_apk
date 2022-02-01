package com.tencent.mm.view.popview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bv;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.d.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/popview/EmojiOperatePopupHelper;", "Lcom/tencent/mm/view/popview/BasePopupHelper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Landroid/content/Context;", "type", "", "(Landroid/content/Context;I)V", "TAG", "", "emojiPopView", "Lcom/tencent/mm/view/popview/EmojiPopView;", "lastAnchor", "Landroid/view/View;", "windowManager", "Landroid/view/WindowManager;", "dead", "", "onLongPress", "", "anchor", "item", "", "onMove", "onOutsideTouched", "onTouchEnd", "removePopup", "updatePopupView", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
  implements com.tencent.mm.vending.e.a
{
  private final String TAG;
  private EmojiPopView agNf;
  private View agNg;
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
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(184003);
      throw paramContext;
    }
    this.windowManager = ((WindowManager)paramContext);
    AppMethodBeat.o(184003);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(235033);
    s.u(paramb, "this$0");
    paramb.jNg();
    AppMethodBeat.o(235033);
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(235036);
    s.u(paramb, "this$0");
    s.u(paramView, "$anchor");
    Object localObject;
    if (paramb.agNf != null)
    {
      localObject = paramb.agNf;
      if (localObject != null) {
        ((EmojiPopView)localObject).setVisibility(0);
      }
      localObject = paramb.agNf;
      if (localObject != null) {
        ((EmojiPopView)localObject).mB(paramView);
      }
      paramView = paramb.windowManager;
      localObject = (View)paramb.agNf;
      paramb = paramb.agNf;
      if (paramb != null) {
        break label93;
      }
    }
    label93:
    for (paramb = null;; paramb = paramb.getWindowLayoutParams())
    {
      paramView.updateViewLayout((View)localObject, (ViewGroup.LayoutParams)paramb);
      AppMethodBeat.o(235036);
      return;
    }
  }
  
  private final void d(View paramView, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(184002);
    if (((paramObject instanceof h)) && (paramView.isEnabled()))
    {
      if ((this.type == 2) || (this.type == 3) || (this.type == 4))
      {
        localObject3 = e.mmt;
        e.aWd().le(((h)paramObject).mgK.field_groupId);
      }
      Object localObject3 = e.mmt;
      e.rN(this.type);
      localObject3 = e.mmt;
      e.aWd().lf(((h)paramObject).mgK.getMd5());
      localObject3 = e.mmt;
      e.rG(1);
      paramView.setPressed(true);
      if (this.agNf == null)
      {
        this.agNf = new EmojiPopView(this.context);
        localObject2 = this.agNf;
        if (localObject2 != null) {
          ((EmojiPopView)localObject2).setOnDismissCallback(new b..ExternalSyntheticLambda0(this));
        }
        localObject2 = this.windowManager;
        localObject3 = (View)this.agNf;
        localObject4 = this.agNf;
        if (localObject4 == null) {}
        for (;;)
        {
          ((WindowManager)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
          localObject1 = this.agNf;
          if (localObject1 != null) {
            ((EmojiPopView)localObject1).setVisibility(4);
          }
          localObject1 = this.agNf;
          if (localObject1 != null) {
            ((EmojiPopView)localObject1).post(new b..ExternalSyntheticLambda1(this, paramView));
          }
          paramView = this.agNf;
          if (paramView != null) {
            paramView.setEmojiInfo(((h)paramObject).mgK);
          }
          paramView = this.agNf;
          if (paramView == null) {
            break;
          }
          paramView.setPopupType(this.type);
          AppMethodBeat.o(184002);
          return;
          localObject1 = ((EmojiPopView)localObject4).getWindowLayoutParams();
        }
      }
      localObject1 = this.agNf;
      if (localObject1 != null) {
        ((EmojiPopView)localObject1).mB(paramView);
      }
      localObject3 = this.windowManager;
      Object localObject4 = (View)this.agNf;
      localObject1 = this.agNf;
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((EmojiPopView)localObject1).getWindowLayoutParams())
      {
        ((WindowManager)localObject3).updateViewLayout((View)localObject4, (ViewGroup.LayoutParams)localObject1);
        break;
      }
    }
    paramView = this.agNf;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    AppMethodBeat.o(184002);
  }
  
  private final void jNg()
  {
    AppMethodBeat.i(235030);
    Log.i(this.TAG, s.X("removePopup: ", this.agNf));
    Object localObject = this.agNg;
    if (localObject != null) {
      ((View)localObject).setPressed(false);
    }
    this.agNg = null;
    localObject = this.agNf;
    if (localObject != null) {
      this.windowManager.removeView((View)localObject);
    }
    this.agNf = null;
    AppMethodBeat.o(235030);
  }
  
  public final boolean b(View paramView, Object paramObject)
  {
    AppMethodBeat.i(183998);
    s.u(paramView, "anchor");
    if ((!(paramObject instanceof h)) || (!paramView.isEnabled()))
    {
      AppMethodBeat.o(183998);
      return false;
    }
    this.agNg = paramView;
    paramView.setPressed(true);
    d(paramView, paramObject);
    AppMethodBeat.o(183998);
    return true;
  }
  
  public final void c(View paramView, Object paramObject)
  {
    AppMethodBeat.i(183999);
    s.u(paramView, "anchor");
    paramView.setPressed(true);
    if (s.p(this.agNg, paramView))
    {
      AppMethodBeat.o(183999);
      return;
    }
    View localView = this.agNg;
    if (localView != null) {
      localView.setPressed(false);
    }
    this.agNg = paramView;
    d(paramView, paramObject);
    AppMethodBeat.o(183999);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(235055);
    jNg();
    AppMethodBeat.o(235055);
  }
  
  public final void hjF()
  {
    AppMethodBeat.i(184000);
    View localView = this.agNg;
    if (localView != null) {
      localView.setPressed(false);
    }
    AppMethodBeat.o(184000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.popview.b
 * JD-Core Version:    0.7.0.1
 */