package com.tencent.mm.plugin.vlog.model;

import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.protocal.protobuf.dtr;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/Material;", "", "scaleType", "Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "filter", "Lcom/tencent/mm/plugin/vlog/model/Filter;", "transition", "Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "startTime", "", "endTime", "duration", "path", "", "keyTrace", "", "Lcom/tencent/mm/protocal/protobuf/WindowMeta;", "transitionParams", "Lcom/tencent/mm/protocal/protobuf/TransitionParam;", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;Lcom/tencent/mm/plugin/vlog/model/Filter;Lcom/tencent/mm/plugin/vlog/model/TransitionType;JJJLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEndTime", "setEndTime", "getFilter", "()Lcom/tencent/mm/plugin/vlog/model/Filter;", "setFilter", "(Lcom/tencent/mm/plugin/vlog/model/Filter;)V", "getKeyTrace", "()Ljava/util/List;", "setKeyTrace", "(Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScaleType", "()Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "setScaleType", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;)V", "getStartTime", "setStartTime", "getTransition", "()Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "setTransition", "(Lcom/tencent/mm/plugin/vlog/model/TransitionType;)V", "getTransitionParams", "setTransitionParams", "plugin-vlog_release"})
public abstract class d
{
  private long duration;
  public long endTime;
  public String path;
  public long startTime;
  private e yZc;
  private a yZd;
  private f yZe;
  List<? extends dtr> yZf;
  List<? extends dep> yZg;
  
  private d(e parame, a parama, f paramf, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.yZc = parame;
    this.yZd = parama;
    this.yZe = paramf;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.duration = paramLong3;
    this.path = paramString;
    this.yZf = null;
    this.yZg = null;
  }
  
  public final void a(e parame)
  {
    k.h(parame, "<set-?>");
    this.yZc = parame;
  }
  
  public final void a(f paramf)
  {
    k.h(paramf, "<set-?>");
    this.yZe = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.d
 * JD-Core Version:    0.7.0.1
 */