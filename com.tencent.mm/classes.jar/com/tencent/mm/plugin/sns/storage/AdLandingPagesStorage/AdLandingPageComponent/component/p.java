package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class p
  extends m
{
  protected g.a KqQ;
  int clickCount = 0;
  
  public p(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
    Object localObject = fRp();
    paramContext = Util.nullAsNil(((ai)localObject).uxInfo);
    int i = ((ai)localObject).Knp;
    int j = ((ai)localObject).source;
    long l = Util.safeParseLong(((ai)localObject).owd);
    int k = paramaa.subType;
    paramViewGroup = Util.nullAsNil(((ai)localObject).getViewId());
    localObject = Util.nullAsNil(((ai)localObject).fQF());
    String str = Util.nullAsNil(paramaa.KmB);
    paramaa = Util.nullAsNil(paramaa.KmP);
    this.KqQ = new g.a(paramContext, j, i, l, k, paramViewGroup, (String)localObject);
    kP(str, paramaa);
  }
  
  private void kP(String paramString1, String paramString2)
  {
    if (this.KqQ != null)
    {
      this.KqQ.kQ("cid", paramString1);
      this.KqQ.kQ("jumpExtInfo", paramString2);
    }
  }
  
  public final void a(aa paramaa, ai paramai)
  {
    if ((paramai == null) || (paramaa == null) || (this.KqQ == null)) {
      return;
    }
    String str1 = Util.nullAsNil(paramai.uxInfo);
    int i = paramai.Knp;
    int j = paramai.source;
    long l = Util.safeParseLong(paramai.owd);
    int k = paramaa.subType;
    String str2 = Util.nullAsNil(paramai.getViewId());
    String str3 = Util.nullAsNil(paramai.fQF());
    paramai = Util.nullAsNil(paramaa.KmB);
    paramaa = Util.nullAsNil(paramaa.KmP);
    g.a locala = this.KqQ;
    try
    {
      locala.Kqa.g("uxinfo", str1);
      locala.Kqa.al("scene", j);
      locala.Kqa.al("originScene", i);
      locala.Kqa.s("canvasId", l);
      locala.Kqa.al("type", 21);
      locala.Kqa.al("subType", k);
      locala.Kqa.al("action", 1);
      if (!Util.isNullOrNil(new String[] { str2, str3 }))
      {
        locala.Kqa.g("viewid", str2);
        locala.Kqa.g("commInfo", str3);
      }
      kP(paramai, paramaa);
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
  
  public final boolean by(JSONObject paramJSONObject)
  {
    if (!super.by(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      aa localaa = this.KqB;
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
  
  protected final void fKi()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
  
  protected void fRc()
  {
    this.KqQ.report("13387");
  }
  
  protected final void fRt()
  {
    this.clickCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */