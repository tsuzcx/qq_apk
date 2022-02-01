package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeTouchOutside", "", "getCloseTouchOutside", "()Z", "setCloseTouchOutside", "(Z)V", "coverByKeyboard", "getCoverByKeyboard", "setCoverByKeyboard", "isDismissing", "value", "outsideTouchable", "getOutsideTouchable", "setOutsideTouchable", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "hasInit", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "Companion", "plugin-recordvideo_release"})
public final class EditorPanelHolder
  extends InsectFrameLayout
{
  public static final a HZN;
  private View FLi;
  private kotlin.g.a.b<? super Boolean, x> HYF;
  private boolean HZJ;
  private boolean HZK;
  private boolean HZL;
  private boolean HZM;
  
  static
  {
    AppMethodBeat.i(217098);
    HZN = new a((byte)0);
    AppMethodBeat.o(217098);
  }
  
  public EditorPanelHolder(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(217097);
    AppMethodBeat.o(217097);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(217095);
    AppMethodBeat.o(217095);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(217093);
    this.HZL = true;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216960);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.HZO.getCloseTouchOutside()) {
          this.HZO.setShow(false);
        }
        a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216960);
      }
    });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(217093);
  }
  
  public final boolean Kc(final int paramInt)
  {
    AppMethodBeat.i(217086);
    if ((this.HZK) && ((paramInt > 200) || (paramInt < 0)))
    {
      AppMethodBeat.o(217086);
      return true;
    }
    View localView = this.FLi;
    if ((localView != null) && (localView.getPaddingBottom() != paramInt)) {
      localView.post((Runnable)new b(localView, paramInt));
    }
    AppMethodBeat.o(217086);
    return true;
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(217080);
    p.k(paramView, "view");
    this.FLi = paramView;
    if (paramLayoutParams != null) {
      paramLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      paramLayoutParams.gravity = 80;
      addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(217080);
      return;
      if (paramView.getLayoutParams() != null) {
        paramLayoutParams = new FrameLayout.LayoutParams(paramView.getLayoutParams());
      } else {
        paramLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      }
    }
  }
  
  public final boolean bVd()
  {
    AppMethodBeat.i(217088);
    if ((getVisibility() == 0) && (!this.HZJ))
    {
      AppMethodBeat.o(217088);
      return true;
    }
    AppMethodBeat.o(217088);
    return false;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217092);
    p.k(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(217092);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(217092);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          setShow(false);
          AppMethodBeat.o(217092);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(217092);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(217092);
    return bool;
  }
  
  public final boolean fpT()
  {
    return this.FLi != null;
  }
  
  public final boolean getCloseTouchOutside()
  {
    return this.HZL;
  }
  
  public final boolean getCoverByKeyboard()
  {
    return this.HZK;
  }
  
  public final boolean getOutsideTouchable()
  {
    return this.HZM;
  }
  
  public final void setCloseTouchOutside(boolean paramBoolean)
  {
    this.HZL = paramBoolean;
  }
  
  public final void setCoverByKeyboard(boolean paramBoolean)
  {
    this.HZK = paramBoolean;
  }
  
  public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.HYF = paramb;
  }
  
  public final void setOutsideTouchable(boolean paramBoolean)
  {
    AppMethodBeat.i(217079);
    this.HZM = paramBoolean;
    if (paramBoolean)
    {
      setOnClickListener(null);
      setClickable(false);
      AppMethodBeat.o(217079);
      return;
    }
    setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(217079);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(217085);
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.HYF;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
      }
      localObject = this.FLi;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getHeight() == 0)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).post((Runnable)new EditorPanelHolder.e((View)localObject));
          AppMethodBeat.o(217085);
          return;
        }
        ((View)localObject).animate().translationY(0.0F).start();
        AppMethodBeat.o(217085);
        return;
      }
      AppMethodBeat.o(217085);
      return;
    }
    this.HZJ = true;
    Object localObject = this.HYF;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
    }
    localObject = this.FLi;
    if (localObject != null)
    {
      ((View)localObject).animate().cancel();
      ((View)localObject).animate().translationY(((View)localObject).getHeight()).withEndAction((Runnable)new d(this)).start();
      AppMethodBeat.o(217085);
      return;
    }
    AppMethodBeat.o(217085);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$insectBottom$1$1"})
  static final class b
    implements Runnable
  {
    b(View paramView, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(228509);
      this.HYL.setPadding(this.HYL.getPaddingLeft(), this.HYL.getPaddingTop(), this.HYL.getPaddingRight(), paramInt);
      this.HYL.requestLayout();
      AppMethodBeat.o(228509);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221601);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (this.HZO.getCloseTouchOutside()) {
        this.HZO.setShow(false);
      }
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221601);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$setShow$2$1"})
  static final class d
    implements Runnable
  {
    d(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void run()
    {
      AppMethodBeat.i(216516);
      this.HZO.setVisibility(8);
      EditorPanelHolder.a(this.HZO);
      AppMethodBeat.o(216516);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder
 * JD-Core Version:    0.7.0.1
 */