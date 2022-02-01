package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.fxy;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "matrix", "Landroid/graphics/Matrix;", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;Ljava/util/ArrayList;Landroid/graphics/Matrix;)V", "byteArray", "", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;[B)V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "captionList", "getCaptionList", "()Ljava/util/ArrayList;", "setCaptionList", "(Ljava/util/ArrayList;)V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "textColor", "getTextColor", "setTextColor", "getCurrentTransResult", "timeMs", "", "getShowCaptionAtTime", "isValid", "", "toProtoBuf", "Lcom/tencent/mm/protocal/protobuf/CaptionItemData;", "toString", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final c.a NYb;
  public ArrayList<uq> NYc;
  public int bgColor;
  public String mAD;
  public int textColor;
  
  static
  {
    AppMethodBeat.i(280359);
    NYb = new c.a((byte)0);
    AppMethodBeat.o(280359);
  }
  
  public c(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(280335);
    this.NYc = new ArrayList();
    AppMethodBeat.o(280335);
  }
  
  public c(d paramd, ArrayList<uq> paramArrayList, Matrix paramMatrix)
  {
    super(paramd);
    AppMethodBeat.i(280345);
    this.NYc = new ArrayList();
    this.NYc.clear();
    this.NYc.addAll((Collection)paramArrayList);
    this.matrix.set(paramMatrix);
    AppMethodBeat.o(280345);
  }
  
  public c(d paramd, byte[] paramArrayOfByte)
  {
    super(paramd);
    AppMethodBeat.i(280354);
    this.NYc = new ArrayList();
    try
    {
      paramd = (com.tencent.mm.bx.a)new vo();
      try
      {
        paramd.parseFrom(paramArrayOfByte);
        paramd = (vo)paramd;
        if (paramd != null)
        {
          this.NYc.clear();
          this.NYc.addAll((Collection)paramd.Zaf);
          paramArrayOfByte = this.matrix;
          fxy localfxy = paramd.Zbl;
          s.s(localfxy, "captionData.matrix");
          paramArrayOfByte.setValues(a(localfxy));
          this.bgColor = paramd.Zbn;
          this.textColor = paramd.Zbm;
          this.mAD = paramd.mAD;
          Log.i("MicroMsg.CaptionItem", toString());
          AppMethodBeat.o(280354);
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
      }
      return;
    }
    catch (IOException paramd)
    {
      Log.printErrStackTrace("MicroMsg.CaptionItem", (Throwable)paramd, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(280354);
    }
  }
  
  public final vo gKr()
  {
    AppMethodBeat.i(280369);
    vo localvo = new vo();
    localvo.Zaf.addAll((Collection)this.NYc);
    localvo.Zbl = h(this.matrix);
    localvo.Zbn = this.bgColor;
    localvo.Zbm = this.textColor;
    localvo.mAD = this.mAD;
    AppMethodBeat.o(280369);
    return localvo;
  }
  
  public final uq tB(long paramLong)
  {
    AppMethodBeat.i(280364);
    Iterator localIterator = ((Iterable)this.NYc).iterator();
    while (localIterator.hasNext())
    {
      uq localuq = (uq)localIterator.next();
      if ((localuq.YZX <= paramLong) && (localuq.YZY >= paramLong))
      {
        AppMethodBeat.o(280364);
        return localuq;
      }
    }
    AppMethodBeat.o(280364);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280380);
    Iterator localIterator = this.NYc.iterator();
    while (localIterator.hasNext())
    {
      uq localuq = (uq)localIterator.next();
      new StringBuilder().append("").append("start:").append(localuq.YZX).append(" end:").append(localuq.YZY).append(" text:").append(localuq.YZW.toString("UTF-8")).append('\n');
    }
    AppMethodBeat.o(280380);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.c
 * JD-Core Version:    0.7.0.1
 */