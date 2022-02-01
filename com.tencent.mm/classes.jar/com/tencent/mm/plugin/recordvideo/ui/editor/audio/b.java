package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isSelect", "", "isDisable", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;ZZ)V", "getFinderObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "()Z", "setDisable", "(Z)V", "setSelect", "getItemId", "", "getItemType", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  final FinderObject ABJ;
  boolean NXv;
  boolean wwJ;
  
  private b(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(280121);
    this.ABJ = paramFinderObject;
    this.wwJ = false;
    this.NXv = false;
    AppMethodBeat.o(280121);
  }
  
  public final long bZA()
  {
    return this.ABJ.id;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.b
 * JD-Core Version:    0.7.0.1
 */