package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/MusicMediaPath;", "", "()V", "musicCachePath", "", "getMusicCachePath", "()Ljava/lang/String;", "thumbSuffix", "getCaptureFilePath", "getCaptureThumbPath", "plugin-music_release"})
public final class j
{
  private static final String AkD = "_thumb";
  public static final j AkE;
  
  static
  {
    AppMethodBeat.i(219981);
    AkE = new j();
    AkD = "_thumb";
    AppMethodBeat.o(219981);
  }
  
  public static String dEC()
  {
    AppMethodBeat.i(219979);
    Object localObject1 = new StringBuilder().append(euy());
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(219979);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2);
    AppMethodBeat.o(219979);
    return localObject1;
  }
  
  private static String euy()
  {
    AppMethodBeat.i(219978);
    String str = b.aKS() + "music/";
    AppMethodBeat.o(219978);
    return str;
  }
  
  public static String euz()
  {
    AppMethodBeat.i(219980);
    Object localObject1 = new StringBuilder().append(euy());
    Object localObject2 = String.valueOf(System.currentTimeMillis());
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(219980);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = g.getMessageDigest((byte[])localObject2) + AkD;
    AppMethodBeat.o(219980);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.j
 * JD-Core Version:    0.7.0.1
 */