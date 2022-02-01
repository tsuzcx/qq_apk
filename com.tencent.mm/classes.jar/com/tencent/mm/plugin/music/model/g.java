package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import java.nio.charset.Charset;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/music/model/MusicFileNameUtil;", "", "()V", "AVATAR_FILE", "", "BULLET_CACHE_FILE", "CACHE", "COVER_APP_ICON", "COVER_AVATAR", "COVER_DEFAULT_VIDEO", "COVER_IMG", "COVER_TRANSITION", "COVER_VIDEO", "LIKE_CACHE_FILE", "PIC_FILE", "STORAGE_COVER", "STORAGE_MUSIC", "TAG", "TMP_FILE", "UP_FILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "autoPath", "user", "avatarEnsurePath", "parentPath", "coverId", "avatarPath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "coverAppIconPath", "coverAvatarPath", "coverDefaultVideoPath", "coverImgPath", "coverTransitionPath", "coverVideoPath", "defaultVideoPath", "name", "isSelf", "userName", "musicBulletCachePath", "musicCachePath", "musicLikeCachePath", "musicPath", "primaryPathVideoPath", "username", "reset", "thumbEnsurePath", "mediaId", "thumbPath", "musicId", "uploadEnsurePath", "uploadThumbPath", "uploadVideoPath", "videoEnsurePath", "videoPath", "url", "plugin-music_release"})
public final class g
{
  public static final g FRy;
  private static String iRj;
  
  static
  {
    AppMethodBeat.i(259701);
    FRy = new g();
    iRj = "";
    AppMethodBeat.o(259701);
  }
  
  public static String aSf(String paramString)
  {
    AppMethodBeat.i(259699);
    if (paramString == null)
    {
      AppMethodBeat.o(259699);
      return "";
    }
    String str = feS() + "img/";
    if (paramString == null)
    {
      AppMethodBeat.o(259699);
      return "";
    }
    paramString = str + paramString + ".p";
    AppMethodBeat.o(259699);
    return paramString;
  }
  
  public static String aSg(String paramString)
  {
    AppMethodBeat.i(259700);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(259700);
      return "";
    }
    localObject = feS() + "video/";
    Charset localCharset = d.UTF_8;
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(259700);
      throw paramString;
    }
    paramString = paramString.getBytes(localCharset);
    p.j(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(259700);
      return "";
    }
    paramString = (String)localObject + paramString + ".v";
    AppMethodBeat.o(259700);
    return paramString;
  }
  
  public static String feP()
  {
    AppMethodBeat.i(259695);
    String str = feS() + "mv_default_video/";
    AppMethodBeat.o(259695);
    return str;
  }
  
  public static String feQ()
  {
    AppMethodBeat.i(259696);
    String str = feS() + "mv_transition/";
    AppMethodBeat.o(259696);
    return str;
  }
  
  public static String feR()
  {
    AppMethodBeat.i(259697);
    String str = feS() + "mv_app_icon/";
    AppMethodBeat.o(259697);
    return str;
  }
  
  public static String feS()
  {
    AppMethodBeat.i(259698);
    Object localObject = new StringBuilder();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localObject = localf.getAccPath() + "music/cover/";
    AppMethodBeat.o(259698);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.g
 * JD-Core Version:    0.7.0.1
 */