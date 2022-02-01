package com.tencent.mm.plugin.recordvideo.ui.editor.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-recordvideo_release"})
public final class a
  extends com.tencent.mm.emoji.view.a
{
  public b<? super Boolean, x> Ccp;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    AppMethodBeat.i(237898);
    this.hee.setBackgroundColor(com.tencent.mm.cb.a.n(paramContext, 2131100310));
    AppMethodBeat.o(237898);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(237897);
    super.dismiss();
    b localb = this.Ccp;
    if (localb != null)
    {
      localb.invoke(Boolean.FALSE);
      AppMethodBeat.o(237897);
      return;
    }
    AppMethodBeat.o(237897);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(237895);
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(237895);
      return;
    }
    dismiss();
    AppMethodBeat.o(237895);
  }
  
  public final void show()
  {
    AppMethodBeat.i(237896);
    super.show();
    b localb = this.Ccp;
    if (localb != null)
    {
      localb.invoke(Boolean.TRUE);
      AppMethodBeat.o(237896);
      return;
    }
    AppMethodBeat.o(237896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a.a
 * JD-Core Version:    0.7.0.1
 */