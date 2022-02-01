package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b
  extends f
{
  public int LNC = 0;
  public String YqN = "";
  public String YqO = "";
  public String YqP = "";
  public String YqQ = "";
  public String YqR = "";
  public String YqS = "";
  public String YqT = "";
  public String YqU = "";
  public String YqV = "";
  public String YqW = "";
  public String YqX = "";
  public String YqY = "";
  public String oOZ = "";
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
    if (!Util.isNullOrNil(this.YqN)) {
      paramStringBuilder.append("<mvObjectId>").append(Util.escapeStringForXml(this.YqN)).append("</mvObjectId>");
    }
    if (!Util.isNullOrNil(this.YqO)) {
      paramStringBuilder.append("<mvNonceId>").append(Util.escapeStringForXml(this.YqO)).append("</mvNonceId>");
    }
    if (!Util.isNullOrNil(this.YqP)) {
      paramStringBuilder.append("<mvCoverUrl>").append(Util.escapeStringForXml(this.YqP)).append("</mvCoverUrl>");
    }
    if (!Util.isNullOrNil(this.YqQ)) {
      paramStringBuilder.append("<mvMakerFinderNickname>").append(Util.escapeStringForXml(this.YqQ)).append("</mvMakerFinderNickname>");
    }
    if (!Util.isNullOrNil(this.YqR)) {
      paramStringBuilder.append("<mvSingerName>").append(Util.escapeStringForXml(this.YqR)).append("</mvSingerName>");
    }
    if (!Util.isNullOrNil(this.YqS)) {
      paramStringBuilder.append("<mvAlbumName>").append(Util.escapeStringForXml(this.YqS)).append("</mvAlbumName>");
    }
    if (!Util.isNullOrNil(this.YqT)) {
      paramStringBuilder.append("<mvMusicGenre>").append(Util.escapeStringForXml(this.YqT)).append("</mvMusicGenre>");
    }
    if (!Util.isNullOrNil(this.YqU)) {
      paramStringBuilder.append("<mvIssueDate>").append(Util.escapeStringForXml(this.YqU)).append("</mvIssueDate>");
    }
    if (!Util.isNullOrNil(this.YqV)) {
      paramStringBuilder.append("<mvIdentification>").append(Util.escapeStringForXml(this.YqV)).append("</mvIdentification>");
    }
    paramStringBuilder.append("<musicDuration>").append(this.LNC).append("</musicDuration>");
    if (!Util.isNullOrNil(this.YqW)) {
      paramStringBuilder.append("<mvExtInfo>").append(Util.escapeStringForXml(this.YqW)).append("</mvExtInfo>");
    }
    if (!Util.isNullOrNil(this.YqX)) {
      paramStringBuilder.append("<mvOperationUrl>").append(Util.escapeStringForXml(this.YqX)).append("</mvOperationUrl>");
    }
    if (!Util.isNullOrNil(this.oOZ)) {
      paramStringBuilder.append("<mid>").append(Util.escapeStringForXml(this.oOZ)).append("</mid>");
    }
    if (!Util.isNullOrNil(this.YqY)) {
      paramStringBuilder.append("<appIdForSourceDisplay>").append(Util.escapeStringForXml(this.YqY)).append("</appIdForSourceDisplay>");
    }
    paramStringBuilder.append("</musicShareItem>");
    AppMethodBeat.o(152372);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152373);
    this.songAlbumUrl = ((String)paramMap.get(".msg.appmsg.songalbumurl"));
    this.songLyric = ((String)paramMap.get(".msg.appmsg.songlyric"));
    this.YqN = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvObjectId"));
    this.YqO = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvNonceId"));
    this.YqP = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvCoverUrl"));
    this.YqQ = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvMakerFinderNickname"));
    this.YqR = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvSingerName"));
    this.YqS = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvAlbumName"));
    this.YqT = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvMusicGenre"));
    this.YqU = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvIssueDate"));
    this.YqV = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvIdentification"));
    this.YqW = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvExtInfo"));
    this.LNC = Util.safeParseInt((String)paramMap.get(".msg.appmsg.musicShareItem.musicDuration"));
    this.YqX = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvOperationUrl"));
    this.oOZ = ((String)paramMap.get(".msg.appmsg.musicShareItem.mid"));
    this.YqY = ((String)paramMap.get(".msg.appmsg.musicShareItem.appIdForSourceDisplay"));
    AppMethodBeat.o(152373);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(152371);
    b localb = new b();
    localb.songAlbumUrl = this.songAlbumUrl;
    localb.songLyric = this.songLyric;
    localb.YqN = this.YqN;
    localb.YqO = this.YqO;
    localb.YqP = this.YqP;
    localb.YqQ = this.YqQ;
    localb.YqR = this.YqR;
    localb.YqS = this.YqS;
    localb.YqT = this.YqT;
    localb.YqU = this.YqU;
    localb.YqV = this.YqV;
    localb.YqW = this.YqW;
    localb.LNC = this.LNC;
    localb.oOZ = this.oOZ;
    localb.YqY = this.YqY;
    AppMethodBeat.o(152371);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */