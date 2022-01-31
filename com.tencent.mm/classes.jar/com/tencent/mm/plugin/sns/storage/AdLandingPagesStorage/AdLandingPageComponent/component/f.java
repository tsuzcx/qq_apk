package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends i
{
  ImageView bNu;
  ProgressBar frw;
  boolean oFx = true;
  
  public f(Context paramContext, ViewGroup paramViewGroup)
  {
    this(paramContext, paramViewGroup, (byte)0);
  }
  
  private f(Context paramContext, ViewGroup paramViewGroup, byte paramByte)
  {
    super(paramContext, null, paramViewGroup);
  }
  
  public final boolean ah(JSONObject paramJSONObject)
  {
    if (!super.ah(paramJSONObject)) {
      return false;
    }
    try
    {
      if (!this.oFx)
      {
        String str = ad.bB(((p)this.oFE).oCV);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("AdLandingImageComp", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  public final View bFf()
  {
    View localView = this.contentView;
    this.bNu = ((ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_items_pure_image_img));
    this.frw = ((ProgressBar)localView.findViewById(i.f.progressbar));
    return localView;
  }
  
  protected final void bFj()
  {
    if ((this.contentView == null) || (this.bNu == null) || (this.frw == null)) {}
    while ((p)this.oFE == null) {
      return;
    }
    float f1 = ((p)this.oFE).oDi;
    float f2 = ((p)this.oFE).oDj;
    float f3 = ((p)this.oFE).oDk;
    float f4 = ((p)this.oFE).oDl;
    String str = ((p)this.oFE).oCV;
    float f5 = ((p)this.oFE).height;
    float f6 = ((p)this.oFE).width;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.bNu.getLayoutParams();
    localLayoutParams.width = ((int)f6);
    localLayoutParams.height = ((int)f5);
    this.bNu.setLayoutParams(localLayoutParams);
    this.oFx = false;
    startLoading();
    h.a(str, ((p)this.oFE).oDh, new f.1(this));
    this.contentView.setPadding((int)f3, (int)f1, (int)f4, (int)f2);
    jn(false);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_image;
  }
  
  public final void startLoading()
  {
    this.frw.setVisibility(0);
  }
  
  public final void stopLoading()
  {
    this.frw.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */