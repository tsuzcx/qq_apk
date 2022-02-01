package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class o
  extends l
{
  int clickCount = 0;
  protected d.a zEb;
  
  public o(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    paramContext = dWZ();
    paramViewGroup = bt.nullAsNil(paramContext.dFy);
    int i = paramContext.zAN;
    this.zEb = new d.a(paramViewGroup, paramContext.dnh, i, bt.aRf(paramContext.ktn), paramx.subType, bt.nullAsNil(paramContext.getViewId()), bt.nullAsNil(paramContext.dWr()));
  }
  
  public final void a(x paramx, ae paramae)
  {
    if ((paramae == null) || (paramx == null) || (this.zEb == null)) {}
    for (;;)
    {
      return;
      String str = bt.nullAsNil(paramae.dFy);
      int i = paramae.zAN;
      int j = paramae.dnh;
      long l = bt.aRf(paramae.ktn);
      int k = paramx.subType;
      paramx = bt.nullAsNil(paramae.getViewId());
      paramae = bt.nullAsNil(paramae.dWr());
      d.a locala = this.zEb;
      try
      {
        locala.zDp.h("uxinfo", str);
        locala.zDp.R("scene", j);
        locala.zDp.R("originScene", i);
        locala.zDp.u("canvasId", l);
        locala.zDp.R("type", 21);
        locala.zDp.R("subType", k);
        locala.zDp.R("action", 1);
        if (!bt.V(new String[] { paramx, paramae }))
        {
          locala.zDp.h("viewid", paramx);
          locala.zDp.h("commInfo", paramae);
          return;
        }
      }
      catch (Exception paramx)
      {
        ad.e("NetSceneAdLadingPageClick", "updateRetInfo exp=" + paramx.toString());
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
      ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  protected final void dWF()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
  
  protected final void dXd()
  {
    this.clickCount += 1;
  }
  
  protected final void dXe()
  {
    Object localObject = this.zEb;
    try
    {
      localObject = ((d.a)localObject).dbO();
      AdLandingPagesProxy.getInstance().onAdLandingPageClick("13387", (String)localObject);
      ad.i("NetSceneAdLadingPageClick", "report, channel=" + "13387" + ", content=" + (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      ad.e("NetSceneAdLadingPageClick", "report exp=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */