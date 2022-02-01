package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "", "name", "", "width", "", "height", "durationMs", "", "thumbPath", "(Ljava/lang/String;IIJLjava/lang/String;)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getHeight", "()I", "getName", "()Ljava/lang/String;", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "getWidth", "getFilePath", "Companion", "plugin-mv_release"})
public final class b
{
  private static int GaQ = 0;
  public static final a GaR;
  private static final String TAG = "MicroMsg.Mv.DefaultVideoInfo";
  public long durationMs;
  public final int height;
  public final String name;
  String thumbPath;
  public final int width;
  
  static
  {
    AppMethodBeat.i(229788);
    GaR = new a((byte)0);
    TAG = "MicroMsg.Mv.DefaultVideoInfo";
    GaQ = 1;
    AppMethodBeat.o(229788);
  }
  
  private b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229784);
    this.name = paramString1;
    this.width = 634;
    this.height = 1080;
    this.durationMs = 5000L;
    this.thumbPath = paramString2;
    AppMethodBeat.o(229784);
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(229782);
    Object localObject = g.FRy;
    String str = u.n(new q(g.feP(), this.name).bOF(), false);
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(229782);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo$Companion;", "", "()V", "TAG", "", "lastRandomIndex", "", "getVideoInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "plugin-mv_release"})
  public static final class a
  {
    public static b ffS()
    {
      AppMethodBeat.i(230800);
      b localb = new b(b.ffR() + ".mp4");
      if (u.agG(localb.getFilePath())) {
        b.ZC(b.ffR() + 1);
      }
      for (;;)
      {
        AppMethodBeat.o(230800);
        return localb;
        b.ZC(1);
        localb = new b(b.ffR() + ".mp4");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b
 * JD-Core Version:    0.7.0.1
 */