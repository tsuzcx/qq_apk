package com.tencent.mm.plugin.recordvideo.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getInputPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "setInputPanel", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "initHeightSafeArea", "", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "plugin-recordvideo_release"})
public final class h
  extends a
{
  public EditorInputView HMM;
  
  public h(EditorInputView paramEditorInputView, d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(222721);
    this.HMM = paramEditorInputView;
    AppMethodBeat.o(222721);
  }
  
  public final void bR(float paramFloat)
  {
    AppMethodBeat.i(75490);
    this.HMM.bR(paramFloat);
    AppMethodBeat.o(75490);
  }
  
  public final void bS(float paramFloat)
  {
    AppMethodBeat.i(75491);
    this.HMM.bR(paramFloat);
    AppMethodBeat.o(75491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.h
 * JD-Core Version:    0.7.0.1
 */