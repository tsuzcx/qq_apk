package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.f;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class ab
  extends f
{
  public String lHq;
  public String lHr;
  public String puE;
  public String rrm;
  public String source;
  public String thumbUrl;
  public String uJi;
  public String uJj;
  public String uJk;
  public String uJl;
  public long uJm;
  public String uJn;
  public String uJo;
  public String uJp;
  public String uJq;
  public String uJr;
  public String uJs;
  public String uJt;
  public long uJu;
  public String uJv;
  
  public final void a(Map<String, String> paramMap, j.b paramb)
  {
    AppMethodBeat.i(124150);
    this.uJi = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.uJj = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.uJk = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.uJl = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.uJm = bo.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.lHq = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.lHr = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.rrm = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.uJn = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.uJo = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.uJp = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.puE = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.uJq = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.uJr = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.uJs = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.uJt = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.uJu = bo.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.uJv = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(124150);
  }
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(124149);
    paramStringBuilder.append("<websearch>");
    if (!bo.isNullOrNil(this.uJi))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(j.b.mZ(this.uJi));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!bo.isNullOrNil(this.uJj))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(j.b.mZ(this.uJj));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bo.isNullOrNil(this.uJj))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(j.b.mZ(this.uJj));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!bo.isNullOrNil(this.uJk))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(j.b.mZ(this.uJk));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!bo.isNullOrNil(this.uJl))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(j.b.mZ(this.uJl));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.uJm >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.uJm);
      paramStringBuilder.append("</rec_category>");
    }
    if (!bo.isNullOrNil(this.lHq))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(j.b.mZ(this.lHq));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!bo.isNullOrNil(this.lHr))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(j.b.mZ(this.lHr));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!bo.isNullOrNil(this.rrm))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(j.b.mZ(this.rrm));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!bo.isNullOrNil(this.uJn))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(j.b.mZ(this.uJn));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!bo.isNullOrNil(this.uJo))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(j.b.mZ(this.uJo));
      paramStringBuilder.append("</shareString>");
    }
    if (!bo.isNullOrNil(this.uJp))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(j.b.mZ(this.uJp));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!bo.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(j.b.mZ(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!bo.isNullOrNil(this.puE))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(j.b.mZ(this.puE));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!bo.isNullOrNil(this.uJq))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(j.b.mZ(this.uJq));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!bo.isNullOrNil(this.uJr))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(j.b.mZ(this.uJr));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!bo.isNullOrNil(this.uJs))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(j.b.mZ(this.uJs));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!bo.isNullOrNil(this.uJt))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(j.b.mZ(this.uJt));
      paramStringBuilder.append("</tagList>");
    }
    if (this.uJu >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.uJu);
      paramStringBuilder.append("</channelId>");
    }
    if (!bo.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(j.b.mZ(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!bo.isNullOrNil(this.uJv))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(j.b.mZ(this.uJv));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(124149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ab
 * JD-Core Version:    0.7.0.1
 */