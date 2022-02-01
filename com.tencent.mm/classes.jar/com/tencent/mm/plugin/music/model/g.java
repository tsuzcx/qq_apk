package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/MusicFileNameUtil;", "", "()V", "AVATAR_FILE", "", "BULLET_CACHE_FILE", "CACHE", "COVER_APP_ICON", "COVER_AVATAR", "COVER_DEFAULT_VIDEO", "COVER_IMG", "COVER_TRANSITION", "COVER_VIDEO", "LIKE_CACHE_FILE", "PIC_FILE", "STORAGE_COVER", "STORAGE_MUSIC", "TAG", "TMP_FILE", "UP_FILE", "VIDEO_FILE", "selfName", "getSelfName", "()Ljava/lang/String;", "setSelfName", "(Ljava/lang/String;)V", "autoPath", "user", "avatarEnsurePath", "parentPath", "coverId", "avatarPath", "checkSelfName", "checkToCreateDir", "", "newVideoPath", "noMedia", "", "coverAppIconPath", "coverAvatarPath", "coverDefaultVideoPath", "coverImgPath", "coverTransitionPath", "coverVideoPath", "defaultVideoPath", "name", "isSelf", "userName", "musicBulletCachePath", "musicCachePath", "musicLikeCachePath", "musicPath", "primaryPathVideoPath", "username", "reset", "thumbEnsurePath", "mediaId", "thumbPath", "musicId", "uploadEnsurePath", "uploadThumbPath", "uploadVideoPath", "videoEnsurePath", "videoPath", "url", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g LMs;
  private static String ltf;
  
  static
  {
    AppMethodBeat.i(271163);
    LMs = new g();
    ltf = "";
    AppMethodBeat.o(271163);
  }
  
  public static String aOX(String paramString)
  {
    AppMethodBeat.i(271149);
    if (paramString == null)
    {
      AppMethodBeat.o(271149);
      return "";
    }
    String str = s.X(gnZ(), "img/");
    if (paramString == null)
    {
      AppMethodBeat.o(271149);
      return "";
    }
    paramString = str + paramString + ".p";
    AppMethodBeat.o(271149);
    return paramString;
  }
  
  public static String aOY(String paramString)
  {
    AppMethodBeat.i(271157);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(271157);
      return "";
    }
    localObject = s.X(gnZ(), "video/");
    Charset localCharset = d.UTF_8;
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(271157);
      throw paramString;
    }
    paramString = paramString.getBytes(localCharset);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(271157);
      return "";
    }
    paramString = (String)localObject + paramString + ".v";
    AppMethodBeat.o(271157);
    return paramString;
  }
  
  public static String gnW()
  {
    AppMethodBeat.i(271122);
    String str = s.X(gnZ(), "mv_default_video/");
    AppMethodBeat.o(271122);
    return str;
  }
  
  public static String gnX()
  {
    AppMethodBeat.i(271128);
    String str = s.X(gnZ(), "mv_transition/");
    AppMethodBeat.o(271128);
    return str;
  }
  
  public static String gnY()
  {
    AppMethodBeat.i(271133);
    String str = s.X(gnZ(), "mv_app_icon/");
    AppMethodBeat.o(271133);
    return str;
  }
  
  public static String gnZ()
  {
    AppMethodBeat.i(271141);
    String str = s.X(h.baE().mCJ, "music/cover/");
    AppMethodBeat.o(271141);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.g
 * JD-Core Version:    0.7.0.1
 */