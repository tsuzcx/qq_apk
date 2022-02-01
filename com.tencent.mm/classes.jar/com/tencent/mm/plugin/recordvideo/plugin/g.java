package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "getInputPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "setInputPanel", "initHeightSafeArea", "", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "plugin-recordvideo_release"})
public final class g
  implements t
{
  public EditorInputView xPV;
  
  public g(EditorInputView paramEditorInputView)
  {
    AppMethodBeat.i(75492);
    this.xPV = paramEditorInputView;
    AppMethodBeat.o(75492);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final void bs(float paramFloat)
  {
    AppMethodBeat.i(75490);
    this.xPV.bs(paramFloat);
    AppMethodBeat.o(75490);
  }
  
  public final void bt(float paramFloat)
  {
    AppMethodBeat.i(75491);
    this.xPV.bs(paramFloat);
    AppMethodBeat.o(75491);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(206570);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(206570);
  }
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.g
 * JD-Core Version:    0.7.0.1
 */