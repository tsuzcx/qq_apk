package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class ai
{
  public long QLA;
  public String QLB;
  public Map<String, String> QLC;
  public int QLu;
  public boolean QLv;
  public String QLw;
  public boolean QLx;
  public String QLy;
  public String QLz;
  public String adExtInfo;
  public String aid;
  public int bizId;
  public String hQX;
  public String pId;
  public String qTb;
  public String rzx;
  public int source;
  public String uin;
  public String uxInfo;
  public String viewId;
  
  public ai()
  {
    AppMethodBeat.i(96323);
    this.QLx = false;
    this.QLA = 0L;
    this.QLB = "";
    this.pId = "";
    this.QLC = new HashMap();
    AppMethodBeat.o(96323);
  }
  
  public final String aZs(String paramString)
  {
    AppMethodBeat.i(96324);
    paramString = (String)this.QLC.get(paramString);
    AppMethodBeat.o(96324);
    return paramString;
  }
  
  public final String getSnsId()
  {
    if (this.hQX == null) {
      return "";
    }
    return this.hQX;
  }
  
  public final String getViewId()
  {
    AppMethodBeat.i(306853);
    if (Util.isNullOrNil(this.viewId))
    {
      AppMethodBeat.o(306853);
      return "";
    }
    String str = this.viewId;
    AppMethodBeat.o(306853);
    return str;
  }
  
  public final String hiC()
  {
    AppMethodBeat.i(306843);
    if (a.ajx(this.source))
    {
      if (!TextUtils.isEmpty(this.QLw)) {
        break label53;
      }
      Log.e("AdLandingPageData", "getUpdatedUxInfo is empty");
      a.gN(this.QLB, 10);
    }
    for (;;)
    {
      String str = this.QLw;
      AppMethodBeat.o(306843);
      return str;
      label53:
      a.gN(this.QLB, 9);
    }
  }
  
  public final String hiD()
  {
    AppMethodBeat.i(306856);
    if (Util.isNullOrNil(this.QLz))
    {
      AppMethodBeat.o(306856);
      return "";
    }
    String str = this.QLz;
    AppMethodBeat.o(306856);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai
 * JD-Core Version:    0.7.0.1
 */