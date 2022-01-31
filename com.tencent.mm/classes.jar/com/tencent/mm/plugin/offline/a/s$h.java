package com.tencent.mm.plugin.offline.a;

import java.util.Map;

public final class s$h
{
  public String cdl;
  public String cdm;
  public String cdn;
  public String cdo;
  public String cdp;
  public boolean mLR;
  
  public s$h(Map<String, String> paramMap)
  {
    Object localObject;
    this.cdl = ((String)localObject.get(".sysmsg.paymsg.guide_flag"));
    this.cdm = ((String)localObject.get(".sysmsg.paymsg.guide_wording"));
    this.cdn = ((String)localObject.get(".sysmsg.paymsg.left_button_wording"));
    this.cdo = ((String)localObject.get(".sysmsg.paymsg.right_button_wording"));
    this.cdp = ((String)localObject.get(".sysmsg.paymsg.upload_credit_url"));
    if ("1".equals(localObject.get(".sysmsg.paymsg.guide_block"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mLR = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.a.s.h
 * JD-Core Version:    0.7.0.1
 */