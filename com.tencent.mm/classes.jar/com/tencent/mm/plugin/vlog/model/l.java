package com.tencent.mm.plugin.vlog.model;

import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.ehb;
import d.g.b.p;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/Material;", "", "scaleType", "Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "filter", "Lcom/tencent/mm/plugin/vlog/model/Filter;", "transition", "Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "startTime", "", "endTime", "duration", "path", "", "keyTrace", "", "Lcom/tencent/mm/protocal/protobuf/WindowMeta;", "transitionParams", "Lcom/tencent/mm/protocal/protobuf/TransitionParam;", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;Lcom/tencent/mm/plugin/vlog/model/Filter;Lcom/tencent/mm/plugin/vlog/model/TransitionType;JJJLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEndTime", "setEndTime", "getFilter", "()Lcom/tencent/mm/plugin/vlog/model/Filter;", "setFilter", "(Lcom/tencent/mm/plugin/vlog/model/Filter;)V", "getKeyTrace", "()Ljava/util/List;", "setKeyTrace", "(Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScaleType", "()Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "setScaleType", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;)V", "getStartTime", "setStartTime", "getTransition", "()Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "setTransition", "(Lcom/tencent/mm/plugin/vlog/model/TransitionType;)V", "getTransitionParams", "setTransitionParams", "plugin-vlog_release"})
public abstract class l
{
  private r BWJ;
  private h BWK;
  private u BWL;
  List<? extends ehb> BWM;
  List<? extends dqs> BWN;
  private long duration;
  public long endTime;
  public String path;
  public long startTime;
  
  private l(r paramr, h paramh, u paramu, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.BWJ = paramr;
    this.BWK = paramh;
    this.BWL = paramu;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.duration = paramLong3;
    this.path = paramString;
    this.BWM = null;
    this.BWN = null;
  }
  
  public final void a(r paramr)
  {
    p.h(paramr, "<set-?>");
    this.BWJ = paramr;
  }
  
  public final void a(u paramu)
  {
    p.h(paramu, "<set-?>");
    this.BWL = paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.l
 * JD-Core Version:    0.7.0.1
 */