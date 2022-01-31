package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class a$a
{
  private String city = "";
  private String country = "";
  private String fBq = "";
  private String pHZ = "";
  private String pIa = "";
  private String pIb = "";
  private String province = "";
  
  private a$a(a parama) {}
  
  public final String cdu()
  {
    if (this.pHZ == null) {
      return "";
    }
    return this.pHZ;
  }
  
  public final String cdv()
  {
    if (this.pIa == null) {
      return "";
    }
    return this.pIa;
  }
  
  public final String cdw()
  {
    if (this.fBq == null) {
      return "";
    }
    return this.fBq;
  }
  
  public final String cdx()
  {
    if (this.pIb == null) {
      return "";
    }
    return this.pIb;
  }
  
  public final void parse(String paramString)
  {
    AppMethodBeat.i(24098);
    if (bo.nullAsNil(paramString).length() <= 0)
    {
      ab.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
      AppMethodBeat.o(24098);
      return;
    }
    paramString = br.F(paramString, "extinfo");
    if (paramString != null)
    {
      this.pHZ = ((String)paramString.get(".extinfo.sex"));
      this.pIa = ((String)paramString.get(".extinfo.age"));
      this.pIb = ((String)paramString.get(".extinfo.bd"));
      this.country = ((String)paramString.get(".extinfo.country"));
      this.province = ((String)paramString.get(".extinfo.province"));
      this.city = ((String)paramString.get(".extinfo.city"));
    }
    if ((this.pHZ != null) && (this.pHZ.equals("1"))) {}
    for (this.pHZ = this.pHY.context.getString(2131303551);; this.pHZ = this.pHY.context.getString(2131303550))
    {
      if (this.country != null) {
        this.fBq = (this.fBq + this.country + " ");
      }
      if (this.province != null) {
        this.fBq = (this.fBq + this.province + " ");
      }
      if (this.city != null) {
        this.fBq += this.city;
      }
      AppMethodBeat.o(24098);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a.a
 * JD-Core Version:    0.7.0.1
 */