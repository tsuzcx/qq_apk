package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.i;
import com.tencent.mm.pluginsdk.model.a;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageLoadTaskListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadTaskListener;", "scene", "", "(I)V", "url", "", "onAfterRun", "", "onBeforeRun", "Companion", "plugin-biz_release"})
public final class l
  implements i
{
  public static final l.a BYi;
  private int scene = 1;
  private String url = "";
  
  static
  {
    AppMethodBeat.i(124896);
    BYi = new l.a((byte)0);
    AppMethodBeat.o(124896);
  }
  
  public final void azf()
  {
    AppMethodBeat.i(124895);
    Object localObject = g.BXQ;
    if (g.UJ(this.scene))
    {
      localObject = a.BOa;
      a.cA(2, this.url);
    }
    AppMethodBeat.o(124895);
  }
  
  public final void yD(String paramString)
  {
    AppMethodBeat.i(124894);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.url = ((String)localObject);
      localObject = g.BXQ;
      if (g.UJ(this.scene))
      {
        localObject = a.BOa;
        a.cA(8, paramString);
        localObject = a.BOa;
        a.cz(2, paramString);
      }
      AppMethodBeat.o(124894);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.l
 * JD-Core Version:    0.7.0.1
 */