package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class q
  extends n
{
  protected h.a QPl;
  int clickCount = 0;
  
  public q(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
    Object localObject = hjn();
    paramContext = Util.nullAsNil(((ai)localObject).uxInfo);
    int i = ((ai)localObject).QLu;
    int j = ((ai)localObject).source;
    long l = Util.safeParseLong(((ai)localObject).rzx);
    int k = paramaa.subType;
    paramViewGroup = Util.nullAsNil(((ai)localObject).getViewId());
    localObject = Util.nullAsNil(((ai)localObject).hiD());
    String str = Util.nullAsNil(paramaa.QKG);
    paramaa = Util.nullAsNil(paramaa.QKT);
    this.QPl = new h.a(paramContext, j, i, l, k, paramViewGroup, (String)localObject);
    mw(str, paramaa);
  }
  
  private void mw(String paramString1, String paramString2)
  {
    if (this.QPl != null)
    {
      this.QPl.mx("cid", paramString1);
      this.QPl.mx("jumpExtInfo", paramString2);
    }
  }
  
  public final void a(aa paramaa, ai paramai)
  {
    if ((paramai == null) || (paramaa == null) || (this.QPl == null)) {
      return;
    }
    String str1 = Util.nullAsNil(paramai.uxInfo);
    int i = paramai.QLu;
    int j = paramai.source;
    long l = Util.safeParseLong(paramai.rzx);
    int k = paramaa.subType;
    String str2 = Util.nullAsNil(paramai.getViewId());
    String str3 = Util.nullAsNil(paramai.hiD());
    paramai = Util.nullAsNil(paramaa.QKG);
    paramaa = Util.nullAsNil(paramaa.QKT);
    h.a locala = this.QPl;
    try
    {
      locala.QOh.m("uxinfo", str1);
      locala.QOh.au("scene", j);
      locala.QOh.au("originScene", i);
      locala.QOh.t("canvasId", l);
      locala.QOh.au("type", 21);
      locala.QOh.au("subType", k);
      locala.QOh.au("action", 1);
      if (!Util.isNullOrNil(new String[] { str2, str3 }))
      {
        locala.QOh.m("viewid", str2);
        locala.QOh.m("commInfo", str3);
      }
      mw(paramai, paramaa);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("NetSceneAdLadingPageClick", "updateRetInfo exp=" + localException.toString());
      }
    }
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    if (!super.bP(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      aa localaa = this.QOV;
      if (localaa != null) {}
      for (int i = localaa.subType;; i = 0)
      {
        paramJSONObject.putOpt("subType", Integer.valueOf(i));
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", paramJSONObject, "", new Object[0]);
    }
  }
  
  protected final void hal()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
  
  protected void hja()
  {
    this.QPl.report("13387");
  }
  
  protected final void hjr()
  {
    this.clickCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q
 * JD-Core Version:    0.7.0.1
 */