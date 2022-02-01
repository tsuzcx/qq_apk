package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.protocal.protobuf.ckm;
import com.tencent.mm.protocal.protobuf.erc;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLyricsInfo", "()Ljava/util/ArrayList;", "isValid", "", "limitLyrics", "", "duration", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class l
  extends a
{
  public static final l.a CfB;
  ArrayList<ckm> CfA;
  
  static
  {
    AppMethodBeat.i(237789);
    CfB = new l.a((byte)0);
    AppMethodBeat.o(237789);
  }
  
  public l(jn paramjn)
  {
    super(d.CeO);
    AppMethodBeat.i(237788);
    this.CfA = new ArrayList();
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new ckl();
      paramjn = paramjn.KOd;
      p.g(paramjn, "proto.itemData");
      paramjn = paramjn.getBuffer();
      p.g(paramjn, "proto.itemData.buffer");
      paramjn = paramjn.zy;
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramjn);
        paramjn = (jn)localObject;
      }
      catch (Exception paramjn)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramjn });
          paramjn = null;
        }
        AppMethodBeat.o(237788);
        return;
      }
      localObject = (ckl)paramjn;
      if (localObject != null)
      {
        this.CfA.clear();
        this.CfA.addAll((Collection)((ckl)localObject).MpX);
        paramjn = this.gT;
        localObject = ((ckl)localObject).Lce;
        p.g(localObject, "it.matrix");
        paramjn.setValues(a((erc)localObject));
        Log.i("MicroMsg.LyricsItem", toString());
        AppMethodBeat.o(237788);
        return;
      }
      return;
    }
    catch (IOException paramjn)
    {
      Log.printErrStackTrace("MicroMsg.LyricsItem", (Throwable)paramjn, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(237788);
    }
  }
  
  public l(List<? extends ckm> paramList, Matrix paramMatrix)
  {
    super(d.CeO);
    AppMethodBeat.i(237787);
    this.CfA = new ArrayList();
    this.CfA.clear();
    this.CfA.addAll((Collection)paramList);
    this.gT.set(paramMatrix);
    AppMethodBeat.o(237787);
  }
  
  public final void Ij(long paramLong)
  {
    AppMethodBeat.i(237785);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.CfA;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((ckm)localObject2).startTime < paramLong) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label98;
        }
        localCollection.add(localObject2);
        break;
      }
    }
    localArrayList.addAll((Collection)localCollection);
    this.CfA.clear();
    this.CfA.addAll((Collection)localArrayList);
    AppMethodBeat.o(237785);
  }
  
  public final com.tencent.mm.bw.a eMk()
  {
    AppMethodBeat.i(237784);
    Object localObject = new ckl();
    float[] arrayOfFloat = new float[9];
    erc localerc = new erc();
    this.gT.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localerc.LOe.add(Float.valueOf(f));
      i += 1;
    }
    ((ckl)localObject).MpX.addAll((Collection)this.CfA);
    ((ckl)localObject).Lce = localerc;
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(237784);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237786);
    String str = "[" + hashCode() + "]lyrics size:" + this.CfA.size();
    AppMethodBeat.o(237786);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.l
 * JD-Core Version:    0.7.0.1
 */