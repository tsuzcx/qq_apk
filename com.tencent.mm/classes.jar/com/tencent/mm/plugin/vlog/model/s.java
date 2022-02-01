package com.tencent.mm.plugin.vlog.model;

import com.tencent.mm.protocal.protobuf.fqg;
import com.tencent.mm.protocal.protobuf.gjc;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/Material;", "", "scaleType", "Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "filter", "Lcom/tencent/mm/plugin/vlog/model/Filter;", "transition", "Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "startTime", "", "endTime", "duration", "path", "", "keyTrace", "", "Lcom/tencent/mm/protocal/protobuf/WindowMeta;", "transitionParams", "Lcom/tencent/mm/protocal/protobuf/TransitionParam;", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;Lcom/tencent/mm/plugin/vlog/model/Filter;Lcom/tencent/mm/plugin/vlog/model/TransitionType;JJJLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEndTime", "setEndTime", "getFilter", "()Lcom/tencent/mm/plugin/vlog/model/Filter;", "setFilter", "(Lcom/tencent/mm/plugin/vlog/model/Filter;)V", "getKeyTrace", "()Ljava/util/List;", "setKeyTrace", "(Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScaleType", "()Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "setScaleType", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;)V", "getStartTime", "setStartTime", "getTransition", "()Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "setTransition", "(Lcom/tencent/mm/plugin/vlog/model/TransitionType;)V", "getTransitionParams", "setTransitionParams", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class s
{
  private aa TZA;
  List<? extends gjc> TZB;
  List<? extends fqg> TZC;
  private y TZy;
  private l TZz;
  private long duration;
  public long endTime;
  public String path;
  public long startTime;
  
  private s(y paramy, l paraml, aa paramaa, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.TZy = paramy;
    this.TZz = paraml;
    this.TZA = paramaa;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.duration = paramLong3;
    this.path = paramString;
    this.TZB = null;
    this.TZC = null;
  }
  
  public final void a(aa paramaa)
  {
    kotlin.g.b.s.u(paramaa, "<set-?>");
    this.TZA = paramaa;
  }
  
  public final void a(y paramy)
  {
    kotlin.g.b.s.u(paramy, "<set-?>");
    this.TZy = paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.s
 * JD-Core Version:    0.7.0.1
 */