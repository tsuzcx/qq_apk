package com.tencent.mm.plugin.recordvideo.ui.editor.a;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.view.SmileyPanelImpl;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/EditorEmojiPanel;", "Lcom/tencent/mm/emoji/view/EmojiPanelBottomSheet;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "darkMode", "", "(Landroid/content/Context;Landroid/view/ViewGroup;Z)V", "visibleCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "visible", "", "dismiss", "hasVisibleCallback", "setOnVisibleChangeCallback", "callback", "setShow", "show", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.emoji.view.a
{
  public b<? super Boolean, ah> NVo;
  
  public a(Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    AppMethodBeat.i(279935);
    this.moB.setBackgroundColor(com.tencent.mm.cd.a.w(paramContext, b.b.emoji_panel_color_dark));
    AppMethodBeat.o(279935);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(279950);
    super.dismiss();
    b localb = this.NVo;
    if (localb != null) {
      localb.invoke(Boolean.FALSE);
    }
    AppMethodBeat.o(279950);
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(279941);
    if (paramBoolean)
    {
      show();
      AppMethodBeat.o(279941);
      return;
    }
    dismiss();
    AppMethodBeat.o(279941);
  }
  
  public final void show()
  {
    AppMethodBeat.i(279946);
    super.show();
    b localb = this.NVo;
    if (localb != null) {
      localb.invoke(Boolean.TRUE);
    }
    AppMethodBeat.o(279946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a.a
 * JD-Core Version:    0.7.0.1
 */