package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "EMOJI", "LOCATION", "TIP", "LYRICS", "CAPTION", "RECORD_CAPTION", "PAG_STICKER", "plugin-recordvideo_release"})
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(237755);
    d locald1 = new d("TEXT", 0, 1);
    CeK = locald1;
    d locald2 = new d("EMOJI", 1, 2);
    CeL = locald2;
    d locald3 = new d("LOCATION", 2, 3);
    CeM = locald3;
    d locald4 = new d("TIP", 3, 4);
    CeN = locald4;
    d locald5 = new d("LYRICS", 4, 5);
    CeO = locald5;
    d locald6 = new d("CAPTION", 5, 6);
    CeP = locald6;
    d locald7 = new d("RECORD_CAPTION", 6, 7);
    CeQ = locald7;
    d locald8 = new d("PAG_STICKER", 7, 8);
    CeR = locald8;
    CeS = new d[] { locald1, locald2, locald3, locald4, locald5, locald6, locald7, locald8 };
    AppMethodBeat.o(237755);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.d
 * JD-Core Version:    0.7.0.1
 */