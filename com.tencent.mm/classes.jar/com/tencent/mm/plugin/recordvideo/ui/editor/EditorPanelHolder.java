package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeTouchOutside", "", "getCloseTouchOutside", "()Z", "setCloseTouchOutside", "(Z)V", "coverByKeyboard", "getCoverByKeyboard", "setCoverByKeyboard", "isDismissing", "value", "outsideTouchable", "getOutsideTouchable", "setOutsideTouchable", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "hasInit", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorPanelHolder
  extends InsectFrameLayout
{
  public static final EditorPanelHolder.a NWo;
  private View LGq;
  private kotlin.g.a.b<? super Boolean, ah> NVo;
  private boolean NWp;
  private boolean NWq;
  private boolean NWr;
  private boolean NWs;
  
  static
  {
    AppMethodBeat.i(280199);
    NWo = new EditorPanelHolder.a((byte)0);
    AppMethodBeat.o(280199);
  }
  
  public EditorPanelHolder(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(280147);
    AppMethodBeat.o(280147);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(280143);
    AppMethodBeat.o(280143);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(280139);
    this.NWr = true;
    setOnClickListener(new EditorPanelHolder..ExternalSyntheticLambda0(this));
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(280139);
  }
  
  private static final void aQ(View paramView, int paramInt)
  {
    AppMethodBeat.i(280190);
    s.u(paramView, "$this_run");
    paramView.setPadding(paramView.getPaddingLeft(), paramView.getPaddingTop(), paramView.getPaddingRight(), paramInt);
    paramView.requestLayout();
    AppMethodBeat.o(280190);
  }
  
  private static final void b(EditorPanelHolder paramEditorPanelHolder, View paramView)
  {
    AppMethodBeat.i(280160);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramEditorPanelHolder);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEditorPanelHolder, "this$0");
    if (paramEditorPanelHolder.getCloseTouchOutside()) {
      paramEditorPanelHolder.setShow(false);
    }
    a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280160);
  }
  
  private static final void c(EditorPanelHolder paramEditorPanelHolder, View paramView)
  {
    AppMethodBeat.i(280167);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramEditorPanelHolder);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramEditorPanelHolder, "this$0");
    if (paramEditorPanelHolder.getCloseTouchOutside()) {
      paramEditorPanelHolder.setShow(false);
    }
    a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/EditorPanelHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(280167);
  }
  
  private static final void setShow$lambda-3$lambda-2(View paramView)
  {
    AppMethodBeat.i(280174);
    s.u(paramView, "$panel");
    paramView.setVisibility(0);
    paramView.setTranslationY(paramView.getHeight());
    paramView.animate().translationY(0.0F).start();
    AppMethodBeat.o(280174);
  }
  
  private static final void setShow$lambda-5$lambda-4(EditorPanelHolder paramEditorPanelHolder)
  {
    AppMethodBeat.i(280180);
    s.u(paramEditorPanelHolder, "this$0");
    paramEditorPanelHolder.setVisibility(8);
    paramEditorPanelHolder.NWp = false;
    AppMethodBeat.o(280180);
  }
  
  public final boolean La(int paramInt)
  {
    AppMethodBeat.i(280322);
    if ((this.NWq) && ((paramInt > 200) || (paramInt < 0)))
    {
      AppMethodBeat.o(280322);
      return true;
    }
    View localView = this.LGq;
    if ((localView != null) && (localView.getPaddingBottom() != paramInt)) {
      localView.post(new EditorPanelHolder..ExternalSyntheticLambda3(localView, paramInt));
    }
    AppMethodBeat.o(280322);
    return true;
  }
  
  public final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(280280);
    s.u(paramView, "view");
    this.LGq = paramView;
    if (paramLayoutParams != null) {
      paramLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      paramLayoutParams.gravity = 80;
      addView(paramView, (ViewGroup.LayoutParams)paramLayoutParams);
      AppMethodBeat.o(280280);
      return;
      if (paramView.getLayoutParams() != null) {
        paramLayoutParams = new FrameLayout.LayoutParams(paramView.getLayoutParams());
      } else {
        paramLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      }
    }
  }
  
  public final boolean cvt()
  {
    AppMethodBeat.i(280329);
    if ((getVisibility() == 0) && (!this.NWp))
    {
      AppMethodBeat.o(280329);
      return true;
    }
    AppMethodBeat.o(280329);
    return false;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(280343);
    s.u(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(280343);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(280343);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          setShow(false);
          AppMethodBeat.o(280343);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(280343);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(280343);
    return bool;
  }
  
  public final boolean gBh()
  {
    return this.LGq != null;
  }
  
  public final boolean getCloseTouchOutside()
  {
    return this.NWr;
  }
  
  public final boolean getCoverByKeyboard()
  {
    return this.NWq;
  }
  
  public final boolean getOutsideTouchable()
  {
    return this.NWs;
  }
  
  public final void setCloseTouchOutside(boolean paramBoolean)
  {
    this.NWr = paramBoolean;
  }
  
  public final void setCoverByKeyboard(boolean paramBoolean)
  {
    this.NWq = paramBoolean;
  }
  
  public final void setOnVisibleChangeCallback(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.NVo = paramb;
  }
  
  public final void setOutsideTouchable(boolean paramBoolean)
  {
    AppMethodBeat.i(280274);
    this.NWs = paramBoolean;
    if (paramBoolean)
    {
      setOnClickListener(null);
      setClickable(false);
      AppMethodBeat.o(280274);
      return;
    }
    setOnClickListener(new EditorPanelHolder..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(280274);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(280313);
    Object localObject;
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.NVo;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
      }
      localObject = this.LGq;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getHeight() == 0)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).post(new EditorPanelHolder..ExternalSyntheticLambda2((View)localObject));
          AppMethodBeat.o(280313);
          return;
        }
        ((View)localObject).animate().translationY(0.0F).start();
        AppMethodBeat.o(280313);
      }
    }
    else
    {
      this.NWp = true;
      localObject = this.NVo;
      if (localObject != null) {
        ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
      }
      localObject = this.LGq;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        ((View)localObject).animate().translationY(((View)localObject).getHeight()).withEndAction(new EditorPanelHolder..ExternalSyntheticLambda4(this)).start();
      }
    }
    AppMethodBeat.o(280313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.EditorPanelHolder
 * JD-Core Version:    0.7.0.1
 */