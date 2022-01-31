package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class j
  extends h
{
  int clickCount = 0;
  
  public j(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    if (!super.aq(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  protected final void cqQ()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
  
  protected final void crh()
  {
    this.clickCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */