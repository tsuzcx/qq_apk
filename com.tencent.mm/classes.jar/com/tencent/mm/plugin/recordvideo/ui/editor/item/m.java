package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fbn;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "musicDuration", "", "(Ljava/util/List;J)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLyricsInfo", "()Ljava/util/ArrayList;", "getMusicDuration", "()J", "isValid", "", "limitLyrics", "", "duration", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"})
public final class m
  extends a
{
  public static final a Icz;
  ArrayList<ctg> Icx;
  long Icy;
  
  static
  {
    AppMethodBeat.i(226759);
    Icz = new a((byte)0);
    AppMethodBeat.o(226759);
  }
  
  public m(jc paramjc)
  {
    super(d.IbK);
    AppMethodBeat.i(226758);
    this.Icx = new ArrayList();
    try
    {
      Object localObject = (com.tencent.mm.cd.a)new ctf();
      paramjc = paramjc.ROY;
      p.j(paramjc, "proto.itemData");
      paramjc = paramjc.Tkb;
      p.j(paramjc, "proto.itemData.buffer");
      paramjc = paramjc.UH;
      try
      {
        ((com.tencent.mm.cd.a)localObject).parseFrom(paramjc);
        paramjc = (jc)localObject;
      }
      catch (Exception paramjc)
      {
        for (;;)
        {
          fbn localfbn;
          Log.printDebugStack("safeParser", "", new Object[] { paramjc });
          paramjc = null;
        }
        AppMethodBeat.o(226758);
        return;
      }
      paramjc = (ctf)paramjc;
      if (paramjc != null)
      {
        this.Icx.clear();
        this.Icx.addAll((Collection)paramjc.TBb);
        localObject = this.aHZ;
        localfbn = paramjc.Sdr;
        p.j(localfbn, "it.matrix");
        ((Matrix)localObject).setValues(a(localfbn));
        this.Icy = paramjc.Icy;
        Log.i("MicroMsg.LyricsItem", toString());
        AppMethodBeat.o(226758);
        return;
      }
      return;
    }
    catch (IOException paramjc)
    {
      Log.printErrStackTrace("MicroMsg.LyricsItem", (Throwable)paramjc, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(226758);
    }
  }
  
  public m(List<? extends ctg> paramList, long paramLong)
  {
    this(paramList, new Matrix());
    AppMethodBeat.i(226753);
    this.Icy = paramLong;
    AppMethodBeat.o(226753);
  }
  
  public m(List<? extends ctg> paramList, Matrix paramMatrix)
  {
    super(d.IbK);
    AppMethodBeat.i(226751);
    this.Icx = new ArrayList();
    this.Icx.clear();
    this.Icx.addAll((Collection)paramList);
    this.aHZ.set(paramMatrix);
    AppMethodBeat.o(226751);
  }
  
  public final void PD(long paramLong)
  {
    AppMethodBeat.i(226740);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.Icx;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((ctg)localObject2).startTime < paramLong) {}
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
    this.Icx.clear();
    this.Icx.addAll((Collection)localArrayList);
    AppMethodBeat.o(226740);
  }
  
  public final com.tencent.mm.cd.a fyG()
  {
    AppMethodBeat.i(226734);
    Object localObject = new ctf();
    float[] arrayOfFloat = new float[9];
    fbn localfbn = new fbn();
    this.aHZ.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localfbn.SWx.add(Float.valueOf(f));
      i += 1;
    }
    ((ctf)localObject).TBb.addAll((Collection)this.Icx);
    ((ctf)localObject).Sdr = localfbn;
    ((ctf)localObject).Icy = this.Icy;
    localObject = (com.tencent.mm.cd.a)localObject;
    AppMethodBeat.o(226734);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226744);
    String str = "[" + hashCode() + "]lyrics size:" + this.Icx.size();
    AppMethodBeat.o(226744);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.m
 * JD-Core Version:    0.7.0.1
 */