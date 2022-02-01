package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/MusicMediaPath;", "", "()V", "musicCachePath", "", "getMusicCachePath", "()Ljava/lang/String;", "thumbSuffix", "getCaptureFilePath", "getCaptureThumbPath", "plugin-music_release"})
public final class j
{
  private static final String FRH = "_thumb";
  public static final j FRI;
  
  static
  {
    AppMethodBeat.i(260214);
    FRI = new j();
    FRH = "_thumb";
    AppMethodBeat.o(260214);
  }
  
  public static String egp()
  {
    AppMethodBeat.i(260209);
    Object localObject1 = new StringBuilder().append(feT());
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(260209);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2);
    AppMethodBeat.o(260209);
    return localObject1;
  }
  
  private static String feT()
  {
    AppMethodBeat.i(260207);
    String str = b.aSU() + "music/";
    AppMethodBeat.o(260207);
    return str;
  }
  
  public static String feU()
  {
    AppMethodBeat.i(260211);
    Object localObject1 = new StringBuilder().append(feT());
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(260211);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2) + FRH;
    AppMethodBeat.o(260211);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.j
 * JD-Core Version:    0.7.0.1
 */