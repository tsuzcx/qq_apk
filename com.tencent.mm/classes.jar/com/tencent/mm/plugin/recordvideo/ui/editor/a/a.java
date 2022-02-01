package com.tencent.mm.plugin.recordvideo.ui.editor.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "hasVisibleCallback", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.emoji.view.a
{
  public b<? super Boolean, x> HYF;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    AppMethodBeat.i(225894);
    this.jPK.setBackgroundColor(com.tencent.mm.ci.a.w(paramContext, b.b.emoji_panel_color_dark));
    AppMethodBeat.o(225894);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(225889);
    super.dismiss();
    b localb = this.HYF;
    if (localb != null)
    {
      localb.invoke(Boolean.FALSE);
      AppMethodBeat.o(225889);
      return;
    }
    AppMethodBeat.o(225889);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(225886);
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(225886);
      return;
    }
    dismiss();
    AppMethodBeat.o(225886);
  }
  
  public final void show()
  {
    AppMethodBeat.i(225887);
    super.show();
    b localb = this.HYF;
    if (localb != null)
    {
      localb.invoke(Boolean.TRUE);
      AppMethodBeat.o(225887);
      return;
    }
    AppMethodBeat.o(225887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a.a
 * JD-Core Version:    0.7.0.1
 */