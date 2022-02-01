package com.tencent.mm.plugin.recordvideo.ui.editor.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.emoji.view.a
{
  public b<? super Boolean, z> ybm;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    AppMethodBeat.i(207057);
    AppMethodBeat.o(207057);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(207056);
    super.dismiss();
    b localb = this.ybm;
    if (localb != null)
    {
      localb.invoke(Boolean.FALSE);
      AppMethodBeat.o(207056);
      return;
    }
    AppMethodBeat.o(207056);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(207054);
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(207054);
      return;
    }
    dismiss();
    AppMethodBeat.o(207054);
  }
  
  public final void show()
  {
    AppMethodBeat.i(207055);
    super.show();
    b localb = this.ybm;
    if (localb != null)
    {
      localb.invoke(Boolean.TRUE);
      AppMethodBeat.o(207055);
      return;
    }
    AppMethodBeat.o(207055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a.a
 * JD-Core Version:    0.7.0.1
 */