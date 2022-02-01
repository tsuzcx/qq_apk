package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class ab
  extends f
{
  public String AGA;
  public String AGB;
  public String AGC;
  public String AGD;
  public long AGE;
  public String AGF;
  public String AGs;
  public String AGt;
  public String AGu;
  public String AGv;
  public long AGw;
  public String AGx;
  public String AGy;
  public String AGz;
  public String kqB;
  public String oYa;
  public String oYb;
  public String rUO;
  public String source;
  public String thumbUrl;
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(117707);
    this.AGs = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.AGt = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.AGu = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.AGv = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.AGw = bt.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.oYa = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.oYb = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.rUO = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.AGx = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.AGy = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.AGz = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.kqB = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.AGA = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.AGB = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.AGC = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.AGD = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.AGE = bt.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.AGF = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(117707);
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117706);
    paramStringBuilder.append("<websearch>");
    if (!bt.isNullOrNil(this.AGs))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(k.b.ry(this.AGs));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!bt.isNullOrNil(this.AGt))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.ry(this.AGt));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bt.isNullOrNil(this.AGt))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.ry(this.AGt));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bt.isNullOrNil(this.AGu))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(k.b.ry(this.AGu));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!bt.isNullOrNil(this.AGv))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(k.b.ry(this.AGv));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.AGw >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.AGw);
      paramStringBuilder.append("</rec_category>");
    }
    if (!bt.isNullOrNil(this.oYa))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(k.b.ry(this.oYa));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!bt.isNullOrNil(this.oYb))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(k.b.ry(this.oYb));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!bt.isNullOrNil(this.rUO))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(k.b.ry(this.rUO));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!bt.isNullOrNil(this.AGx))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(k.b.ry(this.AGx));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!bt.isNullOrNil(this.AGy))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(k.b.ry(this.AGy));
      paramStringBuilder.append("</shareString>");
    }
    if (!bt.isNullOrNil(this.AGz))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(k.b.ry(this.AGz));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!bt.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(k.b.ry(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!bt.isNullOrNil(this.kqB))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(k.b.ry(this.kqB));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!bt.isNullOrNil(this.AGA))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(k.b.ry(this.AGA));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!bt.isNullOrNil(this.AGB))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(k.b.ry(this.AGB));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!bt.isNullOrNil(this.AGC))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(k.b.ry(this.AGC));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!bt.isNullOrNil(this.AGD))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(k.b.ry(this.AGD));
      paramStringBuilder.append("</tagList>");
    }
    if (this.AGE >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.AGE);
      paramStringBuilder.append("</channelId>");
    }
    if (!bt.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(k.b.ry(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!bt.isNullOrNil(this.AGF))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(k.b.ry(this.AGF));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(117706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ab
 * JD-Core Version:    0.7.0.1
 */