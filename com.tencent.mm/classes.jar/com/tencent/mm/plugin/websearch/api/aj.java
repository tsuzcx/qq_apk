package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class aj
  extends f
{
  public String IEA;
  public String IEB;
  public long IEC;
  public String IED;
  public String IEE;
  public String IEF;
  public String IEG;
  public String IEH;
  public String IEI;
  public String IEJ;
  public long IEK;
  public String IEL;
  public String IEy;
  public String IEz;
  public String eby;
  public String msN;
  public String rCq;
  public String source;
  public String thumbUrl;
  public String xDQ;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117706);
    paramStringBuilder.append("<websearch>");
    if (!Util.isNullOrNil(this.IEy))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(k.b.HE(this.IEy));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!Util.isNullOrNil(this.IEz))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.HE(this.IEz));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!Util.isNullOrNil(this.IEz))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.HE(this.IEz));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!Util.isNullOrNil(this.IEA))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(k.b.HE(this.IEA));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!Util.isNullOrNil(this.IEB))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(k.b.HE(this.IEB));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.IEC >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.IEC);
      paramStringBuilder.append("</rec_category>");
    }
    if (!Util.isNullOrNil(this.rCq))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(k.b.HE(this.rCq));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!Util.isNullOrNil(this.msN))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(k.b.HE(this.msN));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!Util.isNullOrNil(this.xDQ))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(k.b.HE(this.xDQ));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!Util.isNullOrNil(this.IED))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(k.b.HE(this.IED));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!Util.isNullOrNil(this.IEE))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(k.b.HE(this.IEE));
      paramStringBuilder.append("</shareString>");
    }
    if (!Util.isNullOrNil(this.IEF))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(k.b.HE(this.IEF));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!Util.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(k.b.HE(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!Util.isNullOrNil(this.eby))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(k.b.HE(this.eby));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!Util.isNullOrNil(this.IEG))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(k.b.HE(this.IEG));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!Util.isNullOrNil(this.IEH))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(k.b.HE(this.IEH));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!Util.isNullOrNil(this.IEI))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(k.b.HE(this.IEI));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!Util.isNullOrNil(this.IEJ))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(k.b.HE(this.IEJ));
      paramStringBuilder.append("</tagList>");
    }
    if (this.IEK >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.IEK);
      paramStringBuilder.append("</channelId>");
    }
    if (!Util.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(k.b.HE(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!Util.isNullOrNil(this.IEL))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(k.b.HE(this.IEL));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(117706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(117707);
    this.IEy = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.IEz = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.IEA = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.IEB = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.IEC = Util.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.rCq = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.msN = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.xDQ = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.IED = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.IEE = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.IEF = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.eby = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.IEG = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.IEH = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.IEI = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.IEJ = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.IEK = Util.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.IEL = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(117707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.aj
 * JD-Core Version:    0.7.0.1
 */