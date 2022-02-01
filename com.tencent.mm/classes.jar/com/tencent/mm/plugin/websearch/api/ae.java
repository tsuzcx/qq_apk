package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class ae
  extends f
{
  public String DBG;
  public String DBH;
  public String DBI;
  public String DBJ;
  public long DBK;
  public String DBL;
  public String DBM;
  public String DBN;
  public String DBO;
  public String DBP;
  public String DBQ;
  public String DBR;
  public long DBS;
  public String DBT;
  public String lox;
  public String qeQ;
  public String qeR;
  public String source;
  public String thumbUrl;
  public String uaw;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117706);
    paramStringBuilder.append("<websearch>");
    if (!bt.isNullOrNil(this.DBG))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(k.b.ys(this.DBG));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!bt.isNullOrNil(this.DBH))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.ys(this.DBH));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bt.isNullOrNil(this.DBH))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.ys(this.DBH));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bt.isNullOrNil(this.DBI))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(k.b.ys(this.DBI));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!bt.isNullOrNil(this.DBJ))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(k.b.ys(this.DBJ));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.DBK >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.DBK);
      paramStringBuilder.append("</rec_category>");
    }
    if (!bt.isNullOrNil(this.qeQ))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(k.b.ys(this.qeQ));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!bt.isNullOrNil(this.qeR))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(k.b.ys(this.qeR));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!bt.isNullOrNil(this.uaw))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(k.b.ys(this.uaw));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!bt.isNullOrNil(this.DBL))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(k.b.ys(this.DBL));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!bt.isNullOrNil(this.DBM))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(k.b.ys(this.DBM));
      paramStringBuilder.append("</shareString>");
    }
    if (!bt.isNullOrNil(this.DBN))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(k.b.ys(this.DBN));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!bt.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(k.b.ys(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!bt.isNullOrNil(this.lox))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(k.b.ys(this.lox));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!bt.isNullOrNil(this.DBO))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(k.b.ys(this.DBO));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!bt.isNullOrNil(this.DBP))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(k.b.ys(this.DBP));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!bt.isNullOrNil(this.DBQ))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(k.b.ys(this.DBQ));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!bt.isNullOrNil(this.DBR))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(k.b.ys(this.DBR));
      paramStringBuilder.append("</tagList>");
    }
    if (this.DBS >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.DBS);
      paramStringBuilder.append("</channelId>");
    }
    if (!bt.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(k.b.ys(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!bt.isNullOrNil(this.DBT))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(k.b.ys(this.DBT));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(117706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(117707);
    this.DBG = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.DBH = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.DBI = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.DBJ = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.DBK = bt.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.qeQ = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.qeR = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.uaw = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.DBL = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.DBM = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.DBN = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.lox = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.DBO = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.DBP = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.DBQ = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.DBR = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.DBS = bt.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.DBT = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(117707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ae
 * JD-Core Version:    0.7.0.1
 */