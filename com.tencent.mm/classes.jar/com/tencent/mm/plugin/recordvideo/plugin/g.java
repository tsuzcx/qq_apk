package com.tencent.mm.plugin.recordvideo.plugin;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "getInputPanel", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "setInputPanel", "initHeightSafeArea", "", "safeHeight", "", "safeFrameHeight", "initWidthSafeArea", "safeWidth", "safeFrameWidth", "plugin-recordvideo_release"})
public final class g
  implements t
{
  public EditorInputView xzZ;
  
  public g(EditorInputView paramEditorInputView)
  {
    AppMethodBeat.i(75492);
    this.xzZ = paramEditorInputView;
    AppMethodBeat.o(75492);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final void bs(float paramFloat)
  {
    AppMethodBeat.i(75490);
    this.xzZ.bs(paramFloat);
    AppMethodBeat.o(75490);
  }
  
  public final void bt(float paramFloat)
  {
    AppMethodBeat.i(75491);
    this.xzZ.bs(paramFloat);
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
    AppMethodBeat.i(200309);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200309);
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