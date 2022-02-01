package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class aa
  extends f
{
  public String BYK;
  public String BYL;
  public String BYM;
  public String BYN;
  public long BYO;
  public String BYP;
  public String BYQ;
  public String BYR;
  public String BYS;
  public String BYT;
  public String BYU;
  public String BYV;
  public long BYW;
  public String BYX;
  public String kRU;
  public String pBl;
  public String pBm;
  public String source;
  public String tcG;
  public String thumbUrl;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117706);
    paramStringBuilder.append("<websearch>");
    if (!bs.isNullOrNil(this.BYK))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(k.b.vB(this.BYK));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!bs.isNullOrNil(this.BYL))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.vB(this.BYL));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bs.isNullOrNil(this.BYL))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.vB(this.BYL));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bs.isNullOrNil(this.BYM))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(k.b.vB(this.BYM));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!bs.isNullOrNil(this.BYN))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(k.b.vB(this.BYN));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.BYO >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.BYO);
      paramStringBuilder.append("</rec_category>");
    }
    if (!bs.isNullOrNil(this.pBl))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(k.b.vB(this.pBl));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!bs.isNullOrNil(this.pBm))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(k.b.vB(this.pBm));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!bs.isNullOrNil(this.tcG))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(k.b.vB(this.tcG));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!bs.isNullOrNil(this.BYP))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(k.b.vB(this.BYP));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!bs.isNullOrNil(this.BYQ))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(k.b.vB(this.BYQ));
      paramStringBuilder.append("</shareString>");
    }
    if (!bs.isNullOrNil(this.BYR))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(k.b.vB(this.BYR));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!bs.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(k.b.vB(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!bs.isNullOrNil(this.kRU))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(k.b.vB(this.kRU));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!bs.isNullOrNil(this.BYS))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(k.b.vB(this.BYS));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!bs.isNullOrNil(this.BYT))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(k.b.vB(this.BYT));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!bs.isNullOrNil(this.BYU))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(k.b.vB(this.BYU));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!bs.isNullOrNil(this.BYV))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(k.b.vB(this.BYV));
      paramStringBuilder.append("</tagList>");
    }
    if (this.BYW >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.BYW);
      paramStringBuilder.append("</channelId>");
    }
    if (!bs.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(k.b.vB(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!bs.isNullOrNil(this.BYX))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(k.b.vB(this.BYX));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(117706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(117707);
    this.BYK = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.BYL = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.BYM = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.BYN = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.BYO = bs.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.pBl = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.pBm = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.tcG = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.BYP = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.BYQ = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.BYR = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.kRU = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.BYS = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.BYT = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.BYU = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.BYV = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.BYW = bs.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.BYX = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(117707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aa
 * JD-Core Version:    0.7.0.1
 */