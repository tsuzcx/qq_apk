package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "", "name", "", "width", "", "height", "durationMs", "", "thumbPath", "(Ljava/lang/String;IIJLjava/lang/String;)V", "getDurationMs", "()J", "setDurationMs", "(J)V", "getHeight", "()I", "getName", "()Ljava/lang/String;", "getThumbPath", "setThumbPath", "(Ljava/lang/String;)V", "getWidth", "getFilePath", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a LWQ;
  private static int LWR;
  private static final String TAG;
  public long durationMs;
  public final int height;
  public final String name;
  String thumbPath;
  public final int width;
  
  static
  {
    AppMethodBeat.i(286103);
    LWQ = new a((byte)0);
    TAG = "MicroMsg.Mv.DefaultVideoInfo";
    LWR = 1;
    AppMethodBeat.o(286103);
  }
  
  private b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(286070);
    this.name = paramString1;
    this.width = 634;
    this.height = 1080;
    this.durationMs = 5000L;
    this.thumbPath = paramString2;
    AppMethodBeat.o(286070);
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(286108);
    Object localObject = g.LMs;
    localObject = y.n(ah.v(new u(g.gnW(), this.name).jKT()), false);
    if (localObject == null)
    {
      AppMethodBeat.o(286108);
      return "";
    }
    AppMethodBeat.o(286108);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo$Companion;", "", "()V", "TAG", "", "lastRandomIndex", "", "getVideoInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultVideoInfo;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static b gpv()
    {
      AppMethodBeat.i(286039);
      b localb = new b(b.gpu() + ".mp4");
      if (y.ZC(localb.getFilePath())) {
        b.adP(b.gpu() + 1);
      }
      for (;;)
      {
        AppMethodBeat.o(286039);
        return localb;
        b.adP(1);
        localb = new b(b.gpu() + ".mp4");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b
 * JD-Core Version:    0.7.0.1
 */