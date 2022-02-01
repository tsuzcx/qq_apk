package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "getInputPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "setInputPanel", "initHeightSafeArea", "", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "plugin-recordvideo_release"})
public final class g
  implements t
{
  public EditorInputView BPY;
  
  public g(EditorInputView paramEditorInputView)
  {
    AppMethodBeat.i(75492);
    this.BPY = paramEditorInputView;
    AppMethodBeat.o(75492);
  }
  
  public final void aSs() {}
  
  public final void bL(float paramFloat)
  {
    AppMethodBeat.i(75490);
    this.BPY.bL(paramFloat);
    AppMethodBeat.o(75490);
  }
  
  public final void bM(float paramFloat)
  {
    AppMethodBeat.i(75491);
    this.BPY.bL(paramFloat);
    AppMethodBeat.o(75491);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237284);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237284);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.g
 * JD-Core Version:    0.7.0.1
 */