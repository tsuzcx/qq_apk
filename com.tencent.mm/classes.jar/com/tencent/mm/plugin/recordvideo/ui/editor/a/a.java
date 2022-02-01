package com.tencent.mm.plugin.recordvideo.ui.editor.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.emoji.view.a
{
  public b<? super Boolean, z> xLr;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    AppMethodBeat.i(200799);
    AppMethodBeat.o(200799);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(200798);
    super.dismiss();
    b localb = this.xLr;
    if (localb != null)
    {
      localb.invoke(Boolean.FALSE);
      AppMethodBeat.o(200798);
      return;
    }
    AppMethodBeat.o(200798);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(200796);
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(200796);
      return;
    }
    dismiss();
    AppMethodBeat.o(200796);
  }
  
  public final void show()
  {
    AppMethodBeat.i(200797);
    super.show();
    b localb = this.xLr;
    if (localb != null)
    {
      localb.invoke(Boolean.TRUE);
      AppMethodBeat.o(200797);
      return;
    }
    AppMethodBeat.o(200797);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a.a
 * JD-Core Version:    0.7.0.1
 */