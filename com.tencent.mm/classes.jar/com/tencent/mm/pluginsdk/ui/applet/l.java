package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.i;
import com.tencent.mm.pluginsdk.model.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageLoadTaskListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadTaskListener;", "scene", "", "(I)V", "url", "", "onAfterRun", "", "onBeforeRun", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements i
{
  public static final l.a YbI;
  private int scene = 1;
  private String url = "";
  
  static
  {
    AppMethodBeat.i(124896);
    YbI = new l.a((byte)0);
    AppMethodBeat.o(124896);
  }
  
  public final void Ox(String paramString)
  {
    AppMethodBeat.i(124894);
    if (paramString == null) {}
    for (Object localObject = "";; localObject = paramString)
    {
      this.url = ((String)localObject);
      localObject = g.Ybp;
      if (g.awm(this.scene))
      {
        localObject = e.XQp;
        e.dW(8, paramString);
        localObject = e.XQp;
        e.dV(2, paramString);
      }
      AppMethodBeat.o(124894);
      return;
    }
  }
  
  public final void bKC()
  {
    AppMethodBeat.i(124895);
    Object localObject = g.Ybp;
    if (g.awm(this.scene))
    {
      localObject = e.XQp;
      e.dW(2, this.url);
    }
    AppMethodBeat.o(124895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.l
 * JD-Core Version:    0.7.0.1
 */