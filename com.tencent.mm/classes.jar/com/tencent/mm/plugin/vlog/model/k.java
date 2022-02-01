package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import d.g.a.b;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "retryCount", "", "getRetryCount", "()I", "setRetryCount", "(I)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "export", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "callback", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "Companion", "plugin-vlog_release"})
public final class k
{
  public static final a Lqb;
  private boolean LpZ;
  public b<? super Float, y> Lqa;
  public int retryCount = 1;
  private VideoTransPara tCr;
  public boolean trF = true;
  
  static
  {
    AppMethodBeat.i(200812);
    Lqb = new a((byte)0);
    AppMethodBeat.o(200812);
  }
  
  public final void a(final dxw paramdxw, final b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(200811);
    d.g.b.k.h(paramdxw, "compositionInfo");
    d.g.b.k.h(paramb, "callback");
    dxx localdxx = paramdxw.Lqd;
    v localv = m.a(paramdxw);
    if ((this.LpZ) && (this.tCr != null))
    {
      l locall = new l(localv);
      Object localObject = this.tCr;
      if (localObject == null) {
        d.g.b.k.fvU();
      }
      localObject = localv.b((VideoTransPara)localObject, localdxx.gnh, localdxx.gni);
      d.g.b.k.g(localdxx, "outputConfig");
      locall.a((v.a)localObject, localdxx);
    }
    paramdxw = m.b(paramdxw);
    localv.K((b)paramdxw);
    paramdxw.start();
    d.g.b.k.g(localdxx, "outputConfig");
    localv.a(localdxx, (b)new b(this, paramdxw, paramb), this.Lqa);
    AppMethodBeat.o(200811);
  }
  
  public final void r(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(200810);
    d.g.b.k.h(paramVideoTransPara, "videoTransPara");
    this.LpZ = true;
    this.tCr = paramVideoTransPara;
    AppMethodBeat.o(200810);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Boolean, y>
  {
    b(k paramk, f paramf, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.k
 * JD-Core Version:    0.7.0.1
 */