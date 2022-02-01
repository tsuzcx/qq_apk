package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TEXT", "EMOJI", "LOCATION", "TIP", "LYRICS", "CAPTION", "RECORD_CAPTION", "PAG_STICKER", "plugin-recordvideo_release"})
public enum d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(200656);
    d locald1 = new d("TEXT", 0, 1);
    xNP = locald1;
    d locald2 = new d("EMOJI", 1, 2);
    xNQ = locald2;
    d locald3 = new d("LOCATION", 2, 3);
    xNR = locald3;
    d locald4 = new d("TIP", 3, 4);
    xNS = locald4;
    d locald5 = new d("LYRICS", 4, 5);
    xNT = locald5;
    d locald6 = new d("CAPTION", 5, 6);
    xNU = locald6;
    d locald7 = new d("RECORD_CAPTION", 6, 7);
    xNV = locald7;
    d locald8 = new d("PAG_STICKER", 7, 8);
    xNW = locald8;
    xNX = new d[] { locald1, locald2, locald3, locald4, locald5, locald6, locald7, locald8 };
    AppMethodBeat.o(200656);
  }
  
  private d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.d
 * JD-Core Version:    0.7.0.1
 */