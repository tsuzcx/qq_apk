package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.i;
import com.tencent.mm.pluginsdk.model.a;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageLoadTaskListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadTaskListener;", "scene", "", "(I)V", "url", "", "onAfterRun", "", "onBeforeRun", "Companion", "plugin-biz_release"})
public final class l
  implements i
{
  public static final l.a Dqz;
  private int scene = 1;
  private String url = "";
  
  static
  {
    AppMethodBeat.i(124896);
    Dqz = new l.a((byte)0);
    AppMethodBeat.o(124896);
  }
  
  public final void CI(String paramString)
  {
    AppMethodBeat.i(124894);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.url = ((String)localObject);
      localObject = g.Dqh;
      if (g.WT(this.scene))
      {
        localObject = a.Dgo;
        a.cD(8, paramString);
        localObject = a.Dgo;
        a.cC(2, paramString);
      }
      AppMethodBeat.o(124894);
      return;
    }
  }
  
  public final void aFW()
  {
    AppMethodBeat.i(124895);
    Object localObject = g.Dqh;
    if (g.WT(this.scene))
    {
      localObject = a.Dgo;
      a.cD(2, this.url);
    }
    AppMethodBeat.o(124895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.l
 * JD-Core Version:    0.7.0.1
 */