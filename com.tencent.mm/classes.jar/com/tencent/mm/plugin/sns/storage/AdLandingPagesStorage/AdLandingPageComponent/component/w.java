package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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

public final class w
  extends a
{
  private ImageView bNu;
  ProgressBar frw;
  private int gHR;
  private int gHS;
  boolean oCT;
  boolean oFx = true;
  private WindowManager oHI;
  
  public w(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
  }
  
  public final boolean K(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      y.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
      return false;
    }
    if (this.bNu == null)
    {
      y.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
      return false;
    }
    if (paramBitmap.getWidth() == 0)
    {
      y.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
      return false;
    }
    this.bNu.setImageBitmap(paramBitmap);
    this.frw.setVisibility(8);
    return true;
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
      y.printErrStackTrace("AdLandingPagePureImageComponet", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  public final View bFf()
  {
    this.bNu = ((ImageView)this.contentView.findViewById(i.f.sns_ad_native_landing_pages_items_pure_image_img));
    this.frw = ((ProgressBar)this.contentView.findViewById(i.f.progressbar));
    return this.contentView;
  }
  
  protected final void bFj()
  {
    if ((this.contentView == null) || (this.bNu == null) || (this.frw == null)) {}
    while ((p)this.oFE == null) {
      return;
    }
    if (this.oHI == null)
    {
      this.oHI = ((WindowManager)this.context.getSystemService("window"));
      this.gHR = this.oHI.getDefaultDisplay().getWidth();
      this.gHS = this.oHI.getDefaultDisplay().getHeight();
    }
    String str = ((p)this.oFE).oCV;
    Object localObject = ((p)this.oFE).oCW;
    float f1 = ((p)this.oFE).height;
    float f2 = ((p)this.oFE).width;
    this.oCT = ((p)this.oFE).oCT;
    if ((f1 != 0.0F) && (f2 != 0.0F) && (!this.oCT)) {
      this.bNu.setLayoutParams(new RelativeLayout.LayoutParams((int)f2, (int)f1));
    }
    for (;;)
    {
      if ((localObject != null) && (((String)localObject).length() > 0)) {}
      try
      {
        this.bNu.setBackgroundColor(Color.parseColor((String)localObject));
        label208:
        if ((str == null) || (str.length() <= 0))
        {
          y.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
          return;
          if ((this.oCT) && (f1 != 0.0F) && (f2 != 0.0F))
          {
            this.bNu.setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
            continue;
          }
          this.bNu.setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
          continue;
        }
        localObject = h.eV("adId", str);
        if ((localObject != null) && (K((Bitmap)localObject)))
        {
          y.i("AdLandingPagePureImageComponet", "loaded cached image with  " + str);
          this.oFx = true;
          return;
        }
        this.oFx = false;
        startLoading();
        h.a(str, ((p)this.oFE).oDh, new w.1(this));
        return;
      }
      catch (Exception localException)
      {
        break label208;
      }
    }
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_pure_image;
  }
  
  public final void startLoading()
  {
    this.frw.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */