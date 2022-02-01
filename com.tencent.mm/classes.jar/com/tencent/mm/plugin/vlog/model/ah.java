package com.tencent.mm.plugin.vlog.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.fyd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "", "respId", "", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "netMusicPath", "", "xEffectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "editItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "Lkotlin/collections/ArrayList;", "editData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "drawingRect", "", "validRect", "(JLjava/util/List;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/VlogResp;Ljava/util/ArrayList;Ljava/util/ArrayList;[F[F)V", "getDrawingRect", "()[F", "setDrawingRect", "([F)V", "getEditData", "()Ljava/util/ArrayList;", "setEditData", "(Ljava/util/ArrayList;)V", "getEditItems", "setEditItems", "fid", "", "getFid", "()I", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "getNetMusicPath", "()Ljava/lang/String;", "setNetMusicPath", "(Ljava/lang/String;)V", "getRespId", "()J", "setRespId", "(J)V", "sid", "getSid", "getValidRect", "setValidRect", "vid", "getVid", "getXEffectConfig", "()Lcom/tencent/mm/protocal/protobuf/VlogResp;", "setXEffectConfig", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "getVideoDurationMs", "hashCode", "isValid", "toString", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  public static final ah.a UaW;
  public float[] NEA;
  public float[] NEB;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> NGU;
  public ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> NGV;
  public long UaX;
  public List<? extends s> UaY;
  public String UaZ;
  public fyd Uba;
  
  static
  {
    AppMethodBeat.i(110947);
    UaW = new ah.a((byte)0);
    AppMethodBeat.o(110947);
  }
  
  private ah(long paramLong, List<? extends s> paramList, String paramString, fyd paramfyd, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList, ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> paramArrayList1, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110945);
    this.UaX = paramLong;
    this.UaY = paramList;
    this.UaZ = paramString;
    this.Uba = paramfyd;
    this.NGU = paramArrayList;
    this.NGV = paramArrayList1;
    this.NEA = paramArrayOfFloat;
    this.NEB = null;
    AppMethodBeat.o(110945);
  }
  
  public final void A(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(110944);
    kotlin.g.b.s.u(paramArrayOfFloat, "<set-?>");
    this.NEA = paramArrayOfFloat;
    AppMethodBeat.o(110944);
  }
  
  public final void bI(ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> paramArrayList)
  {
    AppMethodBeat.i(110943);
    kotlin.g.b.s.u(paramArrayList, "<set-?>");
    this.NGU = paramArrayList;
    AppMethodBeat.o(110943);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(110949);
    if (this == paramObject)
    {
      AppMethodBeat.o(110949);
      return true;
    }
    if (!(paramObject instanceof ah))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    paramObject = (ah)paramObject;
    if (this.UaX != paramObject.UaX)
    {
      AppMethodBeat.o(110949);
      return false;
    }
    if (!kotlin.g.b.s.p(this.UaY, paramObject.UaY))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    if (!kotlin.g.b.s.p(this.UaZ, paramObject.UaZ))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    if (!kotlin.g.b.s.p(this.Uba, paramObject.Uba))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    if (!kotlin.g.b.s.p(this.NGU, paramObject.NGU))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    if (!kotlin.g.b.s.p(this.NGV, paramObject.NGV))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    if (!kotlin.g.b.s.p(this.NEA, paramObject.NEA))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    if (!kotlin.g.b.s.p(this.NEB, paramObject.NEB))
    {
      AppMethodBeat.o(110949);
      return false;
    }
    AppMethodBeat.o(110949);
    return true;
  }
  
  public final int getVideoDurationMs()
  {
    AppMethodBeat.i(110941);
    long l = 0L;
    Iterator localIterator = ((Iterable)this.UaY).iterator();
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
  
  public final int hRj()
  {
    return (int)this.Uba.abVZ.aame;
  }
  
  public final int hRk()
  {
    return (int)this.Uba.abVZ.aamf;
  }
  
  public final int hRl()
  {
    return (int)this.Uba.abVZ.YSo;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(110948);
    int j = q.a..ExternalSyntheticBackport0.m(this.UaX);
    int k = this.UaY.hashCode();
    int m = this.UaZ.hashCode();
    int n = this.Uba.hashCode();
    int i1 = this.NGU.hashCode();
    int i2 = this.NGV.hashCode();
    int i3 = Arrays.hashCode(this.NEA);
    if (this.NEB == null) {}
    for (int i = 0;; i = Arrays.hashCode(this.NEB))
    {
      AppMethodBeat.o(110948);
      return i + ((((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110942);
    String str = "VLogScriptModel(respId=" + this.UaX + ", materials=" + this.UaY + ", netMusicPath='" + this.UaZ + "', xEffectConfig=" + this.Uba + ", editItems=" + this.NGU + ", editData=" + this.NGV + ", drawingRect=" + Arrays.toString(this.NEA) + ')';
    AppMethodBeat.o(110942);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ah
 * JD-Core Version:    0.7.0.1
 */