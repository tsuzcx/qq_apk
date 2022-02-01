package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b
  extends f
{
  public int FSG = 0;
  public String RuA = "";
  public String RuB = "";
  public String RuC = "";
  public String RuD = "";
  public String Ruu = "";
  public String Ruv = "";
  public String Ruw = "";
  public String Rux = "";
  public String Ruy = "";
  public String Ruz = "";
  public String songAlbumUrl = "";
  public String songLyric = "";
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152372);
    if (!Util.isNullOrNil(this.songAlbumUrl)) {
      paramStringBuilder.append("<songalbumurl>").append(Util.escapeStringForXml(this.songAlbumUrl)).append("</songalbumurl>");
    }
    if (!Util.isNullOrNil(this.songLyric)) {
      paramStringBuilder.append("<songlyric>").append(Util.escapeStringForXml(this.songLyric)).append("</songlyric>");
    }
    paramStringBuilder.append("<musicShareItem>");
    if (!Util.isNullOrNil(this.Ruu)) {
      paramStringBuilder.append("<mvObjectId>").append(Util.escapeStringForXml(this.Ruu)).append("</mvObjectId>");
    }
    if (!Util.isNullOrNil(this.Ruv)) {
      paramStringBuilder.append("<mvNonceId>").append(Util.escapeStringForXml(this.Ruv)).append("</mvNonceId>");
    }
    if (!Util.isNullOrNil(this.Ruw)) {
      paramStringBuilder.append("<mvCoverUrl>").append(Util.escapeStringForXml(this.Ruw)).append("</mvCoverUrl>");
    }
    if (!Util.isNullOrNil(this.Rux)) {
      paramStringBuilder.append("<mvMakerFinderNickname>").append(Util.escapeStringForXml(this.Rux)).append("</mvMakerFinderNickname>");
    }
    if (!Util.isNullOrNil(this.Ruy)) {
      paramStringBuilder.append("<mvSingerName>").append(Util.escapeStringForXml(this.Ruy)).append("</mvSingerName>");
    }
    if (!Util.isNullOrNil(this.Ruz)) {
      paramStringBuilder.append("<mvAlbumName>").append(Util.escapeStringForXml(this.Ruz)).append("</mvAlbumName>");
    }
    if (!Util.isNullOrNil(this.RuA)) {
      paramStringBuilder.append("<mvMusicGenre>").append(Util.escapeStringForXml(this.RuA)).append("</mvMusicGenre>");
    }
    if (!Util.isNullOrNil(this.RuB)) {
      paramStringBuilder.append("<mvIssueDate>").append(Util.escapeStringForXml(this.RuB)).append("</mvIssueDate>");
    }
    if (!Util.isNullOrNil(this.RuC)) {
      paramStringBuilder.append("<mvIdentification>").append(Util.escapeStringForXml(this.RuC)).append("</mvIdentification>");
    }
    paramStringBuilder.append("<musicDuration>").append(this.FSG).append("</musicDuration>");
    if (!Util.isNullOrNil(this.RuD)) {
      paramStringBuilder.append("<mvExtInfo>").append(Util.escapeStringForXml(this.RuD)).append("</mvExtInfo>");
    }
    paramStringBuilder.append("</musicShareItem>");
    AppMethodBeat.o(152372);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152373);
    this.songAlbumUrl = ((String)paramMap.get(".msg.appmsg.songalbumurl"));
    this.songLyric = ((String)paramMap.get(".msg.appmsg.songlyric"));
    this.Ruu = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvObjectId"));
    this.Ruv = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvNonceId"));
    this.Ruw = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvCoverUrl"));
    this.Rux = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvMakerFinderNickname"));
    this.Ruy = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvSingerName"));
    this.Ruz = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvAlbumName"));
    this.RuA = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvMusicGenre"));
    this.RuB = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvIssueDate"));
    this.RuC = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvIdentification"));
    this.RuD = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvExtInfo"));
    this.FSG = Util.safeParseInt((String)paramMap.get(".msg.appmsg.musicShareItem.musicDuration"));
    AppMethodBeat.o(152373);
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(152371);
    b localb = new b();
    localb.songAlbumUrl = this.songAlbumUrl;
    localb.songLyric = this.songLyric;
    localb.Ruu = this.Ruu;
    localb.Ruv = this.Ruv;
    localb.Ruw = this.Ruw;
    localb.Rux = this.Rux;
    localb.Ruy = this.Ruy;
    localb.Ruz = this.Ruz;
    localb.RuA = this.RuA;
    localb.RuB = this.RuB;
    localb.RuC = this.RuC;
    localb.RuD = this.RuD;
    localb.FSG = this.FSG;
    AppMethodBeat.o(152371);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */