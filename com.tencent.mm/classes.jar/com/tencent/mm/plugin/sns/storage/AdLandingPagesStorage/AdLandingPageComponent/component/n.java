package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class n
  extends k
{
  int clickCount = 0;
  protected d.a ynh;
  
  public n(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    ae localae = dKH();
    paramViewGroup = bs.nullAsNil(localae.dtx);
    int i = localae.yjY;
    int j = localae.dbL;
    long l = bs.aLz(localae.jYR);
    int k = paramx.subType;
    if (bs.isNullOrNil(localae.dyy))
    {
      paramContext = "";
      paramx = bs.nullAsNil(paramContext);
      if (!bs.isNullOrNil(localae.ykc)) {
        break label125;
      }
    }
    label125:
    for (paramContext = "";; paramContext = localae.ykc)
    {
      this.ynh = new d.a(paramViewGroup, j, i, l, k, paramx, bs.nullAsNil(paramContext));
      return;
      paramContext = localae.dyy;
      break;
    }
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    if (!super.aH(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ac.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  protected final void dKL()
  {
    this.clickCount += 1;
  }
  
  protected final void dKM()
  {
    Object localObject = this.ynh;
    try
    {
      localObject = ((d.a)localObject).cSH();
      AdLandingPagesProxy.getInstance().onAdLandingPageClick("13387", (String)localObject);
      ac.i("NetSceneAdLadingPageClick", "report, channel=" + "13387" + ", content=" + (String)localObject);
      return;
    }
    catch (Exception localException)
    {
      ac.e("NetSceneAdLadingPageClick", "report exp=" + localException.toString());
    }
  }
  
  protected final void dKs()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */