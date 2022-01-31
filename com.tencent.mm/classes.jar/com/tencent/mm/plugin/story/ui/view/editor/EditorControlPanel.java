package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.c.a.a;
import com.tencent.mm.ui.am;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorControlPanel;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addMusicGroup", "Landroid/view/View;", "panelBottom", "Landroid/view/ViewGroup;", "panelTop", "visibleCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "isShow", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-story_release"})
public final class EditorControlPanel
  extends FrameLayout
{
  private b<? super Boolean, y> eTl;
  private final ViewGroup sOH;
  private final ViewGroup sOI;
  private final View sOJ;
  
  public EditorControlPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110539);
    AppMethodBeat.o(110539);
  }
  
  public EditorControlPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110538);
    View.inflate(paramContext, 2130970945, (ViewGroup)this);
    paramAttributeSet = findViewById(2131828371);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_control_layout_top)");
    this.sOH = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131828376);
    j.p(paramAttributeSet, "findViewById(R.id.story_…or_control_layout_bottom)");
    this.sOI = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131828384);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_audio_group)");
    this.sOJ = paramAttributeSet;
    this.sOI.setPadding(0, 0, 0, am.fx(paramContext));
    if (a.srz.czF())
    {
      this.sOJ.setVisibility(0);
      AppMethodBeat.o(110538);
      return;
    }
    this.sOJ.setVisibility(8);
    AppMethodBeat.o(110538);
  }
  
  public final void setOnVisibleChangeCallback(b<? super Boolean, y> paramb)
  {
    this.eTl = paramb;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(110537);
    if (paramBoolean)
    {
      setVisibility(0);
      localb = this.eTl;
      if (localb != null)
      {
        localb.S(Boolean.TRUE);
        AppMethodBeat.o(110537);
        return;
      }
      AppMethodBeat.o(110537);
      return;
    }
    setVisibility(8);
    b localb = this.eTl;
    if (localb != null)
    {
      localb.S(Boolean.FALSE);
      AppMethodBeat.o(110537);
      return;
    }
    AppMethodBeat.o(110537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorControlPanel
 * JD-Core Version:    0.7.0.1
 */