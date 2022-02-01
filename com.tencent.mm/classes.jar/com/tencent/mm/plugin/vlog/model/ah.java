package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.erh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "", "respId", "", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "netMusicPath", "", "xEffectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "drawingRect", "", "validRect", "(JLjava/util/List;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/VlogResp;Ljava/util/ArrayList;Ljava/util/ArrayList;[F[F)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "fid", "", "getFid", "()I", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "getNetMusicPath", "()Ljava/lang/String;", "setNetMusicPath", "(Ljava/lang/String;)V", "getRespId", "()J", "setRespId", "(J)V", "sid", "getSid", "getValidRect", "setValidRect", "vid", "getVid", "getXEffectConfig", "()Lcom/tencent/mm/protocal/protobuf/VlogResp;", "setXEffectConfig", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "getVideoDurationMs", "hashCode", "isValid", "toString", "Companion", "plugin-vlog_release"})
public final class ah
{
  public static final ah.a GzT;
  public float[] BKV;
  public float[] BKW;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> BNn;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> BNo;
  public long GzP;
  public List<? extends s> GzQ;
  public String GzR;
  public erh GzS;
  
  static
  {
    AppMethodBeat.i(110947);
    GzT = new ah.a((byte)0);
    AppMethodBeat.o(110947);
  }
  
  private ah(long paramLong, List<? extends s> paramList, String paramString, erh paramerh, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramArrayList1, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110945);
    this.GzP = paramLong;
    this.GzQ = paramList;
    this.GzR = paramString;
    this.GzS = paramerh;
    this.BNn = paramArrayList;
    this.BNo = paramArrayList1;
    this.BKV = paramArrayOfFloat;
    this.BKW = null;
    AppMethodBeat.o(110945);
  }
  
  public final void aT(ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList)
  {
    AppMethodBeat.i(110943);
    p.h(paramArrayList, "<set-?>");
    this.BNn = paramArrayList;
    AppMethodBeat.o(110943);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110949);
    if (this != paramObject)
    {
      if ((paramObject instanceof ah))
      {
        paramObject = (ah)paramObject;
        if ((this.GzP != paramObject.GzP) || (!p.j(this.GzQ, paramObject.GzQ)) || (!p.j(this.GzR, paramObject.GzR)) || (!p.j(this.GzS, paramObject.GzS)) || (!p.j(this.BNn, paramObject.BNn)) || (!p.j(this.BNo, paramObject.BNo)) || (!p.j(this.BKV, paramObject.BKV)) || (!p.j(this.BKW, paramObject.BKW))) {}
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
  
  public final int fBJ()
  {
    return (int)this.GzS.NoU.LQL;
  }
  
  public final int fBK()
  {
    return (int)this.GzS.NoU.LQM;
  }
  
  public final int fBL()
  {
    return (int)this.GzS.NoU.KTS;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(110941);
    long l = 0L;
    Iterator localIterator = ((Iterable)this.GzQ).iterator();
    if (localIterator.hasNext())
    {
      s locals = (s)localIterator.next();
      if (locals.endTime <= l) {
        break label72;
      }
      l = locals.endTime;
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
    int i2 = 0;
    AppMethodBeat.i(110948);
    long l = this.GzP;
    int i3 = (int)(l ^ l >>> 32);
    Object localObject = this.GzQ;
    int i;
    int j;
    label59:
    int k;
    label76:
    int m;
    label94:
    int n;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.GzR;
      if (localObject == null) {
        break label200;
      }
      j = localObject.hashCode();
      localObject = this.GzS;
      if (localObject == null) {
        break label205;
      }
      k = localObject.hashCode();
      localObject = this.BNn;
      if (localObject == null) {
        break label210;
      }
      m = localObject.hashCode();
      localObject = this.BNo;
      if (localObject == null) {
        break label216;
      }
      n = localObject.hashCode();
      label112:
      localObject = this.BKV;
      if (localObject == null) {
        break label222;
      }
    }
    label200:
    label205:
    label210:
    label216:
    label222:
    for (int i1 = Arrays.hashCode((float[])localObject);; i1 = 0)
    {
      localObject = this.BKW;
      if (localObject != null) {
        i2 = Arrays.hashCode((float[])localObject);
      }
      AppMethodBeat.o(110948);
      return (i1 + (n + (m + (k + (j + (i + i3 * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label59;
      k = 0;
      break label76;
      m = 0;
      break label94;
      n = 0;
      break label112;
    }
  }
  
  public final void p(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110944);
    p.h(paramArrayOfFloat, "<set-?>");
    this.BKV = paramArrayOfFloat;
    AppMethodBeat.o(110944);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110942);
    String str = "VLogScriptModel(respId=" + this.GzP + ", materials=" + this.GzQ + ", netMusicPath='" + this.GzR + "', xEffectConfig=" + this.GzS + ", editItems=" + this.BNn + ", editData=" + this.BNo + ", drawingRect=" + Arrays.toString(this.BKV) + ')';
    AppMethodBeat.o(110942);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ah
 * JD-Core Version:    0.7.0.1
 */