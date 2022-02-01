package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class p
  extends m
{
  int clickCount = 0;
  protected d.a zVg;
  
  public p(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
    paramContext = eaD();
    paramViewGroup = bu.nullAsNil(paramContext.dGD);
    int i = paramContext.zRN;
    this.zVg = new d.a(paramViewGroup, paramContext.doj, i, bu.aSC(paramContext.kwD), paramy.subType, bu.nullAsNil(paramContext.getViewId()), bu.nullAsNil(paramContext.dZT()));
  }
  
  public final void a(y paramy, af paramaf)
  {
    if ((paramaf == null) || (paramy == null) || (this.zVg == null)) {}
    for (;;)
    {
      return;
      String str = bu.nullAsNil(paramaf.dGD);
      int i = paramaf.zRN;
      int j = paramaf.doj;
      long l = bu.aSC(paramaf.kwD);
      int k = paramy.subType;
      paramy = bu.nullAsNil(paramaf.getViewId());
      paramaf = bu.nullAsNil(paramaf.dZT());
      d.a locala = this.zVg;
      try
      {
        locala.zUr.h("uxinfo", str);
        locala.zUr.S("scene", j);
        locala.zUr.S("originScene", i);
        locala.zUr.u("canvasId", l);
        locala.zUr.S("type", 21);
        locala.zUr.S("subType", k);
        locala.zUr.S("action", 1);
        if (!bu.V(new String[] { paramy, paramaf }))
        {
          locala.zUr.h("viewid", paramy);
          locala.zUr.h("commInfo", paramaf);
          return;
        }
      }
      catch (Exception paramy)
      {
        ae.e("NetSceneAdLadingPageClick", "updateRetInfo exp=" + paramy.toString());
      }
    }
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    if (!super.aQ(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ae.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  protected final void eaH()
  {
    this.clickCount += 1;
  }
  
  protected final void eah()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
  
  protected void eaq()
  {
    this.zVg.report("13387");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */