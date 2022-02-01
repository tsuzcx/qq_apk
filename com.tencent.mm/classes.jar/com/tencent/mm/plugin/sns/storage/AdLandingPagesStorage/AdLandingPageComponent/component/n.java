package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class n
  extends k
{
  int clickCount = 0;
  protected d.a xas;
  
  public n(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad localad = dwi();
    paramViewGroup = bt.nullAsNil(localad.dvK);
    int i = localad.wXj;
    int j = localad.dep;
    long l = bt.aGi(localad.jyu);
    int k = paramx.subType;
    if (bt.isNullOrNil(localad.dAM))
    {
      paramContext = "";
      paramx = bt.nullAsNil(paramContext);
      if (!bt.isNullOrNil(localad.wXo)) {
        break label125;
      }
    }
    label125:
    for (paramContext = "";; paramContext = localad.wXo)
    {
      this.xas = new d.a(paramViewGroup, j, i, l, k, paramx, bt.nullAsNil(paramContext));
      return;
      paramContext = localad.dAM;
      break;
    }
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    if (!super.aG(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  protected final void dvT()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.xab.paddingLeft, (int)this.xab.paddingTop, (int)this.xab.paddingRight, (int)this.xab.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
  
  protected final void dwm()
  {
    this.clickCount += 1;
  }
  
  protected final void dwn()
  {
    Object localObject = this.xas;
    try
    {
      localObject = ((d.a)localObject).cFx();
      AdLandingPagesProxy.getInstance().onAdLandingPageClick("13387", (String)localObject);
      com.tencent.mm.sdk.platformtools.ad.i("NetSceneAdLadingPageClick", "report, channel=" + "13387" + ", content=" + (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("NetSceneAdLadingPageClick", "report exp=" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */