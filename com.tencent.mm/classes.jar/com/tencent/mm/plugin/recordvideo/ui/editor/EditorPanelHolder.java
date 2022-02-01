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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeTouchOutside", "", "getCloseTouchOutside", "()Z", "setCloseTouchOutside", "(Z)V", "coverByKeyboard", "getCoverByKeyboard", "setCoverByKeyboard", "value", "outsideTouchable", "getOutsideTouchable", "setOutsideTouchable", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "Companion", "plugin-recordvideo_release"})
public final class EditorPanelHolder
  extends InsectFrameLayout
{
  public static final EditorPanelHolder.a xMB;
  private d.g.a.b<? super Boolean, z> xLr;
  private boolean xMA;
  private View xMx;
  private boolean xMy;
  private boolean xMz;
  
  static
  {
    AppMethodBeat.i(200639);
    xMB = new EditorPanelHolder.a((byte)0);
    AppMethodBeat.o(200639);
  }
  
  public EditorPanelHolder(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(200638);
    AppMethodBeat.o(200638);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(200637);
    AppMethodBeat.o(200637);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200636);
    this.xMz = true;
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200625);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.xMC.getCloseTouchOutside()) {
          this.xMC.setShow(false);
        }
        a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200625);
      }
    });
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(200636);
  }
  
  public final boolean Cy(int paramInt)
  {
    AppMethodBeat.i(200633);
    if ((this.xMy) && ((paramInt > 200) || (paramInt < 0)))
    {
      AppMethodBeat.o(200633);
      return true;
    }
    Object localObject = this.xMx;
    if (localObject != null)
    {
      ad.i("MicroMsg.EditorPanelHolder", "insectBottom  ".concat(String.valueOf(paramInt)));
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
      if (localLayoutParams == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(200633);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localLayoutParams).bottomMargin = paramInt;
      ((View)localObject).setLayoutParams(((View)localObject).getLayoutParams());
    }
    AppMethodBeat.o(200633);
    return true;
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200630);
    p.h(paramView, "view");
    this.xMx = paramView;
    if (paramLayoutParams != null) {
      paramLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      paramLayoutParams.gravity = 80;
      addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(200630);
      return;
      if (paramView.getLayoutParams() != null) {
        paramLayoutParams = new FrameLayout.LayoutParams(paramView.getLayoutParams());
      } else {
        paramLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      }
    }
  }
  
  public final boolean bni()
  {
    AppMethodBeat.i(200634);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(200634);
      return true;
    }
    AppMethodBeat.o(200634);
    return false;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200635);
    p.h(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(200635);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(200635);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          setShow(false);
          AppMethodBeat.o(200635);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(200635);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(200635);
    return bool;
  }
  
  public final boolean getCloseTouchOutside()
  {
    return this.xMz;
  }
  
  public final boolean getCoverByKeyboard()
  {
    return this.xMy;
  }
  
  public final boolean getOutsideTouchable()
  {
    return this.xMA;
  }
  
  public final void setCloseTouchOutside(boolean paramBoolean)
  {
    this.xMz = paramBoolean;
  }
  
  public final void setCoverByKeyboard(boolean paramBoolean)
  {
    this.xMy = paramBoolean;
  }
  
  public final void setOnVisibleChangeCallback(d.g.a.b<? super Boolean, z> paramb)
  {
    this.xLr = paramb;
  }
  
  public final void setOutsideTouchable(boolean paramBoolean)
  {
    AppMethodBeat.i(200629);
    this.xMA = paramBoolean;
    if (paramBoolean)
    {
      setOnClickListener(null);
      setClickable(false);
      AppMethodBeat.o(200629);
      return;
    }
    setOnClickListener((View.OnClickListener)new b(this));
    AppMethodBeat.o(200629);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(200632);
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.xLr;
      if (localObject != null) {
        ((d.g.a.b)localObject).invoke(Boolean.TRUE);
      }
      localObject = this.xMx;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getHeight() == 0)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).post((Runnable)new d((View)localObject));
          AppMethodBeat.o(200632);
          return;
        }
        ((View)localObject).animate().translationY(0.0F).start();
        AppMethodBeat.o(200632);
        return;
      }
      AppMethodBeat.o(200632);
      return;
    }
    Object localObject = this.xLr;
    if (localObject != null) {
      ((d.g.a.b)localObject).invoke(Boolean.FALSE);
    }
    localObject = this.xMx;
    if (localObject != null)
    {
      ((View)localObject).animate().cancel();
      ((View)localObject).animate().translationY(((View)localObject).getHeight()).withEndAction((Runnable)new c(this)).start();
      AppMethodBeat.o(200632);
      return;
    }
    AppMethodBeat.o(200632);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200626);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (this.xMC.getCloseTouchOutside()) {
        this.xMC.setShow(false);
      }
      a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$outsideTouchable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200626);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder$setShow$2$1"})
  static final class c
    implements Runnable
  {
    c(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void run()
    {
      AppMethodBeat.i(200627);
      this.xMC.setVisibility(8);
      AppMethodBeat.o(200627);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(200628);
      this.xMD.setVisibility(0);
      this.xMD.setTranslationY(this.xMD.getHeight());
      this.xMD.animate().translationY(0.0F).start();
      AppMethodBeat.o(200628);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder
 * JD-Core Version:    0.7.0.1
 */