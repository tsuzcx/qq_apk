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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeTouchOutside", "", "getCloseTouchOutside", "()Z", "setCloseTouchOutside", "(Z)V", "coverByKeyboard", "getCoverByKeyboard", "setCoverByKeyboard", "value", "outsideTouchable", "getOutsideTouchable", "setOutsideTouchable", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "Companion", "plugin-recordvideo_release"})
public final class EditorPanelHolder
  extends InsectFrameLayout
{
  public static final EditorPanelHolder.a ycv;
  private d.g.a.b<? super Boolean, z> ybm;
  private View ycr;
  private boolean ycs;
  private boolean yct;
  private boolean ycu;
  
  static
  {
    AppMethodBeat.i(206897);
    ycv = new EditorPanelHolder.a((byte)0);
    AppMethodBeat.o(206897);
  }
  
  public EditorPanelHolder(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(206896);
    AppMethodBeat.o(206896);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(206895);
    AppMethodBeat.o(206895);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(206894);
    this.yct = true;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(206883);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.ycw.getCloseTouchOutside()) {
          this.ycw.setShow(false);
        }
        a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206883);
      }
    });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(206894);
  }
  
  public final boolean CK(int paramInt)
  {
    AppMethodBeat.i(206891);
    if ((this.ycs) && ((paramInt > 200) || (paramInt < 0)))
    {
      AppMethodBeat.o(206891);
      return true;
    }
    Object localObject = this.ycr;
    if (localObject != null)
    {
      ae.i("MicroMsg.EditorPanelHolder", "insectBottom  ".concat(String.valueOf(paramInt)));
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      if (localLayoutParams == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(206891);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localLayoutParams).bottomMargin = paramInt;
      ((View)localObject).setLayoutParams(((View)localObject).getLayoutParams());
    }
    AppMethodBeat.o(206891);
    return true;
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(206888);
    p.h(paramView, "view");
    this.ycr = paramView;
    if (paramLayoutParams != null) {
      paramLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      paramLayoutParams.gravity = 80;
      addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(206888);
      return;
      if (paramView.getLayoutParams() != null) {
        paramLayoutParams = new FrameLayout.LayoutParams(paramView.getLayoutParams());
      } else {
        paramLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      }
    }
  }
  
  public final boolean bnS()
  {
    AppMethodBeat.i(206892);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(206892);
      return true;
    }
    AppMethodBeat.o(206892);
    return false;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(206893);
    p.h(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(206893);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(206893);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          setShow(false);
          AppMethodBeat.o(206893);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(206893);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(206893);
    return bool;
  }
  
  public final boolean getCloseTouchOutside()
  {
    return this.yct;
  }
  
  public final boolean getCoverByKeyboard()
  {
    return this.ycs;
  }
  
  public final boolean getOutsideTouchable()
  {
    return this.ycu;
  }
  
  public final void setCloseTouchOutside(boolean paramBoolean)
  {
    this.yct = paramBoolean;
  }
  
  public final void setCoverByKeyboard(boolean paramBoolean)
  {
    this.ycs = paramBoolean;
  }
  
  public final void setOnVisibleChangeCallback(d.g.a.b<? super Boolean, z> paramb)
  {
    this.ybm = paramb;
  }
  
  public final void setOutsideTouchable(boolean paramBoolean)
  {
    AppMethodBeat.i(206887);
    this.ycu = paramBoolean;
    if (paramBoolean)
    {
      setOnClickListener(null);
      setClickable(false);
      AppMethodBeat.o(206887);
      return;
    }
    setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(206887);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(206890);
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.ybm;
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(Boolean.TRUE);
      }
      localObject = this.ycr;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getHeight() == 0)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).post((Runnable)new EditorPanelHolder.d((View)localObject));
          AppMethodBeat.o(206890);
          return;
        }
        ((View)localObject).animate().translationY(0.0F).start();
        AppMethodBeat.o(206890);
        return;
      }
      AppMethodBeat.o(206890);
      return;
    }
    Object localObject = this.ybm;
    if (localObject != null) {
      ((d.g.a.b)localObject).invoke(Boolean.FALSE);
    }
    localObject = this.ycr;
    if (localObject != null)
    {
      ((View)localObject).animate().cancel();
      ((View)localObject).animate().translationY(((View)localObject).getHeight()).withEndAction((Runnable)new c(this)).start();
      AppMethodBeat.o(206890);
      return;
    }
    AppMethodBeat.o(206890);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206884);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (this.ycw.getCloseTouchOutside()) {
        this.ycw.setShow(false);
      }
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(206884);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$setShow$2$1"})
  static final class c
    implements Runnable
  {
    c(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void run()
    {
      AppMethodBeat.i(206885);
      this.ycw.setVisibility(8);
      AppMethodBeat.o(206885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder
 * JD-Core Version:    0.7.0.1
 */