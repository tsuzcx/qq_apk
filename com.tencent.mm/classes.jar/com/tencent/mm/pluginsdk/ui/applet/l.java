package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.i;
import com.tencent.mm.pluginsdk.model.c;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageLoadTaskListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadTaskListener;", "scene", "", "(I)V", "url", "", "onAfterRun", "", "onBeforeRun", "Companion", "plugin-biz_release"})
public final class l
  implements i
{
  public static final l.a RfB;
  private int scene = 1;
  private String url = "";
  
  static
  {
    AppMethodBeat.i(124896);
    RfB = new l.a((byte)0);
    AppMethodBeat.o(124896);
  }
  
  public final void Wy(String paramString)
  {
    AppMethodBeat.i(124894);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.url = ((String)localObject);
      localObject = g.Rfj;
      if (g.aqi(this.scene))
      {
        localObject = c.QUt;
        c.de(8, paramString);
        localObject = c.QUt;
        c.dd(2, paramString);
      }
      AppMethodBeat.o(124894);
      return;
    }
  }
  
  public final void bmQ()
  {
    AppMethodBeat.i(124895);
    Object localObject = g.Rfj;
    if (g.aqi(this.scene))
    {
      localObject = c.QUt;
      c.de(2, this.url);
    }
    AppMethodBeat.o(124895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.l
 * JD-Core Version:    0.7.0.1
 */