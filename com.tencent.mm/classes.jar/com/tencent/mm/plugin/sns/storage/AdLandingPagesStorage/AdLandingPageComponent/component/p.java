package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class p
  extends m
{
  protected g.a Edn;
  int clickCount = 0;
  
  public p(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    Object localObject = fds();
    paramContext = Util.nullAsNil(((ah)localObject).uxInfo);
    int i = ((ah)localObject).DZU;
    int j = ((ah)localObject).source;
    long l = Util.safeParseLong(((ah)localObject).lAN);
    int k = paramz.subType;
    paramViewGroup = Util.nullAsNil(((ah)localObject).getViewId());
    localObject = Util.nullAsNil(((ah)localObject).fcN());
    String str = Util.nullAsNil(paramz.DZi);
    paramz = Util.nullAsNil(paramz.DZv);
    this.Edn = new g.a(paramContext, j, i, l, k, paramViewGroup, (String)localObject);
    ku(str, paramz);
  }
  
  private void ku(String paramString1, String paramString2)
  {
    if (this.Edn != null)
    {
      this.Edn.kv("cid", paramString1);
      this.Edn.kv("jumpExtInfo", paramString2);
    }
  }
  
  public final void a(z paramz, ah paramah)
  {
    if ((paramah == null) || (paramz == null) || (this.Edn == null)) {
      return;
    }
    String str1 = Util.nullAsNil(paramah.uxInfo);
    int i = paramah.DZU;
    int j = paramah.source;
    long l = Util.safeParseLong(paramah.lAN);
    int k = paramz.subType;
    String str2 = Util.nullAsNil(paramah.getViewId());
    String str3 = Util.nullAsNil(paramah.fcN());
    paramah = Util.nullAsNil(paramz.DZi);
    paramz = Util.nullAsNil(paramz.DZv);
    g.a locala = this.Edn;
    try
    {
      locala.Ecy.h("uxinfo", str1);
      locala.Ecy.U("scene", j);
      locala.Ecy.U("originScene", i);
      locala.Ecy.v("canvasId", l);
      locala.Ecy.U("type", 21);
      locala.Ecy.U("subType", k);
      locala.Ecy.U("action", 1);
      if (!Util.isNullOrNil(new String[] { str2, str3 }))
      {
        locala.Ecy.h("viewid", str2);
        locala.Ecy.h("commInfo", str3);
      }
      ku(paramah, paramz);
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
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    if (!super.bp(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("clickCount", this.clickCount);
      z localz = this.EcX;
      if (localz != null) {}
      for (int i = localz.subType;; i = 0)
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
  
  protected final void eWX()
  {
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
  }
  
  protected void fdf()
  {
    this.Edn.report("13387");
  }
  
  protected final void fdw()
  {
    this.clickCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */