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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeTouchOutside", "", "getCloseTouchOutside", "()Z", "setCloseTouchOutside", "(Z)V", "coverByKeyboard", "getCoverByKeyboard", "setCoverByKeyboard", "value", "outsideTouchable", "getOutsideTouchable", "setOutsideTouchable", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "Companion", "plugin-recordvideo_release"})
public final class EditorPanelHolder
  extends InsectFrameLayout
{
  public static final EditorPanelHolder.a Cdx;
  private View AeF;
  private kotlin.g.a.b<? super Boolean, x> Ccp;
  private boolean Cdu;
  private boolean Cdv;
  private boolean Cdw;
  
  static
  {
    AppMethodBeat.i(237733);
    Cdx = new EditorPanelHolder.a((byte)0);
    AppMethodBeat.o(237733);
  }
  
  public EditorPanelHolder(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(237732);
    AppMethodBeat.o(237732);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(237731);
    AppMethodBeat.o(237731);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237730);
    this.Cdv = true;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(237718);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.Cdy.getCloseTouchOutside()) {
          this.Cdy.setShow(false);
        }
        a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(237718);
      }
    });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(237730);
  }
  
  public final boolean Gv(int paramInt)
  {
    AppMethodBeat.i(237727);
    if ((this.Cdu) && ((paramInt > 200) || (paramInt < 0)))
    {
      AppMethodBeat.o(237727);
      return true;
    }
    View localView = this.AeF;
    if ((localView != null) && (localView.getPaddingBottom() != paramInt)) {
      localView.post((Runnable)new EditorPanelHolder.b(localView, paramInt));
    }
    AppMethodBeat.o(237727);
    return true;
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(237724);
    p.h(paramView, "view");
    this.AeF = paramView;
    if (paramLayoutParams != null) {
      paramLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      paramLayoutParams.gravity = 80;
      addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(237724);
      return;
      if (paramView.getLayoutParams() != null) {
        paramLayoutParams = new FrameLayout.LayoutParams(paramView.getLayoutParams());
      } else {
        paramLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      }
    }
  }
  
  public final boolean bJw()
  {
    AppMethodBeat.i(237728);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(237728);
      return true;
    }
    AppMethodBeat.o(237728);
    return false;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(237729);
    p.h(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(237729);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(237729);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          setShow(false);
          AppMethodBeat.o(237729);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(237729);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(237729);
    return bool;
  }
  
  public final boolean getCloseTouchOutside()
  {
    return this.Cdv;
  }
  
  public final boolean getCoverByKeyboard()
  {
    return this.Cdu;
  }
  
  public final boolean getOutsideTouchable()
  {
    return this.Cdw;
  }
  
  public final void setCloseTouchOutside(boolean paramBoolean)
  {
    this.Cdv = paramBoolean;
  }
  
  public final void setCoverByKeyboard(boolean paramBoolean)
  {
    this.Cdu = paramBoolean;
  }
  
  public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.Ccp = paramb;
  }
  
  public final void setOutsideTouchable(boolean paramBoolean)
  {
    AppMethodBeat.i(237723);
    this.Cdw = paramBoolean;
    if (paramBoolean)
    {
      setOnClickListener(null);
      setClickable(false);
      AppMethodBeat.o(237723);
      return;
    }
    setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(237723);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(237726);
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.Ccp;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
      }
      localObject = this.AeF;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getHeight() == 0)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).post((Runnable)new EditorPanelHolder.e((View)localObject));
          AppMethodBeat.o(237726);
          return;
        }
        ((View)localObject).animate().translationY(0.0F).start();
        AppMethodBeat.o(237726);
        return;
      }
      AppMethodBeat.o(237726);
      return;
    }
    Object localObject = this.Ccp;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
    }
    localObject = this.AeF;
    if (localObject != null)
    {
      ((View)localObject).animate().cancel();
      ((View)localObject).animate().translationY(((View)localObject).getHeight()).withEndAction((Runnable)new d(this)).start();
      AppMethodBeat.o(237726);
      return;
    }
    AppMethodBeat.o(237726);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(237720);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.Cdy.getCloseTouchOutside()) {
        this.Cdy.setShow(false);
      }
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237720);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$setShow$2$1"})
  static final class d
    implements Runnable
  {
    d(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void run()
    {
      AppMethodBeat.i(237721);
      this.Cdy.setVisibility(8);
      AppMethodBeat.o(237721);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder
 * JD-Core Version:    0.7.0.1
 */