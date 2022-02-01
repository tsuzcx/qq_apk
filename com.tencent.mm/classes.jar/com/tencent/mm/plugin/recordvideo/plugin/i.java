package com.tencent.mm.plugin.recordvideo.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getInputPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "setInputPanel", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "initHeightSafeArea", "", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a
{
  public EditorInputView NJH;
  
  public i(EditorInputView paramEditorInputView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(280809);
    this.NJH = paramEditorInputView;
    AppMethodBeat.o(280809);
  }
  
  public final void cV(float paramFloat)
  {
    AppMethodBeat.i(75490);
    this.NJH.cV(paramFloat);
    AppMethodBeat.o(75490);
  }
  
  public final void cW(float paramFloat)
  {
    AppMethodBeat.i(75491);
    this.NJH.cV(paramFloat);
    AppMethodBeat.o(75491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.i
 * JD-Core Version:    0.7.0.1
 */