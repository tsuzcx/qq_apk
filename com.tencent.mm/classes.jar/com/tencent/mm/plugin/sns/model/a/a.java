package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.az;

public final class a
{
  public String bIW = "";
  public String bUi = "";
  public e omO = null;
  public String omV = "";
  public String omW = "";
  public String opV = "";
  public String opZ = "";
  public awd oqa;
  public boolean ouH = false;
  public boolean ouI = false;
  public int ouJ = 0;
  public az ouK;
  public float ouL = 0.0F;
  public String url = "";
  
  public a(String paramString)
  {
    this.bUi = paramString;
  }
  
  public final String bEq()
  {
    if (this.ouJ == 4) {
      return i.p(this.oqa);
    }
    if (this.ouJ == 6) {
      return i.q(this.oqa);
    }
    if (this.ouH) {
      return i.n(this.oqa);
    }
    return i.m(this.oqa);
  }
  
  public final String getPath()
  {
    if (!bk.bl(this.omV)) {
      return this.omV;
    }
    if (bk.bl(this.opV)) {
      init();
    }
    return this.opV;
  }
  
  public final boolean init()
  {
    this.opV = an.eJ(af.getAccSnsPath(), this.bUi);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.a
 * JD-Core Version:    0.7.0.1
 */