package com.tencent.mm.plugin.vlog.model;

import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.dzi;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/Material;", "", "scaleType", "Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "filter", "Lcom/tencent/mm/plugin/vlog/model/Filter;", "transition", "Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "startTime", "", "endTime", "duration", "path", "", "keyTrace", "", "Lcom/tencent/mm/protocal/protobuf/WindowMeta;", "transitionParams", "Lcom/tencent/mm/protocal/protobuf/TransitionParam;", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;Lcom/tencent/mm/plugin/vlog/model/Filter;Lcom/tencent/mm/plugin/vlog/model/TransitionType;JJJLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEndTime", "setEndTime", "getFilter", "()Lcom/tencent/mm/plugin/vlog/model/Filter;", "setFilter", "(Lcom/tencent/mm/plugin/vlog/model/Filter;)V", "getKeyTrace", "()Ljava/util/List;", "setKeyTrace", "(Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScaleType", "()Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "setScaleType", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;)V", "getStartTime", "setStartTime", "getTransition", "()Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "setTransition", "(Lcom/tencent/mm/plugin/vlog/model/TransitionType;)V", "getTransitionParams", "setTransitionParams", "plugin-vlog_release"})
public abstract class i
{
  private m AmY;
  private e AmZ;
  private q Ana;
  List<? extends dzi> Anb;
  List<? extends dke> Anc;
  private long duration;
  public long endTime;
  public String path;
  public long startTime;
  
  private i(m paramm, e parame, q paramq, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.AmY = paramm;
    this.AmZ = parame;
    this.Ana = paramq;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.duration = paramLong3;
    this.path = paramString;
    this.Anb = null;
    this.Anc = null;
  }
  
  public final void a(m paramm)
  {
    k.h(paramm, "<set-?>");
    this.AmY = paramm;
  }
  
  public final void a(q paramq)
  {
    k.h(paramq, "<set-?>");
    this.Ana = paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.i
 * JD-Core Version:    0.7.0.1
 */