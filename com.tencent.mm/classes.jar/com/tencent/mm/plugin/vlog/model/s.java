package com.tencent.mm.plugin.vlog.model;

import com.tencent.mm.protocal.protobuf.eko;
import com.tencent.mm.protocal.protobuf.fbr;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/Material;", "", "scaleType", "Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "filter", "Lcom/tencent/mm/plugin/vlog/model/Filter;", "transition", "Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "startTime", "", "endTime", "duration", "path", "", "keyTrace", "", "Lcom/tencent/mm/protocal/protobuf/WindowMeta;", "transitionParams", "Lcom/tencent/mm/protocal/protobuf/TransitionParam;", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;Lcom/tencent/mm/plugin/vlog/model/Filter;Lcom/tencent/mm/plugin/vlog/model/TransitionType;JJJLjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getDuration", "()J", "setDuration", "(J)V", "getEndTime", "setEndTime", "getFilter", "()Lcom/tencent/mm/plugin/vlog/model/Filter;", "setFilter", "(Lcom/tencent/mm/plugin/vlog/model/Filter;)V", "getKeyTrace", "()Ljava/util/List;", "setKeyTrace", "(Ljava/util/List;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getScaleType", "()Lcom/tencent/mm/plugin/vlog/model/ScaleType;", "setScaleType", "(Lcom/tencent/mm/plugin/vlog/model/ScaleType;)V", "getStartTime", "setStartTime", "getTransition", "()Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "setTransition", "(Lcom/tencent/mm/plugin/vlog/model/TransitionType;)V", "getTransitionParams", "setTransitionParams", "plugin-vlog_release"})
public abstract class s
{
  private y Gyq;
  private l Gyr;
  private ab Gys;
  List<? extends fbr> Gyt;
  List<? extends eko> Gyu;
  private long duration;
  public long endTime;
  public String path;
  public long startTime;
  
  private s(y paramy, l paraml, ab paramab, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    this.Gyq = paramy;
    this.Gyr = paraml;
    this.Gys = paramab;
    this.startTime = paramLong1;
    this.endTime = paramLong2;
    this.duration = paramLong3;
    this.path = paramString;
    this.Gyt = null;
    this.Gyu = null;
  }
  
  public final void a(ab paramab)
  {
    p.h(paramab, "<set-?>");
    this.Gys = paramab;
  }
  
  public final void a(y paramy)
  {
    p.h(paramy, "<set-?>");
    this.Gyq = paramy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.s
 * JD-Core Version:    0.7.0.1
 */