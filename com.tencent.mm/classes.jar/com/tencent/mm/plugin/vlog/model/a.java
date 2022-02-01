package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "retryCount", "", "getRetryCount", "()I", "setRetryCount", "(I)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "export", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "callback", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a AmN;
  private boolean AmL;
  public d.g.a.b<? super Float, y> AmM;
  public int retryCount = 1;
  private VideoTransPara uKO;
  public boolean uzZ = true;
  
  static
  {
    AppMethodBeat.i(207499);
    AmN = new a((byte)0);
    AppMethodBeat.o(207499);
  }
  
  public final void a(yo paramyo, d.g.a.b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(207498);
    k.h(paramyo, "compositionInfo");
    k.h(paramb, "callback");
    yp localyp = paramyo.AmP;
    r localr = c.a(paramyo);
    localr.efD().AqO = true;
    if ((this.AmL) && (this.uKO != null))
    {
      b localb = new b(localr);
      Object localObject = this.uKO;
      if (localObject == null) {
        k.fOy();
      }
      localObject = localr.b((VideoTransPara)localObject, localyp.gNU, localyp.gNV);
      k.g(localyp, "outputConfig");
      localb.a((r.a)localObject, localyp);
    }
    paramyo = c.b(paramyo);
    localr.D((d.g.a.b)paramyo);
    paramyo.start();
    k.g(localyp, "outputConfig");
    localr.a(localyp, (d.g.a.b)new a.b(this, paramyo, paramb), this.AmM);
    AppMethodBeat.o(207498);
  }
  
  public final void r(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(207497);
    k.h(paramVideoTransPara, "videoTransPara");
    this.AmL = true;
    this.uKO = paramVideoTransPara;
    AppMethodBeat.o(207497);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.a
 * JD-Core Version:    0.7.0.1
 */