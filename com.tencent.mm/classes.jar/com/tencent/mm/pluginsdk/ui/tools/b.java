package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class b
  extends f
{
  public int Alz = 0;
  public String Ktn = "";
  public String Kto = "";
  public String Ktp = "";
  public String Ktq = "";
  public String Ktr = "";
  public String Kts = "";
  public String Ktt = "";
  public String Ktu = "";
  public String Ktv = "";
  public String Ktw = "";
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
    if (!Util.isNullOrNil(this.Ktn)) {
      paramStringBuilder.append("<mvObjectId>").append(Util.escapeStringForXml(this.Ktn)).append("</mvObjectId>");
    }
    if (!Util.isNullOrNil(this.Kto)) {
      paramStringBuilder.append("<mvNonceId>").append(Util.escapeStringForXml(this.Kto)).append("</mvNonceId>");
    }
    if (!Util.isNullOrNil(this.Ktp)) {
      paramStringBuilder.append("<mvCoverUrl>").append(Util.escapeStringForXml(this.Ktp)).append("</mvCoverUrl>");
    }
    if (!Util.isNullOrNil(this.Ktq)) {
      paramStringBuilder.append("<mvMakerFinderNickname>").append(Util.escapeStringForXml(this.Ktq)).append("</mvMakerFinderNickname>");
    }
    if (!Util.isNullOrNil(this.Ktr)) {
      paramStringBuilder.append("<mvSingerName>").append(Util.escapeStringForXml(this.Ktr)).append("</mvSingerName>");
    }
    if (!Util.isNullOrNil(this.Kts)) {
      paramStringBuilder.append("<mvAlbumName>").append(Util.escapeStringForXml(this.Kts)).append("</mvAlbumName>");
    }
    if (!Util.isNullOrNil(this.Ktt)) {
      paramStringBuilder.append("<mvMusicGenre>").append(Util.escapeStringForXml(this.Ktt)).append("</mvMusicGenre>");
    }
    if (!Util.isNullOrNil(this.Ktu)) {
      paramStringBuilder.append("<mvIssueDate>").append(Util.escapeStringForXml(this.Ktu)).append("</mvIssueDate>");
    }
    if (!Util.isNullOrNil(this.Ktv)) {
      paramStringBuilder.append("<mvIdentification>").append(Util.escapeStringForXml(this.Ktv)).append("</mvIdentification>");
    }
    paramStringBuilder.append("<musicDuration>").append(this.Alz).append("</musicDuration>");
    if (!Util.isNullOrNil(this.Ktw)) {
      paramStringBuilder.append("<mvExtInfo>").append(Util.escapeStringForXml(this.Ktw)).append("</mvExtInfo>");
    }
    paramStringBuilder.append("</musicShareItem>");
    AppMethodBeat.o(152372);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152373);
    this.songAlbumUrl = ((String)paramMap.get(".msg.appmsg.songalbumurl"));
    this.songLyric = ((String)paramMap.get(".msg.appmsg.songlyric"));
    this.Ktn = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvObjectId"));
    this.Kto = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvNonceId"));
    this.Ktp = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvCoverUrl"));
    this.Ktq = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvMakerFinderNickname"));
    this.Ktr = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvSingerName"));
    this.Kts = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvAlbumName"));
    this.Ktt = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvMusicGenre"));
    this.Ktu = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvIssueDate"));
    this.Ktv = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvIdentification"));
    this.Ktw = ((String)paramMap.get(".msg.appmsg.musicShareItem.mvExtInfo"));
    this.Alz = Util.safeParseInt((String)paramMap.get(".msg.appmsg.musicShareItem.musicDuration"));
    AppMethodBeat.o(152373);
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(152371);
    b localb = new b();
    localb.songAlbumUrl = this.songAlbumUrl;
    localb.songLyric = this.songLyric;
    localb.Ktn = this.Ktn;
    localb.Kto = this.Kto;
    localb.Ktp = this.Ktp;
    localb.Ktq = this.Ktq;
    localb.Ktr = this.Ktr;
    localb.Kts = this.Kts;
    localb.Ktt = this.Ktt;
    localb.Ktu = this.Ktu;
    localb.Ktv = this.Ktv;
    localb.Ktw = this.Ktw;
    localb.Alz = this.Alz;
    AppMethodBeat.o(152371);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */