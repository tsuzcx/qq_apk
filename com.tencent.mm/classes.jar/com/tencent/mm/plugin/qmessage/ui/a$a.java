package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class a$a
{
  private String NiA = "";
  private String NiB = "";
  private String Niz = "";
  private String city = "";
  private String country = "";
  private String oDI = "";
  private String province = "";
  
  private a$a(a parama) {}
  
  public final void aSk(String paramString)
  {
    AppMethodBeat.i(27738);
    if (Util.nullAsNil(paramString).length() <= 0)
    {
      Log.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
      AppMethodBeat.o(27738);
      return;
    }
    paramString = XmlParser.parseXml(paramString, "extinfo", null);
    if (paramString != null)
    {
      this.Niz = ((String)paramString.get(".extinfo.sex"));
      this.NiA = ((String)paramString.get(".extinfo.age"));
      this.NiB = ((String)paramString.get(".extinfo.bd"));
      this.country = ((String)paramString.get(".extinfo.country"));
      this.province = ((String)paramString.get(".extinfo.province"));
      this.city = ((String)paramString.get(".extinfo.city"));
    }
    if ((this.Niz != null) && (this.Niz.equals("1"))) {}
    for (this.Niz = a.a(this.Niy).getString(R.l.sex_male);; this.Niz = a.a(this.Niy).getString(R.l.sex_female))
    {
      if (this.country != null) {
        this.oDI = (this.oDI + this.country + " ");
      }
      if (this.province != null) {
        this.oDI = (this.oDI + this.province + " ");
      }
      if (this.city != null) {
        this.oDI += this.city;
      }
      AppMethodBeat.o(27738);
      return;
    }
  }
  
  public final String gDL()
  {
    if (this.Niz == null) {
      return "";
    }
    return this.Niz;
  }
  
  public final String gDM()
  {
    if (this.NiA == null) {
      return "";
    }
    return this.NiA;
  }
  
  public final String gDN()
  {
    if (this.oDI == null) {
      return "";
    }
    return this.oDI;
  }
  
  public final String gDO()
  {
    if (this.NiB == null) {
      return "";
    }
    return this.NiB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a.a
 * JD-Core Version:    0.7.0.1
 */