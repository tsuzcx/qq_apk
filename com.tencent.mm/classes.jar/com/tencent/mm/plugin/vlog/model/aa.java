package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.dxb;
import d.g.b.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "", "respId", "", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "netMusicPath", "", "xEffectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "drawingRect", "", "validRect", "(JLjava/util/List;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/VlogResp;Ljava/util/ArrayList;Ljava/util/ArrayList;[F[F)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "fid", "", "getFid", "()I", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "getNetMusicPath", "()Ljava/lang/String;", "setNetMusicPath", "(Ljava/lang/String;)V", "getRespId", "()J", "setRespId", "(J)V", "sid", "getSid", "getValidRect", "setValidRect", "vid", "getVid", "getXEffectConfig", "()Lcom/tencent/mm/protocal/protobuf/VlogResp;", "setXEffectConfig", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "getVideoDurationMs", "hashCode", "isValid", "toString", "Companion", "plugin-vlog_release"})
public final class aa
{
  public static final aa.a BYo;
  public long BYk;
  public List<? extends l> BYl;
  public String BYm;
  public dxb BYn;
  public float[] xKR;
  public float[] xKS;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> xNh;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> xNi;
  
  static
  {
    AppMethodBeat.i(110947);
    BYo = new aa.a((byte)0);
    AppMethodBeat.o(110947);
  }
  
  private aa(long paramLong, List<? extends l> paramList, String paramString, dxb paramdxb, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramArrayList1, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110945);
    this.BYk = paramLong;
    this.BYl = paramList;
    this.BYm = paramString;
    this.BYn = paramdxb;
    this.xNh = paramArrayList;
    this.xNi = paramArrayList1;
    this.xKR = paramArrayOfFloat;
    this.xKS = null;
    AppMethodBeat.o(110945);
  }
  
  public final void aC(ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList)
  {
    AppMethodBeat.i(110943);
    p.h(paramArrayList, "<set-?>");
    this.xNh = paramArrayList;
    AppMethodBeat.o(110943);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110949);
    if (this != paramObject)
    {
      if ((paramObject instanceof aa))
      {
        paramObject = (aa)paramObject;
        if ((this.BYk != paramObject.BYk) || (!p.i(this.BYl, paramObject.BYl)) || (!p.i(this.BYm, paramObject.BYm)) || (!p.i(this.BYn, paramObject.BYn)) || (!p.i(this.xNh, paramObject.xNh)) || (!p.i(this.xNi, paramObject.xNi)) || (!p.i(this.xKR, paramObject.xKR)) || (!p.i(this.xKS, paramObject.xKS))) {}
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
  
  public final int evW()
  {
    return (int)this.BYn.Icw.GMF;
  }
  
  public final int evX()
  {
    return (int)this.BYn.Icw.GMG;
  }
  
  public final int evY()
  {
    return (int)this.BYn.Icw.FZY;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(110941);
    long l = 0L;
    Iterator localIterator = ((Iterable)this.BYl).iterator();
    if (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.endTime <= l) {
        break label72;
      }
      l = locall.endTime;
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
    long l = this.BYk;
    int i3 = (int)(l ^ l >>> 32);
    Object localObject = this.BYl;
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
      localObject = this.BYm;
      if (localObject == null) {
        break label200;
      }
      j = localObject.hashCode();
      localObject = this.BYn;
      if (localObject == null) {
        break label205;
      }
      k = localObject.hashCode();
      localObject = this.xNh;
      if (localObject == null) {
        break label210;
      }
      m = localObject.hashCode();
      localObject = this.xNi;
      if (localObject == null) {
        break label216;
      }
      n = localObject.hashCode();
      label112:
      localObject = this.xKR;
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
      localObject = this.xKS;
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
    this.xKR = paramArrayOfFloat;
    AppMethodBeat.o(110944);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110942);
    String str = "VLogScriptModel(respId=" + this.BYk + ", materials=" + this.BYl + ", netMusicPath='" + this.BYm + "', xEffectConfig=" + this.BYn + ", editItems=" + this.xNh + ", editData=" + this.xNi + ", drawingRect=" + Arrays.toString(this.xKR) + ')';
    AppMethodBeat.o(110942);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.aa
 * JD-Core Version:    0.7.0.1
 */