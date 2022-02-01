package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class ae
  extends f
{
  public String DTD;
  public String DTE;
  public String DTF;
  public String DTG;
  public long DTH;
  public String DTI;
  public String DTJ;
  public String DTK;
  public String DTL;
  public String DTM;
  public String DTN;
  public String DTO;
  public long DTP;
  public String DTQ;
  public String dJL;
  public String qlv;
  public String qlw;
  public String source;
  public String thumbUrl;
  public String uly;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117706);
    paramStringBuilder.append("<websearch>");
    if (!bu.isNullOrNil(this.DTD))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(k.b.zc(this.DTD));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!bu.isNullOrNil(this.DTE))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.zc(this.DTE));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bu.isNullOrNil(this.DTE))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.zc(this.DTE));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bu.isNullOrNil(this.DTF))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(k.b.zc(this.DTF));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!bu.isNullOrNil(this.DTG))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(k.b.zc(this.DTG));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.DTH >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.DTH);
      paramStringBuilder.append("</rec_category>");
    }
    if (!bu.isNullOrNil(this.qlv))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(k.b.zc(this.qlv));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!bu.isNullOrNil(this.qlw))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(k.b.zc(this.qlw));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!bu.isNullOrNil(this.uly))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(k.b.zc(this.uly));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!bu.isNullOrNil(this.DTI))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(k.b.zc(this.DTI));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!bu.isNullOrNil(this.DTJ))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(k.b.zc(this.DTJ));
      paramStringBuilder.append("</shareString>");
    }
    if (!bu.isNullOrNil(this.DTK))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(k.b.zc(this.DTK));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!bu.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(k.b.zc(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!bu.isNullOrNil(this.dJL))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(k.b.zc(this.dJL));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!bu.isNullOrNil(this.DTL))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(k.b.zc(this.DTL));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!bu.isNullOrNil(this.DTM))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(k.b.zc(this.DTM));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!bu.isNullOrNil(this.DTN))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(k.b.zc(this.DTN));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!bu.isNullOrNil(this.DTO))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(k.b.zc(this.DTO));
      paramStringBuilder.append("</tagList>");
    }
    if (this.DTP >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.DTP);
      paramStringBuilder.append("</channelId>");
    }
    if (!bu.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(k.b.zc(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!bu.isNullOrNil(this.DTQ))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(k.b.zc(this.DTQ));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(117706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(117707);
    this.DTD = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.DTE = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.DTF = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.DTG = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.DTH = bu.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.qlv = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.qlw = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.uly = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.DTI = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.DTJ = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.DTK = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.dJL = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.DTL = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.DTM = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.DTN = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.DTO = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.DTP = bu.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.DTQ = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(117707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ae
 * JD-Core Version:    0.7.0.1
 */