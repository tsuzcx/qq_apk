package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.a;
import com.tencent.mm.media.editor.a.b;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.dkv;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "", "respId", "", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "netMusicPath", "", "xEffectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "drawingRect", "", "(JLjava/util/List;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/VlogResp;Ljava/util/ArrayList;Ljava/util/ArrayList;[F)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "fid", "", "getFid", "()I", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "getNetMusicPath", "()Ljava/lang/String;", "setNetMusicPath", "(Ljava/lang/String;)V", "getRespId", "()J", "setRespId", "(J)V", "sid", "getSid", "vid", "getVid", "getXEffectConfig", "()Lcom/tencent/mm/protocal/protobuf/VlogResp;", "setXEffectConfig", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getVideoDurationMs", "hashCode", "isValid", "toString", "Companion", "plugin-vlog_release"})
public final class h
{
  public static final a yZw;
  public float[] vem;
  public ArrayList<b> vgI;
  public long yZr;
  public List<? extends d> yZs;
  public String yZt;
  public dkv yZu;
  public ArrayList<a> yZv;
  
  static
  {
    AppMethodBeat.i(110947);
    yZw = new a((byte)0);
    AppMethodBeat.o(110947);
  }
  
  private h(long paramLong, List<? extends d> paramList, String paramString, dkv paramdkv, ArrayList<b> paramArrayList, ArrayList<a> paramArrayList1, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110945);
    this.yZr = paramLong;
    this.yZs = paramList;
    this.yZt = paramString;
    this.yZu = paramdkv;
    this.vgI = paramArrayList;
    this.yZv = paramArrayList1;
    this.vem = paramArrayOfFloat;
    AppMethodBeat.o(110945);
  }
  
  public final void at(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(110943);
    k.h(paramArrayList, "<set-?>");
    this.vgI = paramArrayList;
    AppMethodBeat.o(110943);
  }
  
  public final int dQU()
  {
    return (int)this.yZu.EAA.Dpf;
  }
  
  public final int dQV()
  {
    return (int)this.yZu.EAA.Dpg;
  }
  
  public final int dQW()
  {
    return (int)this.yZu.EAA.CJo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110949);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((this.yZr != paramObject.yZr) || (!k.g(this.yZs, paramObject.yZs)) || (!k.g(this.yZt, paramObject.yZt)) || (!k.g(this.yZu, paramObject.yZu)) || (!k.g(this.vgI, paramObject.vgI)) || (!k.g(this.yZv, paramObject.yZv)) || (!k.g(this.vem, paramObject.vem))) {}
      }
    }
    else
    {
      AppMethodBeat.o(110949);
      return true;
    }
    AppMethodBeat.o(110949);
    return false;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(110941);
    long l = 0L;
    Iterator localIterator = ((Iterable)this.yZs).iterator();
    if (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.endTime <= l) {
        break label72;
      }
      l = locald.endTime;
    }
    label72:
    for (;;)
    {
      break;
      int i = (int)l;
      AppMethodBeat.o(110941);
      return i;
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(110948);
    long l = this.yZr;
    int i2 = (int)(l ^ l >>> 32);
    Object localObject = this.yZs;
    int i;
    int j;
    label59:
    int k;
    label76:
    int m;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.yZt;
      if (localObject == null) {
        break label176;
      }
      j = localObject.hashCode();
      localObject = this.yZu;
      if (localObject == null) {
        break label181;
      }
      k = localObject.hashCode();
      localObject = this.vgI;
      if (localObject == null) {
        break label186;
      }
      m = localObject.hashCode();
      label94:
      localObject = this.yZv;
      if (localObject == null) {
        break label192;
      }
    }
    label176:
    label181:
    label186:
    label192:
    for (int n = localObject.hashCode();; n = 0)
    {
      localObject = this.vem;
      if (localObject != null) {
        i1 = Arrays.hashCode((float[])localObject);
      }
      AppMethodBeat.o(110948);
      return (n + (m + (k + (j + (i + i2 * 31) * 31) * 31) * 31) * 31) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label59;
      k = 0;
      break label76;
      m = 0;
      break label94;
    }
  }
  
  public final void p(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110944);
    k.h(paramArrayOfFloat, "<set-?>");
    this.vem = paramArrayOfFloat;
    AppMethodBeat.o(110944);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110942);
    String str = "VLogScriptModel(respId=" + this.yZr + ", materials=" + this.yZs + ", netMusicPath='" + this.yZt + "', xEffectConfig=" + this.yZu + ", editItems=" + this.vgI + ", editData=" + this.yZv + ", drawingRect=" + Arrays.toString(this.vem) + ')';
    AppMethodBeat.o(110942);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel$Companion;", "", "()V", "default", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.h
 * JD-Core Version:    0.7.0.1
 */