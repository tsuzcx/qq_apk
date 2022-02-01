package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.i.b;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/MusicMediaPath;", "", "()V", "musicCachePath", "", "getMusicCachePath", "()Ljava/lang/String;", "thumbSuffix", "getCaptureFilePath", "getCaptureThumbPath", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j LMC;
  private static final String LMD;
  
  static
  {
    AppMethodBeat.i(271189);
    LMC = new j();
    LMD = "_thumb";
    AppMethodBeat.o(271189);
  }
  
  public static String fip()
  {
    AppMethodBeat.i(271171);
    Object localObject1 = goa();
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(271171);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = s.X((String)localObject1, g.getMessageDigest((byte[])localObject2));
    AppMethodBeat.o(271171);
    return localObject1;
  }
  
  private static String goa()
  {
    AppMethodBeat.i(271165);
    String str = s.X(b.bmI(), "music/");
    AppMethodBeat.o(271165);
    return str;
  }
  
  public static String gob()
  {
    AppMethodBeat.i(271182);
    Object localObject1 = new StringBuilder().append(goa());
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(271182);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2) + LMD;
    AppMethodBeat.o(271182);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.j
 * JD-Core Version:    0.7.0.1
 */