package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class aj
  extends f
{
  public String CHR;
  public String PyQ;
  public String PyR;
  public String PyS;
  public String PyT;
  public long PyU;
  public String PyV;
  public String PyW;
  public String PyX;
  public String PyY;
  public String PyZ;
  public String Pza;
  public String Pzb;
  public long Pzc;
  public String Pzd;
  public String fVx;
  public String pqW;
  public String source;
  public String thumbUrl;
  public String vhY;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117706);
    paramStringBuilder.append("<websearch>");
    if (!Util.isNullOrNil(this.PyQ))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(k.b.OR(this.PyQ));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!Util.isNullOrNil(this.PyR))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.OR(this.PyR));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!Util.isNullOrNil(this.PyR))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.OR(this.PyR));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!Util.isNullOrNil(this.PyS))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(k.b.OR(this.PyS));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!Util.isNullOrNil(this.PyT))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(k.b.OR(this.PyT));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.PyU >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.PyU);
      paramStringBuilder.append("</rec_category>");
    }
    if (!Util.isNullOrNil(this.vhY))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(k.b.OR(this.vhY));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!Util.isNullOrNil(this.pqW))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(k.b.OR(this.pqW));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!Util.isNullOrNil(this.CHR))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(k.b.OR(this.CHR));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!Util.isNullOrNil(this.PyV))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(k.b.OR(this.PyV));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!Util.isNullOrNil(this.PyW))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(k.b.OR(this.PyW));
      paramStringBuilder.append("</shareString>");
    }
    if (!Util.isNullOrNil(this.PyX))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(k.b.OR(this.PyX));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!Util.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(k.b.OR(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!Util.isNullOrNil(this.fVx))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(k.b.OR(this.fVx));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!Util.isNullOrNil(this.PyY))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(k.b.OR(this.PyY));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!Util.isNullOrNil(this.PyZ))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(k.b.OR(this.PyZ));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!Util.isNullOrNil(this.Pza))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(k.b.OR(this.Pza));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!Util.isNullOrNil(this.Pzb))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(k.b.OR(this.Pzb));
      paramStringBuilder.append("</tagList>");
    }
    if (this.Pzc >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.Pzc);
      paramStringBuilder.append("</channelId>");
    }
    if (!Util.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(k.b.OR(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!Util.isNullOrNil(this.Pzd))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(k.b.OR(this.Pzd));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(117706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(117707);
    this.PyQ = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.PyR = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.PyS = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.PyT = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.PyU = Util.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.vhY = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.pqW = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.CHR = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.PyV = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.PyW = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.PyX = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.fVx = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.PyY = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.PyZ = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.Pza = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.Pzb = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.Pzc = Util.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.Pzd = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(117707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj
 * JD-Core Version:    0.7.0.1
 */