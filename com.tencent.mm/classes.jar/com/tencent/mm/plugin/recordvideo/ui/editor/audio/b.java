package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isSelect", "", "isDisable", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;ZZ)V", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "()Z", "setDisable", "(Z)V", "setSelect", "getItemId", "", "getItemType", "", "plugin-recordvideo_release"})
public final class b
  implements a
{
  boolean IaV;
  boolean tsm;
  final FinderObject xcx;
  
  private b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(220234);
    this.xcx = paramFinderObject;
    this.tsm = false;
    this.IaV = false;
    AppMethodBeat.o(220234);
  }
  
  public final int bAQ()
  {
    return 0;
  }
  
  public final long mf()
  {
    return this.xcx.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.b
 * JD-Core Version:    0.7.0.1
 */