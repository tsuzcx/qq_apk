package com.tencent.mm.plugin.sns.ad.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.landingpage.component.comp.AdLandingHBCardComponent;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
{
  private HashMap<String, a> POG;
  public int POH;
  private SnsAdNativeLandingPagesUI POJ;
  private g POK;
  private AdLandingHBCardComponent POL;
  
  public a(SnsAdNativeLandingPagesUI paramSnsAdNativeLandingPagesUI, AdLandingHBCardComponent paramAdLandingHBCardComponent, g paramg)
  {
    AppMethodBeat.i(310000);
    this.POG = new HashMap();
    this.POH = 0;
    this.POJ = paramSnsAdNativeLandingPagesUI;
    this.POL = paramAdLandingHBCardComponent;
    this.POK = paramg;
    AppMethodBeat.o(310000);
  }
  
  private static String bz(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(310007);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (String str = "3";; str = "")
    {
      str = str + paramInt;
      AppMethodBeat.o(310007);
      return str;
    }
  }
  
  public final void bA(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(310014);
    String str = bz(paramInt, paramBoolean);
    a locala2 = (a)this.POG.get(str);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      locala1.POM = paramBoolean;
      locala1.subType = paramInt;
      locala1.POQ = this.POK.POQ;
      this.POG.put(str, locala1);
    }
    locala1.PON += 1;
    this.POH += 1;
    AppMethodBeat.o(310014);
  }
  
  public final JSONObject bB(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(310033);
    Object localObject = bz(paramInt, paramBoolean);
    localObject = (a)this.POG.get(localObject);
    if (localObject != null)
    {
      localObject = ((a)localObject).cqc();
      AppMethodBeat.o(310033);
      return localObject;
    }
    AppMethodBeat.o(310033);
    return null;
  }
  
  public final void n(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(310025);
    Object localObject3 = bz(paramInt1, paramBoolean);
    Object localObject2 = (a)this.POG.get(localObject3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new a();
      ((a)localObject1).POM = paramBoolean;
      ((a)localObject1).subType = paramInt1;
      ((a)localObject1).POQ = this.POK.POQ;
      this.POG.put(localObject3, localObject1);
    }
    if (paramInt2 != 3) {
      ((a)localObject1).POO += 1;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.POJ.hjn();
        localObject2 = ((ai)localObject1).QLy;
        localObject3 = ((ai)localObject1).uxInfo;
        paramInt1 = ((ai)localObject1).source;
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("snsid", Util.nullAsNil((String)localObject2));
        ((JSONObject)localObject1).put("uxinfo", Util.nullAsNil((String)localObject3));
        ((JSONObject)localObject1).put("scene", paramInt1);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("btnType", paramInt2);
        ((JSONObject)localObject2).put("twistCardId", this.POL.PQZ);
        localObject3 = this.POL.haD();
        if (localObject3 != null) {
          ((JSONObject)localObject2).put("hbCard", localObject3);
        }
        ((JSONObject)localObject1).put("extInfo", localObject2);
        m.lU("canvas_hb_card_btn_click", ((JSONObject)localObject1).toString());
        AppMethodBeat.o(310025);
        return;
      }
      catch (Exception localException)
      {
        Log.e("HBCardStatistics", "reportShakeActionResult, exp=" + localException.toString());
        AppMethodBeat.o(310025);
      }
      ((a)localObject1).POP += 1;
    }
  }
  
  public final class a
  {
    boolean POM;
    int PON;
    int POO;
    int POP;
    String POQ;
    int subType;
    
    public a() {}
    
    public final JSONObject cqc()
    {
      AppMethodBeat.i(309995);
      try
      {
        if (this.PON > 0)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("subType", this.subType);
          if (this.POM) {}
          for (int i = 1;; i = 0)
          {
            localJSONObject.put("isDoubleCard", i);
            if (this.PON > 0) {
              localJSONObject.put("expCnt", this.PON);
            }
            if (this.POO > 0) {
              localJSONObject.put("btnClkCnt", this.POO);
            }
            if (this.POP > 0) {
              localJSONObject.put("linkClkCnt", this.POP);
            }
            if (this.subType != 1) {
              localJSONObject.put("giveCardId", Util.nullAsNil(this.POQ));
            }
            AppMethodBeat.o(309995);
            return localJSONObject;
          }
        }
        return null;
      }
      catch (Exception localException)
      {
        Log.e("HBCardStatistics", "toJsonObject exp=" + localException.toString());
        AppMethodBeat.o(309995);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a.a
 * JD-Core Version:    0.7.0.1
 */