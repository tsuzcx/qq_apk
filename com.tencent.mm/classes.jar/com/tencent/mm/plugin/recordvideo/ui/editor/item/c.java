package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;Ljava/util/ArrayList;Landroid/graphics/Matrix;)V", "byteArray", "", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;[B)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "captionList", "getCaptionList", "()Ljava/util/ArrayList;", "setCaptionList", "(Ljava/util/ArrayList;)V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "getCurrentTransResult", "timeMs", "", "getShowCaptionAtTime", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/CaptionItemData;", "toString", "Companion", "plugin-recordvideo_release"})
public final class c
  extends a
{
  public static final c.a CeJ;
  public ArrayList<sy> CeH;
  public String CeI;
  public int bgColor;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(237754);
    CeJ = new c.a((byte)0);
    AppMethodBeat.o(237754);
  }
  
  public c(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(237751);
    this.CeH = new ArrayList();
    AppMethodBeat.o(237751);
  }
  
  public c(d paramd, ArrayList<sy> paramArrayList, Matrix paramMatrix)
  {
    super(paramd);
    AppMethodBeat.i(237752);
    this.CeH = new ArrayList();
    this.CeH.clear();
    this.CeH.addAll((Collection)paramArrayList);
    this.gT.set(paramMatrix);
    AppMethodBeat.o(237752);
  }
  
  public c(d paramd, byte[] paramArrayOfByte)
  {
    super(paramd);
    AppMethodBeat.i(237753);
    this.CeH = new ArrayList();
    try
    {
      paramd = (com.tencent.mm.bw.a)new tv();
      try
      {
        paramd.parseFrom(paramArrayOfByte);
        paramd = (tv)paramd;
        if (paramd != null)
        {
          this.CeH.clear();
          this.CeH.addAll((Collection)paramd.Lbb);
          paramArrayOfByte = this.gT;
          erc localerc = paramd.Lce;
          p.g(localerc, "captionData.matrix");
          paramArrayOfByte.setValues(a(localerc));
          this.bgColor = paramd.Lcg;
          this.textColor = paramd.Lcf;
          this.CeI = paramd.CeI;
          Log.i("MicroMsg.CaptionItem", toString());
          AppMethodBeat.o(237753);
          return;
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramd });
          paramd = null;
        }
        AppMethodBeat.o(237753);
        return;
      }
      return;
    }
    catch (IOException paramd)
    {
      Log.printErrStackTrace("MicroMsg.CaptionItem", (Throwable)paramd, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(237753);
    }
  }
  
  public final sy Ii(long paramLong)
  {
    AppMethodBeat.i(237747);
    Iterator localIterator = ((Iterable)this.CeH).iterator();
    while (localIterator.hasNext())
    {
      sy localsy = (sy)localIterator.next();
      if ((localsy.LaT <= paramLong) && (localsy.LaU >= paramLong))
      {
        AppMethodBeat.o(237747);
        return localsy;
      }
    }
    AppMethodBeat.o(237747);
    return null;
  }
  
  public final tv eMj()
  {
    AppMethodBeat.i(237748);
    tv localtv = new tv();
    localtv.Lbb.addAll((Collection)this.CeH);
    localtv.Lce = f(this.gT);
    localtv.Lcg = this.bgColor;
    localtv.Lcf = this.textColor;
    localtv.CeI = this.CeI;
    AppMethodBeat.o(237748);
    return localtv;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237750);
    Iterator localIterator = this.CeH.iterator();
    while (localIterator.hasNext())
    {
      sy localsy = (sy)localIterator.next();
      new StringBuilder().append("").append("start:").append(localsy.LaT).append(" end:").append(localsy.LaU).append(" text:").append(localsy.LaS.toString("UTF-8")).append('\n');
    }
    AppMethodBeat.o(237750);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.c
 * JD-Core Version:    0.7.0.1
 */