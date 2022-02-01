package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;Ljava/util/ArrayList;Landroid/graphics/Matrix;)V", "byteArray", "", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;[B)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "captionList", "getCaptionList", "()Ljava/util/ArrayList;", "setCaptionList", "(Ljava/util/ArrayList;)V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "getCurrentTransResult", "timeMs", "", "getShowCaptionAtTime", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/CaptionItemData;", "toString", "Companion", "plugin-recordvideo_release"})
public final class c
  extends a
{
  public static final c.a ydH;
  public int bgColor;
  public int textColor;
  public ArrayList<rv> ydF;
  public String ydG;
  
  static
  {
    AppMethodBeat.i(206913);
    ydH = new c.a((byte)0);
    AppMethodBeat.o(206913);
  }
  
  public c(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(206910);
    this.ydF = new ArrayList();
    AppMethodBeat.o(206910);
  }
  
  public c(d paramd, ArrayList<rv> paramArrayList, Matrix paramMatrix)
  {
    super(paramd);
    AppMethodBeat.i(206911);
    this.ydF = new ArrayList();
    this.ydF.clear();
    this.ydF.addAll((Collection)paramArrayList);
    this.gR.set(paramMatrix);
    AppMethodBeat.o(206911);
  }
  
  public c(d paramd, byte[] paramArrayOfByte)
  {
    super(paramd);
    AppMethodBeat.i(206912);
    this.ydF = new ArrayList();
    try
    {
      paramd = (com.tencent.mm.bw.a)new sq();
      try
      {
        paramd.parseFrom(paramArrayOfByte);
        paramd = (sq)paramd;
        if (paramd != null)
        {
          this.ydF.clear();
          this.ydF.addAll((Collection)paramd.Ggy);
          paramArrayOfByte = this.gR;
          dww localdww = paramd.GhB;
          p.g(localdww, "captionData.matrix");
          paramArrayOfByte.setValues(a(localdww));
          this.bgColor = paramd.GhD;
          this.textColor = paramd.GhC;
          this.ydG = paramd.ydG;
          ae.i("MicroMsg.CaptionItem", toString());
          AppMethodBeat.o(206912);
          return;
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramd });
          paramd = null;
        }
        AppMethodBeat.o(206912);
        return;
      }
      return;
    }
    catch (IOException paramd)
    {
      ae.printErrStackTrace("MicroMsg.CaptionItem", (Throwable)paramd, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(206912);
    }
  }
  
  public final sq dLj()
  {
    AppMethodBeat.i(206907);
    sq localsq = new sq();
    localsq.Ggy.addAll((Collection)this.ydF);
    localsq.GhB = f(this.gR);
    localsq.GhD = this.bgColor;
    localsq.GhC = this.textColor;
    localsq.ydG = this.ydG;
    AppMethodBeat.o(206907);
    return localsq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206909);
    Iterator localIterator = this.ydF.iterator();
    while (localIterator.hasNext())
    {
      rv localrv = (rv)localIterator.next();
      new StringBuilder().append("").append("start:").append(localrv.Ggq).append(" end:").append(localrv.Ggr).append(" text:").append(localrv.Ggp.toString("UTF-8")).append('\n');
    }
    AppMethodBeat.o(206909);
    return "";
  }
  
  public final rv zk(long paramLong)
  {
    AppMethodBeat.i(206906);
    Iterator localIterator = ((Iterable)this.ydF).iterator();
    while (localIterator.hasNext())
    {
      rv localrv = (rv)localIterator.next();
      if ((localrv.Ggq <= paramLong) && (localrv.Ggr >= paramLong))
      {
        AppMethodBeat.o(206906);
        return localrv;
      }
    }
    AppMethodBeat.o(206906);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.c
 * JD-Core Version:    0.7.0.1
 */