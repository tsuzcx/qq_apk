package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class ak
  extends f
{
  public String ICb;
  public String WoZ;
  public String Wpa;
  public String Wpb;
  public String Wpc;
  public long Wpd;
  public String Wpe;
  public String Wpf;
  public String Wpg;
  public String Wph;
  public String Wpi;
  public String Wpj;
  public String Wpk;
  public long Wpl;
  public String Wpm;
  public String ibx;
  public String source;
  public String svG;
  public String thumbUrl;
  public String ytZ;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117706);
    paramStringBuilder.append("<websearch>");
    if (!Util.isNullOrNil(this.WoZ))
    {
      paramStringBuilder.append("<relevant_vid>");
      paramStringBuilder.append(k.b.Hg(this.WoZ));
      paramStringBuilder.append("</relevant_vid>");
    }
    if (!Util.isNullOrNil(this.Wpa))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.Hg(this.Wpa));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!Util.isNullOrNil(this.Wpa))
    {
      paramStringBuilder.append("<relevant_expand>");
      paramStringBuilder.append(k.b.Hg(this.Wpa));
      paramStringBuilder.append("</relevant_expand>");
    }
    if (!Util.isNullOrNil(this.Wpb))
    {
      paramStringBuilder.append("<relevant_pre_searchid>");
      paramStringBuilder.append(k.b.Hg(this.Wpb));
      paramStringBuilder.append("</relevant_pre_searchid>");
    }
    if (!Util.isNullOrNil(this.Wpc))
    {
      paramStringBuilder.append("<relevant_shared_openid>");
      paramStringBuilder.append(k.b.Hg(this.Wpc));
      paramStringBuilder.append("</relevant_shared_openid>");
    }
    if (this.Wpd >= 0L)
    {
      paramStringBuilder.append("<rec_category>");
      paramStringBuilder.append(this.Wpd);
      paramStringBuilder.append("</rec_category>");
    }
    if (!Util.isNullOrNil(this.ytZ))
    {
      paramStringBuilder.append("<shareUrl>");
      paramStringBuilder.append(k.b.Hg(this.ytZ));
      paramStringBuilder.append("</shareUrl>");
    }
    if (!Util.isNullOrNil(this.svG))
    {
      paramStringBuilder.append("<shareTitle>");
      paramStringBuilder.append(k.b.Hg(this.svG));
      paramStringBuilder.append("</shareTitle>");
    }
    if (!Util.isNullOrNil(this.ICb))
    {
      paramStringBuilder.append("<shareDesc>");
      paramStringBuilder.append(k.b.Hg(this.ICb));
      paramStringBuilder.append("</shareDesc>");
    }
    if (!Util.isNullOrNil(this.Wpe))
    {
      paramStringBuilder.append("<shareImgUrl>");
      paramStringBuilder.append(k.b.Hg(this.Wpe));
      paramStringBuilder.append("</shareImgUrl>");
    }
    if (!Util.isNullOrNil(this.Wpf))
    {
      paramStringBuilder.append("<shareString>");
      paramStringBuilder.append(k.b.Hg(this.Wpf));
      paramStringBuilder.append("</shareString>");
    }
    if (!Util.isNullOrNil(this.Wpg))
    {
      paramStringBuilder.append("<shareStringUrl>");
      paramStringBuilder.append(k.b.Hg(this.Wpg));
      paramStringBuilder.append("</shareStringUrl>");
    }
    if (!Util.isNullOrNil(this.source))
    {
      paramStringBuilder.append("<source>");
      paramStringBuilder.append(k.b.Hg(this.source));
      paramStringBuilder.append("</source>");
    }
    if (!Util.isNullOrNil(this.ibx))
    {
      paramStringBuilder.append("<sourceUrl>");
      paramStringBuilder.append(k.b.Hg(this.ibx));
      paramStringBuilder.append("</sourceUrl>");
    }
    if (!Util.isNullOrNil(this.Wph))
    {
      paramStringBuilder.append("<strPlayCount>");
      paramStringBuilder.append(k.b.Hg(this.Wph));
      paramStringBuilder.append("</strPlayCount>");
    }
    if (!Util.isNullOrNil(this.Wpi))
    {
      paramStringBuilder.append("<titleUrl>");
      paramStringBuilder.append(k.b.Hg(this.Wpi));
      paramStringBuilder.append("</titleUrl>");
    }
    if (!Util.isNullOrNil(this.Wpj))
    {
      paramStringBuilder.append("<extReqParams>");
      paramStringBuilder.append(k.b.Hg(this.Wpj));
      paramStringBuilder.append("</extReqParams>");
    }
    if (!Util.isNullOrNil(this.Wpk))
    {
      paramStringBuilder.append("<tagList>");
      paramStringBuilder.append(k.b.Hg(this.Wpk));
      paramStringBuilder.append("</tagList>");
    }
    if (this.Wpl >= 0L)
    {
      paramStringBuilder.append("<channelId>");
      paramStringBuilder.append(this.Wpl);
      paramStringBuilder.append("</channelId>");
    }
    if (!Util.isNullOrNil(this.thumbUrl))
    {
      paramStringBuilder.append("<thumbUrl>");
      paramStringBuilder.append(k.b.Hg(this.thumbUrl));
      paramStringBuilder.append("</thumbUrl>");
    }
    if (!Util.isNullOrNil(this.Wpm))
    {
      paramStringBuilder.append("<shareTag>");
      paramStringBuilder.append(k.b.Hg(this.Wpm));
      paramStringBuilder.append("</shareTag>");
    }
    paramStringBuilder.append("</websearch>");
    AppMethodBeat.o(117706);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(117707);
    this.WoZ = ((String)paramMap.get(".msg.appmsg.websearch.relevant_vid"));
    this.Wpa = ((String)paramMap.get(".msg.appmsg.websearch.relevant_expand"));
    this.Wpb = ((String)paramMap.get(".msg.appmsg.websearch.relevant_pre_searchid"));
    this.Wpc = ((String)paramMap.get(".msg.appmsg.websearch.relevant_shared_openid"));
    this.Wpd = Util.getInt((String)paramMap.get(".msg.appmsg.websearch.rec_category"), -1);
    this.ytZ = ((String)paramMap.get(".msg.appmsg.websearch.shareUrl"));
    this.svG = ((String)paramMap.get(".msg.appmsg.websearch.shareTitle"));
    this.ICb = ((String)paramMap.get(".msg.appmsg.websearch.shareDesc"));
    this.Wpe = ((String)paramMap.get(".msg.appmsg.websearch.shareImgUrl"));
    this.Wpf = ((String)paramMap.get(".msg.appmsg.websearch.shareString"));
    this.Wpg = ((String)paramMap.get(".msg.appmsg.websearch.shareStringUrl"));
    this.source = ((String)paramMap.get(".msg.appmsg.websearch.source"));
    this.ibx = ((String)paramMap.get(".msg.appmsg.websearch.sourceUrl"));
    this.Wph = ((String)paramMap.get(".msg.appmsg.websearch.strPlayCount"));
    this.Wpi = ((String)paramMap.get(".msg.appmsg.websearch.titleUrl"));
    this.Wpj = ((String)paramMap.get(".msg.appmsg.websearch.extReqParams"));
    this.Wpk = ((String)paramMap.get(".msg.appmsg.websearch.tagList"));
    this.Wpl = Util.getLong((String)paramMap.get(".msg.appmsg.websearch.channelId"), -1L);
    this.thumbUrl = ((String)paramMap.get(".msg.appmsg.websearch.thumbUrl"));
    this.Wpm = ((String)paramMap.get(".msg.appmsg.websearch.shareTag"));
    AppMethodBeat.o(117707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ak
 * JD-Core Version:    0.7.0.1
 */