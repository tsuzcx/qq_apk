package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLyricsInfo", "()Ljava/util/ArrayList;", "isValid", "", "limitLyrics", "", "duration", "", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class l
  extends a
{
  public static final l.a xOG;
  ArrayList<bwa> xOF;
  
  static
  {
    AppMethodBeat.i(200690);
    xOG = new l.a((byte)0);
    AppMethodBeat.o(200690);
  }
  
  public l(ja paramja)
  {
    super(d.xNT);
    AppMethodBeat.i(200689);
    this.xOF = new ArrayList();
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new bvz();
      paramja = paramja.FCa;
      p.g(paramja, "proto.itemData");
      paramja = paramja.getBuffer();
      p.g(paramja, "proto.itemData.buffer");
      paramja = paramja.getBytes();
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramja);
        paramja = (ja)localObject;
      }
      catch (Exception paramja)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { paramja });
          paramja = null;
        }
        AppMethodBeat.o(200689);
        return;
      }
      localObject = (bvz)paramja;
      if (localObject != null)
      {
        this.xOF.clear();
        this.xOF.addAll((Collection)((bvz)localObject).GQi);
        paramja = this.gR;
        localObject = ((bvz)localObject).FPc;
        p.g(localObject, "it.matrix");
        paramja.setValues(a((dwb)localObject));
        ad.i("MicroMsg.LyricsItem", toString());
        AppMethodBeat.o(200689);
        return;
      }
      return;
    }
    catch (IOException paramja)
    {
      ad.printErrStackTrace("MicroMsg.LyricsItem", (Throwable)paramja, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(200689);
    }
  }
  
  public l(List<? extends bwa> paramList, Matrix paramMatrix)
  {
    super(d.xNT);
    AppMethodBeat.i(200688);
    this.xOF = new ArrayList();
    this.xOF.clear();
    this.xOF.addAll((Collection)paramList);
    this.gR.set(paramMatrix);
    AppMethodBeat.o(200688);
  }
  
  public final com.tencent.mm.bx.a dHT()
  {
    AppMethodBeat.i(200685);
    Object localObject = new bvz();
    float[] arrayOfFloat = new float[9];
    dwb localdwb = new dwb();
    this.gR.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localdwb.GqN.add(Float.valueOf(f));
      i += 1;
    }
    ((bvz)localObject).GQi.addAll((Collection)this.xOF);
    ((bvz)localObject).FPc = localdwb;
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(200685);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(200687);
    String str = "[" + hashCode() + "]lyrics size:" + this.xOF.size();
    AppMethodBeat.o(200687);
    return str;
  }
  
  public final void yN(long paramLong)
  {
    AppMethodBeat.i(200686);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.xOF;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((bwa)localObject2).startTime < paramLong) {}
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
    this.xOF.clear();
    this.xOF.addAll((Collection)localArrayList);
    AppMethodBeat.o(200686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.l
 * JD-Core Version:    0.7.0.1
 */