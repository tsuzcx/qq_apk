package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "closeTouchOutside", "getCloseTouchOutside", "()Z", "setCloseTouchOutside", "(Z)V", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "plugin-recordvideo_release"})
public final class EditorPanelHolder
  extends InsectFrameLayout
{
  private b<? super Boolean, y> gPX;
  private View rUv;
  private boolean wCa;
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(199433);
    AppMethodBeat.o(199433);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199432);
    this.wCa = true;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199423);
        if (this.wCb.getCloseTouchOutside()) {
          this.wCb.setShow(false);
        }
        AppMethodBeat.o(199423);
      }
    });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(199432);
  }
  
  public final boolean bjw()
  {
    AppMethodBeat.i(199430);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(199430);
      return true;
    }
    AppMethodBeat.o(199430);
    return false;
  }
  
  public final boolean cEv()
  {
    return true;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(199431);
    k.h(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(199431);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(199431);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          setShow(false);
          AppMethodBeat.o(199431);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(199431);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(199431);
    return bool;
  }
  
  public final boolean getCloseTouchOutside()
  {
    return this.wCa;
  }
  
  public final void setCloseTouchOutside(boolean paramBoolean)
  {
    AppMethodBeat.i(199427);
    this.wCa = paramBoolean;
    if (this.wCa)
    {
      setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(199427);
      return;
    }
    setClickable(false);
    AppMethodBeat.o(199427);
  }
  
  public final void setOnVisibleChangeCallback(b<? super Boolean, y> paramb)
  {
    this.gPX = paramb;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(199429);
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.gPX;
      if (localObject != null) {
        ((b)localObject).ay(Boolean.TRUE);
      }
      localObject = this.rUv;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getHeight() == 0)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).post((Runnable)new c((View)localObject));
          AppMethodBeat.o(199429);
          return;
        }
        ((View)localObject).animate().translationY(0.0F).start();
        AppMethodBeat.o(199429);
        return;
      }
      AppMethodBeat.o(199429);
      return;
    }
    Object localObject = this.gPX;
    if (localObject != null) {
      ((b)localObject).ay(Boolean.FALSE);
    }
    localObject = this.rUv;
    if (localObject != null)
    {
      ((View)localObject).animate().cancel();
      ((View)localObject).animate().translationY(((View)localObject).getHeight()).withEndAction((Runnable)new b(this)).start();
      AppMethodBeat.o(199429);
      return;
    }
    AppMethodBeat.o(199429);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199424);
      if (this.wCb.getCloseTouchOutside()) {
        this.wCb.setShow(false);
      }
      AppMethodBeat.o(199424);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$setShow$2$1"})
  static final class b
    implements Runnable
  {
    b(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void run()
    {
      AppMethodBeat.i(199425);
      this.wCb.setVisibility(8);
      AppMethodBeat.o(199425);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(199426);
      this.rUx.setVisibility(0);
      this.rUx.setTranslationY(this.rUx.getHeight());
      this.rUx.animate().translationY(0.0F).start();
      AppMethodBeat.o(199426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder
 * JD-Core Version:    0.7.0.1
 */