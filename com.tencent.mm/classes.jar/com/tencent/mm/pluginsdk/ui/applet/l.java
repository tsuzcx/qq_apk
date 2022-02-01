package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.pluginsdk.model.a;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageLoadTaskListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadTaskListener;", "scene", "", "(I)V", "url", "", "onAfterRun", "", "onBeforeRun", "Companion", "plugin-biz_release"})
public final class l
  implements i
{
  public static final l.a FnX;
  private int scene = 1;
  private String url = "";
  
  static
  {
    AppMethodBeat.i(124896);
    FnX = new l.a((byte)0);
    AppMethodBeat.o(124896);
  }
  
  public final void Go(String paramString)
  {
    AppMethodBeat.i(124894);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.url = ((String)localObject);
      localObject = g.FnF;
      if (g.Zv(this.scene))
      {
        localObject = a.Fdw;
        a.cK(8, paramString);
        localObject = a.Fdw;
        a.cJ(2, paramString);
      }
      AppMethodBeat.o(124894);
      return;
    }
  }
  
  public final void aJx()
  {
    AppMethodBeat.i(124895);
    Object localObject = g.FnF;
    if (g.Zv(this.scene))
    {
      localObject = a.Fdw;
      a.cK(2, this.url);
    }
    AppMethodBeat.o(124895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.l
 * JD-Core Version:    0.7.0.1
 */