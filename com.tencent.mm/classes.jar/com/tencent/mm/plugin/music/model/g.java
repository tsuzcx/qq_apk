package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/music/model/MusicFileNameUtil;", "", "()V", "AVATAR_FILE", "", "BULLET_CACHE_FILE", "CACHE", "COVER_AVATAR", "COVER_DEFAULT_VIDEO", "COVER_IMG", "COVER_VIDEO", "LIKE_CACHE_FILE", "PIC_FILE", "STORAGE_COVER", "STORAGE_MUSIC", "TAG", "TMP_FILE", "UP_FILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "autoPath", "user", "avatarEnsurePath", "parentPath", "coverId", "avatarPath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "coverAvatarPath", "coverDefaultVideoPath", "coverImgPath", "coverVideoPath", "defaultVideoPath", "name", "isSelf", "userName", "musicBulletCachePath", "musicCachePath", "musicLikeCachePath", "musicPath", "primaryPathVideoPath", "username", "reset", "thumbEnsurePath", "mediaId", "thumbPath", "musicId", "uploadEnsurePath", "uploadThumbPath", "uploadVideoPath", "videoEnsurePath", "videoPath", "url", "plugin-music_release"})
public final class g
{
  public static final g Aku;
  private static String gna;
  
  static
  {
    AppMethodBeat.i(219974);
    Aku = new g();
    gna = "";
    AppMethodBeat.o(219974);
  }
  
  public static String aHP(String paramString)
  {
    AppMethodBeat.i(219972);
    if (paramString == null)
    {
      AppMethodBeat.o(219972);
      return "";
    }
    String str = eux() + "img/";
    if (paramString == null)
    {
      AppMethodBeat.o(219972);
      return "";
    }
    paramString = str + paramString + ".p";
    AppMethodBeat.o(219972);
    return paramString;
  }
  
  public static String aHQ(String paramString)
  {
    AppMethodBeat.i(219973);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(219973);
      return "";
    }
    localObject = eux() + "video/";
    Charset localCharset = d.UTF_8;
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(219973);
      throw paramString;
    }
    paramString = paramString.getBytes(localCharset);
    p.g(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(219973);
      return "";
    }
    paramString = (String)localObject + paramString + ".v";
    AppMethodBeat.o(219973);
    return paramString;
  }
  
  public static String eux()
  {
    AppMethodBeat.i(219971);
    Object localObject = new StringBuilder();
    e locale = com.tencent.mm.kernel.g.aAh();
    p.g(locale, "MMKernel.storage()");
    localObject = locale.getAccPath() + "music/cover/";
    AppMethodBeat.o(219971);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.g
 * JD-Core Version:    0.7.0.1
 */