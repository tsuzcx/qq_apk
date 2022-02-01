package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.protocal.protobuf.so;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;Ljava/util/ArrayList;Landroid/graphics/Matrix;)V", "byteArray", "", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;[B)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "captionList", "getCaptionList", "()Ljava/util/ArrayList;", "setCaptionList", "(Ljava/util/ArrayList;)V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "getCurrentTransResult", "timeMs", "", "getShowCaptionAtTime", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/CaptionItemData;", "toString", "Companion", "plugin-recordvideo_release"})
public final class c
  extends a
{
  public static final c.a xNO;
  public int bgColor;
  public int textColor;
  public ArrayList<rt> xNM;
  public String xNN;
  
  static
  {
    AppMethodBeat.i(200655);
    xNO = new c.a((byte)0);
    AppMethodBeat.o(200655);
  }
  
  public c(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(200652);
    this.xNM = new ArrayList();
    AppMethodBeat.o(200652);
  }
  
  public c(d paramd, ArrayList<rt> paramArrayList, Matrix paramMatrix)
  {
    super(paramd);
    AppMethodBeat.i(200653);
    this.xNM = new ArrayList();
    this.xNM.clear();
    this.xNM.addAll((Collection)paramArrayList);
    this.gR.set(paramMatrix);
    AppMethodBeat.o(200653);
  }
  
  public c(d paramd, byte[] paramArrayOfByte)
  {
    super(paramd);
    AppMethodBeat.i(200654);
    this.xNM = new ArrayList();
    try
    {
      paramd = (com.tencent.mm.bx.a)new so();
      try
      {
        paramd.parseFrom(paramArrayOfByte);
        paramd = (so)paramd;
        if (paramd != null)
        {
          this.xNM.clear();
          this.xNM.addAll((Collection)paramd.FNZ);
          paramArrayOfByte = this.gR;
          dwb localdwb = paramd.FPc;
          p.g(localdwb, "captionData.matrix");
          paramArrayOfByte.setValues(a(localdwb));
          this.bgColor = paramd.FPe;
          this.textColor = paramd.FPd;
          this.xNN = paramd.xNN;
          ad.i("MicroMsg.CaptionItem", toString());
          AppMethodBeat.o(200654);
          return;
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramd });
          paramd = null;
        }
        AppMethodBeat.o(200654);
        return;
      }
      return;
    }
    catch (IOException paramd)
    {
      ad.printErrStackTrace("MicroMsg.CaptionItem", (Throwable)paramd, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(200654);
    }
  }
  
  public final so dHS()
  {
    AppMethodBeat.i(200649);
    so localso = new so();
    localso.FNZ.addAll((Collection)this.xNM);
    localso.FPc = f(this.gR);
    localso.FPe = this.bgColor;
    localso.FPd = this.textColor;
    localso.xNN = this.xNN;
    AppMethodBeat.o(200649);
    return localso;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200651);
    Iterator localIterator = this.xNM.iterator();
    while (localIterator.hasNext())
    {
      rt localrt = (rt)localIterator.next();
      new StringBuilder().append("").append("start:").append(localrt.FNR).append(" end:").append(localrt.FNS).append(" text:").append(localrt.FNQ.toString("UTF-8")).append('\n');
    }
    AppMethodBeat.o(200651);
    return "";
  }
  
  public final rt yM(long paramLong)
  {
    AppMethodBeat.i(200648);
    Iterator localIterator = ((Iterable)this.xNM).iterator();
    while (localIterator.hasNext())
    {
      rt localrt = (rt)localIterator.next();
      if ((localrt.FNR <= paramLong) && (localrt.FNS >= paramLong))
      {
        AppMethodBeat.o(200648);
        return localrt;
      }
    }
    AppMethodBeat.o(200648);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.c
 * JD-Core Version:    0.7.0.1
 */