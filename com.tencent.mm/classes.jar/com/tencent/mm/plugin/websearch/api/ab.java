package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;

public class ab
  extends com.tencent.mm.ae.d
{
  public String aWf;
  public String jxR;
  public String jxS;
  public String mSy;
  public String oBT;
  public String qTY;
  public String qTZ;
  public String qUa;
  public String qUb;
  public long qUc;
  public String qUd;
  public String qUe;
  public String qUf;
  public String qUg;
  public String qUh;
  public String qUi;
  public String qUj;
  public long qUk;
  public String thumbUrl;
  
  public final void a(StringBuilder paramStringBuilder, g.a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append("<websearch>");
    if (!bk.bl(this.qTY))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(g.a.gq(this.qTY));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!bk.bl(this.qTZ))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(g.a.gq(this.qTZ));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bk.bl(this.qTZ))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(g.a.gq(this.qTZ));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bk.bl(this.qUa))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(g.a.gq(this.qUa));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!bk.bl(this.qUb))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(g.a.gq(this.qUb));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.qUc >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.qUc);
      paramStringBuilder.append("</rec_category>");
    }
    if (!bk.bl(this.jxR))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(g.a.gq(this.jxR));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!bk.bl(this.jxS))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(g.a.gq(this.jxS));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!bk.bl(this.oBT))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(g.a.gq(this.oBT));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!bk.bl(this.qUd))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(g.a.gq(this.qUd));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!bk.bl(this.qUe))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(g.a.gq(this.qUe));
      paramStringBuilder.append("</shareString>");
    }
    if (!bk.bl(this.qUf))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(g.a.gq(this.qUf));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!bk.bl(this.aWf))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(g.a.gq(this.aWf));
      paramStringBuilder.append("</source>");
    }
    if (!bk.bl(this.mSy))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(g.a.gq(this.mSy));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!bk.bl(this.qUg))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(g.a.gq(this.qUg));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!bk.bl(this.qUh))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(g.a.gq(this.qUh));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!bk.bl(this.qUi))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(g.a.gq(this.qUi));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!bk.bl(this.qUj))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(g.a.gq(this.qUj));
      paramStringBuilder.append("</tagList>");
    }
    if (this.qUk >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.qUk);
      paramStringBuilder.append("</channelId>");
    }
    if (!bk.bl(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(this.thumbUrl);
      paramStringBuilder.append("</thumbUrl>");
    }
    paramStringBuilder.append("</websearch>");
  }
  
  public final void a(Map<String, String> paramMap, g.a parama)
  {
    this.qTY = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.qTZ = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.qUa = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.qUb = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.qUc = bk.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.jxR = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.jxS = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.oBT = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.qUd = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.qUe = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.qUf = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.aWf = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.mSy = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.qUg = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.qUh = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.qUi = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.qUj = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.qUk = bk.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ab
 * JD-Core Version:    0.7.0.1
 */