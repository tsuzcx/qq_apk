package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.editor.a.a;
import com.tencent.mm.media.editor.a.b;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.dqm;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "", "respId", "", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "netMusicPath", "", "xEffectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/editor/item/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/media/editor/item/BaseEditorData;", "drawingRect", "", "(JLjava/util/List;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/VlogResp;Ljava/util/ArrayList;Ljava/util/ArrayList;[F)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "fid", "", "getFid", "()I", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "getNetMusicPath", "()Ljava/lang/String;", "setNetMusicPath", "(Ljava/lang/String;)V", "getRespId", "()J", "setRespId", "(J)V", "sid", "getSid", "vid", "getVid", "getXEffectConfig", "()Lcom/tencent/mm/protocal/protobuf/VlogResp;", "setXEffectConfig", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getVideoDurationMs", "hashCode", "isValid", "toString", "Companion", "plugin-vlog_release"})
public final class y
{
  public static final a AoZ;
  public long AoU;
  public List<? extends i> AoV;
  public String AoW;
  public dqm AoX;
  public ArrayList<a> AoY;
  public float[] wnb;
  public ArrayList<b> wpu;
  
  static
  {
    AppMethodBeat.i(110947);
    AoZ = new a((byte)0);
    AppMethodBeat.o(110947);
  }
  
  private y(long paramLong, List<? extends i> paramList, String paramString, dqm paramdqm, ArrayList<b> paramArrayList, ArrayList<a> paramArrayList1, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110945);
    this.AoU = paramLong;
    this.AoV = paramList;
    this.AoW = paramString;
    this.AoX = paramdqm;
    this.wpu = paramArrayList;
    this.AoY = paramArrayList1;
    this.wnb = paramArrayOfFloat;
    AppMethodBeat.o(110945);
  }
  
  public final void aF(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(110943);
    k.h(paramArrayList, "<set-?>");
    this.wpu = paramArrayList;
    AppMethodBeat.o(110943);
  }
  
  public final int efM()
  {
    return (int)this.AoX.FXO.EKf;
  }
  
  public final int efN()
  {
    return (int)this.AoX.FXO.EKg;
  }
  
  public final int efO()
  {
    return (int)this.AoX.FXO.EbQ;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110949);
    if (this != paramObject)
    {
      if ((paramObject instanceof y))
      {
        paramObject = (y)paramObject;
        if ((this.AoU != paramObject.AoU) || (!k.g(this.AoV, paramObject.AoV)) || (!k.g(this.AoW, paramObject.AoW)) || (!k.g(this.AoX, paramObject.AoX)) || (!k.g(this.wpu, paramObject.wpu)) || (!k.g(this.AoY, paramObject.AoY)) || (!k.g(this.wnb, paramObject.wnb))) {}
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
    Iterator localIterator = ((Iterable)this.AoV).iterator();
    if (localIterator.hasNext())
    {
      i locali = (i)localIterator.next();
      if (locali.endTime <= l) {
        break label72;
      }
      l = locali.endTime;
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
    long l = this.AoU;
    int i2 = (int)(l ^ l >>> 32);
    Object localObject = this.AoV;
    int i;
    int j;
    label59:
    int k;
    label76:
    int m;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.AoW;
      if (localObject == null) {
        break label176;
      }
      j = localObject.hashCode();
      localObject = this.AoX;
      if (localObject == null) {
        break label181;
      }
      k = localObject.hashCode();
      localObject = this.wpu;
      if (localObject == null) {
        break label186;
      }
      m = localObject.hashCode();
      label94:
      localObject = this.AoY;
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
      localObject = this.wnb;
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
    this.wnb = paramArrayOfFloat;
    AppMethodBeat.o(110944);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110942);
    String str = "VLogScriptModel(respId=" + this.AoU + ", materials=" + this.AoV + ", netMusicPath='" + this.AoW + "', xEffectConfig=" + this.AoX + ", editItems=" + this.wpu + ", editData=" + this.AoY + ", drawingRect=" + Arrays.toString(this.wnb) + ')';
    AppMethodBeat.o(110942);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel$Companion;", "", "()V", "default", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.y
 * JD-Core Version:    0.7.0.1
 */