package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.fbn;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;Ljava/util/ArrayList;Landroid/graphics/Matrix;)V", "byteArray", "", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;[B)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "captionList", "getCaptionList", "()Ljava/util/ArrayList;", "setCaptionList", "(Ljava/util/ArrayList;)V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "getCurrentTransResult", "timeMs", "", "getShowCaptionAtTime", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/CaptionItemData;", "toString", "Companion", "plugin-recordvideo_release"})
public final class c
  extends a
{
  public static final a IbF;
  public ArrayList<ta> IbD;
  public String IbE;
  public int bgColor;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(221778);
    IbF = new a((byte)0);
    AppMethodBeat.o(221778);
  }
  
  public c(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(221772);
    this.IbD = new ArrayList();
    AppMethodBeat.o(221772);
  }
  
  public c(d paramd, ArrayList<ta> paramArrayList, Matrix paramMatrix)
  {
    super(paramd);
    AppMethodBeat.i(221774);
    this.IbD = new ArrayList();
    this.IbD.clear();
    this.IbD.addAll((Collection)paramArrayList);
    this.aHZ.set(paramMatrix);
    AppMethodBeat.o(221774);
  }
  
  public c(d paramd, byte[] paramArrayOfByte)
  {
    super(paramd);
    AppMethodBeat.i(221777);
    this.IbD = new ArrayList();
    try
    {
      paramd = (com.tencent.mm.cd.a)new tx();
      try
      {
        paramd.parseFrom(paramArrayOfByte);
        paramd = (tx)paramd;
        if (paramd != null)
        {
          this.IbD.clear();
          this.IbD.addAll((Collection)paramd.Scn);
          paramArrayOfByte = this.aHZ;
          fbn localfbn = paramd.Sdr;
          p.j(localfbn, "captionData.matrix");
          paramArrayOfByte.setValues(a(localfbn));
          this.bgColor = paramd.Sdt;
          this.textColor = paramd.Sds;
          this.IbE = paramd.IbE;
          Log.i("MicroMsg.CaptionItem", toString());
          AppMethodBeat.o(221777);
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
        AppMethodBeat.o(221777);
        return;
      }
      return;
    }
    catch (IOException paramd)
    {
      Log.printErrStackTrace("MicroMsg.CaptionItem", (Throwable)paramd, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(221777);
    }
  }
  
  public final ta PB(long paramLong)
  {
    AppMethodBeat.i(221754);
    Iterator localIterator = ((Iterable)this.IbD).iterator();
    while (localIterator.hasNext())
    {
      ta localta = (ta)localIterator.next();
      if ((localta.Scf <= paramLong) && (localta.Scg >= paramLong))
      {
        AppMethodBeat.o(221754);
        return localta;
      }
    }
    AppMethodBeat.o(221754);
    return null;
  }
  
  public final tx fyF()
  {
    AppMethodBeat.i(221765);
    tx localtx = new tx();
    localtx.Scn.addAll((Collection)this.IbD);
    localtx.Sdr = f(this.aHZ);
    localtx.Sdt = this.bgColor;
    localtx.Sds = this.textColor;
    localtx.IbE = this.IbE;
    AppMethodBeat.o(221765);
    return localtx;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221769);
    Iterator localIterator = this.IbD.iterator();
    while (localIterator.hasNext())
    {
      ta localta = (ta)localIterator.next();
      new StringBuilder().append("").append("start:").append(localta.Scf).append(" end:").append(localta.Scg).append(" text:").append(localta.Sce.toString("UTF-8")).append('\n');
    }
    AppMethodBeat.o(221769);
    return "";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.c
 * JD-Core Version:    0.7.0.1
 */