package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "EMOJI", "LOCATION", "TIP", "LYRICS", "CAPTION", "RECORD_CAPTION", "PAG_STICKER", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(280348);
    NYd = new d("TEXT", 0, 1);
    NYe = new d("EMOJI", 1, 2);
    NYf = new d("LOCATION", 2, 3);
    NYg = new d("TIP", 3, 4);
    NYh = new d("LYRICS", 4, 5);
    NYi = new d("CAPTION", 5, 6);
    NYj = new d("RECORD_CAPTION", 6, 7);
    NYk = new d("PAG_STICKER", 7, 8);
    NYl = new d[] { NYd, NYe, NYf, NYg, NYh, NYi, NYj, NYk };
    AppMethodBeat.o(280348);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.d
 * JD-Core Version:    0.7.0.1
 */