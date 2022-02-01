package com.tencent.mm.plugin.recordvideo.ui.editor.item;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.fxy;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/LyricsItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "lyricsInfo", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "matrix", "Landroid/graphics/Matrix;", "(Ljava/util/List;Landroid/graphics/Matrix;)V", "musicDuration", "", "(Ljava/util/List;J)V", "proto", "Lcom/tencent/mm/protocal/protobuf/BaseItemData;", "(Lcom/tencent/mm/protocal/protobuf/BaseItemData;)V", "<set-?>", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLyricsInfo", "()Ljava/util/ArrayList;", "getMusicDuration", "()J", "isValid", "", "limitLyrics", "", "duration", "toProtoBuf", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "toString", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends a
{
  public static final m.a NYT;
  ArrayList<dki> NYU;
  long NYV;
  
  static
  {
    AppMethodBeat.i(280303);
    NYT = new m.a((byte)0);
    AppMethodBeat.o(280303);
  }
  
  public m(jy paramjy)
  {
    super(d.NYh);
    AppMethodBeat.i(280294);
    this.NYU = new ArrayList();
    try
    {
      Object localObject = (com.tencent.mm.bx.a)new dkh();
      paramjy = paramjy.YMl.aaxD.Op;
      try
      {
        ((com.tencent.mm.bx.a)localObject).parseFrom(paramjy);
        paramjy = (jy)localObject;
      }
      catch (Exception paramjy)
      {
        for (;;)
        {
          fxy localfxy;
          Log.printDebugStack("safeParser", "", new Object[] { paramjy });
          paramjy = null;
        }
      }
      paramjy = (dkh)paramjy;
      if (paramjy != null)
      {
        this.NYU.clear();
        this.NYU.addAll((Collection)paramjy.aaQp);
        localObject = this.matrix;
        localfxy = paramjy.Zbl;
        s.s(localfxy, "it.matrix");
        ((Matrix)localObject).setValues(a(localfxy));
        this.NYV = paramjy.NYV;
        Log.i("MicroMsg.LyricsItem", toString());
        AppMethodBeat.o(280294);
        return;
      }
    }
    catch (IOException paramjy)
    {
      Log.printErrStackTrace("MicroMsg.LyricsItem", (Throwable)paramjy, "LocationItem parse error", new Object[0]);
      AppMethodBeat.o(280294);
    }
  }
  
  public m(List<? extends dki> paramList, long paramLong)
  {
    this(paramList, new Matrix());
    AppMethodBeat.i(280287);
    this.NYV = paramLong;
    AppMethodBeat.o(280287);
  }
  
  public m(List<? extends dki> paramList, Matrix paramMatrix)
  {
    super(d.NYh);
    AppMethodBeat.i(280282);
    this.NYU = new ArrayList();
    this.NYU.clear();
    this.NYU.addAll((Collection)paramList);
    this.matrix.set(paramMatrix);
    AppMethodBeat.o(280282);
  }
  
  public final com.tencent.mm.bx.a gKs()
  {
    AppMethodBeat.i(280310);
    Object localObject = new dkh();
    float[] arrayOfFloat = new float[9];
    fxy localfxy = new fxy();
    this.matrix.getValues(arrayOfFloat);
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      localfxy.aaib.add(Float.valueOf(f));
      i += 1;
    }
    ((dkh)localObject).aaQp.addAll((Collection)this.NYU);
    ((dkh)localObject).Zbl = localfxy;
    ((dkh)localObject).NYV = this.NYV;
    localObject = (com.tencent.mm.bx.a)localObject;
    AppMethodBeat.o(280310);
    return localObject;
  }
  
  public final void tD(long paramLong)
  {
    AppMethodBeat.i(280319);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (Iterable)this.NYU;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label98:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((dki)localObject2).startTime < paramLong) {}
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
    this.NYU.clear();
    this.NYU.addAll((Collection)localArrayList);
    AppMethodBeat.o(280319);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(280327);
    String str = "[" + hashCode() + "]lyrics size:" + this.NYU.size();
    AppMethodBeat.o(280327);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.m
 * JD-Core Version:    0.7.0.1
 */