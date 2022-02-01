package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwt;
import com.tencent.mm.protocal.protobuf.bwu;
import com.tencent.mm.protocal.protobuf.dww;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLyricsInfo", "()Ljava/util/ArrayList;", "isValid", "", "limitLyrics", "", "duration", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class l
  extends a
{
  public static final l.a yez;
  ArrayList<bwu> yey;
  
  static
  {
    AppMethodBeat.i(206948);
    yez = new l.a((byte)0);
    AppMethodBeat.o(206948);
  }
  
  public l(ja paramja)
  {
    super(d.ydM);
    AppMethodBeat.i(206947);
    this.yey = new ArrayList();
    try
    {
      Object localObject = (com.tencent.mm.bw.a)new bwt();
      paramja = paramja.FUv;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bw.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
        AppMethodBeat.o(206947);
        return;
      }
      localObject = (bwt)paramja;
      if (localObject != null)
      {
        this.yey.clear();
        this.yey.addAll((Collection)((bwt)localObject).HjJ);
        paramja = this.gR;
        localObject = ((bwt)localObject).GhB;
        p.g(localObject, "it.matrix");
        paramja.setValues(a((dww)localObject));
        ae.i("MicroMsg.LyricsItem", toString());
        AppMethodBeat.o(206947);
        return;
      }
      return;
    }
    catch (IOException paramja)
    {
      ae.printErrStackTrace("MicroMsg.LyricsItem", (Throwable)paramja, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(206947);
    }
  }
  
  public l(List<? extends bwu> paramList, Matrix paramMatrix)
  {
    super(d.ydM);
    AppMethodBeat.i(206946);
    this.yey = new ArrayList();
    this.yey.clear();
    this.yey.addAll((Collection)paramList);
    this.gR.set(paramMatrix);
    AppMethodBeat.o(206946);
  }
  
  public final com.tencent.mm.bw.a dLk()
  {
    AppMethodBeat.i(206943);
    Object localObject = new bwt();
    float[] arrayOfFloat = new float[9];
    dww localdww = new dww();
    this.gR.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localdww.GKl.add(Float.valueOf(f));
      i += 1;
    }
    ((bwt)localObject).HjJ.addAll((Collection)this.yey);
    ((bwt)localObject).GhB = localdww;
    localObject = (com.tencent.mm.bw.a)localObject;
    AppMethodBeat.o(206943);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206945);
    String str = "[" + hashCode() + "]lyrics size:" + this.yey.size();
    AppMethodBeat.o(206945);
    return str;
  }
  
  public final void zl(long paramLong)
  {
    AppMethodBeat.i(206944);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.yey;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((bwu)localObject2).startTime < paramLong) {}
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
    this.yey.clear();
    this.yey.addAll((Collection)localArrayList);
    AppMethodBeat.o(206944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.l
 * JD-Core Version:    0.7.0.1
 */