package com.tencent.mm.plugin.mv.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cq;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"buildBusinessBuffer", "", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "musicShareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "escape", "", "toMusicShareObject", "albumUrl", "toXml", "plugin-mv_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final String a(boo paramboo, dtj paramdtj)
  {
    AppMethodBeat.i(288182);
    s.u(paramboo, "songInfo");
    paramboo = new StringBuilder("\n<MusicVideoStatusOpenParams>\n").append(c(paramboo)).append('\n');
    s.u(paramdtj, "<this>");
    paramdtj = cq.a(paramdtj);
    s.s(paramdtj, "makeContent(this)");
    paramboo = n.bJB(paramdtj + "\n</MusicVideoStatusOpenParams>");
    AppMethodBeat.o(288182);
    return paramboo;
  }
  
  public static final String c(boo paramboo)
  {
    AppMethodBeat.i(288174);
    s.u(paramboo, "<this>");
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("<FinderMVSongInfo>\n    <songName>").append(ga(paramboo.songName)).append("</songName>\n    <singer>").append(ga(paramboo.rDl)).append("</singer>\n    <musicDataUrl>").append(ga(paramboo.musicDataUrl)).append("</musicDataUrl>\n    <musicAppId>").append(ga(paramboo.ZWQ)).append("</musicAppId>\n    <musicWebUrl>").append(ga(paramboo.ZWR)).append("</musicWebUrl>\n    <songId>").append(ga(paramboo.mLQ)).append("</songId>\n    <lyric>").append(ga(paramboo.Mcq)).append("</lyric>\n    <albumName>").append(ga(paramboo.albumName)).append("</albumName>\n    <albumUrl>").append(ga(paramboo.ZWS)).append("</albumUrl>\n    <genre>").append(ga(paramboo.ZTA)).append("</genre>\n    <publicTime>").append(ga(paramboo.ZWT)).append("</publicTime>\n    <publicTimeS>");
    StringBuilder localStringBuilder2 = localStringBuilder1.append(ga(Long.valueOf(paramboo.ZWU))).append("</publicTimeS>\n    <extraInfo>").append(ga(paramboo.extraInfo)).append("</extraInfo>\n    <identification>").append(ga(paramboo.identification)).append("</identification>\n    <duration>").append(paramboo.duration).append("</duration>\n    <musicOperationUrl>");
    Object localObject = paramboo.ZWW;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((bop)localObject).ZWX)
    {
      localStringBuilder2.append(ga(localObject)).append("</musicOperationUrl>\n    <mid>").append(ga(paramboo.oOZ)).append("</mid>\n</FinderMVSongInfo>\n");
      paramboo = n.bJB(localStringBuilder1.toString());
      AppMethodBeat.o(288174);
      return paramboo;
    }
  }
  
  private static String ga(Object paramObject)
  {
    AppMethodBeat.i(288164);
    if (paramObject == null) {
      paramObject = "";
    }
    for (;;)
    {
      paramObject = Util.escapeStringForXml(paramObject);
      s.s(paramObject, "escapeStringForXml(this?.toString() ?: \"\")");
      AppMethodBeat.o(288164);
      return paramObject;
      String str = paramObject.toString();
      paramObject = str;
      if (str == null) {
        paramObject = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.a.d
 * JD-Core Version:    0.7.0.1
 */